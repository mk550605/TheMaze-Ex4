package View.Gui;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import Presenter.Properties;
import Presenter.XmlSerializer;

public class SettingWindow extends Dialog {
	private String[] Algotithem = { "Dfs", "Bestfs", "BreadthFS" };
	public int ok = 0;
	private Properties properties;
	private Text numOfCols;
	private Text numOfRows;
	private Text numOfFloors;
	private Text numOfThreads;
	private Combo AlgorithmForMazeSolution;
	private Text straightMoveScore;
	
	private Label lblnumOfCols;
	private Label lblnumOfRows;
	private Label lblnumOfFloors;
	private Label lblnumOfThreads;
	private Label lblAlgorithmForMazeSolution;
	private Label lblstraightMoveScore;
	 
	
	public SettingWindow(Shell parent) {
		super(parent);
		// TODO Auto-generated constructor stub
	}
	
	public void initWidgets(Properties prop) {
		this.properties = prop;
		Shell parent = getParent();
	    Shell dialog = new Shell(parent, SWT.DIALOG_TRIM
	        | SWT.APPLICATION_MODAL);	    
		dialog.setLayout(new GridLayout(2,false));
		dialog.setSize(200, 240);
		dialog.setText("Properties");
		GridData gridData = new GridData();
		gridData.widthHint = 80;
		gridData.heightHint =20;
		lblnumOfCols = new Label(dialog, SWT.BOLD);
		lblnumOfCols.setText("num of cols");
		lblnumOfCols.setVisible(true);
		numOfCols = new Text(dialog, SWT.BEGINNING);
		numOfCols.setLayoutData(gridData);
		numOfCols.setText(Integer.toString(properties.getNumOfCols()));
		
		lblnumOfRows = new Label(dialog, SWT.BOLD);
		lblnumOfRows.setText("num of rows");
		lblnumOfRows.setVisible(true);
		numOfRows = new Text(dialog, SWT.BEGINNING);
		numOfRows.setLayoutData(gridData);
		numOfRows.setText(Integer.toString(properties.getNumOfRows()));
		
		lblnumOfFloors = new Label(dialog, SWT.BOLD);
		lblnumOfFloors.setText("num of floors");
		lblnumOfFloors.setVisible(true);
		numOfFloors = new Text(dialog, SWT.BEGINNING);
		numOfFloors.setLayoutData(gridData);
		numOfFloors.setText(Integer.toString(properties.getNumOfFloors()));
		
		lblnumOfThreads = new Label(dialog, SWT.BOLD);
		lblnumOfThreads.setText("num of Threads");
		lblnumOfThreads.setVisible(true);
		numOfThreads = new Text(dialog, SWT.BEGINNING);
		numOfThreads.setLayoutData(gridData);
		numOfThreads.setText(Integer.toString(properties.getNumOfThreads()));
		
		lblAlgorithmForMazeSolution = new Label(dialog, SWT.BOLD);
		lblAlgorithmForMazeSolution.setText("sol Algorithm");
		lblAlgorithmForMazeSolution.setVisible(true);
		AlgorithmForMazeSolution = new Combo(dialog, SWT.None);
		AlgorithmForMazeSolution.setLayoutData(gridData);
		AlgorithmForMazeSolution.setItems(Algotithem);
		AlgorithmForMazeSolution.select(1);
		
		lblstraightMoveScore = new Label(dialog, SWT.BOLD);
		lblstraightMoveScore.setText("Movment Score");
		lblstraightMoveScore.setVisible(true);
		straightMoveScore = new Text(dialog, SWT.BEGINNING);
		straightMoveScore.setLayoutData(gridData);
		straightMoveScore.setText(Integer.toString(properties.getStraightMoveScore()));
		
		GridData bgd = new GridData ();
		bgd.widthHint = 80;
		bgd.heightHint =25;
		Button btnOK = new Button(dialog, SWT.PUSH);
		btnOK.setText("OK");
		btnOK.setLayoutData(bgd);
		Button btnCancel = new Button(dialog, SWT.PUSH);
		btnCancel.setText("Cancel");
		btnCancel.setLayoutData(bgd);
		
		
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
				Presenter.Properties prop = new Presenter.Properties(Integer.parseInt(numOfCols.getText()), Integer.parseInt(numOfRows.getText()),
								Integer.parseInt(numOfFloors.getText()), Integer.parseInt(numOfThreads.getText()),
								Algotithem[AlgorithmForMazeSolution.getSelectionIndex()] , Integer.parseInt(straightMoveScore.getText()) );
				XmlSerializer xml = new XmlSerializer();
				try {
					xml.saveSettings("config.xml", prop);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				dialog.dispose();
			
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
	}

}
