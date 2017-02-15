

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//Realizamos esta clase para personalizar los botones que el usuario podrá ir cambiando de color para seleccionar uno.
public class BotonSecuencia extends JComponent implements MouseListener {
	//Inicializamos las propiedades de los botones que vamos a utilizar
    private int  currColor;
    private Color colors[];
    private boolean mousePressed;
    private boolean editable;
    private boolean visible;

  //Creamos el constructor para inicializar las valores
    public BotonSecuencia() {
        addMouseListener(this);

        currColor = 0;
        mousePressed = false;
        editable = false;
        visible = true;
        
    	//Creamos los colores que queremos que aparezcan cada vez que apreta el usuario
        colors = new Color[7];
        colors[0] = Color.BLACK;
        colors[1] = Color.RED;
        colors[2] = Color.BLUE;
        colors[3] = Color.GREEN;
        colors[4] = Color.YELLOW;
        colors[5] = Color.ORANGE;
        colors[6] = Color.MAGENTA;
    }

  //Sobreescribimos el método paint dónde estableceremos las nuevas características del botón.
    public void paint(Graphics g) {
    	//Si hemos clickado el botón pasará al siguiente color
        if (mousePressed) {
            if (currColor == 6) {
            	//Si queremos que vuelva a empezar la lista de colores
            	currColor = 1;
            } else {
                currColor++;
            }
        }
      //Si el botón es visible el color cambiará
        if (visible) {
            g.setColor(colors[currColor]);
        }
      //Para volver a pintar el botón
        if (currColor == 0 || !visible) {
            g.drawOval(0,0,30,30);
        } else {
            g.fillOval(0,0,30,30);
        }
    }

  //Creamos un método para obtener el color actual del bóton
    public int getCurrColor() {
        return currColor;
    }

  //Este método cogera el color actual y lo pintará
    public void setCurrColor(int newColor) {
        currColor = newColor;
      //El método repaint lo utilizamos por los posibles cambios que hemos realizado en el botón
        repaint();
    }

  //Creamos el método para editar el botón
    public void setEdit(boolean edit) {
        editable = edit;
    }

  //Creamos un método para comprobar si es visible el botón o no
    public void setVis(boolean vis) {
        visible = vis;
        repaint();
    }

  //Establecemos el tamaño del botón
    public Dimension getMinimumSize() {
        return new Dimension(30,30);
    }
    public Dimension getPreferredSize() {
        return new Dimension(30,30);
    }

  //Cuando hemos hecho click en el boton
    public void mousePressed(MouseEvent e) {
        if (editable) {
            mousePressed = true;
            repaint();
        }
    }

  //Cuando hemos soltado el boton
    public void mouseReleased(MouseEvent e) {
        mousePressed = false;
    }

    
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
