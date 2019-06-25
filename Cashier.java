package TimeSimulation;

public class Cashier {
	
	private LinkedQueue<Customer> customers;
	
	public Cashier() {
		customers = new LinkedQueue<Customer>();
	}
	
	public void addCustomer(Customer customer) {
		customers.enqueue(customer);
	} //end addCustomer
	
	public void removeCustomer() {
		customers.dequeue();
	} //end removeCustomer
	
	public boolean serviceCustomer() {
		
		Customer aCustomer = customers.peek();
		for(int i = 0; i <= aCustomer.getServiceRequired(); i++) {
			try {
				Thread.sleep(500);
			}
				catch(InterruptedException e){
				
			}
		}
		return true;
		
	}//end isCustomerServiced
	public int queueLength() {
		
		return customers.size();
		
	}//end queueLength

}