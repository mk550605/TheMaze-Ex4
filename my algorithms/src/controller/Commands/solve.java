package controller.Commands;

import java.io.IOException;

import Model.Imodel.Model;
import controller.Command;

public class solve implements Command {

	@Override
	public void doCommand(String[] args, Model model) throws IOException {
		
		model.solveMaze(args[0],args[1]);
		
	}



}
