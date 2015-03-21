import java.util.ArrayList;

class Generator{
	private double seed;
	private double lambda;
	private double mu;
	private ArrayList<Double> randNum;
	private ArrayList<Double> interarrival;
	private ArrayList<Double> service;

	public Generator(double seed, double lambda, double mu){
		this.seed = seed;
		this.lambda = lambda;
		this.mu = mu;
		this.randNum = new ArrayList<Double>();
		this.interarrival = new ArrayList<Double>();
		this.service = new ArrayList<Double>();
	}

	public void nextRandom(){
		this.generatorLearmonthLewis();
		this.interarrivalTime();
		this.serviceTime();
		this.print();
	}

	public void generatorLearmonthLewis(){
		double a = 16807,
			   c = 0 ,
			   m = Math.pow(2,31) - 1;
			   //x = 35;

		this.randNum.add(this.seed/m);
		this.seed = (a*this.seed + c) % m;
	}

	public void interarrivalTime(){
		double lastNum = this.randNum.get(randNum.size()-1);	
		this.interarrival.add( -Math.log(1 - lastNum)/this.mu );
	}

	public void serviceTime(){
		double lastNum = this.randNum.get(randNum.size()-1);
		this.service.add( -Math.log(1 - lastNum)/lambda );
	}

	public void print(){
		System.out.println( "Rand: " + this.randNum.get(randNum.size()-1) );
		System.out.println( "Inter: " + this.interarrival.get(interarrival.size()-1) );
		System.out.println( "Service:" + this.service.get(service.size()-1) );
		System.out.println();

	}
}