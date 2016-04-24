package controller.Commands;

import Model.Imodel.Model;
import controller.Command;

public class display_cross_section implements Command {


	@Override
	public void doCommand(String[] args, Model model) {
		int[][] crossmaze;
		try{
			if(args[0]=="x"){
				crossmaze = model.displayCrossSectionByX(Integer.parseInt(args[1]), args[2]);
			}
			else if(args[0]=="y"){
				crossmaze = model.displayCrossSectionByY(Integer.parseInt(args[1]), args[2]);
			}
			else if (args[0]=="z"){
				crossmaze = model.displayCrossSectionByZ(Integer.parseInt(args[1]), args[2]);
			}
			
		}
		 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	
	}

}
