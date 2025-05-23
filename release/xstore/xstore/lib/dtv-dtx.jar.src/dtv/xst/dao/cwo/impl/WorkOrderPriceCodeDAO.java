/*     */ package dtv.xst.dao.cwo.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cwo.WorkOrderPriceCodeId;
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
/*     */ public class WorkOrderPriceCodeDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 867767481L;
/*  23 */   private static final Logger _logger = Logger.getLogger(WorkOrderPriceCodeDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _priceCode;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Integer _sortOrder;
/*     */   private String _description;
/*  35 */   private Boolean _promptForWarrantyNumber = Boolean.FALSE;
/*     */   
/*     */   public Long getOrganizationId() {
/*  38 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  42 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  43 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPriceCode() {
/*  48 */     return this._priceCode;
/*     */   }
/*     */   
/*     */   public void setPriceCode(String argPriceCode) {
/*  52 */     if (changed(argPriceCode, this._priceCode, "priceCode")) {
/*  53 */       this._priceCode = (argPriceCode != null && MANAGE_CASE) ? argPriceCode.toUpperCase() : argPriceCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  58 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  62 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  63 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  69 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  73 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  74 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  79 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  83 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  84 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  90 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  94 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  95 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/* 100 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 104 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/* 105 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/* 110 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 114 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/* 115 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSortOrder() {
/* 120 */     return this._sortOrder;
/*     */   }
/*     */   
/*     */   public void setSortOrder(Integer argSortOrder) {
/* 124 */     if (changed(argSortOrder, this._sortOrder, "sortOrder")) {
/* 125 */       this._sortOrder = argSortOrder;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 130 */     return this._description;
/*     */   }
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 134 */     if (changed(argDescription, this._description, "description")) {
/* 135 */       this._description = argDescription;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getPromptForWarrantyNumber() {
/* 140 */     return this._promptForWarrantyNumber;
/*     */   }
/*     */   
/*     */   public void setPromptForWarrantyNumber(Boolean argPromptForWarrantyNumber) {
/* 144 */     if (changed(argPromptForWarrantyNumber, this._promptForWarrantyNumber, "promptForWarrantyNumber")) {
/* 145 */       this._promptForWarrantyNumber = argPromptForWarrantyNumber;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 152 */     StringBuilder buf = new StringBuilder(512);
/* 153 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 154 */     if (getOrganizationId() != null) {
/* 155 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 157 */     if (getPriceCode() != null) {
/* 158 */       buf.append("priceCode").append("=").append(getPriceCode()).append(" ");
/*     */     }
/* 160 */     if (getCreateDate() != null) {
/* 161 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 163 */     if (getCreateUserId() != null) {
/* 164 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 166 */     if (getUpdateDate() != null) {
/* 167 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 169 */     if (getUpdateUserId() != null) {
/* 170 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 172 */     if (getOrgCode() != null) {
/* 173 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 175 */     if (getOrgValue() != null) {
/* 176 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 178 */     if (getSortOrder() != null) {
/* 179 */       buf.append("sortOrder").append("=").append(getSortOrder()).append(" ");
/*     */     }
/* 181 */     if (getDescription() != null) {
/* 182 */       buf.append("description").append("=").append(getDescription()).append(" ");
/*     */     }
/* 184 */     if (getPromptForWarrantyNumber() != null && getPromptForWarrantyNumber().booleanValue()) {
/* 185 */       buf.append("promptForWarrantyNumber").append("=").append(getPromptForWarrantyNumber()).append(" ");
/*     */     }
/*     */     
/* 188 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 192 */     WorkOrderPriceCodeId id = new WorkOrderPriceCodeId();
/* 193 */     id.setOrganizationId(getOrganizationId());
/* 194 */     id.setPriceCode(getPriceCode());
/* 195 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 199 */     setOrganizationId(((WorkOrderPriceCodeId)argObjectId).getOrganizationId());
/* 200 */     setPriceCode(((WorkOrderPriceCodeId)argObjectId).getPriceCode());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 204 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 208 */     StringBuilder buf = new StringBuilder(550);
/* 209 */     buf.append("<").append("dao").append(" name=\"WorkOrderPriceCode\" cmd=\"" + getObjectStateString() + "\">");
/* 210 */     getFieldsAsXml(buf);
/* 211 */     buf.append("</").append("dao").append(">");
/*     */     
/* 213 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 217 */     Map<String, String> values = super.getValues();
/* 218 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 219 */     if (this._priceCode != null) values.put("PriceCode", DaoUtils.getXmlSafeFieldValue(12, this._priceCode)); 
/* 220 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 221 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 222 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 223 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 224 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 225 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 226 */     if (this._sortOrder != null) values.put("SortOrder", DaoUtils.getXmlSafeFieldValue(4, this._sortOrder)); 
/* 227 */     if (this._description != null) values.put("Description", DaoUtils.getXmlSafeFieldValue(12, this._description)); 
/* 228 */     if (this._promptForWarrantyNumber != null) values.put("PromptForWarrantyNumber", DaoUtils.getXmlSafeFieldValue(-7, this._promptForWarrantyNumber)); 
/* 229 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 234 */     super.setValues(argValues);
/* 235 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 237 */       String fieldName = field.getKey();
/* 238 */       String fieldValue = field.getValue();
/* 239 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 243 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 244 */             setOrganizationId((Long)value);
/* 245 */           } catch (Exception ee) {
/* 246 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PriceCode":
/*     */           try {
/* 252 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 253 */             setPriceCode((String)value);
/* 254 */           } catch (Exception ee) {
/* 255 */             throw new DtxException("An exception occurred while calling setPriceCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 261 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 262 */             setCreateDate((Date)value);
/* 263 */           } catch (Exception ee) {
/* 264 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 270 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 271 */             setCreateUserId((String)value);
/* 272 */           } catch (Exception ee) {
/* 273 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 279 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 280 */             setUpdateDate((Date)value);
/* 281 */           } catch (Exception ee) {
/* 282 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 288 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 289 */             setUpdateUserId((String)value);
/* 290 */           } catch (Exception ee) {
/* 291 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 297 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 298 */             setOrgCode((String)value);
/* 299 */           } catch (Exception ee) {
/* 300 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 306 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 307 */             setOrgValue((String)value);
/* 308 */           } catch (Exception ee) {
/* 309 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SortOrder":
/*     */           try {
/* 315 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 316 */             setSortOrder((Integer)value);
/* 317 */           } catch (Exception ee) {
/* 318 */             throw new DtxException("An exception occurred while calling setSortOrder() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Description":
/*     */           try {
/* 324 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 325 */             setDescription((String)value);
/* 326 */           } catch (Exception ee) {
/* 327 */             throw new DtxException("An exception occurred while calling setDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PromptForWarrantyNumber":
/*     */           try {
/* 333 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 334 */             setPromptForWarrantyNumber((Boolean)value);
/* 335 */           } catch (Exception ee) {
/* 336 */             throw new DtxException("An exception occurred while calling setPromptForWarrantyNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\impl\WorkOrderPriceCodeDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */