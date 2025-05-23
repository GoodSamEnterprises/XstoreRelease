/*     */ package dtv.xst.dao.cwo.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cwo.CategoryServiceLocationId;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CategoryServiceLocationDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 2138160268L;
/*  23 */   private static final Logger _logger = Logger.getLogger(CategoryServiceLocationDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _serviceLocationId;
/*     */   private String _categoryId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private BigDecimal _leadTimeQuantity;
/*     */   private String _leadTimeUnit;
/*  36 */   private Boolean _createShipment = Boolean.FALSE;
/*     */   
/*     */   public Long getOrganizationId() {
/*  39 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  43 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  44 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getServiceLocationId() {
/*  49 */     return this._serviceLocationId;
/*     */   }
/*     */   
/*     */   public void setServiceLocationId(String argServiceLocationId) {
/*  53 */     if (changed(argServiceLocationId, this._serviceLocationId, "serviceLocationId")) {
/*  54 */       this._serviceLocationId = (argServiceLocationId != null && MANAGE_CASE) ? argServiceLocationId.toUpperCase() : argServiceLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCategoryId() {
/*  59 */     return this._categoryId;
/*     */   }
/*     */   
/*     */   public void setCategoryId(String argCategoryId) {
/*  63 */     if (changed(argCategoryId, this._categoryId, "categoryId")) {
/*  64 */       this._categoryId = (argCategoryId != null && MANAGE_CASE) ? argCategoryId.toUpperCase() : argCategoryId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  69 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  73 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  74 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  80 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  84 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  85 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  90 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  94 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  95 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 101 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 105 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 106 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/* 111 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 115 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/* 116 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/* 121 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 125 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/* 126 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getLeadTimeQuantity() {
/* 131 */     return this._leadTimeQuantity;
/*     */   }
/*     */   
/*     */   public void setLeadTimeQuantity(BigDecimal argLeadTimeQuantity) {
/* 135 */     if (changed(argLeadTimeQuantity, this._leadTimeQuantity, "leadTimeQuantity")) {
/* 136 */       this._leadTimeQuantity = argLeadTimeQuantity;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLeadTimeUnit() {
/* 141 */     return this._leadTimeUnit;
/*     */   }
/*     */   
/*     */   public void setLeadTimeUnit(String argLeadTimeUnit) {
/* 145 */     if (changed(argLeadTimeUnit, this._leadTimeUnit, "leadTimeUnit")) {
/* 146 */       this._leadTimeUnit = argLeadTimeUnit;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getCreateShipment() {
/* 151 */     return this._createShipment;
/*     */   }
/*     */   
/*     */   public void setCreateShipment(Boolean argCreateShipment) {
/* 155 */     if (changed(argCreateShipment, this._createShipment, "createShipment")) {
/* 156 */       this._createShipment = argCreateShipment;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 163 */     StringBuilder buf = new StringBuilder(512);
/* 164 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 165 */     if (getOrganizationId() != null) {
/* 166 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 168 */     if (getServiceLocationId() != null) {
/* 169 */       buf.append("serviceLocationId").append("=").append(getServiceLocationId()).append(" ");
/*     */     }
/* 171 */     if (getCategoryId() != null) {
/* 172 */       buf.append("categoryId").append("=").append(getCategoryId()).append(" ");
/*     */     }
/* 174 */     if (getCreateDate() != null) {
/* 175 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 177 */     if (getCreateUserId() != null) {
/* 178 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 180 */     if (getUpdateDate() != null) {
/* 181 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 183 */     if (getUpdateUserId() != null) {
/* 184 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 186 */     if (getOrgCode() != null) {
/* 187 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 189 */     if (getOrgValue() != null) {
/* 190 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 192 */     if (getLeadTimeQuantity() != null) {
/* 193 */       buf.append("leadTimeQuantity").append("=").append(getLeadTimeQuantity()).append(" ");
/*     */     }
/* 195 */     if (getLeadTimeUnit() != null) {
/* 196 */       buf.append("leadTimeUnit").append("=").append(getLeadTimeUnit()).append(" ");
/*     */     }
/* 198 */     if (getCreateShipment() != null && getCreateShipment().booleanValue()) {
/* 199 */       buf.append("createShipment").append("=").append(getCreateShipment()).append(" ");
/*     */     }
/*     */     
/* 202 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 206 */     CategoryServiceLocationId id = new CategoryServiceLocationId();
/* 207 */     id.setOrganizationId(getOrganizationId());
/* 208 */     id.setServiceLocationId(getServiceLocationId());
/* 209 */     id.setCategoryId(getCategoryId());
/* 210 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 214 */     setOrganizationId(((CategoryServiceLocationId)argObjectId).getOrganizationId());
/* 215 */     setServiceLocationId(((CategoryServiceLocationId)argObjectId).getServiceLocationId());
/* 216 */     setCategoryId(((CategoryServiceLocationId)argObjectId).getCategoryId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 220 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 224 */     StringBuilder buf = new StringBuilder(600);
/* 225 */     buf.append("<").append("dao").append(" name=\"CategoryServiceLocation\" cmd=\"" + getObjectStateString() + "\">");
/* 226 */     getFieldsAsXml(buf);
/* 227 */     buf.append("</").append("dao").append(">");
/*     */     
/* 229 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 233 */     Map<String, String> values = super.getValues();
/* 234 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 235 */     if (this._serviceLocationId != null) values.put("ServiceLocationId", DaoUtils.getXmlSafeFieldValue(12, this._serviceLocationId)); 
/* 236 */     if (this._categoryId != null) values.put("CategoryId", DaoUtils.getXmlSafeFieldValue(12, this._categoryId)); 
/* 237 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 238 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 239 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 240 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 241 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 242 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 243 */     if (this._leadTimeQuantity != null) values.put("LeadTimeQuantity", DaoUtils.getXmlSafeFieldValue(3, this._leadTimeQuantity)); 
/* 244 */     if (this._leadTimeUnit != null) values.put("LeadTimeUnit", DaoUtils.getXmlSafeFieldValue(12, this._leadTimeUnit)); 
/* 245 */     if (this._createShipment != null) values.put("CreateShipment", DaoUtils.getXmlSafeFieldValue(-7, this._createShipment)); 
/* 246 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 251 */     super.setValues(argValues);
/* 252 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 254 */       String fieldName = field.getKey();
/* 255 */       String fieldValue = field.getValue();
/* 256 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 260 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 261 */             setOrganizationId((Long)value);
/* 262 */           } catch (Exception ee) {
/* 263 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ServiceLocationId":
/*     */           try {
/* 269 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 270 */             setServiceLocationId((String)value);
/* 271 */           } catch (Exception ee) {
/* 272 */             throw new DtxException("An exception occurred while calling setServiceLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CategoryId":
/*     */           try {
/* 278 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 279 */             setCategoryId((String)value);
/* 280 */           } catch (Exception ee) {
/* 281 */             throw new DtxException("An exception occurred while calling setCategoryId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 287 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 288 */             setCreateDate((Date)value);
/* 289 */           } catch (Exception ee) {
/* 290 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 296 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 297 */             setCreateUserId((String)value);
/* 298 */           } catch (Exception ee) {
/* 299 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 305 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 306 */             setUpdateDate((Date)value);
/* 307 */           } catch (Exception ee) {
/* 308 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 314 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 315 */             setUpdateUserId((String)value);
/* 316 */           } catch (Exception ee) {
/* 317 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 323 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 324 */             setOrgCode((String)value);
/* 325 */           } catch (Exception ee) {
/* 326 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 332 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 333 */             setOrgValue((String)value);
/* 334 */           } catch (Exception ee) {
/* 335 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LeadTimeQuantity":
/*     */           try {
/* 341 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 342 */             setLeadTimeQuantity((BigDecimal)value);
/* 343 */           } catch (Exception ee) {
/* 344 */             throw new DtxException("An exception occurred while calling setLeadTimeQuantity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LeadTimeUnit":
/*     */           try {
/* 350 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 351 */             setLeadTimeUnit((String)value);
/* 352 */           } catch (Exception ee) {
/* 353 */             throw new DtxException("An exception occurred while calling setLeadTimeUnit() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateShipment":
/*     */           try {
/* 359 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 360 */             setCreateShipment((Boolean)value);
/* 361 */           } catch (Exception ee) {
/* 362 */             throw new DtxException("An exception occurred while calling setCreateShipment() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\impl\CategoryServiceLocationDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */