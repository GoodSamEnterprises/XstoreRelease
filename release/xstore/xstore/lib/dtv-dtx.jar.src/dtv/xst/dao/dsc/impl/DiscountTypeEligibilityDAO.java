/*     */ package dtv.xst.dao.dsc.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IHasConfigElement;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.dsc.DiscountTypeEligibilityId;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DiscountTypeEligibilityDAO
/*     */   extends AbstractDAOImpl
/*     */   implements IHasConfigElement
/*     */ {
/*     */   private static final long serialVersionUID = -853580718L;
/*  23 */   private static final Logger _logger = Logger.getLogger(DiscountTypeEligibilityDAO.class);
/*     */   
/*     */   private String _discountCode;
/*     */   private Long _organizationId;
/*     */   private String _saleLineItemTypeCode;
/*     */   private String _configElement;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   
/*     */   public String getDiscountCode() {
/*  35 */     return this._discountCode;
/*     */   }
/*     */   
/*     */   public void setDiscountCode(String argDiscountCode) {
/*  39 */     if (changed(argDiscountCode, this._discountCode, "discountCode")) {
/*  40 */       this._discountCode = (argDiscountCode != null && MANAGE_CASE) ? argDiscountCode.toUpperCase() : argDiscountCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  45 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  49 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  50 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSaleLineItemTypeCode() {
/*  55 */     return this._saleLineItemTypeCode;
/*     */   }
/*     */   
/*     */   public void setSaleLineItemTypeCode(String argSaleLineItemTypeCode) {
/*  59 */     if (changed(argSaleLineItemTypeCode, this._saleLineItemTypeCode, "saleLineItemTypeCode")) {
/*  60 */       this._saleLineItemTypeCode = (argSaleLineItemTypeCode != null && MANAGE_CASE) ? argSaleLineItemTypeCode.toUpperCase() : argSaleLineItemTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getConfigElement() {
/*  65 */     return this._configElement;
/*     */   }
/*     */   
/*     */   public void setConfigElement(String argConfigElement) {
/*  69 */     if (changed(argConfigElement, this._configElement, "configElement")) {
/*  70 */       this._configElement = argConfigElement;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  75 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  79 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  80 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  86 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  90 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  91 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  96 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 100 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 101 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 107 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 111 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 112 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 119 */     StringBuilder buf = new StringBuilder(512);
/* 120 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 121 */     if (getDiscountCode() != null) {
/* 122 */       buf.append("discountCode").append("=").append(getDiscountCode()).append(" ");
/*     */     }
/* 124 */     if (getOrganizationId() != null) {
/* 125 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 127 */     if (getSaleLineItemTypeCode() != null) {
/* 128 */       buf.append("saleLineItemTypeCode").append("=").append(getSaleLineItemTypeCode()).append(" ");
/*     */     }
/* 130 */     if (getConfigElement() != null) {
/* 131 */       buf.append("configElement").append("=").append(getConfigElement()).append(" ");
/*     */     }
/* 133 */     if (getCreateDate() != null) {
/* 134 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 136 */     if (getCreateUserId() != null) {
/* 137 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 139 */     if (getUpdateDate() != null) {
/* 140 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 142 */     if (getUpdateUserId() != null) {
/* 143 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/*     */     
/* 146 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 150 */     DiscountTypeEligibilityId id = new DiscountTypeEligibilityId();
/* 151 */     id.setDiscountCode(getDiscountCode());
/* 152 */     id.setOrganizationId(getOrganizationId());
/* 153 */     id.setSaleLineItemTypeCode(getSaleLineItemTypeCode());
/* 154 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 158 */     setDiscountCode(((DiscountTypeEligibilityId)argObjectId).getDiscountCode());
/* 159 */     setOrganizationId(((DiscountTypeEligibilityId)argObjectId).getOrganizationId());
/* 160 */     setSaleLineItemTypeCode(((DiscountTypeEligibilityId)argObjectId).getSaleLineItemTypeCode());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 164 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 168 */     StringBuilder buf = new StringBuilder(400);
/* 169 */     buf.append("<").append("dao").append(" name=\"DiscountTypeEligibility\" cmd=\"" + getObjectStateString() + "\">");
/* 170 */     getFieldsAsXml(buf);
/* 171 */     buf.append("</").append("dao").append(">");
/*     */     
/* 173 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 177 */     Map<String, String> values = super.getValues();
/* 178 */     if (this._discountCode != null) values.put("DiscountCode", DaoUtils.getXmlSafeFieldValue(12, this._discountCode)); 
/* 179 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 180 */     if (this._saleLineItemTypeCode != null) values.put("SaleLineItemTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._saleLineItemTypeCode)); 
/* 181 */     if (this._configElement != null) values.put("ConfigElement", DaoUtils.getXmlSafeFieldValue(12, this._configElement)); 
/* 182 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 183 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 184 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 185 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
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
/*     */         case "DiscountCode":
/*     */           try {
/* 200 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 201 */             setDiscountCode((String)value);
/* 202 */           } catch (Exception ee) {
/* 203 */             throw new DtxException("An exception occurred while calling setDiscountCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 209 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 210 */             setOrganizationId((Long)value);
/* 211 */           } catch (Exception ee) {
/* 212 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SaleLineItemTypeCode":
/*     */           try {
/* 218 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 219 */             setSaleLineItemTypeCode((String)value);
/* 220 */           } catch (Exception ee) {
/* 221 */             throw new DtxException("An exception occurred while calling setSaleLineItemTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ConfigElement":
/*     */           try {
/* 227 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 228 */             setConfigElement((String)value);
/* 229 */           } catch (Exception ee) {
/* 230 */             throw new DtxException("An exception occurred while calling setConfigElement() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 236 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 237 */             setCreateDate((Date)value);
/* 238 */           } catch (Exception ee) {
/* 239 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 245 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 246 */             setCreateUserId((String)value);
/* 247 */           } catch (Exception ee) {
/* 248 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 254 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 255 */             setUpdateDate((Date)value);
/* 256 */           } catch (Exception ee) {
/* 257 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 263 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 264 */             setUpdateUserId((String)value);
/* 265 */           } catch (Exception ee) {
/* 266 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\dsc\impl\DiscountTypeEligibilityDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */