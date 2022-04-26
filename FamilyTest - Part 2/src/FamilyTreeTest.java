
public class FamilyTreeTest {

    public static void main(String[] args) {
        String name = Input.getString("Input the ancestor's name: ");
        FamilyTree familytree = new FamilyTree(name);
        Integer option = 7;
        do {
            try{
                System.out.println("0: Quit");
                System.out.println("1: Add child to current");
                System.out.println("2: Add partner to current");
                System.out.println("3: Display family");
                System.out.println("4: Find family member");
                option = Input.getInteger("Input Option: ");
                switch (option) {
                    case 1:
                        try{
                            familytree.checkPartner(name);
                            name = Input.getString("What is the child's name?: ");
                            familytree.addChild(name);
                            System.out.println(familytree);
                        } catch(FamilyTree.PartnerException e){
                            System.out.println("There has to be two parents to a child\n");
                        }
                        break;
                    case 2:
                        try{
                            familytree.checkPartner(name);
                            System.out.println("There is already a partner for this person\n");
                        } catch(FamilyTree.PartnerException e){
                            name = Input.getString("What is the partner's name?: \n");
                            familytree.addPartner(name);
                            System.out.println(familytree);
                        }
                        break;
                    case 3:
                        System.out.println(familytree);
                        break;
                    case 4:
                        System.out.println("not found");
                        break;
                }
            }
            catch(Exception e){
                System.out.println("Please choose a valid menu option between 0 and 3 \n");
            }
        }while (option != 0);
        System.out.println("\nThanks for visiting.");
        }

    }
