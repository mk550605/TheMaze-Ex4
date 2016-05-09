package controller.Commands;

import java.io.IOException;

import Model.Imodel.Model;
import View.View;
import controller.Command;

public class Help implements Command{

	@Override
	public void doCommand(String[] args, Model model, View view) throws IOException {
		view.print(helpFile());
	}
	
	
	private String helpFile(){
		return ("** dir- Show all the files and Directory in Path - dir <path>\n\n"
				+ "** generate a 3DMaze with My Algorithem - generate 3d maze <Name of maze> <cols> <rows> <Floors> \n\n"
				+ "** display a 3DMaze - display <Name of maze> \n\n"
				+ "** display Cross Section of 3DMaze - display Cross Section <x/y/z> <Index in the Maze> <Name of maze>\n\n"
				+ "** save 3dMaze to file in Compress mode - save maze <Name of maze>\n\n"
				+ "** load 3Dmaze from file - load maze <name of file> <Name of maze>\n\n"
				+ "** maze size in the memory - maze size <Name of maze> \n\n"
				+ "** size of 3dMaze file - file size <Name of maze>\n\n"
				+ "** solve the maze  with different algorithems - slove <Name of maze> <algorithem for solvoing (dfs ,BestFS,BreadthFS )\n\n"
				+ "** display the maze solution - display solution <Name of maze>\n\n"
				+ "** close all Threads and files and exit -exit\n\n");
		
	}
}
