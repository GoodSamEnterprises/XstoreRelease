/*    */ package dtv.docbuilding.xml;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DocXmlRootElement
/*    */   implements IDocXmlElement
/*    */ {
/*    */   private final List<IDocXmlSimpleElement> _children;
/*    */   
/*    */   public DocXmlRootElement(List<IDocXmlSimpleElement> argChildren) {
/* 22 */     this._children = argChildren;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Set<? extends DocXmlAttribute> getAttributes() {
/* 28 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public List<IDocXmlSimpleElement> getChildren() {
/* 34 */     return this._children;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 40 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public DocXmlNamespace getNamespace() {
/* 46 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Set<? extends DocXmlNamespace> getNamespaceDeclarations() {
/* 52 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getText() {
/* 58 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\xml\DocXmlRootElement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */