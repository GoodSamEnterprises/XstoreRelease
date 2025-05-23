/*     */ package dtv.xst.dao.tnd;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.IHasConfigElement;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ public class TenderUserSettingsId
/*     */   extends AbstractObjectId
/*     */   implements IHasConfigElement
/*     */ {
/*     */   private static final long serialVersionUID = -576227806L;
/*     */   private String _groupId;
/*     */   private String _tenderId;
/*     */   private String _usageCode;
/*     */   private String _entryMethodCode;
/*     */   private String _configElement;
/*     */   
/*     */   public IObjectId getObjectId() {
/*  21 */     return (IObjectId)this;
/*     */   }
/*     */ 
/*     */   
/*     */   public TenderUserSettingsId() {}
/*     */ 
/*     */   
/*     */   public TenderUserSettingsId(String argObjectIdValue) {
/*  29 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getGroupId() {
/*  39 */     return this._groupId;
/*     */   }
/*     */   
/*     */   public void setGroupId(String argGroupId) {
/*  43 */     this._groupId = (argGroupId != null && MANAGE_CASE) ? argGroupId.toUpperCase() : argGroupId;
/*     */   }
/*     */   
/*     */   public String getTenderId() {
/*  47 */     return this._tenderId;
/*     */   }
/*     */   
/*     */   public void setTenderId(String argTenderId) {
/*  51 */     this._tenderId = (argTenderId != null && MANAGE_CASE) ? argTenderId.toUpperCase() : argTenderId;
/*     */   }
/*     */   
/*     */   public String getUsageCode() {
/*  55 */     return this._usageCode;
/*     */   }
/*     */   
/*     */   public void setUsageCode(String argUsageCode) {
/*  59 */     this._usageCode = (argUsageCode != null && MANAGE_CASE) ? argUsageCode.toUpperCase() : argUsageCode;
/*     */   }
/*     */   
/*     */   public String getEntryMethodCode() {
/*  63 */     return this._entryMethodCode;
/*     */   }
/*     */   
/*     */   public void setEntryMethodCode(String argEntryMethodCode) {
/*  67 */     this._entryMethodCode = (argEntryMethodCode != null && MANAGE_CASE) ? argEntryMethodCode.toUpperCase() : argEntryMethodCode;
/*     */   }
/*     */   
/*     */   public String getConfigElement() {
/*  71 */     return this._configElement;
/*     */   }
/*     */   
/*     */   public void setConfigElement(String argConfigElement) {
/*  75 */     this._configElement = (argConfigElement != null && MANAGE_CASE) ? argConfigElement.toUpperCase() : argConfigElement;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  79 */     String str = argObjectIdValue;
/*  80 */     if (StringUtils.isEmpty(str)) {
/*  81 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  84 */       String[] tokens = str.split("::");
/*  85 */       str = tokens[0];
/*     */       
/*  87 */       if ("null".equals(str)) {
/*  88 */         setGroupId((String)null);
/*     */       } else {
/*     */         
/*  91 */         setGroupId(str);
/*     */       } 
/*  93 */       str = tokens[1];
/*     */       
/*  95 */       setOrganizationId(Long.valueOf(str));
/*  96 */       str = tokens[2];
/*     */       
/*  98 */       if ("null".equals(str)) {
/*  99 */         setTenderId((String)null);
/*     */       } else {
/*     */         
/* 102 */         setTenderId(str);
/*     */       } 
/* 104 */       str = tokens[3];
/*     */       
/* 106 */       if ("null".equals(str)) {
/* 107 */         setUsageCode((String)null);
/*     */       } else {
/*     */         
/* 110 */         setUsageCode(str);
/*     */       } 
/* 112 */       str = tokens[4];
/*     */       
/* 114 */       if ("null".equals(str)) {
/* 115 */         setEntryMethodCode((String)null);
/*     */       } else {
/*     */         
/* 118 */         setEntryMethodCode(str);
/*     */       } 
/* 120 */       str = tokens[5];
/*     */       
/* 122 */       if ("null".equals(str)) {
/* 123 */         setConfigElement((String)null);
/*     */       } else {
/*     */         
/* 126 */         setConfigElement(str);
/*     */       }
/*     */     
/* 129 */     } catch (Exception ee) {
/* 130 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 136 */     if (this == ob) {
/* 137 */       return true;
/*     */     }
/* 139 */     if (!(ob instanceof TenderUserSettingsId)) {
/* 140 */       return false;
/*     */     }
/* 142 */     TenderUserSettingsId other = (TenderUserSettingsId)ob;
/* 143 */     return (((this._groupId == null && other._groupId == null) || (this._groupId != null && this._groupId
/*     */ 
/*     */       
/* 146 */       .equals(other._groupId))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 149 */       .equals(other._organizationId))) && ((this._tenderId == null && other._tenderId == null) || (this._tenderId != null && this._tenderId
/*     */ 
/*     */       
/* 152 */       .equals(other._tenderId))) && ((this._usageCode == null && other._usageCode == null) || (this._usageCode != null && this._usageCode
/*     */ 
/*     */       
/* 155 */       .equals(other._usageCode))) && ((this._entryMethodCode == null && other._entryMethodCode == null) || (this._entryMethodCode != null && this._entryMethodCode
/*     */ 
/*     */       
/* 158 */       .equals(other._entryMethodCode))) && ((this._configElement == null && other._configElement == null) || (this._configElement != null && this._configElement
/*     */ 
/*     */       
/* 161 */       .equals(other._configElement))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 167 */     return ((this._groupId == null) ? 0 : this._groupId
/* 168 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 169 */       .hashCode()) + ((this._tenderId == null) ? 0 : this._tenderId
/* 170 */       .hashCode()) + ((this._usageCode == null) ? 0 : this._usageCode
/* 171 */       .hashCode()) + ((this._entryMethodCode == null) ? 0 : this._entryMethodCode
/* 172 */       .hashCode()) + ((this._configElement == null) ? 0 : this._configElement
/* 173 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 178 */     return "TenderUserSettings";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 183 */     StringBuilder buff = new StringBuilder(72);
/*     */     
/* 185 */     return buff.append(this._groupId)
/*     */       
/* 187 */       .append("::").append(String.valueOf(this._organizationId))
/* 188 */       .append("::").append(this._tenderId)
/* 189 */       .append("::").append(this._usageCode)
/* 190 */       .append("::").append(this._entryMethodCode)
/* 191 */       .append("::").append(this._configElement)
/* 192 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 196 */     if (this._groupId == null) {
/* 197 */       return false;
/*     */     }
/* 199 */     if (this._tenderId == null) {
/* 200 */       return false;
/*     */     }
/* 202 */     if (this._usageCode == null) {
/* 203 */       return false;
/*     */     }
/* 205 */     if (this._entryMethodCode == null) {
/* 206 */       return false;
/*     */     }
/* 208 */     if (this._configElement == null) {
/* 209 */       return false;
/*     */     }
/* 211 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tnd\TenderUserSettingsId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */