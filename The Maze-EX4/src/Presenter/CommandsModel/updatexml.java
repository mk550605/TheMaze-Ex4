package Presenter.CommandsModel;

import java.io.IOException;

import Model.Imodel.Model;
import Presenter.Command;
import View.View;
/**
 * 
 *@author Michael Kratik & Tzipi Cabiri
 * load the new xml file to model
 *
 */
public class updatexml implements Command {
/**
 * 	load the new xml file to model
 */
	@Override
	public void doCommand(String[] args, Model model, View view) throws IOException {
		model.updatexml();

	}

}
