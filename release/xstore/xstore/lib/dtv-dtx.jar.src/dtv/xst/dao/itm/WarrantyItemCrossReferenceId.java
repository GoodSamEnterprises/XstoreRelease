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
/*     */ public class WarrantyItemCrossReferenceId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -332362982L;
/*     */   private String _itemId;
/*     */   private String _warrantyItemId;
/*     */   
/*     */   public WarrantyItemCrossReferenceId() {}
/*     */   
/*     */   public WarrantyItemCrossReferenceId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemId() {
/*  30 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/*  34 */     this._itemId = (argItemId != null && MANAGE_CASE) ? argItemId.toUpperCase() : argItemId;
/*     */   }
/*     */   
/*     */   public String getWarrantyItemId() {
/*  38 */     return this._warrantyItemId;
/*     */   }
/*     */   
/*     */   public void setWarrantyItemId(String argWarrantyItemId) {
/*  42 */     this._warrantyItemId = (argWarrantyItemId != null && MANAGE_CASE) ? argWarrantyItemId.toUpperCase() : argWarrantyItemId;
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
/*  58 */         setItemId((String)null);
/*     */       } else {
/*     */         
/*  61 */         setItemId(str);
/*     */       } 
/*  63 */       str = tokens[2];
/*     */       
/*  65 */       if ("null".equals(str)) {
/*  66 */         setWarrantyItemId((String)null);
/*     */       } else {
/*     */         
/*  69 */         setWarrantyItemId(str);
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
/*  82 */     if (!(ob instanceof WarrantyItemCrossReferenceId)) {
/*  83 */       return false;
/*     */     }
/*  85 */     WarrantyItemCrossReferenceId other = (WarrantyItemCrossReferenceId)ob;
/*  86 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  89 */       .equals(other._organizationId))) && ((this._itemId == null && other._itemId == null) || (this._itemId != null && this._itemId
/*     */ 
/*     */       
/*  92 */       .equals(other._itemId))) && ((this._warrantyItemId == null && other._warrantyItemId == null) || (this._warrantyItemId != null && this._warrantyItemId
/*     */ 
/*     */       
/*  95 */       .equals(other._warrantyItemId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 101 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 102 */       .hashCode()) + ((this._itemId == null) ? 0 : this._itemId
/* 103 */       .hashCode()) + ((this._warrantyItemId == null) ? 0 : this._warrantyItemId
/* 104 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 109 */     return "WarrantyItemCrossReference";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 114 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 116 */     return buff.append(
/* 117 */         String.valueOf(this._organizationId))
/* 118 */       .append("::").append(this._itemId)
/* 119 */       .append("::").append(this._warrantyItemId)
/* 120 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 124 */     if (this._itemId == null) {
/* 125 */       return false;
/*     */     }
/* 127 */     if (this._warrantyItemId == null) {
/* 128 */       return false;
/*     */     }
/* 130 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\WarrantyItemCrossReferenceId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */