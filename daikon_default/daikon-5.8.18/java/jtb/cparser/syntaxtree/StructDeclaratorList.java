//
// Generated by JTB 1.1.2
//

package jtb.cparser.syntaxtree;

// Grammar production:
// f0 -> StructDeclarator()
// f1 -> ( "," StructDeclarator() )*
public class StructDeclaratorList implements Node {
  static final long serialVersionUID = 20050923L;

   public StructDeclarator f0;
   public NodeListOptional f1;

   public StructDeclaratorList(StructDeclarator n0, NodeListOptional n1) {
      f0 = n0;
      f1 = n1;
   }

   public void accept(jtb.cparser.visitor.Visitor v) {
      v.visit(this);
   }
}
