package controller.Commands;

import java.io.IOException;

import Model.Imodel.Model;
import View.View;
import controller.Command;

public class maze_size_in_file implements Command{
	/**
	 * display 3DMaze object in a file by bytes 
	 * @param args - Arguments - Name of the Maze
	 * @param Model - Model of the Program
	 * @param view - View  of the Program
	 */
	@Override
	public void doCommand(String[] args, Model model ,View view) throws IOException {
		if (args.length != 1 )
			throw new IllegalArgumentException("Inncorrect number of Arguments");
		double size = model.getMazeSizeinFile(args[0]);
		view.print(size + " bytes");
	}


	

}
