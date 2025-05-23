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
/*     */ public class ItemDimensionTypePropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 977190466L;
/*     */   private String _dimensionSystem;
/*     */   private String _dimension;
/*     */   private String _propertyCode;
/*     */   
/*     */   public ItemDimensionTypePropertyId() {}
/*     */   
/*     */   public ItemDimensionTypePropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDimensionSystem() {
/*  31 */     return this._dimensionSystem;
/*     */   }
/*     */   
/*     */   public void setDimensionSystem(String argDimensionSystem) {
/*  35 */     this._dimensionSystem = (argDimensionSystem != null && MANAGE_CASE) ? argDimensionSystem.toUpperCase() : argDimensionSystem;
/*     */   }
/*     */   
/*     */   public String getDimension() {
/*  39 */     return this._dimension;
/*     */   }
/*     */   
/*     */   public void setDimension(String argDimension) {
/*  43 */     this._dimension = (argDimension != null && MANAGE_CASE) ? argDimension.toUpperCase() : argDimension;
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
/*  67 */         setDimensionSystem((String)null);
/*     */       } else {
/*     */         
/*  70 */         setDimensionSystem(str);
/*     */       } 
/*  72 */       str = tokens[2];
/*     */       
/*  74 */       if ("null".equals(str)) {
/*  75 */         setDimension((String)null);
/*     */       } else {
/*     */         
/*  78 */         setDimension(str);
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
/*  99 */     if (!(ob instanceof ItemDimensionTypePropertyId)) {
/* 100 */       return false;
/*     */     }
/* 102 */     ItemDimensionTypePropertyId other = (ItemDimensionTypePropertyId)ob;
/* 103 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 106 */       .equals(other._organizationId))) && ((this._dimensionSystem == null && other._dimensionSystem == null) || (this._dimensionSystem != null && this._dimensionSystem
/*     */ 
/*     */       
/* 109 */       .equals(other._dimensionSystem))) && ((this._dimension == null && other._dimension == null) || (this._dimension != null && this._dimension
/*     */ 
/*     */       
/* 112 */       .equals(other._dimension))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 115 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 122 */       .hashCode()) + ((this._dimensionSystem == null) ? 0 : this._dimensionSystem
/* 123 */       .hashCode()) + ((this._dimension == null) ? 0 : this._dimension
/* 124 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 125 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 130 */     return "ItemDimensionTypeProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 135 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 137 */     return buff.append(
/* 138 */         String.valueOf(this._organizationId))
/* 139 */       .append("::").append(this._dimensionSystem)
/* 140 */       .append("::").append(this._dimension)
/* 141 */       .append("::").append(this._propertyCode)
/* 142 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 146 */     if (this._dimensionSystem == null) {
/* 147 */       return false;
/*     */     }
/* 149 */     if (this._dimension == null) {
/* 150 */       return false;
/*     */     }
/* 152 */     if (this._propertyCode == null) {
/* 153 */       return false;
/*     */     }
/* 155 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\ItemDimensionTypePropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */