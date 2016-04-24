package controller.Commands;

import java.io.IOException;

import Model.Imodel.Model;
import controller.Command;

public class Save_Maze implements Command {

	@Override
	public void doCommand(String[] args, Model model) throws IOException {
		model.saveToFile(args[0], args[1]);	
	}




}
