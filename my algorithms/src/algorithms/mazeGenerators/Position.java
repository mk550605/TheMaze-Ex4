package algorithms.mazeGenerators;

public class Position {
public int x,y,z;

public Position(int x, int y, int z) {
	this.x = x;
	this.y = y;
	this.z = z;
}

@Override
public String toString() {
	return "{" + x + "," + y + "," + z +"}";
}

@Override
public boolean equals(Object obj) {
	if (!((obj) instanceof Position))
		throw new IllegalArgumentException(" object must be position");
	Position p = (Position)obj;
	return x==p.x&&y==p.y&&z==p.z;
}


}
