package TimeSimulation;


public class Customer{
 
	private int arrivalTime;
	private int serviceRequired;
	private double probability;
	private boolean serviced;
	
	public Customer() {
		this.probability = 0;
		this.arrivalTime = 0;
		this.serviceRequired = 0;
		this.serviced = false;
	}
 
	public Customer(double prob, int arrivalTime, int serviceRequired){
		this.probability = prob;
		this.arrivalTime = arrivalTime;
		this.serviceRequired = serviceRequired;
		this.serviced = false;
	}
	
	public void substractServiceUnit() {
		
		this.serviceRequired = this.serviceRequired - 1;
		if(this.serviceRequired == 0)
			serviced();
		
	}
	
	public boolean isServiced() {
		return this.serviced;
	}
	
	public void serviced() {
		this.serviced = true;
	}
	
	public int getServiceRequired() {
		return this.serviceRequired;
	}
	

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}
 
}