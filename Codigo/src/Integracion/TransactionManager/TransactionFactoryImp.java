/**
 * @author Sergio Villarroel Fern�ndez 	svillarr@ucm.es
 *
 *
 */
package Integracion.TransactionManager;


public class TransactionFactoryImp extends TransactionFactory {

	@Override
	public Transaction createTransaction() {
		return new TransactionMySQL();
		
	}
	
	

}