/*     */ package dtv.xst.dao.prc.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.prc.DealCustomerGroupsId;
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
/*     */ public class DealCustomerGroupsDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1930313986L;
/*  23 */   private static final Logger _logger = Logger.getLogger(DealCustomerGroupsDAO.class);
/*     */   
/*     */   private String _dealId;
/*     */   private Long _organizationId;
/*     */   private String _customerGroupId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   
/*     */   public String getDealId() {
/*  36 */     return this._dealId;
/*     */   }
/*     */   
/*     */   public void setDealId(String argDealId) {
/*  40 */     if (changed(argDealId, this._dealId, "dealId")) {
/*  41 */       this._dealId = (argDealId != null && MANAGE_CASE) ? argDealId.toUpperCase() : argDealId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  46 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  50 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  51 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustomerGroupId() {
/*  56 */     return this._customerGroupId;
/*     */   }
/*     */   
/*     */   public void setCustomerGroupId(String argCustomerGroupId) {
/*  60 */     if (changed(argCustomerGroupId, this._customerGroupId, "customerGroupId")) {
/*  61 */       this._customerGroupId = (argCustomerGroupId != null && MANAGE_CASE) ? argCustomerGroupId.toUpperCase() : argCustomerGroupId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/*  66 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/*  70 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/*  71 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/*  76 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/*  80 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/*  81 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  86 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  90 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  91 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  97 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 101 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 102 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 107 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 111 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 112 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 118 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 122 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 123 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 130 */     StringBuilder buf = new StringBuilder(512);
/* 131 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 132 */     if (getDealId() != null) {
/* 133 */       buf.append("dealId").append("=").append(getDealId()).append(" ");
/*     */     }
/* 135 */     if (getOrganizationId() != null) {
/* 136 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 138 */     if (getCustomerGroupId() != null) {
/* 139 */       buf.append("customerGroupId").append("=").append(getCustomerGroupId()).append(" ");
/*     */     }
/* 141 */     if (getOrgCode() != null) {
/* 142 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 144 */     if (getOrgValue() != null) {
/* 145 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 147 */     if (getCreateDate() != null) {
/* 148 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 150 */     if (getCreateUserId() != null) {
/* 151 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 153 */     if (getUpdateDate() != null) {
/* 154 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 156 */     if (getUpdateUserId() != null) {
/* 157 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/*     */     
/* 160 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 164 */     DealCustomerGroupsId id = new DealCustomerGroupsId();
/* 165 */     id.setDealId(getDealId());
/* 166 */     id.setOrganizationId(getOrganizationId());
/* 167 */     id.setCustomerGroupId(getCustomerGroupId());
/* 168 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 172 */     setDealId(((DealCustomerGroupsId)argObjectId).getDealId());
/* 173 */     setOrganizationId(((DealCustomerGroupsId)argObjectId).getOrganizationId());
/* 174 */     setCustomerGroupId(((DealCustomerGroupsId)argObjectId).getCustomerGroupId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 178 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 182 */     StringBuilder buf = new StringBuilder(450);
/* 183 */     buf.append("<").append("dao").append(" name=\"DealCustomerGroups\" cmd=\"" + getObjectStateString() + "\">");
/* 184 */     getFieldsAsXml(buf);
/* 185 */     buf.append("</").append("dao").append(">");
/*     */     
/* 187 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 191 */     Map<String, String> values = super.getValues();
/* 192 */     if (this._dealId != null) values.put("DealId", DaoUtils.getXmlSafeFieldValue(12, this._dealId)); 
/* 193 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 194 */     if (this._customerGroupId != null) values.put("CustomerGroupId", DaoUtils.getXmlSafeFieldValue(12, this._customerGroupId)); 
/* 195 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 196 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 197 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 198 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 199 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 200 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 201 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 206 */     super.setValues(argValues);
/* 207 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 209 */       String fieldName = field.getKey();
/* 210 */       String fieldValue = field.getValue();
/* 211 */       switch (fieldName) {
/*     */         
/*     */         case "DealId":
/*     */           try {
/* 215 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 216 */             setDealId((String)value);
/* 217 */           } catch (Exception ee) {
/* 218 */             throw new DtxException("An exception occurred while calling setDealId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 224 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 225 */             setOrganizationId((Long)value);
/* 226 */           } catch (Exception ee) {
/* 227 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustomerGroupId":
/*     */           try {
/* 233 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 234 */             setCustomerGroupId((String)value);
/* 235 */           } catch (Exception ee) {
/* 236 */             throw new DtxException("An exception occurred while calling setCustomerGroupId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 242 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 243 */             setOrgCode((String)value);
/* 244 */           } catch (Exception ee) {
/* 245 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 251 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 252 */             setOrgValue((String)value);
/* 253 */           } catch (Exception ee) {
/* 254 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 260 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 261 */             setCreateDate((Date)value);
/* 262 */           } catch (Exception ee) {
/* 263 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 269 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 270 */             setCreateUserId((String)value);
/* 271 */           } catch (Exception ee) {
/* 272 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 278 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 279 */             setUpdateDate((Date)value);
/* 280 */           } catch (Exception ee) {
/* 281 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 287 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 288 */             setUpdateUserId((String)value);
/* 289 */           } catch (Exception ee) {
/* 290 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\prc\impl\DealCustomerGroupsDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */