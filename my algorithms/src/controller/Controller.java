package controller;

import java.io.IOException;
import java.util.HashMap;

import Model.Imodel.Model;
import View.Cli;
import View.View;
/**
 *Interface for Controller  
 * @author Michael Kratik
 *@version 1.0
 *
 */
public interface Controller {
	public void setModel(Model model);
	public void setView (View view);
	public HashMap<String, Command> getCommandSet();
	public void handleUserCommand(String cmd, String[] args ) throws IOException;
}
