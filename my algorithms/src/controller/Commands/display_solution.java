package controller.Commands;

import java.io.IOException;

import Model.Imodel.Model;
import View.View;
import controller.Command;

public class display_solution implements Command {

	@Override
	public void doCommand(String[] args, Model model ,View view) throws IOException {
		view.print(model.getSolution(args[0]));
		
	}

	

	

}
