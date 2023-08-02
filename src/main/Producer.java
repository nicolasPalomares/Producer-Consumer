package main;

public class Producer extends Thread {
	
	private Buffer buffer;
	private final String letters = "abcdefghijklmnopqrstuvwxyz";
	
	public Producer(Buffer buffer) {
		this.buffer = buffer;
	}
	
	// Sending the product (character) to the buffer
	public void run() {
		while(true) {
			// Random char from String letters
			char c = letters.charAt((int)(Math.random() * letters.length()));
			
			buffer.produce(c);
			System.out.println("Depositing character '" + c + "' to buffer");
			
			try {
				sleep((int)(Math.random() * 4000)); // Random time from 0 to 3999 milliseconds
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
