package Model.Imodel;

import java.util.concurrent.Callable;

import Model.algorithms.Search.Searcher;
import Model.algorithms.Search.Solution;
import Model.algorithms.demo.MazeAdapter;
import Model.algorithms.mazeGenerators.Maze3d;

public class Solve3DMazeCallable implements Callable<Solution> {
	
	MazeAdapter theAdapter;
	Searcher theSearcher;
	
	public Solve3DMazeCallable( MazeAdapter theAdapter , Searcher theSearcher){
		this.theAdapter =theAdapter;
		this.theSearcher = theSearcher;
	}
	
	@Override
	public Solution call() throws Exception {
		return  theSearcher.search(theAdapter);
	}

	
}
