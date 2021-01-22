package Presentacion.Factorias;

import java.lang.reflect.Constructor;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import Presentacion.Command.Command;


public class FactoriaCommandsImp extends FactoriaCommands {

	@Override
	public Command generacionCommand(int evento) {
		// TODO Auto-generated method stub
		Command comando = null;
		try {
			XPathFactory xPathFact = XPathFactory.newInstance();
			XPath xpath = xPathFact.newXPath();
			InputSource input = new InputSource("Commands.xml");
			String expresion = "//*[@id='"+ evento +"'][1]";
			Node  element = (Node) xpath.evaluate(expresion, input,XPathConstants.NODE);
			
			if(element != null){
				String nombre = element.getTextContent().trim();
				Class<?> clase = Class.forName(nombre);
				Constructor<?> constructor = clase.getConstructor();
				comando= (Command) constructor.newInstance();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return comando;
	}
	
}
