package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import Model.Imodel.Model;
import View.View;
import controller.Commands.*;
import controller.Commands.Error;

/**
 *Controller of 3DMaze
 * @author Michael Kratik & Tzipi Cabiri 
 *@version 1.0
 *
 */
public class MyController implements Controller{
	private HashMap<String, Command> commands = new HashMap<String, Command>();
	private Model model;
	private View view;	
/**
 * Constructor of MyController
 * implement Controller and starting the Command Hashmap for handle all commands
 */
	public MyController() {
		commands.put("dir", new dir());
		commands.put("generate 3d maze", new generate_3d_maze());
		commands.put("display" , new display_Maze());
		commands.put("display cross section by", new display_cross_section());
		commands.put("save maze", new Save_Maze());
		commands.put("load maze", new Load_Maze());
		commands.put("maze size" , new maze_size_in_mem());
		commands.put("file size" , new maze_size_in_file());
		commands.put("solve", new solve());
		commands.put("display solution", new display_solution());
		commands.put("exit", new exit());
		commands.put("help", new Help());
	}
	/**
	 * Model Setter 
	 * @param - Model
	 */
	public void setModel(Model model) {
		this.model = model;
	}
	/**
	 * View Setter 
	 * @param - view
	 */
	public void setView(View view) {
		this.view = view;
	}
	
/**
 * getter for HashMap of Commands
 * @return HashMap Commands
 */
	public HashMap<String, Command> getCommandSet(){
		return commands;
	}
	/**
	 * 
	 * private methud for handle User Command by finding the command in the hashMap and running the 
	 * doCommand function of it. 
	 * @param command 
	 * @param arguments of the command.
	 * @param model
	 * @param view
	 * 
	 */
	private void handleUserCommand(String cmd, String[] args , Model model , View view) throws IOException {
		Command command = new Error();
		if(!cmd.equals("")){
			for (Entry<String, Command> e : commands.entrySet()) {
				if (e.getKey().startsWith(cmd)){
					command = e.getValue();
					break;
				}
			}
		}
		command.doCommand(args , model , view);
	}
	/**
	 * handle User Command by adding the Model and view to the 
	 * @param command 
	 * @param arguments of the command.
	 * 
	 */
	@Override
	public void handleUserCommand(String cmd, String[] args) throws IOException {
		handleUserCommand(cmd, args, model,view);
	}
	public void getNotifyDone(String msg){
		view.print(msg);
	}


	

	
}
