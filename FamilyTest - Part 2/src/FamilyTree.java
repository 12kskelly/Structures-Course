
public class FamilyTree {
    
    
    public class PartnerException extends Exception{}
    
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
        familyMember.ancestor = this.current.partner;           
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
    
    public String toString() {
        String familyDetails = new String();
        FamilyTreeNode familyMember2 = this.manager.partner;
        if (this.manager.partner == null){
            familyDetails = this.manager.name + " doesn't have any family";
        }
        else{
            familyDetails += this.manager.name + " partner is " + familyMember2.name + "\n";
            FamilyTreeNode familyMember = this.manager.child;
            if (familyMember == null) {
                familyDetails += "  has no children\n";
            } else {
                while (familyMember != null) {
                    familyDetails += "  " + familyMember.name + "\n";
                    familyDetails += this.getChildren(familyMember);
                    familyMember = familyMember.sibling;
                }
            }
            familyDetails += familyMember2.name + " partner is " + this.manager.name + "\n";
            if (familyMember == null) {
                familyDetails += "  has no children\n";
            } else {
                while (familyMember != null) {
                    familyDetails += "  " + familyMember.name + "\n";
                    familyDetails += this.getChildren(familyMember);
                    familyMember = familyMember.sibling;
                }
            }
        }
            return familyDetails;
    }
    
    private String getChildren(FamilyTreeNode familyMember) {
        String childsDetails = new String();
        familyMember = familyMember.child;
        return childsDetails;
        
    }
    
    public void checkPartner(String name) throws PartnerException{
        if (this.current.partner == null) {
            throw new PartnerException();
        } else {
        }
    }
    
    }
    
