package laur.spilca.staticbasics;

public class Foo {
    /*
    Here the x is actually not belongs to the class but to the instance of the class.
     */
    int x;
    //Static is always used inside the class.
    /*
    Static variable on the other hand, doesn't need an instance to declare it, we could do it with the class name.
    Even if you have more than one instance or zero instance,  you still have one "Y" variable.
    you can still see the variable y it is not related to instances anymore.
    still you can call it using the instance of the class Foo.
     */
    static int y;
    /*
    !!Remember, you can't use the static variable locally.
     */

    /*
    You can change the order of modifiers, but not the order of types with modifiers.
    Example: static final int z (or) final static int z is fine.
    but int static z is not fine. It should be static int z.
     */
    final static int z = 25;
}
