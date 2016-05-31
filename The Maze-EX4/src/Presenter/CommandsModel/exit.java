package Presenter.CommandsModel;

import Model.Imodel.Model;
import Presenter.Command;
import View.View;

public class exit implements Command {


private String Exit(){
	return "the Program Finished";
}
/**
 * check that no file or Threads are working and close the Program
 * @param args - Arguments - None
 * @param Model - Model of the Program
 * @param view - View  of the Program
 */
@Override
public void doCommand(String[] args, Model model ,View view) {
	model.Exit();
	view.displayMessage("\nsaving DB ...\n");
	model.saveHashMap();
	view.displayMessage("DB Saved\n");
	view.displayMessage(Exit());
}

}
