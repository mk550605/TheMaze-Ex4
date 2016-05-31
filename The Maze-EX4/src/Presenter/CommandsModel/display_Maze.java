package Presenter.CommandsModel;

import Model.Imodel.Model;
import Presenter.Command;
import View.View;

public class display_Maze implements Command {


	/**
	 * display 3DMaze 
	 * @param args - Arguments - Name of the Maze
	 * @param Model - Model of the Program
	 * @param view - View  of the Program
	 */
	@Override
	public void doCommand(String[] args , Model model ,View view) {	
		
		if (args.length != 1 ){
	    	  view.displayMessage("Inncorrect number of Arguments\n");
	      	  return;
	      }
		view.displayMaze(model.displayMaze3D(args[0]));
	}

}
