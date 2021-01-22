package Presentacion.Command;

public class Eventos {
	
	/////////---------------------Ventanas principales--------------------------------------//////////////
	public static final int GUI=1000;
	public static final int VistaCLientes=901;
	public static final int VistaVentas=902;
	public static final int VistaPago=903;
	public static final int VistaProducto=904;
	public static final int VistaEmpelado=905;
	public static final int VistaDepartamento=906; 
	public static final int VistaCompetencia=907;
	
	/////--------------------Comandos Ejecucion CLIENTE----------------------------------------////////////
	public static final int createCliente=101;
	public static final int updateCliente=102;
	public static final int readAllCliente=103;
	public static final int deleteCliente=104;
	public static final int readCliente=105;
	///////-----------------------Eventos CLIENTE-----------------------------------------------/////////
	public static final int readAllClienteCommand=1001;
	public static final int readClienteCommand=1002;
	public static final int createClienteCommand=1003;
	public static final int deleteClienteCommand=1004;
	public static final int updateClienteCommand=1005;
	/////-----------------------------Eventos Errores CLIENTE-----------------------------------////////
	public static final int createClienteErrorCommand=10001;
	public static final int readAllClienteErrorCommand=10002;
	public static final int updateClienteErrorCommand=10003;
	public static final int readClienteErrorCommand=10004;
	public static final int deleteClienteErrorCommand=10005;
	
	////-------------------------------Comandos Ejecucion PRODUCTO---------------------------------//////////
	public static final int createProducto=201;
	public static final int createOrdenador=202;
	public static final int createMonitor=203;
	public static final int queryMonitor=204;
	public static final int queryOrdenador=205;
	public static final int updateProducto=206;
	public static final int readAllProducto=207;
	public static final int deleteProducto=208;
	public static final int readProducto=209;
	public static final int readByIdProductos=210;
	////--------------------------------Eventos PRODUCTO-----------------------------------------------/////////
	public static final int createProductoCommand=2001;
	public static final int createOrdenadorCommand=2002;
	public static final int createMonitorCommand=2003;
	public static final int queryMonitorCommand=2004;
	public static final int queryOrdenadorCommand=2005;
	public static final int updateProductoCommand=2006;
	public static final int readAllProductoCommand=2007;
	public static final int deleteProductoCommand=2008;
	public static final int readProductoCommand=2009;
	public static final int readByIdProductosCommand=2010;
	/////-----------------------------Eventos error PRODUCTO-----------------------------------------////////////
	public static final int createProductoCommandError=20001;
	public static final int createOrdenadorCommandError=20002;
	public static final int createMonitorCommandError=20003;
	public static final int queryMonitorCommandError=20004;
	public static final int queryOrdenadorCommandError=20005;
	public static final int updateProductoCommandError=20006;
	public static final int readAllProductoCommandError=20007;
	public static final int deleteProductoCommandError=20008;
	public static final int readProductoCommandError=20009;
	public static final int readByIdProductosCommandError=20010;
	public static final int createProductoErrorExisteCommand=20011;

	//////------------------------------Comandos Ejecucion VENTAS-------------------------------------//////////
	public static final int abrirVenta=301;
	public static final int addProductoVenta=302;
	public static final int createVenta=303;
	public static final int deleteVenta=304;
	public static final int deleteProductoVenta=305;
	public static final int pagoProductoVenta=306;
	public static final int procesarVenta=307;
	public static final int readAllVenta=308;
	public static final int readVenta=309;
	//////------------------------------Eventos VENTAS-------------------------------------//////////
	public static final int abrirVentaCommand=3001;
	public static final int addProductoVentaCommand=3002;
	public static final int createVentaCommand=3003;
	public static final int deleteVentaCommand=3004;
	public static final int deleteProductoVentaCommand=3005;
	public static final int pagoProductoVentaCommand=3006;
	public static final int procesarVentaCommand=3007;
	public static final int readAllVentaCommand=3008;
	public static final int readVentaCommand=3009;
//////------------------------------Eventos error VENTAS-------------------------------------//////////
	public static final int abrirVentaCommandError=30001;
	public static final int addProductoVentaCommandError=30002;
	public static final int createVentaCommandError=30003;
	public static final int deleteVentaCommandError=30004;
	public static final int deleteProductoVentaCommandError=30005;
	public static final int pagoProductoVentaCommandError=30006;
	public static final int procesarVentaCommandError=30007;
	public static final int readAllVentaCommandError=30008;
	public static final int readVentaCommandError=30009;
	
////////--------------------------Comandos ejecucion COMPETENCIA------------------------------////////
	public static final int crearCompetencia=401;
	public static final int borrarCompetencia=402;
	public static final int mostrarEmpleadosQuePoseenCompetencia=403;
	public static final int readCompetencia=404;
	public static final int readAllCompetencia=405;
	public static final int addCompetenciaEmpleado = 406;
	public static final int deleteCompetenciaEmpleado = 407;

///////----------------------Eventos COMPETENCIA------------------------------------------/////////////////////
	public static final int crearCompetenciaCommand=4001;
	public static final int borrarCompetenciaCommand=4002;
	public static final int mostrarEmpleadosQuePoseenCompetenciaCommand=4003;
	public static final int readCompetenciaCommand=4004;
	public static final int readAllCompetenciaCommand=4005;
	public static final int addCompetenciaEmpleadoCommand = 4006;
	public static final int deleteCompetenciaEmpleadoCommand = 4007;
/////////////////---------------Eventos error COOMPETENCIA-------------------------------///////////////////
	public static final int crearCompetenciaCommandError=40001;
	public static final int borrarCompetenciaCommandError=40002;
	public static final int mostrarEmpleadosQuePoseenCompetenciaCommandError=40003;
	public static final int readCompetenciaCommandError=40004;
	public static final int readAllCompetenciaCommandError=40005;
	public static final int deleteCompetenciaEmpleadoCommandError = 40007;
	public static final int addCompetenciaCommandError = 40008;


////////////////------------------------Comandos ejecucion DEPARTAMENTO---------------------/////////////////
	public static final int crearDepartamento=501;
	public static final int borrarDepartamento=502;
	public static final int	updateDepartamento=503;
	public static final int readDepartamento=504;
	public static final int readAllDepartamento=505;
	public static final int costeDepartamento=506;
/////////////----------------------------------Eventos DEPARTAMENTO------------------------////////////////
	public static final int crearDepartamentoCommand=5001;
	public static final int ReactivarDepartamentoCommand = 5007;
	public static final int borrarDepartamentoCommand=5002;
	public static final int	updateDepartamentoCommand=5003;
	public static final int readDepartamentoCommand=5004;
	public static final int readAllDepartamentoCommand=5005;
	public static final int costeDepartamentoCommand=5006;
/////////////--------------------------------Eventos error DEPARTAMENTO---------------------///////////////
	public static final int crearDepartamentoCommandError=50001;
	public static final int borrarDepartamentoCommandError=50002;
	public static final int	updateDepartamentoCommandError=50003;
	public static final int readDepartamentoCommandError=50004;
	public static final int readAllDepartamentoCommandError=50005;
	public static final int costeDepartamentoCommandError=50006;
	
	////////////----------------------Comandos ejecucion EMPLEADO--------------------------------///////////////
	public static final int addEmpleadoTiempoParcial=601;
	public static final int addEmpleadoTiempoCompleto=602;
	public static final int borrarEmpleado=603;
	public static final int updateEmpelado=604;
	public static final int readEmpleado=605;
	public static final int readAllEmpleado=606;
	public static final int  listaDepartamentos=607;
	/////////////////-------------------- Eventos EMPLEADO---------------------------------------////////////
	public static final int addEmpleadoTiempoParcialCommand=6001;
	public static final int addEmpleadoTiempoCompletoCommand=6002;
	public static final int borrarEmpleadoCommand=6003;
	public static final int updateEmpeladoCommand=6004;
	public static final int readEmpleadoCommand=6005;
	public static final int readAllEmpleadoCommand=6006;
	public static final int listaDepartamentosCommand=6007;
	//////////////////-------------------------Eventos error EMPLEADO----------------------------///////////
	public static final int addEmpleadoTiempoParcialCommandError=60001;
	public static final int addEmpleadoTiempoCompletoCommandError=60002;
	public static final int borrarEmpleadoCommandError=60003;
	public static final int updateEmpeladoCommandError=60004;
	public static final int readEmpleadoCommandError=60005;
	public static final int readAllEmpleadoCommandError=60006;
	public static final int listaDepartamentosCommandError=6008;
	

	
	
}
