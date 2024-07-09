# Producer-Consumer

The classic synchronization problem using threads, showcasing how producers and consumers interact in a shared buffer. I made the program without references when I first started learning multithreading in Java.
The producer sends a character from the alphabet, and the consumer takes it. If the buffer is empty, the consumer
waits for it to recieve a character, and if the buffer is full, the producer waits for it to get a free space before sending a character.

It was made with JDK 18.
