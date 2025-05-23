/*    */ package dtv.dataloader.mom;
/*    */ 
/*    */ import java.util.Date;
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
/*    */ public class MOMFileConfiguration
/*    */ {
/*    */   private Integer _numberOfLines;
/*    */   private String _storeId;
/*    */   private Date _timestamp;
/*    */   
/*    */   public Date getTimestamp() {
/* 26 */     return this._timestamp;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setTimestamp(Date timestamp) {
/* 34 */     this._timestamp = timestamp;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Integer getNumberOfLines() {
/* 43 */     return this._numberOfLines;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getStoreId() {
/* 51 */     return this._storeId;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setNumberOfLines(Integer argNumberOfLines) {
/* 60 */     this._numberOfLines = argNumberOfLines;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setNumberOfLines(String argNumberOfLines) throws NumberFormatException {
/* 71 */     setNumberOfLines(Integer.valueOf(argNumberOfLines));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setStoreId(String argStoreId) {
/* 79 */     this._storeId = argStoreId;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\dataloader\mom\MOMFileConfiguration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */