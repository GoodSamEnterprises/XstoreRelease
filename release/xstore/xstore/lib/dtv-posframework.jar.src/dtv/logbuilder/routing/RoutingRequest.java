/*     */ package dtv.logbuilder.routing;
/*     */ 
/*     */ import dtv.util.ObjectUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RoutingRequest
/*     */ {
/*     */   private final String documentId_;
/*     */   private final String fileId_;
/*     */   private String toString_;
/*     */   
/*     */   public RoutingRequest(String argDocumentId, String argFileId) {
/*  27 */     this.documentId_ = argDocumentId;
/*  28 */     this.fileId_ = argFileId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argOther) {
/*  40 */     if (argOther == this) {
/*  41 */       return true;
/*     */     }
/*  43 */     if (!(argOther instanceof RoutingRequest)) {
/*  44 */       return false;
/*     */     }
/*  46 */     RoutingRequest other = (RoutingRequest)argOther;
/*     */     
/*  48 */     return (ObjectUtils.equivalent(other.documentId_, this.documentId_) && 
/*  49 */       ObjectUtils.equivalent(other.fileId_, this.fileId_));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDocumentId() {
/*  58 */     return this.documentId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFileId() {
/*  67 */     return this.fileId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  77 */     int result = 17;
/*  78 */     result = 37 * result + this.documentId_.hashCode();
/*  79 */     result = 37 * result + this.fileId_.hashCode();
/*  80 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  91 */     if (this.toString_ == null) {
/*  92 */       StringBuffer sb = new StringBuffer();
/*  93 */       sb.append("RoutingRequest[");
/*  94 */       sb.append(this.documentId_);
/*  95 */       sb.append("-->");
/*  96 */       sb.append(this.fileId_);
/*  97 */       sb.append("]");
/*  98 */       this.toString_ = sb.toString();
/*     */     } 
/* 100 */     return this.toString_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\routing\RoutingRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */