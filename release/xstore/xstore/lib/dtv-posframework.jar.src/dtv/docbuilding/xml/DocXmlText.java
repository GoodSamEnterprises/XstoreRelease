/*    */ package dtv.docbuilding.xml;
/*    */ 
/*    */ import dtv.docbuilding.IDocElementFactory;
/*    */ import dtv.i18n.formatter.output.IOutputFormatter;
/*    */ import dtv.util.StringUtils;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DocXmlText
/*    */ {
/*    */   private final String _fullName;
/*    */   private final IOutputFormatter _formatter;
/*    */   private final String _sourceDescription;
/*    */   private final boolean _literal;
/*    */   
/*    */   public DocXmlText(String argName, String argNamespacePrefix, IOutputFormatter argFormatter, boolean argLiteral, String argSourceDescription) {
/* 41 */     this._fullName = StringUtils.isEmpty(argNamespacePrefix) ? argName : (argNamespacePrefix + ":" + argName);
/* 42 */     this._formatter = argFormatter;
/* 43 */     this._literal = argLiteral;
/* 44 */     this._sourceDescription = argSourceDescription;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String evaluateAndFormat(IDocXmlExpressionator argEvaluator, Object argSource, IDocElementFactory argFactory) {
/* 65 */     String value = this._literal ? argFactory.getParameterMap().resolveParamValue(this._fullName) : this._fullName;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 71 */     value = this._literal ? DocXmlFacilities.formatNonNull(value, this._formatter) : argEvaluator.evaluateAndFormat(value, argSource, this._formatter, argFactory, this._sourceDescription);
/*    */     
/* 73 */     return StringUtils.nonNull(value);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 79 */     return this._fullName;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\xml\DocXmlText.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */