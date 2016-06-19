package View.Gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;

import Model.algorithms.Search.Solution;
import Model.algorithms.Search.State;
import Model.algorithms.mazeGenerators.Maze3d;
import Model.algorithms.mazeGenerators.Position;
import Presenter.Properties;
import View.View;
import View.Gui.MazeDisplay.MazeDisplay;
import View.Gui.MazeDisplay.TwoDMazeDisplay;
/**
 * @author Michael Kratik & Tzipi Cabiri
 *  Maze gui main window
 * define all the main window of the GUI
 * 
 *
 */
public class MazeWindow extends basicWindow implements View{
	protected Properties prop ;
	private MazeDisplay mazeDisplay;
	protected Position startPos;
	protected Position goalPos;
	private Composite buttonsGroup ;
	private Button btnGenerateMaze;
	private Button btnSolveMaze;
	private Button btnDisplayMaze;
	private Button btnExit;
	private Button btnHint;
	private Button btnSettings;
	protected String listOfMazes;
	private Solution mazeSolution;
	private String DisplaedMaze;
	
	/**
	 * CTOR
	 */
	public MazeWindow() {
			
		}
	/**
	 * Init function of the window 
	 * define all the buttons groups and behavior.
	 */
	@Override
	public void initWidgets() {
		
		// listener of the red X . 
		shell.addListener(SWT.Close, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				int style = SWT.APPLICATION_MODAL | SWT.YES | SWT.NO;
	            MessageBox messageBox = new MessageBox(shell, style);
	            messageBox.setText("Exit");
	            messageBox.setMessage("Close the 3DMaze? All your information will be Lost");
	            event.doit = messageBox.open() == SWT.YES;
			}
		});
		
		// menu starts
		
		Menu m = new Menu(shell, SWT.BAR);
	    MenuItem file = new MenuItem(m, SWT.CASCADE);
	    file.setText("File");
	    Menu filemenu = new Menu(shell, SWT.DROP_DOWN);
	    file.setMenu(filemenu);
	    MenuItem SettingsItem = new MenuItem(filemenu, SWT.PUSH);
	    SettingsItem.setText("Setting");
	    MenuItem exitItem = new MenuItem(filemenu, SWT.PUSH);
	    exitItem.setText("Exit");
	    shell.setMenuBar(m);
	    
	    SettingsItem.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				uptadeXML();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	    
	    exitItem.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				exit();
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		// menu ends
	    
	    
		// button and grid for main window
	    shell.setText("Maze 3D Java Project");
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
		btnSettings = new Button(buttonsGroup, SWT.PUSH);
		btnSettings.setText("Settings");
		btnExit = new Button(buttonsGroup, SWT.PUSH);
		btnExit.setText("Exit");
		// button ends.
		
		//Canvas Display maze
		mazeDisplay = new TwoDMazeDisplay(shell, SWT.BORDER);
		mazeDisplay.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		
		// Button Selection Listeners
		
		btnGenerateMaze.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				GenerateMazeWindow generateWindow = new GenerateMazeWindow(shell  );
				generateWindow.initWidgets(prop);
				if ( generateWindow.ok ==1){
					 setChanged();
					 notifyObservers("generate_3d_maze " + generateWindow.getName() + " " + generateWindow.getCols() 
					 + " " + generateWindow.getRows() + " "+ generateWindow.getFloors() );
				}
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
				if (displayMazeWindow.ok ==1){
					setChanged();
					DisplaedMaze = displayMazeWindow.getSelectedName();
					notifyObservers("display " + DisplaedMaze);
				}
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
				if(solveWindow.ok == 1 ){
					setChanged();
					notifyObservers("solve "+ solveWindow.getMazeName() + " " + solveWindow.SelectedAlgo);
			
				}
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub	
			}
		}); 
		
		btnHint.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				Position curpos = mazeDisplay.getCharacter().getPos();
				setChanged();
				notifyObservers("hint " + DisplaedMaze + " " + curpos.x +
						" " +curpos.y + " " + curpos.z) ;
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnSettings.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				uptadeXML();
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnExit.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				exit();
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}
	
	/**
	 * Exit from Program function 
	 * notify the presenter and close the window.
	 */
	private void exit(){
		setChanged();
		notifyObservers("exit");
		shell.dispose();
	}
	
	/**
	 * starts the Settings window and notify the observers to load the new XML
	 */
	private void uptadeXML(){
		SettingWindow settingswindow = new SettingWindow(shell);
		settingswindow.initWidgets(prop);
		if (settingswindow.ok == 1){
			setChanged();
			notifyObservers("updatexml");
		}
	}
	
	/**
	 * popup a messagebox in sync execution 
	 */
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
	
	/**
	 * start the main window
	 */
	@Override
	public void start() {
		this.run();	
	}

	@Override
	public void setProp(Properties p) {
		this.prop = p;
	}

	/**
	 * Displaying the maze at his place of the GUI
	 * @param the maze to display
	 */
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

	/**
	 * setter for list of mazes
	 */
	@Override
	public void setlistOfMazes(String listOfMazes) {
		this.listOfMazes = listOfMazes;
		
	}
	
	/**
	 * setter for solution of the maze
	 */
	@Override
	public void setSolution(Solution sol) {
		this.mazeSolution = sol;
	}

	/**
	 * hint for the maze solution 
	 * show the way to the trophy from the current location 
	 * redraw the character every 500 mili sec.
	 * 
	 */
	@Override
	public void startHint() {
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(State s : mazeSolution.getStates()){
					Position oldPos = mazeDisplay.getCharacter().getPos();
					mazeDisplay.setCharacterPosition(stateToPos(s.getDescription()));
					if(oldPos.z !=mazeDisplay.getCharacter().getPos().z){
						mazeDisplay.updateMazeDate();
					}
					display.syncExec(new Runnable() {	
						@Override
						public void run() {
							mazeDisplay.redraw();
							mazeDisplay.checkIfGoal(mazeDisplay.getCharacter().getPos());							
						}
						
					});
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		t.start();
	}
	
	/**
	 * transfer from state description to position
	 * @param State stateDes
	 * @return
	 */
	private Position stateToPos(String stateDes){
		stateDes = stateDes.replace("{", "");
		stateDes = stateDes.replace("}","");
		String[] newstr = stateDes.split(",");
		Position pos = new Position(Integer.parseInt(newstr[0]),
				Integer.parseInt(newstr[1]),Integer.parseInt(newstr[2]));
		return pos;
		
	}

	
}
