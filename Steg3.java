//labgrupp 55
//eclipse

import javax.swing.*;

import java.awt.*;

/**
 * 
 * @author Bjorn Franzen and Rikard Helgegren 
 *
 */
public class Steg3  {

	/**
	 * A frame wich adds CrystalControl and controls the size of the window.
	 * @param args
	 */
	public static void main(String[] args) {
		int size=100;

		try{
			size =Integer.parseInt(args[0]);
			if(size>1000 || size<100){
				System.out.println("Invalid interval, Size must be between 99 and 1001");
				return;
			}
			JFrame frame = new JFrame("Ion Bath");
			CrystalModel cm = new CrystalModel(size);
			CrystalControl but = new CrystalControl(cm);

			frame.setSize(size, size);
			frame.add(but);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//frame.pack();
			frame.setVisible(true);
		}
		catch(IndexOutOfBoundsException Error){
			System.out.println("Must insert an integer");
		}
		catch(NumberFormatException Wrong){
			System.out.println("Must insert an integer");
		}










	}

}

