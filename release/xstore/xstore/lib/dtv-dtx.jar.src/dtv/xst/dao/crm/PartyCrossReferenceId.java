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
/*     */ public class PartyCrossReferenceId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -462769327L;
/*     */   private Long _childPartyId;
/*     */   private Long _parentPartyId;
/*     */   private String _partyRelationshipTypeCode;
/*     */   
/*     */   public PartyCrossReferenceId() {}
/*     */   
/*     */   public PartyCrossReferenceId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getChildPartyId() {
/*  31 */     return this._childPartyId;
/*     */   }
/*     */   
/*     */   public void setChildPartyId(Long argChildPartyId) {
/*  35 */     this._childPartyId = argChildPartyId;
/*     */   }
/*     */   
/*     */   public Long getParentPartyId() {
/*  39 */     return this._parentPartyId;
/*     */   }
/*     */   
/*     */   public void setParentPartyId(Long argParentPartyId) {
/*  43 */     this._parentPartyId = argParentPartyId;
/*     */   }
/*     */   
/*     */   public String getPartyRelationshipTypeCode() {
/*  47 */     return this._partyRelationshipTypeCode;
/*     */   }
/*     */   
/*     */   public void setPartyRelationshipTypeCode(String argPartyRelationshipTypeCode) {
/*  51 */     this._partyRelationshipTypeCode = (argPartyRelationshipTypeCode != null && MANAGE_CASE) ? argPartyRelationshipTypeCode.toUpperCase() : argPartyRelationshipTypeCode;
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
/*  63 */       setChildPartyId(Long.valueOf(str));
/*  64 */       str = tokens[1];
/*     */       
/*  66 */       setOrganizationId(Long.valueOf(str));
/*  67 */       str = tokens[2];
/*     */       
/*  69 */       setParentPartyId(Long.valueOf(str));
/*  70 */       str = tokens[3];
/*     */       
/*  72 */       if ("null".equals(str)) {
/*  73 */         setPartyRelationshipTypeCode((String)null);
/*     */       } else {
/*     */         
/*  76 */         setPartyRelationshipTypeCode(str);
/*     */       }
/*     */     
/*  79 */     } catch (Exception ee) {
/*  80 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  86 */     if (this == ob) {
/*  87 */       return true;
/*     */     }
/*  89 */     if (!(ob instanceof PartyCrossReferenceId)) {
/*  90 */       return false;
/*     */     }
/*  92 */     PartyCrossReferenceId other = (PartyCrossReferenceId)ob;
/*  93 */     return (((this._childPartyId == null && other._childPartyId == null) || (this._childPartyId != null && this._childPartyId
/*     */ 
/*     */       
/*  96 */       .equals(other._childPartyId))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  99 */       .equals(other._organizationId))) && ((this._parentPartyId == null && other._parentPartyId == null) || (this._parentPartyId != null && this._parentPartyId
/*     */ 
/*     */       
/* 102 */       .equals(other._parentPartyId))) && ((this._partyRelationshipTypeCode == null && other._partyRelationshipTypeCode == null) || (this._partyRelationshipTypeCode != null && this._partyRelationshipTypeCode
/*     */ 
/*     */       
/* 105 */       .equals(other._partyRelationshipTypeCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 111 */     return ((this._childPartyId == null) ? 0 : this._childPartyId
/* 112 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 113 */       .hashCode()) + ((this._parentPartyId == null) ? 0 : this._parentPartyId
/* 114 */       .hashCode()) + ((this._partyRelationshipTypeCode == null) ? 0 : this._partyRelationshipTypeCode
/* 115 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 120 */     return "PartyCrossReference";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 125 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 127 */     return buff.append(
/* 128 */         String.valueOf(this._childPartyId))
/* 129 */       .append("::").append(String.valueOf(this._organizationId))
/* 130 */       .append("::").append(String.valueOf(this._parentPartyId))
/* 131 */       .append("::").append(this._partyRelationshipTypeCode)
/* 132 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 136 */     if (this._childPartyId == null) {
/* 137 */       return false;
/*     */     }
/* 139 */     if (this._parentPartyId == null) {
/* 140 */       return false;
/*     */     }
/* 142 */     if (this._partyRelationshipTypeCode == null) {
/* 143 */       return false;
/*     */     }
/* 145 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\PartyCrossReferenceId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */