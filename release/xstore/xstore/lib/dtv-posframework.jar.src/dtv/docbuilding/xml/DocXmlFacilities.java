/*    */ package dtv.docbuilding.xml;
/*    */ 
/*    */ import dtv.docbuilding.DocSectionMap;
/*    */ import dtv.docbuilding.config.FormatterMapConfig;
/*    */ import dtv.i18n.formatter.output.IOutputFormatter;
/*    */ import dtv.util.StringUtils;
/*    */ import dtv.util.config.IHasSourceDescription;
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
/*    */ 
/*    */ public class DocXmlFacilities
/*    */   implements IHasSourceDescription
/*    */ {
/*    */   private final DocSectionMap _sectionMap;
/*    */   private final FormatterMapConfig _formatterMap;
/*    */   private final IDocXmlExpressionator _expressionator;
/*    */   
/*    */   public static String formatNonNull(Object argValue, IOutputFormatter argFormatter) {
/* 37 */     String result = (argFormatter == null) ? StringUtils.nonNull(argValue) : StringUtils.nonNull(argFormatter.format(argValue, null));
/* 38 */     return result;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 45 */   private String _sourceDescription = null;
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
/*    */   public DocXmlFacilities(DocSectionMap argSectionMap, FormatterMapConfig argFormatterMap, IDocXmlExpressionator argExpressionator) {
/* 59 */     this._sectionMap = argSectionMap;
/* 60 */     this._formatterMap = argFormatterMap;
/* 61 */     this._expressionator = argExpressionator;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public FormatterMapConfig getFormatterMap() {
/* 69 */     return this._formatterMap;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DocSectionMap getSectionMap() {
/* 77 */     return this._sectionMap;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getSourceDescription() {
/* 83 */     return this._sourceDescription;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setSourceDescription(String argSourceDescription) {
/* 91 */     this._sourceDescription = argSourceDescription;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   IDocXmlExpressionator getExpressionator() {
/* 99 */     return this._expressionator;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\xml\DocXmlFacilities.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */