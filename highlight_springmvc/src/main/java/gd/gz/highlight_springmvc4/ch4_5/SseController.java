package gd.gz.highlight_springmvc4.ch4_5;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SseController {
	@RequestMapping(value = "/push", produces = "text/event-stream")
	@ResponseBody
	public String push() {
		Random rr = new Random();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "data: Testing 1,2,3" + rr.nextInt() + "\n\n";
	}

}
