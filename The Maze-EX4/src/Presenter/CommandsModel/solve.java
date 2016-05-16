package Presenter.CommandsModel;

import java.io.IOException;

import Model.Imodel.Model;
import Presenter.Command;
import View.View;

public class solve implements Command {
	/**
	 * Solve 3DMaze  . running in a difference Thread 
	 * @param args - Arguments - Name of the Maze , the Searcher Algorithm.
	 * @param Model - Model of the Program
	 * @param view - View  of the Program
	 */
	@Override
	public void doCommand(String[] args, Model model ,View view) throws IOException {
		if (args.length != 2 )
			throw new IllegalArgumentException("Inncorrect number of Arguments");
		Thread SolverThread = new Thread(new Runnable() {
			public void run() {
				model.solveMaze(args[0],args[1]);
			}
		});
		
		SolverThread.start();
	}



}
