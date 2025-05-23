/*     */ package dtv.xst.query.results;
/*     */ 
/*     */ import dtv.data2.access.AbstractQueryResult;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.xst.dao.itm.MerchandiseHierarchyId;
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
/*     */ public class MatrixMerchHierarchyQueryResult
/*     */   extends AbstractQueryResult
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private String hierarchyId_;
/*     */   private String description_;
/*     */   private String levelCode_;
/*     */   private String parentId_;
/*     */   private String itemMatrixColor_;
/*     */   private Integer matrixSortOrder_;
/*     */   private String imageUrl_;
/*     */   
/*     */   public String getDescription() {
/*  34 */     return this.description_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getHierarchyId() {
/*  43 */     return this.hierarchyId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getImageUrl() {
/*  52 */     return this.imageUrl_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemMatrixColor() {
/*  61 */     return this.itemMatrixColor_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLevelCode() {
/*  70 */     return this.levelCode_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getParentId() {
/*  79 */     return this.parentId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSortOrder() {
/*  88 */     if (this.matrixSortOrder_ == null) {
/*  89 */       return -1;
/*     */     }
/*     */     
/*  92 */     return this.matrixSortOrder_.intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 101 */     this.description_ = argDescription;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHierarchyId(String argHierarchyId) {
/* 110 */     this.hierarchyId_ = argHierarchyId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setImageUrl(String argImageUrl) {
/* 119 */     this.imageUrl_ = argImageUrl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemMatrixColor(String argItemMatrixColor) {
/* 128 */     this.itemMatrixColor_ = argItemMatrixColor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLevelCode(String argLevelCode) {
/* 137 */     this.levelCode_ = argLevelCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParentId(String argParentId) {
/* 146 */     this.parentId_ = argParentId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSortOrder(int argSortOrder) {
/* 155 */     this.matrixSortOrder_ = Integer.valueOf(argSortOrder);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected IObjectId getObjectIdImpl() {
/* 161 */     MerchandiseHierarchyId id = new MerchandiseHierarchyId();
/* 162 */     id.setHierarchyId(getHierarchyId());
/* 163 */     return (IObjectId)id;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\MatrixMerchHierarchyQueryResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */