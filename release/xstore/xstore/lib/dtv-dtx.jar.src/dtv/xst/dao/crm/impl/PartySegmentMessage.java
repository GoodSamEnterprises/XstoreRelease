/*    */ package dtv.xst.dao.crm.impl;
/*    */ 
/*    */ import dtv.xst.dao.crm.IPartySegmentMessage;
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
/*    */ public class PartySegmentMessage
/*    */   implements IPartySegmentMessage
/*    */ {
/*    */   private final String _language;
/*    */   private final String _message;
/*    */   
/*    */   public PartySegmentMessage(String argLanguage, String argMessage) {
/* 27 */     this._language = argLanguage;
/* 28 */     this._message = argMessage;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getLanguage() {
/* 34 */     return this._language;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getMessage() {
/* 40 */     return this._message;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\impl\PartySegmentMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */