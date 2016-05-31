package View.Gui;

import javax.swing.text.Position;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;

import Model.algorithms.mazeGenerators.Maze3d;
import Presenter.Properties;
import Presenter.CommandsView.DisplayMazeGui;
import View.View;
import View.Gui.MazeDisplay.MazeDisplay;
import View.Gui.MazeDisplay.TwoDMazeDisplay;

public class MazeWindow extends basicWindow implements View{
	protected Properties prop ;
	private MazeDisplay mazeDisplay;
	Model.algorithms.mazeGenerators.Position pos;
	Composite buttonsGroup ;
	Button btnGenerateMaze;
	Button btnSolveMaze;
	Button btnDisplayMaze;
	
	public MazeWindow() {
			
		}

	@Override
	public void initWidgets() {
		GridLayout grid = new GridLayout(2, false);
		shell.setLayout(grid);
		buttonsGroup = new Composite(shell, SWT.BORDER);
		buttonsGroup.setLayout( new FillLayout(SWT.VERTICAL));
		buttonsGroup.setLayoutData(new GridData(SWT.LEAD, SWT.CENTER,false,true));
		btnGenerateMaze = new Button(buttonsGroup, SWT.PUSH);
		btnGenerateMaze.setText("Generate 3D Maze");
		btnSolveMaze = new Button(buttonsGroup, SWT.PUSH);
		btnSolveMaze.setText("Solve Maze");
		btnDisplayMaze = new Button(buttonsGroup, SWT.PUSH);
		btnDisplayMaze.setText("DisplayMaze");
		
		mazeDisplay = new TwoDMazeDisplay(shell, SWT.BORDER);
		mazeDisplay.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		btnGenerateMaze.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				GenerateMazeWindow generateWindow = new GenerateMazeWindow(shell  );
				generateWindow.setProperties(prop);
				generateWindow.initWidgets();
//				System.out.println("generate_3d_maze " + generateWindow.getName() + " " + generateWindow.getCols() 
//				 + " " + generateWindow.getRows() + " "+ generateWindow.getFloors());
				 setChanged();
				 notifyObservers("generate_3d_maze " + generateWindow.getName() + " " + generateWindow.getCols() 
				 + " " + generateWindow.getRows() + " "+ generateWindow.getFloors() );
				
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				
			}
		});
		
		
		
			btnDisplayMaze.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				String command ="display mic";
				setChanged();
				notifyObservers(command);
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		btnSolveMaze.addSelectionListener(new SelectionListener() {	
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				PopUpWindow solveWindow = new SolveMazeWindow();
				
				solveWindow.initWidgets();
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub	
			}
		}); 		
	}
	
	


	@Override
	public void displayMessage(String message) {
		display.syncExec(new Runnable() {
			
			@Override
			public void run() {
				MessageBox generateMB = new MessageBox(shell);
				generateMB.setMessage(message);
				generateMB.setText("System massage");
				generateMB.open();
			}
		});
		
		
	}

	@Override
	public void start() {
		this.run();	
	}

	@Override
	public void setProp(Properties p) {
		this.prop = p;
	}

	@Override
	public void displayMaze(Maze3d theMaze) {
		if (mazeDisplay == null){
			mazeDisplay = new TwoDMazeDisplay(shell,SWT.BORDER);
			mazeDisplay.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
		}
		pos =  theMaze.getStartPosition();
		int[][] mazeData = null ;
		try {
			mazeData =theMaze.getCrossSectionByZ(pos.z);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mazeDisplay.setMazeData(mazeData);
		mazeDisplay.redraw();
		
	}

	
}
