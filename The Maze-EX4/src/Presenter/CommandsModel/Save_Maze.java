package Presenter.CommandsModel;

import java.io.IOException;

import Model.Imodel.Model;
import Presenter.Command;
import View.View;

public class Save_Maze implements Command {
	/**
	 * save 3DMaze in a file 
	 * @param args - Arguments - Name of the Maze, name of File
	 * @param Model - Model of the Program
	 * @param view - View  of the Program
	 */
	@Override
	public void doCommand(String[] args, Model model ,View view) throws IOException {
		if (args.length != 2 )
			throw new IllegalArgumentException("Inncorrect number of Arguments");
		model.saveToFile(args[0], args[1]);	
	}




}
