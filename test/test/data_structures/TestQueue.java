package test.data_structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.Queue;
import model.data_structures.Stack;

public class TestQueue {
	private Queue<Integer>queue;

	/**
	 * Crea una lista vacia para las pruebas
	 */
	@Before
	public void setUp1() {
		queue=new Queue<Integer>();
	}
	/**
	 * agrega 100 elementos para probar el metodo enqueue
	 */
	public void setUp2(){
		for(int i=0;i<100;i++){
			queue.enqueue(i);
		}
	}
	/**
	 * elimina 50 elementos para probar el metodo dequeue
	 */
	public void setUp3(){
		for(int i=0;i<50;i++){
			queue.dequeue();
		}
	}
	/**
	 * Se prueba si la cola esta siendo correctamente creada
	 */
	@Test
	public void testStack() {
		assertTrue(queue!=null);
		assertEquals(0, queue.darTamanio());
	}
	/**
	 * Se prueba metodo push y darUltimoElemento
	 */
	@Test
	public void testPush() {
		setUp2();
		assertEquals("No se agregaron correctamente todos los elementos",100, queue.darTamanio());
		assertEquals("El primer elemento no es el esperado", 0, (int)new Integer(queue.dequeue()));
	}
	/**
	 * Se prueba metodo pop y darUltimoElemento();
	 */
	@Test
	public void testPop() {
		setUp2();
		setUp3();
		assertEquals("No se eliminaron correctamente todos los elementos",50, queue.darTamanio());
		assertEquals("El nuevo primer elemento no es el esperado", 50, (int)new Integer(queue.dequeue()));
	}
	/**
	 * Se prueba metodo isEmpty para saber si la cola esta vacia
	 */
	@Test
	public void isEmpty() {
		assertTrue("El arreglo si se encuentra vacio", queue.isEmpty());
		setUp2();
		assertFalse("El arreglo No se encuentra vacio",queue.isEmpty());
	}
}
