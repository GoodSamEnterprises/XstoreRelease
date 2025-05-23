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
/*     */ public class DiscountCompatabilityId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -934656121L;
/*     */   private String _compatibleDiscountCode;
/*     */   private String _primaryDiscountCode;
/*     */   
/*     */   public DiscountCompatabilityId() {}
/*     */   
/*     */   public DiscountCompatabilityId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCompatibleDiscountCode() {
/*  30 */     return this._compatibleDiscountCode;
/*     */   }
/*     */   
/*     */   public void setCompatibleDiscountCode(String argCompatibleDiscountCode) {
/*  34 */     this._compatibleDiscountCode = (argCompatibleDiscountCode != null && MANAGE_CASE) ? argCompatibleDiscountCode.toUpperCase() : argCompatibleDiscountCode;
/*     */   }
/*     */   
/*     */   public String getPrimaryDiscountCode() {
/*  38 */     return this._primaryDiscountCode;
/*     */   }
/*     */   
/*     */   public void setPrimaryDiscountCode(String argPrimaryDiscountCode) {
/*  42 */     this._primaryDiscountCode = (argPrimaryDiscountCode != null && MANAGE_CASE) ? argPrimaryDiscountCode.toUpperCase() : argPrimaryDiscountCode;
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
/*  55 */         setCompatibleDiscountCode((String)null);
/*     */       } else {
/*     */         
/*  58 */         setCompatibleDiscountCode(str);
/*     */       } 
/*  60 */       str = tokens[1];
/*     */       
/*  62 */       setOrganizationId(Long.valueOf(str));
/*  63 */       str = tokens[2];
/*     */       
/*  65 */       if ("null".equals(str)) {
/*  66 */         setPrimaryDiscountCode((String)null);
/*     */       } else {
/*     */         
/*  69 */         setPrimaryDiscountCode(str);
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
/*  82 */     if (!(ob instanceof DiscountCompatabilityId)) {
/*  83 */       return false;
/*     */     }
/*  85 */     DiscountCompatabilityId other = (DiscountCompatabilityId)ob;
/*  86 */     return (((this._compatibleDiscountCode == null && other._compatibleDiscountCode == null) || (this._compatibleDiscountCode != null && this._compatibleDiscountCode
/*     */ 
/*     */       
/*  89 */       .equals(other._compatibleDiscountCode))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  92 */       .equals(other._organizationId))) && ((this._primaryDiscountCode == null && other._primaryDiscountCode == null) || (this._primaryDiscountCode != null && this._primaryDiscountCode
/*     */ 
/*     */       
/*  95 */       .equals(other._primaryDiscountCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 101 */     return ((this._compatibleDiscountCode == null) ? 0 : this._compatibleDiscountCode
/* 102 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 103 */       .hashCode()) + ((this._primaryDiscountCode == null) ? 0 : this._primaryDiscountCode
/* 104 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 109 */     return "DiscountCompatability";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 114 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 116 */     return buff.append(this._compatibleDiscountCode)
/*     */       
/* 118 */       .append("::").append(String.valueOf(this._organizationId))
/* 119 */       .append("::").append(this._primaryDiscountCode)
/* 120 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 124 */     if (this._compatibleDiscountCode == null) {
/* 125 */       return false;
/*     */     }
/* 127 */     if (this._primaryDiscountCode == null) {
/* 128 */       return false;
/*     */     }
/* 130 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\dsc\DiscountCompatabilityId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */