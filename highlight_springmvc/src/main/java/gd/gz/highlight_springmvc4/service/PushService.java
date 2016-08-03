package gd.gz.highlight_springmvc4.service;

import java.util.Calendar;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

@Service
public class PushService {
	private DeferredResult<String> deferredResult;

	public DeferredResult<String> getAsyncUpdate() {
		deferredResult = new DeferredResult<String>();
		return deferredResult;
	}

	@Scheduled(fixedDelay = 1000)
	public void refresh() {
		if (deferredResult != null) {
			Calendar calendar = Calendar.getInstance();
			deferredResult.setResult(calendar.getTime().toString());
		}
	}
}
