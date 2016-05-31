package Boot;

import Model.Imodel.MyModel;
import Presenter.Presenter;
import View.Gui.MazeWindow;



public class run {

	/*public static void main(String[] args) {
			
			MyModel model = new MyModel();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter writer = new PrintWriter(System.out);
			MyView view = new MyView(reader, writer);
			Presenter presenter = new Presenter(model, view);
			view.addObserver(presenter);
			model.addObserver(presenter);
			view.start();		
		}*/
	
	
		public static void main(String[] args) {
		MyModel model = new MyModel();
		//MyView view = new MyView(reader, writer);
		MazeWindow view = new MazeWindow();
		Presenter presenter = new Presenter(model, view);
		view.addObserver(presenter);
		model.addObserver(presenter);
		view.start();		
	}
	/*
	*
	*
	*
	*
	*
	*String strView = "gui";
			PrintWriter writer = null;
			BufferedReader reader = null;
			View view = null;
			
			MyModel model = new MyModel();
			
			if (strView.equals("gui") ){
				view = new MazeWindow();	
			}
			else{
				 reader = new BufferedReader(new InputStreamReader(System.in));
				 writer = new PrintWriter(System.out);
				 view = new MyView(reader, writer);
			}
			
			
			Presenter presenter = new Presenter(model, view);
			view.addObserver(presenter);
			model.addObserver(presenter);
			view.start();		
		}*/
}
