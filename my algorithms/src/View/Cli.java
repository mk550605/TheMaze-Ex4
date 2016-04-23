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

	
	public Cli (BufferedReader in,PrintWriter out , Controller thecontroller) {
		super(thecontroller);
		this.in=in;
		this.out=out;
		this.commandsSet= controller.getCommandSet();
	}
	
	
	public void startView() throws IOException {
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
					String[] argu= new String[2];
					StringBuilder command=new StringBuilder();
					String[] split=line.split(" ");
					for (int j =0 ,i =0;i<split.length;i++) {
						if (split[i].charAt(0)=='<'){
							split[i] = split[i].replace("<","");
							split[i] = split[i].replace(">", "");
							argu[j]=split[i];
							j++;
						}
						else {
							command.append(split[i]);
						}
						
						
					}
					//Command com=commandsSet.get(command);
					//com.doCommand(argu);
					controller.handleUserCommand(command.toString(), argu);
					argu=null;
					
				
					
				}
				out.write("The Program closed Good Bye");
				in.close();
				out.close();
			
		
		{ try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
			out.close();
		}
	}
	
}
