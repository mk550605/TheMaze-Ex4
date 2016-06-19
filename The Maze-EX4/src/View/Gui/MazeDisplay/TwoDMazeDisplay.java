package View.Gui.MazeDisplay;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import Model.algorithms.mazeGenerators.Position;
import View.View;
/**
 * 
 *  @author Michael Kratik & Tzipi Cabiri
 *  define the GUIView of the maze
 *  
 *
 */
public class TwoDMazeDisplay extends MazeDisplay {
	private String[] updown;
	private Position newPos ;
	private Position p ;
	private int count =0;
	
	/**
	 * CTOR
	 * @param parent
	 * @param style
	 */
	public TwoDMazeDisplay(Composite parent, int style) {
		super(parent, style);
		setBackground(new Color(null, 255,255,255));
	}

	/**
	 * drawing the maze 
	 * find all the walls and the updown places and give them a unic color
	 * placing the character and the trophy 
	 */
	@Override
	protected void drawMaze(PaintEvent e ) {
		if (mazeData == null)
			return;
		e.gc.setForeground(new Color(null,0,0,0));
		e.gc.setBackground(new Color(null,0,0,0));
		
		   int width=getSize().x;
		   int height=getSize().y;
		   int cellWidth=width/mazeData[0].length;
		   int cellHeight=height/mazeData.length;
		   for(int i=0;i<mazeData[0].length;i++)
		      for(int j=0;j<mazeData.length;j++){
		          int x=j*cellWidth;
		          int y=i*cellHeight;
		          if(mazeData[j][i]!=0){
		              e.gc.fillRectangle(x,y,cellWidth,cellHeight);
		          }else{
			        	  if (count ==0){
			      			p=themaze.getStartPosition();
			      			count++;
			      			}
			        	  else if(p.z != character.getPos().z){
			        		  p.z = character.getPos().z;
			        	  }
		        	  p.x = i;
		        	  p.y = j;
		        	  updown = themaze.getPossibleMoves(p);
						for (String move : updown) {
							if (move.equals("UP") || move.equals("DOWN")) {
								e.gc.setBackground(new Color(null, 255, 255, 50));
								e.gc.fillRectangle(x,y,cellWidth,cellHeight);
								e.gc.setBackground(new Color(null,0,0,0));
								}
						}
		          }
		      }

		   character.draw(e, cellWidth, cellHeight);
		   if((character.getPos().z == themaze.getGoalPosition().z))
			   trophy.draw(e, cellWidth, cellHeight);
			   
			      
			}

	/**
	 * Character go left
	 */
	@Override
	protected void goLeft() {
		
		Position pos = character.getPos();
		directions =themaze.getPossibleMoves(pos);
		for (String s : directions){
			if (s.equals("LEFT")){
				newPos = new Position(pos.x-1 , pos.y, pos.z);
				character.setPos(newPos);
				this.redraw();
				checkIfGoal(newPos);
			}
		}
	}
	
	/**
	 * Character go right
	 */
	@Override
	protected void goRight() {
		Position pos = character.getPos();
		directions =themaze.getPossibleMoves(pos);
		for (String s : directions){
			if (s.equals("RIGHT")){
				newPos = new Position(pos.x+1 , pos.y, pos.z);
				character.setPos(newPos);
				this.redraw();
				checkIfGoal(newPos);
			}
		}
}

	/**
	 * Character go forward
	 */
	@Override
	protected void goForward() {
		Position pos = character.getPos();
		directions =themaze.getPossibleMoves(pos);
		for (String s : directions)
			if (s.equals("FORWARD")){
				newPos = new Position(pos.x , pos.y-1, pos.z);
				character.setPos(newPos);
				this.redraw();
				checkIfGoal(newPos);
			}
	}

	/**
	 * Character go backward
	 */
	@Override
	protected void goBackward() {
		Position pos = character.getPos();
		directions =themaze.getPossibleMoves(pos);
		for (String s : directions)
			if (s.equals("REVERSE")){
				newPos = new Position(pos.x , pos.y+1, pos.z);
				character.setPos(newPos);
				this.redraw();
				checkIfGoal(newPos);
			}
	}

	/**
	 * Character go up
	 */
	@Override
	protected void goUp() {
		Position pos = character.getPos();
		directions =themaze.getPossibleMoves(pos);
		for (String s : directions){
			if (s.equals("UP")){	
				newPos = new Position(pos.x , pos.y, pos.z+1);
				character.setPos(newPos);
				try {
					mazeData = themaze.getCrossSectionByZ(pos.z+1);
					p.z = pos.z+1;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
				this.redraw();
				checkIfGoal(newPos);
			}
		}
	}

	/**
	 * Character go down
	 */
	@Override
	protected void goDown() {
		Position pos = character.getPos();		
		directions =themaze.getPossibleMoves(pos);
		for (String s : directions){
			if (s.equals("DOWN")){	
				newPos = new Position(pos.x , pos.y, pos.z-1);
				character.setPos(newPos);
				try {
					mazeData = themaze.getCrossSectionByZ(pos.z-1);
					p.z = pos.z-1;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
				this.redraw();
				checkIfGoal(newPos);
				
			}
		}
	}
	
	/**
	 * check if the Character get the goal Postion
	 */
	public void checkIfGoal(Position pos){
		Position goalpos = themaze.getGoalPosition();
		if (pos.equals(goalpos)){
			MessageBox generateMB = new MessageBox(new Shell());
			generateMB.setMessage("Congratulations you finished the maze");
			generateMB.setText("Congratulations you finished the maze");
			generateMB.open();
		}
			
		
	}
}
