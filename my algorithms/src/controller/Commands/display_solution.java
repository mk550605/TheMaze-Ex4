package controller.Commands;

import java.io.IOException;

import Model.Imodel.Model;
import controller.Command;

public class display_solution implements Command {

	@Override
	public void doCommand(String[] args, Model model) throws IOException {
		model.getSolution(args[0]);
		
	}

	

	

}
