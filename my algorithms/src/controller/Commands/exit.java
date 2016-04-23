package controller.Commands;

import controller.Command;

public class exit implements Command {

	@Override
	public void doCommand(String[] args) {
		Exit();	
	}

private String Exit(){
	return " the Program Finished";
}

}
