package Boot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import Model.Imodel.MyModel;
import Presenter.Presenter;
import View.MyView;
import View.Gui.MazeWindow;
import View.Gui.basicWindow;



public class run {

	public static void main(String[] args) {
		MyModel model = new MyModel();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);
		MyView view = new MyView(reader, writer);
		
		Presenter presenter = new Presenter(model, view);
		view.addObserver(presenter);
		model.addObserver(presenter);
		model.loadHashMap();
		view.start();		
	}
	
	
	/*public static void main(String[] args) {
		MyModel model = new MyModel();
		
		//MyView view = new MyView(reader, writer);
		MazeWindow view = new MazeWindow();
		Presenter presenter = new Presenter(model, view);
		view.addObserver(presenter);
		model.addObserver(presenter);
		model.loadHashMap();
		view.start();		
	}*/

}
