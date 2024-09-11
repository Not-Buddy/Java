class Animal {
    void eat() {
        System.out.println("This animal eats food");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("The dog barks");
    }
}

public class SingleInheritance{
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();  // inherited method from Animal class
        dog.bark(); // method of Dog class
    }
}

