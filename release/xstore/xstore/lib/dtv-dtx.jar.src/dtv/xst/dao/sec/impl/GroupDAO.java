/*     */ package dtv.xst.dao.sec.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IHasConfigElement;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.sec.GroupId;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GroupDAO
/*     */   extends AbstractDAOImpl
/*     */   implements IHasConfigElement
/*     */ {
/*     */   private static final long serialVersionUID = 69076575L;
/*  23 */   private static final Logger _logger = Logger.getLogger(GroupDAO.class);
/*     */   
/*     */   private String _groupId;
/*     */   private Long _organizationId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _configElement;
/*     */   private Integer _bitmapPosition;
/*     */   private String _description;
/*     */   private Integer _groupRank;
/*     */   
/*     */   public String getGroupId() {
/*  37 */     return this._groupId;
/*     */   }
/*     */   
/*     */   public void setGroupId(String argGroupId) {
/*  41 */     if (changed(argGroupId, this._groupId, "groupId")) {
/*  42 */       this._groupId = (argGroupId != null && MANAGE_CASE) ? argGroupId.toUpperCase() : argGroupId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  47 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  51 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  52 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  57 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  61 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  62 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  68 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  72 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  73 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  78 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  82 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  83 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  89 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  93 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  94 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getConfigElement() {
/*  99 */     return this._configElement;
/*     */   }
/*     */   
/*     */   public void setConfigElement(String argConfigElement) {
/* 103 */     if (changed(argConfigElement, this._configElement, "configElement")) {
/* 104 */       this._configElement = argConfigElement;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getBitmapPosition() {
/* 109 */     return this._bitmapPosition;
/*     */   }
/*     */   
/*     */   public void setBitmapPosition(Integer argBitmapPosition) {
/* 113 */     if (changed(argBitmapPosition, this._bitmapPosition, "bitmapPosition")) {
/* 114 */       this._bitmapPosition = argBitmapPosition;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 119 */     return this._description;
/*     */   }
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 123 */     if (changed(argDescription, this._description, "description")) {
/* 124 */       this._description = argDescription;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getGroupRank() {
/* 129 */     return this._groupRank;
/*     */   }
/*     */   
/*     */   public void setGroupRank(Integer argGroupRank) {
/* 133 */     if (changed(argGroupRank, this._groupRank, "groupRank")) {
/* 134 */       this._groupRank = argGroupRank;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 141 */     StringBuilder buf = new StringBuilder(512);
/* 142 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 143 */     if (getGroupId() != null) {
/* 144 */       buf.append("groupId").append("=").append(getGroupId()).append(" ");
/*     */     }
/* 146 */     if (getOrganizationId() != null) {
/* 147 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 149 */     if (getCreateDate() != null) {
/* 150 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 152 */     if (getCreateUserId() != null) {
/* 153 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 155 */     if (getUpdateDate() != null) {
/* 156 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 158 */     if (getUpdateUserId() != null) {
/* 159 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 161 */     if (getConfigElement() != null) {
/* 162 */       buf.append("configElement").append("=").append(getConfigElement()).append(" ");
/*     */     }
/* 164 */     if (getBitmapPosition() != null) {
/* 165 */       buf.append("bitmapPosition").append("=").append(getBitmapPosition()).append(" ");
/*     */     }
/* 167 */     if (getDescription() != null) {
/* 168 */       buf.append("description").append("=").append(getDescription()).append(" ");
/*     */     }
/* 170 */     if (getGroupRank() != null) {
/* 171 */       buf.append("groupRank").append("=").append(getGroupRank()).append(" ");
/*     */     }
/*     */     
/* 174 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 178 */     GroupId id = new GroupId();
/* 179 */     id.setGroupId(getGroupId());
/* 180 */     id.setOrganizationId(getOrganizationId());
/* 181 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 185 */     setGroupId(((GroupId)argObjectId).getGroupId());
/* 186 */     setOrganizationId(((GroupId)argObjectId).getOrganizationId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 190 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 194 */     StringBuilder buf = new StringBuilder(500);
/* 195 */     buf.append("<").append("dao").append(" name=\"Group\" cmd=\"" + getObjectStateString() + "\">");
/* 196 */     getFieldsAsXml(buf);
/* 197 */     buf.append("</").append("dao").append(">");
/*     */     
/* 199 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 203 */     Map<String, String> values = super.getValues();
/* 204 */     if (this._groupId != null) values.put("GroupId", DaoUtils.getXmlSafeFieldValue(12, this._groupId)); 
/* 205 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 206 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 207 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 208 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 209 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 210 */     if (this._configElement != null) values.put("ConfigElement", DaoUtils.getXmlSafeFieldValue(12, this._configElement)); 
/* 211 */     if (this._bitmapPosition != null) values.put("BitmapPosition", DaoUtils.getXmlSafeFieldValue(4, this._bitmapPosition)); 
/* 212 */     if (this._description != null) values.put("Description", DaoUtils.getXmlSafeFieldValue(12, this._description)); 
/* 213 */     if (this._groupRank != null) values.put("GroupRank", DaoUtils.getXmlSafeFieldValue(4, this._groupRank)); 
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
/*     */         case "GroupId":
/*     */           try {
/* 228 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 229 */             setGroupId((String)value);
/* 230 */           } catch (Exception ee) {
/* 231 */             throw new DtxException("An exception occurred while calling setGroupId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
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
/*     */         case "CreateDate":
/*     */           try {
/* 246 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 247 */             setCreateDate((Date)value);
/* 248 */           } catch (Exception ee) {
/* 249 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 255 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 256 */             setCreateUserId((String)value);
/* 257 */           } catch (Exception ee) {
/* 258 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 264 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 265 */             setUpdateDate((Date)value);
/* 266 */           } catch (Exception ee) {
/* 267 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 273 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 274 */             setUpdateUserId((String)value);
/* 275 */           } catch (Exception ee) {
/* 276 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ConfigElement":
/*     */           try {
/* 282 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 283 */             setConfigElement((String)value);
/* 284 */           } catch (Exception ee) {
/* 285 */             throw new DtxException("An exception occurred while calling setConfigElement() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BitmapPosition":
/*     */           try {
/* 291 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 292 */             setBitmapPosition((Integer)value);
/* 293 */           } catch (Exception ee) {
/* 294 */             throw new DtxException("An exception occurred while calling setBitmapPosition() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Description":
/*     */           try {
/* 300 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 301 */             setDescription((String)value);
/* 302 */           } catch (Exception ee) {
/* 303 */             throw new DtxException("An exception occurred while calling setDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "GroupRank":
/*     */           try {
/* 309 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 310 */             setGroupRank((Integer)value);
/* 311 */           } catch (Exception ee) {
/* 312 */             throw new DtxException("An exception occurred while calling setGroupRank() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sec\impl\GroupDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */