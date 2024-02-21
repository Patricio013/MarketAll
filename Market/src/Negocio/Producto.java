package Negocio;

import java.io.Serializable;

public class Producto implements Serializable{
	private int codigo;
	private String descripcion;
	private double precioUnitario;
	private int cantStock;
	private int cantMin;
	
	public Producto(int cod, String des, double pr, int canT, int canM) {
		this.codigo=cod;
		this.descripcion=des;
		this.precioUnitario=pr;
		this.cantStock=canT;
		this.cantMin=canM;
	}
	
	public double getPrUni() {
		return this.precioUnitario;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public String getDescrip() {
		return this.descripcion;
	}
	
	public int getStock() {
		return this.cantStock;
	}
	
	public int getStockMin() {
		return this.cantMin;
	}
	
	public void RestarStock(int canT) {
		this.cantStock=this.cantStock-canT;
	}
	
	public boolean EvaluarStockMin() {
		return this.cantStock>this.cantMin;
	}
	
	public boolean StockSuficiente(int canT) {
		return this.cantStock>=canT;
	}
	
	public void SumarStock(int canT) {
		this.cantStock=this.cantStock+canT;
	}
	
	public void ModificarProducto(int cod, String des, double pr, int canT, int canM) {
		this.codigo=cod;
		this.descripcion=des;
		this.precioUnitario=pr;
		this.cantStock=canT;
		this.cantMin=canM;
	}
}
