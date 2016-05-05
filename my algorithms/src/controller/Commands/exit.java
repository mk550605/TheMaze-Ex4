package controller.Commands;

import java.io.IOException;

import Model.Imodel.Model;
import View.View;
import controller.Command;

public class exit implements Command {
Boolean	ThraedClosed =false; 

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

	view.print(Exit());
}

}
