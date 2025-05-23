/*    */ package dtv.docbuilding.xml;
/*    */ 
/*    */ import dtv.i18n.formatter.output.IOutputFormatter;
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
/*    */ public class DocXmlTextFactory
/*    */   implements IDocXmlTextFactory
/*    */ {
/* 21 */   private DocXmlFacilities _facilities = null;
/*    */ 
/*    */ 
/*    */   
/*    */   public List<DocXmlText> createExpressionTexts(String argExpr) {
/* 26 */     List<DocXmlText> texts = new ArrayList<>();
/*    */     
/* 28 */     for (DocXmlTextDescriptor descriptor : this._facilities.getExpressionator().describe(argExpr)) {
/*    */ 
/*    */       
/* 31 */       DocXmlText text = descriptor.isLiteral() ? createLiteralValue(descriptor.getLiteralOrExpression()) : createExpressionText(descriptor.getLiteralOrExpression(), descriptor.getFormatterName());
/*    */       
/* 33 */       texts.add(text);
/*    */     } 
/* 35 */     return texts;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public DocXmlText createLiteralName(String argName, String argNamespacePrefix) {
/* 41 */     return new DocXmlText(argName, argNamespacePrefix, null, true, this._facilities.getSourceDescription());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public DocXmlText createLiteralValue(String argValue) {
/* 47 */     return new DocXmlText(argValue, null, null, true, this._facilities.getSourceDescription());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void initialize(DocXmlFacilities argFacilities) {
/* 53 */     this._facilities = argFacilities;
/*    */   }
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
/*    */   protected DocXmlText createExpressionText(String argExpr, String argFormatterName) {
/* 67 */     IOutputFormatter formatter = this._facilities.getFormatterMap().getFormatter(argFormatterName);
/* 68 */     return new DocXmlText(argExpr, null, formatter, false, this._facilities.getSourceDescription());
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\xml\DocXmlTextFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */