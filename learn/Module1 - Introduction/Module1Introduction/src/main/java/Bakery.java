public class Bakery {
    public static void main(String[] args) {
        CakeBaker cakeBaker = new CakeBaker(new StrawberryFrosting(), new ChocolateSyrup()); // counter
        System.out.println("Welcome");
        cakeBaker.bakeCake();
    }
}
