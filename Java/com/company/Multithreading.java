package Threads;

import java.util.*;

class square extends Thread {
	int x;

	square(int n) {
		x = n;
	}

	public void run() {
		int sqr = x * x;
		System.out.println("Square of " + x + " = " + sqr);
	}
}

class cube extends Thread {
	int x;

	cube(int n) {
		x = n;
	}

	public void run() {
		int cub = x * x * x;
		System.out.println("Cube of " + x + " = " + cub);
	}
}

class number extends Thread {

	public void run() {
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			int randomInteger = random.nextInt(10);
			System.out.println("Random Integer generated : " + randomInteger);
			square s = new square(randomInteger);
			s.start();
			cube c = new cube(randomInteger);
			c.start();
			try {
				Thread.sleep(1000);

			} catch (InterruptedException ex) {
				System.out.println(ex);
			}
		}
	}

}

public class Multithreading {

	public static void main(String[] args) {
		number n = new number();
		n.start();
	}

}
