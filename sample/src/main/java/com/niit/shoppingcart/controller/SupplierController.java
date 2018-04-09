package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;

@Controller
public class SupplierController {
	@Autowired
	private SupplierDAO supplierDAO; 
	
	@Autowired
	private Supplier supplier; 
	
	@Autowired 
	HttpSession httpSession;
	
	Logger log= LoggerFactory.getLogger(SupplierController.class);
	
	@PostMapping("/supplier/save/")
	public ModelAndView saveSupplier(@RequestParam("supplier_id") String id, @RequestParam("name") String name, 
									 @RequestParam("address") String address)
	{
		log.debug("Start of the supplier save method");
		
		ModelAndView mv= new ModelAndView("redirect:/managesuppliers");
		supplier.setSupplier_id(id);
		supplier.setName(name);
		supplier.setAddress(address);
		
		if (supplierDAO.save(supplier)){
			mv.addObject("suppliersuccess", "Supplier saved successfully");
			supplier.setSupplier_id("");
			supplier.setName("");
			supplier.setAddress("");
			
			List<Supplier> suppliers = supplierDAO.list();
			httpSession.setAttribute("suppliers", suppliers);	
		}
		else{
			mv.addObject("supplierfailure", "Couldn't save");
		}

		log.debug("End of the supplier save method");
		return mv;
	}
	
	@PutMapping("/supplier/update/")
	public ModelAndView updateSupplier(@ModelAttribute Supplier supplier)
	{
		log.debug("Start of the product update method");
		
		ModelAndView mv= new ModelAndView("Home");
		if (supplierDAO.update(supplier)==true){
			mv.addObject("suppliersuccess", "Successfully updated");
		}
		else{
			mv.addObject("supplierfailure", "Failed to update");
		}

		log.debug("End of the supplier update method");
		return mv; 
	}

	@GetMapping("/Allsuppliers")
	public ModelAndView  getAllSuppliers()
	{
		log.debug("Start of the get all suppliers method");
		
		ModelAndView mv= new ModelAndView("Home");
		List<Supplier> suppliers= supplierDAO.list();
		mv.addObject("suppliers", suppliers);

		log.debug("End of the get all suppliers method");
		return mv;
	}
	
	@GetMapping("/supplier/delete")
	public ModelAndView deleteSupplier(@RequestParam("id") String id)
	{
		log.debug("Start of the supplier delete method");
		
		ModelAndView mv= new ModelAndView("redirect:/managesuppliers");
		if (supplierDAO.delete(id)==true){
			mv.addObject("suppliersuccess", "Deleted");
		}
		else{
			mv.addObject("supplierfailure", "Not deleted");
		}

		log.debug("End of the supplier delete method");
		return mv;
	}
	
	@GetMapping("/supplier/edit")
	public ModelAndView editsupplier(@RequestParam String id){
		
		log.debug("Start of the supplier edit method");
		
		ModelAndView mv= new ModelAndView("redirect:/managesuppliers");
		supplier= supplierDAO.get(id);
		httpSession.setAttribute("supplier", supplier);

		log.debug("End of the supplier save method");
		return mv;
	}	
	
//	@GetMapping("/supplier/get/{supplier_id}")
//	public ModelAndView getSupplier(@RequestParam("supplier_id") String id)
//	{
//		log.debug("Start of the get supplier by id method");
//	
//		supplier= supplierDAO.get(id);
//		ModelAndView mv= new ModelAndView("Home");
//
//		log.debug("End of the get all suppliers method");
//		return mv.addObject("supplier", supplier);
//	}

}


