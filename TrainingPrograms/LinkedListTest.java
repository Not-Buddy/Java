public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.print("Initial list: ");
        list.display();

        System.out.println("Contains 2? " + list.contains(2));

        System.out.println("Removing 2...");
        list.remove(2);

        System.out.print("After removal: ");
        list.display();
    }
}
