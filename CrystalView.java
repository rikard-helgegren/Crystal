//labgrupp 55
//eclipse
import javax.swing.*;
import java.awt.*;

/**
 * 
 * @author Bjorn Franzen and Rikard Helgegren 
 *
 */
public class CrystalView extends JPanel{
	private CrystalModel cm;
	private int size;
	
	public CrystalView(CrystalModel cm){
		this.cm=cm;
		size= cm.getSize();
		setBackground(Color.black);
		setPreferredSize(new Dimension(size,size));

	}


	/**
	 * Makes a panel, wich shows the crystallization.
	 * 
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i=-(cm.getSize()/2); i<(cm.getSize()/2); i++){
			
			for(int h=-(cm.getSize()/2); h<(cm.getSize()/2); h++){
				
				if(cm.getModelValue(i,h)){
					if (i==cm.getX() && h==cm.getY()) {
						g.setColor(Color.green);
						g.fillRect(i+(cm.getSize()/2), h+(cm.getSize()/2), 1, 1);
						
						}
					else{
					g.setColor(Color.red);
					g.fillRect(i+(cm.getSize()/2), h+(cm.getSize()/2), 1, 1);
					
					}
				}
			}
		}


	}
}

