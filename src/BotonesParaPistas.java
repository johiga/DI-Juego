import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;


//Personalizamos el Botón para mostrar pistas para el usuario
public class BotonesParaPistas extends JComponent{
	
	//datos que devuelve el botón cuando el jugador elige un color
	private int elegirColor;
	
	//Creamos el constructor 
	
	public BotonesParaPistas(){
		
		elegirColor=0;
	}
	
	//Utilizamos el método paint para pintar el componente como lo queremos
	public void paint(Graphics g){
		
		if (elegirColor==1){
			g.setColor(Color.WHITE);
			g.drawRoundRect(0,0,20,20,40,40);
		}
		else if(elegirColor==2){
			g.setColor(Color.BLACK);
			g.drawRoundRect(0,0,20,20,40,40);
		}
		else{
			g.setColor(Color.BLACK);
			g.drawRoundRect(0,0,20,20,40,40);
		}
	}
	
	//Creamos un método para obtener el color actual del bóton
		public int obtenerColorActual(){
			return elegirColor;
		}
		
		//Este método cogera el color actual y lo pintará
		public void pintarColor(int nuevoColor){
			elegirColor=nuevoColor;
			//El método repaint lo utilizamos por los posibles cambios que hemos realizado en el botón
			repaint();
		}
		
		//Establecemos el tamaño predefinido del botón
		public Dimension obtenerTamaño(){
			
			Dimension dimensionPreferida = new Dimension(20,20);
			return dimensionPreferida;
			
		}

}
