
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Lane north = new Lane("North");
		Lane south = new Lane("South");
		Lane east = new Lane("East");
		Lane west = new Lane("West");
		
		Lane[] lanes = {north, south, east, west};
		
		Thread t1 = new Thread(north);
		Thread t2 = new Thread(south);
		Thread t3 = new Thread(east);
		Thread t4 = new Thread(west);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int i = 0; i < 3; ++i) {

			Lane longestWait = getLongestWaitLane(lanes);
			if (longestWait != null && longestWait.getFront() != null) {
				Car temp = longestWait.remove();
				System.out.println("Let " + temp.getCarID() + " through after " + temp.getWaitTime() + "\n");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		north.setGenerate(false);
		south.setGenerate(false);
		east.setGenerate(false);
		west.setGenerate(false);
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		System.out.println("STOPPED");
		
		while (getLongestWaitLane(lanes) != null) {
			Lane longestWait = getLongestWaitLane(lanes);
			if (longestWait != null && longestWait.getFront() != null) {
				Car temp = longestWait.remove();
				System.out.println("Let " + temp.getCarID() + " through after " + temp.getWaitTime() + "\n");
			}
		}
	}
	
	public static Lane getLongestWaitLane(Lane[] lanes) {
		Lane temp = null;
		
		for (int i = 0; i < lanes.length; ++i) {
			if (lanes[i].getFront() != null) {
				if (temp == null)
					temp = lanes[i];
				else if (temp.getFront() == null) 
					temp = lanes[i];
				else if (temp.getFront().getWaitTime() < lanes[i].getFront().getWaitTime())
					temp = lanes[i];
			}
		}
		
		return temp;
	}
}
