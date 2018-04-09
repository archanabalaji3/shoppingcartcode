/*package com.niit.shoppingcart.controller;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;

@Controller
public class NewProductController {
	@Autowired
	ProductDAO productDAO;
	@Autowired
	CategoryDAO catdao;
	@Autowired
	SupplierDAO supdao;
	
	
	@RequestMapping("/newaddproduct")
	public String getAddProductPage(Model m, Product prdt)
	{
		List<Supplier> suplist=supdao.list();
		List<Category> catlist=catdao.list();
		m.addAttribute(catlist);
		m.addAttribute(suplist);
		Product p=new Product();
		m.addAttribute(prdt);
		return "newproduct";
	}
	
	@RequestMapping(value="/AddProduct",method=RequestMethod.POST)
	public String addProduct(@ModelAttribute("prdt")Product prdt, HttpServletRequest request,RedirectAttributes attributes)
	{
	
		productDAO.save(prdt);

		//copy absolute path of image folder from the drive and use in the below given format.

		String path="E:\\ARCHANA\\mavenshopping\\sample\\src\\main\\webapp\\resources\\images\\";
		path=path+String.valueOf(prdt.getId())+".jpg";
		File f=new File(path);
	
		MultipartFile filedet=prdt.getPimage();
		
		if(!filedet.isEmpty())
		{
			try
			{
			  byte[] bytes=filedet.getBytes();
			  System.out.println(bytes.length);
			  FileOutputStream fos=new FileOutputStream(f);
              			BufferedOutputStream bs=new BufferedOutputStream(fos);
              			bs.write(bytes);
              			bs.close();
             			 System.out.println("File Uploaded Successfully");
			}
			catch(Exception e)
			{
				System.out.println("Exception Arised"+e);
			}
		}
		else
		{
			System.out.println("File is Empty not Uploaded");
			
		}
		
		
		return "ViewProduct";
	}
}
*/