interface Animal {
    void eat();
}

interface Mammal {
    void walk();
}

class Dog implements Animal, Mammal {
    public void eat() {
        System.out.println("The dog eats");
    }

    public void walk() {
        System.out.println("The dog walks");
    }
}

public class HybridInheritance {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        dog.walk();
    }
}

