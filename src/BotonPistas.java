

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//Personalizamos el Botón para mostrar pistas para el usuario
public class BotonPistas extends JComponent {
	//datos que devuelve el botón cuando el jugador elige un color
    private int  currColor;

    // constructor
    public BotonPistas() {
        currColor = 0;
    }

  //Utilizamos el método paint para pintar el componente como lo queremos
    public void paint(Graphics g) {
        if (currColor == 1) {
            g.setColor(Color.WHITE);
            g.fillOval(10,10,10,10);
        } else if (currColor == 2) {
            g.setColor(Color.BLACK);
            g.fillOval(10,10,10,10);
        } else {
            g.setColor(Color.BLACK);
            g.drawOval(10,10,10,10);
        }
    }

  //Creamos un método para obtener el color actual del bóton
    public int getCurrColor() {
        return currColor;
    }

  //Este método cogera el color actual y lo pintará
    public void setCurrColor(int newColor) {
        currColor = newColor;
        repaint();
    }

  //Establecemos el tamaño del botón
    public Dimension getMinimumSize() {
        return new Dimension(20,20);
    }
    public Dimension getPreferredSize() {
        return new Dimension(20,20);
    }
}
