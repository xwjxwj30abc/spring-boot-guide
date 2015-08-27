package zx.soft.sample.jetty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	@RequestMapping("/hello")
	@ResponseBody
	String home() {
		return "Hello World!";
	}

}
