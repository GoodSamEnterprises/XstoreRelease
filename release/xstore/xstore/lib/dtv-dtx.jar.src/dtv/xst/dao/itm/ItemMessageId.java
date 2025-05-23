/*     */ package dtv.xst.dao.itm;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemMessageId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 2088876372L;
/*     */   private String _messageId;
/*     */   private DtvDate _effectiveDate;
/*     */   
/*     */   public ItemMessageId() {}
/*     */   
/*     */   public ItemMessageId(String argObjectIdValue) {
/*  25 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMessageId() {
/*  32 */     return this._messageId;
/*     */   }
/*     */   
/*     */   public void setMessageId(String argMessageId) {
/*  36 */     this._messageId = (argMessageId != null && MANAGE_CASE) ? argMessageId.toUpperCase() : argMessageId;
/*     */   }
/*     */   
/*     */   public Date getEffectiveDate() {
/*  40 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/*  44 */     this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  49 */     String str = argObjectIdValue;
/*  50 */     if (StringUtils.isEmpty(str)) {
/*  51 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  54 */       String[] tokens = str.split("::");
/*  55 */       str = tokens[0];
/*     */       
/*  57 */       if ("null".equals(str)) {
/*  58 */         setMessageId((String)null);
/*     */       } else {
/*     */         
/*  61 */         setMessageId(str);
/*     */       } 
/*  63 */       str = tokens[1];
/*     */       
/*  65 */       setOrganizationId(Long.valueOf(str));
/*  66 */       str = tokens[2];
/*     */       
/*  68 */       if ("null".equals(str)) {
/*  69 */         setEffectiveDate((Date)null);
/*     */       } else {
/*     */         
/*  72 */         setEffectiveDate((Date)new DtvDate());
/*  73 */         this._effectiveDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       }
/*     */     
/*  76 */     } catch (Exception ee) {
/*  77 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  83 */     if (this == ob) {
/*  84 */       return true;
/*     */     }
/*  86 */     if (!(ob instanceof ItemMessageId)) {
/*  87 */       return false;
/*     */     }
/*  89 */     ItemMessageId other = (ItemMessageId)ob;
/*  90 */     return (((this._messageId == null && other._messageId == null) || (this._messageId != null && this._messageId
/*     */ 
/*     */       
/*  93 */       .equals(other._messageId))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  96 */       .equals(other._organizationId))) && ((this._effectiveDate == null && other._effectiveDate == null) || (this._effectiveDate != null && this._effectiveDate
/*     */ 
/*     */       
/*  99 */       .equals(other._effectiveDate))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 105 */     return ((this._messageId == null) ? 0 : this._messageId
/* 106 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 107 */       .hashCode()) + ((this._effectiveDate == null) ? 0 : this._effectiveDate
/* 108 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 113 */     return "ItemMessage";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 118 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 120 */     return buff.append(this._messageId)
/*     */       
/* 122 */       .append("::").append(String.valueOf(this._organizationId))
/* 123 */       .append("::").append((this._effectiveDate == null) ? "null" : String.valueOf(this._effectiveDate.getTimeSerializable()))
/* 124 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 128 */     if (this._messageId == null) {
/* 129 */       return false;
/*     */     }
/* 131 */     if (this._effectiveDate == null) {
/* 132 */       return false;
/*     */     }
/* 134 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\ItemMessageId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */