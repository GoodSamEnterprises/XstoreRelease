/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.data2.access.impl.IHasIncrementalValues;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.StockLedgerId;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StockLedgerDAO
/*     */   extends AbstractDAOImpl
/*     */   implements IHasIncrementalValues
/*     */ {
/*     */   private static final long serialVersionUID = 282529791L;
/*  23 */   private static final Logger _logger = Logger.getLogger(StockLedgerDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _bucketId;
/*     */   private String _invLocationId;
/*     */   private String _itemId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _unitcount;
/*     */   private BigDecimal _initUnitcount;
/*     */   private BigDecimal _inventoryValue;
/*     */   protected boolean _incrementalActive = true;
/*     */   
/*     */   public void setIncrementalActive(boolean argActive) {
/*  40 */     this._incrementalActive = argActive;
/*     */   }
/*     */   
/*     */   public boolean getIncrementalActive() {
/*  44 */     return this._incrementalActive;
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  48 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  52 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  53 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  58 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  62 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  63 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getBucketId() {
/*  68 */     return this._bucketId;
/*     */   }
/*     */   
/*     */   public void setBucketId(String argBucketId) {
/*  72 */     if (changed(argBucketId, this._bucketId, "bucketId")) {
/*  73 */       this._bucketId = (argBucketId != null && MANAGE_CASE) ? argBucketId.toUpperCase() : argBucketId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getInvLocationId() {
/*  78 */     return this._invLocationId;
/*     */   }
/*     */   
/*     */   public void setInvLocationId(String argInvLocationId) {
/*  82 */     if (changed(argInvLocationId, this._invLocationId, "invLocationId")) {
/*  83 */       this._invLocationId = (argInvLocationId != null && MANAGE_CASE) ? argInvLocationId.toUpperCase() : argInvLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getItemId() {
/*  88 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/*  92 */     if (changed(argItemId, this._itemId, "itemId")) {
/*  93 */       this._itemId = (argItemId != null && MANAGE_CASE) ? argItemId.toUpperCase() : argItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  98 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 102 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 103 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 109 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 113 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 114 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 119 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 123 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 124 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 130 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 134 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 135 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getUnitcount() {
/* 140 */     return this._unitcount;
/*     */   }
/*     */   
/*     */   public BigDecimal getInitUnitcount() {
/* 144 */     return this._initUnitcount;
/*     */   }
/*     */   
/*     */   public void setUnitcount(BigDecimal argUnitcount) {
/* 148 */     if (changed(argUnitcount, this._unitcount, "unitcount")) {
/* 149 */       this._unitcount = argUnitcount;
/*     */     }
/*     */   }
/*     */   
/*     */   public void setInitUnitcount(BigDecimal argUnitcount) {
/* 154 */     this._initUnitcount = argUnitcount;
/*     */   }
/*     */   
/*     */   public BigDecimal getInventoryValue() {
/* 158 */     return this._inventoryValue;
/*     */   }
/*     */   
/*     */   public void setInventoryValue(BigDecimal argInventoryValue) {
/* 162 */     if (changed(argInventoryValue, this._inventoryValue, "inventoryValue")) {
/* 163 */       this._inventoryValue = argInventoryValue;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private BigDecimal getUnitcountDiff() {
/*     */     BigDecimal val1, val2;
/* 172 */     if (this._unitcount == null) {
/* 173 */       val1 = new BigDecimal(0);
/*     */     } else {
/*     */       
/* 176 */       val1 = this._unitcount;
/*     */     } 
/*     */     
/* 179 */     if (this._initUnitcount == null) {
/* 180 */       val2 = new BigDecimal(0);
/*     */     } else {
/*     */       
/* 183 */       val2 = this._initUnitcount;
/*     */     } 
/*     */     
/* 186 */     BigDecimal res = val1.subtract(val2);
/*     */     
/* 188 */     if (res.scale() < 8) {
/* 189 */       res = res.setScale(8);
/*     */     }
/*     */     
/* 192 */     return res;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 197 */     StringBuilder buf = new StringBuilder(512);
/* 198 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 199 */     if (getOrganizationId() != null) {
/* 200 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 202 */     if (getRetailLocationId() != null) {
/* 203 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 205 */     if (getBucketId() != null) {
/* 206 */       buf.append("bucketId").append("=").append(getBucketId()).append(" ");
/*     */     }
/* 208 */     if (getInvLocationId() != null) {
/* 209 */       buf.append("invLocationId").append("=").append(getInvLocationId()).append(" ");
/*     */     }
/* 211 */     if (getItemId() != null) {
/* 212 */       buf.append("itemId").append("=").append(getItemId()).append(" ");
/*     */     }
/* 214 */     if (getCreateDate() != null) {
/* 215 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 217 */     if (getCreateUserId() != null) {
/* 218 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 220 */     if (getUpdateDate() != null) {
/* 221 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 223 */     if (getUpdateUserId() != null) {
/* 224 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 226 */     if (getUnitcount() != null) {
/* 227 */       buf.append("unitcount").append("=").append(getUnitcount()).append(" ");
/*     */     }
/* 229 */     if (getInventoryValue() != null) {
/* 230 */       buf.append("inventoryValue").append("=").append(getInventoryValue()).append(" ");
/*     */     }
/*     */     
/* 233 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 237 */     StockLedgerId id = new StockLedgerId();
/* 238 */     id.setOrganizationId(getOrganizationId());
/* 239 */     id.setRetailLocationId(getRetailLocationId());
/* 240 */     id.setBucketId(getBucketId());
/* 241 */     id.setInvLocationId(getInvLocationId());
/* 242 */     id.setItemId(getItemId());
/* 243 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 247 */     setOrganizationId(((StockLedgerId)argObjectId).getOrganizationId());
/* 248 */     setRetailLocationId(((StockLedgerId)argObjectId).getRetailLocationId());
/* 249 */     setBucketId(((StockLedgerId)argObjectId).getBucketId());
/* 250 */     setInvLocationId(((StockLedgerId)argObjectId).getInvLocationId());
/* 251 */     setItemId(((StockLedgerId)argObjectId).getItemId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 255 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 259 */     StringBuilder buf = new StringBuilder(550);
/* 260 */     buf.append("<").append("dao").append(" name=\"StockLedger\" cmd=\"" + getObjectStateString() + "\">");
/* 261 */     getFieldsAsXml(buf);
/* 262 */     buf.append("</").append("dao").append(">");
/*     */     
/* 264 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 268 */     Map<String, String> values = super.getValues();
/* 269 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 270 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 271 */     if (this._bucketId != null) values.put("BucketId", DaoUtils.getXmlSafeFieldValue(12, this._bucketId)); 
/* 272 */     if (this._invLocationId != null) values.put("InvLocationId", DaoUtils.getXmlSafeFieldValue(12, this._invLocationId)); 
/* 273 */     if (this._itemId != null) values.put("ItemId", DaoUtils.getXmlSafeFieldValue(12, this._itemId)); 
/* 274 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 275 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 276 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 277 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 278 */     if (this._unitcount != null) values.put("Unitcount", DaoUtils.getXmlSafeFieldValue(3, getUnitcountDiff())); 
/* 279 */     if (this._inventoryValue != null) values.put("InventoryValue", DaoUtils.getXmlSafeFieldValue(3, this._inventoryValue)); 
/* 280 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 285 */     super.setValues(argValues);
/* 286 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 288 */       String fieldName = field.getKey();
/* 289 */       String fieldValue = field.getValue();
/* 290 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 294 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 295 */             setOrganizationId((Long)value);
/* 296 */           } catch (Exception ee) {
/* 297 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 303 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 304 */             setRetailLocationId((Long)value);
/* 305 */           } catch (Exception ee) {
/* 306 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BucketId":
/*     */           try {
/* 312 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 313 */             setBucketId((String)value);
/* 314 */           } catch (Exception ee) {
/* 315 */             throw new DtxException("An exception occurred while calling setBucketId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InvLocationId":
/*     */           try {
/* 321 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 322 */             setInvLocationId((String)value);
/* 323 */           } catch (Exception ee) {
/* 324 */             throw new DtxException("An exception occurred while calling setInvLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemId":
/*     */           try {
/* 330 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 331 */             setItemId((String)value);
/* 332 */           } catch (Exception ee) {
/* 333 */             throw new DtxException("An exception occurred while calling setItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 339 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 340 */             setCreateDate((Date)value);
/* 341 */           } catch (Exception ee) {
/* 342 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 348 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 349 */             setCreateUserId((String)value);
/* 350 */           } catch (Exception ee) {
/* 351 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 357 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 358 */             setUpdateDate((Date)value);
/* 359 */           } catch (Exception ee) {
/* 360 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 366 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 367 */             setUpdateUserId((String)value);
/* 368 */           } catch (Exception ee) {
/* 369 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Unitcount":
/*     */           try {
/* 375 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 376 */             setUnitcount((BigDecimal)value);
/* 377 */           } catch (Exception ee) {
/* 378 */             throw new DtxException("An exception occurred while calling setUnitcount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InventoryValue":
/*     */           try {
/* 384 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 385 */             setInventoryValue((BigDecimal)value);
/* 386 */           } catch (Exception ee) {
/* 387 */             throw new DtxException("An exception occurred while calling setInventoryValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\StockLedgerDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */