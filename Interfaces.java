// Define an interface
interface Animal {
    void sound();  // Abstract method
    void sleep();  // Abstract method
}

// Class Dog implements the Animal interface
class Dog implements Animal {
    public void sound() {
        System.out.println("The dog barks");
    }
    
    public void sleep() {
        System.out.println("The dog sleeps");
    }
}

// Class Cat implements the Animal interface
class Cat implements Animal {
    public void sound() {
        System.out.println("The cat meows");
    }
    
    public void sleep() {
        System.out.println("The cat sleeps");
    }
}

// Main class
public class Interfaces {
    public static void main(String[] args) {
        // Create objects of Dog and Cat
        Animal myDog = new Dog();
        Animal myCat = new Cat();
        
        // Call methods
        myDog.sound();
        myDog.sleep();
        
        myCat.sound();
        myCat.sleep();
    }
}

