package View.Gui.MazeDisplay;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

import Model.algorithms.mazeGenerators.Maze3d;
import Model.algorithms.mazeGenerators.Position;
/**
 *  @author Michael Kratik & Tzipi Cabiri
 * abstract class extends the canvas 
 * define the maze draw and all the moves on it.
 * 
 * 
 *
 */
public abstract class  MazeDisplay extends Canvas {
	
	protected abstract void drawMaze(PaintEvent e);
	protected int[][] mazeData;
	protected Maze3d themaze;
	protected GameCharacter character = new GameCharacter();
	protected TrophyImg trophy = new TrophyImg();
	protected String[] directions;
	protected abstract void goLeft();

	protected abstract void goRight();

	protected abstract void goForward();

	protected abstract void goBackward();

	protected abstract void goUp();
	
	public abstract void checkIfGoal(Position pos);

	public GameCharacter getCharacter() {
		return character;
	}

	protected abstract void goDown();

	public void setMaze (Maze3d theMaze){
		this.themaze = theMaze;
	}
	
	public void setMazeData (int[][] mazeData){
		this.mazeData =mazeData;
	}
	/**
	 * update the mazedata array when the character go up and down
	 */
	public void updateMazeDate(){
		try {
			this.mazeData = themaze.getCrossSectionByZ(character.getPos().z);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void setCharacterPosition(Position pos) {
		character.setPos(pos);
		}
	
	public void setTrophyPosition (Position pos){
		trophy.setPos(pos);
	}
	
	/**
	 * CTOR
	 * @param parent
	 * @param style
	 */
	public MazeDisplay(Composite parent, int style) {
		super(parent, style);
		this.addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				drawMaze(e);
				
			}
		});
		
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			/**
			 * keypressed handler
			 */
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.keyCode) {
				case SWT.ARROW_LEFT:
					goLeft();
					break;
				case SWT.ARROW_RIGHT:
					goRight();
					break;
				case SWT.ARROW_UP:
					goForward();
					break;
				case SWT.ARROW_DOWN:
					goBackward();
					break;
				case SWT.PAGE_UP:
					goUp();
					break;
				case SWT.PAGE_DOWN:
					goDown();
					break;

				// TODO: Finish this list
				}
				
			}
		});
		
	}
	
	
	
	

		
		
	}
	
	
	
