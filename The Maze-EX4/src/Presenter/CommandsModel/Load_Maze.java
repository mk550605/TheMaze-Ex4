package Presenter.CommandsModel;

import java.io.IOException;

import Model.Imodel.Model;
import Presenter.Command;
import View.View;

public class Load_Maze implements Command {
	/**
	 * Load 3DMaze from File. 
	 * @param args - Arguments - Name of the Maze , Name of File.
	 * @param Model - Model of the Program
	 * @param view - View  of the Program
	 */
	@Override
	public void doCommand(String[] args, Model model ,View view) throws IOException {
		if (args.length != 2 ){
			view.displayMessage("Inncorrect number of Arguments\n");
			return;
		}
		try {
			model.loadFromFile(args[1], args[0]);
		} catch (Exception e) {
			view.displayMessage("Failed to Load File " + args[0]);
		}
	}


	

}
