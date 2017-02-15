

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//Realizamos esta clase para personalizar los botones que el usuario podr� ir cambiando de color para seleccionar uno.
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

  //Sobreescribimos el m�todo paint d�nde estableceremos las nuevas caracter�sticas del bot�n.
    public void paint(Graphics g) {
    	//Si hemos clickado el bot�n pasar� al siguiente color
        if (mousePressed) {
            if (currColor == 6) {
            	//Si queremos que vuelva a empezar la lista de colores
            	currColor = 1;
            } else {
                currColor++;
            }
        }
      //Si el bot�n es visible el color cambiar�
        if (visible) {
            g.setColor(colors[currColor]);
        }
      //Para volver a pintar el bot�n
        if (currColor == 0 || !visible) {
            g.drawOval(0,0,30,30);
        } else {
            g.fillOval(0,0,30,30);
        }
    }

  //Creamos un m�todo para obtener el color actual del b�ton
    public int getCurrColor() {
        return currColor;
    }

  //Este m�todo cogera el color actual y lo pintar�
    public void setCurrColor(int newColor) {
        currColor = newColor;
      //El m�todo repaint lo utilizamos por los posibles cambios que hemos realizado en el bot�n
        repaint();
    }

  //Creamos el m�todo para editar el bot�n
    public void setEdit(boolean edit) {
        editable = edit;
    }

  //Creamos un m�todo para comprobar si es visible el bot�n o no
    public void setVis(boolean vis) {
        visible = vis;
        repaint();
    }

  //Establecemos el tama�o del bot�n
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
