import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;


//Personalizamos el Bot�n para mostrar pistas para el usuario
public class BotonesParaPistas extends JComponent{
	
	//datos que devuelve el bot�n cuando el jugador elige un color
	private int elegirColor;
	
	//Creamos el constructor 
	
	public BotonesParaPistas(){
		
		elegirColor=0;
	}
	
	//Utilizamos el m�todo paint para pintar el componente como lo queremos
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
	
	//Creamos un m�todo para obtener el color actual del b�ton
		public int obtenerColorActual(){
			return elegirColor;
		}
		
		//Este m�todo cogera el color actual y lo pintar�
		public void pintarColor(int nuevoColor){
			elegirColor=nuevoColor;
			//El m�todo repaint lo utilizamos por los posibles cambios que hemos realizado en el bot�n
			repaint();
		}
		
		//Establecemos el tama�o predefinido del bot�n
		public Dimension obtenerTama�o(){
			
			Dimension dimensionPreferida = new Dimension(20,20);
			return dimensionPreferida;
			
		}

}
