package View.Gui.MazeDisplay;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;

import Model.algorithms.mazeGenerators.Position;

public class TwoDMazeDisplay extends MazeDisplay {

	public TwoDMazeDisplay(Composite parent, int style) {
		super(parent, style);
		setBackground(new Color(null, 255,255,255));
	
	}

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

		   for(int i=0;i<mazeData.length;i++)
		      for(int j=0;j<mazeData[i].length;j++){
		          int x=j*cellWidth;
		          int y=i*cellHeight;
		          if(mazeData[i][j]!=0)
		              e.gc.fillRectangle(x,y,cellWidth,cellHeight);
		      }

		   character.draw(e, cellWidth, cellHeight);
		   trophy.draw(e, cellWidth, cellHeight);
			   
			      
			}

	@Override
	protected void goLeft() {
		
		Position pos = character.getPos();
		directions =themaze.getPossibleMoves(pos);
		for (String s : directions){
			System.out.println(s);
			if (s.equals("LEFT")){
				character.setPos(new Position(pos.x - 1, pos.y , pos.z));
				this.redraw();
			}
		}
		System.out.println();
	}

	@Override
	protected void goRight() {
		Position pos = character.getPos();
		directions =themaze.getPossibleMoves(pos);
		for (String s : directions){
			System.out.println(s);
			if (s.equals("RIGHT")){
				character.setPos(new Position(pos.x + 1, pos.y, pos.z));
				this.redraw();
			}
		}
		System.out.println();
}

	@Override
	protected void goForward() {
		Position pos = character.getPos();
		directions =themaze.getPossibleMoves(pos);
		for (String s : directions)
			if (s.equals("FORWARD")){
				character.setPos(new Position(pos.x , pos.y-1, pos.z));
				this.redraw();
			}
	}

	@Override
	protected void goBackward() {
		Position pos = character.getPos();
		directions =themaze.getPossibleMoves(pos);
		for (String s : directions)
			if (s.equals("BACKWARD")){
				character.setPos(new Position(pos.x , pos.y+1, pos.z));
				this.redraw();
			}
	}

	@Override
	protected void goUp() {
		Position pos = character.getPos();
		directions =themaze.getPossibleMoves(pos);
		for (String s : directions)
			if (s.equals("UP")){	
				character.setPos(new Position(pos.x , pos.y, pos.z-1));
				this.redraw();
			}
	}

	@Override
	protected void goDown() {
		Position pos = character.getPos();		
		directions =themaze.getPossibleMoves(pos);
		for (String s : directions)
			if (s.equals("DOWN")){	
				character.setPos(new Position(pos.x , pos.y, pos.z+1));
				this.redraw();
			}
	}
}
