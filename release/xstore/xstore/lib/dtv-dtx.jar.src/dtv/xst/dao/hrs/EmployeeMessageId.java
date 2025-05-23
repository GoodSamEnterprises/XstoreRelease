/*     */ package dtv.xst.dao.hrs;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EmployeeMessageId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 414263641L;
/*     */   private Long _messageId;
/*     */   
/*     */   public EmployeeMessageId() {}
/*     */   
/*     */   public EmployeeMessageId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getMessageId() {
/*  29 */     return this._messageId;
/*     */   }
/*     */   
/*     */   public void setMessageId(Long argMessageId) {
/*  33 */     this._messageId = argMessageId;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  37 */     String str = argObjectIdValue;
/*  38 */     if (StringUtils.isEmpty(str)) {
/*  39 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  42 */       String[] tokens = str.split("::");
/*  43 */       str = tokens[0];
/*     */       
/*  45 */       setOrganizationId(Long.valueOf(str));
/*  46 */       str = tokens[1];
/*     */       
/*  48 */       setMessageId(Long.valueOf(str));
/*     */     }
/*  50 */     catch (Exception ee) {
/*  51 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  57 */     if (this == ob) {
/*  58 */       return true;
/*     */     }
/*  60 */     if (!(ob instanceof EmployeeMessageId)) {
/*  61 */       return false;
/*     */     }
/*  63 */     EmployeeMessageId other = (EmployeeMessageId)ob;
/*  64 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  67 */       .equals(other._organizationId))) && ((this._messageId == null && other._messageId == null) || (this._messageId != null && this._messageId
/*     */ 
/*     */       
/*  70 */       .equals(other._messageId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  76 */     return ((this._organizationId == null) ? 0 : this._organizationId
/*  77 */       .hashCode()) + ((this._messageId == null) ? 0 : this._messageId
/*  78 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/*  83 */     return "EmployeeMessage";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  88 */     StringBuilder buff = new StringBuilder(24);
/*     */     
/*  90 */     return buff.append(
/*  91 */         String.valueOf(this._organizationId))
/*  92 */       .append("::").append(String.valueOf(this._messageId))
/*  93 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/*  97 */     if (this._messageId == null) {
/*  98 */       return false;
/*     */     }
/* 100 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\hrs\EmployeeMessageId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */