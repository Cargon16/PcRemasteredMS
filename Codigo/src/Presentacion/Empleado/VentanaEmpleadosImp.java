package Presentacion.Empleado;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;

public class VentanaEmpleadosImp extends VentanaEmpleados {

	private static final long serialVersionUID = 1L;

	private JPanel contentPaneEmpleado;
	private PanelAddEmpTC empTC;
	private PanelAddEmpTP empTP;
	private panelDeleteEmpleado delete;
	private PanelReadAllEmpleados readAll;
	private PanelReadByIdEmpleado readById;
	private PanelUpdateEmpleado updateEmpleado;

	public VentanaEmpleadosImp() {
		initPanel();
		initComponent();
	}

	@Override
	public void initPanel() {
		delete = new panelDeleteEmpleado();
		readAll = new PanelReadAllEmpleados();
		updateEmpleado = new PanelUpdateEmpleado();
		readById = new PanelReadByIdEmpleado();
		empTP = new PanelAddEmpTP();
		empTC = new PanelAddEmpTC();

	}

	public void initComponent() {
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 737, 698);

		contentPaneEmpleado = new JPanel();
		contentPaneEmpleado.setBackground(SystemColor.activeCaption);
		contentPaneEmpleado.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneEmpleado);
		contentPaneEmpleado.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 5, 706, 93);
		contentPaneEmpleado.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 1, 0, 0));
		final JPanel panel2 = new JPanel();
		panel2.setOpaque(false);
		panel2.setBounds(5, 109, 706, 550);
		contentPaneEmpleado.add(panel2);
		panel2.setLayout(new BorderLayout(0, 0));

		final ArrayList<JPanel> paneles = new ArrayList<JPanel>();

		delete.setVisible(true);
		paneles.add(delete);

		updateEmpleado.setVisible(true);
		paneles.add(updateEmpleado);

		readById.setVisible(true);
		paneles.add(readById);

		readAll.setVisible(true);
		paneles.add(readAll);

		empTP.setVisible(true);
		paneles.add(empTP);

		empTC.setVisible(true);
		paneles.add(empTC);

		final JComboBox combo = new JComboBox();
		combo.addItem("A�adir empleado");
		combo.addItem("Tiempo Completo");
		combo.addItem("Tiempo Parcial");
		panel_1.add(combo);
		combo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == combo) {
					String seleccionado = (String) combo.getSelectedItem();
					int x=0;
					if (seleccionado.contains("Tiempo Completo")) {
						x = 2;
					} else {
						if(seleccionado.contains("Tiempo Parcial"))
						x = 3;
					}

					switch (x) {
					case 2:
						panel2.removeAll();
						setTitle("Anadir empleado tiempo completo");
						empTC.resetCamps();
						panel2.add(paneles.get(5));
						SwingUtilities.updateComponentTreeUI(getContentPane());

						break;
					case 3:
						panel2.removeAll();
						setTitle("A�adir empleado tiempo parcial");
						empTP.resetCamps();
						panel2.add(paneles.get(4));
						SwingUtilities.updateComponentTreeUI(getContentPane());
						break;
					default:
						break;
					}
				}

			}
		});

		JButton eliminar = new JButton("<html>Eliminar <br /> empleado</html>");
		eliminar.setFont(new Font("Consolas", Font.BOLD, 11));
		eliminar.setBackground(SystemColor.activeCaptionBorder);
		eliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel2.removeAll();
				setTitle("Eliminar empleado");
				delete.resetCamps();
				panel2.add(paneles.get(0), SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane());
			}
		});
		panel_1.add(eliminar);

		JButton actualizar = new JButton("<html>Actualizar <br /> empleado</html>");
		actualizar.setFont(new Font("Consolas", Font.BOLD, 11));
		actualizar.setBackground(SystemColor.activeCaptionBorder);
		actualizar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel2.removeAll();
				setTitle("Actualizar Empleado");
				updateEmpleado.resetCamps();
				panel2.add(paneles.get(1), SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane());
			}
		});
		panel_1.add(actualizar);

		JButton mostrarID = new JButton("<html>Mostrar <br /> empleado</html>");
		mostrarID.setFont(new Font("Consolas", Font.BOLD, 11));
		mostrarID.setBackground(SystemColor.activeCaptionBorder);
		mostrarID.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel2.removeAll();
				setTitle("Mostar Empleado");
				readById.resetCamps();
				panel2.add(paneles.get(2), SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane());
			}
		});
		panel_1.add(mostrarID);

		JButton mostrarTodo = new JButton("<html>Mostrar todos <br />los empleados</html>");
		mostrarTodo.setFont(new Font("Consolas", Font.BOLD, 11));
		mostrarTodo.setBackground(SystemColor.activeCaptionBorder);
		mostrarTodo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel2.removeAll();
				setTitle("Mostrar Empleados");
				readAll.resetCamps();
				panel2.add(paneles.get(3), SwingConstants.CENTER);
				SwingUtilities.updateComponentTreeUI(getContentPane());
			}
		});
		panel_1.add(mostrarTodo);

		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("Closed");
				VentanaEmpleados.setInstance(null);
			}
		});

	}

	@Override
	public void resetCamps() {
	}

	@Override
	public void actualizar(Contexto contexto) {
		// TODO Auto-generated method stub
		switch (contexto.getEvento()) {
		case Eventos.addEmpleadoTiempoParcialCommandError:JOptionPane.showMessageDialog(null, "No se ha dado de alta al empleado");break;
		case Eventos.addEmpleadoTiempoParcialCommand:JOptionPane.showMessageDialog(null, "Se ha creado el empleado parcial con id " + contexto.getDatos());break;
		case Eventos.addEmpleadoTiempoCompletoCommandError:if(Integer.valueOf(contexto.getDatos().toString()) == -4)
			JOptionPane.showMessageDialog(null, "Ese departamento no existe");
			else
			JOptionPane.showMessageDialog(null, "No se ha dado de alta al empleado");break;
		case Eventos.addEmpleadoTiempoCompletoCommand:JOptionPane.showMessageDialog(null, "Se ha creado el empleado completo con id " + contexto.getDatos());break;
		case Eventos.readEmpleadoCommand:readById.actualizar(contexto);updateEmpleado.actualizar(contexto);break;
		case Eventos.readEmpleadoCommandError:JOptionPane.showMessageDialog(null, "El empleado no existe");break;
		case Eventos.borrarEmpleadoCommand:JOptionPane.showMessageDialog(null,"Se ha eliminado el empleado con id " + contexto.getDatos() + "\n  exitosamente ");break;
		case Eventos.borrarEmpleadoCommandError:JOptionPane.showMessageDialog(null, "No se ha podido eliminar el empleado");break;
		case Eventos.readAllEmpleadoCommand:readAll.actualizar(contexto);break;
		case Eventos.readAllEmpleadoCommandError:JOptionPane.showMessageDialog(null, "No hay empleados registrados \n en la base de datos");break;
		case Eventos.updateEmpeladoCommandError:
			if(Integer.valueOf(contexto.getDatos().toString()) == -2)JOptionPane.showMessageDialog(null, "No se puede cambiar la situaci�n de un empleado.");
				else JOptionPane.showMessageDialog(null, "Ha ocurrido un error");break;
		case Eventos.updateEmpeladoCommand:JOptionPane.showMessageDialog(null,"El empleado con ID:  " + contexto.getDatos() + " ha sido actualizado.");break;
		case Eventos.listaDepartamentosCommand:empTC.actualizarListaDepartamentos(contexto);empTP.actualizarListaDepartamentos(contexto);break;
		case Eventos.listaDepartamentosCommandError:JOptionPane.showMessageDialog(null, "No hay departamentos registrados");break;
		default:
			break;
		}

	}

}
