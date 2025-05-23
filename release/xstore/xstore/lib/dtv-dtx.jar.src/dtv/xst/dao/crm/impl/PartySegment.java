/*    */ package dtv.xst.dao.crm.impl;
/*    */ 
/*    */ import dtv.xst.dao.crm.IPartySegment;
/*    */ import dtv.xst.dao.crm.IPartySegmentMessage;
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
/*    */ public class PartySegment
/*    */   implements IPartySegment
/*    */ {
/*    */   private String _segmentId;
/*    */   private String _description;
/*    */   private String _name;
/* 25 */   private final List<IPartySegmentMessage> _segmentMessages = new ArrayList<>();
/*    */ 
/*    */ 
/*    */   
/*    */   public void addSegmentMessage(IPartySegmentMessage argSegmentMessage) {
/* 30 */     this._segmentMessages.add(argSegmentMessage);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getDescription() {
/* 36 */     return this._description;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 42 */     return this._name;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getSegmentId() {
/* 48 */     return this._segmentId;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getSegmentMessage(String argLocale) {
/* 54 */     String message = null;
/*    */ 
/*    */     
/* 57 */     String language = (argLocale == null) ? null : argLocale.substring(0, 2);
/*    */     
/* 59 */     for (IPartySegmentMessage segmentMessage : this._segmentMessages) {
/* 60 */       if (segmentMessage.getLanguage().equalsIgnoreCase(language)) {
/* 61 */         message = segmentMessage.getMessage();
/*    */         
/*    */         break;
/*    */       } 
/*    */     } 
/*    */     
/* 67 */     if (message == null && !this._segmentMessages.isEmpty()) {
/* 68 */       message = ((IPartySegmentMessage)this._segmentMessages.get(0)).getMessage();
/*    */     }
/*    */     
/* 71 */     return message;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public List<IPartySegmentMessage> getSegmentMessages() {
/* 77 */     return this._segmentMessages;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setDescription(String argDescription) {
/* 83 */     this._description = argDescription;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setName(String argName) {
/* 89 */     this._name = argName;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setSegmentId(String argId) {
/* 95 */     this._segmentId = argId;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\impl\PartySegment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */