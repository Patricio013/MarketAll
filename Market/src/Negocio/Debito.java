package Negocio;

public class Debito extends Venta{
	
	public Debito (double valor) {
		super(valor);
	}
	public double calcularCosto(){
        return pTotal;
    }
}
