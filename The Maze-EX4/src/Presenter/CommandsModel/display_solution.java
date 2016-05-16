package Presenter.CommandsModel;

import java.io.IOException;

import Model.Imodel.Model;
import Presenter.Command;
import View.View;

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
		view.displayMessage(model.getSolution(args[0]));
		
	}

	

	

}
