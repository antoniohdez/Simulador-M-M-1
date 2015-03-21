class Simulator{
	private Generator generator;
	private int sTime;
	private int time;

	public Simulator(int seed, double lambda, double mu, int sTime){
		this.sTime = time;
		this.time = 0;
		this.generator = new Generator(seed, lambda, mu);
	}

	public void run(){
		this.generator.nextRand();
	}

	public void L(){

	}

	public void Lq(){

	}

	public void W(){

	}

	public void Wq(){

	}

	public void O(){

	}

	public static void main(String[] args) {
		Simulator s = new Simulator(35, 5, 10, 60);
		s.run()
	}
}