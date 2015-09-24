package zx.soft.sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zx.soft.sample.data.jpa.service.HBaseService;

@Controller
public class HBaseController {

	@Autowired
	private HBaseService hBaseService;

	@RequestMapping("/hello")
	@ResponseBody
	String home() {
		return "Hello World!";
	}

	@RequestMapping(value = "/hbase")
	@ResponseBody
	public String put() {
		hBaseService.write("0", "qua", "value");
		return "ok";
	}

}
