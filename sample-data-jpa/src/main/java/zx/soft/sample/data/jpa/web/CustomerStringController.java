package zx.soft.sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import zx.soft.sample.data.jpa.domain.Customer;

// curl -XPUT --header 'Content-Type:application/json' http://192.168.6.126:8900/customer-json
//--data '{"firstName":"redis-first-second","lastName":"redis-last-second"}'
@RestController
@RequestMapping(value = "/customer-json")
public class CustomerStringController {

	@Autowired
	private RedisTemplate<String, Customer> redisTemplate;

	@RequestMapping(method = RequestMethod.PUT, headers = "content-type=application/json")
	@ResponseStatus(HttpStatus.OK)
	public void putJson(@RequestBody Customer customer) {
		ValueOperations<String, Customer> valueOper = redisTemplate.opsForValue();
		valueOper.set("customer", customer);
	}

}
