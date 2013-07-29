
public class Lane implements Runnable{

	private LinkedQueue<Car> carQueue;
	private String name;
	private int totalCars;
	private int currentCars;
	private boolean generate;
	
	public Lane(String name) {
		carQueue = new LinkedQueue<Car>();
		this.name = name;
		totalCars = 0;
		currentCars = 0;
		generate = true;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep((long)(Math.random() * 2000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (generate) {
			generate();
			System.out.println(this);
			try {
				Thread.sleep((long)(2000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void add(Car c) {
		++currentCars;
		carQueue.add(c);
	}
	
	public synchronized void generate() {
		//generates cars randomly and wait between each
		for (int i = 0; i < 3; ++i) {
			if ((int)(Math.random() * 3 + 1) > 2) {
				carQueue.add(new Car(name + totalCars, System.currentTimeMillis()));
				++totalCars;
				++currentCars;
				try {
					Thread.sleep((long)(Math.random() * 2000 + 1000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public synchronized Car remove() {
		try {
			--currentCars;
			Car temp = carQueue.examine();
			carQueue.remove();
			return temp;
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public synchronized Car getFront() {
		try {
			return carQueue.examine();
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		String s = "";
		s = name + " has " + currentCars + " cars.\n" + carQueue.toString();
		return s;
	}
	
	public boolean isEmpty() {
		return carQueue.isEmpty();
	}
	
	public int getCurrentCars() {
		return currentCars;
	}
	
	public boolean isGenerate() {
		return generate;
	}
	public void setGenerate(boolean generate) {
		this.generate = generate;
	}
	
}
