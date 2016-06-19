package View.Gui.MazeDisplay;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

import Model.algorithms.mazeGenerators.Position;
/**
 *  @author Michael Kratik & Tzipi Cabiri
 * the Game character class
 * define the charecter position and image
 *
 */
public class GameCharacter {
	private static final String icon = "images/pacman_old.png";
	private Position pos;
	
	public Position getPos() {
		return pos;
	}
	
	public void setPos(Position pos) {
		this.pos = pos;
	}
	/**
	 * draw the character in the cell size
	 * @param e
	 * @param cellWidth
	 * @param cellHeight
	 */
	public void draw(PaintEvent e, int cellWidth, int cellHeight) {
		e.gc.setBackground(new Color(null, 255, 255, 255));
		
		Image img = new Image(null, icon);
		e.gc.drawImage(img, 0, 0, 128, 128, pos.x * cellWidth, pos.y * cellHeight, cellWidth, cellHeight);
	}
	
	
}

