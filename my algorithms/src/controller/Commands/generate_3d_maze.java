package controller.Commands;

import Model.Imodel.Model;
import View.View;
import controller.Command;

public class generate_3d_maze implements Command {

	@Override
	public void doCommand(String[] args , Model model ,View view) {
		if (args.length != 4 )
			throw new IllegalArgumentException("Inncorrect number of Arguments");
		Thread generateThread = new Thread(new  Runnable() {
			public void run() {
				try{
					model.generateMaze(args [0] ,  Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));	
				}
				 catch (Exception e) {
						// TODO Auto-generated catch block
						view.print(e); 
					}
				view.print("The maze " + args[0] + " is generated");	
			}
		});
		
		generateThread.start();
	}

	

}
