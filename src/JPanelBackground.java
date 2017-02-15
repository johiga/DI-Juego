
import java.awt.Graphics;
import java.awt.Image;
 
import javax.swing.ImageIcon;
import javax.swing.JPanel;
 
 //Clase que extiende de JPanel y permite poner una imagen como fondo.
  
 
 
public class JPanelBackground extends JPanel {
 
	// Atributo que guardara la imagen de Background que le pasemos.
	private Image background;
 
	// Metodo que es llamado automaticamente por la maquina virtual Java cada vez que repinta
	public void paintComponent(Graphics g) {
 
		/* Obtenemos el tama�o del panel para hacer que se ajuste a este
		cada vez que redimensionemos la ventana y se lo pasamos al drawImage */
		int width = getSize().width;
		int height = getSize().height;
 
		// Mandamos que pinte la imagen en el panel
		if (background != null) {
			g.drawImage(background, 0, 0, width, height, null);
		}
 
		super.paintComponent(g);
	}
 
	// Metodo donde le pasaremos la direcci�n de la imagen a cargar.
	public void setBackground(String imagePath) {
		
		// Construimos la imagen y se la asignamos al atributo background.
		setOpaque(false);
		background = new ImageIcon(imagePath).getImage();
		repaint();
	}
 
}