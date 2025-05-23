/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.ItemLabelBatchId;
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
/*     */ public class ItemLabelBatchDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -51165127L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ItemLabelBatchDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _batchName;
/*     */   private String _itemId;
/*     */   private String _stockLabel;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private Long _count;
/*     */   private BigDecimal _overridenPrice;
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
/*     */   public Long getRetailLocationId() {
/*  48 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  52 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  53 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getBatchName() {
/*  58 */     return this._batchName;
/*     */   }
/*     */   
/*     */   public void setBatchName(String argBatchName) {
/*  62 */     if (changed(argBatchName, this._batchName, "batchName")) {
/*  63 */       this._batchName = (argBatchName != null && MANAGE_CASE) ? argBatchName.toUpperCase() : argBatchName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getItemId() {
/*  68 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/*  72 */     if (changed(argItemId, this._itemId, "itemId")) {
/*  73 */       this._itemId = (argItemId != null && MANAGE_CASE) ? argItemId.toUpperCase() : argItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStockLabel() {
/*  78 */     return this._stockLabel;
/*     */   }
/*     */   
/*     */   public void setStockLabel(String argStockLabel) {
/*  82 */     if (changed(argStockLabel, this._stockLabel, "stockLabel")) {
/*  83 */       this._stockLabel = (argStockLabel != null && MANAGE_CASE) ? argStockLabel.toUpperCase() : argStockLabel;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  88 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  92 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  93 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  99 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 103 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 104 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 109 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 113 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 114 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 120 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 124 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 125 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getCount() {
/* 130 */     return this._count;
/*     */   }
/*     */   
/*     */   public void setCount(Long argCount) {
/* 134 */     if (changed(argCount, this._count, "count")) {
/* 135 */       this._count = argCount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getOverridenPrice() {
/* 140 */     return this._overridenPrice;
/*     */   }
/*     */   
/*     */   public void setOverridenPrice(BigDecimal argOverridenPrice) {
/* 144 */     if (changed(argOverridenPrice, this._overridenPrice, "overridenPrice")) {
/* 145 */       this._overridenPrice = argOverridenPrice;
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
/* 157 */     if (getRetailLocationId() != null) {
/* 158 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 160 */     if (getBatchName() != null) {
/* 161 */       buf.append("batchName").append("=").append(getBatchName()).append(" ");
/*     */     }
/* 163 */     if (getItemId() != null) {
/* 164 */       buf.append("itemId").append("=").append(getItemId()).append(" ");
/*     */     }
/* 166 */     if (getStockLabel() != null) {
/* 167 */       buf.append("stockLabel").append("=").append(getStockLabel()).append(" ");
/*     */     }
/* 169 */     if (getCreateDate() != null) {
/* 170 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 172 */     if (getCreateUserId() != null) {
/* 173 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 175 */     if (getUpdateDate() != null) {
/* 176 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 178 */     if (getUpdateUserId() != null) {
/* 179 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 181 */     if (getCount() != null) {
/* 182 */       buf.append("count").append("=").append(getCount()).append(" ");
/*     */     }
/* 184 */     if (getOverridenPrice() != null) {
/* 185 */       buf.append("overridenPrice").append("=").append(getOverridenPrice()).append(" ");
/*     */     }
/*     */     
/* 188 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 192 */     ItemLabelBatchId id = new ItemLabelBatchId();
/* 193 */     id.setOrganizationId(getOrganizationId());
/* 194 */     id.setRetailLocationId(getRetailLocationId());
/* 195 */     id.setBatchName(getBatchName());
/* 196 */     id.setItemId(getItemId());
/* 197 */     id.setStockLabel(getStockLabel());
/* 198 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 202 */     setOrganizationId(((ItemLabelBatchId)argObjectId).getOrganizationId());
/* 203 */     setRetailLocationId(((ItemLabelBatchId)argObjectId).getRetailLocationId());
/* 204 */     setBatchName(((ItemLabelBatchId)argObjectId).getBatchName());
/* 205 */     setItemId(((ItemLabelBatchId)argObjectId).getItemId());
/* 206 */     setStockLabel(((ItemLabelBatchId)argObjectId).getStockLabel());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 210 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 214 */     StringBuilder buf = new StringBuilder(550);
/* 215 */     buf.append("<").append("dao").append(" name=\"ItemLabelBatch\" cmd=\"" + getObjectStateString() + "\">");
/* 216 */     getFieldsAsXml(buf);
/* 217 */     buf.append("</").append("dao").append(">");
/*     */     
/* 219 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 223 */     Map<String, String> values = super.getValues();
/* 224 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 225 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 226 */     if (this._batchName != null) values.put("BatchName", DaoUtils.getXmlSafeFieldValue(12, this._batchName)); 
/* 227 */     if (this._itemId != null) values.put("ItemId", DaoUtils.getXmlSafeFieldValue(12, this._itemId)); 
/* 228 */     if (this._stockLabel != null) values.put("StockLabel", DaoUtils.getXmlSafeFieldValue(12, this._stockLabel)); 
/* 229 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 230 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 231 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 232 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 233 */     if (this._count != null) values.put("Count", DaoUtils.getXmlSafeFieldValue(-5, this._count)); 
/* 234 */     if (this._overridenPrice != null) values.put("OverridenPrice", DaoUtils.getXmlSafeFieldValue(3, this._overridenPrice)); 
/* 235 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 240 */     super.setValues(argValues);
/* 241 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 243 */       String fieldName = field.getKey();
/* 244 */       String fieldValue = field.getValue();
/* 245 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 249 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 250 */             setOrganizationId((Long)value);
/* 251 */           } catch (Exception ee) {
/* 252 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 258 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 259 */             setRetailLocationId((Long)value);
/* 260 */           } catch (Exception ee) {
/* 261 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BatchName":
/*     */           try {
/* 267 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 268 */             setBatchName((String)value);
/* 269 */           } catch (Exception ee) {
/* 270 */             throw new DtxException("An exception occurred while calling setBatchName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemId":
/*     */           try {
/* 276 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 277 */             setItemId((String)value);
/* 278 */           } catch (Exception ee) {
/* 279 */             throw new DtxException("An exception occurred while calling setItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StockLabel":
/*     */           try {
/* 285 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 286 */             setStockLabel((String)value);
/* 287 */           } catch (Exception ee) {
/* 288 */             throw new DtxException("An exception occurred while calling setStockLabel() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 294 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 295 */             setCreateDate((Date)value);
/* 296 */           } catch (Exception ee) {
/* 297 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 303 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 304 */             setCreateUserId((String)value);
/* 305 */           } catch (Exception ee) {
/* 306 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 312 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 313 */             setUpdateDate((Date)value);
/* 314 */           } catch (Exception ee) {
/* 315 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 321 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 322 */             setUpdateUserId((String)value);
/* 323 */           } catch (Exception ee) {
/* 324 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Count":
/*     */           try {
/* 330 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 331 */             setCount((Long)value);
/* 332 */           } catch (Exception ee) {
/* 333 */             throw new DtxException("An exception occurred while calling setCount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OverridenPrice":
/*     */           try {
/* 339 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 340 */             setOverridenPrice((BigDecimal)value);
/* 341 */           } catch (Exception ee) {
/* 342 */             throw new DtxException("An exception occurred while calling setOverridenPrice() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemLabelBatchDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */