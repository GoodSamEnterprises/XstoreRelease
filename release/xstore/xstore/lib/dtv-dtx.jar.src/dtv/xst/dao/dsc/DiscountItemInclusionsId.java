/*     */ package dtv.xst.dao.dsc;
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
/*     */ public class DiscountItemInclusionsId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -844796405L;
/*     */   private String _discountCode;
/*     */   private String _itemId;
/*     */   
/*     */   public DiscountItemInclusionsId() {}
/*     */   
/*     */   public DiscountItemInclusionsId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDiscountCode() {
/*  30 */     return this._discountCode;
/*     */   }
/*     */   
/*     */   public void setDiscountCode(String argDiscountCode) {
/*  34 */     this._discountCode = (argDiscountCode != null && MANAGE_CASE) ? argDiscountCode.toUpperCase() : argDiscountCode;
/*     */   }
/*     */   
/*     */   public String getItemId() {
/*  38 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/*  42 */     this._itemId = (argItemId != null && MANAGE_CASE) ? argItemId.toUpperCase() : argItemId;
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
/*  54 */       if ("null".equals(str)) {
/*  55 */         setDiscountCode((String)null);
/*     */       } else {
/*     */         
/*  58 */         setDiscountCode(str);
/*     */       } 
/*  60 */       str = tokens[1];
/*     */       
/*  62 */       if ("null".equals(str)) {
/*  63 */         setItemId((String)null);
/*     */       } else {
/*     */         
/*  66 */         setItemId(str);
/*     */       } 
/*  68 */       str = tokens[2];
/*     */       
/*  70 */       setOrganizationId(Long.valueOf(str));
/*     */     }
/*  72 */     catch (Exception ee) {
/*  73 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  79 */     if (this == ob) {
/*  80 */       return true;
/*     */     }
/*  82 */     if (!(ob instanceof DiscountItemInclusionsId)) {
/*  83 */       return false;
/*     */     }
/*  85 */     DiscountItemInclusionsId other = (DiscountItemInclusionsId)ob;
/*  86 */     return (((this._discountCode == null && other._discountCode == null) || (this._discountCode != null && this._discountCode
/*     */ 
/*     */       
/*  89 */       .equals(other._discountCode))) && ((this._itemId == null && other._itemId == null) || (this._itemId != null && this._itemId
/*     */ 
/*     */       
/*  92 */       .equals(other._itemId))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  95 */       .equals(other._organizationId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 101 */     return ((this._discountCode == null) ? 0 : this._discountCode
/* 102 */       .hashCode()) + ((this._itemId == null) ? 0 : this._itemId
/* 103 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 104 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 109 */     return "DiscountItemInclusions";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 114 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 116 */     return buff.append(this._discountCode)
/*     */       
/* 118 */       .append("::").append(this._itemId)
/* 119 */       .append("::").append(String.valueOf(this._organizationId))
/* 120 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 124 */     if (this._discountCode == null) {
/* 125 */       return false;
/*     */     }
/* 127 */     if (this._itemId == null) {
/* 128 */       return false;
/*     */     }
/* 130 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\dsc\DiscountItemInclusionsId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */