/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import com.google.common.collect.LinkedListMultimap;
/*     */ import com.google.common.collect.ListMultimap;
/*     */ import com.google.common.collect.Multimaps;
/*     */ import dtv.data2.access.IDataProperty;
/*     */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*     */ import dtv.util.CompositeObject;
/*     */ import dtv.xst.dao.itm.IItem;
/*     */ import dtv.xst.dao.itm.IItemDealProperty;
/*     */ import dtv.xst.dao.itm.IItemDimensionType;
/*     */ import dtv.xst.dao.itm.IItemDimensionValue;
/*     */ import dtv.xst.dao.itm.IItemImage;
/*     */ import dtv.xst.dao.itm.IItemModel;
/*     */ import dtv.xst.dao.itm.IItemOptions;
/*     */ import dtv.xst.dao.itm.IItemPromptProperty;
/*     */ import dtv.xst.dao.itm.IItemProperty;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class ItemBaseModel
/*     */   extends AbstractDataModelWithPropertyImpl<IItemProperty>
/*     */   implements IItemModel, IItem
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private transient String messageKey_;
/*     */   private transient ListMultimap<String, IItemDealProperty> propertiesByName_;
/*     */   private transient ListMultimap<String, IDataProperty> promptPropertiesByName_;
/*     */   private transient IItemOptions _itemOptions;
/*     */   
/*     */   public void buildPromptPropertiesMap() {
/*  34 */     this
/*  35 */       .promptPropertiesByName_ = Multimaps.synchronizedListMultimap(
/*  36 */         (ListMultimap)LinkedListMultimap.create());
/*     */     
/*  38 */     List<IItemPromptProperty> itemPromptProperties = getItemPromptProperties();
/*     */     
/*  40 */     if (itemPromptProperties == null || itemPromptProperties.isEmpty()) {
/*     */       return;
/*     */     }
/*     */     
/*  44 */     String name = null;
/*  45 */     IDataProperty property = null;
/*     */     
/*  47 */     for (int i = 0; i < itemPromptProperties.size(); i++) {
/*  48 */       property = (IDataProperty)itemPromptProperties.get(i);
/*  49 */       name = property.getPropertyCode().toUpperCase();
/*  50 */       this.promptPropertiesByName_.put(name, property);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void buildPropertiesMap() {
/*  57 */     this
/*  58 */       .propertiesByName_ = Multimaps.synchronizedListMultimap(
/*  59 */         (ListMultimap)LinkedListMultimap.create());
/*     */     
/*  61 */     List<IItemDealProperty> itemDealProperties = getItemDealProperties();
/*     */     
/*  63 */     if (itemDealProperties == null || itemDealProperties.isEmpty()) {
/*     */       return;
/*     */     }
/*     */     
/*  67 */     String name = null;
/*  68 */     IItemDealProperty property = null;
/*     */     
/*  70 */     for (int i = 0; i < itemDealProperties.size(); i++) {
/*  71 */       property = itemDealProperties.get(i);
/*  72 */       name = property.getItemDealPropertyCode().toUpperCase();
/*  73 */       this.propertiesByName_.put(name, property);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/*  80 */     if (getDAO_().getDescription() == null && getParentItem() != null) {
/*  81 */       return getParentItem().getDescription();
/*     */     }
/*     */     
/*  84 */     return getDAO_().getDescription();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IItemDimensionType getItemDimensionType(int argIndex) {
/*  91 */     IItemDimensionType result = null;
/*     */     
/*  93 */     for (IItemDimensionType type : getItemDimensionTypes()) {
/*  94 */       if (argIndex == type.getSequence()) {
/*  95 */         result = type;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 100 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemDimensionValue(int argIndex) {
/* 106 */     String dimValue = null;
/*     */     
/* 108 */     if (argIndex == 1) {
/* 109 */       dimValue = getDimension1();
/*     */     }
/* 111 */     else if (argIndex == 2) {
/* 112 */       dimValue = getDimension2();
/*     */     }
/* 114 */     else if (argIndex == 3) {
/* 115 */       dimValue = getDimension3();
/*     */     } 
/*     */     
/* 118 */     return dimValue;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IItemDimensionValue> getItemDimensionValues(String argDimension) {
/* 124 */     List<IItemDimensionValue> results = new ArrayList<>();
/*     */     
/* 126 */     for (IItemDimensionValue value : getItemDimensionValues()) {
/* 127 */       if (value.getDimension().equalsIgnoreCase(argDimension)) {
/* 128 */         results.add(value);
/*     */       }
/*     */     } 
/*     */     
/* 132 */     return results;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IItemImage getItemImage(String argFeatureId) {
/* 138 */     IItemImage defaultImage = null;
/*     */     
/* 140 */     for (IItemImage image : getItemImages()) {
/* 141 */       if (image.getFeatureId().equalsIgnoreCase("DEFAULT")) {
/* 142 */         defaultImage = image;
/*     */       }
/*     */       
/* 145 */       if (image.getFeatureId().equalsIgnoreCase(argFeatureId)) {
/* 146 */         return image;
/*     */       }
/*     */     } 
/*     */     
/* 150 */     return defaultImage;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMerchLevel1Id() {
/* 156 */     if (getDAO_().getMerchLevel1Id() != null) {
/* 157 */       return getDAO_().getMerchLevel1Id();
/*     */     }
/* 159 */     if (getParentItem() != null) {
/* 160 */       return getParentItem().getMerchLevel1Id();
/*     */     }
/*     */     
/* 163 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMerchLevel2Id() {
/* 170 */     if (getDAO_().getMerchLevel2Id() != null) {
/* 171 */       return getDAO_().getMerchLevel2Id();
/*     */     }
/* 173 */     if (getParentItem() != null) {
/* 174 */       return getParentItem().getMerchLevel2Id();
/*     */     }
/*     */     
/* 177 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMerchLevel3Id() {
/* 184 */     if (getDAO_().getMerchLevel3Id() != null) {
/* 185 */       return getDAO_().getMerchLevel3Id();
/*     */     }
/* 187 */     if (getParentItem() != null) {
/* 188 */       return getParentItem().getMerchLevel3Id();
/*     */     }
/*     */     
/* 191 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMerchLevel4Id() {
/* 198 */     if (getDAO_().getMerchLevel4Id() != null) {
/* 199 */       return getDAO_().getMerchLevel4Id();
/*     */     }
/* 201 */     if (getParentItem() != null) {
/* 202 */       return getParentItem().getMerchLevel4Id();
/*     */     }
/*     */     
/* 205 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMessageKey() {
/* 216 */     return this.messageKey_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IItemOptions getOptions() {
/* 222 */     if (this._itemOptions == null)
/*     */     {
/*     */       
/* 225 */       for (CompositeObject.TwoPiece<String, String> orgNode : (Iterable<CompositeObject.TwoPiece<String, String>>)this._persistenceDefaults
/* 226 */         .getOrgHierarchyAncestry()) {
/* 227 */         for (IItemOptions possibleOptions : getItemOptions()) {
/* 228 */           if (possibleOptions.getLevelCode().equals(orgNode.a()) && possibleOptions
/* 229 */             .getLevelValue().equals(orgNode.b())) {
/*     */             
/* 231 */             this._itemOptions = possibleOptions;
/*     */             
/*     */             // Byte code: goto -> 120
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/* 238 */     return this._itemOptions;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IDataProperty> getPromptPropertiesByCode(String argCode) {
/* 244 */     if (this.promptPropertiesByName_ == null) {
/* 245 */       buildPromptPropertiesMap();
/*     */     }
/*     */     
/* 248 */     return this.promptPropertiesByName_.get(argCode.toUpperCase());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IItemDealProperty> getPropertiesByCode(String argCode) {
/* 254 */     if (this.propertiesByName_ == null) {
/* 255 */       buildPropertiesMap();
/*     */     }
/*     */     
/* 258 */     return this.propertiesByName_.get(argCode.toUpperCase());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IItemDealProperty> getPropertiesByCode(String[] argCodeArray) {
/* 264 */     if (this.propertiesByName_ == null) {
/* 265 */       buildPropertiesMap();
/*     */     }
/*     */     
/* 268 */     List<IItemDealProperty> returnList = new ArrayList<>();
/*     */     
/* 270 */     for (String code : argCodeArray) {
/* 271 */       returnList.addAll(this.propertiesByName_.get(code.toUpperCase()));
/*     */     }
/*     */     
/* 274 */     return returnList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMessageKey(String messageKey) {
/* 284 */     this.messageKey_ = messageKey;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ItemDAO getDAO_() {
/* 292 */     return (ItemDAO)this._daoImpl;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */