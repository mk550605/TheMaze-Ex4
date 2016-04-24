package controller.Commands;

import java.io.IOException;

import Model.Imodel.Model;
import controller.Command;

public class maze_size_in_file implements Command{

	@Override
	public void doCommand(String[] args, Model model) throws IOException {
		model.getMazeSizeinFile(args[0]);
		
	}


	

}
