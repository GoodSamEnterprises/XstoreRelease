/*     */ package dtv.xst.dao.cat;
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
/*     */ public class EscrowAccountActivityId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -374900425L;
/*     */   private String _custAccountId;
/*     */   private Long _seqNbr;
/*     */   
/*     */   public EscrowAccountActivityId() {}
/*     */   
/*     */   public EscrowAccountActivityId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustAccountId() {
/*  30 */     return this._custAccountId;
/*     */   }
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/*  34 */     this._custAccountId = (argCustAccountId != null && MANAGE_CASE) ? argCustAccountId.toUpperCase() : argCustAccountId;
/*     */   }
/*     */   
/*     */   public Long getSeqNbr() {
/*  38 */     return this._seqNbr;
/*     */   }
/*     */   
/*     */   public void setSeqNbr(Long argSeqNbr) {
/*  42 */     this._seqNbr = argSeqNbr;
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
/*  58 */         setCustAccountId((String)null);
/*     */       } else {
/*     */         
/*  61 */         setCustAccountId(str);
/*     */       } 
/*  63 */       str = tokens[2];
/*     */       
/*  65 */       setSeqNbr(Long.valueOf(str));
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
/*  77 */     if (!(ob instanceof EscrowAccountActivityId)) {
/*  78 */       return false;
/*     */     }
/*  80 */     EscrowAccountActivityId other = (EscrowAccountActivityId)ob;
/*  81 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  84 */       .equals(other._organizationId))) && ((this._custAccountId == null && other._custAccountId == null) || (this._custAccountId != null && this._custAccountId
/*     */ 
/*     */       
/*  87 */       .equals(other._custAccountId))) && ((this._seqNbr == null && other._seqNbr == null) || (this._seqNbr != null && this._seqNbr
/*     */ 
/*     */       
/*  90 */       .equals(other._seqNbr))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  96 */     return ((this._organizationId == null) ? 0 : this._organizationId
/*  97 */       .hashCode()) + ((this._custAccountId == null) ? 0 : this._custAccountId
/*  98 */       .hashCode()) + ((this._seqNbr == null) ? 0 : this._seqNbr
/*  99 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 104 */     return "EscrowAccountActivity";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 109 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 111 */     return buff.append(
/* 112 */         String.valueOf(this._organizationId))
/* 113 */       .append("::").append(this._custAccountId)
/* 114 */       .append("::").append(String.valueOf(this._seqNbr))
/* 115 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 119 */     if (this._custAccountId == null) {
/* 120 */       return false;
/*     */     }
/* 122 */     if (this._seqNbr == null) {
/* 123 */       return false;
/*     */     }
/* 125 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\EscrowAccountActivityId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */