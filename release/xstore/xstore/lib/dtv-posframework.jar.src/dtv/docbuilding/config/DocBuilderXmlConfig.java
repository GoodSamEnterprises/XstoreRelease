/*    */ package dtv.docbuilding.config;
/*    */ 
/*    */ import dtv.docbuilding.DocBuilderXmlBlock;
/*    */ import dtv.docbuilding.DocSectionMap;
/*    */ import dtv.util.config.PrimitiveConfig;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DocBuilderXmlConfig
/*    */   extends PrimitiveConfig
/*    */   implements ISectionMemberConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 31 */   private String _xml = null;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DocBuilderXmlBlock makeXmlBlock(DocSectionMap argSectionMap, FormatterMapConfig argFormatters) {
/* 41 */     DocBuilderXmlBlock block = new DocBuilderXmlBlock(this._xml, argSectionMap, argFormatters);
/* 42 */     block.setSourceDescription(getSourceDescription());
/*    */     
/* 44 */     return block;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setValue(String argValue) {
/* 50 */     this._xml = argValue;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\config\DocBuilderXmlConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */