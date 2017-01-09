import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

import javax.swing.JComponent;

 
 //Realizamos esta clase para personalizar los botones que el usuario podrá ir cambiando de color para seleccionar uno.
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
	
	//Sobreescribimos el método paint dónde estableceremos las nuevas características del botón.
	
	public void paint (Graphics g){
		//Si hemos clickado el botón pasará al siguiente color
		if(apretarBoton=true){
			if(numColor==3){
				//Si queremos que vuelva a empezar la lista de colores
				numColor=1;
			}
			else{
				numColor++;
			}
			
		}
		
		//Si el botón es visible el color cambiará
		
		if (visible=true){
			g.setColor(colors[numColor]);
			
		}
		//Para volver a pintar el botón
		if(numColor == 0 || !visible){
			 g.drawRoundRect(0,0,40,40,20,20);
		}		
	}
		
	//Creamos un método para obtener el color actual del bóton
	public int obtenerColorActual(){
		return numColor;
	}
	
	//Este método cogera el color actual y lo pintará
	public void pintarColor(int nuevoColor){
		numColor=nuevoColor;
		//El método repaint lo utilizamos por los posibles cambios que hemos realizado en el botón
		repaint();
	}
	
	//Creamos el método para editar el botón
	
	public void editable(boolean edit){
		
		editar=edit;
		
	}
	
	//Creamos un método para comprobar si es visible el botón o no
	
	public void visible(boolean vis){
		visible = vis;
		repaint();
	}
	//Establecemos el tamaño predefinido del botón
	public Dimension obtenerTamaño(){
		
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
	
	//Estos métodos no los vamos a utilizar pero son necesarios cuando implementamos la interfaz MouseListener
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
