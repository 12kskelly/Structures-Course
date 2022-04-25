
public class FamilyTest {
  
    public static void main(String[] args) {
        String name = Input.getString("Input the ancestor's name: ");
        FamilyTree familytree = new FamilyTree(name);
        name = Input.getString("What is their partner's name: ");
        familytree.addPartner(name);
        Integer option;
    
}
