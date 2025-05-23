/*     */ package dtv.xst.dao.cat;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CustomerItemAccountActivityPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 698586848L;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private Long _custAccountDetailNum;
/*     */   private Long _sequenceNumber;
/*     */   private String _propertyCode;
/*     */   
/*     */   public CustomerItemAccountActivityPropertyId() {}
/*     */   
/*     */   public CustomerItemAccountActivityPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustAccountId() {
/*  33 */     return this._custAccountId;
/*     */   }
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/*  37 */     this._custAccountId = (argCustAccountId != null && MANAGE_CASE) ? argCustAccountId.toUpperCase() : argCustAccountId;
/*     */   }
/*     */   
/*     */   public String getCustAccountCode() {
/*  41 */     return this._custAccountCode;
/*     */   }
/*     */   
/*     */   public void setCustAccountCode(String argCustAccountCode) {
/*  45 */     this._custAccountCode = (argCustAccountCode != null && MANAGE_CASE) ? argCustAccountCode.toUpperCase() : argCustAccountCode;
/*     */   }
/*     */   
/*     */   public Long getCustAccountDetailNum() {
/*  49 */     return this._custAccountDetailNum;
/*     */   }
/*     */   
/*     */   public void setCustAccountDetailNum(Long argCustAccountDetailNum) {
/*  53 */     this._custAccountDetailNum = argCustAccountDetailNum;
/*     */   }
/*     */   
/*     */   public Long getSequenceNumber() {
/*  57 */     return this._sequenceNumber;
/*     */   }
/*     */   
/*     */   public void setSequenceNumber(Long argSequenceNumber) {
/*  61 */     this._sequenceNumber = argSequenceNumber;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  65 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  69 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  73 */     String str = argObjectIdValue;
/*  74 */     if (StringUtils.isEmpty(str)) {
/*  75 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  78 */       String[] tokens = str.split("::");
/*  79 */       str = tokens[0];
/*     */       
/*  81 */       setOrganizationId(Long.valueOf(str));
/*  82 */       str = tokens[1];
/*     */       
/*  84 */       if ("null".equals(str)) {
/*  85 */         setCustAccountId((String)null);
/*     */       } else {
/*     */         
/*  88 */         setCustAccountId(str);
/*     */       } 
/*  90 */       str = tokens[2];
/*     */       
/*  92 */       if ("null".equals(str)) {
/*  93 */         setCustAccountCode((String)null);
/*     */       } else {
/*     */         
/*  96 */         setCustAccountCode(str);
/*     */       } 
/*  98 */       str = tokens[3];
/*     */       
/* 100 */       setCustAccountDetailNum(Long.valueOf(str));
/* 101 */       str = tokens[4];
/*     */       
/* 103 */       setSequenceNumber(Long.valueOf(str));
/* 104 */       str = tokens[5];
/*     */       
/* 106 */       if ("null".equals(str)) {
/* 107 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 110 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 113 */     } catch (Exception ee) {
/* 114 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 120 */     if (this == ob) {
/* 121 */       return true;
/*     */     }
/* 123 */     if (!(ob instanceof CustomerItemAccountActivityPropertyId)) {
/* 124 */       return false;
/*     */     }
/* 126 */     CustomerItemAccountActivityPropertyId other = (CustomerItemAccountActivityPropertyId)ob;
/* 127 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 130 */       .equals(other._organizationId))) && ((this._custAccountId == null && other._custAccountId == null) || (this._custAccountId != null && this._custAccountId
/*     */ 
/*     */       
/* 133 */       .equals(other._custAccountId))) && ((this._custAccountCode == null && other._custAccountCode == null) || (this._custAccountCode != null && this._custAccountCode
/*     */ 
/*     */       
/* 136 */       .equals(other._custAccountCode))) && ((this._custAccountDetailNum == null && other._custAccountDetailNum == null) || (this._custAccountDetailNum != null && this._custAccountDetailNum
/*     */ 
/*     */       
/* 139 */       .equals(other._custAccountDetailNum))) && ((this._sequenceNumber == null && other._sequenceNumber == null) || (this._sequenceNumber != null && this._sequenceNumber
/*     */ 
/*     */       
/* 142 */       .equals(other._sequenceNumber))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 145 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 151 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 152 */       .hashCode()) + ((this._custAccountId == null) ? 0 : this._custAccountId
/* 153 */       .hashCode()) + ((this._custAccountCode == null) ? 0 : this._custAccountCode
/* 154 */       .hashCode()) + ((this._custAccountDetailNum == null) ? 0 : this._custAccountDetailNum
/* 155 */       .hashCode()) + ((this._sequenceNumber == null) ? 0 : this._sequenceNumber
/* 156 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 157 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 162 */     return "CustomerItemAccountActivityProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 167 */     StringBuilder buff = new StringBuilder(72);
/*     */     
/* 169 */     return buff.append(
/* 170 */         String.valueOf(this._organizationId))
/* 171 */       .append("::").append(this._custAccountId)
/* 172 */       .append("::").append(this._custAccountCode)
/* 173 */       .append("::").append(String.valueOf(this._custAccountDetailNum))
/* 174 */       .append("::").append(String.valueOf(this._sequenceNumber))
/* 175 */       .append("::").append(this._propertyCode)
/* 176 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 180 */     if (this._custAccountId == null) {
/* 181 */       return false;
/*     */     }
/* 183 */     if (this._custAccountCode == null) {
/* 184 */       return false;
/*     */     }
/* 186 */     if (this._custAccountDetailNum == null) {
/* 187 */       return false;
/*     */     }
/* 189 */     if (this._sequenceNumber == null) {
/* 190 */       return false;
/*     */     }
/* 192 */     if (this._propertyCode == null) {
/* 193 */       return false;
/*     */     }
/* 195 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\CustomerItemAccountActivityPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */