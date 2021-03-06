package View;

import java.io.IOException;
import java.util.HashMap;

import controller.Command;
/**
 * Interface for View
 * @author Michael Kratik & Tzipi Cabiri 
 * @version 1.0
 *
 */
public interface View {
	void start() throws IOException;
	void print(Object textToPrint);
}
