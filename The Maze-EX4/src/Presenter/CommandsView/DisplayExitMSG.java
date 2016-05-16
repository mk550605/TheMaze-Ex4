package Presenter.CommandsView;

import java.io.IOException;

import Model.Imodel.Model;
import Presenter.Command;
import View.View;

public class DisplayExitMSG implements Command {

	@Override
	public void doCommand(String[] args, Model model, View view) throws IOException {
		view.displayMessage(model.getExitMSG());

	}

}
