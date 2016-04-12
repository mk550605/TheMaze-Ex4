package algorithms.mazeGenerators;
/**
 * define a Position in the Maze Domain
 * @author Michael Kratik
 * @version 1.0
 *
 */
public class Position {
public int x,y,z;
/**
 * constructor for the position
 * @param x
 * @param y
 * @param z
 */
public Position(int x, int y, int z) {
	this.x = x;
	this.y = y;
	this.z = z;
}
/**
 * override the to string 
 * printing in ( x , y , z ) Format
 */
@Override
public String toString() {
	return "{" + x + "," + y + "," + z +"}";
}
/**
 * override equals 
 * equals position objects
 * @return Boolean 
 */
@Override
public boolean equals(Object obj) {
	if (!((obj) instanceof Position))
		throw new IllegalArgumentException(" object must be position");
	Position p = (Position)obj;
	return x==p.x&&y==p.y&&z==p.z;
}


}
