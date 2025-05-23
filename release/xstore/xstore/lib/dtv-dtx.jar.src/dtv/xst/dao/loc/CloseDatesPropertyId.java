/*     */ package dtv.xst.dao.loc;
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
/*     */ public class CloseDatesPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1128690818L;
/*     */   private Long _retailLocationId;
/*     */   private DtvDate _closeDate;
/*     */   private String _propertyCode;
/*     */   
/*     */   public CloseDatesPropertyId() {}
/*     */   
/*     */   public CloseDatesPropertyId(String argObjectIdValue) {
/*  25 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getRetailLocationId() {
/*  33 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  37 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public Date getCloseDate() {
/*  41 */     return (Date)this._closeDate;
/*     */   }
/*     */   
/*     */   public void setCloseDate(Date argCloseDate) {
/*  45 */     this._closeDate = (argCloseDate == null || argCloseDate instanceof DtvDate) ? (DtvDate)argCloseDate : new DtvDate(argCloseDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPropertyCode() {
/*  50 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  54 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  58 */     String str = argObjectIdValue;
/*  59 */     if (StringUtils.isEmpty(str)) {
/*  60 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  63 */       String[] tokens = str.split("::");
/*  64 */       str = tokens[0];
/*     */       
/*  66 */       setOrganizationId(Long.valueOf(str));
/*  67 */       str = tokens[1];
/*     */       
/*  69 */       setRetailLocationId(Long.valueOf(str));
/*  70 */       str = tokens[2];
/*     */       
/*  72 */       if ("null".equals(str)) {
/*  73 */         setCloseDate((Date)null);
/*     */       } else {
/*     */         
/*  76 */         setCloseDate((Date)new DtvDate());
/*  77 */         this._closeDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/*  79 */       str = tokens[3];
/*     */       
/*  81 */       if ("null".equals(str)) {
/*  82 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/*  85 */         setPropertyCode(str);
/*     */       }
/*     */     
/*  88 */     } catch (Exception ee) {
/*  89 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  95 */     if (this == ob) {
/*  96 */       return true;
/*     */     }
/*  98 */     if (!(ob instanceof CloseDatesPropertyId)) {
/*  99 */       return false;
/*     */     }
/* 101 */     CloseDatesPropertyId other = (CloseDatesPropertyId)ob;
/* 102 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 105 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 108 */       .equals(other._retailLocationId))) && ((this._closeDate == null && other._closeDate == null) || (this._closeDate != null && this._closeDate
/*     */ 
/*     */       
/* 111 */       .equals(other._closeDate))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 114 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 120 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 121 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 122 */       .hashCode()) + ((this._closeDate == null) ? 0 : this._closeDate
/* 123 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 124 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 129 */     return "CloseDatesProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 134 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 136 */     return buff.append(
/* 137 */         String.valueOf(this._organizationId))
/* 138 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 139 */       .append("::").append((this._closeDate == null) ? "null" : String.valueOf(this._closeDate.getTimeSerializable()))
/* 140 */       .append("::").append(this._propertyCode)
/* 141 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 145 */     if (this._retailLocationId == null) {
/* 146 */       return false;
/*     */     }
/* 148 */     if (this._closeDate == null) {
/* 149 */       return false;
/*     */     }
/* 151 */     if (this._propertyCode == null) {
/* 152 */       return false;
/*     */     }
/* 154 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\CloseDatesPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */