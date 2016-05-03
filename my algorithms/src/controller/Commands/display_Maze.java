package controller.Commands;

import Model.Imodel.Model;
import View.View;
import controller.Command;

public class display_Maze implements Command {



	@Override
	public void doCommand(String[] args , Model model ,View view) {	
		if (args.length != 1 )
			throw new IllegalArgumentException("Inncorrect number of Arguments");
		view.print(model.displayMaze3D(args[0]));
	}

}
