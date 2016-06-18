package Presenter.CommandsModel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.GridData;

import Model.Imodel.Model;
import Presenter.Command;
import View.View;

public class Hint implements Command {
	/**
	 * Solve 3DMaze  . running in a difference Thread 
	 * @param args - Arguments - Name of the Maze , the Searcher Algorithm.
	 * @param Model - Model of the Program
	 * @param view - View  of the Program
	 */
	@Override
	public void doCommand(String[] args, Model model ,View view) {
//		if (args.length != 2 ){
//			view.displayMessage("Inncorrect number of Arguments");
//			return;
//		}
				try {
					model.hint(args[0],args[1],args[2],args[3]);
				} catch (Exception e) {
					view.displayMessage("Error in solving the Maze");
				}
	}



}
