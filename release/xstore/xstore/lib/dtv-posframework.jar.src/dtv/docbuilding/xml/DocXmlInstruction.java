/*    */ package dtv.docbuilding.xml;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DocXmlInstruction
/*    */   implements IDocXmlSimpleElement
/*    */ {
/* 16 */   private static final Set<String> _noAttributes = Collections.emptySet();
/*    */   
/*    */   private final String _target;
/*    */   
/* 20 */   private Map<String, String> _attributes = null;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DocXmlInstruction(String argTarget) {
/* 28 */     this._target = argTarget;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Set<String> getAttributeNames() {
/* 38 */     return (this._attributes == null) ? _noAttributes : this._attributes.keySet();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getAttributeValue(String argName) {
/* 48 */     return (this._attributes == null) ? null : this._attributes.get(argName);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getTarget() {
/* 56 */     return this._target;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setAttribute(String argName, String argValue) {
/* 66 */     if (this._attributes == null) {
/* 67 */       this._attributes = new HashMap<>();
/*    */     }
/* 69 */     this._attributes.put(argName, argValue);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 75 */     return "?" + this._target + this._attributes;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\xml\DocXmlInstruction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */