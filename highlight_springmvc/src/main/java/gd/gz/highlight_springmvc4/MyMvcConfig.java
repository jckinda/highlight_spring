package gd.gz.highlight_springmvc4;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("gd.gz.highlight_springmvc4")
public class MyMvcConfig {
		public InternalResourceViewResolver viewResolver(){
			InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
			viewResolver.setPrefix("/WEB-INF/classes/views/");
			viewResolver.setSuffix(".jsp");
			viewResolver.setViewClass(JstlView.class);
			return viewResolver;
		}
		

}
