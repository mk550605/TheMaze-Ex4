package controller;

import java.io.IOException;

import Model.Imodel.Model;
import View.View;
/**
 *Interface for Command  
 * @author Michael Kratik
 *@version 1.0
 *
 */
public interface Command {
	public void doCommand(String[] args , Model model, View view) throws IOException;
}
