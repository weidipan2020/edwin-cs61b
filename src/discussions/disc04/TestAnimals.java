package discussions.disc04;

public class TestAnimals {
    public static void main(String[] args) {
        Animal a = new Animal("Pluto", 10);
        Cat c = new Cat("Garfield", 6);
        Dog d = new Dog("Fido", 4);
        a.greet(); 			// (A) Animal Pluto says: Huh?
        c.greet(); 			// (B) Cat Garfield says: Meow!
        d.greet(); 			// (C) Dog Fido says: WOOF!
        a = c;
        ((Cat) a).greet(); 	// (D) Cat Garfield says: Meow!
        a.greet(); 			// (E) Cat Garfield says: Meow!
    }
}
