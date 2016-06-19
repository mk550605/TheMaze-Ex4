package Presenter.CommandsView;

import java.io.IOException;

import Model.Imodel.Model;
import Presenter.Command;
import Presenter.Presenter;
import View.View;
/**
 *@author Michael Kratik & Tzipi Cabiri
 * setting the properties to the view model.
 */
public class updateviewxml implements Command {

	/**
	 *  setting the properties to the view model.
	 */
	@Override
	public void doCommand(String[] args, Model model, View view) throws IOException {
		view.setProp(model.getProp());
	}

}
