/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.ItemRestrictGS1Id;
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
/*     */ public class ItemRestrictGS1DAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1589828438L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ItemRestrictGS1DAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _itemId;
/*     */   private String _fieldId;
/*     */   private String _startValue;
/*     */   private String _aiType;
/*     */   private String _endValue;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _recordState;
/*     */   
/*     */   public Long getOrganizationId() {
/*  40 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  44 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  45 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getItemId() {
/*  50 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/*  54 */     if (changed(argItemId, this._itemId, "itemId")) {
/*  55 */       this._itemId = (argItemId != null && MANAGE_CASE) ? argItemId.toUpperCase() : argItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getFieldId() {
/*  60 */     return this._fieldId;
/*     */   }
/*     */   
/*     */   public void setFieldId(String argFieldId) {
/*  64 */     if (changed(argFieldId, this._fieldId, "fieldId")) {
/*  65 */       this._fieldId = (argFieldId != null && MANAGE_CASE) ? argFieldId.toUpperCase() : argFieldId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStartValue() {
/*  70 */     return this._startValue;
/*     */   }
/*     */   
/*     */   public void setStartValue(String argStartValue) {
/*  74 */     if (changed(argStartValue, this._startValue, "startValue")) {
/*  75 */       this._startValue = (argStartValue != null && MANAGE_CASE) ? argStartValue.toUpperCase() : argStartValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAiType() {
/*  80 */     return this._aiType;
/*     */   }
/*     */   
/*     */   public void setAiType(String argAiType) {
/*  84 */     if (changed(argAiType, this._aiType, "aiType")) {
/*  85 */       this._aiType = argAiType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getEndValue() {
/*  90 */     return this._endValue;
/*     */   }
/*     */   
/*     */   public void setEndValue(String argEndValue) {
/*  94 */     if (changed(argEndValue, this._endValue, "endValue")) {
/*  95 */       this._endValue = argEndValue;
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
/*     */   public Date getCreateDate() {
/* 120 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 124 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 125 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 131 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 135 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 136 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 141 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 145 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 146 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 152 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 156 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 157 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getRecordState() {
/* 162 */     return this._recordState;
/*     */   }
/*     */   
/*     */   public void setRecordState(String argRecordState) {
/* 166 */     if (changed(argRecordState, this._recordState, "recordState")) {
/* 167 */       this._recordState = argRecordState;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 174 */     StringBuilder buf = new StringBuilder(512);
/* 175 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 176 */     if (getOrganizationId() != null) {
/* 177 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 179 */     if (getItemId() != null) {
/* 180 */       buf.append("itemId").append("=").append(getItemId()).append(" ");
/*     */     }
/* 182 */     if (getFieldId() != null) {
/* 183 */       buf.append("fieldId").append("=").append(getFieldId()).append(" ");
/*     */     }
/* 185 */     if (getStartValue() != null) {
/* 186 */       buf.append("startValue").append("=").append(getStartValue()).append(" ");
/*     */     }
/* 188 */     if (getAiType() != null) {
/* 189 */       buf.append("aiType").append("=").append(getAiType()).append(" ");
/*     */     }
/* 191 */     if (getEndValue() != null) {
/* 192 */       buf.append("endValue").append("=").append(getEndValue()).append(" ");
/*     */     }
/* 194 */     if (getOrgCode() != null) {
/* 195 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 197 */     if (getOrgValue() != null) {
/* 198 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 200 */     if (getCreateDate() != null) {
/* 201 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 203 */     if (getCreateUserId() != null) {
/* 204 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 206 */     if (getUpdateDate() != null) {
/* 207 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 209 */     if (getUpdateUserId() != null) {
/* 210 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 212 */     if (getRecordState() != null) {
/* 213 */       buf.append("recordState").append("=").append(getRecordState()).append(" ");
/*     */     }
/*     */     
/* 216 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 220 */     ItemRestrictGS1Id id = new ItemRestrictGS1Id();
/* 221 */     id.setOrganizationId(getOrganizationId());
/* 222 */     id.setItemId(getItemId());
/* 223 */     id.setFieldId(getFieldId());
/* 224 */     id.setStartValue(getStartValue());
/* 225 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 229 */     setOrganizationId(((ItemRestrictGS1Id)argObjectId).getOrganizationId());
/* 230 */     setItemId(((ItemRestrictGS1Id)argObjectId).getItemId());
/* 231 */     setFieldId(((ItemRestrictGS1Id)argObjectId).getFieldId());
/* 232 */     setStartValue(((ItemRestrictGS1Id)argObjectId).getStartValue());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 236 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 240 */     StringBuilder buf = new StringBuilder(650);
/* 241 */     buf.append("<").append("dao").append(" name=\"ItemRestrictGS1\" cmd=\"" + getObjectStateString() + "\">");
/* 242 */     getFieldsAsXml(buf);
/* 243 */     buf.append("</").append("dao").append(">");
/*     */     
/* 245 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 249 */     Map<String, String> values = super.getValues();
/* 250 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 251 */     if (this._itemId != null) values.put("ItemId", DaoUtils.getXmlSafeFieldValue(12, this._itemId)); 
/* 252 */     if (this._fieldId != null) values.put("FieldId", DaoUtils.getXmlSafeFieldValue(12, this._fieldId)); 
/* 253 */     if (this._startValue != null) values.put("StartValue", DaoUtils.getXmlSafeFieldValue(12, this._startValue)); 
/* 254 */     if (this._aiType != null) values.put("AiType", DaoUtils.getXmlSafeFieldValue(12, this._aiType)); 
/* 255 */     if (this._endValue != null) values.put("EndValue", DaoUtils.getXmlSafeFieldValue(12, this._endValue)); 
/* 256 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 257 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 258 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 259 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 260 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 261 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 262 */     if (this._recordState != null) values.put("RecordState", DaoUtils.getXmlSafeFieldValue(12, this._recordState)); 
/* 263 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 268 */     super.setValues(argValues);
/* 269 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 271 */       String fieldName = field.getKey();
/* 272 */       String fieldValue = field.getValue();
/* 273 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 277 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 278 */             setOrganizationId((Long)value);
/* 279 */           } catch (Exception ee) {
/* 280 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemId":
/*     */           try {
/* 286 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 287 */             setItemId((String)value);
/* 288 */           } catch (Exception ee) {
/* 289 */             throw new DtxException("An exception occurred while calling setItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FieldId":
/*     */           try {
/* 295 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 296 */             setFieldId((String)value);
/* 297 */           } catch (Exception ee) {
/* 298 */             throw new DtxException("An exception occurred while calling setFieldId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StartValue":
/*     */           try {
/* 304 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 305 */             setStartValue((String)value);
/* 306 */           } catch (Exception ee) {
/* 307 */             throw new DtxException("An exception occurred while calling setStartValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AiType":
/*     */           try {
/* 313 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 314 */             setAiType((String)value);
/* 315 */           } catch (Exception ee) {
/* 316 */             throw new DtxException("An exception occurred while calling setAiType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EndValue":
/*     */           try {
/* 322 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 323 */             setEndValue((String)value);
/* 324 */           } catch (Exception ee) {
/* 325 */             throw new DtxException("An exception occurred while calling setEndValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 331 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 332 */             setOrgCode((String)value);
/* 333 */           } catch (Exception ee) {
/* 334 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 340 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 341 */             setOrgValue((String)value);
/* 342 */           } catch (Exception ee) {
/* 343 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 349 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 350 */             setCreateDate((Date)value);
/* 351 */           } catch (Exception ee) {
/* 352 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 358 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 359 */             setCreateUserId((String)value);
/* 360 */           } catch (Exception ee) {
/* 361 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 367 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 368 */             setUpdateDate((Date)value);
/* 369 */           } catch (Exception ee) {
/* 370 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 376 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 377 */             setUpdateUserId((String)value);
/* 378 */           } catch (Exception ee) {
/* 379 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RecordState":
/*     */           try {
/* 385 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 386 */             setRecordState((String)value);
/* 387 */           } catch (Exception ee) {
/* 388 */             throw new DtxException("An exception occurred while calling setRecordState() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemRestrictGS1DAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */