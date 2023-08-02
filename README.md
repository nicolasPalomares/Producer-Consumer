# Producer-Consumer
The classic multithreading problem in Java

The very well known Producer-Consumer problem. I made the program without references when I first started learning multithreading in Java.
The producer sends a character from the alphabet String, and the consumer takes the character. If the buffer is empty, the consumer
waits for it to recieve a character, and if the buffer is full, the producer waits for it to get a free space before sending a character.

It was made with JDK 18.
