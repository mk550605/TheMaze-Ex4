package View.Gui;

import java.util.Observable;
import java.util.Observer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 *  @author Michael Kratik & Tzipi Cabiri
 *	basic window of GUI 
 * 
 *
 */
public abstract class basicWindow extends Observable implements Runnable {

	protected Display display;
	protected Shell shell;
	
	/**
	 * CTOR
	 * create the display and the shell
	 */
	public basicWindow() {
		this.display = new Display();
		this.shell = new Shell(display);
	}
	
	public abstract void initWidgets();
	
	/**
	 * run the shell of GUI
	 */
	@Override
	public void run() {
		initWidgets();
		
		shell.open();
		 while(!shell.isDisposed()){ // window isn't closed
			  if(!display.readAndDispatch()){
			   display.sleep();
			  }
			 }
			 display.dispose();

	}
	
	

	
}
