/* Generated By:JavaCC: Do not edit this line. ArchParserDefaultVisitor.java Version 6.0_1 */
package wyvern.tools.parsing.coreparser.arch;

public class ArchParserDefaultVisitor implements ArchParserVisitor{
  public Object defaultVisit(SimpleNode node, Object data){
    node.childrenAccept(this, data);
    return data;
  }
  public Object visit(SimpleNode node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTArchDesc node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTComponentTypeDecl node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTConnectorTypeDecl node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTArchitectureTypeDecl node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTComponentDecl node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTConnectorDecl node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTAttachmentDecl node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTBindingDecl node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTEntryPointDecl node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTPortDecl node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTValDecl node, Object data){
    return defaultVisit(node, data);
  }
}
/* JavaCC - OriginalChecksum=85516206f2a2eb5532534e669537b51a (do not edit this line) */
