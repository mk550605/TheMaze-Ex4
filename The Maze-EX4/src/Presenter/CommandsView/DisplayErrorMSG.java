package Presenter.CommandsView;

import java.io.IOException;

import Model.Imodel.Model;
import Presenter.Command;
import View.View;
/**
 * 
 * @author Michael Kratik & Tzipi Cabiri
 *display the Error MSG on GUI
 */
public class DisplayErrorMSG implements Command {
	/**
	 * display the Error MSG on GUI
	 */
	@Override
	public void doCommand(String[] args, Model model, View view) throws IOException {
		view.displayMessage(model.getError());
	}

}
