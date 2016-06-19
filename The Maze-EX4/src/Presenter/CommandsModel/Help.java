package Presenter.CommandsModel;



import Model.Imodel.Model;
import Presenter.Command;
import View.View;
/**
 * 
 * @author  Michael Kratik & Tzipi Cabiri
 *Help file for user 
 *helps to now what commands exist and there syntax.
 */
public class Help implements Command{

	@Override
	public void doCommand(String[] args, Model model, View view){
		view.displayMessage(helpFile());
	}
	
	
	private String helpFile(){
		return ("** dir- Show all the files and Directory in Path - dir path\n\n"
				+ "** generate a 3DMaze with My Algorithem - generate_3d_maze Name cols rows Floors \n\n"
				+ "** display a 3DMaze - display Name_of_maze \n\n"
				+ "** display Cross Section of 3DMaze - display_Cross_Section_by (x/y/z) Index n maze_name\n\n"
				+ "** save 3dMaze to file in Compress mode - save_maze Name\n\n"
				+ "** load 3Dmaze from file - load_maze name_of_file Name_of_maze\n\n"
				+ "** maze size in the memory - maze_size Name_of_maze \n\n"
				+ "** size of 3dMaze file - file_size Name_of_maze\n\n"
				+ "** solve the maze  with different algorithems - slove Name_of_maze algorithem_for_solvoing (dfs ,BestFS,BreadthFS )\n\n"
				+ "** display the maze solution - display_solution Name_of_maze\n\n"
				+ "** close all Threads and files and exit -exit\n\n");
		
	}
}
