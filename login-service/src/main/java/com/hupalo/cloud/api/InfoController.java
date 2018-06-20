package com.hupalo.cloud.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//public class InfoController {
//
//	@Autowired
//	private Environment env;
//
//	@GetMapping
//	public Map<String, Object> getProperties() {
//		var map = new HashMap();
//		((AbstractEnvironment) env).getPropertySources().forEach(x ->
//				{
//					if (x instanceof MapPropertySource) {
//						map.putAll(((MapPropertySource) x).getSource());
//					}
//				}
//		);
//
//		return map;
//	}
//}
