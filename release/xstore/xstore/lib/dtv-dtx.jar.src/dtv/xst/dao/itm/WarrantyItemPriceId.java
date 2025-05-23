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
/*     */ public class WarrantyItemPriceId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 231273530L;
/*     */   private String _itemId;
/*     */   private Long _warrantyPriceSeq;
/*     */   
/*     */   public WarrantyItemPriceId() {}
/*     */   
/*     */   public WarrantyItemPriceId(String argObjectIdValue) {
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
/*     */   public Long getWarrantyPriceSeq() {
/*  38 */     return this._warrantyPriceSeq;
/*     */   }
/*     */   
/*     */   public void setWarrantyPriceSeq(Long argWarrantyPriceSeq) {
/*  42 */     this._warrantyPriceSeq = argWarrantyPriceSeq;
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
/*  65 */       setWarrantyPriceSeq(Long.valueOf(str));
/*     */     }
/*  67 */     catch (Exception ee) {
/*  68 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  74 */     if (this == ob) {
/*  75 */       return true;
/*     */     }
/*  77 */     if (!(ob instanceof WarrantyItemPriceId)) {
/*  78 */       return false;
/*     */     }
/*  80 */     WarrantyItemPriceId other = (WarrantyItemPriceId)ob;
/*  81 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  84 */       .equals(other._organizationId))) && ((this._itemId == null && other._itemId == null) || (this._itemId != null && this._itemId
/*     */ 
/*     */       
/*  87 */       .equals(other._itemId))) && ((this._warrantyPriceSeq == null && other._warrantyPriceSeq == null) || (this._warrantyPriceSeq != null && this._warrantyPriceSeq
/*     */ 
/*     */       
/*  90 */       .equals(other._warrantyPriceSeq))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  96 */     return ((this._organizationId == null) ? 0 : this._organizationId
/*  97 */       .hashCode()) + ((this._itemId == null) ? 0 : this._itemId
/*  98 */       .hashCode()) + ((this._warrantyPriceSeq == null) ? 0 : this._warrantyPriceSeq
/*  99 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 104 */     return "WarrantyItemPrice";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 109 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 111 */     return buff.append(
/* 112 */         String.valueOf(this._organizationId))
/* 113 */       .append("::").append(this._itemId)
/* 114 */       .append("::").append(String.valueOf(this._warrantyPriceSeq))
/* 115 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 119 */     if (this._itemId == null) {
/* 120 */       return false;
/*     */     }
/* 122 */     if (this._warrantyPriceSeq == null) {
/* 123 */       return false;
/*     */     }
/* 125 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\WarrantyItemPriceId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */