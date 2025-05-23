/*     */ package dtv.xst.dao.tnd;
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
/*     */ public class TenderDenominationId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1700067577L;
/*     */   private String _denominationId;
/*     */   private String _tenderId;
/*     */   
/*     */   public TenderDenominationId() {}
/*     */   
/*     */   public TenderDenominationId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDenominationId() {
/*  30 */     return this._denominationId;
/*     */   }
/*     */   
/*     */   public void setDenominationId(String argDenominationId) {
/*  34 */     this._denominationId = (argDenominationId != null && MANAGE_CASE) ? argDenominationId.toUpperCase() : argDenominationId;
/*     */   }
/*     */   
/*     */   public String getTenderId() {
/*  38 */     return this._tenderId;
/*     */   }
/*     */   
/*     */   public void setTenderId(String argTenderId) {
/*  42 */     this._tenderId = (argTenderId != null && MANAGE_CASE) ? argTenderId.toUpperCase() : argTenderId;
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
/*  55 */         setDenominationId((String)null);
/*     */       } else {
/*     */         
/*  58 */         setDenominationId(str);
/*     */       } 
/*  60 */       str = tokens[1];
/*     */       
/*  62 */       setOrganizationId(Long.valueOf(str));
/*  63 */       str = tokens[2];
/*     */       
/*  65 */       if ("null".equals(str)) {
/*  66 */         setTenderId((String)null);
/*     */       } else {
/*     */         
/*  69 */         setTenderId(str);
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
/*  82 */     if (!(ob instanceof TenderDenominationId)) {
/*  83 */       return false;
/*     */     }
/*  85 */     TenderDenominationId other = (TenderDenominationId)ob;
/*  86 */     return (((this._denominationId == null && other._denominationId == null) || (this._denominationId != null && this._denominationId
/*     */ 
/*     */       
/*  89 */       .equals(other._denominationId))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  92 */       .equals(other._organizationId))) && ((this._tenderId == null && other._tenderId == null) || (this._tenderId != null && this._tenderId
/*     */ 
/*     */       
/*  95 */       .equals(other._tenderId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 101 */     return ((this._denominationId == null) ? 0 : this._denominationId
/* 102 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 103 */       .hashCode()) + ((this._tenderId == null) ? 0 : this._tenderId
/* 104 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 109 */     return "TenderDenomination";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 114 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 116 */     return buff.append(this._denominationId)
/*     */       
/* 118 */       .append("::").append(String.valueOf(this._organizationId))
/* 119 */       .append("::").append(this._tenderId)
/* 120 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 124 */     if (this._denominationId == null) {
/* 125 */       return false;
/*     */     }
/* 127 */     if (this._tenderId == null) {
/* 128 */       return false;
/*     */     }
/* 130 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tnd\TenderDenominationId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */