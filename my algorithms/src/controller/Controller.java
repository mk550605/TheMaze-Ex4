package controller;

import java.util.HashMap;

import Model.Imodel.Model;
import View.Cli;
import View.View;

public interface Controller {
	public void setModel(Model model);
	public void setView (View view);
	public HashMap<String, Command> getCommandSet();
	public void handleUserCommand(String cmd, String[] args);

}
