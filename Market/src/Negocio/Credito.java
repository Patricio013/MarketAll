package Negocio;

public class Credito extends Venta{
	private int Cuota;
	double Recargo;
	double Total;
	
	public Credito (double valor, int c) {
		super(valor);
		this.Cuota=c;
	}

	public double CalcularPrecio() {
		if (this.Cuota==2) {
			Recargo= this.pTotal + this.pTotal*(6/100);
			Total=Recargo/this.Cuota;
		} else {
			if (this.Cuota==3) {
				Recargo= this.pTotal + this.pTotal*(12/100);
				Total=Recargo/this.Cuota;
			} else {
				Recargo= this.pTotal + this.pTotal*(20/100);
				Total=Recargo/this.Cuota;
			}
		}
		return Total;
	}
}
