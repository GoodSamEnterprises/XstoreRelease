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
/*     */ public class ItemDimensionValuePropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 507768243L;
/*     */   private String _dimensionSystem;
/*     */   private String _dimension;
/*     */   private String _dimensionValue;
/*     */   private String _propertyCode;
/*     */   
/*     */   public ItemDimensionValuePropertyId() {}
/*     */   
/*     */   public ItemDimensionValuePropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDimensionSystem() {
/*  32 */     return this._dimensionSystem;
/*     */   }
/*     */   
/*     */   public void setDimensionSystem(String argDimensionSystem) {
/*  36 */     this._dimensionSystem = (argDimensionSystem != null && MANAGE_CASE) ? argDimensionSystem.toUpperCase() : argDimensionSystem;
/*     */   }
/*     */   
/*     */   public String getDimension() {
/*  40 */     return this._dimension;
/*     */   }
/*     */   
/*     */   public void setDimension(String argDimension) {
/*  44 */     this._dimension = (argDimension != null && MANAGE_CASE) ? argDimension.toUpperCase() : argDimension;
/*     */   }
/*     */   
/*     */   public String getDimensionValue() {
/*  48 */     return this._dimensionValue;
/*     */   }
/*     */   
/*     */   public void setDimensionValue(String argDimensionValue) {
/*  52 */     this._dimensionValue = (argDimensionValue != null && MANAGE_CASE) ? argDimensionValue.toUpperCase() : argDimensionValue;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  56 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  60 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  64 */     String str = argObjectIdValue;
/*  65 */     if (StringUtils.isEmpty(str)) {
/*  66 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  69 */       String[] tokens = str.split("::");
/*  70 */       str = tokens[0];
/*     */       
/*  72 */       setOrganizationId(Long.valueOf(str));
/*  73 */       str = tokens[1];
/*     */       
/*  75 */       if ("null".equals(str)) {
/*  76 */         setDimensionSystem((String)null);
/*     */       } else {
/*     */         
/*  79 */         setDimensionSystem(str);
/*     */       } 
/*  81 */       str = tokens[2];
/*     */       
/*  83 */       if ("null".equals(str)) {
/*  84 */         setDimension((String)null);
/*     */       } else {
/*     */         
/*  87 */         setDimension(str);
/*     */       } 
/*  89 */       str = tokens[3];
/*     */       
/*  91 */       if ("null".equals(str)) {
/*  92 */         setDimensionValue((String)null);
/*     */       } else {
/*     */         
/*  95 */         setDimensionValue(str);
/*     */       } 
/*  97 */       str = tokens[4];
/*     */       
/*  99 */       if ("null".equals(str)) {
/* 100 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 103 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 106 */     } catch (Exception ee) {
/* 107 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 113 */     if (this == ob) {
/* 114 */       return true;
/*     */     }
/* 116 */     if (!(ob instanceof ItemDimensionValuePropertyId)) {
/* 117 */       return false;
/*     */     }
/* 119 */     ItemDimensionValuePropertyId other = (ItemDimensionValuePropertyId)ob;
/* 120 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 123 */       .equals(other._organizationId))) && ((this._dimensionSystem == null && other._dimensionSystem == null) || (this._dimensionSystem != null && this._dimensionSystem
/*     */ 
/*     */       
/* 126 */       .equals(other._dimensionSystem))) && ((this._dimension == null && other._dimension == null) || (this._dimension != null && this._dimension
/*     */ 
/*     */       
/* 129 */       .equals(other._dimension))) && ((this._dimensionValue == null && other._dimensionValue == null) || (this._dimensionValue != null && this._dimensionValue
/*     */ 
/*     */       
/* 132 */       .equals(other._dimensionValue))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 135 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 141 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 142 */       .hashCode()) + ((this._dimensionSystem == null) ? 0 : this._dimensionSystem
/* 143 */       .hashCode()) + ((this._dimension == null) ? 0 : this._dimension
/* 144 */       .hashCode()) + ((this._dimensionValue == null) ? 0 : this._dimensionValue
/* 145 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 146 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 151 */     return "ItemDimensionValueProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 156 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 158 */     return buff.append(
/* 159 */         String.valueOf(this._organizationId))
/* 160 */       .append("::").append(this._dimensionSystem)
/* 161 */       .append("::").append(this._dimension)
/* 162 */       .append("::").append(this._dimensionValue)
/* 163 */       .append("::").append(this._propertyCode)
/* 164 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 168 */     if (this._dimensionSystem == null) {
/* 169 */       return false;
/*     */     }
/* 171 */     if (this._dimension == null) {
/* 172 */       return false;
/*     */     }
/* 174 */     if (this._dimensionValue == null) {
/* 175 */       return false;
/*     */     }
/* 177 */     if (this._propertyCode == null) {
/* 178 */       return false;
/*     */     }
/* 180 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\ItemDimensionValuePropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */