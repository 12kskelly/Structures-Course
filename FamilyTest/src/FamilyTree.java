
public class FamilyTree {
    
    private class FamilyTreeNode {
        private String name;
        private FamilyTreeNode ancestor;
        private FamilyTreeNode partner;
        private FamilyTreeNode sibling;
        private FamilyTreeNode child;
    }
    
    private FamilyTreeNode manager;
    private FamilyTreeNode current;
    private FamilyTreeNode current2;
    
    public FamilyTree(String managerName) {
        this.manager = new FamilyTreeNode();
        this.manager.name = managerName;
        this.current = this.manager;
    }
    
    public void addPartner(String name) {
        FamilyTreeNode familyMember = new FamilyTreeNode();
        familyMember.name = name;
        familyMember.partner = this.current;
        this.current.partner = familyMember;
    }
    
    public void addChild(String name) {
        FamilyTreeNode familyMember = new FamilyTreeNode();
        familyMember.name = name;
        familyMember.ancestor = this.current;
        familyMember.partner = this.current.partner;
        if (this.current.child == null) {
            this.current.child = familyMember;
        } else {
            FamilyTreeNode next = this.current.child;
            while (next.sibling != null) {
                next = next.sibling;
            }
            next.sibling = familyMember;
        }
    }
}
