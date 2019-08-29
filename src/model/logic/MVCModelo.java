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
		Queue<ViajeUber> auxiliar = new Queue<ViajeUber>();
		Queue<ViajeUber> respuesta = new Queue<ViajeUber>();
		int horaMayor = 0;
		for(int i=0;i<queueDatos.darTamanio();i++)
		{
			ViajeUber actual = queueDatos.dequeue();
			int numHoraObjeto = Integer.parseInt(actual.darHora());
			int numHoraParametro = Integer.parseInt(pHoraInicial);
			if(numHoraObjeto>=numHoraParametro) 
			{
				if(numHoraObjeto>=horaMayor)
				{
					horaMayor = numHoraObjeto;
					auxiliar.enqueue(actual);	
				}
				else if(numHoraObjeto<horaMayor)
				{
					auxiliar = new Queue<ViajeUber>();
					auxiliar.enqueue(actual);
					horaMayor = numHoraObjeto;
				}
			}
			else
			{
				for(int j=0;j<auxiliar.darTamanio();j++)
				{
					auxiliar.dequeue();
				}
				horaMayor = 0;
			}
			if(auxiliar.darTamanio()>=respuesta.darTamanio())
			{
				respuesta = auxiliar;
			}
		}
	
		return respuesta;
	}

	public Queue<ViajeUber> nViajesACiertaHora(int pN, String pHora)
	{

		int contadorElementosBuscados = 0;
		boolean terminado = false;
		Queue<ViajeUber> respuesta = new Queue<ViajeUber>();
		for(int i =0;i<queueDatos.darTamanio()&&!terminado;i++)
		{
			ViajeUber actual = queueDatos.dequeue();
			if(actual.darHora().equals(pHora))
			{
				contadorElementosBuscados++;
				respuesta.enqueue(actual);
			}
			if(contadorElementosBuscados==pN)
			{
				terminado = true;
			}
		}
		return respuesta;
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
