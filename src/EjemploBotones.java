import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class EjemploBotones extends JPanel{

	
	 public void paint(Graphics g) {
		//Botones para elegir color  g.drawRoundRect(0,0,40,40,20,20);
		//Botones para pistas g.drawRoundRect(0,0,20,20,40,40);
		  }
	public static void main(String[] args) {
		 JFrame frame = new JFrame();
		    frame.getContentPane().add(new EjemploBotones());

		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setSize(200, 200);
		    frame.setVisible(true);

	}

}
