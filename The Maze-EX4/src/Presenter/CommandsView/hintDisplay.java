package Presenter.CommandsView;

import java.io.IOException;

import Model.Imodel.Model;
import Presenter.Command;
import View.View;
/**
 * 
 * @author Michael Kratik & Tzipi Cabiri
 *command hint display
 */
public class hintDisplay implements Command {

	/**
	 * get the solution from model , put it to solution at the view
	 * starting the hint process on GUI. 
	 */
	@Override
	public void doCommand(String[] args, Model model, View view) throws IOException {
		view.setSolution(model.getSolution(model.getLastHint()));
		view.startHint();
	}

}
