
public class Main {

	public static void main(String[] args) {
		Port port = new Port();
		
		String[] area = new String[10];
		for(int i = 0; i < area.length; i++) {
			area[i] = "" + i;
		}
		
		Ship one = new Ship("one", area);
		Ship two = new Ship("two", area);
		Ship three = new Ship("three", area);
		
		port.addShip(one);
		port.addShip(two);
		port.addShip(three);
		
		Thread thr = new Thread(port);
		thr.start();
	}

}
