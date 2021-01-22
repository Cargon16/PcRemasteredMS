/**
 * @author Sergio Villarroel Fernández 	svillarr@ucm.es
 *
 *
 */
package Integracion.TransactionManager;


public abstract class TransactionFactory {
	
	private static TransactionFactory instance;

	public synchronized static TransactionFactory getInstance() {
		if(instance==null){
			instance = new TransactionFactoryImp();
		}
		return instance;
	}
	
	public abstract Transaction createTransaction();
}