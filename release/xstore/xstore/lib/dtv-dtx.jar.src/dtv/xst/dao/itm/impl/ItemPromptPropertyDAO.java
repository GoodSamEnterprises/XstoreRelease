/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.ItemPromptPropertyId;
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
/*     */ public class ItemPromptPropertyDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 979737964L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ItemPromptPropertyDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _itemId;
/*     */   private String _promptPropertyCode;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private String _promptMethodCode;
/*     */   private String _codeGroup;
/*     */   private String _promptTitleKey;
/*     */   private String _promptMessageKey;
/*  38 */   private Boolean _required = Boolean.FALSE;
/*     */   private Integer _sortOrder;
/*     */   
/*     */   public Long getOrganizationId() {
/*  42 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  46 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  47 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getItemId() {
/*  52 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/*  56 */     if (changed(argItemId, this._itemId, "itemId")) {
/*  57 */       this._itemId = (argItemId != null && MANAGE_CASE) ? argItemId.toUpperCase() : argItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPromptPropertyCode() {
/*  62 */     return this._promptPropertyCode;
/*     */   }
/*     */   
/*     */   public void setPromptPropertyCode(String argPromptPropertyCode) {
/*  66 */     if (changed(argPromptPropertyCode, this._promptPropertyCode, "promptPropertyCode")) {
/*  67 */       this._promptPropertyCode = (argPromptPropertyCode != null && MANAGE_CASE) ? argPromptPropertyCode.toUpperCase() : argPromptPropertyCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  72 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  76 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  77 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  83 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  87 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  88 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  93 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  97 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  98 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 104 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 108 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 109 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/* 114 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 118 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/* 119 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/* 124 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 128 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/* 129 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPromptMethodCode() {
/* 134 */     return this._promptMethodCode;
/*     */   }
/*     */   
/*     */   public void setPromptMethodCode(String argPromptMethodCode) {
/* 138 */     if (changed(argPromptMethodCode, this._promptMethodCode, "promptMethodCode")) {
/* 139 */       this._promptMethodCode = argPromptMethodCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCodeGroup() {
/* 144 */     return this._codeGroup;
/*     */   }
/*     */   
/*     */   public void setCodeGroup(String argCodeGroup) {
/* 148 */     if (changed(argCodeGroup, this._codeGroup, "codeGroup")) {
/* 149 */       this._codeGroup = argCodeGroup;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPromptTitleKey() {
/* 154 */     return this._promptTitleKey;
/*     */   }
/*     */   
/*     */   public void setPromptTitleKey(String argPromptTitleKey) {
/* 158 */     if (changed(argPromptTitleKey, this._promptTitleKey, "promptTitleKey")) {
/* 159 */       this._promptTitleKey = argPromptTitleKey;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPromptMessageKey() {
/* 164 */     return this._promptMessageKey;
/*     */   }
/*     */   
/*     */   public void setPromptMessageKey(String argPromptMessageKey) {
/* 168 */     if (changed(argPromptMessageKey, this._promptMessageKey, "promptMessageKey")) {
/* 169 */       this._promptMessageKey = argPromptMessageKey;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getRequired() {
/* 174 */     return this._required;
/*     */   }
/*     */   
/*     */   public void setRequired(Boolean argRequired) {
/* 178 */     if (changed(argRequired, this._required, "required")) {
/* 179 */       this._required = argRequired;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSortOrder() {
/* 184 */     return this._sortOrder;
/*     */   }
/*     */   
/*     */   public void setSortOrder(Integer argSortOrder) {
/* 188 */     if (changed(argSortOrder, this._sortOrder, "sortOrder")) {
/* 189 */       this._sortOrder = argSortOrder;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 196 */     StringBuilder buf = new StringBuilder(512);
/* 197 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 198 */     if (getOrganizationId() != null) {
/* 199 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 201 */     if (getItemId() != null) {
/* 202 */       buf.append("itemId").append("=").append(getItemId()).append(" ");
/*     */     }
/* 204 */     if (getPromptPropertyCode() != null) {
/* 205 */       buf.append("promptPropertyCode").append("=").append(getPromptPropertyCode()).append(" ");
/*     */     }
/* 207 */     if (getCreateDate() != null) {
/* 208 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 210 */     if (getCreateUserId() != null) {
/* 211 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 213 */     if (getUpdateDate() != null) {
/* 214 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 216 */     if (getUpdateUserId() != null) {
/* 217 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 219 */     if (getOrgCode() != null) {
/* 220 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 222 */     if (getOrgValue() != null) {
/* 223 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 225 */     if (getPromptMethodCode() != null) {
/* 226 */       buf.append("promptMethodCode").append("=").append(getPromptMethodCode()).append(" ");
/*     */     }
/* 228 */     if (getCodeGroup() != null) {
/* 229 */       buf.append("codeGroup").append("=").append(getCodeGroup()).append(" ");
/*     */     }
/* 231 */     if (getPromptTitleKey() != null) {
/* 232 */       buf.append("promptTitleKey").append("=").append(getPromptTitleKey()).append(" ");
/*     */     }
/* 234 */     if (getPromptMessageKey() != null) {
/* 235 */       buf.append("promptMessageKey").append("=").append(getPromptMessageKey()).append(" ");
/*     */     }
/* 237 */     if (getRequired() != null && getRequired().booleanValue()) {
/* 238 */       buf.append("required").append("=").append(getRequired()).append(" ");
/*     */     }
/* 240 */     if (getSortOrder() != null) {
/* 241 */       buf.append("sortOrder").append("=").append(getSortOrder()).append(" ");
/*     */     }
/*     */     
/* 244 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 248 */     ItemPromptPropertyId id = new ItemPromptPropertyId();
/* 249 */     id.setOrganizationId(getOrganizationId());
/* 250 */     id.setItemId(getItemId());
/* 251 */     id.setPromptPropertyCode(getPromptPropertyCode());
/* 252 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 256 */     setOrganizationId(((ItemPromptPropertyId)argObjectId).getOrganizationId());
/* 257 */     setItemId(((ItemPromptPropertyId)argObjectId).getItemId());
/* 258 */     setPromptPropertyCode(((ItemPromptPropertyId)argObjectId).getPromptPropertyCode());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 262 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 266 */     StringBuilder buf = new StringBuilder(750);
/* 267 */     buf.append("<").append("dao").append(" name=\"ItemPromptProperty\" cmd=\"" + getObjectStateString() + "\">");
/* 268 */     getFieldsAsXml(buf);
/* 269 */     buf.append("</").append("dao").append(">");
/*     */     
/* 271 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 275 */     Map<String, String> values = super.getValues();
/* 276 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 277 */     if (this._itemId != null) values.put("ItemId", DaoUtils.getXmlSafeFieldValue(12, this._itemId)); 
/* 278 */     if (this._promptPropertyCode != null) values.put("PromptPropertyCode", DaoUtils.getXmlSafeFieldValue(12, this._promptPropertyCode)); 
/* 279 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 280 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 281 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 282 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 283 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 284 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 285 */     if (this._promptMethodCode != null) values.put("PromptMethodCode", DaoUtils.getXmlSafeFieldValue(12, this._promptMethodCode)); 
/* 286 */     if (this._codeGroup != null) values.put("CodeGroup", DaoUtils.getXmlSafeFieldValue(12, this._codeGroup)); 
/* 287 */     if (this._promptTitleKey != null) values.put("PromptTitleKey", DaoUtils.getXmlSafeFieldValue(12, this._promptTitleKey)); 
/* 288 */     if (this._promptMessageKey != null) values.put("PromptMessageKey", DaoUtils.getXmlSafeFieldValue(12, this._promptMessageKey)); 
/* 289 */     if (this._required != null) values.put("Required", DaoUtils.getXmlSafeFieldValue(-7, this._required)); 
/* 290 */     if (this._sortOrder != null) values.put("SortOrder", DaoUtils.getXmlSafeFieldValue(4, this._sortOrder)); 
/* 291 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 296 */     super.setValues(argValues);
/* 297 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 299 */       String fieldName = field.getKey();
/* 300 */       String fieldValue = field.getValue();
/* 301 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 305 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 306 */             setOrganizationId((Long)value);
/* 307 */           } catch (Exception ee) {
/* 308 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemId":
/*     */           try {
/* 314 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 315 */             setItemId((String)value);
/* 316 */           } catch (Exception ee) {
/* 317 */             throw new DtxException("An exception occurred while calling setItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PromptPropertyCode":
/*     */           try {
/* 323 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 324 */             setPromptPropertyCode((String)value);
/* 325 */           } catch (Exception ee) {
/* 326 */             throw new DtxException("An exception occurred while calling setPromptPropertyCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 332 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 333 */             setCreateDate((Date)value);
/* 334 */           } catch (Exception ee) {
/* 335 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 341 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 342 */             setCreateUserId((String)value);
/* 343 */           } catch (Exception ee) {
/* 344 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 350 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 351 */             setUpdateDate((Date)value);
/* 352 */           } catch (Exception ee) {
/* 353 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 359 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 360 */             setUpdateUserId((String)value);
/* 361 */           } catch (Exception ee) {
/* 362 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 368 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 369 */             setOrgCode((String)value);
/* 370 */           } catch (Exception ee) {
/* 371 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 377 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 378 */             setOrgValue((String)value);
/* 379 */           } catch (Exception ee) {
/* 380 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PromptMethodCode":
/*     */           try {
/* 386 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 387 */             setPromptMethodCode((String)value);
/* 388 */           } catch (Exception ee) {
/* 389 */             throw new DtxException("An exception occurred while calling setPromptMethodCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CodeGroup":
/*     */           try {
/* 395 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 396 */             setCodeGroup((String)value);
/* 397 */           } catch (Exception ee) {
/* 398 */             throw new DtxException("An exception occurred while calling setCodeGroup() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PromptTitleKey":
/*     */           try {
/* 404 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 405 */             setPromptTitleKey((String)value);
/* 406 */           } catch (Exception ee) {
/* 407 */             throw new DtxException("An exception occurred while calling setPromptTitleKey() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PromptMessageKey":
/*     */           try {
/* 413 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 414 */             setPromptMessageKey((String)value);
/* 415 */           } catch (Exception ee) {
/* 416 */             throw new DtxException("An exception occurred while calling setPromptMessageKey() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Required":
/*     */           try {
/* 422 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 423 */             setRequired((Boolean)value);
/* 424 */           } catch (Exception ee) {
/* 425 */             throw new DtxException("An exception occurred while calling setRequired() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SortOrder":
/*     */           try {
/* 431 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 432 */             setSortOrder((Integer)value);
/* 433 */           } catch (Exception ee) {
/* 434 */             throw new DtxException("An exception occurred while calling setSortOrder() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemPromptPropertyDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */