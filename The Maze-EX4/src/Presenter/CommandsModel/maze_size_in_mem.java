package Presenter.CommandsModel;



import Model.Imodel.Model;
import Presenter.Command;
import View.View;

public class maze_size_in_mem implements Command{
	/**
	 * display 3DMaze object in a memory by bytes 
	 * @param args - Arguments - Name of the Maze
	 * @param Model - Model of the Program
	 * @param view - View  of the Program
	 */
	@Override
	public void doCommand(String[] args, Model model ,View view) {
		if (args.length != 1 ){
			view.displayMessage("Inncorrect number of Arguments");
			return;
		}	
		long size = model.getMazeSize(args[0]);
		if(size == 0)
			return;
		view.displayMessage(size + " bytes");
	}



	

}
