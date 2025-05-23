/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.ItemLabelPropertiesId;
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
/*     */ public class ItemLabelPropertiesDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1062658964L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ItemLabelPropertiesDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _itemId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _stockLabel;
/*     */   private String _logoUrl;
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
/*     */   public String getItemId() {
/*  47 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/*  51 */     if (changed(argItemId, this._itemId, "itemId")) {
/*  52 */       this._itemId = (argItemId != null && MANAGE_CASE) ? argItemId.toUpperCase() : argItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/*  57 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/*  61 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/*  62 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/*  67 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/*  71 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/*  72 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  77 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  81 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  82 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  88 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  92 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  93 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  98 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 102 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 103 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 109 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 113 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 114 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStockLabel() {
/* 119 */     return this._stockLabel;
/*     */   }
/*     */   
/*     */   public void setStockLabel(String argStockLabel) {
/* 123 */     if (changed(argStockLabel, this._stockLabel, "stockLabel")) {
/* 124 */       this._stockLabel = argStockLabel;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLogoUrl() {
/* 129 */     return this._logoUrl;
/*     */   }
/*     */   
/*     */   public void setLogoUrl(String argLogoUrl) {
/* 133 */     if (changed(argLogoUrl, this._logoUrl, "logoUrl")) {
/* 134 */       this._logoUrl = argLogoUrl;
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
/* 146 */     if (getItemId() != null) {
/* 147 */       buf.append("itemId").append("=").append(getItemId()).append(" ");
/*     */     }
/* 149 */     if (getOrgCode() != null) {
/* 150 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 152 */     if (getOrgValue() != null) {
/* 153 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 155 */     if (getCreateDate() != null) {
/* 156 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 158 */     if (getCreateUserId() != null) {
/* 159 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 161 */     if (getUpdateDate() != null) {
/* 162 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 164 */     if (getUpdateUserId() != null) {
/* 165 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 167 */     if (getStockLabel() != null) {
/* 168 */       buf.append("stockLabel").append("=").append(getStockLabel()).append(" ");
/*     */     }
/* 170 */     if (getLogoUrl() != null) {
/* 171 */       buf.append("logoUrl").append("=").append(getLogoUrl()).append(" ");
/*     */     }
/*     */     
/* 174 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 178 */     ItemLabelPropertiesId id = new ItemLabelPropertiesId();
/* 179 */     id.setOrganizationId(getOrganizationId());
/* 180 */     id.setItemId(getItemId());
/* 181 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 185 */     setOrganizationId(((ItemLabelPropertiesId)argObjectId).getOrganizationId());
/* 186 */     setItemId(((ItemLabelPropertiesId)argObjectId).getItemId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 190 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 194 */     StringBuilder buf = new StringBuilder(500);
/* 195 */     buf.append("<").append("dao").append(" name=\"ItemLabelProperties\" cmd=\"" + getObjectStateString() + "\">");
/* 196 */     getFieldsAsXml(buf);
/* 197 */     buf.append("</").append("dao").append(">");
/*     */     
/* 199 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 203 */     Map<String, String> values = super.getValues();
/* 204 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 205 */     if (this._itemId != null) values.put("ItemId", DaoUtils.getXmlSafeFieldValue(12, this._itemId)); 
/* 206 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 207 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 208 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 209 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 210 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 211 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 212 */     if (this._stockLabel != null) values.put("StockLabel", DaoUtils.getXmlSafeFieldValue(12, this._stockLabel)); 
/* 213 */     if (this._logoUrl != null) values.put("LogoUrl", DaoUtils.getXmlSafeFieldValue(12, this._logoUrl)); 
/* 214 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 219 */     super.setValues(argValues);
/* 220 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 222 */       String fieldName = field.getKey();
/* 223 */       String fieldValue = field.getValue();
/* 224 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 228 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 229 */             setOrganizationId((Long)value);
/* 230 */           } catch (Exception ee) {
/* 231 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemId":
/*     */           try {
/* 237 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 238 */             setItemId((String)value);
/* 239 */           } catch (Exception ee) {
/* 240 */             throw new DtxException("An exception occurred while calling setItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 246 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 247 */             setOrgCode((String)value);
/* 248 */           } catch (Exception ee) {
/* 249 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 255 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 256 */             setOrgValue((String)value);
/* 257 */           } catch (Exception ee) {
/* 258 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 264 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 265 */             setCreateDate((Date)value);
/* 266 */           } catch (Exception ee) {
/* 267 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 273 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 274 */             setCreateUserId((String)value);
/* 275 */           } catch (Exception ee) {
/* 276 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 282 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 283 */             setUpdateDate((Date)value);
/* 284 */           } catch (Exception ee) {
/* 285 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 291 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 292 */             setUpdateUserId((String)value);
/* 293 */           } catch (Exception ee) {
/* 294 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StockLabel":
/*     */           try {
/* 300 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 301 */             setStockLabel((String)value);
/* 302 */           } catch (Exception ee) {
/* 303 */             throw new DtxException("An exception occurred while calling setStockLabel() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LogoUrl":
/*     */           try {
/* 309 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 310 */             setLogoUrl((String)value);
/* 311 */           } catch (Exception ee) {
/* 312 */             throw new DtxException("An exception occurred while calling setLogoUrl() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemLabelPropertiesDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */