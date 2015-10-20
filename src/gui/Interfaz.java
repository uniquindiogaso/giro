/**
 * 
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import logica.Ciclista;
import logica.Equipo;

/**
 * Interfaz principal de la aplicaci�n 
 * @author Einer
 * @version 1.0
 */
public class Interfaz extends JFrame implements ActionListener {

	//se declaran todas las etiquetas de texto de la interfaz
	private JLabel txtNombre;
	private JLabel txtID;
	private JLabel txtEdad;
	private JLabel txtNumero;

	//se declaran todos los campos de texto de la interfaz
	private JTextField cmpNombre;
	private JTextField cmpId;
	private JTextField cmpEdad;
	private JTextField cmpNumero;
	
	//se declaran los botones de la interfaz 
	private JButton btnAceptar;
	
	//decaraci�n como atributo de la clase principal de  la aplicaci�n 
	private Equipo equipo;

	/**
	 * metodo donde se inicializan todos los componetes de la clase 
	 */
	public Interfaz() {

		//se declara null para no usar layouts
		getContentPane().setLayout(null);

		//inicializacion de la clase principal
		equipo= new Equipo();

		//INICIALIZACI�N DEL TEXTO QUE SE AGREGAN EN PANTALLA 
		txtID = new JLabel("ID:");
		// se pocisiona en el jframe y se asignan el ancho y alto
		txtID.setBounds(10, 10, 50, 25);
		//se agrega en el JFrame
		getContentPane().add(txtID);

		//se usa otro metodo contructor para inicializar la etiqueta
		txtNombre = new JLabel();
		//se asigna un texto a la etiqueta 
		txtNombre.setText("Nombre:");
		txtNombre.setBounds(10, 40, 50, 25);
		getContentPane().add(txtNombre);
		
		txtEdad = new JLabel("Edad:");
		txtEdad.setBounds(10, 70, 50, 25);
		getContentPane().add(txtEdad);
		
		txtNumero = new JLabel("Numero:");
		txtNumero.setBounds(10, 100, 50, 25);
		getContentPane().add(txtNumero);
		
		//INICIALIZACI�N DE LOS CAMPOS DE TEXTO 
		cmpId = new JTextField();
		cmpId.setBounds(60, 10, 100, 25);
		getContentPane().add(cmpId);
		
		cmpNombre = new JTextField();
		cmpNombre.setBounds(60, 40, 100, 25);
		getContentPane().add(cmpNombre);

		cmpEdad = new JTextField();
		cmpEdad.setBounds(60, 70, 100, 25);
		getContentPane().add(cmpEdad);

		cmpNumero = new JTextField();
		cmpNumero.setBounds(60, 100, 100, 25);
		getContentPane().add(cmpNumero);

		//INICIALIZACI�N DE LOS BOTONES
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(10, 215, 100, 30);
		//adici�n del evento al boton 
		btnAceptar.addActionListener(this);
		getContentPane().add(btnAceptar);

		//titulo de la pantalla
		setTitle("Giro de Italia");
		//setSize(200, 200);
		//tama�o posici�n y tama�o del JFrame
		setBounds(200, 200,300, 400);

	}

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		//se pregunta cual boton fue el presionado
		if (e.getSource() == btnAceptar){
		
			//se obtienen los datos ingresados por el usuario
			String nombre = cmpNombre.getText();
			String id= cmpId.getText();
			int edad= Integer.parseInt(cmpEdad.getText());
			int numero= Integer.parseInt(cmpNumero.getText());
			
			System.out.println("tamanio  "+equipo.getCiclistas().size());
			//se realiza el llamado al metodo agregarCiclista 
			boolean res= equipo.agregarCiclista(new Ciclista(id, nombre, 23, 0, numero));
			System.out.println("tamanio "+equipo.getCiclistas().size());
				
		}
	}

}
