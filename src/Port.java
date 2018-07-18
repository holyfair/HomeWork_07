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
		if(port.isEmpty()) {
			return;
		}
		while(!port.isEmpty()) {
		if(right.isReady()) {
			Dok rightDok = new Dok(port.remove(), right);
			Thread thr = new Thread(rightDok);
			thr.start();
		}
		if(left.isReady() && !port.isEmpty()) {
			Dok leftDok = new Dok(port.remove(), left);
			Thread thr = new Thread(leftDok);
			thr.start();
		}
		System.out.println(right.isReady());
		}
	}

	
}
