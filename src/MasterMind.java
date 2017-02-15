import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class MasterMind extends JFrame implements ActionListener {
	// Creamos la vista de los botones personalizados para elegir color
	BotonSecuencia secuencia[][];
	BotonPistas pista[][];

	// Creamos la vista de los botones para las pistas
	BotonSecuencia tecla[];

	// Creamos un botón para aceptar los colores a adivinar
	JButton btnEnter;

	// Creamos un contador para que cuente la posicion de cada boton dependiendo
	// del color que haya elegido el jugador
	int contador;

	int mode;

	// Representación de las diferentes teclas
	String keyVal = new String();

	// Creamos un random para generar aleatoriamente los valores
	Random rand = new Random();

	public static void main(String args[]) {
		new MasterMind();
	}

	// constructor
	public MasterMind() {
		super("MasterMind");
		iniciarGUI();
		initValues();
		registerListeners();
	}

	public void iniciarGUI() {
		// Creamos dos paneles, uno principal dónde estará todo el juego y otro
		// panel dónde esté solo la fila de los botones

		JPanel panelPrincipal = new JPanel();

		panelPrincipal.setBackground(Color.LIGHT_GRAY);
		panelPrincipal.setLayout(new GridLayout(11, 2, 0, 15));
		JPanelBackground panelSecuencia = new JPanelBackground();
		panelSecuencia.setBackground("img/placas_madera.png");

		// creamos los botones de la secuencia que el usuario deberá adivinar
		tecla = new BotonSecuencia[4];
		for (int i = 0; i < 4; i++) {
			tecla[i] = new BotonSecuencia();
			panelSecuencia.add(tecla[i]);
		}

		// Creamos una barra separadora entre las pistas y los botones
		panelPrincipal.add(new JSeparator(SwingConstants.HORIZONTAL));
		panelPrincipal.add(new JSeparator(SwingConstants.HORIZONTAL));

		// Creamos los paneles dónde estarán los botones de adivinar y el panel
		// dónde se encontrará los botones de pistas al usuario
		JPanelBackground panelesSecuenciaUsuario[] = new JPanelBackground[10];
		JPanelBackground panelesPistas[] = new JPanelBackground[10];
		secuencia = new BotonSecuencia[10][4];
		pista = new BotonPistas[10][4];
		for (int i = 0; i < 10; i++) {
			panelesPistas[i] = new JPanelBackground();
			panelesPistas[i].setBackground("img/placas_metal.png");
			panelesPistas[i].setLayout(new GridLayout(0, 4));
			panelesSecuenciaUsuario[i] = new JPanelBackground();
			panelesSecuenciaUsuario[i].setBackground("img/fondo_madera2.png");
			for (int j = 0; j < 4; j++) {
				pista[i][j] = new BotonPistas();
				panelesPistas[i].add(pista[i][j]);
				secuencia[i][j] = new BotonSecuencia();
				panelesSecuenciaUsuario[i].add(secuencia[i][j]);
			}
			panelPrincipal.add(panelesPistas[i]);
			panelPrincipal.add(panelesSecuenciaUsuario[i]);
		}

		// boton aceptar
		btnEnter = new JButton("Aceptar");
		JPanel enterPanel = new JPanel();
		enterPanel.setBackground(Color.YELLOW);
		enterPanel.add(btnEnter);

		// Contenedor principal
		JLabel label = new JLabel("Adivina esta secuencia!");
		panelSecuencia.add(label);
		Container ventana = this.getContentPane();
		ventana.setLayout(new BorderLayout());
		ventana.add(panelSecuencia, BorderLayout.NORTH);
		ventana.add(panelPrincipal, BorderLayout.CENTER);
		ventana.add(enterPanel, BorderLayout.SOUTH);

		pack();
		setDefaultCloseOperation(MasterMind.EXIT_ON_CLOSE);
		setSize(325, 700);
		setVisible(true);
	}

	// Creamos un método que restablezca el juego al inicio y lo inicialice
	public void initValues() {
		// Realizamos una ventana para inicializar el juego

		ImageIcon icon = new ImageIcon("img/mastermind.png");
		String[] options = { "Comenzar" };

		mode = JOptionPane.showOptionDialog(null, "Vamos a empezar la partida!", "Iniciar", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, icon, options, options[0]);

		// iniciamos el contador
		contador = 9;

		// iniciamos la secuencia
		for (int i = 0; i < 4; i++) {

			if (mode == 0) {
				tecla[i].setVis(false);
				tecla[i].setCurrColor((rand.nextInt(6) + 1));
			} else {

				tecla[i].setCurrColor(0);
				tecla[i].setEdit(true);
			}
		}

		// guarda la secuencia de teclas en un string si existen
		if (mode == 0) {
			keyVal = stringValue(tecla);
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 4; j++) {
				secuencia[i][j].setCurrColor(0);
				if (i == 9 && mode == 0) {
					secuencia[i][j].setEdit(true);
				} else {
					secuencia[i][j].setEdit(false);
				}
				pista[i][j].setCurrColor(0);
			}
		}
	}

	// Utilizamos este método para poder contabilizar que colores escoge el
	// usuario
	public String stringValue(BotonSecuencia[] buttons) {
		String value = new String();

		for (int i = 0; i < buttons.length; i++) {
			value += String.format("%d", buttons[i].getCurrColor());
		}

		System.out.println(value);
		return value;
	}

	public void registerListeners() {
		btnEnter.addActionListener(this);
	}

	// mediante el método action performed establecemos la acción que llevará a
	// cabo el botón aceptar
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		if (e.getSource() == btnEnter && mode == 0) {

			submitGuess();
		} else {
			System.out.println("ERROR");
		}
	}

	// controla si están todos los colores puestos
	public void submitGuess() {
		boolean win = false;

		if (validGuess(secuencia[contador])) {
			// puntuacion para ganar
			win = returnClue();
			if (win) {
				System.out.println("ganador");
				gameOver(true);
				return;
			}

			// decremento del contador para la proxima pista
			contador--;

			// controla si pierde el usuario
			if (contador < 0) {
				gameOver(false);
				return;
			}

			for (int i = 0; i < 4; i++) {
				secuencia[contador][i].setEdit(true);
				secuencia[contador + 1][i].setEdit(false);
			}
		}
	}

	// comprueba que todos los circulos se han rellenado
	public boolean validGuess(BotonSecuencia[] button) {
		for (int i = 0; i < 4; i++) {
			if (button[i].getCurrColor() == 0) {
				return false;
			}
		}
		return true;
	}

	// para acabar la partida
	public void gameOver(boolean winner) {
		// revelamos la secuencia que tenia que adivinar el usuario
		for (int i = 0; i < 4; i++) {
			tecla[i].setVis(true);
		}

		// enviamos un mensaje al usuario
		String msg = new String();
		if (winner) {
			msg = "Has ganado!";
		} else {
			msg = "Has perdido!";
		}

		// este será el mensaje
		int ans = JOptionPane.showConfirmDialog(null, "Quieres jugar otra partida?", msg, JOptionPane.YES_NO_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		// reseteamos el juego o salimos
		if (ans == 0) {
			initValues();
		} else if (ans == 1) {
			System.exit(0);
		} else {
			System.out.println("ERROR");
		}
	}

	// calculamos las maximas posibilidades con los colores
	public int getMax(String attempt, ArrayList<String> set) {
		// posibles resultados
		String[] scores = { "0,0", "0,1", "0,2", "0,3", "0,4", "1,0", "1,1", "1,2", "1,3", "2,0", "2,1", "2,2", "3,0",
				"4,0" };
		// contador
		int max = 0;

		// para cada resultado
		for (int i = 0; i < scores.length; i++) {
			int cnt = 0;
			// comparamos la secuencia del usuario con la que tiene que resolver

			for (int j = 0; j < set.size(); j++) {
				if (score(set.get(j), attempt).equals(scores[i])) {
					cnt++;
				}
			}

			if (cnt > max) {
				max = cnt;
			}
		}

		return max;
	}

	// mostramos las pistas
	public boolean returnClue() {

		int exactMatch = 0;

		int colorMatch = 0;

		int result = 0;

		String guessVal = new String();

		String sc[] = new String[2];

		guessVal = stringValue(secuencia[contador]);
		sc = score(keyVal, guessVal).split(",");
		System.out.println(sc[0] + "," + sc[1]);

		for (int i = Integer.parseInt(sc[0]); i > 0; i--) {
			pista[contador][result].setCurrColor(2);
			result++;
		}

		for (int i = Integer.parseInt(sc[1]); i > 0; i--) {
			pista[contador][result].setCurrColor(1);
			result++;
		}

		if (sc[0].equals("4")) {
			return true;
		} else {
			return false;
		}
	}

	// calculamos el resultado a partir de los números designados de cada color
	// y dependiendo de la posición
	public String score(String key, String guess) {
		int exactMatch = 0;
		int colorMatch = 0;

		// encuentra posición y color exacto
		for (int i = 0; i < 4; i++) {
			if (key.charAt(i) == guess.charAt(i)) {
				exactMatch++;
			}
		}

		// sólo color
		for (int i = 1; i < 7; i++) {
			colorMatch += Math.min(count(key, Character.forDigit(i, 10)), count(guess, Character.forDigit(i, 10)));
		}

		colorMatch -= exactMatch;

		return exactMatch + "," + colorMatch;
	}

	public int count(String value, char x) {
		int cnt = 0;
		for (int i = 0; i < value.length(); i++) {
			if (value.charAt(i) == x) {
				cnt++;
			}
		}
		return cnt;
	}
}