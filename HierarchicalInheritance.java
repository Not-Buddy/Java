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

class Cat extends Animal {
    void meow() {
        System.out.println("The cat meows");
    }
}

public class HierarchicalInheritance{
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();  // inherited from Animal class
        dog.bark(); // method of Dog class

        Cat cat = new Cat();
        cat.eat();  // inherited from Animal class
        cat.meow(); // method of Cat class
    }
}

