package Presentacion.Clientes;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;

import java.awt.SystemColor;
import java.awt.Font;

public class VentanaClientesImp extends VentanaClientes{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PanelAddClientes anadir;
	private PanelDeleteClientes eliminar;
	private PanelUpdateClientes actualizar;
	private PanelReadByIdClientes mID;
	private PanelReadAllClientes mAll;
	private JButton botonanadir;
	private JButton botonEliminar;
	private JButton botonActualizar;
	private JButton botonMostrarID;
	private JButton botonMostrarTodo;

	public VentanaClientesImp(){
		
		initComponent();
	}
	@Override
	public void initPanel(){
		
		anadir = new PanelAddClientes();
		eliminar = new PanelDeleteClientes();
		actualizar = new PanelUpdateClientes();
		mID = new PanelReadByIdClientes();
		mAll = new PanelReadAllClientes();
		contentPane = new JPanel();
		
	}
	@Override
	public void initComponent() {
		initPanel();
	
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 737, 598);

		
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 5, 706, 93);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 1, 0, 0));

		final JPanel panel2 = new JPanel();
		panel2.setOpaque(false);
		panel2.setBounds(5, 109, 706, 439);
		contentPane.add(panel2);
		panel2.setLayout(new BorderLayout(0, 0));

		final ArrayList<JPanel> paneles = new ArrayList<JPanel>();
		anadir.setVisible(true);
		paneles.add(anadir);

		eliminar.setVisible(true);
		paneles.add(eliminar);

		actualizar.setVisible(true);
		paneles.add(actualizar);

		mID.setVisible(true);
		paneles.add(mID);

		mAll.setVisible(true);
		paneles.add(mAll);


		botonanadir = new JButton("Añadir Cliente");
		botonanadir.setFont(new Font("Consolas", Font.BOLD, 11));
		botonanadir.setBackground(SystemColor.activeCaptionBorder);

		botonanadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2.removeAll();
				setTitle("Añadir cliente");
				anadir.resetCamps();
				panel2.add(paneles.get(0),SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane()); 
			


			}
		});
		panel_1.add(botonanadir);

		botonEliminar = new JButton("<html>Eliminar <br /> clientes</html>");
		botonEliminar.setFont(new Font("Consolas", Font.BOLD, 11));
		botonEliminar.setBackground(SystemColor.activeCaptionBorder);
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2.removeAll();
				setTitle("Eliminar cliente");
				eliminar.resetCamps();
				panel2.add(paneles.get(1),SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane()); 
				
			}
		});
		panel_1.add(botonEliminar);

		botonActualizar = new JButton("<html>Actualizar<br /> clientes</html>");
		botonActualizar.setFont(new Font("Consolas", Font.BOLD, 11));
		botonActualizar.setBackground(SystemColor.activeCaptionBorder);
		botonActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel2.removeAll();
				setTitle("Actualizar cliente");
				actualizar.resetCamps();
				panel2.add(paneles.get(2),SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane()); 
				
			}
		});
		panel_1.add(botonActualizar);

		botonMostrarID = new JButton("<html>Mostrar clientes<br /> por su ID </html>");
		botonMostrarID.setFont(new Font("Consolas", Font.BOLD, 11));
		botonMostrarID.setBackground(SystemColor.activeCaptionBorder);

		botonMostrarID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2.removeAll();
				setTitle("Mostrar clientes por ID");
				mID.resetCamps();
				panel2.add(paneles.get(3),SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane());
			}
		});
		panel_1.add(botonMostrarID);

		botonMostrarTodo = new JButton("<html>Mostrar todos<br /> los clientes</html>");
		botonMostrarTodo.setFont(new Font("Consolas", Font.BOLD, 11));
		botonMostrarTodo.setBackground(SystemColor.activeCaptionBorder);

		botonMostrarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2.removeAll();
				setTitle("Mostrar todos los clientes ");
				mAll.resetCamps();
				panel2.add(paneles.get(4),SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane());
			}
		});
		panel_1.add(botonMostrarTodo);
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				System.out.println("Closed");
				VentanaClientes.setInstance(null);        }
		});
	}


	@Override
	public void actualizar(Contexto contexto) {
		

		switch (contexto.getEvento()) {
		case Eventos.createClienteCommand: JOptionPane.showMessageDialog(null, "Se ha creado el cliente nuevo con id " +contexto.getDatos()); break;
		case Eventos.createClienteErrorCommand: JOptionPane.showMessageDialog(null, "No se ha podido dar de alta el cliente"); break;
		case Eventos.readClienteCommand: mID.actualizar(contexto);actualizar.actualizar(contexto);break;
		case Eventos.readClienteErrorCommand: JOptionPane.showMessageDialog(null, "El cliente no existe");break;
		case Eventos.deleteClienteCommand:JOptionPane.showMessageDialog(null, "Se ha eliminado el cliente con id" +contexto.getDatos() + "\n existosamente") ;break;
		case Eventos.deleteClienteErrorCommand: if ( (Integer)contexto.getDatos() ==-2)
			JOptionPane.showMessageDialog(null, "El cliente no existe");
		else if( (Integer)contexto.getDatos()==-1)
			JOptionPane.showMessageDialog(null, "El cliente ya esta inactivo");
		;break;
		case Eventos.readAllClienteCommand: mAll.actualizar(contexto); break;
		case Eventos.readAllClienteErrorCommand:JOptionPane.showMessageDialog(null, "No hay clientes registrados \n en la base de datos");break;
		case Eventos.updateClienteCommand: JOptionPane.showMessageDialog(null, "Se ha actualizado el cliente con id " +contexto.getDatos()); break;
		case Eventos.updateClienteErrorCommand : JOptionPane.showMessageDialog(null, "No ha sido posible actualizar");break;
		default:
			break;
		}
	}

	@Override
	public void resetCamps() {		
	}
}