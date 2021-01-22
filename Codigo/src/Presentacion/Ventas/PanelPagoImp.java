package Presentacion.Ventas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import Negocio.Producto.TProducto;
import Negocio.Venta.LineaVenta;
import Negocio.Venta.TVentaDetalles;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;
import Presentacion.Controlador.Controller;

import java.awt.Font;
import java.awt.SystemColor;

public class PanelPagoImp extends PanelPago{

	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
	@SuppressWarnings("unused")
	private static ArrayList<TProducto> lista;
	private static int idventa;
	@SuppressWarnings("unused")
	private static float total;
	private JButton btnProcesar;
	private JLabel lblTotal;

	public PanelPagoImp() {
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 737, 598);
		getContentPane().setLayout(null);

		btnProcesar = new JButton("Pagar");
		btnProcesar.setBackground(SystemColor.textHighlight);
		btnProcesar.setBounds(295, 127, 170, 41);
		getContentPane().add(btnProcesar);

		textArea = new JTextArea();
		textArea.setBounds(31, 77, 221, 272);
		getContentPane().add(textArea);


		JLabel lblProductosAadidos = new JLabel("Ticket de compra");
		lblProductosAadidos.setBounds(31, 50, 151, 14);
		getContentPane().add(lblProductosAadidos);

		JLabel lblVentanaDePago = new JLabel("VENTANA DE PAGO");
		lblVentanaDePago.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVentanaDePago.setBounds(31, 13, 159, 29);
		getContentPane().add(lblVentanaDePago);

		lblTotal = new JLabel("TOTAL");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTotal.setBounds(295, 77, 170, 27);
		getContentPane().add(lblTotal);
		btnProcesar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if(lblTotal.getText().equals("TOTAL: 0.0")){
					JOptionPane.showMessageDialog(null, "La compra esta vacia");

				}else{
					Controller.getInstance().ejecutar(new Contexto(Eventos.pagoProductoVenta, idventa));
					JOptionPane.showMessageDialog(null, "La venta ha sido pagada.");
					dispose();
					PanelPago.setInstance(null);
					
				}

					
			}
			
		});
		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				System.out.println("Closed");
				PanelPago.setInstance(null);        }
		});

	}

	@Override
	public void actualizar(Contexto contexto) {
		Integer idP;
		LineaVenta precioP;
		String texto="";
		

		textArea.setText("");
		TVentaDetalles ven = (TVentaDetalles) contexto.getDatos();
		
		ArrayList<TVentaDetalles> objects = new ArrayList<TVentaDetalles>();
		objects.add(ven);

		TVentaDetalles venta = (TVentaDetalles) objects.get(0);
		lblTotal.setText("TOTAL: " + venta.getVenta().getPrecioTotal());
		idventa = venta.getVenta().getIDVenta();
		HashMap<Integer, LineaVenta> map = venta.getVenta().getLineaVentas();
		texto += "Cliente: " + venta.getCliente().getNombre() + "\n";
		for (Entry<Integer, LineaVenta> entry : map.entrySet()) {
			idP=entry.getKey();
			precioP = entry.getValue();
			int Cantidad = precioP.getCantidad();

			texto+= "ID:"+ idP +"\n"+ "Cantidad: "+ Cantidad +"\n"; 

		}
		texto+= "Precio Total: " + venta.getVenta().getPrecioTotal() + "\n" +"Pagado: "+ venta.getVenta().getPagado() +"\n"; 
		textArea.setText(texto);


	}

	@Override
	public void resetCamps() {
		textArea.setText(null);

	}

}

