package org.tai.web.servlet.rest.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tai.web.servlet.PerSessionRequestCounter;

@Controller
@RequestMapping("/requests")
public class RequestController {
	
	private PerSessionRequestCounter counter;
	
	@Autowired
	public RequestController(PerSessionRequestCounter counter) {
		this.counter = counter;
	}
	
	@RequestMapping("/summary")
	public @ResponseBody Integer getRequestPerSession() {
		return this.counter.requestCount();
	}

}
