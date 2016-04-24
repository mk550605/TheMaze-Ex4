package controller.Commands;

import java.io.File;

import Model.Imodel.Model;
import controller.Command;

public class dir implements Command{



	@Override
	public void doCommand(String[] args , Model model) {
		File f = null;
	      File[] paths;
	      
	      try{      
	         // create new file
	         f = new File(args[0]);
	    	  //f = new File("c:/");
	         // returns pathnames for files and directory
	         paths = f.listFiles();
	         
	         // for each pathname in pathname array
	         for(File path:paths)
	         {
	            // prints file and directory paths
	            System.out.println(path);
	         }
	      }catch(Exception e){
	         // if any error occurs
	        
	         System.out.println("\nNo sach Directory, please try again\n");
	      }
		
	}

}
