package com.solvd.seleniumpure;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.solvd.seleniumpure.SeleniumWebdriver;

public class Menu {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(Menu.class);
	
	public Menu() {

	}

	public void showSeleniumDriverFunctions() {	
	
		SeleniumWebdriver swd = new SeleniumWebdriver();
		System.out.println("1");
		swd.showSeleniumDriverChrome();
		
	}
	
}