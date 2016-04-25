package controller.Commands;

import java.io.IOException;

import Model.Imodel.Model;
import View.View;
import controller.Command;

public class solve implements Command {

	@Override
	public void doCommand(String[] args, Model model ,View view) throws IOException {
		
		model.solveMaze(args[0],args[1]);
		
	}



}
