package TimeSimulation;


public class MarketModel {
	
	private static int clock;
	private int serviceTime;
	private double arrProb;
	private Cashier aCashier;
	private Customer aCustomer;
	private SecondCxThread secondThread;
	private int counterTest;
	
	public MarketModel(int clock, int serviceTime, double arrProb) {
		MarketModel.clock = clock;
		this.serviceTime = serviceTime;
		this.arrProb = arrProb;
		counterTest = 0;
		aCashier = new Cashier();
		aCustomer = new Customer(arrProb, 0, serviceTime);
	}
	
	public void enqueue(Customer aCustomer) {
		aCashier.addCustomer(aCustomer);
	}
	
	public static int getRunningTime() {
		return clock;
	}
	
	public void simulation() {
		//do we still need this?
		//int serviceProvided = 0;
		
		int currentTime = (int)System.currentTimeMillis()/1000;
		int finishTime = currentTime + MarketModel.clock;
		
		secondThread = new SecondCxThread(aCashier, MarketModel.clock, this.serviceTime, this.arrProb);
		Thread thread = new Thread(secondThread);
		thread.start();
		aCashier.addCustomer(aCustomer);
		aCashier.addCustomer(aCustomer);
		aCashier.addCustomer(aCustomer);
		
		while(((int)System.currentTimeMillis()/1000) < finishTime){
			//serviceProvided = 0;
				
				if (aCashier.serviceCustomer()) {
					aCashier.removeCustomer();
					this.counterTest++;
				}
					
			
		}
	}//end simulation
	
	
	public int getCount() {
		return this.counterTest;
	}
	
	public int queueLength() {
		
		return aCashier.queueLength();
		
	}
}//end MarketModel
