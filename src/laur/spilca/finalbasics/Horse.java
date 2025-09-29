package laur.spilca.finalbasics;

public class Horse {
    /*
     At the moment of creating the instances you can create a value for the constant "name".
     But you can't change it after creating it, as It is final means Constant.
     */
    final String name;

    public Horse(String name) {
        this.name = name;
    }
}
