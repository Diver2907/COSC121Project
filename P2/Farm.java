package P2;
import java.util.Arrays;

public class Farm implements Cloneable{
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
		int animalCount = 0;
		
		for(Animal animalia : animals){
			if (animalia != null){
				animalCount+=1;
			}
		}
		Animal animalArray[] = new Animal[animalCount];
		int arrayIdx = 0;
		for(Animal animalia:animals){
			if (animalia != null){
				animalArray[arrayIdx]=animalia;
				arrayIdx+=1;
			}
		}
		return animalArray;
	}	

	public void animSort(){
		Animal[] sortArray = getAnimals();
		for(int i=0;i<sortArray.length-1;i++){
			sortArray[i].compareTo(sortArray[i+1]);
			Arrays.sort(sortArray);
		}
		animals = sortArray;
	}

	public boolean addClone(Animal anim) throws CloneNotSupportedException{
		Animal[] newAnimals = new Animal[animals.length+1];
		int index = 0;
		for(Animal animal:animals){
			newAnimals[index] = animal;
			index+=1;
		}
		for(int i=0; i<newAnimals.length;i++){
			if(newAnimals[i] == null){
				newAnimals[i] = (Animal) anim.clone();
				animals = newAnimals;
				return true;
			}
		}
		return false;
	}

	public void printAnimals(){
		for(Animal animal:animals){
			System.out.printf("%-8s: %-5s at (%-2.1f,%-2.1f) Energy=%-7.1f\n", animal.getName(), animal.isAlive()?"alive":"dead",animal.getX(),animal.getY(),animal.getEnergy());
		} 
	}

	public int getNumChicken(){
		int chickenCount = 0;
		for(Animal animal:animals){
			if(animal instanceof Chicken){
				chickenCount+=1;
			}
		}
		return chickenCount;
	}
	public int getNumCow(){
		int cowCount = 0;
		for(Animal animal:animals){
			if(animal instanceof Cow){
				cowCount+=1;
			}
		}
		return cowCount;
	}
	public int getNumLlama(){
		int llamaCount = 0;
		for(Animal animal:animals){
			if(animal instanceof Llama){
				llamaCount+=1;
			}
		}
		return llamaCount;
	}
	public void printSummary(){
		int totalAnimals = getNumChicken()+getNumCow()+getNumLlama();
		System.out.printf("The farm has:\n- %d animals (%d chickens,%d cows,%d llamas)\n- %f units of available food",totalAnimals,getNumChicken(),getNumCow(),getNumLlama(),getAvailableFood());
	}
}
