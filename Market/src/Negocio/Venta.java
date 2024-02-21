package Negocio;

public class Venta {
	protected double pTotal;
	
	public Venta(double valor){
        this.pTotal = valor;
    }

    public double getMonto(){
        return this.pTotal;
    }

    public double calcularCosto(){
        return this.pTotal;
    }
}
