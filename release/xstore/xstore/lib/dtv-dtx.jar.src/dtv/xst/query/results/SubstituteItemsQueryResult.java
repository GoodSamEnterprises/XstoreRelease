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
/*     */ public class SubstituteItemsQueryResult
/*     */   extends AbstractQueryResult
/*     */   implements IOverridableOrgHierarchyResult
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private String _itemId;
/*     */   private String _description;
/*     */   private String _primaryItemId;
/*     */   private String _substituteItemLevel;
/*     */   private String _substituteITemCode;
/*     */   
/*     */   public String getDescription() {
/*  33 */     return this._description;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IObjectId getFilteringObjectId() {
/*  39 */     ItemId id = new ItemId();
/*  40 */     id.setItemId(getPrimaryItemId());
/*  41 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemId() {
/*  50 */     return this._itemId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLevelCode() {
/*  56 */     return this._substituteITemCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLevelValue() {
/*  62 */     return this._substituteItemLevel;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPrimaryItemId() {
/*  71 */     return this._primaryItemId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/*  80 */     this._description = argDescription;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemId(String argItemId) {
/*  89 */     this._itemId = argItemId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPrimaryItemId(String argPrimaryItemId) {
/*  98 */     this._primaryItemId = argPrimaryItemId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected IObjectId getObjectIdImpl() {
/* 104 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\SubstituteItemsQueryResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */