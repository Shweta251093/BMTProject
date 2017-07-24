package com.nttdata.pune.training.bookmytable.controller;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import com.nttdata.pune.training.bookmytable.model.beans.LoginBean;
import com.nttdata.pune.training.bookmytable.service.LoginOperationService;

@Controller
@SessionAttributes({"usernamevalue","superAdmin","adminvalue"})
public class LoginController {

	   @Autowired
	   LoginOperationService operationService;
      /*----------------------------------Get Method----------------------------------------------------*/
	   
	   @RequestMapping(value = {"/user","/"}, method = RequestMethod.GET)
	   public ModelAndView displayLogin(HttpServletRequest request,HttpServletResponse response) //populating bean properties instead of passing in constructor arguments.
	   {
	   ModelAndView model = new ModelAndView("login/user");
	   LoginBean loginBean = new LoginBean();
	   model.addObject("loginBean", loginBean);
	   return model;

	   }
	   
	   /*-------------------------------Post Method----------------------------------------------------*/
	   
	   @RequestMapping(value = "/user", method = RequestMethod.POST)
	   public ModelAndView executeLogin(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("loginBean") @Valid LoginBean loginBean,BindingResult result, Model model1)
	   {
       ModelAndView model = null;
	   try {
     
		/* -----------------------------List declaration------------------------------------------*/
		   
		List<LoginBean> listUser = operationService.validate(loginBean.getUsername(), loginBean.getPassword());   
		List<LoginBean> listAdmin = operationService.validateAdmin(loginBean.getUsername(), loginBean.getPassword());
		List<LoginBean> listTempAdmin = operationService.validateTemporaryAdmin(loginBean.getUsername(),loginBean.getPassword());
       
		
		/*---------------------------------------User View Redirect------------------------------------*/
		if ((!listUser.isEmpty())) {                                        //Returns true if this list contains no elements
		System.out.println("User Login Successful");
		for (LoginBean loginBean2 : listUser) 
		{
         String userNameValue = loginBean2.getUsername();
		request.getSession().setAttribute("usernamevalue",userNameValue);
		return new ModelAndView("redirect:userHome");
		}
		}
		
		/*---------------------------------------Admin View Redirect------------------------------------*/
		
		else
	    {
        if ((!listAdmin.isEmpty())) {                                        //Returns true if this list contains no elements
		System.out.println("User Login Successful");
        for (LoginBean loginBean2 : listAdmin)
        {
		String userNameValue = loginBean2.getUsername();
		request.getSession().setAttribute("usernamevalue",userNameValue);
		request.getSession().setAttribute("adminvalue",userNameValue);
		model = new ModelAndView("redirect:homeAdminView");
		return model;
		}
        }
        
        /*---------------------------------------Temporary Admin View Redirect------------------------------------*/
        
        else 
        {
        if ((!listTempAdmin.isEmpty())) {                                   //Returns true if this list contains no elements
		System.out.println("User Login Successful");
	    model = new ModelAndView("admins/temporaryAdmin");
		return model;
		}
        
        /*---------------------------------------Super Admin View Redirect------------------------------------*/
        
        else 
        {
		if (loginBean.getUsername().equalsIgnoreCase("SuperAdmin")&& loginBean.getPassword().equals("Superman"))  //Compares this String to another String
		{
		request.getSession().setAttribute("superAdmin","SuperAdmin");
		System.out.println("User Login Successful");
	    model = new ModelAndView("redirect:superAdmin");
		return model;
		}
		
		/*---------------------------------------Validation------------------------------------*/
		else 
		{
		model1.addAttribute("message","Invalid credentials!!");
		model = new ModelAndView("login/user");
		return model;
		}

		}
		}
		}
		} catch (Exception e) {
		e.printStackTrace();
		}

		return model;
	    }  
	   
	   /*--------------------------------- session Logout------------------------------------------*/
	   @RequestMapping("/logout")
	    public String logout(SessionStatus session) {
	    session.setComplete();
	         
	    return "login/logout";
	          
	          
	    }
	  
	    }

        