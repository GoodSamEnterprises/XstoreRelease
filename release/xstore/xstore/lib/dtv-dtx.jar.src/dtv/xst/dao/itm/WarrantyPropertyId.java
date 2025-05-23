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
/*     */ public class WarrantyPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -223425775L;
/*     */   private String _warrantyNbr;
/*     */   private String _warrantyTypeCode;
/*     */   private String _propertyCode;
/*     */   
/*     */   public WarrantyPropertyId() {}
/*     */   
/*     */   public WarrantyPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWarrantyNbr() {
/*  31 */     return this._warrantyNbr;
/*     */   }
/*     */   
/*     */   public void setWarrantyNbr(String argWarrantyNbr) {
/*  35 */     this._warrantyNbr = (argWarrantyNbr != null && MANAGE_CASE) ? argWarrantyNbr.toUpperCase() : argWarrantyNbr;
/*     */   }
/*     */   
/*     */   public String getWarrantyTypeCode() {
/*  39 */     return this._warrantyTypeCode;
/*     */   }
/*     */   
/*     */   public void setWarrantyTypeCode(String argWarrantyTypeCode) {
/*  43 */     this._warrantyTypeCode = (argWarrantyTypeCode != null && MANAGE_CASE) ? argWarrantyTypeCode.toUpperCase() : argWarrantyTypeCode;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  47 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  51 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  55 */     String str = argObjectIdValue;
/*  56 */     if (StringUtils.isEmpty(str)) {
/*  57 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  60 */       String[] tokens = str.split("::");
/*  61 */       str = tokens[0];
/*     */       
/*  63 */       setOrganizationId(Long.valueOf(str));
/*  64 */       str = tokens[1];
/*     */       
/*  66 */       if ("null".equals(str)) {
/*  67 */         setWarrantyNbr((String)null);
/*     */       } else {
/*     */         
/*  70 */         setWarrantyNbr(str);
/*     */       } 
/*  72 */       str = tokens[2];
/*     */       
/*  74 */       if ("null".equals(str)) {
/*  75 */         setWarrantyTypeCode((String)null);
/*     */       } else {
/*     */         
/*  78 */         setWarrantyTypeCode(str);
/*     */       } 
/*  80 */       str = tokens[3];
/*     */       
/*  82 */       if ("null".equals(str)) {
/*  83 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/*  86 */         setPropertyCode(str);
/*     */       }
/*     */     
/*  89 */     } catch (Exception ee) {
/*  90 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  96 */     if (this == ob) {
/*  97 */       return true;
/*     */     }
/*  99 */     if (!(ob instanceof WarrantyPropertyId)) {
/* 100 */       return false;
/*     */     }
/* 102 */     WarrantyPropertyId other = (WarrantyPropertyId)ob;
/* 103 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 106 */       .equals(other._organizationId))) && ((this._warrantyNbr == null && other._warrantyNbr == null) || (this._warrantyNbr != null && this._warrantyNbr
/*     */ 
/*     */       
/* 109 */       .equals(other._warrantyNbr))) && ((this._warrantyTypeCode == null && other._warrantyTypeCode == null) || (this._warrantyTypeCode != null && this._warrantyTypeCode
/*     */ 
/*     */       
/* 112 */       .equals(other._warrantyTypeCode))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 115 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 122 */       .hashCode()) + ((this._warrantyNbr == null) ? 0 : this._warrantyNbr
/* 123 */       .hashCode()) + ((this._warrantyTypeCode == null) ? 0 : this._warrantyTypeCode
/* 124 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 125 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 130 */     return "WarrantyProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 135 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 137 */     return buff.append(
/* 138 */         String.valueOf(this._organizationId))
/* 139 */       .append("::").append(this._warrantyNbr)
/* 140 */       .append("::").append(this._warrantyTypeCode)
/* 141 */       .append("::").append(this._propertyCode)
/* 142 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 146 */     if (this._warrantyNbr == null) {
/* 147 */       return false;
/*     */     }
/* 149 */     if (this._warrantyTypeCode == null) {
/* 150 */       return false;
/*     */     }
/* 152 */     if (this._propertyCode == null) {
/* 153 */       return false;
/*     */     }
/* 155 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\WarrantyPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */