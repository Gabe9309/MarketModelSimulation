package TimeSimulation;

import java.util.Random;

public class SecondCxThread implements Runnable {
	
	private int totalTime;
	private int serviceTime;
	public static int counter;
	private double probability;
	Customer aCustomer;
	Cashier aCashier;

	public SecondCxThread(Cashier aCashier, int totalTime, int serviceTime, double arrProb) {
		this.totalTime = totalTime;
		this.probability = arrProb;
		this.serviceTime = serviceTime;
		//aCustomer = new Customer();
		this.aCashier = aCashier;
	}
@Override
	public void run() {
		int finishTime = (int)(totalTime + System.currentTimeMillis()/1000);
		Random aRandom = new Random();
			
		aCustomer = new Customer(this.probability,(int)(System.currentTimeMillis()/1000), this.serviceTime);
		aCashier.addCustomer(aCustomer);
		
			while((int)(System.currentTimeMillis()/1000) < finishTime) {
				try
				{
					if(aRandom.nextDouble() <= this.probability) {
						aCustomer = new Customer(this.probability,(int)(System.currentTimeMillis()/1000), this.serviceTime);
						aCashier.addCustomer(aCustomer);
					}
					Thread.sleep(1000);
				} catch (InterruptedException e) {
						
				} SecondCxThread.counter++;
			}
	}
}
