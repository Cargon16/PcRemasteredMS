package Presentacion.Command.Vista;

import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.IGUI.VentanaPrincipal;

public class InitCommand implements Command{

	@Override
	public Contexto ejecutar(Object contexto) {
		// TODO Auto-generated method stub
		Contexto context = (Contexto)contexto;
		
		if(context.getDatos()==null)
			VentanaPrincipal.getInstance();
		else {
			Integer i = (Integer) context.getDatos();
			VentanaPrincipal.getInstance().setTitle("Empleado: "+i.toString());
		}
		
		return context ;
	}

}
