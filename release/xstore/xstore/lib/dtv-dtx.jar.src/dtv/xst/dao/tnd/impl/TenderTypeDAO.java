/*     */ package dtv.xst.dao.tnd.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tnd.TenderTypeId;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TenderTypeDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1500428210L;
/*  23 */   private static final Logger _logger = Logger.getLogger(TenderTypeDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _tenderTypecode;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _description;
/*     */   private Integer _sortOrder;
/*     */   private String _unitCountCode;
/*     */   private BigDecimal _closeCountDiscrepancyThreshold;
/*  35 */   private Boolean _hidden = Boolean.FALSE;
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
/*     */   public String getTenderTypecode() {
/*  48 */     return this._tenderTypecode;
/*     */   }
/*     */   
/*     */   public void setTenderTypecode(String argTenderTypecode) {
/*  52 */     if (changed(argTenderTypecode, this._tenderTypecode, "tenderTypecode")) {
/*  53 */       this._tenderTypecode = (argTenderTypecode != null && MANAGE_CASE) ? argTenderTypecode.toUpperCase() : argTenderTypecode;
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
/*     */   public String getDescription() {
/* 100 */     return this._description;
/*     */   }
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 104 */     if (changed(argDescription, this._description, "description")) {
/* 105 */       this._description = argDescription;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSortOrder() {
/* 110 */     return this._sortOrder;
/*     */   }
/*     */   
/*     */   public void setSortOrder(Integer argSortOrder) {
/* 114 */     if (changed(argSortOrder, this._sortOrder, "sortOrder")) {
/* 115 */       this._sortOrder = argSortOrder;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getUnitCountCode() {
/* 120 */     return this._unitCountCode;
/*     */   }
/*     */   
/*     */   public void setUnitCountCode(String argUnitCountCode) {
/* 124 */     if (changed(argUnitCountCode, this._unitCountCode, "unitCountCode")) {
/* 125 */       this._unitCountCode = argUnitCountCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getCloseCountDiscrepancyThreshold() {
/* 130 */     return this._closeCountDiscrepancyThreshold;
/*     */   }
/*     */   
/*     */   public void setCloseCountDiscrepancyThreshold(BigDecimal argCloseCountDiscrepancyThreshold) {
/* 134 */     if (changed(argCloseCountDiscrepancyThreshold, this._closeCountDiscrepancyThreshold, "closeCountDiscrepancyThreshold")) {
/* 135 */       this._closeCountDiscrepancyThreshold = argCloseCountDiscrepancyThreshold;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getHidden() {
/* 140 */     return this._hidden;
/*     */   }
/*     */   
/*     */   public void setHidden(Boolean argHidden) {
/* 144 */     if (changed(argHidden, this._hidden, "hidden")) {
/* 145 */       this._hidden = argHidden;
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
/* 157 */     if (getTenderTypecode() != null) {
/* 158 */       buf.append("tenderTypecode").append("=").append(getTenderTypecode()).append(" ");
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
/* 172 */     if (getDescription() != null) {
/* 173 */       buf.append("description").append("=").append(getDescription()).append(" ");
/*     */     }
/* 175 */     if (getSortOrder() != null) {
/* 176 */       buf.append("sortOrder").append("=").append(getSortOrder()).append(" ");
/*     */     }
/* 178 */     if (getUnitCountCode() != null) {
/* 179 */       buf.append("unitCountCode").append("=").append(getUnitCountCode()).append(" ");
/*     */     }
/* 181 */     if (getCloseCountDiscrepancyThreshold() != null) {
/* 182 */       buf.append("closeCountDiscrepancyThreshold").append("=").append(getCloseCountDiscrepancyThreshold()).append(" ");
/*     */     }
/* 184 */     if (getHidden() != null && getHidden().booleanValue()) {
/* 185 */       buf.append("hidden").append("=").append(getHidden()).append(" ");
/*     */     }
/*     */     
/* 188 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 192 */     TenderTypeId id = new TenderTypeId();
/* 193 */     id.setOrganizationId(getOrganizationId());
/* 194 */     id.setTenderTypecode(getTenderTypecode());
/* 195 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 199 */     setOrganizationId(((TenderTypeId)argObjectId).getOrganizationId());
/* 200 */     setTenderTypecode(((TenderTypeId)argObjectId).getTenderTypecode());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 204 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 208 */     StringBuilder buf = new StringBuilder(550);
/* 209 */     buf.append("<").append("dao").append(" name=\"TenderType\" cmd=\"" + getObjectStateString() + "\">");
/* 210 */     getFieldsAsXml(buf);
/* 211 */     buf.append("</").append("dao").append(">");
/*     */     
/* 213 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 217 */     Map<String, String> values = super.getValues();
/* 218 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 219 */     if (this._tenderTypecode != null) values.put("TenderTypecode", DaoUtils.getXmlSafeFieldValue(12, this._tenderTypecode)); 
/* 220 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 221 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 222 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 223 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 224 */     if (this._description != null) values.put("Description", DaoUtils.getXmlSafeFieldValue(12, this._description)); 
/* 225 */     if (this._sortOrder != null) values.put("SortOrder", DaoUtils.getXmlSafeFieldValue(4, this._sortOrder)); 
/* 226 */     if (this._unitCountCode != null) values.put("UnitCountCode", DaoUtils.getXmlSafeFieldValue(12, this._unitCountCode)); 
/* 227 */     if (this._closeCountDiscrepancyThreshold != null) values.put("CloseCountDiscrepancyThreshold", DaoUtils.getXmlSafeFieldValue(3, this._closeCountDiscrepancyThreshold)); 
/* 228 */     if (this._hidden != null) values.put("Hidden", DaoUtils.getXmlSafeFieldValue(-7, this._hidden)); 
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
/*     */         case "TenderTypecode":
/*     */           try {
/* 252 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 253 */             setTenderTypecode((String)value);
/* 254 */           } catch (Exception ee) {
/* 255 */             throw new DtxException("An exception occurred while calling setTenderTypecode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
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
/*     */         case "Description":
/*     */           try {
/* 297 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 298 */             setDescription((String)value);
/* 299 */           } catch (Exception ee) {
/* 300 */             throw new DtxException("An exception occurred while calling setDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SortOrder":
/*     */           try {
/* 306 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 307 */             setSortOrder((Integer)value);
/* 308 */           } catch (Exception ee) {
/* 309 */             throw new DtxException("An exception occurred while calling setSortOrder() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UnitCountCode":
/*     */           try {
/* 315 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 316 */             setUnitCountCode((String)value);
/* 317 */           } catch (Exception ee) {
/* 318 */             throw new DtxException("An exception occurred while calling setUnitCountCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CloseCountDiscrepancyThreshold":
/*     */           try {
/* 324 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 325 */             setCloseCountDiscrepancyThreshold((BigDecimal)value);
/* 326 */           } catch (Exception ee) {
/* 327 */             throw new DtxException("An exception occurred while calling setCloseCountDiscrepancyThreshold() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Hidden":
/*     */           try {
/* 333 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 334 */             setHidden((Boolean)value);
/* 335 */           } catch (Exception ee) {
/* 336 */             throw new DtxException("An exception occurred while calling setHidden() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tnd\impl\TenderTypeDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */