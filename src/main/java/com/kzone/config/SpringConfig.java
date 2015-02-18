package com.kzone.config;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.accept.PathExtensionContentNegotiationStrategy;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.mvc.method.annotation.MatrixVariableMethodArgumentResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.tiles2.TilesView;

@Configuration
@ComponentScan("com.kzone")
@EnableWebMvc
public class SpringConfig extends WebMvcConfigurerAdapter {

//	@Bean
//	public UrlBasedViewResolver setupViewResolver() {
//
//		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
//		resolver.setPrefix("/WEB-INF/jsp/");
//		resolver.setSuffix(".jsp");
//		resolver.setViewClass(JstlView.class);
//		return resolver;
//	}

	@Bean
	public ViewResolver tilesViewResolver() {
		UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
		urlBasedViewResolver.setOrder(1);
		urlBasedViewResolver.setViewClass(TilesView.class);
		return urlBasedViewResolver;
	}
	
//	@Bean
//	public ResourceBundleViewResolver getViewResolver(){
//		ResourceBundleViewResolver resolver = new ResourceBundleViewResolver();
//		resolver.setBasename("views");
//		resolver.setOrder(1);
//		return resolver;
//	}
//	
	@Bean
	public TilesConfigurer tilesConfigurer() {
         TilesConfigurer tilesConfigurer = new TilesConfigurer();
         tilesConfigurer.setDefinitions(new String []{"WEB-INF/tile-defs/templates.xml","WEB-INF/tile-defs/definitions.xml"});
         return tilesConfigurer;
    }
	
	@Bean
	public ContentNegotiatingViewResolver getContentNegotiatingViewResolve(){
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setOrder(org.springframework.core.Ordered.HIGHEST_PRECEDENCE);
//		resolver.setFavorPathExtension(true);
		resolver.setContentNegotiationManager(getContentNegotiationManager());
		return resolver;
	}
	
	
	private ContentNegotiationManager getContentNegotiationManager(){
		ContentNegotiationManager manager = 
				new ContentNegotiationManager(getPathExtensionContentNegotiationStrategy());
		
		return manager;
	}
	
	private PathExtensionContentNegotiationStrategy getPathExtensionContentNegotiationStrategy(){
		Map<String, MediaType> mediaTypes = new HashMap<String, MediaType>();
		mediaTypes.put("html", MediaType.TEXT_HTML);
		mediaTypes.put("xml", MediaType.APPLICATION_XML);
		mediaTypes.put("json", MediaType.APPLICATION_JSON);
		mediaTypes.put("atom", MediaType.APPLICATION_XML);
//		mediaTypes.put("atom", MediaType.);
		
		PathExtensionContentNegotiationStrategy strategy 
		= new PathExtensionContentNegotiationStrategy(mediaTypes);
		
		return strategy;
	}
	
	
	@Bean
	public MatrixVariableMethodArgumentResolver setupMatrixVariableMethodArgumentResolver() {
		MatrixVariableMethodArgumentResolver argumentResolver = new MatrixVariableMethodArgumentResolver();

		return argumentResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations(
				"/resources/");

	}
	
	
//	@Bean
//    public MessageSource messageSource() {
//        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//        messageSource.setBasename("messages");
//        return messageSource;
//    }

//	@Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(localeChangeInterceptor());
//    }
//	
//	@Bean
//    public HandlerInterceptor localeChangeInterceptor() {
//        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
//        localeChangeInterceptor.setParamName("lang");
//        return localeChangeInterceptor;
//    }

    @Bean
    public LocaleResolver localeResolver() {
    	CookieLocaleResolver localeResolver = new CookieLocaleResolver();
    	localeResolver.setDefaultLocale(new Locale("en"));
        return localeResolver;
    }
//
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:/messages");
        messageSource.setUseCodeAsDefaultMessage(true);
        return messageSource;
    }

}
