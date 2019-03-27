package com.wutian.spring.spring_rent.controller;

import java.util.List;

import com.wutian.spring.spring_rent.data.RoomRent;
import com.wutian.spring.spring_rent.service.RentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Returns a json body instead of template name
 */
@RestController
@RequestMapping(value = "/api", method = RequestMethod.GET)
class RentRestController {

    @Autowired
    private RentService rentService;

    @RequestMapping(method=RequestMethod.GET, value="/rent/{date}")
    public List<RoomRent> getRents(@PathVariable(value="date") String dateString){
        return rentService.getRoomRentForDate(dateString);
    }

}