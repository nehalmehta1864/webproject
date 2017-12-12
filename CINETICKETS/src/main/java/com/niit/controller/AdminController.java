/*package com.niit.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.*;
import com.niit.model.Category;
import com.niit.model.Productmodel;
import com.niit.model.Supplier;


@Controller
@RequestMapping("/admin")
public class AdminController

{

	@Autowired
	categorydao categoriesDao;

	@Autowired
	suppliermodeldao suppliersDao;

	@Autowired
	productmodeldao productDao;

	

	@RequestMapping("/editproductdetails")
	String goeditproductdetails() {
		return "editproductdetails";
	}



	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("catList", categoriesDao.getCategories());
	}

	
	  @RequestMapping("/addCategory") ModelAndView
	  addCategoryClick(@RequestParam("cid") int id, @RequestParam("cname")
	  String name) { Category category = new Category();
	  category.setCategoryId(id); category.setCategoryName(name);
	  categoriesDao.savecategory(category); return new
	  ModelAndView("categories"); }
	  
	  @RequestMapping("/addSupplier") ModelAndView
	  addSupplierClick(@RequestParam("sid") int id, @RequestParam("sname")
	  String name) { Supplier supplier = new Supplier();
	  supplier.setSupplierId(id); supplier.setSupplierName(name);
	  suppliersDao.savesupplier(supplier); return new
	  ModelAndView("categories"); }
	 

	
	  @RequestMapping("/addProduct") ModelAndView
	  addProductClick(@RequestParam("pid") int id, @RequestParam("pname")
	  String name,
	  
	  @RequestParam("pdescription") String description, @RequestParam("pprice")
	  String price,
	  
	  @RequestParam("pquantity") int quantity, @RequestParam("file")
	  MultipartFile file,
	  
	  @RequestParam("categoryitems") int cid, @RequestParam("supplieritems")
	  int sid, HttpServletRequest request) { Productmodel Productmodel = new
	  Productmodel(); Productmodel.setName(name); Productmodel.setId(id);
	  Productmodel.setDescription(description); Productmodel.setPrice(price);
	  Productmodel.setQuantity(quantity); //Productmodel.setImage(image);
	  Category cat = categoriesDao.getcategorybyid(cid);
	  Productmodel.setProdCategory(cat); Supplier sup =
	  suppliersDao.getsupplierbyid(sid); Productmodel.setProdSupplier(sup);
	 String filename = id + file.getOriginalFilename();
	 Productmodel.setpImage(filename);
	  productDao.saveProductmodel(Productmodel);
	  
	  String path =
	  request.getSession().getServletContext().getRealPath("/resources/");
	  
	  System.out.println(path + "" + filename);
	  
	  byte barr[]; try { barr = file.getBytes(); BufferedOutputStream bout =
	  new BufferedOutputStream(new FileOutputStream(path + filename));
	  bout.write(barr); bout.flush(); bout.close(); } catch (IOException e) {
	  e.printStackTrace(); } return new ModelAndView("categories"); }
	

	
	  @RequestMapping("/categorylist") ModelAndView gocategorylist() {
	  List<Category> categorylist = categoriesDao.getCategories(); ModelAndView
	  mv = new ModelAndView(); mv.addObject("catList", categorylist);
	  mv.setViewName("categorylist"); return mv; }
	  
	  @RequestMapping("/supplierlist") ModelAndView gosupplierlist() {
	  List<Supplier> supplierlist = suppliersDao.getSupplier();
	  System.out.println("Supplier List " + supplierlist.size()); ModelAndView
	  mv = new ModelAndView(); mv.addObject("supplierList", supplierlist);
	  mv.setViewName("supplierlist"); return mv; }
	 


	
	  @RequestMapping("/adminproductlist") ModelAndView goadminproductlist() {
	  ModelAndView mv = new ModelAndView(); mv.addObject("productList",
	  productDao.getproducts()); mv.setViewName("adminproductlist"); return mv;
	  }
	  
	  @RequestMapping(value = "/productDelete/{prodId}", method =
	  RequestMethod.GET) public String deleteProduct(@PathVariable("prodId")
	  int pid) { System.out.println("Product id" + pid);
	  productDao.delete(productDao.getProductDetail(pid)); return
	  "redirect:/adminproductlist"; }
	 

}
*/