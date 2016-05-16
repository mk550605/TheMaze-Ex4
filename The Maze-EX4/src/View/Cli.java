package View;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.util.Observable;

public class Cli extends Observable {
	private BufferedReader in;
	private Writer out;	
	
	public Cli(BufferedReader in, Writer out) {
		this.in = in;
		this.out = out;		
	}
	
	public void start() {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				 
				try {					
					String line = null;
					do {
						out.write("\nEnter command: ");
						out.flush();
						line = in.readLine();
						setChanged();
						notifyObservers(line);						
					} while (!(line.equals("exit")));					 
					
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}						
			}
			
		});
		thread.start();
	}
	
	
}
