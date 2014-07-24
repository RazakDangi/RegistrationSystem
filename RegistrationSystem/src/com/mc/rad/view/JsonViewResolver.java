package com.mc.rad.view;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

public class JsonViewResolver implements ViewResolver{

	@SuppressWarnings("deprecation")
	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception {
		@SuppressWarnings("deprecation")
		MappingJacksonJsonView jsonView = new MappingJacksonJsonView();
		jsonView.setPrettyPrint(true);
		return null;
	}

}
