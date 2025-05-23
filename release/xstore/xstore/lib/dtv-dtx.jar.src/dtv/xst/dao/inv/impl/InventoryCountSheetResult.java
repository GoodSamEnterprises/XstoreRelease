/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.AbstractQueryResult;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.xst.dao.inv.InventoryCountSheetId;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InventoryCountSheetResult
/*     */   extends AbstractQueryResult
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private long _organizationId;
/*     */   private long _retailLocationId;
/*     */   private String _countId;
/*     */   private int _countCycle;
/*     */   private int _countSheetNumber;
/*     */   private String _inventoryBucketId;
/*     */   private String _inventoryBucketName;
/*     */   private String _sectionId;
/*     */   private int _sectionNumber;
/*     */   private String _sheetStatus;
/*     */   
/*     */   public int getCountCycle() {
/*  38 */     return this._countCycle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCountId() {
/*  47 */     return this._countId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCountSheetNumber() {
/*  56 */     return this._countSheetNumber;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getInventoryBucketId() {
/*  65 */     return this._inventoryBucketId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getInventoryBucketName() {
/*  74 */     return this._inventoryBucketName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  83 */     return this._organizationId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRetailLocationId() {
/*  92 */     return this._retailLocationId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSectionId() {
/* 101 */     return this._sectionId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSectionNumber() {
/* 110 */     return this._sectionNumber;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSheetStatus() {
/* 119 */     return this._sheetStatus;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCountCycle(int argCountCycle) {
/* 128 */     this._countCycle = argCountCycle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCountId(String argCountId) {
/* 137 */     this._countId = argCountId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCountSheetNumber(int argCountSheetNumber) {
/* 146 */     this._countSheetNumber = argCountSheetNumber;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInventoryBucketId(String argInventoryBucketId) {
/* 155 */     this._inventoryBucketId = argInventoryBucketId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInventoryBucketName(String argInventoryBucketName) {
/* 164 */     this._inventoryBucketName = argInventoryBucketName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 173 */     this._organizationId = argOrganizationId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(long argRetailLocationId) {
/* 182 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSectionId(String argSectionId) {
/* 191 */     this._sectionId = argSectionId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSectionNumber(int argSectionNumber) {
/* 200 */     this._sectionNumber = argSectionNumber;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSheetStatus(String argSheetStatus) {
/* 209 */     this._sheetStatus = argSheetStatus;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected IObjectId getObjectIdImpl() {
/* 215 */     InventoryCountSheetId id = new InventoryCountSheetId();
/* 216 */     id.setOrganizationId(Long.valueOf(this._organizationId));
/* 217 */     id.setRetailLocationId(Long.valueOf(this._retailLocationId));
/* 218 */     id.setInventoryCountId(this._countId);
/* 219 */     id.setCountSheetNumber(Integer.valueOf(this._countSheetNumber));
/* 220 */     return (IObjectId)id;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryCountSheetResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */