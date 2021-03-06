package Presenter.CommandsModel;

import Model.Imodel.Model;
import Presenter.Command;
import View.View;

public class generate_3d_maze implements Command   {
	/**
	 * generate 3DMaze running in a separate Thread.
	 * @param args - Arguments - Name of the Maze , num of cols , num of rows , num of floors.
	 * @param Model - Model of the Program
	 * @param view - View  of the Program
	 */
	@Override
	public void doCommand(String[] args , Model model ,View view) {
		if (args.length != 4 ){
			view.displayMessage("Inncorrect number of Arguments\n");
			return;
		}
			try{
				model.generateMaze(args [0] ,  Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));	
				}
				 catch (Exception e) {
						view.displayMessage("Failed to Generate 3D Maze" + e.toString());
						 
					}

		
	}

	

}
