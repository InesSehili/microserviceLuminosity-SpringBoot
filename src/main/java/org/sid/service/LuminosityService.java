package org.sid.service;

import java.util.HashMap;
import java.util.Map;

import org.sid.controller.LuminosityController;
import org.sintef.jarduino.JArduino;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LuminosityService {
	LuminosityController e=new LuminosityController("COM4");
	
	
	
	
	
	
	@Value("${xParam}")
	private int xParam;
  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping("/myConfig")
  public Map<String, Object> MyConfig()
   {Map<String, Object> param= new HashMap();
       param.put("xParam", xParam);
           param.put("thread", Thread.currentThread().getName());
              return param;}







@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/DemarrerServiceLuminosity", method=RequestMethod.GET)
public void demmarrer() {
	e.setStatus("automatique");
	 JArduino arduino =e;
	 arduino.runArduinoProcess();
	  }
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/AutomatiqueLampe", method=RequestMethod.GET)
public void automatique() {
	
	e.setStatus("automatique");
	  }
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/OnLampe", method=RequestMethod.GET)
public void On() {
	
	e.setStatus("On");
	  }
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/OffLampe", method=RequestMethod.GET)
public void Off() {
	
	e.setStatus("Off");
	  }
}
