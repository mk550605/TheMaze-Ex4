package View.Gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import Presenter.Properties;


public class GenerateMazeWindow extends Dialog {
	private Properties properties;
	private String name =null;
//	private String cols = Integer.toString(this.properties.getNumOfCols());
//	private String rows = Integer.toString(properties.getNumOfRows());
//	private String floors = Integer.toString(properties.getNumOfFloors());

	private String cols = "41";
	private String rows = "41";
	private String floors = "1";
	private String result = "Cancel";
	/**
	 * @param prop 
	 * @param dialog
	 */
	public GenerateMazeWindow(Shell parent) {
		super(parent);
	}
	
	public void setProperties(Properties prop){
		this.properties = prop;
	}


//	protected Shell dialog;
	
	
	public String initWidgets() {
		Shell parent = getParent();
	    Shell dialog = new Shell(parent, SWT.DIALOG_TRIM
	        | SWT.APPLICATION_MODAL);	    
		dialog.setLayout(new GridLayout(2,false));
		dialog.setSize(250, 150);
		dialog.setText("Generate Maze");
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		Label labName = new Label(dialog, SWT.BOLD);
		labName.setText("Maze Name");
		labName.setVisible(true);
		GridData gd = new GridData ();
		gd.widthHint = 100;
		labName.setLayoutData (gd);
		Text txtName = new Text(dialog, SWT.BEGINNING);
		txtName.setText("Name of Maze");
		txtName.setLayoutData(gridData);
		Label labCols = new Label(dialog, SWT.BOLD);
		labCols.setText("num of cols");
		labCols.setVisible(true);
		Text txtCols = new Text(dialog, SWT.BEGINNING);
		txtCols.setText(cols);
		txtCols.setLayoutData(gridData);
		Label labRows = new Label(dialog, SWT.BOLD);
		labRows.setText("num of Rows");
		labRows.setVisible(true);
		Text txtRows = new Text(dialog, SWT.BEGINNING);
		txtRows.setText(rows);
		txtRows.setLayoutData(gridData);
		Label labFloors = new Label(dialog, SWT.BOLD);
		labFloors.setText("num of Floors");
		labFloors.setVisible(true);
		Text txtFloors = new Text(dialog, SWT.BEGINNING);
		txtFloors.setText(floors);
		txtFloors.setEnabled(true);
		txtFloors.setLayoutData(gridData);
		Button btnOK = new Button(dialog, SWT.PUSH);
		btnOK.setText("OK");
		Button btnCancel = new Button(dialog, SWT.PUSH);
		btnCancel.setText("Cancel");
		
		
		
		
			btnCancel.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				dialog.close();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnOK.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				 name = txtName.getText();
				 cols = txtCols.getText();
				 rows = txtRows.getText();
				 floors = txtFloors.getText();
				 dialog.close();
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		dialog.open();
		Display display = parent.getDisplay();
	    while (!dialog.isDisposed()) {
	      if (!display.readAndDispatch())
	        display.sleep();
	    }
	    return result;
	}

	
	
	public void run() {
		this.run();
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCols() {
		return cols;
	}


	public void setCols(String cols) {
		this.cols = cols;
	}


	public String getRows() {
		return rows;
	}


	public void setRows(String rows) {
		this.rows = rows;
	}


	public String getFloors() {
		return floors;
	}


	public void setFloors(String floors) {
		this.floors = floors;
	}
	
	
}
