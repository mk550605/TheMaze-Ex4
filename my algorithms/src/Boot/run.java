package Boot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


import Model.Imodel.Model;
import Model.Imodel.MyModel;
import View.Cli;
import View.View;
import controller.Controller;
import controller.MyController;

public class run {
	
	public static void main(String[] args) throws IOException {
		
		Controller c =new MyController();
		Model m = new MyModel(c);
		View view =  new Cli(new BufferedReader(new InputStreamReader(System.in)), new PrintWriter(System.out),c);
		c.setModel(m);
		c.setView(view);
		view.start();
	}

}
