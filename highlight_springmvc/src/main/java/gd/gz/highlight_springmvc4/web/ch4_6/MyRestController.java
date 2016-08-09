package gd.gz.highlight_springmvc4.web.ch4_6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gd.gz.highlight_springmvc4.service.DemoService;

@RestController
public class MyRestController {
	@Autowired
	DemoService demoService;
	
	@RequestMapping(value="/testRest",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String testRest(){
		return demoService.saySonething();
	}
}