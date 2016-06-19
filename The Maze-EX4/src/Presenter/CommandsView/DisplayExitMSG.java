package Presenter.CommandsView;

import java.io.IOException;

import Model.Imodel.Model;
import Presenter.Command;
import View.View;
/**
 * 
 * @author Michael Kratik & Tzipi Cabiri
 *display the exit MSG on GUI
 */

public class DisplayExitMSG implements Command {
	
	/**
	 * display the exit MSG on GUI
	 */
	@Override
	public void doCommand(String[] args, Model model, View view) throws IOException {
		view.displayMessage(model.getExitMSG());

	}

}
