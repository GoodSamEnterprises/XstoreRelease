/*     */ package dtv.xst.dao.rpt.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.rpt.OrganizerId;
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
/*     */ public class OrganizerDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -137637105L;
/*  23 */   private static final Logger _logger = Logger.getLogger(OrganizerDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _reportName;
/*     */   private String _reportGroup;
/*     */   private String _reportElement;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private Integer _reportOrder;
/*     */   
/*     */   public Long getOrganizationId() {
/*  36 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  40 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  41 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getReportName() {
/*  46 */     return this._reportName;
/*     */   }
/*     */   
/*     */   public void setReportName(String argReportName) {
/*  50 */     if (changed(argReportName, this._reportName, "reportName")) {
/*  51 */       this._reportName = (argReportName != null && MANAGE_CASE) ? argReportName.toUpperCase() : argReportName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getReportGroup() {
/*  56 */     return this._reportGroup;
/*     */   }
/*     */   
/*     */   public void setReportGroup(String argReportGroup) {
/*  60 */     if (changed(argReportGroup, this._reportGroup, "reportGroup")) {
/*  61 */       this._reportGroup = (argReportGroup != null && MANAGE_CASE) ? argReportGroup.toUpperCase() : argReportGroup;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getReportElement() {
/*  66 */     return this._reportElement;
/*     */   }
/*     */   
/*     */   public void setReportElement(String argReportElement) {
/*  70 */     if (changed(argReportElement, this._reportElement, "reportElement")) {
/*  71 */       this._reportElement = (argReportElement != null && MANAGE_CASE) ? argReportElement.toUpperCase() : argReportElement;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  76 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  80 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  81 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  87 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  91 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  92 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  97 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 101 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 102 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 108 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 112 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 113 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getReportOrder() {
/* 118 */     return this._reportOrder;
/*     */   }
/*     */   
/*     */   public void setReportOrder(Integer argReportOrder) {
/* 122 */     if (changed(argReportOrder, this._reportOrder, "reportOrder")) {
/* 123 */       this._reportOrder = argReportOrder;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 130 */     StringBuilder buf = new StringBuilder(512);
/* 131 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 132 */     if (getOrganizationId() != null) {
/* 133 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 135 */     if (getReportName() != null) {
/* 136 */       buf.append("reportName").append("=").append(getReportName()).append(" ");
/*     */     }
/* 138 */     if (getReportGroup() != null) {
/* 139 */       buf.append("reportGroup").append("=").append(getReportGroup()).append(" ");
/*     */     }
/* 141 */     if (getReportElement() != null) {
/* 142 */       buf.append("reportElement").append("=").append(getReportElement()).append(" ");
/*     */     }
/* 144 */     if (getCreateDate() != null) {
/* 145 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 147 */     if (getCreateUserId() != null) {
/* 148 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 150 */     if (getUpdateDate() != null) {
/* 151 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 153 */     if (getUpdateUserId() != null) {
/* 154 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 156 */     if (getReportOrder() != null) {
/* 157 */       buf.append("reportOrder").append("=").append(getReportOrder()).append(" ");
/*     */     }
/*     */     
/* 160 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 164 */     OrganizerId id = new OrganizerId();
/* 165 */     id.setOrganizationId(getOrganizationId());
/* 166 */     id.setReportName(getReportName());
/* 167 */     id.setReportGroup(getReportGroup());
/* 168 */     id.setReportElement(getReportElement());
/* 169 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 173 */     setOrganizationId(((OrganizerId)argObjectId).getOrganizationId());
/* 174 */     setReportName(((OrganizerId)argObjectId).getReportName());
/* 175 */     setReportGroup(((OrganizerId)argObjectId).getReportGroup());
/* 176 */     setReportElement(((OrganizerId)argObjectId).getReportElement());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 180 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 184 */     StringBuilder buf = new StringBuilder(450);
/* 185 */     buf.append("<").append("dao").append(" name=\"Organizer\" cmd=\"" + getObjectStateString() + "\">");
/* 186 */     getFieldsAsXml(buf);
/* 187 */     buf.append("</").append("dao").append(">");
/*     */     
/* 189 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 193 */     Map<String, String> values = super.getValues();
/* 194 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 195 */     if (this._reportName != null) values.put("ReportName", DaoUtils.getXmlSafeFieldValue(12, this._reportName)); 
/* 196 */     if (this._reportGroup != null) values.put("ReportGroup", DaoUtils.getXmlSafeFieldValue(12, this._reportGroup)); 
/* 197 */     if (this._reportElement != null) values.put("ReportElement", DaoUtils.getXmlSafeFieldValue(12, this._reportElement)); 
/* 198 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 199 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 200 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 201 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 202 */     if (this._reportOrder != null) values.put("ReportOrder", DaoUtils.getXmlSafeFieldValue(4, this._reportOrder)); 
/* 203 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 208 */     super.setValues(argValues);
/* 209 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 211 */       String fieldName = field.getKey();
/* 212 */       String fieldValue = field.getValue();
/* 213 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 217 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 218 */             setOrganizationId((Long)value);
/* 219 */           } catch (Exception ee) {
/* 220 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReportName":
/*     */           try {
/* 226 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 227 */             setReportName((String)value);
/* 228 */           } catch (Exception ee) {
/* 229 */             throw new DtxException("An exception occurred while calling setReportName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReportGroup":
/*     */           try {
/* 235 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 236 */             setReportGroup((String)value);
/* 237 */           } catch (Exception ee) {
/* 238 */             throw new DtxException("An exception occurred while calling setReportGroup() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReportElement":
/*     */           try {
/* 244 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 245 */             setReportElement((String)value);
/* 246 */           } catch (Exception ee) {
/* 247 */             throw new DtxException("An exception occurred while calling setReportElement() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 253 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 254 */             setCreateDate((Date)value);
/* 255 */           } catch (Exception ee) {
/* 256 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 262 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 263 */             setCreateUserId((String)value);
/* 264 */           } catch (Exception ee) {
/* 265 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 271 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 272 */             setUpdateDate((Date)value);
/* 273 */           } catch (Exception ee) {
/* 274 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 280 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 281 */             setUpdateUserId((String)value);
/* 282 */           } catch (Exception ee) {
/* 283 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReportOrder":
/*     */           try {
/* 289 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 290 */             setReportOrder((Integer)value);
/* 291 */           } catch (Exception ee) {
/* 292 */             throw new DtxException("An exception occurred while calling setReportOrder() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\rpt\impl\OrganizerDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */