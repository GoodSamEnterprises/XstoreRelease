/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.ItemRestrictionMappingId;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemRestrictionMappingDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1762616309L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ItemRestrictionMappingDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _merchHierarchyLevel;
/*     */   private String _merchHierarchyId;
/*     */   private String _restrictionCategory;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   
/*     */   public Long getOrganizationId() {
/*  37 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  41 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  42 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getMerchHierarchyLevel() {
/*  47 */     return this._merchHierarchyLevel;
/*     */   }
/*     */   
/*     */   public void setMerchHierarchyLevel(String argMerchHierarchyLevel) {
/*  51 */     if (changed(argMerchHierarchyLevel, this._merchHierarchyLevel, "merchHierarchyLevel")) {
/*  52 */       this._merchHierarchyLevel = (argMerchHierarchyLevel != null && MANAGE_CASE) ? argMerchHierarchyLevel.toUpperCase() : argMerchHierarchyLevel;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getMerchHierarchyId() {
/*  57 */     return this._merchHierarchyId;
/*     */   }
/*     */   
/*     */   public void setMerchHierarchyId(String argMerchHierarchyId) {
/*  61 */     if (changed(argMerchHierarchyId, this._merchHierarchyId, "merchHierarchyId")) {
/*  62 */       this._merchHierarchyId = (argMerchHierarchyId != null && MANAGE_CASE) ? argMerchHierarchyId.toUpperCase() : argMerchHierarchyId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getRestrictionCategory() {
/*  67 */     return this._restrictionCategory;
/*     */   }
/*     */   
/*     */   public void setRestrictionCategory(String argRestrictionCategory) {
/*  71 */     if (changed(argRestrictionCategory, this._restrictionCategory, "restrictionCategory")) {
/*  72 */       this._restrictionCategory = (argRestrictionCategory != null && MANAGE_CASE) ? argRestrictionCategory.toUpperCase() : argRestrictionCategory;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/*  77 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/*  81 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/*  82 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/*  87 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/*  91 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/*  92 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  97 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 101 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 102 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 108 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 112 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 113 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 118 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 122 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 123 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 129 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 133 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 134 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 141 */     StringBuilder buf = new StringBuilder(512);
/* 142 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 143 */     if (getOrganizationId() != null) {
/* 144 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 146 */     if (getMerchHierarchyLevel() != null) {
/* 147 */       buf.append("merchHierarchyLevel").append("=").append(getMerchHierarchyLevel()).append(" ");
/*     */     }
/* 149 */     if (getMerchHierarchyId() != null) {
/* 150 */       buf.append("merchHierarchyId").append("=").append(getMerchHierarchyId()).append(" ");
/*     */     }
/* 152 */     if (getRestrictionCategory() != null) {
/* 153 */       buf.append("restrictionCategory").append("=").append(getRestrictionCategory()).append(" ");
/*     */     }
/* 155 */     if (getOrgCode() != null) {
/* 156 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 158 */     if (getOrgValue() != null) {
/* 159 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 161 */     if (getCreateDate() != null) {
/* 162 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 164 */     if (getCreateUserId() != null) {
/* 165 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 167 */     if (getUpdateDate() != null) {
/* 168 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 170 */     if (getUpdateUserId() != null) {
/* 171 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/*     */     
/* 174 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 178 */     ItemRestrictionMappingId id = new ItemRestrictionMappingId();
/* 179 */     id.setOrganizationId(getOrganizationId());
/* 180 */     id.setMerchHierarchyLevel(getMerchHierarchyLevel());
/* 181 */     id.setMerchHierarchyId(getMerchHierarchyId());
/* 182 */     id.setRestrictionCategory(getRestrictionCategory());
/* 183 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 187 */     setOrganizationId(((ItemRestrictionMappingId)argObjectId).getOrganizationId());
/* 188 */     setMerchHierarchyLevel(((ItemRestrictionMappingId)argObjectId).getMerchHierarchyLevel());
/* 189 */     setMerchHierarchyId(((ItemRestrictionMappingId)argObjectId).getMerchHierarchyId());
/* 190 */     setRestrictionCategory(((ItemRestrictionMappingId)argObjectId).getRestrictionCategory());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 194 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 198 */     StringBuilder buf = new StringBuilder(500);
/* 199 */     buf.append("<").append("dao").append(" name=\"ItemRestrictionMapping\" cmd=\"" + getObjectStateString() + "\">");
/* 200 */     getFieldsAsXml(buf);
/* 201 */     buf.append("</").append("dao").append(">");
/*     */     
/* 203 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 207 */     Map<String, String> values = super.getValues();
/* 208 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 209 */     if (this._merchHierarchyLevel != null) values.put("MerchHierarchyLevel", DaoUtils.getXmlSafeFieldValue(12, this._merchHierarchyLevel)); 
/* 210 */     if (this._merchHierarchyId != null) values.put("MerchHierarchyId", DaoUtils.getXmlSafeFieldValue(12, this._merchHierarchyId)); 
/* 211 */     if (this._restrictionCategory != null) values.put("RestrictionCategory", DaoUtils.getXmlSafeFieldValue(12, this._restrictionCategory)); 
/* 212 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 213 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 214 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 215 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 216 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 217 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 218 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 223 */     super.setValues(argValues);
/* 224 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 226 */       String fieldName = field.getKey();
/* 227 */       String fieldValue = field.getValue();
/* 228 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 232 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 233 */             setOrganizationId((Long)value);
/* 234 */           } catch (Exception ee) {
/* 235 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MerchHierarchyLevel":
/*     */           try {
/* 241 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 242 */             setMerchHierarchyLevel((String)value);
/* 243 */           } catch (Exception ee) {
/* 244 */             throw new DtxException("An exception occurred while calling setMerchHierarchyLevel() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MerchHierarchyId":
/*     */           try {
/* 250 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 251 */             setMerchHierarchyId((String)value);
/* 252 */           } catch (Exception ee) {
/* 253 */             throw new DtxException("An exception occurred while calling setMerchHierarchyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RestrictionCategory":
/*     */           try {
/* 259 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 260 */             setRestrictionCategory((String)value);
/* 261 */           } catch (Exception ee) {
/* 262 */             throw new DtxException("An exception occurred while calling setRestrictionCategory() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 268 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 269 */             setOrgCode((String)value);
/* 270 */           } catch (Exception ee) {
/* 271 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 277 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 278 */             setOrgValue((String)value);
/* 279 */           } catch (Exception ee) {
/* 280 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 286 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 287 */             setCreateDate((Date)value);
/* 288 */           } catch (Exception ee) {
/* 289 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 295 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 296 */             setCreateUserId((String)value);
/* 297 */           } catch (Exception ee) {
/* 298 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 304 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 305 */             setUpdateDate((Date)value);
/* 306 */           } catch (Exception ee) {
/* 307 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 313 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 314 */             setUpdateUserId((String)value);
/* 315 */           } catch (Exception ee) {
/* 316 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemRestrictionMappingDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */