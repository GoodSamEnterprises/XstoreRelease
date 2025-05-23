/*     */ package dtv.xst.dao.dsc.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IHasConfigElement;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.dsc.DiscountGroupMappingId;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DiscountGroupMappingDAO
/*     */   extends AbstractDAOImpl
/*     */   implements IHasConfigElement
/*     */ {
/*     */   private static final long serialVersionUID = -2010226352L;
/*  23 */   private static final Logger _logger = Logger.getLogger(DiscountGroupMappingDAO.class);
/*     */   
/*     */   private String _customerGroupId;
/*     */   private String _discountCode;
/*     */   private Long _organizationId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _configElement;
/*     */   
/*     */   public String getCustomerGroupId() {
/*  35 */     return this._customerGroupId;
/*     */   }
/*     */   
/*     */   public void setCustomerGroupId(String argCustomerGroupId) {
/*  39 */     if (changed(argCustomerGroupId, this._customerGroupId, "customerGroupId")) {
/*  40 */       this._customerGroupId = (argCustomerGroupId != null && MANAGE_CASE) ? argCustomerGroupId.toUpperCase() : argCustomerGroupId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDiscountCode() {
/*  45 */     return this._discountCode;
/*     */   }
/*     */   
/*     */   public void setDiscountCode(String argDiscountCode) {
/*  49 */     if (changed(argDiscountCode, this._discountCode, "discountCode")) {
/*  50 */       this._discountCode = (argDiscountCode != null && MANAGE_CASE) ? argDiscountCode.toUpperCase() : argDiscountCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  55 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  59 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  60 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  65 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  69 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  70 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  76 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  80 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  81 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  86 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  90 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  91 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  97 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 101 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 102 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getConfigElement() {
/* 107 */     return this._configElement;
/*     */   }
/*     */   
/*     */   public void setConfigElement(String argConfigElement) {
/* 111 */     if (changed(argConfigElement, this._configElement, "configElement")) {
/* 112 */       this._configElement = argConfigElement;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 119 */     StringBuilder buf = new StringBuilder(512);
/* 120 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 121 */     if (getCustomerGroupId() != null) {
/* 122 */       buf.append("customerGroupId").append("=").append(getCustomerGroupId()).append(" ");
/*     */     }
/* 124 */     if (getDiscountCode() != null) {
/* 125 */       buf.append("discountCode").append("=").append(getDiscountCode()).append(" ");
/*     */     }
/* 127 */     if (getOrganizationId() != null) {
/* 128 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 130 */     if (getCreateDate() != null) {
/* 131 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 133 */     if (getCreateUserId() != null) {
/* 134 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 136 */     if (getUpdateDate() != null) {
/* 137 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 139 */     if (getUpdateUserId() != null) {
/* 140 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 142 */     if (getConfigElement() != null) {
/* 143 */       buf.append("configElement").append("=").append(getConfigElement()).append(" ");
/*     */     }
/*     */     
/* 146 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 150 */     DiscountGroupMappingId id = new DiscountGroupMappingId();
/* 151 */     id.setCustomerGroupId(getCustomerGroupId());
/* 152 */     id.setDiscountCode(getDiscountCode());
/* 153 */     id.setOrganizationId(getOrganizationId());
/* 154 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 158 */     setCustomerGroupId(((DiscountGroupMappingId)argObjectId).getCustomerGroupId());
/* 159 */     setDiscountCode(((DiscountGroupMappingId)argObjectId).getDiscountCode());
/* 160 */     setOrganizationId(((DiscountGroupMappingId)argObjectId).getOrganizationId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 164 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 168 */     StringBuilder buf = new StringBuilder(400);
/* 169 */     buf.append("<").append("dao").append(" name=\"DiscountGroupMapping\" cmd=\"" + getObjectStateString() + "\">");
/* 170 */     getFieldsAsXml(buf);
/* 171 */     buf.append("</").append("dao").append(">");
/*     */     
/* 173 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 177 */     Map<String, String> values = super.getValues();
/* 178 */     if (this._customerGroupId != null) values.put("CustomerGroupId", DaoUtils.getXmlSafeFieldValue(12, this._customerGroupId)); 
/* 179 */     if (this._discountCode != null) values.put("DiscountCode", DaoUtils.getXmlSafeFieldValue(12, this._discountCode)); 
/* 180 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 181 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 182 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 183 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 184 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 185 */     if (this._configElement != null) values.put("ConfigElement", DaoUtils.getXmlSafeFieldValue(12, this._configElement)); 
/* 186 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 191 */     super.setValues(argValues);
/* 192 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 194 */       String fieldName = field.getKey();
/* 195 */       String fieldValue = field.getValue();
/* 196 */       switch (fieldName) {
/*     */         
/*     */         case "CustomerGroupId":
/*     */           try {
/* 200 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 201 */             setCustomerGroupId((String)value);
/* 202 */           } catch (Exception ee) {
/* 203 */             throw new DtxException("An exception occurred while calling setCustomerGroupId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DiscountCode":
/*     */           try {
/* 209 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 210 */             setDiscountCode((String)value);
/* 211 */           } catch (Exception ee) {
/* 212 */             throw new DtxException("An exception occurred while calling setDiscountCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 218 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 219 */             setOrganizationId((Long)value);
/* 220 */           } catch (Exception ee) {
/* 221 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 227 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 228 */             setCreateDate((Date)value);
/* 229 */           } catch (Exception ee) {
/* 230 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 236 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 237 */             setCreateUserId((String)value);
/* 238 */           } catch (Exception ee) {
/* 239 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 245 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 246 */             setUpdateDate((Date)value);
/* 247 */           } catch (Exception ee) {
/* 248 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 254 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 255 */             setUpdateUserId((String)value);
/* 256 */           } catch (Exception ee) {
/* 257 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ConfigElement":
/*     */           try {
/* 263 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 264 */             setConfigElement((String)value);
/* 265 */           } catch (Exception ee) {
/* 266 */             throw new DtxException("An exception occurred while calling setConfigElement() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\dsc\impl\DiscountGroupMappingDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */