package Presenter.CommandsView;

import java.io.IOException;

import Model.Imodel.Model;
import Presenter.Command;
import Presenter.Presenter;
import View.View;

public class updateviewxml implements Command {

	@Override
	public void doCommand(String[] args, Model model, View view) throws IOException {
		view.setProp(model.getProp());
	}

}
