import java.util.*;

public class Compare{
	class Dog{
		int age;
		public Dog(int age){
			this.age = age;
		}
	}
	public static void main(String[] args){
		Dog[] dogs = new Dog[10];
		for (int i = 0; i < 10; i++){
			dogs[i] = new Dog(10 - i);
		}
		Comparator<Dog> comparator = new Comparator<Dog>(){
			public int compare(Dog a, Dog b){
				if (a.age > b.age){
					return 1;
				}else if (a.age < b.age){
					return -1;
				}else{
					return 0;
				}
			}
		};
		Arrays.sort(dogs, x);
		System.out.println(Arrays.toString(dogs));
	}
}