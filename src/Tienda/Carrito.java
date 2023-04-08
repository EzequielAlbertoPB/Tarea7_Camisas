package Tienda;

import java.util.Scanner;
import java.util.Stack;

public class Carrito {

	public static void main(String[] args) {

		System.out.println("Bienvenido a la tienda de camisetas:\n\n"
				+ "1- Camisa de manga larga ($190)\n2- Camisa casual de manga larga ($230)\n"
				+ "3- Camisa formal de manga larga ($310)\n\n");

		Scanner leer = new Scanner(System.in);
		Stack<Integer> carro = new Stack<Integer>();
		boolean carroLleno = false;

		while (carroLleno == false) {
			System.out.println("Ingrese el número del articulo que desea agregar al carrito: ");
			int num = leer.nextInt();
			if (num < 4) {
				System.out.println("¿Cuantas piezas quiere de la camisa seleccionada?: ");
				int cantidad = leer.nextInt();
				for (int c = 1; c <= cantidad; c++) {
					carro.add(num);
				}
			} else {
				System.out.println("No hay articulo con ese numero\n");
			}
			System.out.println("¿Quiere añadir otro articulo al carrito?[ Y=1/N=2 ]: ");
			num = leer.nextInt();
			if (num != 1) {
				carroLleno = true;
			}
		}

		float precio = calcularPrecio(carro);
		if (precio != 0) {
			System.out.println("\nEl total a pagar por sus articulos es: $" + precio);
		}

		System.out.println("\nFin del programa");

	}

	public static float calcularPrecio(Stack carrito) {
		float c1 = 0, c2 = 0, c3 = 0;
		while (carrito.empty() == false) {
			int articulo = (int) carrito.pop();
			if (articulo == 1) {
				c1++;
			} else if (articulo == 2) {
				c2++;
			} else if (articulo == 3) {
				c3++;
			}

		}

		Stack<Float> resultado = new Stack<Float>();
		float c1_total = c1*190;
		float c2_total = c2*230;
		float c3_total = c3*310;
		float total = c1_total+c2_total+c3_total;
		
		resultado = calcularDescuento(total, c1+c2+c3);
		float descuento = resultado.pop();
		float porcentaje = resultado.pop();
		
		if(c1 != 0) {
			System.out.print("\n\tTotal camisa de manga larga:\n"
					+"\t\t\t"+c1+" * 190 = "+c1_total+"\n");
		}
		
		if(c2 != 0) {
			System.out.print("\n\tTotal camisa casual de manga larga:\n"
					+"\t\t\t"+c2+" * 230 = "+c2_total+"\n");
		}
		
		if(c3 != 0) {
			System.out.print("\n\tTotal camisa formal de manga larga:\n"
					+"\t\t\t"+c3+" * 310 = "+c3_total+"\n");
		}
		
		if(porcentaje !=0) {
			System.out.print("\nDescuento aplicado: "+porcentaje+"%"+" = "+(descuento)+"\n");
		}
		
		return total-descuento;
	}

	public static Stack<Float> calcularDescuento(float total, float cantidad) {
	
		float descuento = 0;
		float porcentaje = 0;
		
		if (cantidad > 2 && cantidad < 6) {
			descuento = ((total / 100) * 5);
			descuento = total - descuento;
			porcentaje = 5;
		} else if (cantidad > 5) {
			descuento = ((total / 100) * 8);
			descuento = total - descuento;
			porcentaje = 8;
		}

		Stack<Float> resultado = new Stack<Float>();
		resultado.add(porcentaje);
		resultado.add(total-descuento);
		
		return resultado;
	}
	
}