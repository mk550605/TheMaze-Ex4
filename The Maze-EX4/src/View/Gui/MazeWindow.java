package View.Gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;

import View.View;

public class MazeWindow extends basicWindow implements View{
		
	@Override
	public void initWidgets() {
		
		GridLayout grid = new GridLayout(2, false);
		shell.setLayout(grid);
		Composite buttonsGroup = new Composite(shell, SWT.BORDER);
		buttonsGroup.setLayout( new FillLayout(SWT.VERTICAL));
		buttonsGroup.setLayoutData(new GridData(SWT.LEAD, SWT.CENTER,false,true));
		Button btnGenerateMaze = new Button(buttonsGroup, SWT.PUSH);
		btnGenerateMaze.setText("Generate 3D Maze");
		Button btnSolveMaze = new Button(buttonsGroup, SWT.PUSH);
		btnSolveMaze.setText("Solve Maze");
		btnGenerateMaze.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				MessageBox generateMB = new MessageBox(shell);
				generateMB.setMessage("Generate 3D Maze");
				generateMB.setText("enter name and Size");
				generateMB.open();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

	@Override
	public void displayMessage(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start() {
		this.run();
		
	}

}
