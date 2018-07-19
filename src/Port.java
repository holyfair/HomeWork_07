import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Port implements Runnable{

	private Queue<Ship> port = new ArrayDeque<Ship>();
	
	public void addShip(Ship ship) {
		if(ship == null) {
			throw new IllegalArgumentException();
		}
		port.offer(ship);
	}
	
	
	@Override
	public void run() {
		isDocReady right = new isDocReady();
		isDocReady left = new isDocReady();
		Thread rightDocThread = null;
		Thread leftDocThread = null;
		if(port.isEmpty()) {
			return;
		}
		while(!port.isEmpty()) {
		if(right.isReady()) {
			Dok rightDok = new Dok(port.remove(), right);
			rightDocThread = new Thread(rightDok);
			rightDocThread.start();
			right.setReady(false);
		}
		if(left.isReady() && !port.isEmpty()) {
			Dok leftDok = new Dok(port.remove(), left);
			leftDocThread = new Thread(leftDok);
			leftDocThread.start();
			left.setReady(false);
		}
		try {
			rightDocThread.join();
			leftDocThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		right.setReady(true);
		left.setReady(true);
		}
	}

	
}
