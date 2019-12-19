/**
 * Public class Test, used for testing the ADT and Interfaces.
 * COM498 Coursework 2
 * B00757542
 * John Lee O'Connell
 */

public class Test {
    public static void main (String[] args) {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("***Testing Started***");

        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Integer Testing:");
        DeckInterface<Integer> testInt = new Deck<>(true);
        Integer[] array = {10, 20, 30, 40, 50, 60, 70, 80, 100};
        for (int i = 0; i < array.length; i++) {
            testInt.addNew(array[i]);
        }
        // Testing show
        testInt.show();
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Swap test, pos 1 and 2 should swap");
        testInt.swapNode(1, 2);
        if (testInt.find(array[0]) == 1) {
            System.out.println("Test failed");
        } else {
            System.out.println("Test passed");
        }
        testInt.show();
        int pos = testInt.find(20);
        System.out.println("20 is found at position: " + pos);
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Testing shuffles:");
        System.out.println("Random shuffle");
        //random shuffle is gerating incorrect sizes of rand
        testInt.shuffle();
        testInt.show();
        System.out.println("In shuffle");
        testInt.inShuffle();
        testInt.show();
        System.out.println("Out shuffle");
        testInt.outShuffle();
        testInt.show();
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Reveal testing:");
        testInt.reveal();
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Remove testing:");
        testInt.remove();
        testInt.show();
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Add position testing");
        testInt.addNew(27, 2);
        testInt.show();
        // end
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("******Testing Finished******");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("John Lee O'Connell\nB00757542\nCW2 COM498\n2nd Year Software Engineering");
    }

}


