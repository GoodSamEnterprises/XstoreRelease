/*     */ package dtv.xst.dao.com;
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
/*     */ public class CountryReturnMapId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 926734134L;
/*     */   private String _purchasedFrom;
/*     */   private String _returnTo;
/*     */   
/*     */   public CountryReturnMapId() {}
/*     */   
/*     */   public CountryReturnMapId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPurchasedFrom() {
/*  30 */     return this._purchasedFrom;
/*     */   }
/*     */   
/*     */   public void setPurchasedFrom(String argPurchasedFrom) {
/*  34 */     this._purchasedFrom = (argPurchasedFrom != null && MANAGE_CASE) ? argPurchasedFrom.toUpperCase() : argPurchasedFrom;
/*     */   }
/*     */   
/*     */   public String getReturnTo() {
/*  38 */     return this._returnTo;
/*     */   }
/*     */   
/*     */   public void setReturnTo(String argReturnTo) {
/*  42 */     this._returnTo = (argReturnTo != null && MANAGE_CASE) ? argReturnTo.toUpperCase() : argReturnTo;
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
/*  58 */         setPurchasedFrom((String)null);
/*     */       } else {
/*     */         
/*  61 */         setPurchasedFrom(str);
/*     */       } 
/*  63 */       str = tokens[2];
/*     */       
/*  65 */       if ("null".equals(str)) {
/*  66 */         setReturnTo((String)null);
/*     */       } else {
/*     */         
/*  69 */         setReturnTo(str);
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
/*  82 */     if (!(ob instanceof CountryReturnMapId)) {
/*  83 */       return false;
/*     */     }
/*  85 */     CountryReturnMapId other = (CountryReturnMapId)ob;
/*  86 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  89 */       .equals(other._organizationId))) && ((this._purchasedFrom == null && other._purchasedFrom == null) || (this._purchasedFrom != null && this._purchasedFrom
/*     */ 
/*     */       
/*  92 */       .equals(other._purchasedFrom))) && ((this._returnTo == null && other._returnTo == null) || (this._returnTo != null && this._returnTo
/*     */ 
/*     */       
/*  95 */       .equals(other._returnTo))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 101 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 102 */       .hashCode()) + ((this._purchasedFrom == null) ? 0 : this._purchasedFrom
/* 103 */       .hashCode()) + ((this._returnTo == null) ? 0 : this._returnTo
/* 104 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 109 */     return "CountryReturnMap";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 114 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 116 */     return buff.append(
/* 117 */         String.valueOf(this._organizationId))
/* 118 */       .append("::").append(this._purchasedFrom)
/* 119 */       .append("::").append(this._returnTo)
/* 120 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 124 */     if (this._purchasedFrom == null) {
/* 125 */       return false;
/*     */     }
/* 127 */     if (this._returnTo == null) {
/* 128 */       return false;
/*     */     }
/* 130 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\CountryReturnMapId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */