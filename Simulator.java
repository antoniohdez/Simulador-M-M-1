class Simulator{
	private Generator generator;
	private int sTime;
	private int time;

	private Queue<Client> queue;
	private Client serving;
	private ArrayList<Client> ;

	public Simulator(int seed, double lambda, double mu, int sTime){
		this.sTime = time;
		this.time = 0;
		this.generator = new Generator(seed, lambda, mu);
		this.clients = new ArrayList<Client>();
		this.clients.add( new Client(this.time) );
	}

	public void event(){

	}

	public void run(){

		this.generator.generatorLearmonthLewis();
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
}