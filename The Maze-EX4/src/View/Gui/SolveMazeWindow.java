package View.Gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;

public class SolveMazeWindow extends PopUpWindow {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initWidgets() {
		popUpShell.setLayout(new GridLayout(4,false));
		popUpShell.setSize(300, 100);
		popUpShell.setText("Solve Maze");
		Label labName = new Label(popUpShell, SWT.BOLD);
		labName.setText("Maze name");
		GridData gd = new GridData ();
		gd.widthHint = 100;
		labName.setLayoutData (gd);
		labName.setVisible(true);
		Combo comboMazes = new Combo(popUpShell, SWT.NONE);
		comboMazes.setItems(new String[] { "A-1", "B-1", "C-1" });
		Label labAlgo = new Label(popUpShell, SWT.BOLD);
		labAlgo.setText("Select Algorithem");
		GridData gdAlgo = new GridData ();
		gdAlgo.widthHint = 100;
		labAlgo.setLayoutData (gdAlgo);
		labAlgo.setVisible(true);
		Combo comboAlgorithms = new Combo(popUpShell, SWT.NONE);
		comboAlgorithms.setItems(new String[] { "Dfs", "Bestfs", "BreadthFS" });
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
	}
	
	
	

}
