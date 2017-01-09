import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class MasterMind extends JFrame implements ActionListener{
	//Creamos la vista de los botones personalizados para elegir color
	BotonPersonalizado botonColor[][];
	BotonPersonalizado arrayBotones[];
	//Creamos la vista de los botones para las pistas
	BotonesParaPistas botonPistas[][];
	//Creamos un botón para aceptar los colores a adivinar
	private JButton botonAceptar;
	/*Creamos un contador para que cuente la posicion de cada boton dependiendo del color que haya elegido el jugador
	 * 
	 * posicion 0 color verde
	   posicion 1 color azul
	   posición 2 color rojo
	   posición 3 color amarillo
	 */
	private int contador;
	//Creamos un contador para ver en que modo del juego está 

	//private int modo;
	
	//Representación de las diferentes teclas 
	String valorTeclas = new String();
	//Creamos un random para generar aleatoriamente los valores
	Random valores = new Random();
	
	
	
	public MasterMind(){
		super("MasterMind");
		iniciarGUI();
	}
		
	public void iniciarGUI(){
		
		//Creamos dos paneles, uno principal dónde estará todo el juego y otro panel dónde esté solo la fila de los botones 
		JPanel panelPrincipal = new JPanel();
		JPanel panelBotones = new JPanel();
		
		panelPrincipal.setBackground(Color.LIGHT_GRAY);
		
		pack();
		setSize(300,300);
		setVisible(true);
				
	}
	
	//Creamos un color 
	public void cambiarColorBoton(){
		
		setBackground(Color.yellow);
		setBackground(Color.green);
		setBackground(Color.blue);
		setBackground(Color.red);
		
	}
	
	public void aceptarSeleccion(){
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
		cambiarColorBoton();
	}
	
	public static void main(String[] args) {

		new MasterMind();

	}

}
