package IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyDecompressorInputStream extends InputStream {

	private InputStream in;
	
	public MyDecompressorInputStream(InputStream in) {
		this.in = in;
	}

	
	@Override
	public int read(byte[] byteArray) throws IOException {
		int counter = 0;
		int count;
		byte data;
		while ((data = (byte) in.read())!=-1){
			count = in.read();
			if (counter == 0)
				count--;
			for(int i=0 ; i<count;i++){
				byteArray[counter] = data;
				counter++;
			}
		}
		return 0;
	}


	@Override
	public int read() throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

}