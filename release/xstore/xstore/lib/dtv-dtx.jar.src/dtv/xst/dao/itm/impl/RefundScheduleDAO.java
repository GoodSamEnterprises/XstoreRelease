/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.RefundScheduleId;
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
/*     */ public class RefundScheduleDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1284811343L;
/*  23 */   private static final Logger _logger = Logger.getLogger(RefundScheduleDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _itemId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private DtvDate _effectiveDate;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private DtvDate _expirationDate;
/*     */   private Integer _maximumFullRefundTime;
/*     */   private Integer _minimumNoRefundTime;
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
/*     */   public String getItemId() {
/*  49 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/*  53 */     if (changed(argItemId, this._itemId, "itemId")) {
/*  54 */       this._itemId = (argItemId != null && MANAGE_CASE) ? argItemId.toUpperCase() : argItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/*  59 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/*  63 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/*  64 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/*  69 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/*  73 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/*  74 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getEffectiveDate() {
/*  79 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/*  83 */     if (changed(argEffectiveDate, this._effectiveDate, "effectiveDate")) {
/*  84 */       this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/*  90 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  94 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  95 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 101 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 105 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 106 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 111 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 115 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 116 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 122 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 126 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 127 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getExpirationDate() {
/* 132 */     return (Date)this._expirationDate;
/*     */   }
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 136 */     if (changed(argExpirationDate, this._expirationDate, "expirationDate")) {
/* 137 */       this._expirationDate = (argExpirationDate == null || argExpirationDate instanceof DtvDate) ? (DtvDate)argExpirationDate : new DtvDate(argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getMaximumFullRefundTime() {
/* 143 */     return this._maximumFullRefundTime;
/*     */   }
/*     */   
/*     */   public void setMaximumFullRefundTime(Integer argMaximumFullRefundTime) {
/* 147 */     if (changed(argMaximumFullRefundTime, this._maximumFullRefundTime, "maximumFullRefundTime")) {
/* 148 */       this._maximumFullRefundTime = argMaximumFullRefundTime;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getMinimumNoRefundTime() {
/* 153 */     return this._minimumNoRefundTime;
/*     */   }
/*     */   
/*     */   public void setMinimumNoRefundTime(Integer argMinimumNoRefundTime) {
/* 157 */     if (changed(argMinimumNoRefundTime, this._minimumNoRefundTime, "minimumNoRefundTime")) {
/* 158 */       this._minimumNoRefundTime = argMinimumNoRefundTime;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 165 */     StringBuilder buf = new StringBuilder(512);
/* 166 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 167 */     if (getOrganizationId() != null) {
/* 168 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 170 */     if (getItemId() != null) {
/* 171 */       buf.append("itemId").append("=").append(getItemId()).append(" ");
/*     */     }
/* 173 */     if (getOrgCode() != null) {
/* 174 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 176 */     if (getOrgValue() != null) {
/* 177 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 179 */     if (getEffectiveDate() != null) {
/* 180 */       buf.append("effectiveDate").append("=").append(getEffectiveDate()).append(" ");
/*     */     }
/* 182 */     if (getCreateDate() != null) {
/* 183 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 185 */     if (getCreateUserId() != null) {
/* 186 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 188 */     if (getUpdateDate() != null) {
/* 189 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 191 */     if (getUpdateUserId() != null) {
/* 192 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 194 */     if (getExpirationDate() != null) {
/* 195 */       buf.append("expirationDate").append("=").append(getExpirationDate()).append(" ");
/*     */     }
/* 197 */     if (getMaximumFullRefundTime() != null) {
/* 198 */       buf.append("maximumFullRefundTime").append("=").append(getMaximumFullRefundTime()).append(" ");
/*     */     }
/* 200 */     if (getMinimumNoRefundTime() != null) {
/* 201 */       buf.append("minimumNoRefundTime").append("=").append(getMinimumNoRefundTime()).append(" ");
/*     */     }
/*     */     
/* 204 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 208 */     RefundScheduleId id = new RefundScheduleId();
/* 209 */     id.setOrganizationId(getOrganizationId());
/* 210 */     id.setItemId(getItemId());
/* 211 */     id.setEffectiveDate(getEffectiveDate());
/* 212 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 216 */     setOrganizationId(((RefundScheduleId)argObjectId).getOrganizationId());
/* 217 */     setItemId(((RefundScheduleId)argObjectId).getItemId());
/* 218 */     setEffectiveDate(((RefundScheduleId)argObjectId).getEffectiveDate());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 222 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 226 */     StringBuilder buf = new StringBuilder(600);
/* 227 */     buf.append("<").append("dao").append(" name=\"RefundSchedule\" cmd=\"" + getObjectStateString() + "\">");
/* 228 */     getFieldsAsXml(buf);
/* 229 */     buf.append("</").append("dao").append(">");
/*     */     
/* 231 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 235 */     Map<String, String> values = super.getValues();
/* 236 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 237 */     if (this._itemId != null) values.put("ItemId", DaoUtils.getXmlSafeFieldValue(12, this._itemId)); 
/* 238 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 239 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 240 */     if (this._effectiveDate != null) values.put("EffectiveDate", DaoUtils.getXmlSafeFieldValue(91, this._effectiveDate)); 
/* 241 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 242 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 243 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 244 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 245 */     if (this._expirationDate != null) values.put("ExpirationDate", DaoUtils.getXmlSafeFieldValue(91, this._expirationDate)); 
/* 246 */     if (this._maximumFullRefundTime != null) values.put("MaximumFullRefundTime", DaoUtils.getXmlSafeFieldValue(4, this._maximumFullRefundTime)); 
/* 247 */     if (this._minimumNoRefundTime != null) values.put("MinimumNoRefundTime", DaoUtils.getXmlSafeFieldValue(4, this._minimumNoRefundTime)); 
/* 248 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 253 */     super.setValues(argValues);
/* 254 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 256 */       String fieldName = field.getKey();
/* 257 */       String fieldValue = field.getValue();
/* 258 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 262 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 263 */             setOrganizationId((Long)value);
/* 264 */           } catch (Exception ee) {
/* 265 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemId":
/*     */           try {
/* 271 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 272 */             setItemId((String)value);
/* 273 */           } catch (Exception ee) {
/* 274 */             throw new DtxException("An exception occurred while calling setItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 280 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 281 */             setOrgCode((String)value);
/* 282 */           } catch (Exception ee) {
/* 283 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 289 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 290 */             setOrgValue((String)value);
/* 291 */           } catch (Exception ee) {
/* 292 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EffectiveDate":
/*     */           try {
/* 298 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 299 */             setEffectiveDate((Date)value);
/* 300 */           } catch (Exception ee) {
/* 301 */             throw new DtxException("An exception occurred while calling setEffectiveDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 307 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 308 */             setCreateDate((Date)value);
/* 309 */           } catch (Exception ee) {
/* 310 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 316 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 317 */             setCreateUserId((String)value);
/* 318 */           } catch (Exception ee) {
/* 319 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 325 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 326 */             setUpdateDate((Date)value);
/* 327 */           } catch (Exception ee) {
/* 328 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 334 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 335 */             setUpdateUserId((String)value);
/* 336 */           } catch (Exception ee) {
/* 337 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExpirationDate":
/*     */           try {
/* 343 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 344 */             setExpirationDate((Date)value);
/* 345 */           } catch (Exception ee) {
/* 346 */             throw new DtxException("An exception occurred while calling setExpirationDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MaximumFullRefundTime":
/*     */           try {
/* 352 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 353 */             setMaximumFullRefundTime((Integer)value);
/* 354 */           } catch (Exception ee) {
/* 355 */             throw new DtxException("An exception occurred while calling setMaximumFullRefundTime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MinimumNoRefundTime":
/*     */           try {
/* 361 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 362 */             setMinimumNoRefundTime((Integer)value);
/* 363 */           } catch (Exception ee) {
/* 364 */             throw new DtxException("An exception occurred while calling setMinimumNoRefundTime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\RefundScheduleDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */