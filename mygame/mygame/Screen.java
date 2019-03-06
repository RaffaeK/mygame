package mygame;
import java.awt.*;
import javax.swing.JFrame;

public class Screen {
	
	private GraphicsDevice vc; // gives us an interface to our graphics card //
	
	// we need to get to our graphics environment
	public Screen() {
		
        // env is our graphics object //
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		// we now have access to our computer screen //
		vc = env.getDefaultScreenDevice();
		
	}
	// we're gonna build a window and converting it to full screen //
	public void setFullScreen (DisplayMode dm, JFrame window) {
		// this will remove anything on the window except what we want //
		window.setUndecorated(true);
		// this will make it impossible to mess with the size //
		window.setResizable(false);
		// this will make the window we created to a full screen //
		vc.setFullScreenWindow(window);
		
		// this will check if it got monitor setting or
		// if it is able to display those settings
		// and refresh rate
		if(dm !=null && vc.isDisplayChangeSupported()) {
			try {
				vc.setDisplayMode(dm);
			} catch (Exception ex) {}
		}
		
		// our methods //
		public Window getFullScreenWindow() {
			// this will return our window //
			retun vc.getFullScreenWindow();
		}
		
		public void restoreScreen() {
		// this restores the window
			Window w = vc.getFullScreenWindow();
			// if window contains something //
					if(w !=null) {
						w.dispose();
					}
			// This will take it away from full screen
			vc.setFullScreenWindow(null);
		}
		
	}
}


