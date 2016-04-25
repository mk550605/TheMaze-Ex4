package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import Model.Imodel.Model;
import Model.Imodel.MyModel;
import View.Cli;
import View.View;
import controller.Commands.*;
import controller.Commands.Error;


public class MyController implements Controller{
	private HashMap<String, Command> commands = new HashMap<String, Command>();
	private Model model;
	private View view;	

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
		commands.put("Error", new Error());
	}
	
	public void setModel(Model model) {
		this.model = model;
	}
	
	public void setView(View view) {
		this.view = view;
	}
	

	public HashMap<String, Command> getCommandSet(){
		return commands;
	}
	public void handleUserCommand(String cmd, String[] args , Model model , View view) throws IOException {
		//Command command1 = commands.;
		Command command = new Error();
		for (Entry<String, Command> e : commands.entrySet()) {
			if (e.getKey().startsWith(cmd)){
				command = e.getValue();
				break;
			}
			   //add to my result list
		}
		command.doCommand(args , model , view);
	}

	@Override
	public void handleUserCommand(String cmd, String[] args) throws IOException {
		handleUserCommand(cmd, args, model,view);
	}




	

	
}
