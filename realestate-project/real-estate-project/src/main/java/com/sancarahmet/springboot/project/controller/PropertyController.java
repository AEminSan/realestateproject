package com.sancarahmet.springboot.project.controller;

import com.sancarahmet.springboot.project.dao.BusinessDao;
import com.sancarahmet.springboot.project.dao.PropertyDao;
import com.sancarahmet.springboot.project.dao.UserDao;
import com.sancarahmet.springboot.project.entity.Business;
import com.sancarahmet.springboot.project.entity.Property;
import com.sancarahmet.springboot.project.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/properties")
public class PropertyController {

    private PropertyDao propertyDao;
    private BusinessDao businessDao;

    private UserDao userDao;

    public PropertyController(PropertyDao propertyDao, BusinessDao businessDao, UserDao userDao){
        this.propertyDao = propertyDao;
        this.businessDao = businessDao;
        this.userDao = userDao;
    }

    @GetMapping("/create-an-advert")
    public String createAnAd(Model theModel){
        Property theProperty = new Property();

        theModel.addAttribute("property" ,theProperty);

        return "property/add-property";
    }

    @PostMapping("/save")
    public String saveProperty(@ModelAttribute("property") Property theProperty){

        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String theUsername = loggedInUser.getName();

        User theUser = userDao.findByUserName(theUsername);
        System.out.println(theUser);

        Business theBusiness = businessDao.findByUserId(theUser.getId());
//        theProperty.setBusinessId(theBusiness.getId());

        System.out.println(theBusiness);
        theProperty.setBusiness(theBusiness);

        theProperty.setUserId(theUser.getId());

        theProperty.setBusiness(theBusiness);

        propertyDao.save(theProperty);


        return "redirect:/properties/list";
    }

    @GetMapping("/list")
    public String listProperties(Model theModel){

        List<Property> theProperties =  propertyDao.findAll();

        theModel.addAttribute("properties", theProperties);

        return "property/properties-list";
    }

    @GetMapping("/my-properties")
    public String listMyProperties(Model theModel){

        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String theUsername = loggedInUser.getName();

        User theUser = userDao.findByUserName(theUsername);

        List<Property> theProperties =  propertyDao.findByBusinessId(theUser.getId());

        theModel.addAttribute("properties", theProperties);

        return "property/my-properties-list";
    }

    @GetMapping("/list-by-search")
    public String listBySearch(@RequestParam(value = "type", required = false) String type,
                               @RequestParam(value = "number_of_rooms", required = false) int noOfRooms,
                               @RequestParam(value = "floor", required = false) int floor,
                               @RequestParam(value = "heating", required = false) String heating,
                               @RequestParam(value = "size", required = false) int size,
                               Model theModel){
        List<Property> theProperties =  propertyDao.findBySearch(type, noOfRooms, floor, heating, size);

        theModel.addAttribute("properties", theProperties);

        return "property/properties-by-search";

    }

}
