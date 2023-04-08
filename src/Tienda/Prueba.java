package Tienda;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

import org.junit.jupiter.api.Test;

class Prueba {

	public Carrito Tienda;
	
	public void escenario () {
		Tienda = new Carrito();
	}

	@Test
	void testcalcularDescuento() {
		escenario();
		Stack<Float> resultado = new Stack<Float>();
		resultado.add((float) 8);
		resultado.add((float) 136.80005);
		assertEquals(resultado, Tienda.calcularDescuento(1710, 9));
	}
	
	@Test
	void testcalcularPrecio() {
		escenario();
		Stack<Integer> carro = new Stack<Integer>();
		for(int i=1;i<10;i++) {
			carro.add(1);
		}
		assertEquals(1573.199951171875, Tienda.calcularPrecio(carro));
	}

}
