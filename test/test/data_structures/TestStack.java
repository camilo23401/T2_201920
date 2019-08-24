package test.data_structures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.Stack;



public class TestStack {

	private Stack<Integer>stack;

	/**
	 * Crea una lista vacia para las pruebas
	 */
	@Before
	public void setUp1() {
		stack=new Stack<Integer>();
	}
	/**
	 * agrega 100 elementos para probar el metodo push
	 */
	public void setUp2(){
		for(int i=0;i<100;i++){
			stack.push(i);
		}
	}
	/**
	 * elimina 50 elementos para probar el metodo pop
	 */
	public void setUp3(){
		for(int i=50;i<100;i++){
			stack.pop();
		}
	}
	/**
	 * Se prueba si la pila esta siendo correctamente creada
	 */
	@Test
	public void testStack() {
		assertTrue(stack!=null);
		assertEquals(0, stack.darTamanio());
	}
	/**
	 * Se prueba metodo push y darUltimoElemento
	 */
	@Test
	public void testPush() {
		setUp2();
		assertEquals("No se agregaron correctamente todos los elementos",100, stack.darTamanio());
		assertEquals("El ultimo elemento no es el esperado", 99, (int)new Integer(stack.pop()));
	}
	/**
	 * Se prueba metodo pop y darUltimoElemento();
	 */
	@Test
	public void testPop() {
		setUp2();
		setUp3();
		assertEquals("No se eliminaron correctamente todos los elementos",50, stack.darTamanio());
		assertEquals("El ultimo elemento no es el esperado", 49, (int)new Integer(stack.pop()));
	}
	/**
	 * Se prueba metodo isEmpty para saber si la lista esta vacia
	 */
	@Test
	public void isEmpty() {
		assertTrue("El arreglo si se encuentra vacio", stack.isEmpty());
		setUp2();
		assertFalse("El arreglo No se encuentra vacio",stack.isEmpty());
	}



}
