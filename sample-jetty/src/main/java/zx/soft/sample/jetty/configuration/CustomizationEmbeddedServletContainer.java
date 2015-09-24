package zx.soft.sample.jetty.configuration;

import java.text.SimpleDateFormat;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;

@Component
public class CustomizationEmbeddedServletContainer implements EmbeddedServletContainerCustomizer {

	@Value("${server.port}")
	private String port;

	@Value("${server.sessionTimeout}")
	private String sessionTimeout;

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(Integer.parseInt(port));
		container.setSessionTimeout(Integer.parseInt(sessionTimeout));
	}

	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
		builder.dateFormat(new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US));
		return builder;
	}

}
