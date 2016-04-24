package controller.Commands;

import java.io.IOException;

import Model.Imodel.Model;
import controller.Command;

public class exit implements Command {


private String Exit(){
	return " the Program Finished";
}

@Override
public void doCommand(String[] args, Model model) throws IOException {
	Exit();
	
}

}
