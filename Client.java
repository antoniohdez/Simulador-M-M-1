class Client{
	private double arrivedAt;
	private double servedAt;
	private double serviceTime;

	public Client(double arrivedAt, double servedAt, double serviceTime){
		this.arrivedAt = arrivedAt;
		this.servedAt = servedAt;
		this.serviceTime = serviceTime;
	}

	public Client(double arrivedAt){
		this.arrivedAt = arrivedAt;
	}

	public void setServedAt(double servedAt){
		this.servedAt = servedAt;
	}

	public void setServiceTime(){
		this.serviceTime = serviceTime;
	}

	public double getArrivedAt(){
		return this.arrivedAt;
	}

	public double getservedAt(){
		return this.servedAt;
	}

	public double getservicetime(){
		return this.serviceTime;
	}

}