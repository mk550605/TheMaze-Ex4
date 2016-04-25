package View;

import java.io.IOException;
import java.util.HashMap;

import controller.Command;
import controller.Controller;

public class MyView implements View{
	Controller controller;
	
	
	public MyView(Controller controller) {
		this.controller = controller;
	}


	@Override
	public void startView() throws IOException {
	
		
	}


	@Override
	public void print(String textToPrint) {
		System.out.println(textToPrint);
		
	}



}
