package Presenter.CommandsModel;



import Model.Imodel.Model;
import Presenter.Command;
import View.View;

public class maze_size_in_file implements Command{
	/**
	 * display 3DMaze object in a file by bytes 
	 * @param args - Arguments - Name of the Maze
	 * @param Model - Model of the Program
	 * @param view - View  of the Program
	 */
	@Override
	public void doCommand(String[] args, Model model ,View view){
		if (args.length != 1 ){
			view.displayMessage("Inncorrect number of Arguments\n");
			return;
		}
		try {
			double size = model.getMazeSizeinFile(args[0]);
			view.displayMessage(size + " bytes");
		} catch (Exception e) {
			view.displayMessage("Error in find Maze size in file" + e.toString());
		}
	}


	

}
