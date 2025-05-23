/*     */ package dtv.xst.dao.thr.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.thr.PayrollHeaderId;
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
/*     */ public class PayrollHeaderDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1972081678L;
/*  23 */   private static final Logger _logger = Logger.getLogger(PayrollHeaderDAO.class);
/*     */   
/*     */   private Long _retailLocId;
/*     */   private Long _partyId;
/*     */   private Long _organizationId;
/*     */   private DtvDate _weekEndingDate;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private DtvDate _reviewedDate;
/*     */   
/*     */   public Long getRetailLocId() {
/*  36 */     return this._retailLocId;
/*     */   }
/*     */   
/*     */   public void setRetailLocId(Long argRetailLocId) {
/*  40 */     if (changed(argRetailLocId, this._retailLocId, "retailLocId")) {
/*  41 */       this._retailLocId = argRetailLocId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getPartyId() {
/*  46 */     return this._partyId;
/*     */   }
/*     */   
/*     */   public void setPartyId(Long argPartyId) {
/*  50 */     if (changed(argPartyId, this._partyId, "partyId")) {
/*  51 */       this._partyId = argPartyId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  56 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  60 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  61 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getWeekEndingDate() {
/*  66 */     return (Date)this._weekEndingDate;
/*     */   }
/*     */   
/*     */   public void setWeekEndingDate(Date argWeekEndingDate) {
/*  70 */     if (changed(argWeekEndingDate, this._weekEndingDate, "weekEndingDate")) {
/*  71 */       this._weekEndingDate = (argWeekEndingDate == null || argWeekEndingDate instanceof DtvDate) ? (DtvDate)argWeekEndingDate : new DtvDate(argWeekEndingDate);
/*     */     }
/*     */   }
/*     */ 
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
/*     */   public Date getReviewedDate() {
/* 119 */     return (Date)this._reviewedDate;
/*     */   }
/*     */   
/*     */   public void setReviewedDate(Date argReviewedDate) {
/* 123 */     if (changed(argReviewedDate, this._reviewedDate, "reviewedDate")) {
/* 124 */       this._reviewedDate = (argReviewedDate == null || argReviewedDate instanceof DtvDate) ? (DtvDate)argReviewedDate : new DtvDate(argReviewedDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 132 */     StringBuilder buf = new StringBuilder(512);
/* 133 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 134 */     if (getRetailLocId() != null) {
/* 135 */       buf.append("retailLocId").append("=").append(getRetailLocId()).append(" ");
/*     */     }
/* 137 */     if (getPartyId() != null) {
/* 138 */       buf.append("partyId").append("=").append(getPartyId()).append(" ");
/*     */     }
/* 140 */     if (getOrganizationId() != null) {
/* 141 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 143 */     if (getWeekEndingDate() != null) {
/* 144 */       buf.append("weekEndingDate").append("=").append(getWeekEndingDate()).append(" ");
/*     */     }
/* 146 */     if (getCreateDate() != null) {
/* 147 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 149 */     if (getCreateUserId() != null) {
/* 150 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 152 */     if (getUpdateDate() != null) {
/* 153 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 155 */     if (getUpdateUserId() != null) {
/* 156 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 158 */     if (getReviewedDate() != null) {
/* 159 */       buf.append("reviewedDate").append("=").append(getReviewedDate()).append(" ");
/*     */     }
/*     */     
/* 162 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 166 */     PayrollHeaderId id = new PayrollHeaderId();
/* 167 */     id.setRetailLocId(getRetailLocId());
/* 168 */     id.setPartyId(getPartyId());
/* 169 */     id.setOrganizationId(getOrganizationId());
/* 170 */     id.setWeekEndingDate(getWeekEndingDate());
/* 171 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 175 */     setRetailLocId(((PayrollHeaderId)argObjectId).getRetailLocId());
/* 176 */     setPartyId(((PayrollHeaderId)argObjectId).getPartyId());
/* 177 */     setOrganizationId(((PayrollHeaderId)argObjectId).getOrganizationId());
/* 178 */     setWeekEndingDate(((PayrollHeaderId)argObjectId).getWeekEndingDate());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 182 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 186 */     StringBuilder buf = new StringBuilder(450);
/* 187 */     buf.append("<").append("dao").append(" name=\"PayrollHeader\" cmd=\"" + getObjectStateString() + "\">");
/* 188 */     getFieldsAsXml(buf);
/* 189 */     buf.append("</").append("dao").append(">");
/*     */     
/* 191 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 195 */     Map<String, String> values = super.getValues();
/* 196 */     if (this._retailLocId != null) values.put("RetailLocId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocId)); 
/* 197 */     if (this._partyId != null) values.put("PartyId", DaoUtils.getXmlSafeFieldValue(-5, this._partyId)); 
/* 198 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 199 */     if (this._weekEndingDate != null) values.put("WeekEndingDate", DaoUtils.getXmlSafeFieldValue(91, this._weekEndingDate)); 
/* 200 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 201 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 202 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 203 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 204 */     if (this._reviewedDate != null) values.put("ReviewedDate", DaoUtils.getXmlSafeFieldValue(91, this._reviewedDate)); 
/* 205 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 210 */     super.setValues(argValues);
/* 211 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 213 */       String fieldName = field.getKey();
/* 214 */       String fieldValue = field.getValue();
/* 215 */       switch (fieldName) {
/*     */         
/*     */         case "RetailLocId":
/*     */           try {
/* 219 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 220 */             setRetailLocId((Long)value);
/* 221 */           } catch (Exception ee) {
/* 222 */             throw new DtxException("An exception occurred while calling setRetailLocId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PartyId":
/*     */           try {
/* 228 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 229 */             setPartyId((Long)value);
/* 230 */           } catch (Exception ee) {
/* 231 */             throw new DtxException("An exception occurred while calling setPartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 237 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 238 */             setOrganizationId((Long)value);
/* 239 */           } catch (Exception ee) {
/* 240 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WeekEndingDate":
/*     */           try {
/* 246 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 247 */             setWeekEndingDate((Date)value);
/* 248 */           } catch (Exception ee) {
/* 249 */             throw new DtxException("An exception occurred while calling setWeekEndingDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 255 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 256 */             setCreateDate((Date)value);
/* 257 */           } catch (Exception ee) {
/* 258 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 264 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 265 */             setCreateUserId((String)value);
/* 266 */           } catch (Exception ee) {
/* 267 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 273 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 274 */             setUpdateDate((Date)value);
/* 275 */           } catch (Exception ee) {
/* 276 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 282 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 283 */             setUpdateUserId((String)value);
/* 284 */           } catch (Exception ee) {
/* 285 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReviewedDate":
/*     */           try {
/* 291 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 292 */             setReviewedDate((Date)value);
/* 293 */           } catch (Exception ee) {
/* 294 */             throw new DtxException("An exception occurred while calling setReviewedDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\thr\impl\PayrollHeaderDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */