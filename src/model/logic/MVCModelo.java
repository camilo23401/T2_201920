package model.logic;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;
import model.data_structures.Queue;
import model.data_structures.Stack;

/**
 * Definicion del modelo del mundo
 *
 */
public class MVCModelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private IArregloDinamico datos;

	private Queue<ViajeUber> queueDatos;

	private Stack<ViajeUber> stackDatos;
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public MVCModelo()
	{
		datos = new ArregloDinamico(7);
		queueDatos = new Queue<ViajeUber>();
		stackDatos = new Stack<ViajeUber>();
	}

	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */
	public MVCModelo(int capacidad)
	{
		datos = new ArregloDinamico(capacidad);
	}

	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.darTamano();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public String[] agregarDatos() throws IOException
	{	
		int contador1 = 0;
		String primerViaje =  "";
		String ultimoViaje = "";
		CSVReader lector = new CSVReader(new FileReader("data/bogota-cadastral-2018-1-All-HourlyAggregate.csv"));
		String [] siguiente;
		ViajeUber ultimoLeido = null;
		while ((siguiente = lector.readNext()) != null) 
		{
			if(contador1!=0)
			{
				ViajeUber viajeNuevo = new ViajeUber(siguiente[0], siguiente[1], siguiente[2], siguiente[3]);
				if(contador1 == 1)
				{
					primerViaje = "Primer Viaje \n Zona Origen: " + viajeNuevo.darSourceid() + "\n Zona Destino: " + viajeNuevo.darDstid() + "\n Hora " + viajeNuevo.darHora() + "\n Tiempo promedio " + viajeNuevo.darTiempoPromedio();
				}
				queueDatos.enqueue(viajeNuevo);
				stackDatos.push(viajeNuevo);
				ultimoLeido = viajeNuevo;
			}
			contador1++;
		}
		ultimoViaje = "Ultimo Viaje \n Zona Origen: " + ultimoLeido.darSourceid() + "\n Zona Destino: " + ultimoLeido.darDstid() + "\n Hora " + ultimoLeido.darHora() + "\n Tiempo promedio " + ultimoLeido.darTiempoPromedio();
		String [] mensajesARetornar = new String[2];
		mensajesARetornar[0] = primerViaje;
		mensajesARetornar[1] = ultimoViaje;
		lector.close();
		
		return mensajesARetornar;
	}
	
	public Queue<ViajeUber> clusterOrdenadoHora(String pHoraInicial)
	{
		//Inicializar una cola auxiliar, que se llenará cada vez que se encuentren meses ascendentemente consecutivos
		
		//Inicilizar la cola que será la respuesta eventualmente.
		
		//Ciclo que recorre cada elemento de la queue que entra. Si encuentra un valor mayor a la horaInicial que entra por párametro, empezará a 
		//revisar si los elementos siguientes son mayores y agregar cada uno a la lista auxiliar
		
		//Se compara el tamaño de la queue auxiliar con la que será eventualmente la respuesta y se cambiará la respuesta por la auxiliar de ser necesario.
		
		
		return null;
	}
	
	public Queue<ViajeUber> nViajesACiertaHora(int pN, String pHora)
	{
		//Se iniciliza un contador que corresponda a los N datos que se buscan.
		//Se inicializa una lista local que será la respuesta
		
		//Se recorrerá totalmente los viajes del archivo. Cada vez que se encuentre uno a la hora buscada, se agregará  a la queue
		//de respuesta y se sumará 1 al contador. Se repite hasta llegar a los N elementos deseados o hasta acabar la queue.
		
		//Se retorna la solucion.
		return null;
	}

	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public String buscar(String dato)
	{
		return datos.buscar(dato);
	}

	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public String eliminar(String dato)
	{
		return datos.eliminar(dato);
	}


}
