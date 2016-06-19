package Presenter.CommandsView;

import java.io.IOException;

import Model.Imodel.Model;
import Presenter.Command;
import View.View;
/**
 * 
 * @author Michael Kratik & Tzipi Cabiri
 *display the solution MSG on GUI
 */
public class DisplaySolutionMSG implements Command {
	
	/**
	 * display the solution MSG on GUI
	 */
	@Override
	public void doCommand(String[] args, Model model, View view) throws IOException {
		view.displayMessage(model.getSolutionMSG());

	}

}
