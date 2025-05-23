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
/*    */ public class DocXmlNamespace
/*    */ {
/* 18 */   public static final DocXmlNamespace DEFAULT = new DocXmlNamespace("", "");
/*    */ 
/*    */   
/*    */   private final String _prefix;
/*    */ 
/*    */   
/*    */   private final String _uri;
/*    */ 
/*    */   
/*    */   public DocXmlNamespace(String argUri) {
/* 28 */     this("", argUri);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DocXmlNamespace(String argPrefix, String argUri) {
/* 39 */     this._prefix = StringUtils.nonNull(argPrefix);
/* 40 */     this._uri = StringUtils.nonNull(argUri);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getPrefix() {
/* 48 */     return this._prefix;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getURI() {
/* 56 */     return this._uri;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toDeclaration() {
/* 64 */     StringBuilder sb = new StringBuilder();
/*    */     
/* 66 */     if (!StringUtils.isEmpty(this._uri)) {
/* 67 */       sb.append("xmlns");
/* 68 */       if (!StringUtils.isEmpty(this._prefix)) {
/* 69 */         sb.append(":").append(this._prefix);
/*    */       }
/* 71 */       sb.append("=\"").append(this._uri).append("\"");
/*    */     } 
/* 73 */     return sb.toString();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 79 */     return toDeclaration();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\xml\DocXmlNamespace.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */