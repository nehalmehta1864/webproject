package com.niit.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.cartmodeldao;
import com.niit.dao.categorydao;
import com.niit.dao.usermodeldao;
import com.niit.model.CartModel;
import com.niit.model.Usermodel;

@Controller
public class UserController {

	@Autowired
	usermodeldao userDao;
	@Autowired
	cartmodeldao cartDao;
	@Autowired
	categorydao categoriesDao;

	@RequestMapping("/notaccessible")
	public String notaccess() {
		return "noAccessPage";
	}
	
	
	
	@RequestMapping("/userLogged")
	public String userLogged()
	{
	return "redirect:/";
}

	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("catList", categoriesDao.getCategories());
	}

	@RequestMapping("/register")
	String goregister() {
		return "register";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	ModelAndView addUserClick(@RequestParam("name") String name, @RequestParam("age") int age,
			@RequestParam("mail") String u_mail, @RequestParam("passwd") String u_password,
			@RequestParam("phone") String phone, @RequestParam("address") String address) {

		Usermodel usermodel = new Usermodel();

		usermodel.setU_name(name);
		usermodel.setAge(age);
		usermodel.setU_mail(u_mail);
		usermodel.setU_password(u_password);
		usermodel.setPhone((phone));
		usermodel.setAddress(address);
		usermodel.setEnabled(true);
		usermodel.setRole("ROLE_USER");
		userDao.addUser(usermodel);
		return new ModelAndView("index");

	}

	@RequestMapping(value="/addCart",method = RequestMethod.POST)
	public ModelAndView goAddCart(HttpServletRequest request)
	{
		CartModel cartmodel = new CartModel();
		ModelAndView mv=new ModelAndView();
		try
		{
		
		int pid=Integer.parseInt(request.getParameter("cartpid"));
		double price=Double.parseDouble(request.getParameter("cartprice"));
		int qty=Integer.parseInt(request.getParameter("prodquantity"));
		String cartImage=request.getParameter("cartImage");
		String cartProdName=request.getParameter("cartProdName");
		cartmodel.setCartImage(cartImage);
		cartmodel.setPname(cartProdName);
		cartmodel.setProductId(pid);
		cartmodel.setPrice(price);
		cartmodel.setQuantity(qty);
		cartDao.addToCart(cartmodel);
		Principal principal = request.getUserPrincipal();
		String userId = principal.getName();
		CartModel exist = cartDao.getCartItem(pid, userId);

		
		
		
		if(exist==null)
		{
		CartModel cm=new CartModel();
		cm.setPrice(price);
		cm.setCartItemId(pid);
		cm.setQuantity(qty);
		cm.setCartImage(cartImage);
		cm.setPname(cartProdName);
		Usermodel c=userDao.getUserDetail(userId);
		cm.getCartUserDetails();
		cartDao.addToCart(cartmodel);
		
				
		}
		else
		{
			CartModel cm=new CartModel();
			cm.setCartItemId(exist.getCartItemId());
			cm.setPrice(price);
			cm.setCartItemId(pid);
			cm.setQuantity(qty);
			cm.setCartImage(cartImage);
			cm.setPname(cartProdName);
			Usermodel c = userDao.getUserDetail(userId);
			cm.setCartUserDetails(c);
			cartDao.updateCart(cm);
			List<CartModel> cartList=cartDao.getAll();
			ModelAndView mv1 = new ModelAndView("display");//productDetails
			mv1.addObject("cartlist",cartList);
			return mv1;
			
		}

			
		
		
		mv.addObject("cartDetails",cartDao.getCartById(userId));
		mv.setViewName("viewcart");
		return mv;
		}
		catch(NullPointerException ex)
		{
			mv.setViewName("userproductlist");
			return mv;
		}
	}

	@RequestMapping("/viewcart")
	public ModelAndView viewcart() {

		ModelAndView mv = new ModelAndView("viewcart");
		List<CartModel> cartList = cartDao.getAll();

		mv.addObject("cartlist", cartList);
		return mv;
	}

	@RequestMapping("/cart_delete")
	public ModelAndView editCart(HttpServletRequest request) {
		int cid = Integer.valueOf(request.getParameter("id"));
		CartModel c = cartDao.getId(cid);
		cartDao.deleteCart(c);

		ModelAndView mv = new ModelAndView("viewcart");
		List<CartModel> cartList = cartDao.getAll();

		mv.addObject("cartlist", cartList);
		return mv;
	}

	@RequestMapping("/customerDetails")
	public ModelAndView customer(HttpServletRequest request) {
		int tot = Integer.valueOf(request.getParameter("tot"));
		System.out.println(tot);
		ModelAndView mv = new ModelAndView("checkout");
		mv.addObject("tot", tot);
		return mv;
	}

	@RequestMapping("/invoice")
	public ModelAndView invoice(HttpServletRequest request) {
		String name = request.getParameter("name");
		String add = request.getParameter("add");
		String phone = request.getParameter("contact_no");
		String email = request.getParameter("email");
		String tot = request.getParameter("tot");
		Usermodel usermodel = new Usermodel();
		usermodel.setU_name(name);
		usermodel.setAddress(add);
		usermodel.setPhone(phone);
		usermodel.setU_mail(email);
		userDao.persist(usermodel);

		ModelAndView mv = new ModelAndView("invoice");
		mv.addObject("name", name);
		mv.addObject("add", add);
		mv.addObject("phone", phone);
		mv.addObject("email", email);
		mv.addObject("tot", tot);

		return mv;
	}

	@RequestMapping("/Confirm")
	public String confirm() {
		return "Confirm";
	}

}
