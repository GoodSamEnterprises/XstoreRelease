/*    */ package dtv.pos.framework.action.type;
/*    */ 
/*    */ import dtv.pos.iframework.action.IXstActionKey;
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
/*    */ public class DummyActionKey
/*    */   implements IXstActionKey
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public IXstActionKey get(String key) {
/* 23 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\action\type\DummyActionKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */