package View.Gui;

import java.util.Observable;

import org.eclipse.swt.widgets.Shell;

public abstract class PopUpWindow implements Runnable {	

			protected Shell popUpShell;
			protected StringBuilder listOfMazes;
			
			/**
			 * @param shell
			 */
			public PopUpWindow() {
				this.popUpShell = new Shell();
			}
		
			public abstract void initWidgets();
			

}
