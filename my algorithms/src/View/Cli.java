package View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import controller.*;


public class Cli extends MyView{

	private HashMap<String, Command> commandsSet;
	private BufferedReader in;
	private PrintWriter out;

	/**
	 * Command Line Interface for the 3Dmaze Project
	 * getting the User Commands and arguments.
	 * @param in - inbound commands
	 * @param out - outbound information
	 * @param thecontroller - Controller for the program
	 */
	public Cli (BufferedReader in,PrintWriter out , Controller thecontroller) {
		super(thecontroller);
		this.in=in;
		this.out=out;
		this.commandsSet= controller.getCommandSet();
	}
	/**
	 * Start for the View
	 */
	public void start(){
		Thread cliThread = new Thread(new Runnable() {
			public void run() {
				String line= "1";
				while(!line.equals("exit")) {
					System.out.println("\n");
					for(String str: commandsSet.keySet())
						System.out.println("* " + str);
					System.out.println("\nEnter command");
					try {
						line=in.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
						StringBuilder argusb= new StringBuilder();
						StringBuilder command=new StringBuilder();
						String[] split=line.split(" ");
						int j=0;
						for (int i =0;i<split.length;i++) {
							if (split[i].startsWith("<")){
								split[i] = split[i].replace("<","");
								split[i] = split[i].replace(">", "");
								split[i]= split[i].toLowerCase();
								argusb.append(split[i]);
								argusb.append(" ");
								
							}
							else {
								command.append(" ");
								command.append(split[i]);
							}
							
							
						}
						command.deleteCharAt(0);
						try{
						controller.handleUserCommand(command.toString(),argusb.toString().split(" "));
						}catch (Exception e){
							e.printStackTrace();
						}
						
						argusb=null;
						
					}
					//out.write("The Program closed Good Bye");
			{ try {
				in.close();
			} catch (IOException e) {
				System.out.println("The In stream can't be close");
			} 
				out.close();
			}
			}
		});
			
			cliThread.start();	
		}
}
