package Presenter.CommandsView;

import java.io.IOException;

import Model.Imodel.Model;
import Presenter.Command;
import View.View;

public class DisplayMazeReadyMessageCommand implements Command {

	
	@Override
	public void doCommand(String[] args, Model model, View view) throws IOException {
	view.displayMessage(model.getMazeGeneretedMsg());
	view.setlistOfMazes(model.getMazesList());
	}

}
  