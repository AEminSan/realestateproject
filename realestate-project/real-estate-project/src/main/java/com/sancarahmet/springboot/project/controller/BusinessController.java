package com.sancarahmet.springboot.project.controller;

import com.sancarahmet.springboot.project.dao.BusinessDao;
import com.sancarahmet.springboot.project.dao.UserDao;
import com.sancarahmet.springboot.project.entity.Business;
import com.sancarahmet.springboot.project.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/business")
public class BusinessController {
    private BusinessDao businessDao;

    private UserDao userDao;




    public BusinessController(BusinessDao businessDao, UserDao userDao){
        this.businessDao = businessDao;
        this.userDao = userDao;
    }



    @GetMapping("/register")
    public String registerBusiness(Model theModel){
        Business theBusiness = new Business();

        theModel.addAttribute("business", theBusiness);

        return "business/register";

    }

    @PostMapping("/save")
    public String saveBusiness(@ModelAttribute("business") Business theBusiness){

        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String theUsername = loggedInUser.getName();

        User theUser = userDao.findByUserName(theUsername);

        theBusiness.setUser(theUser);
        theBusiness.setUserId(theUser.getId());

        businessDao.save(theBusiness);

        return "redirect:/";
    }

    @GetMapping("/show")
    public String show(Model theModel){
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String theUsername = loggedInUser.getName();

        User theUser = userDao.findByUserName(theUsername);

        theModel.addAttribute("business", businessDao.findByUserId(theUser.getId()));
        return "business/my-information";
    }

    @GetMapping("/contact")
    public String contact(@RequestParam("userId") int userId,  Model theModel){

        User theUser = userDao.findByUserId(userId);


        System.out.println(userId);

        theModel.addAttribute("business", businessDao.findByUserId(theUser.getId()));

        return "business/information";
    }





}
