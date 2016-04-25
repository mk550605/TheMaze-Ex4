package controller.Commands;

import java.io.IOException;

import Model.Imodel.Model;
import View.View;
import controller.Command;

public class Load_Maze implements Command {

	@Override
	public void doCommand(String[] args, Model model ,View view) throws IOException {
		model.loadFromFile(args[1], args[0]);
	}


	

}
