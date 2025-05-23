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
/*     */ public class CustomerAccountNotePropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1251449302L;
/*     */   private Long _noteSequence;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private String _propertyCode;
/*     */   
/*     */   public CustomerAccountNotePropertyId() {}
/*     */   
/*     */   public CustomerAccountNotePropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getNoteSequence() {
/*  32 */     return this._noteSequence;
/*     */   }
/*     */   
/*     */   public void setNoteSequence(Long argNoteSequence) {
/*  36 */     this._noteSequence = argNoteSequence;
/*     */   }
/*     */   
/*     */   public String getCustAccountId() {
/*  40 */     return this._custAccountId;
/*     */   }
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/*  44 */     this._custAccountId = (argCustAccountId != null && MANAGE_CASE) ? argCustAccountId.toUpperCase() : argCustAccountId;
/*     */   }
/*     */   
/*     */   public String getCustAccountCode() {
/*  48 */     return this._custAccountCode;
/*     */   }
/*     */   
/*     */   public void setCustAccountCode(String argCustAccountCode) {
/*  52 */     this._custAccountCode = (argCustAccountCode != null && MANAGE_CASE) ? argCustAccountCode.toUpperCase() : argCustAccountCode;
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
/*  72 */       setNoteSequence(Long.valueOf(str));
/*  73 */       str = tokens[1];
/*     */       
/*  75 */       setOrganizationId(Long.valueOf(str));
/*  76 */       str = tokens[2];
/*     */       
/*  78 */       if ("null".equals(str)) {
/*  79 */         setCustAccountId((String)null);
/*     */       } else {
/*     */         
/*  82 */         setCustAccountId(str);
/*     */       } 
/*  84 */       str = tokens[3];
/*     */       
/*  86 */       if ("null".equals(str)) {
/*  87 */         setCustAccountCode((String)null);
/*     */       } else {
/*     */         
/*  90 */         setCustAccountCode(str);
/*     */       } 
/*  92 */       str = tokens[4];
/*     */       
/*  94 */       if ("null".equals(str)) {
/*  95 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/*  98 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 101 */     } catch (Exception ee) {
/* 102 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 108 */     if (this == ob) {
/* 109 */       return true;
/*     */     }
/* 111 */     if (!(ob instanceof CustomerAccountNotePropertyId)) {
/* 112 */       return false;
/*     */     }
/* 114 */     CustomerAccountNotePropertyId other = (CustomerAccountNotePropertyId)ob;
/* 115 */     return (((this._noteSequence == null && other._noteSequence == null) || (this._noteSequence != null && this._noteSequence
/*     */ 
/*     */       
/* 118 */       .equals(other._noteSequence))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 121 */       .equals(other._organizationId))) && ((this._custAccountId == null && other._custAccountId == null) || (this._custAccountId != null && this._custAccountId
/*     */ 
/*     */       
/* 124 */       .equals(other._custAccountId))) && ((this._custAccountCode == null && other._custAccountCode == null) || (this._custAccountCode != null && this._custAccountCode
/*     */ 
/*     */       
/* 127 */       .equals(other._custAccountCode))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 130 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 136 */     return ((this._noteSequence == null) ? 0 : this._noteSequence
/* 137 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 138 */       .hashCode()) + ((this._custAccountId == null) ? 0 : this._custAccountId
/* 139 */       .hashCode()) + ((this._custAccountCode == null) ? 0 : this._custAccountCode
/* 140 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 141 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 146 */     return "CustomerAccountNoteProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 151 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 153 */     return buff.append(
/* 154 */         String.valueOf(this._noteSequence))
/* 155 */       .append("::").append(String.valueOf(this._organizationId))
/* 156 */       .append("::").append(this._custAccountId)
/* 157 */       .append("::").append(this._custAccountCode)
/* 158 */       .append("::").append(this._propertyCode)
/* 159 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 163 */     if (this._noteSequence == null) {
/* 164 */       return false;
/*     */     }
/* 166 */     if (this._custAccountId == null) {
/* 167 */       return false;
/*     */     }
/* 169 */     if (this._custAccountCode == null) {
/* 170 */       return false;
/*     */     }
/* 172 */     if (this._propertyCode == null) {
/* 173 */       return false;
/*     */     }
/* 175 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\CustomerAccountNotePropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */