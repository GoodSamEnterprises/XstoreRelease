/*    */ package dtv.logbuilder.oxm;
/*    */ 
/*    */ import dtv.docbuilding.AbstractPosDocument;
/*    */ import dtv.docbuilding.FormattedLine;
/*    */ import dtv.docbuilding.IDocElement;
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
/*    */ public class XmlPosDocument
/*    */   extends AbstractPosDocument
/*    */   implements IXmlPosDocument
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 22 */   private final StringBuilder xmlString_ = new StringBuilder();
/*    */ 
/*    */   
/*    */   public void appendElement(IDocElement argElement) {
/* 26 */     List<IDocElement> els = getElementList();
/* 27 */     els.add(argElement);
/*    */     
/* 29 */     for (Object line : argElement.getLines()) {
/* 30 */       if (line instanceof FormattedLine) {
/* 31 */         this.xmlString_.append(((FormattedLine)line).getRawText());
/*    */         continue;
/*    */       } 
/* 34 */       this.xmlString_.append(line.toString());
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getXmlString() {
/* 41 */     return this.xmlString_.toString();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\oxm\XmlPosDocument.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */