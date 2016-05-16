package View;

import java.io.IOException;
import java.util.HashMap;

import controller.Command;
import controller.Controller;
/**
 * Define the bases of MyView
 * @author Michael Kratik &Tzipi Cabiri 
 *@version 1.0
 */
public class MyView implements View{
	Controller controller;
	
	/**
	 * Constructor for MyView
	 * @param controller
	 */
	public MyView(Controller controller) {
		this.controller = controller;
	}

	/**
	 * Start function for view
	 */
	@Override
	public void start() throws IOException {
	
		
	}

	/**
	 * print to gui 
	 */
	@Override
	public void print(Object textToPrint) {
		System.out.println(textToPrint);
		
	}



}
