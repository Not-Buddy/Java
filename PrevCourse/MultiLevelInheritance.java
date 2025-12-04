class Animal {
    void eat() {
        System.out.println("This animal eats food");
    }
}

class Mammal extends Animal {
    void walk() {
        System.out.println("This mammal walks");
    }
}

class Dog extends Mammal {
    void bark() {
        System.out.println("The dog barks");
    }
}

public class MultiLevelInheritance{
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();  // inherited from Animal class
        dog.walk(); // inherited from Mammal class
        dog.bark(); // method of Dog class
    }
}

