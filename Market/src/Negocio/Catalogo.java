package Negocio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import datos.*;

public class Catalogo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Producto> Productos;
	
	public Catalogo() {
		this.Productos=new ArrayList<Producto>();
	}
	
	public ArrayList<Producto> getList() {
		return new ArrayList<>(this.Productos);
	}
	
	public void CrearProducto(Producto p) {
		if (! this.Existe(p.getCodigo())) {
			this.Productos.add(p);
			System.out.println("Producto agregado con exito");
		} else {
		System.out.println("Producto ya existente");
		}
	}
	
	public double MostrarPrecioPro(Producto p) {
		return p.getPrUni();
	}
	
	public Producto getProducto(int cod) {
		Producto t = null;
		for (Producto p: Productos) {
			if (cod==p.getCodigo())
			t=p;	
		}
		return t;
	}
	
	public boolean Existe(int cod) {
		for (Producto p: Productos) {
			if (cod==p.getCodigo())
				return true;
		}
		return false;
	}
	
	public void EliminarProducto(int cod) {
		if (this.Existe(cod)) {
			Iterator<Producto> iterator = Productos.iterator();
	        while (iterator.hasNext()) {
	            Producto p = iterator.next();
	            if (p.getCodigo()==cod) {
	                iterator.remove();
	                break; // Eliminar el elemento durante el recorrido
	            }
	        }
	        System.out.println("Producto eliminado con exito");
		}else {
			System.out.println("Producto no existe");
		}
	}
	
	public void ModificarProducto(int cod, String des, double pr, int canT, int canM) {		
		if (this.Existe(cod)) {
			for (Producto p: Productos) {
				if (cod==p.getCodigo()) {
					p.ModificarProducto(cod, des, pr, canT, canM);
					break;
				}
			}
			System.out.println("Producto modificado con exito");
		} else {
			System.out.println("Producto no existe");
		}
	}
	
	public boolean StockNecesario(int cod, int canT) {
		return this.getProducto(cod).StockSuficiente(canT);
	}
	
	public void AgregarStock(int cod, int canT) {
		if (this.Existe(cod)) {
			for (Producto p: Productos) {
				if (cod==p.getCodigo()) {
					p.SumarStock(canT);
					break;
				}
			}
			System.out.println("Stock agregado con exito");
		} else {
			System.out.println("Producto no existe");
		}
	}
	
	public static Catalogo recuperarse(){
		Catalogo emp=(Catalogo)Datos.recuperar();
		if(emp == null)
			emp = new Catalogo();
		return emp;
	}
	
	public boolean guardarse(){
		return Datos.guardar(this);
	}
}
