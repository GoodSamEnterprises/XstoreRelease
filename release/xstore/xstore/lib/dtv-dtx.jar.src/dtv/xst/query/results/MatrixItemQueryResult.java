/*     */ package dtv.xst.query.results;
/*     */ 
/*     */ import dtv.data2.access.AbstractQueryResult;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.IOverridableOrgHierarchyResult;
/*     */ import dtv.xst.dao.itm.ItemId;
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
/*     */ public class MatrixItemQueryResult
/*     */   extends AbstractQueryResult
/*     */   implements IOverridableOrgHierarchyResult
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private String itemId_;
/*     */   private String description_;
/*     */   private String itemMatrixColor_;
/*     */   private String _merchLevel1Id;
/*     */   private String _merchLevel2Id;
/*     */   private String _merchLevel3Id;
/*     */   private String _merchLevel4Id;
/*     */   private Integer matrixSortOrder_;
/*     */   private boolean _disallowMatrixDisplay;
/*     */   private String _availabilityCode;
/*     */   private String _optionsLevelCode;
/*     */   private String _optionsLevelValue;
/*     */   private String imageUrl_;
/*     */   
/*     */   public String getAvailabilityCode() {
/*  41 */     return this._availabilityCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/*  50 */     return this.description_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getDisallowMatrixDisplay() {
/*  59 */     return this._disallowMatrixDisplay;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IObjectId getFilteringObjectId() {
/*  65 */     return getObjectIdImpl();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getImageUrl() {
/*  74 */     return this.imageUrl_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemId() {
/*  83 */     return this.itemId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemMatrixColor() {
/*  92 */     return this.itemMatrixColor_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLevelCode() {
/*  98 */     return this._optionsLevelCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLevelValue() {
/* 104 */     return this._optionsLevelValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMerchLevel1Id() {
/* 113 */     return this._merchLevel1Id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMerchLevel2Id() {
/* 122 */     return this._merchLevel2Id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMerchLevel3Id() {
/* 131 */     return this._merchLevel3Id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMerchLevel4Id() {
/* 140 */     return this._merchLevel4Id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSortOrder() {
/* 149 */     if (this.matrixSortOrder_ == null) {
/* 150 */       return -1;
/*     */     }
/*     */     
/* 153 */     return this.matrixSortOrder_.intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAvailabilityCode(String argAvailabilityCode) {
/* 162 */     this._availabilityCode = argAvailabilityCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 171 */     this.description_ = argDescription;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDisallowMatrixDisplay(boolean argDisallowMatrixDisplay) {
/* 180 */     this._disallowMatrixDisplay = argDisallowMatrixDisplay;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setImageUrl(String argImageUrl) {
/* 189 */     this.imageUrl_ = argImageUrl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 198 */     this.itemId_ = argItemId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemMatrixColor(String argItemMatrixColor) {
/* 207 */     this.itemMatrixColor_ = argItemMatrixColor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLevelCode(String argOptionsLevelCode) {
/* 216 */     this._optionsLevelCode = argOptionsLevelCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLevelValue(String argOptionsLevelValue) {
/* 225 */     this._optionsLevelValue = argOptionsLevelValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMerchLevel1Id(String argMerchLevel1Id) {
/* 234 */     this._merchLevel1Id = argMerchLevel1Id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMerchLevel2Id(String argMerchLevel2Id) {
/* 243 */     this._merchLevel2Id = argMerchLevel2Id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMerchLevel3Id(String argMerchLevel3Id) {
/* 252 */     this._merchLevel3Id = argMerchLevel3Id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMerchLevel4Id(String argMerchLevel4Id) {
/* 261 */     this._merchLevel4Id = argMerchLevel4Id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSortOrder(int argSortOrder) {
/* 270 */     this.matrixSortOrder_ = Integer.valueOf(argSortOrder);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected IObjectId getObjectIdImpl() {
/* 276 */     ItemId id = new ItemId();
/* 277 */     id.setItemId(getItemId());
/* 278 */     return (IObjectId)id;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\MatrixItemQueryResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */