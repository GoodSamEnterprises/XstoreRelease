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
/*     */ public class ItemDimensionValueId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1859499586L;
/*     */   private String _dimensionSystem;
/*     */   private String _dimension;
/*     */   private String _dimensionValue;
/*     */   
/*     */   public ItemDimensionValueId() {}
/*     */   
/*     */   public ItemDimensionValueId(String argObjectIdValue) {
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
/*     */   public String getDimensionValue() {
/*  47 */     return this._dimensionValue;
/*     */   }
/*     */   
/*     */   public void setDimensionValue(String argDimensionValue) {
/*  51 */     this._dimensionValue = (argDimensionValue != null && MANAGE_CASE) ? argDimensionValue.toUpperCase() : argDimensionValue;
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
/*  83 */         setDimensionValue((String)null);
/*     */       } else {
/*     */         
/*  86 */         setDimensionValue(str);
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
/*  99 */     if (!(ob instanceof ItemDimensionValueId)) {
/* 100 */       return false;
/*     */     }
/* 102 */     ItemDimensionValueId other = (ItemDimensionValueId)ob;
/* 103 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 106 */       .equals(other._organizationId))) && ((this._dimensionSystem == null && other._dimensionSystem == null) || (this._dimensionSystem != null && this._dimensionSystem
/*     */ 
/*     */       
/* 109 */       .equals(other._dimensionSystem))) && ((this._dimension == null && other._dimension == null) || (this._dimension != null && this._dimension
/*     */ 
/*     */       
/* 112 */       .equals(other._dimension))) && ((this._dimensionValue == null && other._dimensionValue == null) || (this._dimensionValue != null && this._dimensionValue
/*     */ 
/*     */       
/* 115 */       .equals(other._dimensionValue))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 122 */       .hashCode()) + ((this._dimensionSystem == null) ? 0 : this._dimensionSystem
/* 123 */       .hashCode()) + ((this._dimension == null) ? 0 : this._dimension
/* 124 */       .hashCode()) + ((this._dimensionValue == null) ? 0 : this._dimensionValue
/* 125 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 130 */     return "ItemDimensionValue";
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
/* 141 */       .append("::").append(this._dimensionValue)
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
/* 152 */     if (this._dimensionValue == null) {
/* 153 */       return false;
/*     */     }
/* 155 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\ItemDimensionValueId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */