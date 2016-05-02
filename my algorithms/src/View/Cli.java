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
	
	public void start(){
		Thread thread = new Thread(new Runnable() {
			
			@Override
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
						String[] argu= new String[4];
						StringBuilder command=new StringBuilder();
						String[] split=line.split(" ");
						for (int j =0 ,i =0;i<split.length;i++) {
							if (split[i].startsWith("<")){
								split[i] = split[i].replace("<","");
								split[i] = split[i].replace(">", "");
								split[i]= split[i].toLowerCase();
								argu[j]=split[i];
								j++;
							}
							else {
								command.append(" ");
								command.append(split[i]);
							}
							
							
						}
					
						command.deleteCharAt(0);
						try{
						controller.handleUserCommand(command.toString(), argu);
						}catch (Exception e){
							e.printStackTrace();
						}
						
						argu=null;
						
						
					}
					out.write("The Program closed Good Bye");
					try {
						in.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					out.close();
				
			
			{ try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
				out.close();
			}
		}
					
			
		});	
		thread.run();
	}
	
	
	

}
