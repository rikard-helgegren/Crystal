//labgrupp 55
//eclipse
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.Timer;


/**
 * 
 * @author Bjorn Franzen and Rikard Helgegren 
 *
 */
public class CrystalControl extends JPanel{
	private CrystalModel cm;
	private int delay, steps, size, butIndex;
	private CrystalView view;
	private Timer timer;
	private JButton b3;

	/**
	 * Aranges the layout of JFrame.
	 * @param cm
	 */
	public CrystalControl(CrystalModel cm){
		timer = new Timer(50, new TimerListener());
		this.cm=cm;

		view = new CrystalView(cm);
		JPanel but = new JPanel();

		setLayout(new BorderLayout());// to change default layout to how we order it =D
		JLabel label1 = new JLabel("stop");
		JLabel label2 = new JLabel("go");
		
		//keeps track of what the button B3 shows
		butIndex=1;
		
		//Default length of steps  
		steps=30;

		but.setBackground(Color.gray);
		JButton b1 = new JButton("Change Speed");
		but.add(b1, BorderLayout.WEST);
		JButton b2 = new JButton("Run");
		b1.addActionListener(new B1Listener());
		but.add(b2, BorderLayout.EAST);

		b2.addActionListener(new B2Listener());
		b3 = new JButton("Stop");
		but.add(b3, BorderLayout.SOUTH);
		b3.addActionListener(new B3Listener());



		add(view, BorderLayout.CENTER);
		add(but, BorderLayout.SOUTH);


	}


	public class TimerListener implements ActionListener{
		/**
		 * Keeps track of the time and orders repaint.
		 */
		public void actionPerformed(ActionEvent actionEvent) {
			if(cm.runSomeSteps(steps)){
				view.repaint();
			}
			else{
				timer.stop();
				view.repaint();
			}
		}
	}

	public class B1Listener implements ActionListener{
		/**
		 * Changes the amount of steps takeSomeSteps takes witch changes the speed
		 */
		public void actionPerformed(ActionEvent e) {
			String ans =
				JOptionPane.showInputDialog(
				"Chooose speed, 30 is default.");
			if (ans != null) {
				steps =Integer.parseInt(ans.trim());
				timer.stop();
				cm.reset();
				view.repaint();
			}
		}
	}
	public class B2Listener implements ActionListener{
/**
 * Resets the simulation.
 */
		public void actionPerformed(ActionEvent e) {
			cm.reset();
			timer.start();
			butIndex=1;
			b3.setText("Stop");

		}
	}
	public class B3Listener implements ActionListener{
		/**
		 * Starts and stops the timer/simulation.
		 */
		public void actionPerformed(ActionEvent e) {
			switch(butIndex){
			case 1:
				timer.stop();
				butIndex=2;
				if(b3==null){System.out.println("b3 is null");}
				b3.setText("Start");
				break;
			case 2:
				timer.start();
				butIndex=1;
				b3.setText("Stop");
				break;
			default: 
				System.out.println("Ohh! NOOOO! ERROR IN BUTT_NR_3");	
				break;
			}
		}
	}

}

