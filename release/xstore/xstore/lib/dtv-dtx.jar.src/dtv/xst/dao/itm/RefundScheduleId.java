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
/*     */ public class RefundScheduleId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1284811343L;
/*     */   private String _itemId;
/*     */   private DtvDate _effectiveDate;
/*     */   
/*     */   public RefundScheduleId() {}
/*     */   
/*     */   public RefundScheduleId(String argObjectIdValue) {
/*  25 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemId() {
/*  32 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/*  36 */     this._itemId = (argItemId != null && MANAGE_CASE) ? argItemId.toUpperCase() : argItemId;
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
/*  57 */       setOrganizationId(Long.valueOf(str));
/*  58 */       str = tokens[1];
/*     */       
/*  60 */       if ("null".equals(str)) {
/*  61 */         setItemId((String)null);
/*     */       } else {
/*     */         
/*  64 */         setItemId(str);
/*     */       } 
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
/*  86 */     if (!(ob instanceof RefundScheduleId)) {
/*  87 */       return false;
/*     */     }
/*  89 */     RefundScheduleId other = (RefundScheduleId)ob;
/*  90 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  93 */       .equals(other._organizationId))) && ((this._itemId == null && other._itemId == null) || (this._itemId != null && this._itemId
/*     */ 
/*     */       
/*  96 */       .equals(other._itemId))) && ((this._effectiveDate == null && other._effectiveDate == null) || (this._effectiveDate != null && this._effectiveDate
/*     */ 
/*     */       
/*  99 */       .equals(other._effectiveDate))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 105 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 106 */       .hashCode()) + ((this._itemId == null) ? 0 : this._itemId
/* 107 */       .hashCode()) + ((this._effectiveDate == null) ? 0 : this._effectiveDate
/* 108 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 113 */     return "RefundSchedule";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 118 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 120 */     return buff.append(
/* 121 */         String.valueOf(this._organizationId))
/* 122 */       .append("::").append(this._itemId)
/* 123 */       .append("::").append((this._effectiveDate == null) ? "null" : String.valueOf(this._effectiveDate.getTimeSerializable()))
/* 124 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 128 */     if (this._itemId == null) {
/* 129 */       return false;
/*     */     }
/* 131 */     if (this._effectiveDate == null) {
/* 132 */       return false;
/*     */     }
/* 134 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\RefundScheduleId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */