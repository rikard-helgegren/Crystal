import javax.swing.*;

import java.awt.*;

public class Steg2{
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Ion Bath");
		int size=500;
		CrystalModel cm = new CrystalModel(size);
		cm.crystallizeOneIon();
		CrystalView view = new CrystalView(cm);
		
		frame.add(view);
		frame.setSize(size, size);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		while(cm.runSomeSteps(10)){
			view.repaint();
			
		}
		
		
	}

}
