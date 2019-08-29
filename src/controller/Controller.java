package controller;

import java.util.Scanner;

import model.data_structures.Queue;
import model.logic.MVCModelo;
import view.MVCView;
import model.logic.ViajeUber;

public class Controller {

	/* Instancia del Modelo*/
	private MVCModelo modelo;
	
	/* Instancia de la Vista*/
	private MVCView view;
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new MVCView();
		modelo = new MVCModelo();
	}
		
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
				case 1:
					System.out.println("--------- \nCrear Arreglo \nDar capacidad inicial del arreglo: ");
				    int capacidad = lector.nextInt();
				    modelo = new MVCModelo(capacidad); 
					System.out.println("Arreglo Dinamico creado");
					System.out.println("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;

				case 2:
					System.out.println("--------- \nDar cadena (simple) a ingresar: ");
					dato = lector.next();
					System.out.println("Dato agregado");
					System.out.println("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;

				case 3:
					System.out.println("--------- \nDar cadena (simple) a buscar: ");
					dato = lector.next();
					respuesta = modelo.buscar(dato);
					if ( respuesta != null)
					{
						System.out.println("Dato encontrado: "+ respuesta);
					}
					else
					{
						System.out.println("Dato NO encontrado");
					}
					System.out.println("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;

				case 4:
					System.out.println("--------- \nDar cadena (simple) a eliminar: ");
					dato = lector.next();
					respuesta = modelo.eliminar(dato);
					if ( respuesta != null)
					{
						System.out.println("Dato eliminado "+ respuesta);
					}
					else
					{
						System.out.println("Dato NO eliminado");							
					}
					System.out.println("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;

				case 5: 
					System.out.println("--------- \nContenido del Arreglo: ");
					view.printModelo(modelo);
					System.out.println("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;
					
				case 6:
					try
					{
						String[] rta = modelo.agregarDatos();
						for(int i =0; i<rta.length;i++)
						{
							System.out.println(rta[i]);
						}
					}
					catch(Exception e)
					{
						System.out.println("Se produjo un error " + e.toString());
					}
					break;
					
				case 7:
					System.out.println("Digite la hora mínima que quiere que se muestre: ");
					String horaMinima = lector.next();
					Queue<ViajeUber> lista = modelo.clusterOrdenadoHora(horaMinima);
					int numViajesLista = lista.darTamanio();
					int contadorViajesOrdenados = 0;
					while(contadorViajesOrdenados<numViajesLista)
					{
						contadorViajesOrdenados++;
						ViajeUber actual = lista.dequeue();
						System.out.println("---------- Viaje " + contadorViajesOrdenados +"----------");
						System.out.println("Hora: " + actual.darHora());
						System.out.println("Zona origen: " + actual.darSourceid());
						System.out.println("Zona destino: " + actual.darDstid());
						System.out.println("Tiempo promedio: "+actual.darTiempoPromedio());
					}
					break;
					
				case 8:
					System.out.println("Digite el número de elementos que desea contar");
					int pN = Integer.parseInt(lector.next());
					System.out.println("Digite la hora que desea buscar");
					String hora = lector.next();
					Queue<ViajeUber> viajes = modelo.nViajesACiertaHora(pN, hora);
					int numViajes = viajes.darTamanio();
					int contadorViajes = 0;
					while (contadorViajes<numViajes)
					{
						contadorViajes++;
						ViajeUber actual = viajes.dequeue();
						System.out.println("---------- Viaje " + contadorViajes +"----------");
						System.out.println("Hora: " + actual.darHora());
						System.out.println("Zona origen: " + actual.darSourceid());
						System.out.println("Zona destino: " + actual.darDstid());
						System.out.println("Tiempo promedio: "+actual.darTiempoPromedio());
					}
					break;
					
				case 9: 
					System.out.println("--------- \n Hasta pronto !! \n---------"); 
					lector.close();
					fin = true;
					break;	

				default: 
					System.out.println("--------- \n Opcion Invalida !! \n---------");
					break;
			}
		}
		
	}	
}
