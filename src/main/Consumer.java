package main;

public class Consumer extends Thread {
	
	private Buffer buffer;
	
	public Consumer(Buffer buffer) {
		this.buffer = buffer;
	}
	
	// Consuming a character from buffer
	public void run() {
		while(true) {
			char value = buffer.consume();
			System.out.println("Character '" + value + "' consumed from buffer");
			
			try {
				sleep((int)(Math.random() * 4000)); // Random time from 0 to 3999 milliseconds
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
