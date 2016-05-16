package Presenter.CommandsModel;

import Model.Imodel.Model;
import Presenter.Command;
import View.View;

public class display_cross_section implements Command {

	/**
	 * display Cross Section of the 3Dmaze as a 2D maze 
	 * chek the cross wanted by user.
	 * @param args - Arguments - crossSection , Section Number, 3DMaze Name.
	 * @param Model - Model of the Program
	 * @param view - View  of the Program
	 */
	@Override
	public void doCommand(String[] args, Model model ,View view) {
		int[][] crossmaze = null;
		if (args.length != 3 )
			throw new IllegalArgumentException("Inncorrect number of Arguments");
		try{
			if(args[0].equals("x")){
				crossmaze = model.displayCrossSectionByX(Integer.parseInt(args[1]), args[2]);
				
			}
			else if(args[0].equals("y")){
				crossmaze = model.displayCrossSectionByY(Integer.parseInt(args[1]), args[2]);
			}
			else if (args[0].equals("z")){
				crossmaze = model.displayCrossSectionByZ(Integer.parseInt(args[1]), args[2]);
			}
			StringBuilder sb = new StringBuilder();
				for (int i = 0; i < crossmaze[0].length; i++) {
					for (int j = 0; j < crossmaze.length; j++) {
						sb.append(crossmaze[j][i] + " ");
					}
					sb.append("\n");
				}
				sb.append("\n\n");
			view.displayMessage(sb.toString());
		}
		 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	
	}

}
