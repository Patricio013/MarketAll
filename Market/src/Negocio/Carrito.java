package Negocio;

public class Carrito {
	class productos {
		int codigo;
		int cantStock;
	}
	
	productos[] listaProductos;
	int cant;
	double pTotalBruto;
	
	public void InicializarCarrito() {
		listaProductos=new productos[1000];
		cant=0;
		pTotalBruto=0;
	}
	
	public void AgregarProducto(Catalogo c, int cod, int cst) {
		if (c.Existe(cod)){
			if (c.StockNecesario(cod, cst)){
				listaProductos[cant]=new productos();
				listaProductos[cant].codigo=cod;
				listaProductos[cant].cantStock=cst;
				cant++;
				this.pTotalBruto=this.pTotalBruto+c.MostrarPrecioPro(c.getProducto(cod))*cst;
				System.out.println("Producto agregado al carrito");
			} else {
				System.out.println("No hay stock suficiente");
			}
		} else {
			System.out.println("El producto que ingreso no existe");
		}
	}
		
	public double MostrarPrecio(int tipo, int c) {
		if (tipo==1) {
			Venta v=new Efectivo(this.pTotalBruto);
			return v.calcularCosto();
		} else {
			if (tipo==2) {
				Venta v=new Debito(this.pTotalBruto);
				return v.calcularCosto();
			} else {
				Venta v=new Credito(this.pTotalBruto, c);
				return v.calcularCosto();
			}
		}
	}
	public void ConcretarVenta(Catalogo c) {
		while (cant!=-1){
			c.getProducto(listaProductos[cant].codigo).RestarStock(listaProductos[cant].cantStock);
			if (c.getProducto(listaProductos[cant].codigo).EvaluarStockMin()) {
				System.out.println("El producto "+listaProductos[cant].codigo+" ha llegado a su stock minimo");
			}
			cant--;
		}
		cant=0;
		pTotalBruto=0;
	}
	
	public boolean EstaProducto(int cod) {
		int i =cant;
		boolean r=false;
		while (i!=-1) {
			if (listaProductos[i].codigo==cod) {
				r=true;
				break;
			}
		}
		return r;
	}
	
	public void Sacar(int cod) {
		int i = 0;
		while(i < cant && listaProductos[i].codigo != cod)
			i++;
		if(i < cant) {
			listaProductos[i] = listaProductos[cant - 1];
			cant--;
		}
	}
	
	public void CancelarCompra() {
		cant=0;
		pTotalBruto=0;
		System.out.println("Compra cancelada");
	}
	
	public void MostrarCarrito() {
		if (cant!=0) {
			int i=0;
			while(i<cant) {
				System.out.println(listaProductos[i].codigo+"-"+listaProductos[i].cantStock);
			}
			System.out.println("Monto: $"+pTotalBruto);
		} else {
			System.out.println("No hay ningun producto en el carrito");
		}
	}
}
