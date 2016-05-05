package controller.Commands;

import java.io.IOException;

import Model.Imodel.Model;
import View.View;
import controller.Command;

public class display_solution implements Command {
	/**
	 * display 3DMaze Solution
	 * @param args - Arguments - Name of the maze
	 * @param Model - Model of the Program
	 * @param view - View  of the Program
	 */
	@Override
	public void doCommand(String[] args, Model model ,View view) throws IOException {
		if (args.length != 1 )
			throw new IllegalArgumentException("Inncorrect number of Arguments");
		view.print(model.getSolution(args[0]));
		
	}

	

	

}
