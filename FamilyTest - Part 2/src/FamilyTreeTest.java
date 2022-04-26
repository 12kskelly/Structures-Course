
public class FamilyTreeTest {

    public static void main(String[] args) {
        String name = Input.getString("Input the ancestor's name: ");
        FamilyTree familytree = new FamilyTree(name);
        Integer option = 7;
        do {
            try{
                System.out.println("0: quit");
                System.out.println("1: add child to current");
                System.out.println("2: add partner to current");
                System.out.println("3: display family");
                option = Input.getInteger("input option: ");
                switch (option) {
                    case 1:
                        try{
                        name = Input.getString("input the child's name: ");
                        familytree.addChild(name);
                        } catch(FamilyTree.NoPartnerException e){
                            System.out.println("There must be two parents to add on a child\n");
                        }
                        break;
                    case 2:
                        name = Input.getString("What is their partner's name: ");
                        familytree.addPartner(name);
                        break;
                     case 3:
                        System.out.println(familytree);
                        break;
                }
            }
            catch(Exception e){
                System.out.println("Please choose a valid menu option between 0 and 3 \n");
            }
        }while (option != 0);
        System.out.println("Thanks for visiting.");
        }

    }
