package vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import modelo.Monomio;
import modelo.Polinomio;

public class Frame extends JFrame {

	private JTextArea txtArea;
	private JButton btnSumar;
	private JButton btnRestar;
	private JButton btnMultiplicar;

	public Frame() {
		super("Operaciones con polinomios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setLayout(new BorderLayout());

		iniciar();
		listeners();

		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void iniciar() {
		txtArea = new JTextArea();
		txtArea.setFont(new Font("Arial", Font.BOLD, 22));
		add(txtArea, BorderLayout.CENTER);

		btnSumar = new JButton("Sumar");
		btnRestar = new JButton("Restar");
		btnMultiplicar = new JButton("Multiplicar");


		JPanel pnlBotones = new JPanel();
		pnlBotones.add(btnSumar);
		pnlBotones.add(btnRestar);
		pnlBotones.add(btnMultiplicar);

		add(pnlBotones, BorderLayout.SOUTH);
	}

	private void listeners() {
		btnSumar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Polinomio p1 = new Polinomio();
				Polinomio p2 = new Polinomio();

				Random r = new Random();
				p1.agregar(new Monomio(r.nextInt(10) + 1, r.nextInt(5)));
				p1.agregar(new Monomio(r.nextInt(10) + 1, r.nextInt(5)));
				p1.agregar(new Monomio(r.nextInt(10) + 1, r.nextInt(5)));
				p1.agregar(new Monomio(r.nextInt(10) + 1, r.nextInt(5)));

				p2.agregar(new Monomio(r.nextInt(10) + 1, r.nextInt(5)));
				p2.agregar(new Monomio(r.nextInt(10) + 1, r.nextInt(5)));
				p2.agregar(new Monomio(r.nextInt(10) + 1, r.nextInt(5)));
				p2.agregar(new Monomio(r.nextInt(10) + 1, r.nextInt(5)));
				p2.agregar(new Monomio(r.nextInt(10) + 1, r.nextInt(5)));

				Polinomio aux1 = Polinomio.simplificar(p1);
				aux1.ordenar();

				Polinomio aux2 = Polinomio.simplificar(p2);
				aux2.ordenar();

				Polinomio suma = Polinomio.sumar(aux1, aux2);
				suma.ordenar();

				String texto = String.format("LA SUMA DE \n%s \nMÁS \n%s \nES: \n %s", 
						aux1, 
						aux2, 
						suma);

				txtArea.setText(texto);
			}
		});

		btnRestar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Polinomio p1 = new Polinomio();
				Polinomio p2 = new Polinomio();

				Random r = new Random();
				p1.agregar(new Monomio(r.nextInt(10) + 1, r.nextInt(5)));
				p1.agregar(new Monomio(r.nextInt(10) + 1, r.nextInt(5)));
				p1.agregar(new Monomio(r.nextInt(10) + 1, r.nextInt(5)));
				p1.agregar(new Monomio(r.nextInt(10) + 1, r.nextInt(5)));

				p2.agregar(new Monomio(r.nextInt(10) + 1, r.nextInt(5)));
				p2.agregar(new Monomio(r.nextInt(10) + 1, r.nextInt(5)));
				p2.agregar(new Monomio(r.nextInt(10) + 1, r.nextInt(5)));
				p2.agregar(new Monomio(r.nextInt(10) + 1, r.nextInt(5)));
				p2.agregar(new Monomio(r.nextInt(10) + 1, r.nextInt(5)));

				Polinomio aux1 = Polinomio.simplificar(p1);
				aux1.ordenar();

				Polinomio aux2 = Polinomio.simplificar(p2);
				aux2.ordenar();
				
				String aux2s = aux2.toString();
				
				Polinomio resta = Polinomio.restar(aux1, aux2);
				resta.ordenar();

				String texto = String.format("LA RESTA DE \n%s \nMENOS \n%s \nES: \n %s", 
						aux1, 
						aux2s, 
						resta);

				txtArea.setText(texto);
			}
		});

		btnMultiplicar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Polinomio p1 = new Polinomio();
				Polinomio p2 = new Polinomio();

				Random r = new Random();
				p1.agregar(new Monomio(r.nextInt(10) + 1, r.nextInt(5)));
				p1.agregar(new Monomio(r.nextInt(10) + 1, r.nextInt(5)));

				p2.agregar(new Monomio(r.nextInt(10) + 1, r.nextInt(5)));
				p2.agregar(new Monomio(r.nextInt(10) + 1, r.nextInt(5)));

				Polinomio aux1 = Polinomio.simplificar(p1);
				aux1.ordenar();

				Polinomio aux2 = Polinomio.simplificar(p2);
				aux2.ordenar();

				Polinomio mult = Polinomio.multiplicar(aux1, aux2);
				mult.ordenar();

				String texto = String.format("LA MULTIPLICACION DE \n%s \nPOR \n%s \nES: \n %s", 
						aux1, 
						aux2, 
						mult);

				txtArea.setText(texto);
			}
		});

	}
}
