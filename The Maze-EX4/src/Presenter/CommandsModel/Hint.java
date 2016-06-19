package Presenter.CommandsModel;

import Model.Imodel.Model;
import Presenter.Command;
import View.View;

public class Hint implements Command {
	/**
	 * Hint  solving the 3DMaze from the curr loction . running in a difference Thread 
	 * @param args - Arguments - Name of the Maze , the Searcher Algorithm.
	 * @param Model - Model of the Program
	 * @param view - View  of the Program
	 */
	@Override
	public void doCommand(String[] args, Model model ,View view) {
				try {
					model.hint(args[0],args[1],args[2],args[3]);
				} catch (Exception e) {
					view.displayMessage("Error in solving the Maze");
				}
	}



}
