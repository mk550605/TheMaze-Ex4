package Presenter.CommandsModel;

import java.io.IOException;

import Model.Imodel.Model;
import Presenter.Command;
import View.View;

public class exit implements Command {


private String Exit(){
	return " the Program Finished";
}
/**
 * check that no file or Threads are working and close the Program
 * @param args - Arguments - None
 * @param Model - Model of the Program
 * @param view - View  of the Program
 */
@Override
public void doCommand(String[] args, Model model ,View view) throws IOException {
	model.Exit();
	view.displayMessage(Exit());
}

}
