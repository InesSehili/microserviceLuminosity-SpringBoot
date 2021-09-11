package org.sid.controller;

import org.sintef.jarduino.AnalogPin;
import org.sintef.jarduino.JArduino;
import org.sintef.jarduino.PWMPin;

public class LuminosityController extends JArduino{
	private String status="" ;
	final AnalogPin analogInPin = AnalogPin.A_1;  // Analog input pin that the potentiometer is attached to
	//actuator 
	final PWMPin analogOutPin = PWMPin.PWM_PIN_9; // Analog output pin that the LED is attached to
                                                            
	int sensorValue = 0;        
	int outputValue = 0;
	public LuminosityController(String port) {
		super(port);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void loop() {
		// TODO Auto-generated method stub
		if(status.equals("automatique"))
		{
		  sensorValue = analogRead(analogInPin);            
		  // map it to the range of the analog out:
		  outputValue = map(sensorValue, 0, 1023, 0, 255);  
		  // change the analog out value:
		  analogWrite(analogOutPin, (byte)outputValue);           

		  // print the results to the serial monitor:
		  System.out.print("sensor = " );                       
		  System.out.print(sensorValue);      
		  System.out.print("\t output = ");      
		  System.out.println(outputValue);   

		  // wait 10 milliseconds before the next loop
		  // for the analog-to-digital converter to settle
		  // after the last reading:
		  delay(10); 
		  System.out.print(this.status); }
		
			if(this.status.equals("On"))
		{ 
				analogWrite(analogOutPin,(byte) 255);      }
		
			if (this.status.equals("Off"))
		{ analogWrite(analogOutPin,(byte)0 );      }
		
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
