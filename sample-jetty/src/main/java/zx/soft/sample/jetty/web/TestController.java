package zx.soft.sample.jetty.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zx.soft.sample.jetty.service.Writer;

@Controller
public class TestController {

	private Writer writer;

	@RequestMapping("/hello")
	@ResponseBody
	String home() {
		return "Hello World!";
	}

	@RequestMapping(value = "/hbase")
	public void put() {
		writer.write("tableName", "cf", "0", "qua", "value");
	}

}
