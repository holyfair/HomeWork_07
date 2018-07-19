
public class Dok implements Runnable{

	private Ship ship;
	private isDocReady ready;
	
	public Dok(Ship ship, isDocReady ready) {
		super();
		this.ship = ship;
		this.ready = ready;
	}

	private synchronized void work() {
		for(String str : ship.getBoxes()) {
			System.out.println(ship.getName() + ": " + str);
			try {
				this.wait(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void run() {
		work();
		ready.setReady(true);
	}
	
	
}
