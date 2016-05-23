package View.Gui;

import java.util.Observable;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public abstract class basicWindow extends Observable implements Runnable{

	protected Display display;
	protected Shell shell;
	
	public basicWindow() {
		this.display = new Display();
		this.shell = new Shell();
	}
	
	public abstract void initWidgets();
	
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
