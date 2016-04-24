package controller.Commands;

import Model.Imodel.Model;
import controller.Command;

public class display_Maze implements Command {



	@Override
	public void doCommand(String[] args , Model model) {	
		model.displayMaze3D(args[0]);
		
	}

}
