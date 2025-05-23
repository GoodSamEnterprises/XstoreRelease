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
/*     */ public class ChargeAccountUserId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -143206364L;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private String _accountUserId;
/*     */   
/*     */   public ChargeAccountUserId() {}
/*     */   
/*     */   public ChargeAccountUserId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustAccountId() {
/*  31 */     return this._custAccountId;
/*     */   }
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/*  35 */     this._custAccountId = (argCustAccountId != null && MANAGE_CASE) ? argCustAccountId.toUpperCase() : argCustAccountId;
/*     */   }
/*     */   
/*     */   public String getCustAccountCode() {
/*  39 */     return this._custAccountCode;
/*     */   }
/*     */   
/*     */   public void setCustAccountCode(String argCustAccountCode) {
/*  43 */     this._custAccountCode = (argCustAccountCode != null && MANAGE_CASE) ? argCustAccountCode.toUpperCase() : argCustAccountCode;
/*     */   }
/*     */   
/*     */   public String getAccountUserId() {
/*  47 */     return this._accountUserId;
/*     */   }
/*     */   
/*     */   public void setAccountUserId(String argAccountUserId) {
/*  51 */     this._accountUserId = (argAccountUserId != null && MANAGE_CASE) ? argAccountUserId.toUpperCase() : argAccountUserId;
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
/*  67 */         setCustAccountId((String)null);
/*     */       } else {
/*     */         
/*  70 */         setCustAccountId(str);
/*     */       } 
/*  72 */       str = tokens[2];
/*     */       
/*  74 */       if ("null".equals(str)) {
/*  75 */         setCustAccountCode((String)null);
/*     */       } else {
/*     */         
/*  78 */         setCustAccountCode(str);
/*     */       } 
/*  80 */       str = tokens[3];
/*     */       
/*  82 */       if ("null".equals(str)) {
/*  83 */         setAccountUserId((String)null);
/*     */       } else {
/*     */         
/*  86 */         setAccountUserId(str);
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
/*  99 */     if (!(ob instanceof ChargeAccountUserId)) {
/* 100 */       return false;
/*     */     }
/* 102 */     ChargeAccountUserId other = (ChargeAccountUserId)ob;
/* 103 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 106 */       .equals(other._organizationId))) && ((this._custAccountId == null && other._custAccountId == null) || (this._custAccountId != null && this._custAccountId
/*     */ 
/*     */       
/* 109 */       .equals(other._custAccountId))) && ((this._custAccountCode == null && other._custAccountCode == null) || (this._custAccountCode != null && this._custAccountCode
/*     */ 
/*     */       
/* 112 */       .equals(other._custAccountCode))) && ((this._accountUserId == null && other._accountUserId == null) || (this._accountUserId != null && this._accountUserId
/*     */ 
/*     */       
/* 115 */       .equals(other._accountUserId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 122 */       .hashCode()) + ((this._custAccountId == null) ? 0 : this._custAccountId
/* 123 */       .hashCode()) + ((this._custAccountCode == null) ? 0 : this._custAccountCode
/* 124 */       .hashCode()) + ((this._accountUserId == null) ? 0 : this._accountUserId
/* 125 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 130 */     return "ChargeAccountUser";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 135 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 137 */     return buff.append(
/* 138 */         String.valueOf(this._organizationId))
/* 139 */       .append("::").append(this._custAccountId)
/* 140 */       .append("::").append(this._custAccountCode)
/* 141 */       .append("::").append(this._accountUserId)
/* 142 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 146 */     if (this._custAccountId == null) {
/* 147 */       return false;
/*     */     }
/* 149 */     if (this._custAccountCode == null) {
/* 150 */       return false;
/*     */     }
/* 152 */     if (this._accountUserId == null) {
/* 153 */       return false;
/*     */     }
/* 155 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\ChargeAccountUserId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */