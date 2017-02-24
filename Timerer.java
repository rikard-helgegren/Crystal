


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Timerer {
	public static void main(String args[]) {
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				System.out.println("Hello World Timer");
			}
		};
		Timer timer = new Timer(500, actionListener);
		timer.start();
	}

}





/*
 * ActionListener actionListener = new ActionListener() {
		public void actionPerformed(ActionEvent actionEvent) {
			if(cm.runSomeSteps(steps)){
				view.repaint();
			}
			else{
				timer.stop();
			}
		}
	};
	Timer timer = new Timer(500, actionListener);
 * 
 */
