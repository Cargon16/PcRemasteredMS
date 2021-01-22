/**
 * 
 */
package Integracion.TransactionManager;


public abstract class TransactionManager {

	private static TransactionManager instance;


	public synchronized static TransactionManager getInstance() {
		if(instance==null){
			instance= new TransactionManagerImp();
			
		}
		return instance;
	}

	public abstract Transaction getTransaction();


	public abstract Transaction newTransaction();
	
	public abstract void deleteTransaction();
}