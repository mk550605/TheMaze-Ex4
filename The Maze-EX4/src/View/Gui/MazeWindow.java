package View.Gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.MessageBox;

import Model.algorithms.Search.Solution;
import Model.algorithms.mazeGenerators.Maze3d;
import Model.algorithms.mazeGenerators.Position;
import Presenter.Properties;
import View.View;
import View.Gui.MazeDisplay.MazeDisplay;
import View.Gui.MazeDisplay.TwoDMazeDisplay;

public class MazeWindow extends basicWindow implements View{
	protected Properties prop ;
	private MazeDisplay mazeDisplay;
	protected Position startPos;
	protected Position goalPos;
	Composite buttonsGroup ;
	private Button btnGenerateMaze;
	private Button btnSolveMaze;
	private Button btnDisplayMaze;
	private Button btnExit;
	private Button btnHint;
	protected String listOfMazes;
	private Solution mazeSolution;
	private String DisplaedMaze;
	
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
		btnHint = new Button(buttonsGroup, SWT.PUSH);
		btnHint.setText("Hint");
		btnExit = new Button(buttonsGroup, SWT.PUSH);
		btnExit.setText("Exit");
		
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
				DisplayMazeWindow displayMazeWindow = new DisplayMazeWindow(shell); 
				displayMazeWindow.initWidgets(listOfMazes);
				setChanged();
				DisplaedMaze = displayMazeWindow.getSelectedName();
				notifyObservers("display " + DisplaedMaze);
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		btnSolveMaze.addSelectionListener(new SelectionListener() {	
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				
				SolveMazeWindow solveWindow = new SolveMazeWindow(shell);
				solveWindow.initWidgets(listOfMazes);
				setChanged();
				notifyObservers("solve "+ solveWindow.getMazeName() + " " + solveWindow.SelectedAlgo);
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub	
			}
		}); 
		
		btnHint.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				setChanged();
				notifyObservers("display_solution " + DisplaedMaze);
				for (int i = 0 ; i <mazeSolution.getSize(); i++){
				
//					mazeDisplay.setCharacterPosition(pos);
				}
				
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		btnExit.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				setChanged();
				notifyObservers("exit");
				shell.dispose();
				
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
		startPos =  theMaze.getStartPosition();
		goalPos = theMaze.getGoalPosition();
		int[][] mazeData = null ;
		try {
			mazeData =theMaze.getCrossSectionByZ(startPos.z);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mazeDisplay.setMazeData(mazeData);
		mazeDisplay.setMaze(theMaze);
		mazeDisplay.setCharacterPosition(new Position(startPos.x, startPos.y, startPos.z));
		mazeDisplay.setTrophyPosition(new Position(goalPos.x, goalPos.y, goalPos.z));
		mazeDisplay.redraw();
	}

	@Override
	public void setlistOfMazes(String listOfMazes) {
		this.listOfMazes = listOfMazes;
		
	}

	@Override
	public void setSolution(Solution sol) {
		this.mazeSolution = sol;
	}

	
}
