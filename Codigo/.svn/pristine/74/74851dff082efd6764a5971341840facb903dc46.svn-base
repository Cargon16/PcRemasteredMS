package Presentacion.Dispatcher;

import java.lang.reflect.Method;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import Presentacion.Command.Contexto;
import Presentacion.IGUI.Ventana;

public class DispatcherImp extends Dispatcher {

	@Override
	public void generarVista(Contexto contexto) {
		// TODO Auto-generated method stub

		try {
			XPathFactory factory = XPathFactory.newInstance();
			XPath xpath = factory.newXPath();
			InputSource input = new InputSource("Dispatcher.xml");
			String expresion = "//*[@id='" + contexto.getEvento() + "'][1]";
			Node elemento = (Node) xpath.evaluate(expresion, input, XPathConstants.NODE);

			String name = elemento.getTextContent().trim();
			Class<?> vista = Class.forName(name);
			Method method = vista.getMethod("getInstance");
			Ventana ventana = (Ventana) method.invoke(null);

			ventana.actualizar(contexto);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error dispatcher vista: " + e.getMessage());
		}

	}

}
