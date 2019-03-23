package com.leiye;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserDashboardController {
	
	 @RequestMapping("/dashboard")
    public String getUser(@RequestParam(value="id", defaultValue="1") int id) {
        RestTemplate restTemplate = new RestTemplate();
        
      //调用其他Rest接口
        UserView user = restTemplate.getForObject("http://localhost:9001/user?id="+id, UserView.class);
        return "用户控制面板 <br>" +
                "欢迎 " + user.getForename() +" "+user.getSurname()+"<br>"+
                "您的当前得分 " +user.getPoints() + " ! 干得漂亮!<br>"+
                "<br>"+
                "<br>"+user.getOrganisation();
    }
}
