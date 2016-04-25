package controller.Commands;

import Model.Imodel.Model;
import View.View;
import controller.Command;

public class generate_3d_maze implements Command {

	@Override
	public void doCommand(String[] args , Model model ,View view) {
		
		try{
			model.generateMaze(args [0] ,  Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));	
		}
		 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		view.print("The maze is generated");
		
	}

	

}
