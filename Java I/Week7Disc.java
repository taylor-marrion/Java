import java.util.concurrent.*;


public class Week7Disc {

	public static void main(String[] args) {
		
		int x = Integer.parseInt(args[0]);
	
		int y = Integer.parseInt(args[1]);
		
		System.out.print("The random integer between " + x + " and " + y + " is:  ");
		
		System.out.print(ThreadLocalRandom.current().nextInt(x, y));
		
		
	}

}