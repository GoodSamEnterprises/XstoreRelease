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
/*     */ public class ItemDimensionTypeId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -198567603L;
/*     */   private String _dimensionSystem;
/*     */   private String _dimension;
/*     */   
/*     */   public ItemDimensionTypeId() {}
/*     */   
/*     */   public ItemDimensionTypeId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDimensionSystem() {
/*  30 */     return this._dimensionSystem;
/*     */   }
/*     */   
/*     */   public void setDimensionSystem(String argDimensionSystem) {
/*  34 */     this._dimensionSystem = (argDimensionSystem != null && MANAGE_CASE) ? argDimensionSystem.toUpperCase() : argDimensionSystem;
/*     */   }
/*     */   
/*     */   public String getDimension() {
/*  38 */     return this._dimension;
/*     */   }
/*     */   
/*     */   public void setDimension(String argDimension) {
/*  42 */     this._dimension = (argDimension != null && MANAGE_CASE) ? argDimension.toUpperCase() : argDimension;
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
/*  58 */         setDimensionSystem((String)null);
/*     */       } else {
/*     */         
/*  61 */         setDimensionSystem(str);
/*     */       } 
/*  63 */       str = tokens[2];
/*     */       
/*  65 */       if ("null".equals(str)) {
/*  66 */         setDimension((String)null);
/*     */       } else {
/*     */         
/*  69 */         setDimension(str);
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
/*  82 */     if (!(ob instanceof ItemDimensionTypeId)) {
/*  83 */       return false;
/*     */     }
/*  85 */     ItemDimensionTypeId other = (ItemDimensionTypeId)ob;
/*  86 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  89 */       .equals(other._organizationId))) && ((this._dimensionSystem == null && other._dimensionSystem == null) || (this._dimensionSystem != null && this._dimensionSystem
/*     */ 
/*     */       
/*  92 */       .equals(other._dimensionSystem))) && ((this._dimension == null && other._dimension == null) || (this._dimension != null && this._dimension
/*     */ 
/*     */       
/*  95 */       .equals(other._dimension))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 101 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 102 */       .hashCode()) + ((this._dimensionSystem == null) ? 0 : this._dimensionSystem
/* 103 */       .hashCode()) + ((this._dimension == null) ? 0 : this._dimension
/* 104 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 109 */     return "ItemDimensionType";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 114 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 116 */     return buff.append(
/* 117 */         String.valueOf(this._organizationId))
/* 118 */       .append("::").append(this._dimensionSystem)
/* 119 */       .append("::").append(this._dimension)
/* 120 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 124 */     if (this._dimensionSystem == null) {
/* 125 */       return false;
/*     */     }
/* 127 */     if (this._dimension == null) {
/* 128 */       return false;
/*     */     }
/* 130 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\ItemDimensionTypeId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */