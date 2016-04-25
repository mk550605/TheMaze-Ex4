package controller.Commands;

import Model.Imodel.Model;
import View.View;
import controller.Command;

public class display_Maze implements Command {



	@Override
	public void doCommand(String[] args , Model model ,View view) {	
		view.print(model.displayMaze3D(args[0]));
	}

}
