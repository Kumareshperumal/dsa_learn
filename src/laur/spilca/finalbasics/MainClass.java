package laur.spilca.finalbasics;

import laur.spilca.finalbasics.Cat;

public class MainClass {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.name = "bob";
        Cat cat2 = new Cat();
        cat2.name = "Hon";
        System.out.println(cat1.name);
        System.out.println(cat2.name);
        cat1.name = "rob";
        System.out.println(cat1.name);
        //final keyword for name and defined.
        Dog dog1 = new Dog();
        System.out.println(dog1.name);
        //final keyword for name variable but using constructor.
        //The advantage is you can have different value for each instance compare to Dog class.
        Horse horse1 = new Horse("rocky");
        Horse horse2 = new Horse("Lir");
        System.out.println(horse1.name);
        System.out.println(horse2.name);
    }
}
