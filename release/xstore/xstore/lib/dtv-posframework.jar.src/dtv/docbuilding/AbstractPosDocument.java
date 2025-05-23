/*    */ package dtv.docbuilding;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
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
/*    */ 
/*    */ public abstract class AbstractPosDocument
/*    */   implements IPosDocument
/*    */ {
/*    */   private static final long serialVersionUID = 337957126243271855L;
/* 22 */   private final List<IDocElement> els_ = new ArrayList<>();
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
/*    */ 
/*    */ 
/*    */   
/*    */   public final void appendElements(IDocElement[] aElements) throws IOException {
/* 38 */     for (IDocElement e : aElements) {
/* 39 */       appendElement(e);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final IDocElement[] getElements() {
/* 50 */     IDocElement[] a = new IDocElement[this.els_.size()];
/* 51 */     return this.els_.<IDocElement>toArray(a);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isReadable() {
/* 61 */     return true;
/*    */   }
/*    */   
/*    */   protected List<IDocElement> getElementList() {
/* 65 */     return this.els_;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\AbstractPosDocument.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */