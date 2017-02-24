//labgrupp 55
//eclipse
/**
 * 
 * @author Bjorn Franzen and Rikard Helgegren
 *
 */
public class CrystalModel{
	private int width,height, x, y;
	private boolean[][] positionMatrix;
	private int radius, innerRadius;
/**
 * CrystalModel simulates a crystalation in a bath.
 * @param size
 */
	public CrystalModel(int size){
		width=size;
		height=size;
		radius=(int)(size*0.45-1);
		innerRadius=(int)(size*0.43-1);
		positionMatrix = new boolean[width+4][height+4];
		reset();
		
	}

	//slapper en ny jon (med hjalp av dropNewIon() ) och flyttar sedan jonen ett steg at gangen tills den kristalliseras.
	//Kommer den utanfor flyktcirkeln sa slapps en ny jon. Se beskrivningen ovan for mer detaljer. Metoden returnerar false nar kristallen ar klar 
	//(dvs nar sista jonen kristalliseras pa startcirkeln) och true om vi kan kristallisera fler joner.
	/**
	 * Drops an ion then walks the ion around, and restarts if the ion gets to far of from the middle. Or crystallize it if anyNeighbours==true.
	 */
	public boolean crystallizeOneIon(){
		dropNewIon();
		while(!outsideCircle(radius, x, y)){
			int random = (int)(4*Math.random());

			switch(random){
			case 0: x++;
			break;

			case 1: x--;
			break;

			case 2: y++;
			break;

			case 3: y--;
			break;

			default: System.out.println("Help! Help! I cant move.");
			}
			
			if(anyNeighbours(x,y)){
	
				positionMatrix[xBathToModelRep(x)][yBathToModelRep(y)]=true;
				
				if(outsideCircle(innerRadius, x, y)){
					return false;
				}
				else {
					return true;
				}
				
			}
			
		}
		return crystallizeOneIon();
		
	}
	/**
	 * Runns some ions before returning values.
	 * @param steps
	 * @return if we should run again.
	 */
	public boolean runSomeSteps(int steps) {
        int i= 0;
        boolean goOn = false;
        do {
           goOn = crystallizeOneIon();
           i++;
        } while ( i<steps && goOn );
        return goOn; // we are done
    }

	//returnerar "true" om det finns en kristalliserad jon pa position x,y.
	/**
	 * Returns value in matrix, position (x,y)
	 */
	public boolean getModelValue(int x, int y){
		return positionMatrix[xBathToModelRep(x)][yBathToModelRep(y)];
	}
	//kollar om position x,y ar utanfor (eller pa) cirkeln med radie r. (anvand pythagoras)
	private boolean outsideCircle(int r, int x, int y){
		// pluss ett for sakerhetsmarginal
		return r*r<(x*x+y*y+1);
	}
	/**
	 * Control if an ion is beside a crystal.
	 * @param x
	 * @param y
	 * @return if an ion is beside a crystal
	 */
	private boolean anyNeighbours(int x, int y){
		return(getModelValue(x+1,y) || getModelValue(x-1,y) || getModelValue(x,y+1) || getModelValue(x,y-1));
	}
	/**
	 * Drops an new ion.
	 */
	private void dropNewIon(){
		double value = Math.random()*2*Math.PI;
		x= (int)(innerRadius*Math.cos(value)+0.5);
		y= (int)(innerRadius*Math.sin(value)+0.5);
	}
	/**
	 * Transform bath cordinates to matrix cordinates.
	 * @param x
	 * @return real x value 
	 */
	private int xBathToModelRep(int x){
		return(x+(width/2));
		
		
	}
	/**
	 * Transform bath cordinates to matrix cordinates.
	 * @param y
	 * @return real y value 
	 */
	private int yBathToModelRep(int y){
		return((height/2)-y);
		
		
	}
	

	
	/**
	 * Gets X.
	 * @return
	 */
	public int getX(){
		return x;
	}
	/**
	 * Gets Y.
	 * @return y value
	 */
	public int getY(){
		return y;
	}
	/**
	 * Gets size.
	 * @return size
	 */
	public int getSize(){
		return width;
	}
	
/**
 * Resets the simulation
 */
	void reset(){
		for(int i=0;i<width;i++){
			for(int f=0;f<height;f++){
				this.positionMatrix[i][f]=false;
			}
		}
		positionMatrix[width/2][height/2]=true;
		x=0;
		y=0;
	}

/**
	 * Returns the crystals state i.e. a string according to figure 3 i labPM. 
	 * x and y is the position of the ion in the bath
	 * @return A string that draws the crystal.
	 */
	public String toString() {
		int size = radius;
		StringBuffer s = new StringBuffer(1000);
		for(int i=-size-1; i<size+1; i++) {
			s.append("-");
		}
		s.append("\n");
		for(int i=-size; i<size; i++) {
			s.append("|");
			for(int j=-size; j<size; j++) {
				if (getModelValue(i, j)) {
					if (i==x && j==y) {
						s.append("#");
					} else {
						s.append("*");
					}
				} else {
					s.append(" ");
				}
			}
			s.append("|");
			s.append("\n");
		}
		for(int i = -size-1; i < size+1; i++) {
			s.append("-");
		}
		s.append("\n");
		return s.toString();
	}


}
