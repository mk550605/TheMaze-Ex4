package Presenter;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

import com.thoughtworks.xstream.XStream;

/**
 *Defines all the parameters for an XML file
 */
public class XmlSerializer {

	/**
	 * Saves settings to filePath
	 * @param filePath the place to save the file
	 * @param settings defines from where to take settings
	 * @throws IOException
	 */
	public static void saveSettings(String filePath, PropertiesInterface properties) throws IOException {
		XStream xStream = new XStream();
	    xStream.autodetectAnnotations(true);
	    xStream.alias(properties.getClassAlias(), properties.getClass()); 
	    
	    FileOutputStream outputStream = null;
	    Writer writer = null;

	    try {
	        outputStream = new FileOutputStream(filePath);
	        writer = new OutputStreamWriter(outputStream, Charset.forName("UTF-8"));
	        xStream.toXML(properties, writer);
	    }
	    finally {
	    	if (outputStream != null) {
	    		outputStream.close();
	    	}
	    	
	    	if (writer != null) {
	    		writer.close();
	    	}
	    }
	}
	
	/**
	 * 
	 * @param filePath the place to save the file
	 * @param settings for load from XML
	 * @return class of settings
	 * @throws IOException
	 */
	public static PropertiesInterface loadSettings(String filePath, PropertiesInterface properties) throws IOException {
		XStream xStream = new XStream();
		xStream.autodetectAnnotations(true);
		xStream.alias(properties.getClassAlias(), properties.getClass());
		
		FileReader reader = null;
	    
	    try {
	    	reader = new FileReader(filePath);
	    	return (PropertiesInterface)xStream.fromXML(reader);
	    }
	    finally {
	    	if (reader != null) {
	    		reader.close();
	    	}
	    }
	}
}
