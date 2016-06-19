package View.Gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
/**
 * @author Michael Kratik & Tzipi Cabiri
 * Solve Maze gui window
 * getting information from user about what maze to solve with what alogo
 * 
 *
 */
public class SolveMazeWindow extends Dialog {
	/**
	 * CTOR
	 */
	public SolveMazeWindow(Shell parent) {
		super(parent);
		// TODO Auto-generated constructor stub
	}
	public int ok =0;
	private String[] mazeName;
	private String[] Algotithem = { "Dfs", "Bestfs", "BreadthFS" };
	int SelectedName;
	int SelectedAlgo;
	
	public String getMazeName() {
		return mazeName[SelectedName];
	}

	public String getAlgotithem() {
		return Algotithem[SelectedAlgo];
	}

	
	/**
	 * init the window 
	 * define the label and text on screen
	 * define two buttons of ok and cancel
	 * Handle the buttons push
	 * @param listOfMazes- for selecting the maze.
	 */
	public void initWidgets(String listOfMazes) {
		Shell parent = getParent();
	    Shell popUpShell = new Shell(parent, SWT.DIALOG_TRIM
	        | SWT.APPLICATION_MODAL);	    
		mazeName = listOfMazes.split(" ");
		popUpShell.setLayout(new GridLayout(4,false));
		popUpShell.setSize(600, 200);
		popUpShell.setText("Solve Maze");
		Label labName = new Label(popUpShell, SWT.BOLD);
		labName.setText("Maze name");
		GridData gd = new GridData ();
		gd.widthHint = 100;
		labName.setLayoutData (gd);
		labName.setVisible(true);
		Combo comboMazes = new Combo(popUpShell, SWT.NONE);
		comboMazes.setItems(mazeName);
		comboMazes.select(0);
		Label labAlgo = new Label(popUpShell, SWT.BOLD);
		labAlgo.setText("Select Algorithem");
		GridData gdAlgo = new GridData ();
		gdAlgo.widthHint = 100;
		labAlgo.setLayoutData (gdAlgo);
		labAlgo.setVisible(true);
		Combo comboAlgorithms = new Combo(popUpShell, SWT.NONE);
		comboAlgorithms.setItems(Algotithem );
		comboAlgorithms.select(1);
		Button btnOK = new Button(popUpShell, SWT.PUSH);
		btnOK.setText("OK");
		Button btnCancel = new Button(popUpShell, SWT.PUSH);
		btnCancel.setText("Cancel");
		popUpShell.open();
		
		
		
		btnCancel.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				popUpShell.close();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		btnOK.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				SelectedAlgo = comboAlgorithms.getSelectionIndex();
				SelectedName = comboMazes.getSelectionIndex();
				popUpShell.close();
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		popUpShell.open();
		Display display = parent.getDisplay();
	    while (!popUpShell.isDisposed()) {
	      if (!display.readAndDispatch())
	        display.sleep();
	    }
	    return ;

	}

	
	
	
	

}
