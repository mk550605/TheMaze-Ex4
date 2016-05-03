package controller.Commands;

import java.io.IOException;

import Model.Imodel.Model;
import View.View;
import controller.Command;

public class Save_Maze implements Command {

	@Override
	public void doCommand(String[] args, Model model ,View view) throws IOException {
		if (args.length != 2 )
			throw new IllegalArgumentException("Inncorrect number of Arguments");
		model.saveToFile(args[0], args[1]);	
	}




}
