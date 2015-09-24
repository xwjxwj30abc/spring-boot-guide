package zx.soft.sample.data.jpa.configuration;

import java.text.SimpleDateFormat;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * 其他部分工具配置类
 * @author xuwenjuan
 *
 */
@Configuration
public class UtilsConfiguration {

	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
		builder.dateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH));
		return builder;
	}

}
