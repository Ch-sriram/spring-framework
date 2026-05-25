package com.sriram.lil.landon_hotel.web.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.micrometer.common.util.StringUtils;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {
	
	@GetMapping(produces=MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String getWelcome(@RequestParam(value="name", required=false) String name) {
		String greeting = "Hello " + (StringUtils.isNotBlank(name) ? name : "World") + "!";
		return "<h1>" + greeting + "</h1>";
	}

	// Open http://localhost:8080/welcome?name=Sriram, and see that the output is "Hello Sriram!"
	// NOTE: If the `name` query parameter is changed, that same parameter would reflect in the view.
}
