import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

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

	}

	public void run(){
		double interarrivalTime = this.generator.interarrivalTime(this.n);
		double serviceTime = this.generator.serviceTime(this.n);

		//this.lastArrive = new Client(this.time, interarrivalTime);
		//this.queue.add( this.lastArrive );

		//this.serving = this.queue.poll();

		//System.out.println("Llegada: Cliente " + this.n + " " + this.time);


		this.nextArrive += interarrivalTime;
		this.nextExit += serviceTime + interarrivalTime;

		//this.serving.setServedAt(interarrivalTime);
		//this.serving.setServiceTime(serviceTime);

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
					
					//Se acaba la simulación a la mitad del servicio
					if(this.serving.getServiceTime() + (this.nextArrive - this.nextExit) >= sTime){
						
					}
					//
					
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
		while(this.queue.size()!=0){
			this.queue.peek().setServiceTime(0);			
			this.queue.peek().setServedAt(sTime);
			this.clients.add(this.queue.poll());
		}
	}

	public double L(){
		double result = 0;
		for(Client c : this.clients){
			result += c.getTimeInSystem();
		}
		return result/this.sTime;
	}

	public double Lq(){
		double result = 0;
		for(Client c : this.clients){
			result += c.getWaitingTime();
		}
		return result/this.sTime;	
	}

	public double W(){
		double result = 0;
		for(Client c : this.clients){
			result += c.getTimeInSystem();
		}
		return result/this.clients.size();
	}

	public double Wq(){
		double result = 0;
		for(Client c : this.clients){
			result += c.getWaitingTime();
		}
		return result/this.clients.size();	
	}

	public double O(){
		return this.idle/this.sTime;
	}
	
	public double Ocio(){
		return this.idle;
	}

	public ArrayList<Client> getClients(){
		return this.clients;
	}

	public Queue<Client> getQuere(){
		return this.queue;
	}
	
	

}