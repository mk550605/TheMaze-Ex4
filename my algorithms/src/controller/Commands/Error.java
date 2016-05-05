package controller.Commands;

import java.io.IOException;

import Model.Imodel.Model;
import View.View;
import controller.Command;

public class Error implements Command {
	/**
	 * display Error msg
	 * @param args - Arguments none
	 * @param Model - Model of the Program
	 * @param view - View  of the Program
	 */
	@Override
	public void doCommand(String[] args, Model model, View view) throws IOException {
		view.print("Wrong input, please try again");

	}

}
