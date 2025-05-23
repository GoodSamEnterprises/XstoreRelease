/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.ItemImageId;
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
/*     */ public class ItemImageDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -157724184L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ItemImageDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _itemId;
/*     */   private String _featureId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _imageUrl;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
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
/*     */   public String getFeatureId() {
/*  57 */     return this._featureId;
/*     */   }
/*     */   
/*     */   public void setFeatureId(String argFeatureId) {
/*  61 */     if (changed(argFeatureId, this._featureId, "featureId")) {
/*  62 */       this._featureId = (argFeatureId != null && MANAGE_CASE) ? argFeatureId.toUpperCase() : argFeatureId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  67 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  71 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  72 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  78 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  82 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  83 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  88 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  92 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  93 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  99 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 103 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 104 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getImageUrl() {
/* 109 */     return this._imageUrl;
/*     */   }
/*     */   
/*     */   public void setImageUrl(String argImageUrl) {
/* 113 */     if (changed(argImageUrl, this._imageUrl, "imageUrl")) {
/* 114 */       this._imageUrl = argImageUrl;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/* 119 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 123 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/* 124 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/* 129 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 133 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/* 134 */       this._orgValue = argOrgValue;
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
/* 149 */     if (getFeatureId() != null) {
/* 150 */       buf.append("featureId").append("=").append(getFeatureId()).append(" ");
/*     */     }
/* 152 */     if (getCreateDate() != null) {
/* 153 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 155 */     if (getCreateUserId() != null) {
/* 156 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 158 */     if (getUpdateDate() != null) {
/* 159 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 161 */     if (getUpdateUserId() != null) {
/* 162 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 164 */     if (getImageUrl() != null) {
/* 165 */       buf.append("imageUrl").append("=").append(getImageUrl()).append(" ");
/*     */     }
/* 167 */     if (getOrgCode() != null) {
/* 168 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 170 */     if (getOrgValue() != null) {
/* 171 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/*     */     
/* 174 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 178 */     ItemImageId id = new ItemImageId();
/* 179 */     id.setOrganizationId(getOrganizationId());
/* 180 */     id.setItemId(getItemId());
/* 181 */     id.setFeatureId(getFeatureId());
/* 182 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 186 */     setOrganizationId(((ItemImageId)argObjectId).getOrganizationId());
/* 187 */     setItemId(((ItemImageId)argObjectId).getItemId());
/* 188 */     setFeatureId(((ItemImageId)argObjectId).getFeatureId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 192 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 196 */     StringBuilder buf = new StringBuilder(500);
/* 197 */     buf.append("<").append("dao").append(" name=\"ItemImage\" cmd=\"" + getObjectStateString() + "\">");
/* 198 */     getFieldsAsXml(buf);
/* 199 */     buf.append("</").append("dao").append(">");
/*     */     
/* 201 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 205 */     Map<String, String> values = super.getValues();
/* 206 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 207 */     if (this._itemId != null) values.put("ItemId", DaoUtils.getXmlSafeFieldValue(12, this._itemId)); 
/* 208 */     if (this._featureId != null) values.put("FeatureId", DaoUtils.getXmlSafeFieldValue(12, this._featureId)); 
/* 209 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 210 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 211 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 212 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 213 */     if (this._imageUrl != null) values.put("ImageUrl", DaoUtils.getXmlSafeFieldValue(12, this._imageUrl)); 
/* 214 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 215 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 216 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 221 */     super.setValues(argValues);
/* 222 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 224 */       String fieldName = field.getKey();
/* 225 */       String fieldValue = field.getValue();
/* 226 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 230 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 231 */             setOrganizationId((Long)value);
/* 232 */           } catch (Exception ee) {
/* 233 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemId":
/*     */           try {
/* 239 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 240 */             setItemId((String)value);
/* 241 */           } catch (Exception ee) {
/* 242 */             throw new DtxException("An exception occurred while calling setItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FeatureId":
/*     */           try {
/* 248 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 249 */             setFeatureId((String)value);
/* 250 */           } catch (Exception ee) {
/* 251 */             throw new DtxException("An exception occurred while calling setFeatureId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 257 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 258 */             setCreateDate((Date)value);
/* 259 */           } catch (Exception ee) {
/* 260 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 266 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 267 */             setCreateUserId((String)value);
/* 268 */           } catch (Exception ee) {
/* 269 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 275 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 276 */             setUpdateDate((Date)value);
/* 277 */           } catch (Exception ee) {
/* 278 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 284 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 285 */             setUpdateUserId((String)value);
/* 286 */           } catch (Exception ee) {
/* 287 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ImageUrl":
/*     */           try {
/* 293 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 294 */             setImageUrl((String)value);
/* 295 */           } catch (Exception ee) {
/* 296 */             throw new DtxException("An exception occurred while calling setImageUrl() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 302 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 303 */             setOrgCode((String)value);
/* 304 */           } catch (Exception ee) {
/* 305 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 311 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 312 */             setOrgValue((String)value);
/* 313 */           } catch (Exception ee) {
/* 314 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemImageDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */