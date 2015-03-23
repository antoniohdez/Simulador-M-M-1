class Client{
	private double arrivedAt;
	private double servedAt;
	private double serviceTime;

	private int id;

	public Client(double arrivedAt, double servedAt, double serviceTime){
		this.arrivedAt = arrivedAt;
		this.servedAt = servedAt;
		this.serviceTime = serviceTime;
	}

	public Client(double arrivedAt, int id){
		this.arrivedAt = arrivedAt;
		this.id = id;
	}

	public void setServedAt(double servedAt){
		this.servedAt = servedAt;
	}

	public void setServiceTime(double serviceTime){
		this.serviceTime = serviceTime;
	}

	public double getArrivedAt(){
		return this.arrivedAt;
	}

	public double getServedAt(){
		return this.servedAt;
	}

	public double getServiceTime(){
		return this.serviceTime;
	}

	public double getWaitingTime(){
		return this.servedAt - this.arrivedAt;
	}

	public double getExitTime(){
		return this.arrivedAt + getTimeInSystem();
	}

	public double getTimeInSystem(){
		return this.getWaitingTime() + this.serviceTime;
	}

	public int getID(){
		return this.id;
	}

}