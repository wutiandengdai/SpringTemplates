package com.wutian.spring.spring_rent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.wutian.spring.spring_rent.data.RoomRent;
import com.wutian.spring.spring_rent.entity.Guest;
import com.wutian.spring.spring_rent.entity.Rent;
import com.wutian.spring.spring_rent.entity.Room;
import com.wutian.spring.spring_rent.repository.GuestRepository;
import com.wutian.spring.spring_rent.repository.RentRepository;
import com.wutian.spring.spring_rent.repository.RoomRepository;

@Service
public class RentService {
    private final DateFormat DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private RoomRepository roomRepository;
    private GuestRepository guestRepository;
    private RentRepository rentRepository;

    @Autowired
    public RentService(RoomRepository roomRepository, GuestRepository guestRepository, RentRepository rentRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.rentRepository = rentRepository;
    }

    public List<RoomRent> getRoomRentForDate(String dateString){
        Date date = parseDateString(dateString);
        Iterable<Room> rooms = this.roomRepository.findAll();
        Map<Long, RoomRent> roomRentMap = new HashMap<>();
        rooms.forEach(room->{
            RoomRent roomRent = new RoomRent();
            roomRent.setRoomId(room.getId());
            roomRent.setRoomName(room.getName());
            roomRent.setRoomNumber(room.getNumber());
            roomRentMap.put(room.getId(), roomRent);
        });
        Iterable<Rent> rents = this.rentRepository.findByDate(new java.sql.Date(date.getTime()));
        if(null!=rents){
            rents.forEach(rent -> {
                // Guest guest = this.guestRepository.findOne(rent.getGuestId());
                // Option 2
                Optional<Guest> guestResponse = this.guestRepository.findById(rent.getGuestId());
                if(guestResponse.isPresent()){
                    Guest guest = guestResponse.get();
                // if(null!=guest){
                    RoomRent roomRent = roomRentMap.get(rent.getId());
                    roomRent.setDate(date);
                    roomRent.setFirstName(guest.getFirstName());
                    roomRent.setLastName(guest.getLastName());
                    roomRent.setGuestId(guest.getId());
                }
            });
        }
        List<RoomRent> roomRents = new ArrayList<>();
        for(Long roomId:roomRentMap.keySet()){
            roomRents.add(roomRentMap.get(roomId));
        }
        return roomRents;
    }


    private Date parseDateString(String dateString){
        Date date = new Date();
        if(dateString != null){
            try{
                date = DATEFORMAT.parse(dateString);
            }catch(ParseException ex){
                date = new Date();
            }
        }
        return date;
    }
}
