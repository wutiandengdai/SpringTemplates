package com.leiye;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello 测试
 * @author ucs_yelei
 *
 */
@RestController
public class HelloController {

	@RequestMapping("/hello")
	@ResponseBody
	public String index(@RequestParam(value="name", required=false, defaultValue="SpringBoot")String name, Model model){
		//添加到model中，对view可见
//		model.addAttribute("name", name);
		return "Greetings From " + name + " !";
	}
}
