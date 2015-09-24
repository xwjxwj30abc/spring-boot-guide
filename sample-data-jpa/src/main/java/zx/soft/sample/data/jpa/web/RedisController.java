package zx.soft.sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import zx.soft.sample.data.jpa.domain.Customer;
import zx.soft.sample.data.jpa.service.RedisService;

@RestController
@RequestMapping(value = "/redis")
public class RedisController {

	@Autowired
	private RedisService redisService;

	@RequestMapping(value = "/json", method = RequestMethod.POST, headers = "content-type=application/json")
	@ResponseStatus(HttpStatus.OK)
	public void putJson(@RequestBody Customer customer) {
		redisService.add(customer);
	}

}
