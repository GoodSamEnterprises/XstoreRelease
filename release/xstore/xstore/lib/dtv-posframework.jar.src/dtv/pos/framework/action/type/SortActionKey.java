/*    */ package dtv.pos.framework.action.type;
/*    */ 
/*    */ import dtv.pos.iframework.action.IXstActionKey;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ public class SortActionKey
/*    */   implements IXstActionKey
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 22 */   private static Map<String, SortActionKey> values_ = new HashMap<>();
/*    */ 
/*    */ 
/*    */   
/*    */   private final String _listType;
/*    */ 
/*    */ 
/*    */   
/*    */   public static SortActionKey valueOf(String argName) {
/* 31 */     if (argName == null) {
/* 32 */       return null;
/*    */     }
/*    */     
/* 35 */     SortActionKey found = values_.get(argName.trim().toUpperCase());
/*    */     
/* 37 */     if (found == null) {
/* 38 */       found = new SortActionKey(argName);
/*    */     }
/*    */     
/* 41 */     return found;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private SortActionKey(String argListType) {
/* 52 */     this._listType = argListType.trim().toUpperCase();
/* 53 */     values_.put(this._listType, this);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object argObject) {
/* 59 */     return (argObject instanceof SortActionKey && ((SortActionKey)argObject)._listType.equals(this._listType));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IXstActionKey get(String argKey) {
/* 65 */     return valueOf(argKey);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 71 */     return this._listType.hashCode();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 77 */     return this._listType;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\action\type\SortActionKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */