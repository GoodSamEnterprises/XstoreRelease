/*     */ package dtv.xst.dao.tax;
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
/*     */ public class TaxBracketId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1929214621L;
/*     */   private String _taxBracketId;
/*     */   private Integer _taxBracketSequence;
/*     */   
/*     */   public TaxBracketId() {}
/*     */   
/*     */   public TaxBracketId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTaxBracketId() {
/*  30 */     return this._taxBracketId;
/*     */   }
/*     */   
/*     */   public void setTaxBracketId(String argTaxBracketId) {
/*  34 */     this._taxBracketId = (argTaxBracketId != null && MANAGE_CASE) ? argTaxBracketId.toUpperCase() : argTaxBracketId;
/*     */   }
/*     */   
/*     */   public Integer getTaxBracketSequence() {
/*  38 */     return this._taxBracketSequence;
/*     */   }
/*     */   
/*     */   public void setTaxBracketSequence(Integer argTaxBracketSequence) {
/*  42 */     this._taxBracketSequence = argTaxBracketSequence;
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
/*  58 */         setTaxBracketId((String)null);
/*     */       } else {
/*     */         
/*  61 */         setTaxBracketId(str);
/*     */       } 
/*  63 */       str = tokens[2];
/*     */       
/*  65 */       setTaxBracketSequence(Integer.valueOf(str));
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
/*  77 */     if (!(ob instanceof TaxBracketId)) {
/*  78 */       return false;
/*     */     }
/*  80 */     TaxBracketId other = (TaxBracketId)ob;
/*  81 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  84 */       .equals(other._organizationId))) && ((this._taxBracketId == null && other._taxBracketId == null) || (this._taxBracketId != null && this._taxBracketId
/*     */ 
/*     */       
/*  87 */       .equals(other._taxBracketId))) && ((this._taxBracketSequence == null && other._taxBracketSequence == null) || (this._taxBracketSequence != null && this._taxBracketSequence
/*     */ 
/*     */       
/*  90 */       .equals(other._taxBracketSequence))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  96 */     return ((this._organizationId == null) ? 0 : this._organizationId
/*  97 */       .hashCode()) + ((this._taxBracketId == null) ? 0 : this._taxBracketId
/*  98 */       .hashCode()) + ((this._taxBracketSequence == null) ? 0 : this._taxBracketSequence
/*  99 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 104 */     return "TaxBracket";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 109 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 111 */     return buff.append(
/* 112 */         String.valueOf(this._organizationId))
/* 113 */       .append("::").append(this._taxBracketId)
/* 114 */       .append("::").append(String.valueOf(this._taxBracketSequence))
/* 115 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 119 */     if (this._taxBracketId == null) {
/* 120 */       return false;
/*     */     }
/* 122 */     if (this._taxBracketSequence == null) {
/* 123 */       return false;
/*     */     }
/* 125 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\TaxBracketId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */