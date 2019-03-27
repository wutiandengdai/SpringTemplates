package com.wutian.spring.spring_rent.controller;

import java.util.ArrayList;
import java.util.List;

import com.wutian.spring.spring_rent.entity.Room;
import com.wutian.spring.spring_rent.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RoomController{
    @Autowired
    private RoomRepository repository;

    @RequestMapping(value="/rooms", method=RequestMethod.GET)
    List<Room> findAll(@RequestParam(required=false) String number){
        List<Room> results = new ArrayList<Room>();
        if(number == null){
            Iterable<Room> rooms = this.repository.findAll();
            rooms.forEach(room -> results.add(room));
        }else{
            Room room = this.repository.findByNumber(number);
            if( room!= null){
                results.add(room);
            }
        }
        return results;
    }

}