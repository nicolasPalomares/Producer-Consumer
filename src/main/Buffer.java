package main;

public class Buffer {
	
	private char buffer[];
	private int next;
	private boolean empty;
	private boolean full;
	
	public Buffer(int size) {
		buffer = new char[size];
		next = 0;
		empty = true;
		full = false;
	}
	
	public synchronized char consume() {
		// If the buffer is empty, the consumer waits
		while(empty == true) {
			try {
				wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		next--; // The consumer took a character from the buffer
		
		// If there's no next character, it means that the buffer is empty (the consumer waits)
		if(next == 0) {
			empty = true;
		}
		
		full = false; // So, the buffer is not full
		notifyAll();
		
		return(buffer[next]);
	}
	
	public synchronized void produce(char c) {
		// If the buffer is full, the producer waits for space
		while(full == true) {
			try {
				wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		buffer[next] = c;
		
		next++; // The producer added a character to the buffer
		empty = false; // So, the buffer is not empty
		
		// If next is equal to the size of the buffer, it means that the buffer is full
		if(next == this.buffer.length) {
			full = true;
		}
		
		empty = false;
		notifyAll();
	}

}
