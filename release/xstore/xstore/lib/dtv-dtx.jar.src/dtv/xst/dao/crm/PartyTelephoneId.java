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
/*     */ 
/*     */ public class PartyTelephoneId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -158832674L;
/*     */   private Long _partyId;
/*     */   private String _telephoneType;
/*     */   
/*     */   public PartyTelephoneId() {}
/*     */   
/*     */   public PartyTelephoneId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getPartyId() {
/*  30 */     return this._partyId;
/*     */   }
/*     */   
/*     */   public void setPartyId(Long argPartyId) {
/*  34 */     this._partyId = argPartyId;
/*     */   }
/*     */   
/*     */   public String getTelephoneType() {
/*  38 */     return this._telephoneType;
/*     */   }
/*     */   
/*     */   public void setTelephoneType(String argTelephoneType) {
/*  42 */     this._telephoneType = (argTelephoneType != null && MANAGE_CASE) ? argTelephoneType.toUpperCase() : argTelephoneType;
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
/*  57 */       setPartyId(Long.valueOf(str));
/*  58 */       str = tokens[2];
/*     */       
/*  60 */       if ("null".equals(str)) {
/*  61 */         setTelephoneType((String)null);
/*     */       } else {
/*     */         
/*  64 */         setTelephoneType(str);
/*     */       }
/*     */     
/*  67 */     } catch (Exception ee) {
/*  68 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  74 */     if (this == ob) {
/*  75 */       return true;
/*     */     }
/*  77 */     if (!(ob instanceof PartyTelephoneId)) {
/*  78 */       return false;
/*     */     }
/*  80 */     PartyTelephoneId other = (PartyTelephoneId)ob;
/*  81 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  84 */       .equals(other._organizationId))) && ((this._partyId == null && other._partyId == null) || (this._partyId != null && this._partyId
/*     */ 
/*     */       
/*  87 */       .equals(other._partyId))) && ((this._telephoneType == null && other._telephoneType == null) || (this._telephoneType != null && this._telephoneType
/*     */ 
/*     */       
/*  90 */       .equals(other._telephoneType))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  96 */     return ((this._organizationId == null) ? 0 : this._organizationId
/*  97 */       .hashCode()) + ((this._partyId == null) ? 0 : this._partyId
/*  98 */       .hashCode()) + ((this._telephoneType == null) ? 0 : this._telephoneType
/*  99 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 104 */     return "PartyTelephone";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 109 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 111 */     return buff.append(
/* 112 */         String.valueOf(this._organizationId))
/* 113 */       .append("::").append(String.valueOf(this._partyId))
/* 114 */       .append("::").append(this._telephoneType)
/* 115 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 119 */     if (this._partyId == null) {
/* 120 */       return false;
/*     */     }
/* 122 */     if (this._telephoneType == null) {
/* 123 */       return false;
/*     */     }
/* 125 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\PartyTelephoneId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */