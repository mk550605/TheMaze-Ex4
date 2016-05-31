package View.Gui.MazeDisplay;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;

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

		   int w=width/mazeData[0].length;
		   int h=height/mazeData.length;

		   for(int i=0;i<mazeData.length;i++)
		      for(int j=0;j<mazeData[i].length;j++){
		          int x=j*w;
		          int y=i*h;
		          if(mazeData[i][j]!=0)
		              e.gc.fillRectangle(x,y,w,h);
		      }


			   
			      
			}

	

}
