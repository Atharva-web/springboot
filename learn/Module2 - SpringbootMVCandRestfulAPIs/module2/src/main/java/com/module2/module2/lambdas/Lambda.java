package com.module2.module2.lambdas;

public class Lambda {
    public static void main(String[] args) {
//        Walkable obj = new WalkFast();
//        obj.walk(4);

//        we don't want to create a new class just to implement 1 method.
//        one might argue about reusability, but if it's not used many times, or if different impl are required every other time,
//        we can just define implementation wherever we want to use it.

//        anonymous class
//        Walkable obj = new Walkable() {
//            @Override
//            public int walk(int steps) {
//                System.out.println("walking fast. " + 2*steps + " steps.");
//                return 2*steps;
//            }
//        };

//        Walkable obj = (int steps) -> {
//            System.out.println("walking fast. " + 2*steps + " steps.");
//            return 2*steps;
//        };

//        lambda expression
        Walkable obj = (steps, isEnabled) -> {
            System.out.println("walking fast. " + 2*steps + " steps.\nEnabled = " + isEnabled);
            return 2*steps;
        };

        Walkable obj2 = (steps, isEnabled) -> 2*steps;

        obj.walk(4, true);
        obj2.walk(4, true);
    }
}

@FunctionalInterface
interface Walkable {
    int walk(int steps, boolean isEnabled);
}


//class WalkFast implements Walkable {
//    @Override
//    public int walk(int steps, boolean isEnabled) {
//        System.out.println("walking fast. " + 2*steps + " steps.\nEnabled = " + isEnabled);
//        return 2*steps;
//    }
//}
