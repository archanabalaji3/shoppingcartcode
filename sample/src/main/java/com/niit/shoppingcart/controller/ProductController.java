package com.niit.shoppingcart.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Product;
import com.niit.util.FileUtil;

public class ProductController {
	@Autowired
	private Product product; 

	@Autowired
	private ProductDAO productDAO; 
	
	@Autowired
	private CategoryDAO categoryDAO; 
	
	@Autowired
	private SupplierDAO supplierDAO; 
	
	@Autowired
	HttpSession httpSession;

	@Autowired
	FileUtil fileUtil;
	
	Logger log= LoggerFactory.getLogger(ProductController.class);

	@PostMapping("/product/save/")
	public ModelAndView saveProduct(@RequestParam("product_id") String id,@RequestParam("name") String name,
								@RequestParam("price") String price,@RequestParam("category_id") String categoryID, @RequestParam("supplier_id") String supplierID, 
								@RequestParam("file") MultipartFile file, HttpServletRequest req)
	{
		log.debug("Start of the product save method");
		
		ModelAndView mv= new ModelAndView("redirect:/manageproducts"); 
		product.setProduct_id(id);
		product.setName(name);
		price= price.replace(", ", "");
		product.setPrice(Integer.parseInt(price));
		product.setCat_id(categoryID);
		product.setSup_id(supplierID);
		
		if (productDAO.save(product))
		{
			mv.addObject("productsuccess", "Product saved successfully");
			product.setProduct_id("");
			product.setName("");
			product.setPrice(0);
			
			
			List<Product> products = productDAO.list();
			httpSession.setAttribute("products", products);
			
			if (FileUtil.fileCopyNIO(file, id+".png",req)){
				System.out.println("Product image successfully uploaded");
				mv.addObject("uploadmsg", "Product image successfully uploaded");
			}
			else{
				mv.addObject("uploadmsg", "Product image could not be uploaded");
			}
		}
		
		else{
			mv.addObject("producterror", "Couldn't save");
		}
		
		log.debug("End of the product save method");
		return mv;
	}
    
	@PutMapping("/product/update/")
	public ModelAndView updateProduct(@ModelAttribute Product product)
	{
		log.debug("Start of the product update method");
		
		ModelAndView mv= new ModelAndView("Home");
		if (productDAO.update(product)==true){
			mv.addObject("productsuccess", "Successfully updated");
		}
		else{
			mv.addObject("producterror", "Failed to update");
		}

		log.debug("End of the product update method");
		return mv;
	}
		
	@GetMapping("/allproducts")
	public ModelAndView getAllProducts()
	{
		log.debug("Start of the get all products method");
		
		ModelAndView mv= new ModelAndView("Home");
		List<Product> products= productDAO.list();
		mv.addObject("products", products);

		log.debug("End of the get all products method");
		return mv;
	}
	
	@GetMapping("/product/delete") 
	public ModelAndView deleteProduct(@RequestParam("id") String id) 
	{
		log.debug("Start of the product delete method");
		
		ModelAndView mv= new ModelAndView("redirect:/manageproducts"); 
		if (productDAO.delete(id)==true){
			mv.addObject("productsuccess", "Deleted");
		}
		else{
			mv.addObject("producterror", "Not deleted");
		}

		log.debug("End of the product delete method");
		return mv;
	}
	
	@GetMapping("/product/edit")
	public ModelAndView editProduct(@RequestParam String id){
		
		log.debug("Start of the product edit method");
		
		ModelAndView mv= new ModelAndView("redirect:/manageproducts");
		product= productDAO.get(id);
		httpSession.setAttribute("selectedProduct", product); 

		log.debug("End of the product edit method");
		return mv;
	}
	
	@GetMapping("/product/get/{product_id}")
	public ModelAndView getSelectedProduct(@PathVariable("product_id") String product_id, RedirectAttributes redirectAttributes)
	{
		log.debug("Start of the get product by id method");
		
		ModelAndView mv= new ModelAndView("redirect:/");
		redirectAttributes.addFlashAttribute("isUserSelectedProduct", true);
		redirectAttributes.addFlashAttribute("selectedProductImage","resources/images/ShoppingCartImages/"+product_id+".png");
		redirectAttributes.addFlashAttribute("selectedProduct", productDAO.get(product_id));
		redirectAttributes.addFlashAttribute("productID", product_id);

		log.debug("End of the get product by id method");
		return mv;
	}
}