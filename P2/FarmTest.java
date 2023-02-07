package P2;

import java.util.Arrays;

public class FarmTest implements Cloneable{
	public static void main(String[] args) throws CloneNotSupportedException {
		Farm myFarm = new Farm();
		myFarm.add(new Chicken());
		myFarm.add(new Cow());
		myFarm.add(new Llama());
		myFarm.add(new Llama());
		for(Animal a: myFarm.getAnimals())
			a.setEnergy(Math.random()*100);
		System.out.println("\nInitial list of animals:\n-------------------------");
		myFarm.printAnimals();
		System.out.println("\nAdding a clone of the second animal\n-----------------------------------");
		myFarm.addClone(myFarm.getAnimals()[1]);
		myFarm.printAnimals();
		System.out.println("\nAfter SORTING:\n--------------");
		myFarm.animSort();
		myFarm.printAnimals();
		System.out.println("\nFarm summary:\n--------------");
		myFarm.printSummary();
	}
}