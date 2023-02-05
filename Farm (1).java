package P2;
public class Farm {
	private double availableFood;
	private Animal[] animals;
	public Farm() {
		setAvailableFood(1000);
		animals = new Animal[100];
	}
	public boolean add(Animal anim) {
		for (int indexCheck = 0; indexCheck < animals.length;indexCheck++) {
			if (animals[indexCheck]==null) {
				animals[indexCheck] = anim;
				return true;
			}
		}
		return false;
		
	}
	public void makeNoise(){			// all animals make their sound (Moo, Cluck, etc)
		for(Animal animal: animals)
			if (animal != null) {
				animal.sound();
			}
			else {break;}
	}
	public void feedAnimals(){ 			// restore energy of all animals and deduct amount eaten from availableFood
		for(Animal animal : animals)
			if (animal != null) {
				if(availableFood >= Math.min(animal.getMealAmount(), (100-animal.getEnergy()))) 
				// no penalty if student uses:  if(availableFood >= animal.getMealAmount())
					availableFood -= animal.eat();
				else
					System.out.println("Not enough food for your animals! You need to collect more food items.");
			}
			else {break;}
	}
	public double getAvailableFood() {
		return availableFood;
	}
	public void setAvailableFood(double availableFood) {
		if(availableFood>=0 && availableFood<=1000)
			this.availableFood = availableFood;
	}
	public Animal[] getAnimals() {
		return animals;
	}	
}