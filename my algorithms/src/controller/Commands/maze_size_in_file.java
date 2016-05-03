package controller.Commands;

import java.io.IOException;

import Model.Imodel.Model;
import View.View;
import controller.Command;

public class maze_size_in_file implements Command{

	@Override
	public void doCommand(String[] args, Model model ,View view) throws IOException {
		if (args.length != 1 )
			throw new IllegalArgumentException("Inncorrect number of Arguments");
		double size = model.getMazeSizeinFile(args[0]);
		view.print(size + " bytes");
	}


	

}
