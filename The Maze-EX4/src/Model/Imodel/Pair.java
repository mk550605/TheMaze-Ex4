package Model.Imodel;

import java.io.Serializable;

public class Pair <X,Y> implements Serializable {
	public X maze;
	public Y sol;
	public Pair(X maze, Y sol){
		this.maze= maze;
		this.sol=sol;
	}
}
