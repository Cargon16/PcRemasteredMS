package Presentacion.Departamento;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
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

public class VentanaDepartamentosImp extends VentanaDepartamento {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PanelAddDepartamento anadir;
	private PanelDeleteDepartamento eliminar;
	private PanelUpdateDepartamento actualizar;
	private PanelReadByIdDepartamento mID;
	private PanelReadAllDepartamentos mAll;
	private PanelCalcularCosteDepartamento coste;
	private JButton botonCoste;
	private JButton botonanadir;
	private JButton botonEliminar;
	private JButton botonActualizar;
	private JButton botonMostrarID;
	private JButton botonMostrarTodo;

	public VentanaDepartamentosImp(){
		
		initComponent();
	}
	@Override
	public void initPanel(){
		
		anadir = new PanelAddDepartamento();
		eliminar = new PanelDeleteDepartamento();
		actualizar = new PanelUpdateDepartamento();
		mID = new PanelReadByIdDepartamento();
		mAll = new PanelReadAllDepartamentos();
		coste = new PanelCalcularCosteDepartamento();
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
		
		coste.setVisible(true);
		paneles.add(coste);
		

		botonanadir = new JButton("<html>A�adir<br /> Departamento");
		botonanadir.setFont(new Font("Consolas", Font.BOLD, 11));
		botonanadir.setBackground(SystemColor.activeCaptionBorder);

		botonanadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2.removeAll();
				setTitle("A�adir Departamento");
				anadir.resetCamps();
				panel2.add(paneles.get(0),SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane()); 
			


			}
		});
		panel_1.add(botonanadir);

		botonEliminar = new JButton("<html>Eliminar <br /> Departamento</html>");
		botonEliminar.setFont(new Font("Consolas", Font.BOLD, 11));
		botonEliminar.setBackground(SystemColor.activeCaptionBorder);
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2.removeAll();
				setTitle("Eliminar Departamento");
				eliminar.resetCamps();
				panel2.add(paneles.get(1),SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane()); 
				
			}
		});
		panel_1.add(botonEliminar);

		botonActualizar = new JButton("<html>Actualizar<br /> departamento");
		botonActualizar.setFont(new Font("Consolas", Font.BOLD, 11));
		botonActualizar.setBackground(SystemColor.activeCaptionBorder);
		botonActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel2.removeAll();
				setTitle("Actualizar departamento");
				actualizar.resetCamps();
				panel2.add(paneles.get(2),SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane()); 
				
			}
		});
		panel_1.add(botonActualizar);

		botonMostrarID = new JButton("<html>Mostrar departamento<br /> por su ID </html>");
		botonMostrarID.setFont(new Font("Consolas", Font.BOLD, 11));
		botonMostrarID.setBackground(SystemColor.activeCaptionBorder);

		botonMostrarID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2.removeAll();
				setTitle("Mostrar Departamento por ID");
				mID.resetCamps();
				panel2.add(paneles.get(3),SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane());
			}
		});
		panel_1.add(botonMostrarID);

		botonMostrarTodo = new JButton("<html>Mostrar todos<br /> los Departamentos</html>");
		botonMostrarTodo.setFont(new Font("Consolas", Font.BOLD, 11));
		botonMostrarTodo.setBackground(SystemColor.activeCaptionBorder);

		botonMostrarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2.removeAll();
				setTitle("Mostrar todos los Departamentos ");
				mAll.resetCamps();
				panel2.add(paneles.get(4),SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane());
			}
		});
		panel_1.add(botonMostrarTodo);
		
		botonCoste = new JButton("<html>Calcular <br />coste<br /> departamento");
		botonCoste.setFont(new Font("Consolas", Font.BOLD, 11));
		botonCoste.setBackground(SystemColor.activeCaptionBorder);
		
		botonCoste.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel2.removeAll();
				setTitle("Calcular coste departamento");
				coste.resetCamps();
				panel2.add(paneles.get(5),SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane()); 
			}
		});
		panel_1.add(botonCoste);


		
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				System.out.println("Closed");
				VentanaDepartamento.setInstance(null);        }
		});
	}


	@Override
	public void actualizar(Contexto contexto) {
		

		switch (contexto.getEvento()) {
		case Eventos.crearDepartamentoCommand: JOptionPane.showMessageDialog(null, "Se ha creado el departamento con id " +contexto.getDatos()); break;
		case Eventos.ReactivarDepartamentoCommand: JOptionPane.showMessageDialog(null, "Se ha reactivado el departamento"); break;
		case Eventos.crearDepartamentoCommandError: JOptionPane.showMessageDialog(null, "No se ha podido dar de alta el departamento"); break;
		case Eventos.readDepartamentoCommand: mID.actualizar(contexto);actualizar.actualizar(contexto);break;
		case Eventos.readDepartamentoCommandError: JOptionPane.showMessageDialog(null, "El departamento no existe");break;
		case Eventos.borrarDepartamentoCommand:JOptionPane.showMessageDialog(null, "Se ha eliminado el departamento con id " +contexto.getDatos() + "\n existosamente") ;break;
		case Eventos.borrarDepartamentoCommandError: if ( (Integer)contexto.getDatos() ==-3)
			JOptionPane.showMessageDialog(null, "El departamento ya esta inactivo");
			else if( (Integer)contexto.getDatos() ==-2)
				JOptionPane.showMessageDialog(null, "Ese departamento no existe");
			else if((Integer)contexto.getDatos() == -4){
				JOptionPane.showMessageDialog(null, "El departamento tiene empleados asignados, elimine los empleados para poder eliminar el departamento");
			}else
				JOptionPane.showMessageDialog(null, "Ha habido un problema al borrar el departamento");
		;break;
		case Eventos.readAllDepartamentoCommand: mAll.actualizar(contexto); break;
		case Eventos.readAllDepartamentoCommandError:JOptionPane.showMessageDialog(null, "No hay departamentos registrados \n en la base de datos");break;
		case Eventos.updateDepartamentoCommandError: if((Integer)contexto.getDatos() ==-4)
			JOptionPane.showMessageDialog(null, "Ese departamento est� inactivo, no se puede actualizar");
			else
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error, no se ha actualizado el departamento");break;
		case Eventos.updateDepartamentoCommand: actualizar.actualizar(contexto); JOptionPane.showMessageDialog(null, "Departamento actualizado con exito");break;
		case Eventos.costeDepartamentoCommand: coste.actualizar(contexto); break;
		case Eventos.costeDepartamentoCommandError: JOptionPane.showMessageDialog(null, "Error mostrar coste departamento");break;
		default:
			break;
		}
	}

	@Override
	public void resetCamps() {		
	}


}
