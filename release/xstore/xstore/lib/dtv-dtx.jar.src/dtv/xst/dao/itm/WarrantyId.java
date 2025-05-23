/*     */ package dtv.xst.dao.itm;
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
/*     */ public class WarrantyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 566191388L;
/*     */   private String _warrantyNbr;
/*     */   private String _warrantyTypeCode;
/*     */   
/*     */   public WarrantyId() {}
/*     */   
/*     */   public WarrantyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWarrantyNbr() {
/*  30 */     return this._warrantyNbr;
/*     */   }
/*     */   
/*     */   public void setWarrantyNbr(String argWarrantyNbr) {
/*  34 */     this._warrantyNbr = (argWarrantyNbr != null && MANAGE_CASE) ? argWarrantyNbr.toUpperCase() : argWarrantyNbr;
/*     */   }
/*     */   
/*     */   public String getWarrantyTypeCode() {
/*  38 */     return this._warrantyTypeCode;
/*     */   }
/*     */   
/*     */   public void setWarrantyTypeCode(String argWarrantyTypeCode) {
/*  42 */     this._warrantyTypeCode = (argWarrantyTypeCode != null && MANAGE_CASE) ? argWarrantyTypeCode.toUpperCase() : argWarrantyTypeCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  46 */     String str = argObjectIdValue;
/*  47 */     if (StringUtils.isEmpty(str)) {
/*  48 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  51 */       String[] tokens = str.split("::");
/*  52 */       str = tokens[0];
/*     */       
/*  54 */       setOrganizationId(Long.valueOf(str));
/*  55 */       str = tokens[1];
/*     */       
/*  57 */       if ("null".equals(str)) {
/*  58 */         setWarrantyNbr((String)null);
/*     */       } else {
/*     */         
/*  61 */         setWarrantyNbr(str);
/*     */       } 
/*  63 */       str = tokens[2];
/*     */       
/*  65 */       if ("null".equals(str)) {
/*  66 */         setWarrantyTypeCode((String)null);
/*     */       } else {
/*     */         
/*  69 */         setWarrantyTypeCode(str);
/*     */       }
/*     */     
/*  72 */     } catch (Exception ee) {
/*  73 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  79 */     if (this == ob) {
/*  80 */       return true;
/*     */     }
/*  82 */     if (!(ob instanceof WarrantyId)) {
/*  83 */       return false;
/*     */     }
/*  85 */     WarrantyId other = (WarrantyId)ob;
/*  86 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  89 */       .equals(other._organizationId))) && ((this._warrantyNbr == null && other._warrantyNbr == null) || (this._warrantyNbr != null && this._warrantyNbr
/*     */ 
/*     */       
/*  92 */       .equals(other._warrantyNbr))) && ((this._warrantyTypeCode == null && other._warrantyTypeCode == null) || (this._warrantyTypeCode != null && this._warrantyTypeCode
/*     */ 
/*     */       
/*  95 */       .equals(other._warrantyTypeCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 101 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 102 */       .hashCode()) + ((this._warrantyNbr == null) ? 0 : this._warrantyNbr
/* 103 */       .hashCode()) + ((this._warrantyTypeCode == null) ? 0 : this._warrantyTypeCode
/* 104 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 109 */     return "Warranty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 114 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 116 */     return buff.append(
/* 117 */         String.valueOf(this._organizationId))
/* 118 */       .append("::").append(this._warrantyNbr)
/* 119 */       .append("::").append(this._warrantyTypeCode)
/* 120 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 124 */     if (this._warrantyNbr == null) {
/* 125 */       return false;
/*     */     }
/* 127 */     if (this._warrantyTypeCode == null) {
/* 128 */       return false;
/*     */     }
/* 130 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\WarrantyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */