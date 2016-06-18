package View.Gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class DisplayMazeWindow extends org.eclipse.swt.widgets.Dialog {

	private String[] mazeName;
	private String selectedName;
	public int ok = 0;
	
	
	public DisplayMazeWindow(Shell parent) {
		super(parent);
		// TODO Auto-generated constructor stub
	}
	public void initWidgets(String listOfMazes) {
		Shell parent = getParent();
	    Shell popUpShell = new Shell(parent, SWT.DIALOG_TRIM
	        | SWT.APPLICATION_MODAL);	    
		mazeName = listOfMazes.split(" ");
		popUpShell.setLayout(new GridLayout(2,true));
		popUpShell.setSize(250, 100);
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
		Button btnOK = new Button(popUpShell, SWT.PUSH);
		btnOK.setText("OK");
		Button btnCancel = new Button(popUpShell, SWT.PUSH);
		btnCancel.setText("Cancel");
//		popUpShell.open();
		
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
				selectedName = mazeName[comboMazes.getSelectionIndex()];
				ok = 1;
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
	public String getSelectedName() {
		return selectedName;
	}
	
}
