/*    */ package dtv.pos.framework.reporting.type;
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
/*    */ public enum ReportOutputFormat
/*    */ {
/* 18 */   PDF((byte)11), HTML((byte)3), XLS((byte)36, true),
/* 19 */   XLSX((byte)36, true), PPTX((byte)26, true), RTF((byte)2, true),
/* 20 */   DOCX((byte)21, true);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private byte _formatId;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private boolean _clickToDownload;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   ReportOutputFormat(byte argFormatId, boolean argClickToDownload) {
/* 37 */     this._formatId = argFormatId;
/* 38 */     this._clickToDownload = argClickToDownload;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public byte getFormatId() {
/* 46 */     return this._formatId;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getTranslationKey() {
/* 54 */     return "_reportOutputFormat_" + name();
/*    */   }
/*    */   
/*    */   public boolean isClickToDownload() {
/* 58 */     return this._clickToDownload;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\reporting\type\ReportOutputFormat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */