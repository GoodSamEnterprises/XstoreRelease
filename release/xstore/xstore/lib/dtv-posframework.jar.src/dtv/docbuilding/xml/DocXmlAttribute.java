/*    */ package dtv.docbuilding.xml;
/*    */ 
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
/*    */ public class DocXmlAttribute
/*    */ {
/*    */   private final String _name;
/*    */   private final String _namespacePrefix;
/*    */   private final String _value;
/*    */   
/*    */   public DocXmlAttribute(String argName, String argValue) {
/* 27 */     this(argName, null, argValue);
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
/*    */   public DocXmlAttribute(String argName, String argNamespacePrefix, String argValue) {
/* 39 */     this._name = argName;
/* 40 */     this._namespacePrefix = argNamespacePrefix;
/* 41 */     this._value = argValue;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 49 */     return this._name;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getNamespacePrefix() {
/* 57 */     return this._namespacePrefix;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getValue() {
/* 65 */     return this._value;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 71 */     return (StringUtils.isEmpty(this._namespacePrefix) ? "" : (this._namespacePrefix + ":")) + this._name + "=" + this._value;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\xml\DocXmlAttribute.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */