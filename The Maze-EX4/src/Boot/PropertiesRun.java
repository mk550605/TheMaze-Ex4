package Boot;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import com.thoughtworks.xstream.XStream;

import Presenter.XmlSerializer;


public class PropertiesRun {

	public static void main(String[] args) {
		Presenter.Properties prop = new Presenter.Properties(11, 11, 11, 20, "myMaze3dGenerator", "Bestfs", 10, "up", "down", "left", "right", "forward", "backwards");
		XmlSerializer xml = new XmlSerializer();
		try {
			xml.saveSettings("config.xml", prop);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
