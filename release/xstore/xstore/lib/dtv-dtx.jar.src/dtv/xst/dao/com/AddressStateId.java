/*     */ package dtv.xst.dao.com;
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
/*     */ public class AddressStateId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 417522973L;
/*     */   private String _countryId;
/*     */   private String _stateId;
/*     */   private String _addressMode;
/*     */   
/*     */   public AddressStateId() {}
/*     */   
/*     */   public AddressStateId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCountryId() {
/*  31 */     return this._countryId;
/*     */   }
/*     */   
/*     */   public void setCountryId(String argCountryId) {
/*  35 */     this._countryId = (argCountryId != null && MANAGE_CASE) ? argCountryId.toUpperCase() : argCountryId;
/*     */   }
/*     */   
/*     */   public String getStateId() {
/*  39 */     return this._stateId;
/*     */   }
/*     */   
/*     */   public void setStateId(String argStateId) {
/*  43 */     this._stateId = (argStateId != null && MANAGE_CASE) ? argStateId.toUpperCase() : argStateId;
/*     */   }
/*     */   
/*     */   public String getAddressMode() {
/*  47 */     return this._addressMode;
/*     */   }
/*     */   
/*     */   public void setAddressMode(String argAddressMode) {
/*  51 */     this._addressMode = (argAddressMode != null && MANAGE_CASE) ? argAddressMode.toUpperCase() : argAddressMode;
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
/*  67 */         setCountryId((String)null);
/*     */       } else {
/*     */         
/*  70 */         setCountryId(str);
/*     */       } 
/*  72 */       str = tokens[2];
/*     */       
/*  74 */       if ("null".equals(str)) {
/*  75 */         setStateId((String)null);
/*     */       } else {
/*     */         
/*  78 */         setStateId(str);
/*     */       } 
/*  80 */       str = tokens[3];
/*     */       
/*  82 */       if ("null".equals(str)) {
/*  83 */         setAddressMode((String)null);
/*     */       } else {
/*     */         
/*  86 */         setAddressMode(str);
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
/*  99 */     if (!(ob instanceof AddressStateId)) {
/* 100 */       return false;
/*     */     }
/* 102 */     AddressStateId other = (AddressStateId)ob;
/* 103 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 106 */       .equals(other._organizationId))) && ((this._countryId == null && other._countryId == null) || (this._countryId != null && this._countryId
/*     */ 
/*     */       
/* 109 */       .equals(other._countryId))) && ((this._stateId == null && other._stateId == null) || (this._stateId != null && this._stateId
/*     */ 
/*     */       
/* 112 */       .equals(other._stateId))) && ((this._addressMode == null && other._addressMode == null) || (this._addressMode != null && this._addressMode
/*     */ 
/*     */       
/* 115 */       .equals(other._addressMode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 122 */       .hashCode()) + ((this._countryId == null) ? 0 : this._countryId
/* 123 */       .hashCode()) + ((this._stateId == null) ? 0 : this._stateId
/* 124 */       .hashCode()) + ((this._addressMode == null) ? 0 : this._addressMode
/* 125 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 130 */     return "AddressState";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 135 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 137 */     return buff.append(
/* 138 */         String.valueOf(this._organizationId))
/* 139 */       .append("::").append(this._countryId)
/* 140 */       .append("::").append(this._stateId)
/* 141 */       .append("::").append(this._addressMode)
/* 142 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 146 */     if (this._countryId == null) {
/* 147 */       return false;
/*     */     }
/* 149 */     if (this._stateId == null) {
/* 150 */       return false;
/*     */     }
/* 152 */     if (this._addressMode == null) {
/* 153 */       return false;
/*     */     }
/* 155 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\AddressStateId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */