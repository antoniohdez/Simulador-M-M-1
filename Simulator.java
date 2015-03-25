import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.lang.Math.*;

class Simulator{
	private Generator generator;
	private double sTime;
	private double time;
	private double idle;
	private boolean active;
	private int n;

	private Queue<Client> queue;
	private Client serving;
	private ArrayList<Client> clients;

	private Client lastArrive;
	private double nextArrive;
	private double nextExit;

	private double lambda;
	private double mu;

	public Simulator(int seed, double lambda, double mu, int sTime){
		this.sTime = sTime;
		this.time = 0;
		this.generator = new Generator(seed, lambda, mu);
		this.queue = new LinkedList<Client>();
		this.clients = new ArrayList<Client>();
		this.n = 0;
		this.nextArrive = 0;
		this.nextExit = 0;
		this.active = true;
		this.idle = 0;
		this.lambda = lambda;
		this.mu = mu;

	}

	public void run(){

		this.lastArrive = new Client(this.time, 0);
		this.queue.add( this.lastArrive );

		this.serving = this.queue.poll();

		System.out.println("Llegada: Cliente " + this.n + " " + this.time);

		double interarrivalTime = this.generator.interarrivalTime(this.n);
		double serviceTime = this.generator.serviceTime(this.n);

		this.nextArrive += interarrivalTime;
		this.nextExit += serviceTime;

		this.serving.setServedAt(0);
		this.serving.setServiceTime(serviceTime);
		this.n++;

		while(time < sTime){
			if( this.nextArrive <= this.nextExit || !this.active){
				this.time = this.nextArrive;
				if(this.time > this.sTime){
					break;
				}
				this.active = true;
				System.out.println("Llegada: Cliente " + this.n + " " + this.time);

				this.lastArrive = new Client(this.time, this.n);
				this.queue.add(this.lastArrive);

				if(this.serving == null){
					this.serving = this.queue.poll();
					this.serving.setServedAt(this.time);

					serviceTime = this.generator.serviceTime( this.serving.getID() );
					
					System.out.println("Tiempo de servicio: " + this.serving.getID() + " " + serviceTime);

					
					this.serving.setServiceTime(serviceTime);
					
					this.nextExit += serviceTime + (this.nextArrive - this.nextExit);
				}
				this.nextArrive += this.generator.interarrivalTime( this.n+1 );	
				this.n++;

			}else if(this.nextExit < this.nextArrive && this.active ){
				this.time = this.nextExit;
				if(this.time > this.sTime){
					break;
				}
				System.out.println("Salida: Cliente " + this.serving.getID() + " " + this.time);

				this.clients.add( this.serving );
				if(this.queue.size() == 0){

					System.out.println();
					this.serving = null;
					
					//this.nextExit = -1;
					this.active = false;
					this.idle += this.nextArrive - this.time;
					
					System.out.println("Tiempo de ocio " + (this.nextArrive - this.time) );
					
				}else{
					this.serving = this.queue.poll();
					this.serving.setServedAt(this.time);

					serviceTime = this.generator.serviceTime( this.serving.getID() );

					System.out.println("Tiempo de servicio: " + this.serving.getID() + " " + serviceTime);

					this.serving.setServiceTime(serviceTime);

					this.nextExit += serviceTime;
				}
			}else if(this.nextArrive == this.nextExit){
				this.time = this.nextArrive;
				if(this.time > this.sTime){
					break;
				}

				System.out.println("Llegada: Cliente " + this.n + " " + this.time);

				//Llegada de cliente
				this.lastArrive = new Client(this.time, this.n);
				this.queue.add(this.lastArrive);

				//Calcula siguiente llegada
				this.nextArrive += this.generator.interarrivalTime( this.n+1 );

				//Salida de cliente
				this.clients.add( this.serving );

				//Atencion a cliente nuevo
				this.serving = this.queue.poll();

				this.serving.setServedAt(this.time);

				//Calcula siguiente salida y 
				serviceTime = this.generator.serviceTime( this.serving.getID() );

				System.out.println("Tiempo de servicio: " + this.serving.getID() + " " + serviceTime);

				this.serving.setServiceTime(serviceTime);

				this.nextExit += serviceTime;
				
				this.n++;
			}
		}
		//Se acaba la simulación a la mitad del servicio
		if(this.serving != null){
			this.serving.setServiceTime( this.sTime - this.serving.getServedAt() );
			this.clients.add(this.serving);
		}

		while(this.queue.size()!=0){
			this.queue.peek().setServiceTime(sTime);			
			this.queue.peek().setServedAt(sTime);
			this.clients.add(this.queue.poll());
		}
	}

	public double L(){
		/*
		double result = 0;
		for(Client c : this.clients){
			result += c.getTimeInSystem();
		}
		System.out.println("L Formula: " + (lambda/(mu-lambda)) );
		System.out.println("L Simulcion: " + (result/this.sTime) );
		return result/this.clients.size();
		*/
		//System.out.println("L:" +  (this.P()/(1-this.P())) );
		return this.P()/(1-this.P());
	}

	public double Lq(){
		/*
		double result = 0;
		for(Client c : this.clients){
			result += c.getWaitingTime();
		}
		return result/this.sTime;	
		*/
		return Math.pow(this.P(), 2)/(1-this.P());
	}

	public double W(){
		/*
		double result = 0;
		for(Client c : this.clients){
			result += c.getTimeInSystem();
		}
		return result/this.clients.size();
		*/
		return this.L()/this.lambda;
	}

	public double Wq(){
		/*
		double result = 0;
		for(Client c : this.clients){
			result += c.getWaitingTime();
		}
		return result/this.clients.size();	
		*/
		return this.Lq()/this.lambda;
	}

	public double O(){
		return this.idle/this.sTime;
	}
	
	public double Ocio(){
		return this.idle;
	}

	public double P(){
		return 1 - this.O();
	}

	public ArrayList<Client> getClients(){
		return this.clients;
	}

	public Queue<Client> getQuere(){
		return this.queue;
	}
}