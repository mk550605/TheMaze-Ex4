package Boot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import Model.Imodel.MyModel;
import Presenter.Presenter;
import View.Gui.MazeWindow;
import View.*;



public class run {

	public static void main(String[] args) {
		
		
		Display display=new Display();
		Shell shell=new Shell(display);
		shell.setSize(300,200);
		shell.setText("Jave 3D Maze Project");
		shell.setLayout(new GridLayout(1, false));
		Label labelUI=new Label(shell,SWT.NONE);
		labelUI.setText("choose UI");
		labelUI.setLayoutData(new GridData(SWT.CENTER,SWT.CENTER,true,true));
		
		GridData gd = new GridData(SWT.CENTER,SWT.CENTER,true,true);
		gd.heightHint = 50;
		gd.widthHint = 200;
		
		Button guibutton=new Button(shell,SWT.PUSH);
		guibutton.setText("Gui");
		guibutton.setLayoutData(gd);
		
		guibutton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				
				shell.dispose();
				
				
				Thread t=new Thread(new Runnable() {
					public void run() {
						MyModel model = new MyModel();
						MazeWindow view = new MazeWindow();
						Presenter presenter = new Presenter(model, view);
						view.addObserver(presenter);
						model.addObserver(presenter);
						view.start();		
					}
				});
				t.start();
				
				try {
					t.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				t.interrupt();
				
				
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		Button clibutton=new Button(shell,SWT.PUSH);
		clibutton.setText("Cli");
		clibutton.setLayoutData(gd);
		clibutton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				shell.dispose();
				Thread t=new Thread(new Runnable() {
					
					@Override
					public void run() {
						MyModel model = new MyModel();
						BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
						PrintWriter writer = new PrintWriter(System.out);
						MyView view = new MyView(reader, writer);
						Presenter presenter = new Presenter(model, view);
						view.addObserver(presenter);
						model.addObserver(presenter);
						view.start();						
					}
				});
				t.start();
				try {
					t.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				t.interrupt();
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		shell.open();
		while (!shell.isDisposed()) { //loop to management the event queue while the gui isnt closed

			if (display.readAndDispatch()) {  //if the event queue is empty go to sleep until new event occurs
				display.sleep();
			}
		}
		display.dispose(); //close
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*	
			MyModel model = new MyModel();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter writer = new PrintWriter(System.out);
			MyView view = new MyView(reader, writer);
			Presenter presenter = new Presenter(model, view);
			view.addObserver(presenter);
			model.addObserver(presenter);
			view.start();		
		}
	
	
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
			view.start();	*/	
		}
		
}
