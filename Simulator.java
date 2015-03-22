import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

class Simulator{
	private Generator generator;
	private double sTime;
	private double time;
	private double idle;
	private int n;

	private Queue<Client> queue;
	private Client serving;
	private ArrayList<Client> clients;

	private Client lastArrive;
	private double nextArrive;
	private double nextExit;

	public Simulator(int seed, double lambda, double mu, int sTime){
		this.sTime = sTime;
		this.time = 0;
		this.generator = new Generator(seed, lambda, mu);
		this.queue = new LinkedList<Client>();
		this.clients = new ArrayList<Client>();
		this.n = 0;
		this.nextArrive = 0;
		this.nextExit = 0;
	}

	public void run(){
		this.lastArrive = new Client(this.time, 0);
		this.queue.add( this.lastArrive );

		double interarrivalTime = this.generator.interarrivalTime(this.n);
		double serviceTime = this.generator.serviceTime(this.n);

		this.n++;

		this.nextArrive += interarrivalTime;
		this.nextExit += serviceTime;

		this.lastArrive.setServedAt(0);
		this.lastArrive.setServiceTime(serviceTime);

		while(time < sTime){

		}
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