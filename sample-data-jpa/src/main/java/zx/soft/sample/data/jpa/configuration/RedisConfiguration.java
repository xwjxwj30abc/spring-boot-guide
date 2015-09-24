package zx.soft.sample.data.jpa.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;
import zx.soft.sample.data.jpa.domain.Customer;

/**
 *　redis连接配置类
 * @author xuwenjuan
 *
 */
@Configuration
public class RedisConfiguration {

	@Value("${spring.redis.host}")
	String host;
	@Value("${spring.redis.password}")
	String password;
	@Value("${spring.redis.port}")
	String port;
	@Value("${spring.redis.database}")
	String database;
	@Value("${spring.redis.pool.max-idle}")
	String maxIdle;
	@Value("${spring.redis.pool.min-idle}")
	String minIdle;
	@Value("${spring.redis.pool.max-wait}")
	String maxWait;

	@Bean
	public RedisTemplate<String, Customer> jsonRedisTemplate() {
		RedisTemplate<String, Customer> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory());//或者使用@Autowired RedisConnectionFactory
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Customer.class));
		redisTemplate.setHashKeySerializer(redisTemplate.getKeySerializer());
		redisTemplate.setHashValueSerializer(redisTemplate.getValueSerializer());
		return redisTemplate;
	}

	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		factory.setHostName(host);
		factory.setPassword(password);
		factory.setPort(Integer.parseInt(port));
		factory.setDatabase(Integer.parseInt(database));
		factory.setUsePool(true);
		factory.setPoolConfig(jedisPoolConfig());
		return factory;
	}

	@Bean
	public JedisPoolConfig jedisPoolConfig() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(Integer.parseInt(maxIdle));
		jedisPoolConfig.setMaxWaitMillis(Integer.parseInt(maxWait));
		jedisPoolConfig.setMinIdle(Integer.parseInt(minIdle));
		return jedisPoolConfig;
	}
}
