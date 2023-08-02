package main;

public class Test {
	
	public static void main(String[] args) {
		Buffer buffer = new Buffer(10);  // A size of ten for the buffer
		Producer producer = new Producer(buffer);
		Consumer consumer = new Consumer(buffer);
		
		producer.start();
		consumer.start();
	}

}
