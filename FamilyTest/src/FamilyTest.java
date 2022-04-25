
public class FamilyTest {

    public static void main(String[] args) {
        String name = Input.getString("Input the ancestor's name: ");
        FamilyTree familytree = new FamilyTree(name);
        name = Input.getString("What is their partner's name: ");
        familytree.addPartner(name);
        Integer option;
        do {
            System.out.println("0: quit");
            System.out.println("1: add child to current");
            System.out.println("2: find family member");
            System.out.println("3: display family");
            option = Input.getInteger("input option: ");
            switch (option) {
                case 1:
                    System.out.println("Test 1");
                    break;  
                case 2:
                    System.out.println("Test 2");
                    break;
                case 3:
                    System.out.println("Test 3");
                    break;             
            }
        } while (option != 0);
    }

}