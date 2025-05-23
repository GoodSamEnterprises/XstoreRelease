/*     */ package dtv.xst.dao.tnd;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.IHasConfigElement;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ public class TenderUserSettingsPropertyId
/*     */   extends AbstractObjectId
/*     */   implements IHasConfigElement {
/*     */   private static final long serialVersionUID = 1267758615L;
/*     */   private String _groupId;
/*     */   private String _tenderId;
/*     */   private String _usageCode;
/*     */   private String _entryMethodCode;
/*     */   private String _configElement;
/*     */   private String _propertyCode;
/*     */   
/*     */   public IObjectId getObjectId() {
/*  21 */     return (IObjectId)this;
/*     */   }
/*     */ 
/*     */   
/*     */   public TenderUserSettingsPropertyId() {}
/*     */ 
/*     */   
/*     */   public TenderUserSettingsPropertyId(String argObjectIdValue) {
/*  29 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getGroupId() {
/*  40 */     return this._groupId;
/*     */   }
/*     */   
/*     */   public void setGroupId(String argGroupId) {
/*  44 */     this._groupId = (argGroupId != null && MANAGE_CASE) ? argGroupId.toUpperCase() : argGroupId;
/*     */   }
/*     */   
/*     */   public String getTenderId() {
/*  48 */     return this._tenderId;
/*     */   }
/*     */   
/*     */   public void setTenderId(String argTenderId) {
/*  52 */     this._tenderId = (argTenderId != null && MANAGE_CASE) ? argTenderId.toUpperCase() : argTenderId;
/*     */   }
/*     */   
/*     */   public String getUsageCode() {
/*  56 */     return this._usageCode;
/*     */   }
/*     */   
/*     */   public void setUsageCode(String argUsageCode) {
/*  60 */     this._usageCode = (argUsageCode != null && MANAGE_CASE) ? argUsageCode.toUpperCase() : argUsageCode;
/*     */   }
/*     */   
/*     */   public String getEntryMethodCode() {
/*  64 */     return this._entryMethodCode;
/*     */   }
/*     */   
/*     */   public void setEntryMethodCode(String argEntryMethodCode) {
/*  68 */     this._entryMethodCode = (argEntryMethodCode != null && MANAGE_CASE) ? argEntryMethodCode.toUpperCase() : argEntryMethodCode;
/*     */   }
/*     */   
/*     */   public String getConfigElement() {
/*  72 */     return this._configElement;
/*     */   }
/*     */   
/*     */   public void setConfigElement(String argConfigElement) {
/*  76 */     this._configElement = (argConfigElement != null && MANAGE_CASE) ? argConfigElement.toUpperCase() : argConfigElement;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  80 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  84 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  88 */     String str = argObjectIdValue;
/*  89 */     if (StringUtils.isEmpty(str)) {
/*  90 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  93 */       String[] tokens = str.split("::");
/*  94 */       str = tokens[0];
/*     */       
/*  96 */       if ("null".equals(str)) {
/*  97 */         setGroupId((String)null);
/*     */       } else {
/*     */         
/* 100 */         setGroupId(str);
/*     */       } 
/* 102 */       str = tokens[1];
/*     */       
/* 104 */       setOrganizationId(Long.valueOf(str));
/* 105 */       str = tokens[2];
/*     */       
/* 107 */       if ("null".equals(str)) {
/* 108 */         setTenderId((String)null);
/*     */       } else {
/*     */         
/* 111 */         setTenderId(str);
/*     */       } 
/* 113 */       str = tokens[3];
/*     */       
/* 115 */       if ("null".equals(str)) {
/* 116 */         setUsageCode((String)null);
/*     */       } else {
/*     */         
/* 119 */         setUsageCode(str);
/*     */       } 
/* 121 */       str = tokens[4];
/*     */       
/* 123 */       if ("null".equals(str)) {
/* 124 */         setEntryMethodCode((String)null);
/*     */       } else {
/*     */         
/* 127 */         setEntryMethodCode(str);
/*     */       } 
/* 129 */       str = tokens[5];
/*     */       
/* 131 */       if ("null".equals(str)) {
/* 132 */         setConfigElement((String)null);
/*     */       } else {
/*     */         
/* 135 */         setConfigElement(str);
/*     */       } 
/* 137 */       str = tokens[6];
/*     */       
/* 139 */       if ("null".equals(str)) {
/* 140 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 143 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 146 */     } catch (Exception ee) {
/* 147 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 153 */     if (this == ob) {
/* 154 */       return true;
/*     */     }
/* 156 */     if (!(ob instanceof TenderUserSettingsPropertyId)) {
/* 157 */       return false;
/*     */     }
/* 159 */     TenderUserSettingsPropertyId other = (TenderUserSettingsPropertyId)ob;
/* 160 */     return (((this._groupId == null && other._groupId == null) || (this._groupId != null && this._groupId
/*     */ 
/*     */       
/* 163 */       .equals(other._groupId))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 166 */       .equals(other._organizationId))) && ((this._tenderId == null && other._tenderId == null) || (this._tenderId != null && this._tenderId
/*     */ 
/*     */       
/* 169 */       .equals(other._tenderId))) && ((this._usageCode == null && other._usageCode == null) || (this._usageCode != null && this._usageCode
/*     */ 
/*     */       
/* 172 */       .equals(other._usageCode))) && ((this._entryMethodCode == null && other._entryMethodCode == null) || (this._entryMethodCode != null && this._entryMethodCode
/*     */ 
/*     */       
/* 175 */       .equals(other._entryMethodCode))) && ((this._configElement == null && other._configElement == null) || (this._configElement != null && this._configElement
/*     */ 
/*     */       
/* 178 */       .equals(other._configElement))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 181 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 187 */     return ((this._groupId == null) ? 0 : this._groupId
/* 188 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 189 */       .hashCode()) + ((this._tenderId == null) ? 0 : this._tenderId
/* 190 */       .hashCode()) + ((this._usageCode == null) ? 0 : this._usageCode
/* 191 */       .hashCode()) + ((this._entryMethodCode == null) ? 0 : this._entryMethodCode
/* 192 */       .hashCode()) + ((this._configElement == null) ? 0 : this._configElement
/* 193 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 194 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 199 */     return "TenderUserSettingsProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 204 */     StringBuilder buff = new StringBuilder(84);
/*     */     
/* 206 */     return buff.append(this._groupId)
/*     */       
/* 208 */       .append("::").append(String.valueOf(this._organizationId))
/* 209 */       .append("::").append(this._tenderId)
/* 210 */       .append("::").append(this._usageCode)
/* 211 */       .append("::").append(this._entryMethodCode)
/* 212 */       .append("::").append(this._configElement)
/* 213 */       .append("::").append(this._propertyCode)
/* 214 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 218 */     if (this._groupId == null) {
/* 219 */       return false;
/*     */     }
/* 221 */     if (this._tenderId == null) {
/* 222 */       return false;
/*     */     }
/* 224 */     if (this._usageCode == null) {
/* 225 */       return false;
/*     */     }
/* 227 */     if (this._entryMethodCode == null) {
/* 228 */       return false;
/*     */     }
/* 230 */     if (this._configElement == null) {
/* 231 */       return false;
/*     */     }
/* 233 */     if (this._propertyCode == null) {
/* 234 */       return false;
/*     */     }
/* 236 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tnd\TenderUserSettingsPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */