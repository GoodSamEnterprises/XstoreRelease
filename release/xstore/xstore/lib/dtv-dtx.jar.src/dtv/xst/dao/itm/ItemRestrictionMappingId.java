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
/*     */ public class ItemRestrictionMappingId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1762616309L;
/*     */   private String _merchHierarchyLevel;
/*     */   private String _merchHierarchyId;
/*     */   private String _restrictionCategory;
/*     */   
/*     */   public ItemRestrictionMappingId() {}
/*     */   
/*     */   public ItemRestrictionMappingId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMerchHierarchyLevel() {
/*  31 */     return this._merchHierarchyLevel;
/*     */   }
/*     */   
/*     */   public void setMerchHierarchyLevel(String argMerchHierarchyLevel) {
/*  35 */     this._merchHierarchyLevel = (argMerchHierarchyLevel != null && MANAGE_CASE) ? argMerchHierarchyLevel.toUpperCase() : argMerchHierarchyLevel;
/*     */   }
/*     */   
/*     */   public String getMerchHierarchyId() {
/*  39 */     return this._merchHierarchyId;
/*     */   }
/*     */   
/*     */   public void setMerchHierarchyId(String argMerchHierarchyId) {
/*  43 */     this._merchHierarchyId = (argMerchHierarchyId != null && MANAGE_CASE) ? argMerchHierarchyId.toUpperCase() : argMerchHierarchyId;
/*     */   }
/*     */   
/*     */   public String getRestrictionCategory() {
/*  47 */     return this._restrictionCategory;
/*     */   }
/*     */   
/*     */   public void setRestrictionCategory(String argRestrictionCategory) {
/*  51 */     this._restrictionCategory = (argRestrictionCategory != null && MANAGE_CASE) ? argRestrictionCategory.toUpperCase() : argRestrictionCategory;
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
/*  67 */         setMerchHierarchyLevel((String)null);
/*     */       } else {
/*     */         
/*  70 */         setMerchHierarchyLevel(str);
/*     */       } 
/*  72 */       str = tokens[2];
/*     */       
/*  74 */       if ("null".equals(str)) {
/*  75 */         setMerchHierarchyId((String)null);
/*     */       } else {
/*     */         
/*  78 */         setMerchHierarchyId(str);
/*     */       } 
/*  80 */       str = tokens[3];
/*     */       
/*  82 */       if ("null".equals(str)) {
/*  83 */         setRestrictionCategory((String)null);
/*     */       } else {
/*     */         
/*  86 */         setRestrictionCategory(str);
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
/*  99 */     if (!(ob instanceof ItemRestrictionMappingId)) {
/* 100 */       return false;
/*     */     }
/* 102 */     ItemRestrictionMappingId other = (ItemRestrictionMappingId)ob;
/* 103 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 106 */       .equals(other._organizationId))) && ((this._merchHierarchyLevel == null && other._merchHierarchyLevel == null) || (this._merchHierarchyLevel != null && this._merchHierarchyLevel
/*     */ 
/*     */       
/* 109 */       .equals(other._merchHierarchyLevel))) && ((this._merchHierarchyId == null && other._merchHierarchyId == null) || (this._merchHierarchyId != null && this._merchHierarchyId
/*     */ 
/*     */       
/* 112 */       .equals(other._merchHierarchyId))) && ((this._restrictionCategory == null && other._restrictionCategory == null) || (this._restrictionCategory != null && this._restrictionCategory
/*     */ 
/*     */       
/* 115 */       .equals(other._restrictionCategory))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 122 */       .hashCode()) + ((this._merchHierarchyLevel == null) ? 0 : this._merchHierarchyLevel
/* 123 */       .hashCode()) + ((this._merchHierarchyId == null) ? 0 : this._merchHierarchyId
/* 124 */       .hashCode()) + ((this._restrictionCategory == null) ? 0 : this._restrictionCategory
/* 125 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 130 */     return "ItemRestrictionMapping";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 135 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 137 */     return buff.append(
/* 138 */         String.valueOf(this._organizationId))
/* 139 */       .append("::").append(this._merchHierarchyLevel)
/* 140 */       .append("::").append(this._merchHierarchyId)
/* 141 */       .append("::").append(this._restrictionCategory)
/* 142 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 146 */     if (this._merchHierarchyLevel == null) {
/* 147 */       return false;
/*     */     }
/* 149 */     if (this._merchHierarchyId == null) {
/* 150 */       return false;
/*     */     }
/* 152 */     if (this._restrictionCategory == null) {
/* 153 */       return false;
/*     */     }
/* 155 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\ItemRestrictionMappingId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */