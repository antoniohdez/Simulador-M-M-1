class Main{
	public static void main(String[] args) {
		//VentanaMM1 v = new VentanaMM1();

		Simulator s = new Simulator(588245, 150, 149, 10);
		s.run();
		System.out.println("L: " + s.L());
		System.out.println("Lq: " + s.Lq());
		System.out.println("W: " + s.W());
		System.out.println("Wq: " + s.Wq());
		System.out.println("O: " + s.O());
		
	}
}