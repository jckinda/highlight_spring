package gd.gz.highlight_springmvc4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import gd.gz.highlight_springmvc4.interceptor.DemoInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan("gd.gz.highlight_springmvc4")
public class MyMvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/classes/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}

	//暴露文件
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
		registry.addResourceHandler("/test/**").addResourceLocations("classpath:/test1/");
	}
	
	//定义拦截器
	@Bean
	public DemoInterceptor demoInterceptor(){
		return new DemoInterceptor();
	}
	
	//添加拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(demoInterceptor());
	}
	
	//定义viewController
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index1").setViewName("index");
		registry.addViewController("/index2").setViewName("index");
	}
}
