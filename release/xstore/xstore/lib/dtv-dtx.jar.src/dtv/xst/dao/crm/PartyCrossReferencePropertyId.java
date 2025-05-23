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
/*     */ public class PartyCrossReferencePropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1716982854L;
/*     */   private Long _childPartyId;
/*     */   private Long _parentPartyId;
/*     */   private String _partyRelationshipTypeCode;
/*     */   private String _propertyCode;
/*     */   
/*     */   public PartyCrossReferencePropertyId() {}
/*     */   
/*     */   public PartyCrossReferencePropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getChildPartyId() {
/*  32 */     return this._childPartyId;
/*     */   }
/*     */   
/*     */   public void setChildPartyId(Long argChildPartyId) {
/*  36 */     this._childPartyId = argChildPartyId;
/*     */   }
/*     */   
/*     */   public Long getParentPartyId() {
/*  40 */     return this._parentPartyId;
/*     */   }
/*     */   
/*     */   public void setParentPartyId(Long argParentPartyId) {
/*  44 */     this._parentPartyId = argParentPartyId;
/*     */   }
/*     */   
/*     */   public String getPartyRelationshipTypeCode() {
/*  48 */     return this._partyRelationshipTypeCode;
/*     */   }
/*     */   
/*     */   public void setPartyRelationshipTypeCode(String argPartyRelationshipTypeCode) {
/*  52 */     this._partyRelationshipTypeCode = (argPartyRelationshipTypeCode != null && MANAGE_CASE) ? argPartyRelationshipTypeCode.toUpperCase() : argPartyRelationshipTypeCode;
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
/*  72 */       setChildPartyId(Long.valueOf(str));
/*  73 */       str = tokens[1];
/*     */       
/*  75 */       setOrganizationId(Long.valueOf(str));
/*  76 */       str = tokens[2];
/*     */       
/*  78 */       setParentPartyId(Long.valueOf(str));
/*  79 */       str = tokens[3];
/*     */       
/*  81 */       if ("null".equals(str)) {
/*  82 */         setPartyRelationshipTypeCode((String)null);
/*     */       } else {
/*     */         
/*  85 */         setPartyRelationshipTypeCode(str);
/*     */       } 
/*  87 */       str = tokens[4];
/*     */       
/*  89 */       if ("null".equals(str)) {
/*  90 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/*  93 */         setPropertyCode(str);
/*     */       }
/*     */     
/*  96 */     } catch (Exception ee) {
/*  97 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 103 */     if (this == ob) {
/* 104 */       return true;
/*     */     }
/* 106 */     if (!(ob instanceof PartyCrossReferencePropertyId)) {
/* 107 */       return false;
/*     */     }
/* 109 */     PartyCrossReferencePropertyId other = (PartyCrossReferencePropertyId)ob;
/* 110 */     return (((this._childPartyId == null && other._childPartyId == null) || (this._childPartyId != null && this._childPartyId
/*     */ 
/*     */       
/* 113 */       .equals(other._childPartyId))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 116 */       .equals(other._organizationId))) && ((this._parentPartyId == null && other._parentPartyId == null) || (this._parentPartyId != null && this._parentPartyId
/*     */ 
/*     */       
/* 119 */       .equals(other._parentPartyId))) && ((this._partyRelationshipTypeCode == null && other._partyRelationshipTypeCode == null) || (this._partyRelationshipTypeCode != null && this._partyRelationshipTypeCode
/*     */ 
/*     */       
/* 122 */       .equals(other._partyRelationshipTypeCode))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 125 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 131 */     return ((this._childPartyId == null) ? 0 : this._childPartyId
/* 132 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 133 */       .hashCode()) + ((this._parentPartyId == null) ? 0 : this._parentPartyId
/* 134 */       .hashCode()) + ((this._partyRelationshipTypeCode == null) ? 0 : this._partyRelationshipTypeCode
/* 135 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 136 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 141 */     return "PartyCrossReferenceProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 146 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 148 */     return buff.append(
/* 149 */         String.valueOf(this._childPartyId))
/* 150 */       .append("::").append(String.valueOf(this._organizationId))
/* 151 */       .append("::").append(String.valueOf(this._parentPartyId))
/* 152 */       .append("::").append(this._partyRelationshipTypeCode)
/* 153 */       .append("::").append(this._propertyCode)
/* 154 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 158 */     if (this._childPartyId == null) {
/* 159 */       return false;
/*     */     }
/* 161 */     if (this._parentPartyId == null) {
/* 162 */       return false;
/*     */     }
/* 164 */     if (this._partyRelationshipTypeCode == null) {
/* 165 */       return false;
/*     */     }
/* 167 */     if (this._propertyCode == null) {
/* 168 */       return false;
/*     */     }
/* 170 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\PartyCrossReferencePropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */