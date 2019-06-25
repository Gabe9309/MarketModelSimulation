package TimeSimulation;

public class App {

	public static void main(String[] args) {
		MarketModel market = new MarketModel(40, 5, 0.70);
		
		market.simulation();
		
		System.out.println(market.getCount());
		System.out.println(SecondCxThread.counter);
		System.out.println(market.queueLength());
		/*System.out.println((int)(System.currentTimeMillis()/1000));
		System.out.println(System.currentTimeMillis()/1000 + 20);*/
	}

}
