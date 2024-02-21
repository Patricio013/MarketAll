package IntEmpleado;
import java.util.Scanner;

import Negocio.*;

public class VentCompra {
	
	public void ventana(Catalogo Market, Scanner scanner) {
		Carrito supermer=new Carrito();
		supermer.InicializarCarrito();
		int numero=0;
		int cuota=1;
		int cantidad=0;
		String texto="""
1. Ver catalogo de productos
2. Agregar al carrito
3. Sacar del carrito
4. Pagar
5. Ver carrito
6. Salir o cancelar compra
Escriba el numero de la opcion deseada
""";
String texto2="""
Metodos de pago disponible
1. Efectivo
2. Debito
3. Credito
Escriba el metodo de pago
""";

String texto3="""
Las cuotas son
2 cuotas con 6% de Recargo
3 cuotas con 12% de Recargo
6 cuotas con 20% de Recargo
Escribe numero de la cuota que desee
""";
		System.out.println("");
		System.out.println("Se encuentra en el carrito");
		System.out.println(texto);
		while (numero!=6) {
			try {
		numero = scanner.nextInt();
		
		switch(numero) {
		case 1:
			System.out.println("Lista de productos");
			for (Producto p2: Market.getList()) {
				System.out.println(p2.getCodigo()+" "+p2.getDescrip()+" "+p2.getPrUni()+" "+p2.getStock()+" "+p2.getStockMin());
			}
			break;
		case 2:
			System.out.println("Escriba el codigo del producto que desea comprar");
			int codigo2 = scanner.nextInt();
			System.out.println("Ingrese la cantidad del producto");
			int cantidad2 = scanner.nextInt();
			
			supermer.AgregarProducto(Market, codigo2, cantidad2);
			break;
		case 3:
			System.out.println("Ingrese el codigo del producto");
			int codigo = scanner.nextInt();
			
			supermer.Sacar(codigo);
			System.out.println("Producto removido");
			break;
		case 4:
			System.out.println(texto2);
			int codigo3 = scanner.nextInt();
			if (codigo3==3) {
				while (cuota!=2 && cuota!=3 && cuota!=6) {
				System.out.println(texto3);
				cuota= scanner.nextInt();
				}
			}
			System.out.println("Monto a pagar: $" +supermer.MostrarPrecio(codigo3, cuota));
			System.out.println("Escriba 1 para pagar o 2 para cancelar");
			switch (cantidad) {
			case 1:
				System.out.println("Pago exitoso");
				supermer.ConcretarVenta(Market);
				break;
			case 2:
				supermer.CancelarCompra();
				break;
			default:
			cantidad = scanner.nextInt();
			}
			numero=5;
			break;
		case 5:
			supermer.MostrarCarrito();
			break;
		case 6:
			System.out.println("Volviendo al menu");
			break;
		default:
			System.out.println("Opcion no valida");
		}
		if (numero !=6) {
			System.out.println("");
			System.out.println(texto);
		}
		}catch (java.util.InputMismatchException e) {
            System.out.println("Entrada no válida. Introduce un número entero.");
            scanner.next(); // Consumir la entrada no válida
        }
		
	}
	if (Market.guardarse()) {
		System.out.println("Cambios guardados");
	}
	}
}
