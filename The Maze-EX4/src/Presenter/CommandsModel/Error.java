package Presenter.CommandsModel;

import Model.Imodel.Model;
import Presenter.Command;
import View.View;

public class Error implements Command {
	/**
	 * display Error msg
	 * @param args - Arguments none
	 * @param Model - Model of the Program
	 * @param view - View  of the Program
	 */
	@Override
	public void doCommand(String[] args, Model model, View view) {
		view.displayMessage("Wrong input, please try again");

	}

}
