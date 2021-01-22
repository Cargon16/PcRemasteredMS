package Integracion.TransactionManager;

import java.util.concurrent.ConcurrentHashMap;

public class TransactionManagerImp extends TransactionManager {

	private ConcurrentHashMap<Thread, Transaction> transacciones = new ConcurrentHashMap<Thread, Transaction> ();
	

	@Override
	public Transaction getTransaction() {
		// TODO Auto-generated method stub
		return this.transacciones.get(Thread.currentThread());

	}

	@Override
	public Transaction newTransaction() {
		
		Thread hilo = Thread.currentThread();
		Transaction transacti = this.transacciones.get(hilo);
		
		if(transacti == null){
		TransactionFactory factory = TransactionFactory.getInstance();
		transacti = factory.createTransaction();
		this.transacciones.put(hilo, transacti);
		}
		return transacti;
	}

	@Override
	public void deleteTransaction() {
		transacciones.remove(Thread.currentThread());

	}
}