package com.guo.j8.Chapter2;

public class Chapter2_1 {

    /***
     * why and what is lambda expression?
     * anonymous class is to make code concise and simple, However it still seems a  bit excessive and cumbersome. Lambda expression is to help to express one single method more compactly.
     *
     *Anonymous class try to declare and instantiate a class at same time they are one-time local class. use Anonymous class when you don't need name of calls and only once.
     *
     *The high-level goal of Project Lambda is to enable programming patterns that require modeling code as data to be convenient and idiomatic in Java.
     */

    /***
     * Local class: Use it if you need to create more than one instance of a class, access its constructor, or introduce
     * a new, named type (because, for example, you need to invoke additional methods later).
     *
     *  Anonymous class: Use it if you need to declare fields or additional methods.
     *
     *  Lambda expression:
     *  Use it if you are encapsulating a single unit of behavior that you want to pass to other code. For example, you would use a lambda expression if you want a certain action performed on each element of a collection, when a process is completed, or when a process encounters an error.
     *
     *  Use it if you need a simple instance of a functional interface and none of the preceding criteria apply (for example, you do not need a constructor, a named type, fields, or additional methods).
     *
     *  Nested class: Use it if your requirements are similar to those of a local class, you want to make the type more widely available, and you don't require access to local variables or method parameters.
     *
     * Use a non-static nested class (or inner class) if you require access to an enclosing instance's non-public fields and methods. Use a static nested class if you don't require this access.
     */

    @FunctionalInterface
    public interface ClassDiff {
        public void printOut();
    }

    // local class
    public static void localClassExample() {
        //delare entire class including: class name , variables... in the method parameter place.
        class LocalClass implements ClassDiff {
            @Override
            public void printOut() {
                System.out.println("This is local class");
            }
        }
        LocalClass localClass1 = new LocalClass();
        localClass1.printOut();
    }

    // Anonymous class

    public static void AyClassExample() {
        new ClassDiff()
                //equals: ClassDiff ayclass1 = new ClassDiff()
        {
            @Override
            public void printOut() {
                // TODO Auto-generated method stub
                System.out.println("This is Ayclass");
            }

        }.printOut();

    }

    //lambda expression "anonymous methods"
    //One key difference between using Anonymous class and Lambda expression is the use of this keyword. For anonymous class ‘this’ keyword resolves to anonymous class, whereas for lambda expression ‘this’ keyword resolves to enclosing class where lambda is written.
    //public void lambdaExample(){()->{System.out.print("This is Ayclass");}}
    public static void LambdaExample(ClassDiff d) {
        d.printOut();
    }


    //------------------------------------------------------------------test---------------------------------------------------------------
    public static void main(String... args) {
        AyClassExample();
        localClassExample();
        LambdaExample(() -> System.out.println("lambda"));

    }

}

