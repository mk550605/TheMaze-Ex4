package Presenter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import Model.Imodel.Model;
import Presenter.CommandsModel.Error;
import Presenter.CommandsModel.Help;
import Presenter.CommandsModel.Hint;
import Presenter.CommandsModel.Load_Maze;
import Presenter.CommandsModel.Save_Maze;
import Presenter.CommandsModel.dir;
import Presenter.CommandsModel.display_Maze;
import Presenter.CommandsModel.display_cross_section;
import Presenter.CommandsModel.display_solution;
import Presenter.CommandsModel.exit;
import Presenter.CommandsModel.generate_3d_maze;
import Presenter.CommandsModel.maze_size_in_file;
import Presenter.CommandsModel.maze_size_in_mem;
import Presenter.CommandsModel.solve;
import Presenter.CommandsModel.updatexml;
import Presenter.CommandsView.DisplayErrorMSG;
import Presenter.CommandsView.DisplayExitMSG;
import Presenter.CommandsView.DisplayMazeGui;
import Presenter.CommandsView.DisplayMazeReadyMessageCommand;
import Presenter.CommandsView.DisplaySolutionMSG;
import Presenter.CommandsView.hintDisplay;
import Presenter.CommandsView.updateviewxml;
import View.View;
/**
 * 
 * @author Michael Kratik & Tzipi Cabiri 
 * @version 1.4
 *class define all the Presenter work
 *holding two command hashmap - view commands and model commands.
 */
public class Presenter implements Observer {
	private Model model;
	private View view;
	private HashMap< String, Command> viewCommands  = new HashMap<String, Command>();;
	private HashMap< String, Command> modelCommands  = new HashMap<String, Command>();;
	public  Properties prop;
	
	public Presenter(Model model, View view){
		this.model= model;
		this.view =view;
		buildCommands();
		view.setProp(model.getProp());
		view.setlistOfMazes(model.getMazesList());
	}
	/**
	 * buliding all the command Hashmaps 
	 * 
	 */
	private void buildCommands(){
		modelCommands.put("dir", new dir());
		modelCommands.put("generate_3d_maze", new generate_3d_maze());
		modelCommands.put("display" , new display_Maze());
		modelCommands.put("display_cross_section_by", new display_cross_section());
		modelCommands.put("save_maze", new Save_Maze());
		modelCommands.put("load_maze", new Load_Maze());
		modelCommands.put("maze_size" , new maze_size_in_mem());
		modelCommands.put("file_size" , new maze_size_in_file());
		modelCommands.put("solve", new solve());
		modelCommands.put("display_solution", new display_solution());
		modelCommands.put("exit", new exit());
		modelCommands.put("help", new Help());
		modelCommands.put("Error", new Error());
		modelCommands.put("updatexml", new updatexml());
		modelCommands.put("hint", new Hint());
		viewCommands.put("MazeDone", new DisplayMazeReadyMessageCommand());
		viewCommands.put("canExit", new DisplayExitMSG());
		viewCommands.put("SolutionisReady", new DisplaySolutionMSG());
		viewCommands.put("Error", new DisplayErrorMSG());
		viewCommands.put("DisplayMazeGui", new DisplayMazeGui());
		viewCommands.put("updatenewxml", new updateviewxml());
		viewCommands.put("hintReady", new hintDisplay());
	}
	
	/**
	 * Handle commands from observable.
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (o == model){
			String CommandName = (String) arg;
			Command command = viewCommands.get(CommandName);
			try {
				command.doCommand(null, model,view);
//				view.displayMessage(String.valueOf(prop.getNumOfCols()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (o==view) {
			String commandLine = (String)arg;
			commandLine = commandLine.trim();
			commandLine = commandLine.toLowerCase();
			String[] arr = commandLine.split(" ");
			String commandName = arr[0];
			String[] args = new String[arr.length - 1];
			System.arraycopy(arr, 1, args, 0, arr.length - 1);
			
			Command command = modelCommands.get(commandName);
			if (command == null)
				command=modelCommands.get("Error");
			try {
				command.doCommand(args , model, view);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}

}
