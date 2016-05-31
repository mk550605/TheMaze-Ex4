package View.Gui.MazeDisplay;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

public abstract class  MazeDisplay extends Canvas {

	protected abstract void drawMaze(PaintEvent e);
	protected int[][] mazeData;
	
	public void setMazeData (int[][] mazeData){
		this.mazeData =mazeData;
	}
	
	public MazeDisplay(Composite parent, int style) {
		super(parent, style);
		this.addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				drawMaze(e);
				
			}
		});
	}
	
	

		
		

	
	
	
}
