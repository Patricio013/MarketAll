package IntEmpleado;

import java.util.Scanner;

import Negocio.*;


public class VentCatalogo {
	public void ventanaCat(Catalogo Market, Scanner scanner) {
		int numero=0;
		String texto="""
Seleccione la opcion que desea ejecutar
1. Añadir un nuevo producto
2. Modificar un producto
3. Ver productos disponibles
4. Eliminar un producto
5. Agregar stock a producto
6. Salir
Escriba el numero de la opcion deseada
""";
		System.out.println("");
		System.out.println("Se encuentra en el catalogo");
		System.out.println(texto);
		while (numero!=6) {
			try {
		numero = scanner.nextInt();
		switch(numero) {
		case 1:
			System.out.println("Ingrese el codigo del producto");
			int codigo = scanner.nextInt();
			System.out.println("Ingrese el nombre del producto");
			String nombre = scanner.next();
			System.out.println("Ingrese el precio del producto");
			double precioUnitario = scanner.nextDouble();
			System.out.println("Ingrese la cantidad del producto");
			int cantidad = scanner.nextInt();
			System.out.println("Ingrese la cantidad minima del producto");
			int cantidadMinima = scanner.nextInt();
			Producto p = new Producto(codigo, nombre, precioUnitario, cantidad, cantidadMinima);
			Market.CrearProducto(p);
			break;
		case 2:
			System.out.println("Escriba el codigo del producto objetivo");
			int codigo2 = scanner.nextInt();
			System.out.println("Ingrese el nombre del producto");
			String nombre2 = scanner.next();
			System.out.println("Ingrese el precio del producto");
			double precioUnitario2 = scanner.nextDouble();
			System.out.println("Ingrese la cantidad del producto");
			int cantidad2 = scanner.nextInt();
			System.out.println("Ingrese la cantidad minima del producto");
			int cantidadMinima2 = scanner.nextInt();
			Market.ModificarProducto(codigo2, nombre2, precioUnitario2, cantidad2, cantidadMinima2);
			break;
		case 3:
			System.out.println("Lista de productos");
			for (Producto p2: Market.getList()) {
				System.out.println(p2.getCodigo()+" "+p2.getDescrip()+" "+p2.getPrUni()+" "+p2.getStock()+" "+p2.getStockMin());
			}
			break;
		case 4:
			System.out.println("Escriba el codigo del producto objetivo");
			int codigo3 = scanner.nextInt();
			Market.EliminarProducto(codigo3);
			break;
		case 5:
			System.out.println("Ingrese codigo del producto a agregar stock");
			int codigo4=scanner.nextInt();
			System.out.println("Ingrese cantidad de stock a agregar");
			int cantidad3=scanner.nextInt();
			Market.AgregarStock(codigo4, cantidad3);
			break;
		case 6:
			System.out.println("Volviendo al menu");
			break;
		default:
			System.out.println("Opcion no valida");
		}
		if (numero!=6) {
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
