
public class Steg1{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CrystalModel cm = new CrystalModel(300);
		while(cm.crystallizeOneIon()){
			System.out.println(cm);
			try{
                Thread.sleep(10); // take a breake
            } 
            // maste fangas, kan kastas av Thread.sleep men bor ej handa
            catch (InterruptedException ex) {System.out.println("InterruptedException");
            }
		}
		System.out.println(cm);


	}
}