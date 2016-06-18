package Presenter.CommandsModel;

import java.io.IOException;

import Model.Imodel.Model;
import Presenter.Command;
import View.View;

public class updatexml implements Command {

	@Override
	public void doCommand(String[] args, Model model, View view) throws IOException {
		model.updatexml();

	}

}
