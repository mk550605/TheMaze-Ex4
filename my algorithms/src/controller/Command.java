package controller;

import java.io.IOException;

import Model.Imodel.Model;
import View.View;

public interface Command {
	public void doCommand(String[] args , Model model, View view) throws IOException;
}
