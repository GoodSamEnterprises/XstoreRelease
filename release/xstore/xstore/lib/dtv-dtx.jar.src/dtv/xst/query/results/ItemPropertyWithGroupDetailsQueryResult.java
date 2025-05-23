/*     */ package dtv.xst.query.results;
/*     */ 
/*     */ import dtv.data2.access.AbstractQueryResult;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.i18n.FormattableFactory;
/*     */ import dtv.i18n.OutputContextType;
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
/*     */ public class ItemPropertyWithGroupDetailsQueryResult
/*     */   extends AbstractQueryResult
/*     */ {
/*     */   private static final long serialVersionUID = 1719943481192063523L;
/*     */   private String itemId_;
/*     */   private String itemName_;
/*     */   private String description_;
/*     */   private String stringValue_;
/*     */   private String propertyCode_;
/*     */   private String propertyValueDescription_;
/*     */   private String propertyCodeDescription_;
/*     */   private int propertyCodeSortOrder_;
/*     */   
/*     */   public String getCustomGroupDetailsString() {
/*  36 */     return getStringValue() + "  " + FormattableFactory.getInstance()
/*  37 */       .getSimpleFormattable(getPropertyValueDescription()).toString(OutputContextType.VIEW);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/*  46 */     return this.description_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemId() {
/*  55 */     return this.itemId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemName() {
/*  64 */     return this.itemName_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPropertyCode() {
/*  73 */     return this.propertyCode_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPropertyCodeDescription() {
/*  82 */     return this.propertyCodeDescription_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPropertyCodeSortOrder() {
/*  91 */     return this.propertyCodeSortOrder_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPropertyValueDescription() {
/* 100 */     return this.propertyValueDescription_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStringValue() {
/* 109 */     return this.stringValue_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 118 */     this.description_ = argDescription;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 127 */     this.itemId_ = argItemId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemName(String argItemName) {
/* 136 */     this.itemName_ = argItemName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/* 145 */     this.propertyCode_ = argPropertyCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPropertyCodeDescription(String argPropertyCodeDescription) {
/* 154 */     this.propertyCodeDescription_ = argPropertyCodeDescription;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPropertyCodeSortOrder(int argPropertyCodeSortOrder) {
/* 163 */     this.propertyCodeSortOrder_ = argPropertyCodeSortOrder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPropertyValueDescription(String argPropertyDescription) {
/* 172 */     this.propertyValueDescription_ = argPropertyDescription;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/* 181 */     this.stringValue_ = argStringValue;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected IObjectId getObjectIdImpl() {
/* 187 */     ItemId id = new ItemId();
/* 188 */     id.setItemId(getItemId());
/* 189 */     return (IObjectId)id;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\ItemPropertyWithGroupDetailsQueryResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */