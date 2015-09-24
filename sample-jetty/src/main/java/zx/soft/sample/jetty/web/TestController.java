package zx.soft.sample.jetty.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zx.soft.sample.jetty.service.Writer;

@Controller
public class TestController {

	@Autowired
	private Writer writer;

	@RequestMapping("/hello")
	@ResponseBody
	String home() {
		return "Hello World!";
	}

	@RequestMapping(value = "/hbase")
	@ResponseBody
	public String put() {
		writer.write("0", "qua", "value");
		return "ok";
	}

}
