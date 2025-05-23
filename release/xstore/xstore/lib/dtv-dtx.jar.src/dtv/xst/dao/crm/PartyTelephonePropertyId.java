/*     */ package dtv.xst.dao.crm;
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
/*     */ public class PartyTelephonePropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -751703085L;
/*     */   private Long _partyId;
/*     */   private String _telephoneType;
/*     */   private String _propertyCode;
/*     */   
/*     */   public PartyTelephonePropertyId() {}
/*     */   
/*     */   public PartyTelephonePropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getPartyId() {
/*  31 */     return this._partyId;
/*     */   }
/*     */   
/*     */   public void setPartyId(Long argPartyId) {
/*  35 */     this._partyId = argPartyId;
/*     */   }
/*     */   
/*     */   public String getTelephoneType() {
/*  39 */     return this._telephoneType;
/*     */   }
/*     */   
/*     */   public void setTelephoneType(String argTelephoneType) {
/*  43 */     this._telephoneType = (argTelephoneType != null && MANAGE_CASE) ? argTelephoneType.toUpperCase() : argTelephoneType;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  47 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  51 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
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
/*  66 */       setPartyId(Long.valueOf(str));
/*  67 */       str = tokens[2];
/*     */       
/*  69 */       if ("null".equals(str)) {
/*  70 */         setTelephoneType((String)null);
/*     */       } else {
/*     */         
/*  73 */         setTelephoneType(str);
/*     */       } 
/*  75 */       str = tokens[3];
/*     */       
/*  77 */       if ("null".equals(str)) {
/*  78 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/*  81 */         setPropertyCode(str);
/*     */       }
/*     */     
/*  84 */     } catch (Exception ee) {
/*  85 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  91 */     if (this == ob) {
/*  92 */       return true;
/*     */     }
/*  94 */     if (!(ob instanceof PartyTelephonePropertyId)) {
/*  95 */       return false;
/*     */     }
/*  97 */     PartyTelephonePropertyId other = (PartyTelephonePropertyId)ob;
/*  98 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 101 */       .equals(other._organizationId))) && ((this._partyId == null && other._partyId == null) || (this._partyId != null && this._partyId
/*     */ 
/*     */       
/* 104 */       .equals(other._partyId))) && ((this._telephoneType == null && other._telephoneType == null) || (this._telephoneType != null && this._telephoneType
/*     */ 
/*     */       
/* 107 */       .equals(other._telephoneType))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 110 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 116 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 117 */       .hashCode()) + ((this._partyId == null) ? 0 : this._partyId
/* 118 */       .hashCode()) + ((this._telephoneType == null) ? 0 : this._telephoneType
/* 119 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 120 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 125 */     return "PartyTelephoneProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 130 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 132 */     return buff.append(
/* 133 */         String.valueOf(this._organizationId))
/* 134 */       .append("::").append(String.valueOf(this._partyId))
/* 135 */       .append("::").append(this._telephoneType)
/* 136 */       .append("::").append(this._propertyCode)
/* 137 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 141 */     if (this._partyId == null) {
/* 142 */       return false;
/*     */     }
/* 144 */     if (this._telephoneType == null) {
/* 145 */       return false;
/*     */     }
/* 147 */     if (this._propertyCode == null) {
/* 148 */       return false;
/*     */     }
/* 150 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\PartyTelephonePropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */