package gd.gz.highlight_springmvc4.web.ch4_3;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gd.gz.highlight_springmvc4.domain.DemoObj;

@RestController
@RequestMapping("/rest")
public class DemoRestController {
	
	@RequestMapping(value="/getjson",produces="application/json;charset=utf-8")
	public DemoObj getjson(DemoObj obj){
		return new DemoObj(obj.getId()+1, obj.getName()+"yy");
	}
	
	@RequestMapping(value="/getxml",produces="application/xml;charset=utf-8")
	public DemoObj getxml(DemoObj obj){
		return new DemoObj(obj.getId()+1, obj.getName()+"yy");
	}
	
	@RequestMapping(value="/test0",produces="application/json;charset=utf-8")
	public ResponseEntity<String> test0(){
		return ResponseEntity.ok("好嘢！！！");
	}
	
	
}
