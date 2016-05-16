package View;

import java.io.IOException;
import java.util.HashMap;

import Presenter.Command;
/**
 * Interface for View
 * @author Michael Kratik & Tzipi Cabiri 
 * @version 1.0
 *
 */
public interface View {
	void displayMessage(String message);
	void start();	
}
