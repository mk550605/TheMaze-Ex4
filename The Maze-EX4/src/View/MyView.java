package View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import Presenter.Command;
import controller.Controller;
/**
 * Define the bases of MyView
 * @author Michael Kratik &Tzipi Cabiri 
 *@version 1.0
 */
public class MyView extends Observable implements View, Observer {

	private BufferedReader in;
	private Writer out;
	private Cli cli;	
		
	public MyView(BufferedReader in, Writer out)
	{		
		this.in = in;
		this.out = out;		
		cli = new Cli(in, out);
		cli.addObserver(this);
	}
			
	@Override
	public void displayMessage(String message) {
		try {
			out.write(message);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public void start() {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {				
				cli.start();
			}
			
		});	
		thread.start();
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o == cli) {
			this.setChanged();
			this.notifyObservers(arg);			
		}		
	}	
}
