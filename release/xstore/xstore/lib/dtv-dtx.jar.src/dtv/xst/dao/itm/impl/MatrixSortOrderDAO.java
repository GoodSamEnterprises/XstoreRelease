/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.MatrixSortOrderId;
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
/*     */ public class MatrixSortOrderDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 647421295L;
/*  23 */   private static final Logger _logger = Logger.getLogger(MatrixSortOrderDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _matrixSortType;
/*     */   private String _matrixSortId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private Integer _sortOrder;
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
/*     */   public String getMatrixSortType() {
/*  47 */     return this._matrixSortType;
/*     */   }
/*     */   
/*     */   public void setMatrixSortType(String argMatrixSortType) {
/*  51 */     if (changed(argMatrixSortType, this._matrixSortType, "matrixSortType")) {
/*  52 */       this._matrixSortType = (argMatrixSortType != null && MANAGE_CASE) ? argMatrixSortType.toUpperCase() : argMatrixSortType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getMatrixSortId() {
/*  57 */     return this._matrixSortId;
/*     */   }
/*     */   
/*     */   public void setMatrixSortId(String argMatrixSortId) {
/*  61 */     if (changed(argMatrixSortId, this._matrixSortId, "matrixSortId")) {
/*  62 */       this._matrixSortId = (argMatrixSortId != null && MANAGE_CASE) ? argMatrixSortId.toUpperCase() : argMatrixSortId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/*  67 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/*  71 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/*  72 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/*  77 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/*  81 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/*  82 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  87 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  91 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  92 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  98 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 102 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 103 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 108 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 112 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 113 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 119 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 123 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 124 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSortOrder() {
/* 129 */     return this._sortOrder;
/*     */   }
/*     */   
/*     */   public void setSortOrder(Integer argSortOrder) {
/* 133 */     if (changed(argSortOrder, this._sortOrder, "sortOrder")) {
/* 134 */       this._sortOrder = argSortOrder;
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
/* 146 */     if (getMatrixSortType() != null) {
/* 147 */       buf.append("matrixSortType").append("=").append(getMatrixSortType()).append(" ");
/*     */     }
/* 149 */     if (getMatrixSortId() != null) {
/* 150 */       buf.append("matrixSortId").append("=").append(getMatrixSortId()).append(" ");
/*     */     }
/* 152 */     if (getOrgCode() != null) {
/* 153 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 155 */     if (getOrgValue() != null) {
/* 156 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 158 */     if (getCreateDate() != null) {
/* 159 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 161 */     if (getCreateUserId() != null) {
/* 162 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 164 */     if (getUpdateDate() != null) {
/* 165 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 167 */     if (getUpdateUserId() != null) {
/* 168 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 170 */     if (getSortOrder() != null) {
/* 171 */       buf.append("sortOrder").append("=").append(getSortOrder()).append(" ");
/*     */     }
/*     */     
/* 174 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 178 */     MatrixSortOrderId id = new MatrixSortOrderId();
/* 179 */     id.setOrganizationId(getOrganizationId());
/* 180 */     id.setMatrixSortType(getMatrixSortType());
/* 181 */     id.setMatrixSortId(getMatrixSortId());
/* 182 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 186 */     setOrganizationId(((MatrixSortOrderId)argObjectId).getOrganizationId());
/* 187 */     setMatrixSortType(((MatrixSortOrderId)argObjectId).getMatrixSortType());
/* 188 */     setMatrixSortId(((MatrixSortOrderId)argObjectId).getMatrixSortId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 192 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 196 */     StringBuilder buf = new StringBuilder(500);
/* 197 */     buf.append("<").append("dao").append(" name=\"MatrixSortOrder\" cmd=\"" + getObjectStateString() + "\">");
/* 198 */     getFieldsAsXml(buf);
/* 199 */     buf.append("</").append("dao").append(">");
/*     */     
/* 201 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 205 */     Map<String, String> values = super.getValues();
/* 206 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 207 */     if (this._matrixSortType != null) values.put("MatrixSortType", DaoUtils.getXmlSafeFieldValue(12, this._matrixSortType)); 
/* 208 */     if (this._matrixSortId != null) values.put("MatrixSortId", DaoUtils.getXmlSafeFieldValue(12, this._matrixSortId)); 
/* 209 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 210 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 211 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 212 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 213 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 214 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 215 */     if (this._sortOrder != null) values.put("SortOrder", DaoUtils.getXmlSafeFieldValue(4, this._sortOrder)); 
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
/*     */         case "MatrixSortType":
/*     */           try {
/* 239 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 240 */             setMatrixSortType((String)value);
/* 241 */           } catch (Exception ee) {
/* 242 */             throw new DtxException("An exception occurred while calling setMatrixSortType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MatrixSortId":
/*     */           try {
/* 248 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 249 */             setMatrixSortId((String)value);
/* 250 */           } catch (Exception ee) {
/* 251 */             throw new DtxException("An exception occurred while calling setMatrixSortId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 257 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 258 */             setOrgCode((String)value);
/* 259 */           } catch (Exception ee) {
/* 260 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 266 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 267 */             setOrgValue((String)value);
/* 268 */           } catch (Exception ee) {
/* 269 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 275 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 276 */             setCreateDate((Date)value);
/* 277 */           } catch (Exception ee) {
/* 278 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 284 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 285 */             setCreateUserId((String)value);
/* 286 */           } catch (Exception ee) {
/* 287 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 293 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 294 */             setUpdateDate((Date)value);
/* 295 */           } catch (Exception ee) {
/* 296 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 302 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 303 */             setUpdateUserId((String)value);
/* 304 */           } catch (Exception ee) {
/* 305 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SortOrder":
/*     */           try {
/* 311 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 312 */             setSortOrder((Integer)value);
/* 313 */           } catch (Exception ee) {
/* 314 */             throw new DtxException("An exception occurred while calling setSortOrder() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\MatrixSortOrderDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */