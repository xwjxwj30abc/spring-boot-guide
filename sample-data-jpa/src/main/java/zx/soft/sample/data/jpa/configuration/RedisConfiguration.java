package zx.soft.sample.data.jpa.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import zx.soft.sample.data.jpa.domain.Customer;

@Configuration
public class RedisConfiguration {

	@Bean
	public RedisTemplate<String, Customer> jsonRedisTemplate(RedisConnectionFactory connectionFactory) {
		RedisTemplate<String, Customer> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(connectionFactory);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Customer.class));
		redisTemplate.setHashKeySerializer(redisTemplate.getKeySerializer());
		redisTemplate.setHashValueSerializer(redisTemplate.getValueSerializer());
		return redisTemplate;
	}

}
