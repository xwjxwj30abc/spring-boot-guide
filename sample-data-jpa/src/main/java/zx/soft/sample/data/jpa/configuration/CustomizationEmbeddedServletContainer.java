package zx.soft.sample.data.jpa.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.stereotype.Component;

/**
 * servlet配置类
 * @author xuwenjuan
 *
 */
@Component
public class CustomizationEmbeddedServletContainer implements EmbeddedServletContainerCustomizer {

	@Value("${server.port}")
	private String port;

	@Value("${server.address}")
	private String address;

	@Value("${server.sessionTimeout}")
	private String sessionTimeout;

	//方式一:使用pom.xml依赖中内嵌的servlet，调整其参数
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(Integer.parseInt(port));
		container.setSessionTimeout(Integer.parseInt(sessionTimeout));
	}

	//方式二:直接定义ConfigurableEmbeddedServletContainer，在pom.xml文件依赖中exclude　tomcat servlet并添加jetty　依赖
	//	@Bean
	//	public EmbeddedServletContainerFactory servletContainer() {
	//		JettyEmbeddedServletContainerFactory factory = new JettyEmbeddedServletContainerFactory();
	//		factory.setPort(Integer.parseInt(port));
	//		factory.setSessionTimeout(Integer.parseInt(sessionTimeout), TimeUnit.MINUTES);
	//		return factory;
	//	}

}
