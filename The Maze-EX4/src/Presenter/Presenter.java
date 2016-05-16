package Presenter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import Model.Imodel.Model;
import Presenter.CommandsModel.Help;
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
import Presenter.CommandsView.DisplayExitMSG;
import Presenter.CommandsView.DisplayMazeReadyMessageCommand;
import Presenter.CommandsView.DisplaySolutionMSG;
import View.View;

public class Presenter implements Observer {
	private Model model;
	private View view;
	private HashMap< String, Command> viewCommands  = new HashMap<String, Command>();;
	private HashMap< String, Command> modelCommands  = new HashMap<String, Command>();;
	
	
	public Presenter(Model model, View view) {
		this.model= model;
		this.view =view;
		buildCommands();
	}
	
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
		viewCommands.put("MazeDone", new DisplayMazeReadyMessageCommand());
		viewCommands.put("canExit", new DisplayExitMSG());
		viewCommands.put("SolutionisReady", new DisplaySolutionMSG());
	}
	@Override
	public void update(Observable o, Object arg) {
		if (o == model){
			String CommandName = (String) arg;
			Command command = viewCommands.get(CommandName);
			try {
				command.doCommand(null, model,view);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (o==view) {
			String commandLine = (String)arg;
			String[] arr = commandLine.split(" ");
			String commandName = arr[0];
			String[] args = new String[arr.length - 1];
			System.arraycopy(arr, 1, args, 0, arr.length - 1);
			
			Command command = modelCommands.get(commandName);
			try {
				command.doCommand(args , model, view);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}

}