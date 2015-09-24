package zx.soft.sample.data.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import zx.soft.sample.data.jpa.domain.Customer;

@Service
public class RedisService {

	@Autowired
	private RedisTemplate<String, Customer> redisTemplate;

	public void add(Customer customer) {
		ValueOperations<String, Customer> valueOper = redisTemplate.opsForValue();
		valueOper.set("sent:sina:closeCostomers", customer);
	}

}
