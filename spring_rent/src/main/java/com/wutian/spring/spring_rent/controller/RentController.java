package com.wutian.spring.spring_rent.controller;

import com.wutian.spring.spring_rent.service.RentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/rent")
public class RentController {

    @Autowired
    private RentService rentService;

    @RequestMapping(method=RequestMethod.GET)
    public String getRent(@RequestParam(value="date", required=false) String dateString, Model model){
        model.addAttribute("roomRents", rentService.getRoomRentForDate(dateString));

        //static path name. The file needs to be under templates!
        return "rent";
    }
}