package zx.soft.sample.data.jpa.domain;

/*@Component
public class CustomizationEmbeddedServletContainer implements EmbeddedServletContainerCustomizer {

	@Value("${server.port}")
	private String port;

	@Value("${server.address}")
	private String address;

	@Value("${server.sessionTimeout}")
	private String sessionTimeout;

	//方式一:编程方式的自定义
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(Integer.parseInt(port));
		container.setSessionTimeout(Integer.parseInt(sessionTimeout));
	}

	//方式二:直接定义ConfigurableEmbeddedServletContainer
	//	@Bean
	//	public EmbeddedServletContainerFactory servletContainer() {
	//		JettyEmbeddedServletContainerFactory factory = new JettyEmbeddedServletContainerFactory();
	//		factory.setPort(Integer.parseInt(port));
	//		factory.setSessionTimeout(Integer.parseInt(sessionTimeout), TimeUnit.MINUTES);
	//		return factory;
	//	}

	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
		builder.dateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH));
		return builder;
	}

}
 */