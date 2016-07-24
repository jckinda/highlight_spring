package gd.gz.highlight_springmvc4.web.ch4_3;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import gd.gz.highlight_springmvc4.domain.DemoObj;

@Controller
@RequestMapping("/anno")
public class DemoAnnoController {
	
	@RequestMapping(produces = "test/plain;charset=utf-8")
	@ResponseBody
	public String index(HttpServletRequest request) {
		return "url" + request.getRequestURL();
	}
	
	@RequestMapping(value = "/pathvar/{str}" , produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String demoPathVar(@PathVariable String str,HttpServletRequest request){
		return "url"+request.getRequestURL()+" Can access, str: "+ str;
	}
	
	@RequestMapping(value="/requestParam", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String passRequestParam(Long id , HttpServletRequest request){
		return "url:"+request.getRequestURL()+" can access, id: "+id;
	}
	
	@RequestMapping(value="/obj",produces="application/json;charset=utf-8")
	@ResponseBody
	public String passObj(DemoObj obj, HttpServletRequest request){
		return "url: "+request.getRequestURL()+ "can access, obj id: "+obj.getId()+" obj name: "+obj.getName();
	}
	
	@RequestMapping(value={"/name1","/name2"},produces="text/plain;charset=utf-8")
	@ResponseBody
	public String remove(HttpServletRequest request){
		return "url:"+request.getRequestURL()+"can access";
	}
	
	@RequestMapping(value="/test1",produces="text/plain;charset=utf-8",method=RequestMethod.GET)
	public ResponseEntity<String> test1(){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("叼你啊！！！");
	}
}
