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
/*     */ 
/*     */ public class CloseDatesId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -93581427L;
/*     */   private Long _retailLocationId;
/*     */   private DtvDate _closeDate;
/*     */   
/*     */   public CloseDatesId() {}
/*     */   
/*     */   public CloseDatesId(String argObjectIdValue) {
/*  25 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getRetailLocationId() {
/*  32 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  36 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public Date getCloseDate() {
/*  40 */     return (Date)this._closeDate;
/*     */   }
/*     */   
/*     */   public void setCloseDate(Date argCloseDate) {
/*  44 */     this._closeDate = (argCloseDate == null || argCloseDate instanceof DtvDate) ? (DtvDate)argCloseDate : new DtvDate(argCloseDate);
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
/*  60 */       setRetailLocationId(Long.valueOf(str));
/*  61 */       str = tokens[2];
/*     */       
/*  63 */       if ("null".equals(str)) {
/*  64 */         setCloseDate((Date)null);
/*     */       } else {
/*     */         
/*  67 */         setCloseDate((Date)new DtvDate());
/*  68 */         this._closeDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       }
/*     */     
/*  71 */     } catch (Exception ee) {
/*  72 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  78 */     if (this == ob) {
/*  79 */       return true;
/*     */     }
/*  81 */     if (!(ob instanceof CloseDatesId)) {
/*  82 */       return false;
/*     */     }
/*  84 */     CloseDatesId other = (CloseDatesId)ob;
/*  85 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  88 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/*  91 */       .equals(other._retailLocationId))) && ((this._closeDate == null && other._closeDate == null) || (this._closeDate != null && this._closeDate
/*     */ 
/*     */       
/*  94 */       .equals(other._closeDate))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 100 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 101 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 102 */       .hashCode()) + ((this._closeDate == null) ? 0 : this._closeDate
/* 103 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 108 */     return "CloseDates";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 113 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 115 */     return buff.append(
/* 116 */         String.valueOf(this._organizationId))
/* 117 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 118 */       .append("::").append((this._closeDate == null) ? "null" : String.valueOf(this._closeDate.getTimeSerializable()))
/* 119 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 123 */     if (this._retailLocationId == null) {
/* 124 */       return false;
/*     */     }
/* 126 */     if (this._closeDate == null) {
/* 127 */       return false;
/*     */     }
/* 129 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\CloseDatesId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */