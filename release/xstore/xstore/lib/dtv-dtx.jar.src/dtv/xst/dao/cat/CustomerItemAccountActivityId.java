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
/*     */ public class CustomerItemAccountActivityId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 570978283L;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private Long _custAccountDetailNum;
/*     */   private Long _sequenceNumber;
/*     */   
/*     */   public CustomerItemAccountActivityId() {}
/*     */   
/*     */   public CustomerItemAccountActivityId(String argObjectIdValue) {
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
/*     */   public Long getCustAccountDetailNum() {
/*  48 */     return this._custAccountDetailNum;
/*     */   }
/*     */   
/*     */   public void setCustAccountDetailNum(Long argCustAccountDetailNum) {
/*  52 */     this._custAccountDetailNum = argCustAccountDetailNum;
/*     */   }
/*     */   
/*     */   public Long getSequenceNumber() {
/*  56 */     return this._sequenceNumber;
/*     */   }
/*     */   
/*     */   public void setSequenceNumber(Long argSequenceNumber) {
/*  60 */     this._sequenceNumber = argSequenceNumber;
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
/*  91 */       setCustAccountDetailNum(Long.valueOf(str));
/*  92 */       str = tokens[4];
/*     */       
/*  94 */       setSequenceNumber(Long.valueOf(str));
/*     */     }
/*  96 */     catch (Exception ee) {
/*  97 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 103 */     if (this == ob) {
/* 104 */       return true;
/*     */     }
/* 106 */     if (!(ob instanceof CustomerItemAccountActivityId)) {
/* 107 */       return false;
/*     */     }
/* 109 */     CustomerItemAccountActivityId other = (CustomerItemAccountActivityId)ob;
/* 110 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 113 */       .equals(other._organizationId))) && ((this._custAccountId == null && other._custAccountId == null) || (this._custAccountId != null && this._custAccountId
/*     */ 
/*     */       
/* 116 */       .equals(other._custAccountId))) && ((this._custAccountCode == null && other._custAccountCode == null) || (this._custAccountCode != null && this._custAccountCode
/*     */ 
/*     */       
/* 119 */       .equals(other._custAccountCode))) && ((this._custAccountDetailNum == null && other._custAccountDetailNum == null) || (this._custAccountDetailNum != null && this._custAccountDetailNum
/*     */ 
/*     */       
/* 122 */       .equals(other._custAccountDetailNum))) && ((this._sequenceNumber == null && other._sequenceNumber == null) || (this._sequenceNumber != null && this._sequenceNumber
/*     */ 
/*     */       
/* 125 */       .equals(other._sequenceNumber))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 131 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 132 */       .hashCode()) + ((this._custAccountId == null) ? 0 : this._custAccountId
/* 133 */       .hashCode()) + ((this._custAccountCode == null) ? 0 : this._custAccountCode
/* 134 */       .hashCode()) + ((this._custAccountDetailNum == null) ? 0 : this._custAccountDetailNum
/* 135 */       .hashCode()) + ((this._sequenceNumber == null) ? 0 : this._sequenceNumber
/* 136 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 141 */     return "CustomerItemAccountActivity";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 146 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 148 */     return buff.append(
/* 149 */         String.valueOf(this._organizationId))
/* 150 */       .append("::").append(this._custAccountId)
/* 151 */       .append("::").append(this._custAccountCode)
/* 152 */       .append("::").append(String.valueOf(this._custAccountDetailNum))
/* 153 */       .append("::").append(String.valueOf(this._sequenceNumber))
/* 154 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 158 */     if (this._custAccountId == null) {
/* 159 */       return false;
/*     */     }
/* 161 */     if (this._custAccountCode == null) {
/* 162 */       return false;
/*     */     }
/* 164 */     if (this._custAccountDetailNum == null) {
/* 165 */       return false;
/*     */     }
/* 167 */     if (this._sequenceNumber == null) {
/* 168 */       return false;
/*     */     }
/* 170 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\CustomerItemAccountActivityId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */