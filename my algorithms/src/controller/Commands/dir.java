package controller.Commands;

import java.io.File;

import Model.Imodel.Model;
import View.View;
import controller.Command;

public class dir implements Command{


/**
 * display all the files and directory in the path given in the arguments
 * @param args - Arguments - Path
 * @param Model - Model of the Program
 * @param view - View  of the Program
 */
	@Override
	public void doCommand(String[] args , Model model  ,View view) {
		File f = null;
	      File[] paths;
	      if (args.length != 1 )
				throw new IllegalArgumentException("Inncorrect number of Arguments");
	      try{  
	    	  if (args[0].equals("null")){
					throw new IllegalArgumentException("Inncorrect number of Arguments");
	    	  } 
			// create new file
	         f = new File(args[0]);
	    	  //f = new File("c:/");
	         // returns pathnames for files and directory
	         paths = f.listFiles();
	         
	         // for each pathname in pathname array
	         for(File path:paths)
	         {
	            // prints file and directory paths
	            view.print(path);
	         }
	      }catch(Exception e){
	         // if any error occurs
	        
	        view.print("\nNo sach Directory, please try again\n");
	      }
		
	}

}
