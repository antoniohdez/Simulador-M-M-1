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

	public void generatorLearmonthLewis(){
		double a = 16807,
			   c = 0,
			   m = Math.pow(2,31) - 1;
			   //x = 35;

		this.randNum.add(this.seed/m);
		this.seed = (a*this.seed + c) % m;
	}

	public void checkForRandom(int pos){
		if(pos >= this.size()){
			this.generatorLearmonthLewis();
			this.checkForRandom(pos);
		}
	}

	public double interarrivalTime(int pos){
		this.checkForRandom(pos);

		double time = this.randNum.get(pos);	
		this.interarrival.add( -Math.log(1 - time)/this.mu );

		return -Math.log(1 - time)/this.mu;
	}

	public double serviceTime(int pos){
		this.checkForRandom(pos);

		double time = this.randNum.get(pos);
		this.service.add( -Math.log(1 - time)/lambda );

		return -Math.log(1 - time)/lambda;
	}

	public void print(int pos){
		System.out.println( "Rand: " + this.randNum.get( pos ) );
		System.out.println( "Inter: " + this.interarrival.get( pos ) );
		System.out.println( "Service:" + this.service.get( pos ) );
		System.out.println();
	}

	public double size(){
		return this.randNum.size();
	}

	public double getRandom(int pos){
		return this.randNum.get(pos);
	}

	public double getInterarrivalTime(int pos){
		return this.interarrival.get(pos);
	}

	public double getServiceTime(int pos){
		return this.service.get(pos);
	}
}