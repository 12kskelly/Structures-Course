
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
                            familytree.checkPartner(name);
                            name = Input.getString("What is the child's name?: ");
                            familytree.addChild(name);
                            System.out.println("Child Added\n");
                        } catch(FamilyTree.PartnerException e){
                            System.out.println("There has to be two parent to a child");
                        }
                        break;
                    case 2:
                        try{
                            familytree.checkPartner(name);
                            System.out.println("There is already a partner for this person\n");
                        } catch(FamilyTree.PartnerException e){
                            name = Input.getString("What is the partner's name?: ");
                            familytree.addPartner(name);
                        }
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
