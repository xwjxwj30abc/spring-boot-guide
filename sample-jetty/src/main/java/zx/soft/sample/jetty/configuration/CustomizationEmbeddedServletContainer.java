package zx.soft.sample.jetty.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
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

}
