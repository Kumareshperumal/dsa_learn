package laur.spilca.staticbasics;

public class MainExample {
    public static void main(String[] args) {
        Foo f1 = new Foo();
        Foo f2 = new Foo();
        f1.x = 10;
        f2.x = 11;
        System.out.println(f1.x);
        System.out.println(f2.x);

        Foo.y = 15;
        f1.y = 20;
        f2.y = 30;
        /*
        output is 30, It always refers to only one variable y they have in memory.
         */
        System.out.println(Foo.y);
        System.out.println(f1.y);
        System.out.println(f2.y);
        /*
        No matter how many instance you create, there is always one Y in memory. Remember it is static variable & belongs to class.
         */

    }
}
