package Presenter.CommandsModel;


import Model.Imodel.Model;
import Model.algorithms.Search.Solution;
import Presenter.Command;
import View.View;

public class display_solution implements Command {
	/**
	 * display 3DMaze Solution
	 * @param args - Arguments - Name of the maze
	 * @param Model - Model of the Program
	 * @param view - View  of the Program
	 */
	@Override
	public void doCommand(String[] args, Model model ,View view) {
		if (args.length != 1 ){
	    	  view.displayMessage("Inncorrect number of Arguments\n");
	      	  return;
	      }
				try {
					Solution sol =model.getSolution(args[0]);
					view.setSolution(sol);
					view.displayMessage(sol.toString());
				} catch (NullPointerException e) {
		
					
				}catch (Exception e) {
					view.displayMessage(e.toString());
				}

	}

	

	

}
