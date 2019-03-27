package com.wutian.spring.spring_rent.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wutian.spring.spring_rent.data.RoomRent;
import com.wutian.spring.spring_rent.service.RentService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Test supported by spring-boot-starter-test
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(RentController.class)
public class RentControllerTest {

    @MockBean
    private RentService rentService;

    @Autowired
    private MockMvc mockMvc;

    private final DateFormat DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Test
    public void getRent() throws Exception {
        Date date = DATEFORMAT.parse("2017-01-01");
        List<RoomRent> mockRoomRentList = new ArrayList<>();
        RoomRent mockRoomRent = new RoomRent();
        mockRoomRent.setLastName("Test");
        mockRoomRent.setFirstName("JUnit");
        mockRoomRent.setDate(date);
        mockRoomRent.setGuestId(1);
        mockRoomRent.setRoomNumber("J1");
        mockRoomRent.setRoomId(100);
        mockRoomRent.setRoomName("JUnit Room");
        mockRoomRentList.add(mockRoomRent);

        given(rentService.getRoomRentForDate(DATEFORMAT.format(date))).willReturn(mockRoomRentList);
        mockMvc.perform(get("/rent?date=2017-01-01")).andExpect(status().isOk()).andExpect(content().string(containsString("Test JUnit")));
    }
}