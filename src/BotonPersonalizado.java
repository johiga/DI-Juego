import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

import javax.swing.JComponent;

 
 //Realizamos esta clase para personalizar los botones que el usuario podr� ir cambiando de color para seleccionar uno.
public class BotonPersonalizado extends JComponent implements MouseListener{
	
	//Inicializamos las propiedades de los botones que vamos a utilizar
	private Color colors[];
	private int numColor;
	private boolean apretarBoton;
	private boolean editar;
	private boolean visible;
	//Creamos el constructor para inicializar las valores
	
	public BotonPersonalizado(){
		
		numColor=0;
		apretarBoton=false;
		editar=false;
		visible=true;
		
		//Creamos los colores que queremos que aparezcan cada vez que apreta el usuario
		colors = new Color[4];
		colors[0]= Color.GREEN;
		colors[1]=Color.BLUE;
		colors[2]=Color.RED;
		colors[3]=Color.YELLOW;
	
		this.addMouseListener(this);		
	}
	
	//Sobreescribimos el m�todo paint d�nde estableceremos las nuevas caracter�sticas del bot�n.
	
	public void paint (Graphics g){
		//Si hemos clickado el bot�n pasar� al siguiente color
		if(apretarBoton=true){
			if(numColor==3){
				//Si queremos que vuelva a empezar la lista de colores
				numColor=1;
			}
			else{
				numColor++;
			}
			
		}
		
		//Si el bot�n es visible el color cambiar�
		
		if (visible=true){
			g.setColor(colors[numColor]);
			
		}
		//Para volver a pintar el bot�n
		if(numColor == 0 || !visible){
			 g.drawRoundRect(0,0,40,40,20,20);
		}		
	}
		
	//Creamos un m�todo para obtener el color actual del b�ton
	public int obtenerColorActual(){
		return numColor;
	}
	
	//Este m�todo cogera el color actual y lo pintar�
	public void pintarColor(int nuevoColor){
		numColor=nuevoColor;
		//El m�todo repaint lo utilizamos por los posibles cambios que hemos realizado en el bot�n
		repaint();
	}
	
	//Creamos el m�todo para editar el bot�n
	
	public void editable(boolean edit){
		
		editar=edit;
		
	}
	
	//Creamos un m�todo para comprobar si es visible el bot�n o no
	
	public void visible(boolean vis){
		visible = vis;
		repaint();
	}
	//Establecemos el tama�o predefinido del bot�n
	public Dimension obtenerTama�o(){
		
		Dimension dimensionPreferida = new Dimension(40,40);
		return dimensionPreferida;
		
	}
	
	//Cuando hemos hecho click en el boton
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		if(editar=true){
			
			apretarBoton=true;
			repaint();
		}
		
	}
   
	//Cuando hemos soltado el boton
	@Override
	public void mouseReleased(MouseEvent arg0) {
		apretarBoton=false;
		
	}
	
	//Estos m�todos no los vamos a utilizar pero son necesarios cuando implementamos la interfaz MouseListener
	@Override
	public void mouseClicked(MouseEvent arg0) {
			}

	@Override
	public void mouseEntered(MouseEvent arg0) {
			}

	@Override
	public void mouseExited(MouseEvent arg0) {
		}	
}
