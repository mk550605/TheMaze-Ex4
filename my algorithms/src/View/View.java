package View;

import java.io.IOException;
import java.util.HashMap;

import controller.Command;

public interface View {
	void start() throws IOException;
	void print(Object textToPrint);
}
