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
/*     */ public class ChargeAccountUserPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -2123975143L;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private String _accountUserId;
/*     */   private String _propertyCode;
/*     */   
/*     */   public ChargeAccountUserPropertyId() {}
/*     */   
/*     */   public ChargeAccountUserPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustAccountId() {
/*  32 */     return this._custAccountId;
/*     */   }
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/*  36 */     this._custAccountId = (argCustAccountId != null && MANAGE_CASE) ? argCustAccountId.toUpperCase() : argCustAccountId;
/*     */   }
/*     */   
/*     */   public String getCustAccountCode() {
/*  40 */     return this._custAccountCode;
/*     */   }
/*     */   
/*     */   public void setCustAccountCode(String argCustAccountCode) {
/*  44 */     this._custAccountCode = (argCustAccountCode != null && MANAGE_CASE) ? argCustAccountCode.toUpperCase() : argCustAccountCode;
/*     */   }
/*     */   
/*     */   public String getAccountUserId() {
/*  48 */     return this._accountUserId;
/*     */   }
/*     */   
/*     */   public void setAccountUserId(String argAccountUserId) {
/*  52 */     this._accountUserId = (argAccountUserId != null && MANAGE_CASE) ? argAccountUserId.toUpperCase() : argAccountUserId;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  56 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  60 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  64 */     String str = argObjectIdValue;
/*  65 */     if (StringUtils.isEmpty(str)) {
/*  66 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  69 */       String[] tokens = str.split("::");
/*  70 */       str = tokens[0];
/*     */       
/*  72 */       setOrganizationId(Long.valueOf(str));
/*  73 */       str = tokens[1];
/*     */       
/*  75 */       if ("null".equals(str)) {
/*  76 */         setCustAccountId((String)null);
/*     */       } else {
/*     */         
/*  79 */         setCustAccountId(str);
/*     */       } 
/*  81 */       str = tokens[2];
/*     */       
/*  83 */       if ("null".equals(str)) {
/*  84 */         setCustAccountCode((String)null);
/*     */       } else {
/*     */         
/*  87 */         setCustAccountCode(str);
/*     */       } 
/*  89 */       str = tokens[3];
/*     */       
/*  91 */       if ("null".equals(str)) {
/*  92 */         setAccountUserId((String)null);
/*     */       } else {
/*     */         
/*  95 */         setAccountUserId(str);
/*     */       } 
/*  97 */       str = tokens[4];
/*     */       
/*  99 */       if ("null".equals(str)) {
/* 100 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 103 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 106 */     } catch (Exception ee) {
/* 107 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 113 */     if (this == ob) {
/* 114 */       return true;
/*     */     }
/* 116 */     if (!(ob instanceof ChargeAccountUserPropertyId)) {
/* 117 */       return false;
/*     */     }
/* 119 */     ChargeAccountUserPropertyId other = (ChargeAccountUserPropertyId)ob;
/* 120 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 123 */       .equals(other._organizationId))) && ((this._custAccountId == null && other._custAccountId == null) || (this._custAccountId != null && this._custAccountId
/*     */ 
/*     */       
/* 126 */       .equals(other._custAccountId))) && ((this._custAccountCode == null && other._custAccountCode == null) || (this._custAccountCode != null && this._custAccountCode
/*     */ 
/*     */       
/* 129 */       .equals(other._custAccountCode))) && ((this._accountUserId == null && other._accountUserId == null) || (this._accountUserId != null && this._accountUserId
/*     */ 
/*     */       
/* 132 */       .equals(other._accountUserId))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 135 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 141 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 142 */       .hashCode()) + ((this._custAccountId == null) ? 0 : this._custAccountId
/* 143 */       .hashCode()) + ((this._custAccountCode == null) ? 0 : this._custAccountCode
/* 144 */       .hashCode()) + ((this._accountUserId == null) ? 0 : this._accountUserId
/* 145 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 146 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 151 */     return "ChargeAccountUserProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 156 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 158 */     return buff.append(
/* 159 */         String.valueOf(this._organizationId))
/* 160 */       .append("::").append(this._custAccountId)
/* 161 */       .append("::").append(this._custAccountCode)
/* 162 */       .append("::").append(this._accountUserId)
/* 163 */       .append("::").append(this._propertyCode)
/* 164 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 168 */     if (this._custAccountId == null) {
/* 169 */       return false;
/*     */     }
/* 171 */     if (this._custAccountCode == null) {
/* 172 */       return false;
/*     */     }
/* 174 */     if (this._accountUserId == null) {
/* 175 */       return false;
/*     */     }
/* 177 */     if (this._propertyCode == null) {
/* 178 */       return false;
/*     */     }
/* 180 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\ChargeAccountUserPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */