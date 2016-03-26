package algorithms.mazeGenerators;

public class SimpaleMaze3D extends Maze3dGenerator {

	@Override
	public Maze3d generate(int cols, int raws, int floors) {
		Maze3d theMaze = new Maze3d(cols, raws, floors);
		for(int i=0 ; i < theMaze.getFloor()  ; i++){
			for (int j=0 ; j < theMaze.getRows()  ; j++){
				for(int k=0 ; k < theMaze.getCols() ; k++){
					int a = Utils.random.nextInt(2);
					if (a==1)
						theMaze.setWall(k, j, i);
					else
						theMaze.setFree(k, j, i);
				}
			}
		} 
		
		theMaze.setStartPosition(randomizePosition(theMaze));
		int sX =theMaze.getStartPosition().x;
		int sY= theMaze.getStartPosition().y;
		int sZ= theMaze.getStartPosition().z;
		theMaze.setFree(sX, sY, sZ);
		theMaze.setGoalPosition(randomizePosition(theMaze));
		int gX =theMaze.getGoalPosition().x;
		int gY= theMaze.getGoalPosition().y;
		int gZ= theMaze.getGoalPosition().z;
		theMaze.setFree(gX,gY, gZ);
		
		// Enforce Solution.
		while(sX !=gX){
			if (sX > gX )
				sX = sX -1;
			else
				sX = sX +1;
			theMaze.setFree(sX, sY, sZ);
		}
		while(sY !=gY){
			if (sY > gY )
				sY = sY -1;
			else
				sY = sY +1;
			theMaze.setFree(sX, sY, sZ);
		}
		while(sZ !=gZ){
			if (sZ > gZ )
				sZ = sZ -1;
			else
				sZ = sZ +1;
			theMaze.setFree(sX, sY, sZ);
		}
		
		return theMaze;
	}

	private Position randomizePosition(Maze3d theMaze){
		int x =Utils.random.nextInt(theMaze.getCols());
		int y = Utils.random.nextInt(theMaze.getRows());
		int z =Utils.random.nextInt(theMaze.getFloor() );
		Position randomPos = new Position(x, y, z);
		return randomPos;
	}
	
}
