package Presenter.CommandsView;

import java.io.IOException;

import Model.Imodel.Model;
import Presenter.Command;
import View.View;

public class hintDisplay implements Command {

	@Override
	public void doCommand(String[] args, Model model, View view) throws IOException {
		view.setSolution(model.getSolution(model.getLastHint()));
		view.startHint();
	}

}
