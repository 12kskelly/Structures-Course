
public class FamilyTree {
    
    
    public class PartnerException extends Exception{}
    
    public class MemberNotFoundException extends Exception{}
    
    private class FamilyTreeNode {
        private String name;
        private FamilyTreeNode ancestor;
        private FamilyTreeNode partner;
        private FamilyTreeNode sibling;
        private FamilyTreeNode child;
    }
    
    private FamilyTreeNode mainAncestor;
    private FamilyTreeNode current;
    private FamilyTreeNode current2;
    
    public FamilyTree(String mainAncestorName) {
        this.mainAncestor = new FamilyTreeNode();
        this.mainAncestor.name = mainAncestorName;
        this.current = this.mainAncestor;
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
        FamilyTreeNode familyMember2 = this.mainAncestor.partner;
        if (this.mainAncestor.partner == null){
            familyDetails = this.mainAncestor.name + " doesn't have any family";
        }
        else{
            familyDetails += this.mainAncestor.name + " partner is " + familyMember2.name + "\n";
            FamilyTreeNode familyMember = this.mainAncestor.child;
            if (familyMember == null) {
                familyDetails += "  has no children\n";
            } else {
                while (familyMember != null) {
                    familyDetails += "  " + familyMember.name + "\n";
                    familyDetails += this.getChildren(familyMember);
                    familyMember = familyMember.sibling;
                }
            }
            familyDetails += familyMember2.name + " partner is " + this.mainAncestor.name + "\n";
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
        if (familyMember == null) {
            childsDetails += " has no children\n";
        } else {
            while (familyMember != null) {
                childsDetails += "    " + familyMember.name + "\n";
                familyMember = familyMember.sibling;
            }
        }
        
        
        return childsDetails;
        
    }
    
    public void checkPartner(String name) throws PartnerException{
        if (this.current.partner == null) {
            throw new PartnerException();
        } else {
        }
    }
    
    private FamilyTreeNode checkChild(String name, FamilyTreeNode familyMember) {
    familyMember=familyMember.child;
    Boolean searching=familyMember!=null;
    while (searching) {
        if (name.equalsIgnoreCase(familyMember.name)) {
            searching = false;
        } else {
            familyMember = familyMember.sibling;
            if (familyMember == null) {
                searching = false;
            }
        }
    }
    return familyMember;
}
    
    
    public void findMember(String name) throws MemberNotFoundException{
    FamilyTreeNode familyMember;
    FamilyTreeNode child;
    if (name.equalsIgnoreCase(this.mainAncestor.name)) {
        familyMember = this.mainAncestor;
    } else {
        if(this.mainAncestor.child==null)
            throw new MemberNotFoundException();
        familyMember = this.checkChild(name, this.mainAncestor);
        if (familyMember == null) {
            child = this.mainAncestor.child;
            while (familyMember==null) {
                familyMember = this.checkChild(name, child);
                if (familyMember == null) {
                    child = child.sibling;
                    if (child == null) {
                        throw new MemberNotFoundException();
                    }
                }
            }
        }
    }
    this.current=familyMember;
}
    
    public String getCurrent() {
    String currentDetails = new String();
    currentDetails += this.current.name;
    if (this.current.ancestor != null) {
        currentDetails += " partner " + this.current.ancestor.name + '\n';
    } else {
        currentDetails += " has no partner\n";
    }
    currentDetails += this.getChildren(this.current);
    return currentDetails;
}
    
    }
    
