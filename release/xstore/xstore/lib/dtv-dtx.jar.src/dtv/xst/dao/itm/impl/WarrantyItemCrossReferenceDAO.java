/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.WarrantyItemCrossReferenceId;
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
/*     */ public class WarrantyItemCrossReferenceDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -332362982L;
/*  23 */   private static final Logger _logger = Logger.getLogger(WarrantyItemCrossReferenceDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _itemId;
/*     */   private String _warrantyItemId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _warrantyTypeCode;
/*     */   private Long _sortOrder;
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
/*     */   public String getItemId() {
/*  48 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/*  52 */     if (changed(argItemId, this._itemId, "itemId")) {
/*  53 */       this._itemId = (argItemId != null && MANAGE_CASE) ? argItemId.toUpperCase() : argItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getWarrantyItemId() {
/*  58 */     return this._warrantyItemId;
/*     */   }
/*     */   
/*     */   public void setWarrantyItemId(String argWarrantyItemId) {
/*  62 */     if (changed(argWarrantyItemId, this._warrantyItemId, "warrantyItemId")) {
/*  63 */       this._warrantyItemId = (argWarrantyItemId != null && MANAGE_CASE) ? argWarrantyItemId.toUpperCase() : argWarrantyItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/*  68 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/*  72 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/*  73 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/*  78 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/*  82 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/*  83 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  88 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  92 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  93 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  99 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 103 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 104 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 109 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 113 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 114 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 120 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 124 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 125 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getWarrantyTypeCode() {
/* 130 */     return this._warrantyTypeCode;
/*     */   }
/*     */   
/*     */   public void setWarrantyTypeCode(String argWarrantyTypeCode) {
/* 134 */     if (changed(argWarrantyTypeCode, this._warrantyTypeCode, "warrantyTypeCode")) {
/* 135 */       this._warrantyTypeCode = argWarrantyTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getSortOrder() {
/* 140 */     return this._sortOrder;
/*     */   }
/*     */   
/*     */   public void setSortOrder(Long argSortOrder) {
/* 144 */     if (changed(argSortOrder, this._sortOrder, "sortOrder")) {
/* 145 */       this._sortOrder = argSortOrder;
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
/* 157 */     if (getItemId() != null) {
/* 158 */       buf.append("itemId").append("=").append(getItemId()).append(" ");
/*     */     }
/* 160 */     if (getWarrantyItemId() != null) {
/* 161 */       buf.append("warrantyItemId").append("=").append(getWarrantyItemId()).append(" ");
/*     */     }
/* 163 */     if (getOrgCode() != null) {
/* 164 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 166 */     if (getOrgValue() != null) {
/* 167 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 169 */     if (getCreateDate() != null) {
/* 170 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 172 */     if (getCreateUserId() != null) {
/* 173 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 175 */     if (getUpdateDate() != null) {
/* 176 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 178 */     if (getUpdateUserId() != null) {
/* 179 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 181 */     if (getWarrantyTypeCode() != null) {
/* 182 */       buf.append("warrantyTypeCode").append("=").append(getWarrantyTypeCode()).append(" ");
/*     */     }
/* 184 */     if (getSortOrder() != null) {
/* 185 */       buf.append("sortOrder").append("=").append(getSortOrder()).append(" ");
/*     */     }
/*     */     
/* 188 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 192 */     WarrantyItemCrossReferenceId id = new WarrantyItemCrossReferenceId();
/* 193 */     id.setOrganizationId(getOrganizationId());
/* 194 */     id.setItemId(getItemId());
/* 195 */     id.setWarrantyItemId(getWarrantyItemId());
/* 196 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 200 */     setOrganizationId(((WarrantyItemCrossReferenceId)argObjectId).getOrganizationId());
/* 201 */     setItemId(((WarrantyItemCrossReferenceId)argObjectId).getItemId());
/* 202 */     setWarrantyItemId(((WarrantyItemCrossReferenceId)argObjectId).getWarrantyItemId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 206 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 210 */     StringBuilder buf = new StringBuilder(550);
/* 211 */     buf.append("<").append("dao").append(" name=\"WarrantyItemCrossReference\" cmd=\"" + getObjectStateString() + "\">");
/* 212 */     getFieldsAsXml(buf);
/* 213 */     buf.append("</").append("dao").append(">");
/*     */     
/* 215 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 219 */     Map<String, String> values = super.getValues();
/* 220 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 221 */     if (this._itemId != null) values.put("ItemId", DaoUtils.getXmlSafeFieldValue(12, this._itemId)); 
/* 222 */     if (this._warrantyItemId != null) values.put("WarrantyItemId", DaoUtils.getXmlSafeFieldValue(12, this._warrantyItemId)); 
/* 223 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 224 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 225 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 226 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 227 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 228 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 229 */     if (this._warrantyTypeCode != null) values.put("WarrantyTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._warrantyTypeCode)); 
/* 230 */     if (this._sortOrder != null) values.put("SortOrder", DaoUtils.getXmlSafeFieldValue(-5, this._sortOrder)); 
/* 231 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 236 */     super.setValues(argValues);
/* 237 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 239 */       String fieldName = field.getKey();
/* 240 */       String fieldValue = field.getValue();
/* 241 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 245 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 246 */             setOrganizationId((Long)value);
/* 247 */           } catch (Exception ee) {
/* 248 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemId":
/*     */           try {
/* 254 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 255 */             setItemId((String)value);
/* 256 */           } catch (Exception ee) {
/* 257 */             throw new DtxException("An exception occurred while calling setItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WarrantyItemId":
/*     */           try {
/* 263 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 264 */             setWarrantyItemId((String)value);
/* 265 */           } catch (Exception ee) {
/* 266 */             throw new DtxException("An exception occurred while calling setWarrantyItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 272 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 273 */             setOrgCode((String)value);
/* 274 */           } catch (Exception ee) {
/* 275 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 281 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 282 */             setOrgValue((String)value);
/* 283 */           } catch (Exception ee) {
/* 284 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 290 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 291 */             setCreateDate((Date)value);
/* 292 */           } catch (Exception ee) {
/* 293 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 299 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 300 */             setCreateUserId((String)value);
/* 301 */           } catch (Exception ee) {
/* 302 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 308 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 309 */             setUpdateDate((Date)value);
/* 310 */           } catch (Exception ee) {
/* 311 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 317 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 318 */             setUpdateUserId((String)value);
/* 319 */           } catch (Exception ee) {
/* 320 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WarrantyTypeCode":
/*     */           try {
/* 326 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 327 */             setWarrantyTypeCode((String)value);
/* 328 */           } catch (Exception ee) {
/* 329 */             throw new DtxException("An exception occurred while calling setWarrantyTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SortOrder":
/*     */           try {
/* 335 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 336 */             setSortOrder((Long)value);
/* 337 */           } catch (Exception ee) {
/* 338 */             throw new DtxException("An exception occurred while calling setSortOrder() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\WarrantyItemCrossReferenceDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */