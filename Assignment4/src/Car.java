
public class Car {

	private String carID;
	private long arrivalTime;
	
	Car(String ID, long currentTime) {
		carID = ID;
		arrivalTime = currentTime;
	}

	public long getArrivalTime() {
		return arrivalTime;
	}

	public long getWaitTime() {
		return System.currentTimeMillis() - arrivalTime;
	}

	public String getCarID() {
		return carID;
	}

	public void setCarID(String carID) {
		this.carID = carID;
	}
	
	public String toString() {
		String s = "";
		s += "Car: " + carID + " Waited: " + getWaitTime() + "\n";
		return s;
	}
	
}
