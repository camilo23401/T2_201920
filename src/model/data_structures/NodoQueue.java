package model.data_structures;

public class NodoQueue<E> {

	/**
	 * Elemento almacenado en el nodo.
	 */

	protected E elemento;

	/**
	 * anterior nodo.
	 */
	
	protected NodoQueue<E>siguiente;
	/**
	 * Constructor del nodo.
	 * @param elemento El elemento que se almacenar� en el nodo. elemento != null
	 */
	public NodoQueue(E elemento)
	{
		this.elemento=elemento;
	
	}

	/**
	 * M�todo que cambia el siguiente nodo.
	 * <b>post: </b> Se ha cambiado el siguiente nodo
	 * @param siguiente El nuevo siguiente nodo
	 */
	public void cambiarSiguiente(NodoQueue<E> nuevo)
	{
		this.siguiente=nuevo;
		
	}

	/**
	 * M�todo que retorna el elemento almacenado en el nodo.
	 * @return El elemento almacenado en el nodo.
	 */
	public E darElemento()
	{
		return elemento;
	}

	/**
	 * Cambia el elemento almacenado en el nodo.
	 * @param elemento El nuevo elemento que se almacenar� en el nodo.
	 */
	public void cambiarElemento(E elemento)
	{
		this.elemento = elemento;
	}
	/**
	 * M�todo que retorna el siguiente nodo.
	 * @return Siguiente nodo
	 */
	public NodoQueue<E> darSiguiente()
	{
		return siguiente;
	}

	

}
