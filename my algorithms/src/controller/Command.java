package controller;

import java.io.IOException;

import Model.Imodel.Model;

public interface Command {
	public void doCommand(String[] args , Model model) throws IOException;
}
