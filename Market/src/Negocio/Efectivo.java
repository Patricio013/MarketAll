package Negocio;

public class Efectivo extends Venta{
	private int Descuento=10;
	
	public Efectivo (double valor) {
		super(valor);
	}
	
	public double calcularCosto(){
        double total = this.pTotal - (this.pTotal*this.Descuento/100);
        return total;
    }
}
