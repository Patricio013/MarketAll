package IntEmpleado;

import java.util.Scanner;

import Negocio.*;

public class VentanaGeneral {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int numero = 0;
        Catalogo Market = Catalogo.recuperarse();
        VentCompra ventanaCom = new VentCompra();
        VentCatalogo ventanaCat = new VentCatalogo();

        String texto = """
            Seleccione la opcion que desea ejecutar
            1. Entrar al Catalogo
            2. Realizar una Compra
            3. Salir
            Escriba el numero de la opcion deseada
            """;

        System.out.println("Bienvenido a MarketAll");
        System.out.println(texto);

        while (numero != 3) {
            try {
                numero = scanner.nextInt();
                switch (numero) {
                    case 1:
                        ventanaCat.ventanaCat(Market, scanner);
                        break;
                    case 2:
                        ventanaCom.ventana(Market, scanner);
                        break;
                    case 3:
                        System.out.println("Gracias por usar nuestro sistema");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }
                if (numero!=3) {
                System.out.println("");
                System.out.println("Bienvenido devuelta al menu");
                System.out.println(texto);
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada no válida. Introduce un número entero.");
                scanner.next(); // Consumir la entrada no válida
            }
        }

        // Cierre del Scanner al final del programa
        scanner.close();
    }
}



