package P2;

import java.util.Arrays;

public class FarmTest {
	public static void main(String[] args) {
		Farm myFarm = new Farm();
		myFarm.add(new Chicken());
		myFarm.add(new Cow());
		myFarm.add(new Llama());
		myFarm.add(new Llama());
		for(Animal a:myFarm.getAnimals()) {
			if (a == null) {break;}
			else {
				for(int i=0; i<(int)(Math.random()*1000); i++) {
					a.move();
				}
			}
		}
		myFarm.animSort();
		System.out.println(Arrays.toString(myFarm.getAnimals()));
		System.out.println("Before feeding: " + myFarm.getAvailableFood());
		myFarm.feedAnimals();
		System.out.println("After feeding: " + myFarm.getAvailableFood());
		myFarm.makeNoise();
		myFarm.getAnimals()[0].speak("Hello!!");
		System.out.println(Arrays.toString(myFarm.getAnimals()));
	}
}
