/*      */ package dtv.xst.dao.itm.impl;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.impl.IDataModelImpl;
/*      */ import dtv.event.EventDescriptor;
/*      */ import dtv.event.IEventAware;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.itm.IItem;
/*      */ import dtv.xst.dao.itm.IItemDealProperty;
/*      */ import dtv.xst.dao.itm.IItemDimensionType;
/*      */ import dtv.xst.dao.itm.IItemDimensionValue;
/*      */ import dtv.xst.dao.itm.IItemImage;
/*      */ import dtv.xst.dao.itm.IItemOptions;
/*      */ import dtv.xst.dao.itm.IItemPromptProperty;
/*      */ import dtv.xst.dao.itm.IItemProperty;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class ItemModel extends ItemBaseModel implements IItem {
/*      */   private static final long serialVersionUID = 2289459L;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   private IDataModel _myExtension;
/*      */   private HistoricalList<IItemOptions> _itemOptions;
/*      */   private transient HistoricalList<IItemOptions> _itemOptionsSavepoint;
/*      */   private IItem _parentItem;
/*      */   private transient IItem _parentItemSavepoint;
/*      */   private HistoricalList<IItemDealProperty> _itemDealProperties;
/*      */   private transient HistoricalList<IItemDealProperty> _itemDealPropertiesSavepoint;
/*      */   private HistoricalList<IItemPromptProperty> _itemPromptProperties;
/*      */   
/*      */   public String toString() {
/*   36 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private transient HistoricalList<IItemPromptProperty> _itemPromptPropertiesSavepoint; private IItemLabelProperties _itemLabelProperties; private transient IItemLabelProperties _itemLabelPropertiesSavepoint; private HistoricalList<IItemImage> _itemImages; private transient HistoricalList<IItemImage> _itemImagesSavepoint; private HistoricalList<IItemDimensionType> _itemDimensionTypes; private transient HistoricalList<IItemDimensionType> _itemDimensionTypesSavepoint; private HistoricalList<IItemDimensionValue> _itemDimensionValues; private transient HistoricalList<IItemDimensionValue> _itemDimensionValuesSavepoint; private HistoricalList<IItemProperty> _properties; private transient HistoricalList<IItemProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   41 */     setDAO((IDataAccessObject)new ItemDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private ItemDAO getDAO_() {
/*   49 */     return (ItemDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*   57 */     if (getDAO_().getOrganizationId() != null) {
/*   58 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*      */     
/*   61 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*   70 */     if (setOrganizationId_noev(argOrganizationId) && 
/*   71 */       this._events != null && 
/*   72 */       postEventsForChanges()) {
/*   73 */       this._events.post(IItem.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*   80 */     boolean ev_postable = false;
/*      */     
/*   82 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*   83 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*   84 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*   85 */       ev_postable = true;
/*   86 */       if (this._itemOptions != null) {
/*      */         
/*   88 */         Iterator<ItemOptionsModel> it = this._itemOptions.iterator();
/*   89 */         while (it.hasNext())
/*      */         {
/*   91 */           ((ItemOptionsModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*   94 */       if (this._itemDealProperties != null) {
/*      */         
/*   96 */         Iterator<ItemDealPropertyModel> it = this._itemDealProperties.iterator();
/*   97 */         while (it.hasNext())
/*      */         {
/*   99 */           ((ItemDealPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  102 */       if (this._itemPromptProperties != null) {
/*      */         
/*  104 */         Iterator<ItemPromptPropertyModel> it = this._itemPromptProperties.iterator();
/*  105 */         while (it.hasNext())
/*      */         {
/*  107 */           ((ItemPromptPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  110 */       if (this._itemImages != null) {
/*      */         
/*  112 */         Iterator<ItemImageModel> it = this._itemImages.iterator();
/*  113 */         while (it.hasNext())
/*      */         {
/*  115 */           ((ItemImageModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  118 */       if (this._itemDimensionTypes != null) {
/*      */         
/*  120 */         Iterator<ItemDimensionTypeModel> it = this._itemDimensionTypes.iterator();
/*  121 */         while (it.hasNext())
/*      */         {
/*  123 */           ((ItemDimensionTypeModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  126 */       if (this._itemDimensionValues != null) {
/*      */         
/*  128 */         Iterator<ItemDimensionValueModel> it = this._itemDimensionValues.iterator();
/*  129 */         while (it.hasNext())
/*      */         {
/*  131 */           ((ItemDimensionValueModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*  134 */       if (this._properties != null) {
/*      */         
/*  136 */         Iterator<ItemPropertyModel> it = this._properties.iterator();
/*  137 */         while (it.hasNext())
/*      */         {
/*  139 */           ((ItemPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  144 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getItemId() {
/*  152 */     return getDAO_().getItemId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setItemId(String argItemId) {
/*  160 */     if (setItemId_noev(argItemId) && 
/*  161 */       this._events != null && 
/*  162 */       postEventsForChanges()) {
/*  163 */       this._events.post(IItem.SET_ITEMID, argItemId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setItemId_noev(String argItemId) {
/*  170 */     boolean ev_postable = false;
/*      */     
/*  172 */     if ((getDAO_().getItemId() == null && argItemId != null) || (
/*  173 */       getDAO_().getItemId() != null && !getDAO_().getItemId().equals(argItemId))) {
/*  174 */       getDAO_().setItemId(argItemId);
/*  175 */       ev_postable = true;
/*  176 */       if (this._itemOptions != null) {
/*      */         
/*  178 */         Iterator<ItemOptionsModel> it = this._itemOptions.iterator();
/*  179 */         while (it.hasNext())
/*      */         {
/*  181 */           ((ItemOptionsModel)it.next()).setItemId_noev(argItemId);
/*      */         }
/*      */       } 
/*  184 */       if (this._itemDealProperties != null) {
/*      */         
/*  186 */         Iterator<ItemDealPropertyModel> it = this._itemDealProperties.iterator();
/*  187 */         while (it.hasNext())
/*      */         {
/*  189 */           ((ItemDealPropertyModel)it.next()).setItemId_noev(argItemId);
/*      */         }
/*      */       } 
/*  192 */       if (this._itemPromptProperties != null) {
/*      */         
/*  194 */         Iterator<ItemPromptPropertyModel> it = this._itemPromptProperties.iterator();
/*  195 */         while (it.hasNext())
/*      */         {
/*  197 */           ((ItemPromptPropertyModel)it.next()).setItemId_noev(argItemId);
/*      */         }
/*      */       } 
/*  200 */       if (this._itemImages != null) {
/*      */         
/*  202 */         Iterator<ItemImageModel> it = this._itemImages.iterator();
/*  203 */         while (it.hasNext())
/*      */         {
/*  205 */           ((ItemImageModel)it.next()).setItemId_noev(argItemId);
/*      */         }
/*      */       } 
/*  208 */       if (this._properties != null) {
/*      */         
/*  210 */         Iterator<ItemPropertyModel> it = this._properties.iterator();
/*  211 */         while (it.hasNext())
/*      */         {
/*  213 */           ((ItemPropertyModel)it.next()).setItemId_noev(argItemId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  218 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getClassName() {
/*  226 */     return getDAO_().getClassName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setClassName(String argClassName) {
/*  234 */     if (setClassName_noev(argClassName) && 
/*  235 */       this._events != null && 
/*  236 */       postEventsForChanges()) {
/*  237 */       this._events.post(IItem.SET_CLASSNAME, argClassName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setClassName_noev(String argClassName) {
/*  244 */     boolean ev_postable = false;
/*      */     
/*  246 */     if ((getDAO_().getClassName() == null && argClassName != null) || (
/*  247 */       getDAO_().getClassName() != null && !getDAO_().getClassName().equals(argClassName))) {
/*  248 */       getDAO_().setClassName(argClassName);
/*  249 */       ev_postable = true;
/*      */     } 
/*      */     
/*  252 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  260 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  268 */     if (setCreateDate_noev(argCreateDate) && 
/*  269 */       this._events != null && 
/*  270 */       postEventsForChanges()) {
/*  271 */       this._events.post(IItem.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  278 */     boolean ev_postable = false;
/*      */     
/*  280 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  281 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  282 */       getDAO_().setCreateDate(argCreateDate);
/*  283 */       ev_postable = true;
/*      */     } 
/*      */     
/*  286 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  294 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  302 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  303 */       this._events != null && 
/*  304 */       postEventsForChanges()) {
/*  305 */       this._events.post(IItem.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  312 */     boolean ev_postable = false;
/*      */     
/*  314 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  315 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  316 */       getDAO_().setCreateUserId(argCreateUserId);
/*  317 */       ev_postable = true;
/*      */     } 
/*      */     
/*  320 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  328 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  336 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  337 */       this._events != null && 
/*  338 */       postEventsForChanges()) {
/*  339 */       this._events.post(IItem.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  346 */     boolean ev_postable = false;
/*      */     
/*  348 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  349 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  350 */       getDAO_().setUpdateDate(argUpdateDate);
/*  351 */       ev_postable = true;
/*      */     } 
/*      */     
/*  354 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  362 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  370 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  371 */       this._events != null && 
/*  372 */       postEventsForChanges()) {
/*  373 */       this._events.post(IItem.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  380 */     boolean ev_postable = false;
/*      */     
/*  382 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  383 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  384 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  385 */       ev_postable = true;
/*      */     } 
/*      */     
/*  388 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOrgCode() {
/*  396 */     return getDAO_().getOrgCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrgCode(String argOrgCode) {
/*  404 */     if (setOrgCode_noev(argOrgCode) && 
/*  405 */       this._events != null && 
/*  406 */       postEventsForChanges()) {
/*  407 */       this._events.post(IItem.SET_ORGCODE, argOrgCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrgCode_noev(String argOrgCode) {
/*  414 */     boolean ev_postable = false;
/*      */     
/*  416 */     if ((getDAO_().getOrgCode() == null && argOrgCode != null) || (
/*  417 */       getDAO_().getOrgCode() != null && !getDAO_().getOrgCode().equals(argOrgCode))) {
/*  418 */       getDAO_().setOrgCode(argOrgCode);
/*  419 */       ev_postable = true;
/*      */     } 
/*      */     
/*  422 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOrgValue() {
/*  430 */     return getDAO_().getOrgValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrgValue(String argOrgValue) {
/*  438 */     if (setOrgValue_noev(argOrgValue) && 
/*  439 */       this._events != null && 
/*  440 */       postEventsForChanges()) {
/*  441 */       this._events.post(IItem.SET_ORGVALUE, argOrgValue);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrgValue_noev(String argOrgValue) {
/*  448 */     boolean ev_postable = false;
/*      */     
/*  450 */     if ((getDAO_().getOrgValue() == null && argOrgValue != null) || (
/*  451 */       getDAO_().getOrgValue() != null && !getDAO_().getOrgValue().equals(argOrgValue))) {
/*  452 */       getDAO_().setOrgValue(argOrgValue);
/*  453 */       ev_postable = true;
/*      */     } 
/*      */     
/*  456 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDescription(String argDescription) {
/*  464 */     if (setDescription_noev(argDescription) && 
/*  465 */       this._events != null && 
/*  466 */       postEventsForChanges()) {
/*  467 */       this._events.post(IItem.SET_DESCRIPTION, argDescription);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDescription_noev(String argDescription) {
/*  474 */     boolean ev_postable = false;
/*      */     
/*  476 */     if ((getDAO_().getDescription() == null && argDescription != null) || (
/*  477 */       getDAO_().getDescription() != null && !getDAO_().getDescription().equals(argDescription))) {
/*  478 */       getDAO_().setDescription(argDescription);
/*  479 */       ev_postable = true;
/*      */     } 
/*      */     
/*  482 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getItemLevelCode() {
/*  490 */     return getDAO_().getItemLevelCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setItemLevelCode(String argItemLevelCode) {
/*  498 */     if (setItemLevelCode_noev(argItemLevelCode) && 
/*  499 */       this._events != null && 
/*  500 */       postEventsForChanges()) {
/*  501 */       this._events.post(IItem.SET_ITEMLEVELCODE, argItemLevelCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setItemLevelCode_noev(String argItemLevelCode) {
/*  508 */     boolean ev_postable = false;
/*      */     
/*  510 */     if ((getDAO_().getItemLevelCode() == null && argItemLevelCode != null) || (
/*  511 */       getDAO_().getItemLevelCode() != null && !getDAO_().getItemLevelCode().equals(argItemLevelCode))) {
/*  512 */       getDAO_().setItemLevelCode(argItemLevelCode);
/*  513 */       ev_postable = true;
/*      */     } 
/*      */     
/*  516 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getItemTypeCode() {
/*  524 */     return getDAO_().getItemTypeCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setItemTypeCode(String argItemTypeCode) {
/*  532 */     if (setItemTypeCode_noev(argItemTypeCode) && 
/*  533 */       this._events != null && 
/*  534 */       postEventsForChanges()) {
/*  535 */       this._events.post(IItem.SET_ITEMTYPECODE, argItemTypeCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setItemTypeCode_noev(String argItemTypeCode) {
/*  542 */     boolean ev_postable = false;
/*      */     
/*  544 */     if ((getDAO_().getItemTypeCode() == null && argItemTypeCode != null) || (
/*  545 */       getDAO_().getItemTypeCode() != null && !getDAO_().getItemTypeCode().equals(argItemTypeCode))) {
/*  546 */       getDAO_().setItemTypeCode(argItemTypeCode);
/*  547 */       ev_postable = true;
/*      */     } 
/*      */     
/*  550 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMerchLevel1Id(String argMerchLevel1Id) {
/*  558 */     if (setMerchLevel1Id_noev(argMerchLevel1Id) && 
/*  559 */       this._events != null && 
/*  560 */       postEventsForChanges()) {
/*  561 */       this._events.post(IItem.SET_MERCHLEVEL1ID, argMerchLevel1Id);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setMerchLevel1Id_noev(String argMerchLevel1Id) {
/*  568 */     boolean ev_postable = false;
/*      */     
/*  570 */     if ((getDAO_().getMerchLevel1Id() == null && argMerchLevel1Id != null) || (
/*  571 */       getDAO_().getMerchLevel1Id() != null && !getDAO_().getMerchLevel1Id().equals(argMerchLevel1Id))) {
/*  572 */       getDAO_().setMerchLevel1Id(argMerchLevel1Id);
/*  573 */       ev_postable = true;
/*      */     } 
/*      */     
/*  576 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMerchLevel2Id(String argMerchLevel2Id) {
/*  584 */     if (setMerchLevel2Id_noev(argMerchLevel2Id) && 
/*  585 */       this._events != null && 
/*  586 */       postEventsForChanges()) {
/*  587 */       this._events.post(IItem.SET_MERCHLEVEL2ID, argMerchLevel2Id);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setMerchLevel2Id_noev(String argMerchLevel2Id) {
/*  594 */     boolean ev_postable = false;
/*      */     
/*  596 */     if ((getDAO_().getMerchLevel2Id() == null && argMerchLevel2Id != null) || (
/*  597 */       getDAO_().getMerchLevel2Id() != null && !getDAO_().getMerchLevel2Id().equals(argMerchLevel2Id))) {
/*  598 */       getDAO_().setMerchLevel2Id(argMerchLevel2Id);
/*  599 */       ev_postable = true;
/*      */     } 
/*      */     
/*  602 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMerchLevel3Id(String argMerchLevel3Id) {
/*  610 */     if (setMerchLevel3Id_noev(argMerchLevel3Id) && 
/*  611 */       this._events != null && 
/*  612 */       postEventsForChanges()) {
/*  613 */       this._events.post(IItem.SET_MERCHLEVEL3ID, argMerchLevel3Id);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setMerchLevel3Id_noev(String argMerchLevel3Id) {
/*  620 */     boolean ev_postable = false;
/*      */     
/*  622 */     if ((getDAO_().getMerchLevel3Id() == null && argMerchLevel3Id != null) || (
/*  623 */       getDAO_().getMerchLevel3Id() != null && !getDAO_().getMerchLevel3Id().equals(argMerchLevel3Id))) {
/*  624 */       getDAO_().setMerchLevel3Id(argMerchLevel3Id);
/*  625 */       ev_postable = true;
/*      */     } 
/*      */     
/*  628 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMerchLevel4Id(String argMerchLevel4Id) {
/*  636 */     if (setMerchLevel4Id_noev(argMerchLevel4Id) && 
/*  637 */       this._events != null && 
/*  638 */       postEventsForChanges()) {
/*  639 */       this._events.post(IItem.SET_MERCHLEVEL4ID, argMerchLevel4Id);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setMerchLevel4Id_noev(String argMerchLevel4Id) {
/*  646 */     boolean ev_postable = false;
/*      */     
/*  648 */     if ((getDAO_().getMerchLevel4Id() == null && argMerchLevel4Id != null) || (
/*  649 */       getDAO_().getMerchLevel4Id() != null && !getDAO_().getMerchLevel4Id().equals(argMerchLevel4Id))) {
/*  650 */       getDAO_().setMerchLevel4Id(argMerchLevel4Id);
/*  651 */       ev_postable = true;
/*      */     } 
/*      */     
/*  654 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getSerializedItem() {
/*  662 */     if (getDAO_().getSerializedItem() != null) {
/*  663 */       return getDAO_().getSerializedItem().booleanValue();
/*      */     }
/*      */     
/*  666 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSerializedItem(boolean argSerializedItem) {
/*  675 */     if (setSerializedItem_noev(argSerializedItem) && 
/*  676 */       this._events != null && 
/*  677 */       postEventsForChanges()) {
/*  678 */       this._events.post(IItem.SET_SERIALIZEDITEM, Boolean.valueOf(argSerializedItem));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSerializedItem_noev(boolean argSerializedItem) {
/*  685 */     boolean ev_postable = false;
/*      */     
/*  687 */     if ((getDAO_().getSerializedItem() == null && Boolean.valueOf(argSerializedItem) != null) || (
/*  688 */       getDAO_().getSerializedItem() != null && !getDAO_().getSerializedItem().equals(Boolean.valueOf(argSerializedItem)))) {
/*  689 */       getDAO_().setSerializedItem(Boolean.valueOf(argSerializedItem));
/*  690 */       ev_postable = true;
/*      */     } 
/*      */     
/*  693 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getParentItemId() {
/*  701 */     return getDAO_().getParentItemId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setParentItemId(String argParentItemId) {
/*  709 */     if (setParentItemId_noev(argParentItemId) && 
/*  710 */       this._events != null && 
/*  711 */       postEventsForChanges()) {
/*  712 */       this._events.post(IItem.SET_PARENTITEMID, argParentItemId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setParentItemId_noev(String argParentItemId) {
/*  719 */     boolean ev_postable = false;
/*      */     
/*  721 */     if ((getDAO_().getParentItemId() == null && argParentItemId != null) || (
/*  722 */       getDAO_().getParentItemId() != null && !getDAO_().getParentItemId().equals(argParentItemId))) {
/*  723 */       getDAO_().setParentItemId(argParentItemId);
/*  724 */       ev_postable = true;
/*      */     } 
/*      */     
/*  727 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getName() {
/*  735 */     return getDAO_().getName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setName(String argName) {
/*  743 */     if (setName_noev(argName) && 
/*  744 */       this._events != null && 
/*  745 */       postEventsForChanges()) {
/*  746 */       this._events.post(IItem.SET_NAME, argName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setName_noev(String argName) {
/*  753 */     boolean ev_postable = false;
/*      */     
/*  755 */     if ((getDAO_().getName() == null && argName != null) || (
/*  756 */       getDAO_().getName() != null && !getDAO_().getName().equals(argName))) {
/*  757 */       getDAO_().setName(argName);
/*  758 */       ev_postable = true;
/*      */     } 
/*      */     
/*  761 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getDisallowItemMatrixDisplay() {
/*  769 */     if (getDAO_().getDisallowItemMatrixDisplay() != null) {
/*  770 */       return getDAO_().getDisallowItemMatrixDisplay().booleanValue();
/*      */     }
/*      */     
/*  773 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDisallowItemMatrixDisplay(boolean argDisallowItemMatrixDisplay) {
/*  782 */     if (setDisallowItemMatrixDisplay_noev(argDisallowItemMatrixDisplay) && 
/*  783 */       this._events != null && 
/*  784 */       postEventsForChanges()) {
/*  785 */       this._events.post(IItem.SET_DISALLOWITEMMATRIXDISPLAY, Boolean.valueOf(argDisallowItemMatrixDisplay));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDisallowItemMatrixDisplay_noev(boolean argDisallowItemMatrixDisplay) {
/*  792 */     boolean ev_postable = false;
/*      */     
/*  794 */     if ((getDAO_().getDisallowItemMatrixDisplay() == null && Boolean.valueOf(argDisallowItemMatrixDisplay) != null) || (
/*  795 */       getDAO_().getDisallowItemMatrixDisplay() != null && !getDAO_().getDisallowItemMatrixDisplay().equals(Boolean.valueOf(argDisallowItemMatrixDisplay)))) {
/*  796 */       getDAO_().setDisallowItemMatrixDisplay(Boolean.valueOf(argDisallowItemMatrixDisplay));
/*  797 */       ev_postable = true;
/*      */     } 
/*      */     
/*  800 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getItemMatrixColor() {
/*  808 */     return getDAO_().getItemMatrixColor();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setItemMatrixColor(String argItemMatrixColor) {
/*  816 */     if (setItemMatrixColor_noev(argItemMatrixColor) && 
/*  817 */       this._events != null && 
/*  818 */       postEventsForChanges()) {
/*  819 */       this._events.post(IItem.SET_ITEMMATRIXCOLOR, argItemMatrixColor);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setItemMatrixColor_noev(String argItemMatrixColor) {
/*  826 */     boolean ev_postable = false;
/*      */     
/*  828 */     if ((getDAO_().getItemMatrixColor() == null && argItemMatrixColor != null) || (
/*  829 */       getDAO_().getItemMatrixColor() != null && !getDAO_().getItemMatrixColor().equals(argItemMatrixColor))) {
/*  830 */       getDAO_().setItemMatrixColor(argItemMatrixColor);
/*  831 */       ev_postable = true;
/*      */     } 
/*      */     
/*  834 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDimensionSystem() {
/*  842 */     return getDAO_().getDimensionSystem();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDimensionSystem(String argDimensionSystem) {
/*  850 */     if (setDimensionSystem_noev(argDimensionSystem) && 
/*  851 */       this._events != null && 
/*  852 */       postEventsForChanges()) {
/*  853 */       this._events.post(IItem.SET_DIMENSIONSYSTEM, argDimensionSystem);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDimensionSystem_noev(String argDimensionSystem) {
/*  860 */     boolean ev_postable = false;
/*      */     
/*  862 */     if ((getDAO_().getDimensionSystem() == null && argDimensionSystem != null) || (
/*  863 */       getDAO_().getDimensionSystem() != null && !getDAO_().getDimensionSystem().equals(argDimensionSystem))) {
/*  864 */       getDAO_().setDimensionSystem(argDimensionSystem);
/*  865 */       ev_postable = true;
/*  866 */       if (this._itemDimensionTypes != null) {
/*      */         
/*  868 */         Iterator<ItemDimensionTypeModel> it = this._itemDimensionTypes.iterator();
/*  869 */         while (it.hasNext())
/*      */         {
/*  871 */           ((ItemDimensionTypeModel)it.next()).setDimensionSystem_noev(argDimensionSystem);
/*      */         }
/*      */       } 
/*  874 */       if (this._itemDimensionValues != null) {
/*      */         
/*  876 */         Iterator<ItemDimensionValueModel> it = this._itemDimensionValues.iterator();
/*  877 */         while (it.hasNext())
/*      */         {
/*  879 */           ((ItemDimensionValueModel)it.next()).setDimensionSystem_noev(argDimensionSystem);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  884 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDimension1() {
/*  892 */     return getDAO_().getDimension1();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDimension1(String argDimension1) {
/*  900 */     if (setDimension1_noev(argDimension1) && 
/*  901 */       this._events != null && 
/*  902 */       postEventsForChanges()) {
/*  903 */       this._events.post(IItem.SET_DIMENSION1, argDimension1);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDimension1_noev(String argDimension1) {
/*  910 */     boolean ev_postable = false;
/*      */     
/*  912 */     if ((getDAO_().getDimension1() == null && argDimension1 != null) || (
/*  913 */       getDAO_().getDimension1() != null && !getDAO_().getDimension1().equals(argDimension1))) {
/*  914 */       getDAO_().setDimension1(argDimension1);
/*  915 */       ev_postable = true;
/*      */     } 
/*      */     
/*  918 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDimension2() {
/*  926 */     return getDAO_().getDimension2();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDimension2(String argDimension2) {
/*  934 */     if (setDimension2_noev(argDimension2) && 
/*  935 */       this._events != null && 
/*  936 */       postEventsForChanges()) {
/*  937 */       this._events.post(IItem.SET_DIMENSION2, argDimension2);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDimension2_noev(String argDimension2) {
/*  944 */     boolean ev_postable = false;
/*      */     
/*  946 */     if ((getDAO_().getDimension2() == null && argDimension2 != null) || (
/*  947 */       getDAO_().getDimension2() != null && !getDAO_().getDimension2().equals(argDimension2))) {
/*  948 */       getDAO_().setDimension2(argDimension2);
/*  949 */       ev_postable = true;
/*      */     } 
/*      */     
/*  952 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDimension3() {
/*  960 */     return getDAO_().getDimension3();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDimension3(String argDimension3) {
/*  968 */     if (setDimension3_noev(argDimension3) && 
/*  969 */       this._events != null && 
/*  970 */       postEventsForChanges()) {
/*  971 */       this._events.post(IItem.SET_DIMENSION3, argDimension3);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDimension3_noev(String argDimension3) {
/*  978 */     boolean ev_postable = false;
/*      */     
/*  980 */     if ((getDAO_().getDimension3() == null && argDimension3 != null) || (
/*  981 */       getDAO_().getDimension3() != null && !getDAO_().getDimension3().equals(argDimension3))) {
/*  982 */       getDAO_().setDimension3(argDimension3);
/*  983 */       ev_postable = true;
/*      */     } 
/*      */     
/*  986 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getListPrice() {
/*  994 */     return getDAO_().getListPrice();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setListPrice(BigDecimal argListPrice) {
/* 1002 */     if (setListPrice_noev(argListPrice) && 
/* 1003 */       this._events != null && 
/* 1004 */       postEventsForChanges()) {
/* 1005 */       this._events.post(IItem.SET_LISTPRICE, argListPrice);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setListPrice_noev(BigDecimal argListPrice) {
/* 1012 */     boolean ev_postable = false;
/*      */     
/* 1014 */     if ((getDAO_().getListPrice() == null && argListPrice != null) || (
/* 1015 */       getDAO_().getListPrice() != null && !getDAO_().getListPrice().equals(argListPrice))) {
/* 1016 */       getDAO_().setListPrice(argListPrice);
/* 1017 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1020 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getMeasurementRequired() {
/* 1028 */     if (getDAO_().getMeasurementRequired() != null) {
/* 1029 */       return getDAO_().getMeasurementRequired().booleanValue();
/*      */     }
/*      */     
/* 1032 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMeasurementRequired(boolean argMeasurementRequired) {
/* 1041 */     if (setMeasurementRequired_noev(argMeasurementRequired) && 
/* 1042 */       this._events != null && 
/* 1043 */       postEventsForChanges()) {
/* 1044 */       this._events.post(IItem.SET_MEASUREMENTREQUIRED, Boolean.valueOf(argMeasurementRequired));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setMeasurementRequired_noev(boolean argMeasurementRequired) {
/* 1051 */     boolean ev_postable = false;
/*      */     
/* 1053 */     if ((getDAO_().getMeasurementRequired() == null && Boolean.valueOf(argMeasurementRequired) != null) || (
/* 1054 */       getDAO_().getMeasurementRequired() != null && !getDAO_().getMeasurementRequired().equals(Boolean.valueOf(argMeasurementRequired)))) {
/* 1055 */       getDAO_().setMeasurementRequired(Boolean.valueOf(argMeasurementRequired));
/* 1056 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1059 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getNotInventoried() {
/* 1067 */     if (getDAO_().getNotInventoried() != null) {
/* 1068 */       return getDAO_().getNotInventoried().booleanValue();
/*      */     }
/*      */     
/* 1071 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNotInventoried(boolean argNotInventoried) {
/* 1080 */     if (setNotInventoried_noev(argNotInventoried) && 
/* 1081 */       this._events != null && 
/* 1082 */       postEventsForChanges()) {
/* 1083 */       this._events.post(IItem.SET_NOTINVENTORIED, Boolean.valueOf(argNotInventoried));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setNotInventoried_noev(boolean argNotInventoried) {
/* 1090 */     boolean ev_postable = false;
/*      */     
/* 1092 */     if ((getDAO_().getNotInventoried() == null && Boolean.valueOf(argNotInventoried) != null) || (
/* 1093 */       getDAO_().getNotInventoried() != null && !getDAO_().getNotInventoried().equals(Boolean.valueOf(argNotInventoried)))) {
/* 1094 */       getDAO_().setNotInventoried(Boolean.valueOf(argNotInventoried));
/* 1095 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1098 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getExternalSystem() {
/* 1106 */     return getDAO_().getExternalSystem();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExternalSystem(String argExternalSystem) {
/* 1114 */     if (setExternalSystem_noev(argExternalSystem) && 
/* 1115 */       this._events != null && 
/* 1116 */       postEventsForChanges()) {
/* 1117 */       this._events.post(IItem.SET_EXTERNALSYSTEM, argExternalSystem);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setExternalSystem_noev(String argExternalSystem) {
/* 1124 */     boolean ev_postable = false;
/*      */     
/* 1126 */     if ((getDAO_().getExternalSystem() == null && argExternalSystem != null) || (
/* 1127 */       getDAO_().getExternalSystem() != null && !getDAO_().getExternalSystem().equals(argExternalSystem))) {
/* 1128 */       getDAO_().setExternalSystem(argExternalSystem);
/* 1129 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1132 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected IItemProperty newProperty(String argPropertyName) {
/* 1136 */     ItemPropertyId id = new ItemPropertyId();
/*      */     
/* 1138 */     id.setItemId(getItemId());
/* 1139 */     id.setPropertyCode(argPropertyName);
/*      */     
/* 1141 */     IItemProperty prop = (IItemProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IItemProperty.class);
/* 1142 */     return prop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "ItemOptions")
/*      */   public List<IItemOptions> getItemOptions() {
/* 1175 */     if (this._itemOptions == null) {
/* 1176 */       this._itemOptions = new HistoricalList(null);
/*      */     }
/* 1178 */     return (List<IItemOptions>)this._itemOptions;
/*      */   }
/*      */   
/*      */   public void setItemOptions(List<IItemOptions> argItemOptions) {
/* 1182 */     if (this._itemOptions == null) {
/* 1183 */       this._itemOptions = new HistoricalList(argItemOptions);
/*      */     } else {
/* 1185 */       this._itemOptions.setCurrentList(argItemOptions);
/*      */     } 
/*      */     
/* 1188 */     for (IItemOptions child : this._itemOptions) {
/* 1189 */       child.setItem(this);
/*      */     }
/*      */ 
/*      */     
/* 1193 */     for (IItemOptions child : this._itemOptions) {
/* 1194 */       ItemOptionsModel model = (ItemOptionsModel)child;
/* 1195 */       model.setItemId_noev(getItemId());
/* 1196 */       model.setOrganizationId_noev(getOrganizationId());
/* 1197 */       if (child instanceof IDataModelImpl) {
/* 1198 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1199 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1200 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1201 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1204 */       if (postEventsForChanges()) {
/* 1205 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void addItemOptions(IItemOptions argItemOptions) {
/* 1212 */     argItemOptions.setItem(this);
/* 1213 */     if (this._itemOptions == null) {
/* 1214 */       this._itemOptions = new HistoricalList(null);
/*      */     }
/* 1216 */     argItemOptions.setItemId(getItemId());
/* 1217 */     argItemOptions.setOrganizationId(getOrganizationId());
/* 1218 */     if (argItemOptions instanceof IDataModelImpl) {
/* 1219 */       IDataAccessObject childDao = ((IDataModelImpl)argItemOptions).getDAO();
/* 1220 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1221 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1222 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1227 */     if (postEventsForChanges()) {
/* 1228 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemOptions));
/*      */     }
/*      */     
/* 1231 */     this._itemOptions.add(argItemOptions);
/* 1232 */     if (postEventsForChanges()) {
/* 1233 */       this._events.post(IItem.ADD_ITEMOPTIONS, argItemOptions);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeItemOptions(IItemOptions argItemOptions) {
/* 1238 */     if (this._itemOptions != null) {
/*      */       
/* 1240 */       if (postEventsForChanges()) {
/* 1241 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemOptions));
/*      */       }
/* 1243 */       this._itemOptions.remove(argItemOptions);
/*      */       
/* 1245 */       argItemOptions.setItem(null);
/* 1246 */       if (postEventsForChanges()) {
/* 1247 */         this._events.post(IItem.REMOVE_ITEMOPTIONS, argItemOptions);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "ParentItem")
/*      */   public IItem getParentItem() {
/* 1254 */     return this._parentItem;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setParentItem(IItem argParentItem) {
/* 1259 */     if (argParentItem == null) {
/*      */       
/* 1261 */       getDAO_().setParentItemId(null);
/* 1262 */       if (this._parentItem != null)
/*      */       {
/* 1264 */         if (postEventsForChanges()) {
/* 1265 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._parentItem));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/* 1270 */       getDAO_().setParentItemId(argParentItem.getItemId());
/*      */       
/* 1272 */       if (postEventsForChanges()) {
/* 1273 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argParentItem));
/*      */       }
/*      */     } 
/*      */     
/* 1277 */     this._parentItem = argParentItem;
/* 1278 */     if (postEventsForChanges()) {
/* 1279 */       this._events.post(IItem.SET_PARENTITEM, argParentItem);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "ItemDealProperties")
/*      */   public List<IItemDealProperty> getItemDealProperties() {
/* 1285 */     if (this._itemDealProperties == null) {
/* 1286 */       this._itemDealProperties = new HistoricalList(null);
/*      */     }
/* 1288 */     return (List<IItemDealProperty>)this._itemDealProperties;
/*      */   }
/*      */   
/*      */   public void setItemDealProperties(List<IItemDealProperty> argItemDealProperties) {
/* 1292 */     if (this._itemDealProperties == null) {
/* 1293 */       this._itemDealProperties = new HistoricalList(argItemDealProperties);
/*      */     } else {
/* 1295 */       this._itemDealProperties.setCurrentList(argItemDealProperties);
/*      */     } 
/*      */     
/* 1298 */     for (IItemDealProperty child : this._itemDealProperties) {
/* 1299 */       child.setParentItem(this);
/*      */     }
/*      */ 
/*      */     
/* 1303 */     for (IItemDealProperty child : this._itemDealProperties) {
/* 1304 */       ItemDealPropertyModel model = (ItemDealPropertyModel)child;
/* 1305 */       model.setItemId_noev(getItemId());
/* 1306 */       model.setOrganizationId_noev(getOrganizationId());
/* 1307 */       if (child instanceof IDataModelImpl) {
/* 1308 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1309 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1310 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1311 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1314 */       if (postEventsForChanges()) {
/* 1315 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void addItemDealProperty(IItemDealProperty argItemDealProperty) {
/* 1322 */     argItemDealProperty.setParentItem(this);
/* 1323 */     if (this._itemDealProperties == null) {
/* 1324 */       this._itemDealProperties = new HistoricalList(null);
/*      */     }
/* 1326 */     argItemDealProperty.setItemId(getItemId());
/* 1327 */     argItemDealProperty.setOrganizationId(getOrganizationId());
/* 1328 */     if (argItemDealProperty instanceof IDataModelImpl) {
/* 1329 */       IDataAccessObject childDao = ((IDataModelImpl)argItemDealProperty).getDAO();
/* 1330 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1331 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1332 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1337 */     if (postEventsForChanges()) {
/* 1338 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemDealProperty));
/*      */     }
/*      */     
/* 1341 */     this._itemDealProperties.add(argItemDealProperty);
/* 1342 */     if (postEventsForChanges()) {
/* 1343 */       this._events.post(IItem.ADD_ITEMDEALPROPERTIES, argItemDealProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeItemDealProperty(IItemDealProperty argItemDealProperty) {
/* 1348 */     if (this._itemDealProperties != null) {
/*      */       
/* 1350 */       if (postEventsForChanges()) {
/* 1351 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemDealProperty));
/*      */       }
/* 1353 */       this._itemDealProperties.remove(argItemDealProperty);
/*      */       
/* 1355 */       argItemDealProperty.setParentItem(null);
/* 1356 */       if (postEventsForChanges()) {
/* 1357 */         this._events.post(IItem.REMOVE_ITEMDEALPROPERTIES, argItemDealProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "ItemPromptProperties")
/*      */   public List<IItemPromptProperty> getItemPromptProperties() {
/* 1364 */     if (this._itemPromptProperties == null) {
/* 1365 */       this._itemPromptProperties = new HistoricalList(null);
/*      */     }
/* 1367 */     return (List<IItemPromptProperty>)this._itemPromptProperties;
/*      */   }
/*      */   
/*      */   public void setItemPromptProperties(List<IItemPromptProperty> argItemPromptProperties) {
/* 1371 */     if (this._itemPromptProperties == null) {
/* 1372 */       this._itemPromptProperties = new HistoricalList(argItemPromptProperties);
/*      */     } else {
/* 1374 */       this._itemPromptProperties.setCurrentList(argItemPromptProperties);
/*      */     } 
/*      */     
/* 1377 */     for (IItemPromptProperty child : this._itemPromptProperties) {
/* 1378 */       child.setParentItem(this);
/*      */     }
/*      */ 
/*      */     
/* 1382 */     for (IItemPromptProperty child : this._itemPromptProperties) {
/* 1383 */       ItemPromptPropertyModel model = (ItemPromptPropertyModel)child;
/* 1384 */       model.setItemId_noev(getItemId());
/* 1385 */       model.setOrganizationId_noev(getOrganizationId());
/* 1386 */       if (child instanceof IDataModelImpl) {
/* 1387 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1388 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1389 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1390 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1393 */       if (postEventsForChanges()) {
/* 1394 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void addItemPromptProperty(IItemPromptProperty argItemPromptProperty) {
/* 1401 */     argItemPromptProperty.setParentItem(this);
/* 1402 */     if (this._itemPromptProperties == null) {
/* 1403 */       this._itemPromptProperties = new HistoricalList(null);
/*      */     }
/* 1405 */     argItemPromptProperty.setItemId(getItemId());
/* 1406 */     argItemPromptProperty.setOrganizationId(getOrganizationId());
/* 1407 */     if (argItemPromptProperty instanceof IDataModelImpl) {
/* 1408 */       IDataAccessObject childDao = ((IDataModelImpl)argItemPromptProperty).getDAO();
/* 1409 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1410 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1411 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1416 */     if (postEventsForChanges()) {
/* 1417 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemPromptProperty));
/*      */     }
/*      */     
/* 1420 */     this._itemPromptProperties.add(argItemPromptProperty);
/* 1421 */     if (postEventsForChanges()) {
/* 1422 */       this._events.post(IItem.ADD_ITEMPROMPTPROPERTIES, argItemPromptProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeItemPromptProperty(IItemPromptProperty argItemPromptProperty) {
/* 1427 */     if (this._itemPromptProperties != null) {
/*      */       
/* 1429 */       if (postEventsForChanges()) {
/* 1430 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemPromptProperty));
/*      */       }
/* 1432 */       this._itemPromptProperties.remove(argItemPromptProperty);
/*      */       
/* 1434 */       argItemPromptProperty.setParentItem(null);
/* 1435 */       if (postEventsForChanges()) {
/* 1436 */         this._events.post(IItem.REMOVE_ITEMPROMPTPROPERTIES, argItemPromptProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "ItemLabelProperties")
/*      */   public IItemLabelProperties getItemLabelProperties() {
/* 1443 */     return this._itemLabelProperties;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setItemLabelProperties(IItemLabelProperties argItemLabelProperties) {
/* 1448 */     if (argItemLabelProperties == null) {
/*      */       
/* 1450 */       if (this._itemLabelProperties != null) {
/* 1451 */         throw new DtxException("An Attempt was made to break a ONE-ONE relationship that cannot be broken because all fields that define the relationship are primary keys on the parent data object.");
/*      */       }
/*      */       
/* 1454 */       if (this._itemLabelProperties != null)
/*      */       {
/* 1456 */         if (postEventsForChanges()) {
/* 1457 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._itemLabelProperties));
/*      */         }
/*      */       }
/*      */     }
/*      */     else {
/*      */       
/* 1463 */       argItemLabelProperties.setParentItem(this);
/*      */ 
/*      */       
/* 1466 */       if (postEventsForChanges()) {
/* 1467 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemLabelProperties));
/*      */       }
/*      */     } 
/*      */     
/* 1471 */     this._itemLabelProperties = argItemLabelProperties;
/* 1472 */     if (postEventsForChanges()) {
/* 1473 */       this._events.post(IItem.SET_ITEMLABELPROPERTIES, argItemLabelProperties);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "ItemImages")
/*      */   public List<IItemImage> getItemImages() {
/* 1479 */     if (this._itemImages == null) {
/* 1480 */       this._itemImages = new HistoricalList(null);
/*      */     }
/* 1482 */     return (List<IItemImage>)this._itemImages;
/*      */   }
/*      */   
/*      */   public void setItemImages(List<IItemImage> argItemImages) {
/* 1486 */     if (this._itemImages == null) {
/* 1487 */       this._itemImages = new HistoricalList(argItemImages);
/*      */     } else {
/* 1489 */       this._itemImages.setCurrentList(argItemImages);
/*      */     } 
/*      */     
/* 1492 */     for (IItemImage child : this._itemImages) {
/* 1493 */       child.setParentItem(this);
/*      */     }
/*      */ 
/*      */     
/* 1497 */     for (IItemImage child : this._itemImages) {
/* 1498 */       ItemImageModel model = (ItemImageModel)child;
/* 1499 */       model.setItemId_noev(getItemId());
/* 1500 */       model.setOrganizationId_noev(getOrganizationId());
/* 1501 */       if (child instanceof IDataModelImpl) {
/* 1502 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1503 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1504 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1505 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1508 */       if (postEventsForChanges()) {
/* 1509 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void addItemImage(IItemImage argItemImage) {
/* 1516 */     argItemImage.setParentItem(this);
/* 1517 */     if (this._itemImages == null) {
/* 1518 */       this._itemImages = new HistoricalList(null);
/*      */     }
/* 1520 */     argItemImage.setItemId(getItemId());
/* 1521 */     argItemImage.setOrganizationId(getOrganizationId());
/* 1522 */     if (argItemImage instanceof IDataModelImpl) {
/* 1523 */       IDataAccessObject childDao = ((IDataModelImpl)argItemImage).getDAO();
/* 1524 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1525 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1526 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1531 */     if (postEventsForChanges()) {
/* 1532 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemImage));
/*      */     }
/*      */     
/* 1535 */     this._itemImages.add(argItemImage);
/* 1536 */     if (postEventsForChanges()) {
/* 1537 */       this._events.post(IItem.ADD_ITEMIMAGES, argItemImage);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeItemImage(IItemImage argItemImage) {
/* 1542 */     if (this._itemImages != null) {
/*      */       
/* 1544 */       if (postEventsForChanges()) {
/* 1545 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemImage));
/*      */       }
/* 1547 */       this._itemImages.remove(argItemImage);
/*      */       
/* 1549 */       argItemImage.setParentItem(null);
/* 1550 */       if (postEventsForChanges()) {
/* 1551 */         this._events.post(IItem.REMOVE_ITEMIMAGES, argItemImage);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "ItemDimensionTypes")
/*      */   public List<IItemDimensionType> getItemDimensionTypes() {
/* 1558 */     if (this._itemDimensionTypes == null) {
/* 1559 */       this._itemDimensionTypes = new HistoricalList(null);
/*      */     }
/* 1561 */     return (List<IItemDimensionType>)this._itemDimensionTypes;
/*      */   }
/*      */   
/*      */   public void setItemDimensionTypes(List<IItemDimensionType> argItemDimensionTypes) {
/* 1565 */     if (this._itemDimensionTypes == null) {
/* 1566 */       this._itemDimensionTypes = new HistoricalList(argItemDimensionTypes);
/*      */     } else {
/* 1568 */       this._itemDimensionTypes.setCurrentList(argItemDimensionTypes);
/*      */     } 
/*      */     
/* 1571 */     for (IItemDimensionType child : this._itemDimensionTypes) {
/* 1572 */       ItemDimensionTypeModel model = (ItemDimensionTypeModel)child;
/* 1573 */       model.setOrganizationId_noev(getOrganizationId());
/* 1574 */       model.setDimensionSystem_noev(getDimensionSystem());
/* 1575 */       if (child instanceof IDataModelImpl) {
/* 1576 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1577 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1578 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1579 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1582 */       if (postEventsForChanges()) {
/* 1583 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addItemDimensionType(IItemDimensionType argItemDimensionType) {
/* 1589 */     if (this._itemDimensionTypes == null) {
/* 1590 */       this._itemDimensionTypes = new HistoricalList(null);
/*      */     }
/* 1592 */     argItemDimensionType.setOrganizationId(getOrganizationId());
/* 1593 */     argItemDimensionType.setDimensionSystem(getDimensionSystem());
/* 1594 */     if (argItemDimensionType instanceof IDataModelImpl) {
/* 1595 */       IDataAccessObject childDao = ((IDataModelImpl)argItemDimensionType).getDAO();
/* 1596 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1597 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1598 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1603 */     if (postEventsForChanges()) {
/* 1604 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemDimensionType));
/*      */     }
/*      */     
/* 1607 */     this._itemDimensionTypes.add(argItemDimensionType);
/* 1608 */     if (postEventsForChanges()) {
/* 1609 */       this._events.post(IItem.ADD_ITEMDIMENSIONTYPES, argItemDimensionType);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeItemDimensionType(IItemDimensionType argItemDimensionType) {
/* 1614 */     if (this._itemDimensionTypes != null) {
/*      */       
/* 1616 */       if (postEventsForChanges()) {
/* 1617 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemDimensionType));
/*      */       }
/* 1619 */       this._itemDimensionTypes.remove(argItemDimensionType);
/* 1620 */       if (postEventsForChanges()) {
/* 1621 */         this._events.post(IItem.REMOVE_ITEMDIMENSIONTYPES, argItemDimensionType);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "ItemDimensionValues")
/*      */   public List<IItemDimensionValue> getItemDimensionValues() {
/* 1628 */     if (this._itemDimensionValues == null) {
/* 1629 */       this._itemDimensionValues = new HistoricalList(null);
/*      */     }
/* 1631 */     return (List<IItemDimensionValue>)this._itemDimensionValues;
/*      */   }
/*      */   
/*      */   public void setItemDimensionValues(List<IItemDimensionValue> argItemDimensionValues) {
/* 1635 */     if (this._itemDimensionValues == null) {
/* 1636 */       this._itemDimensionValues = new HistoricalList(argItemDimensionValues);
/*      */     } else {
/* 1638 */       this._itemDimensionValues.setCurrentList(argItemDimensionValues);
/*      */     } 
/*      */     
/* 1641 */     for (IItemDimensionValue child : this._itemDimensionValues) {
/* 1642 */       ItemDimensionValueModel model = (ItemDimensionValueModel)child;
/* 1643 */       model.setOrganizationId_noev(getOrganizationId());
/* 1644 */       model.setDimensionSystem_noev(getDimensionSystem());
/* 1645 */       if (child instanceof IDataModelImpl) {
/* 1646 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1647 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1648 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1649 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1652 */       if (postEventsForChanges()) {
/* 1653 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addItemDimensionValue(IItemDimensionValue argItemDimensionValue) {
/* 1659 */     if (this._itemDimensionValues == null) {
/* 1660 */       this._itemDimensionValues = new HistoricalList(null);
/*      */     }
/* 1662 */     argItemDimensionValue.setOrganizationId(getOrganizationId());
/* 1663 */     argItemDimensionValue.setDimensionSystem(getDimensionSystem());
/* 1664 */     if (argItemDimensionValue instanceof IDataModelImpl) {
/* 1665 */       IDataAccessObject childDao = ((IDataModelImpl)argItemDimensionValue).getDAO();
/* 1666 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1667 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1668 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1673 */     if (postEventsForChanges()) {
/* 1674 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemDimensionValue));
/*      */     }
/*      */     
/* 1677 */     this._itemDimensionValues.add(argItemDimensionValue);
/* 1678 */     if (postEventsForChanges()) {
/* 1679 */       this._events.post(IItem.ADD_ITEMDIMENSIONVALUES, argItemDimensionValue);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeItemDimensionValue(IItemDimensionValue argItemDimensionValue) {
/* 1684 */     if (this._itemDimensionValues != null) {
/*      */       
/* 1686 */       if (postEventsForChanges()) {
/* 1687 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemDimensionValue));
/*      */       }
/* 1689 */       this._itemDimensionValues.remove(argItemDimensionValue);
/* 1690 */       if (postEventsForChanges()) {
/* 1691 */         this._events.post(IItem.REMOVE_ITEMDIMENSIONVALUES, argItemDimensionValue);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<IItemProperty> getProperties() {
/* 1698 */     if (this._properties == null) {
/* 1699 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1701 */     return (List<IItemProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<IItemProperty> argProperties) {
/* 1705 */     if (this._properties == null) {
/* 1706 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/* 1708 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/* 1711 */     for (IItemProperty child : this._properties) {
/* 1712 */       ItemPropertyModel model = (ItemPropertyModel)child;
/* 1713 */       model.setOrganizationId_noev(getOrganizationId());
/* 1714 */       model.setItemId_noev(getItemId());
/* 1715 */       if (child instanceof IDataModelImpl) {
/* 1716 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 1717 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1718 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1719 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 1722 */       if (postEventsForChanges()) {
/* 1723 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addItemProperty(IItemProperty argItemProperty) {
/* 1729 */     if (this._properties == null) {
/* 1730 */       this._properties = new HistoricalList(null);
/*      */     }
/* 1732 */     argItemProperty.setOrganizationId(getOrganizationId());
/* 1733 */     argItemProperty.setItemId(getItemId());
/* 1734 */     if (argItemProperty instanceof IDataModelImpl) {
/* 1735 */       IDataAccessObject childDao = ((IDataModelImpl)argItemProperty).getDAO();
/* 1736 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 1737 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 1738 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1743 */     if (postEventsForChanges()) {
/* 1744 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemProperty));
/*      */     }
/*      */     
/* 1747 */     this._properties.add(argItemProperty);
/* 1748 */     if (postEventsForChanges()) {
/* 1749 */       this._events.post(IItem.ADD_PROPERTIES, argItemProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeItemProperty(IItemProperty argItemProperty) {
/* 1754 */     if (this._properties != null) {
/*      */       
/* 1756 */       if (postEventsForChanges()) {
/* 1757 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemProperty));
/*      */       }
/* 1759 */       this._properties.remove(argItemProperty);
/* 1760 */       if (postEventsForChanges()) {
/* 1761 */         this._events.post(IItem.REMOVE_PROPERTIES, argItemProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/* 1768 */     if ("ItemOptions".equals(argFieldId)) {
/* 1769 */       return getItemOptions();
/*      */     }
/* 1771 */     if ("ParentItem".equals(argFieldId)) {
/* 1772 */       return getParentItem();
/*      */     }
/* 1774 */     if ("ItemDealProperties".equals(argFieldId)) {
/* 1775 */       return getItemDealProperties();
/*      */     }
/* 1777 */     if ("ItemPromptProperties".equals(argFieldId)) {
/* 1778 */       return getItemPromptProperties();
/*      */     }
/* 1780 */     if ("ItemLabelProperties".equals(argFieldId)) {
/* 1781 */       return getItemLabelProperties();
/*      */     }
/* 1783 */     if ("ItemImages".equals(argFieldId)) {
/* 1784 */       return getItemImages();
/*      */     }
/* 1786 */     if ("ItemDimensionTypes".equals(argFieldId)) {
/* 1787 */       return getItemDimensionTypes();
/*      */     }
/* 1789 */     if ("ItemDimensionValues".equals(argFieldId)) {
/* 1790 */       return getItemDimensionValues();
/*      */     }
/* 1792 */     if ("Properties".equals(argFieldId)) {
/* 1793 */       return getProperties();
/*      */     }
/* 1795 */     if ("ItemExtension".equals(argFieldId)) {
/* 1796 */       return this._myExtension;
/*      */     }
/*      */     
/* 1799 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/* 1805 */     if ("ItemOptions".equals(argFieldId)) {
/* 1806 */       setItemOptions(changeToList(argValue, IItemOptions.class));
/*      */     }
/* 1808 */     else if ("ParentItem".equals(argFieldId)) {
/* 1809 */       setParentItem((IItem)argValue);
/*      */     }
/* 1811 */     else if ("ItemDealProperties".equals(argFieldId)) {
/* 1812 */       setItemDealProperties(changeToList(argValue, IItemDealProperty.class));
/*      */     }
/* 1814 */     else if ("ItemPromptProperties".equals(argFieldId)) {
/* 1815 */       setItemPromptProperties(changeToList(argValue, IItemPromptProperty.class));
/*      */     }
/* 1817 */     else if ("ItemLabelProperties".equals(argFieldId)) {
/* 1818 */       setItemLabelProperties((IItemLabelProperties)argValue);
/*      */     }
/* 1820 */     else if ("ItemImages".equals(argFieldId)) {
/* 1821 */       setItemImages(changeToList(argValue, IItemImage.class));
/*      */     }
/* 1823 */     else if ("ItemDimensionTypes".equals(argFieldId)) {
/* 1824 */       setItemDimensionTypes(changeToList(argValue, IItemDimensionType.class));
/*      */     }
/* 1826 */     else if ("ItemDimensionValues".equals(argFieldId)) {
/* 1827 */       setItemDimensionValues(changeToList(argValue, IItemDimensionValue.class));
/*      */     }
/* 1829 */     else if ("Properties".equals(argFieldId)) {
/* 1830 */       setProperties(changeToList(argValue, IItemProperty.class));
/*      */     }
/* 1832 */     else if ("ItemExtension".equals(argFieldId)) {
/* 1833 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/* 1836 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 1842 */     this._persistenceDefaults = argPD;
/* 1843 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 1844 */     this._eventManager = argEM;
/* 1845 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 1846 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 1847 */     if (this._itemOptions != null) {
/* 1848 */       for (IItemOptions relationship : this._itemOptions) {
/* 1849 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1852 */     if (this._parentItem != null) {
/* 1853 */       ((IDataModelImpl)this._parentItem).setDependencies(argPD, argEM);
/*      */     }
/* 1855 */     if (this._itemDealProperties != null) {
/* 1856 */       for (IItemDealProperty relationship : this._itemDealProperties) {
/* 1857 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1860 */     if (this._itemPromptProperties != null) {
/* 1861 */       for (IItemPromptProperty relationship : this._itemPromptProperties) {
/* 1862 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1865 */     if (this._itemLabelProperties != null) {
/* 1866 */       ((IDataModelImpl)this._itemLabelProperties).setDependencies(argPD, argEM);
/*      */     }
/* 1868 */     if (this._itemImages != null) {
/* 1869 */       for (IItemImage relationship : this._itemImages) {
/* 1870 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1873 */     if (this._itemDimensionTypes != null) {
/* 1874 */       for (IItemDimensionType relationship : this._itemDimensionTypes) {
/* 1875 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1878 */     if (this._itemDimensionValues != null) {
/* 1879 */       for (IItemDimensionValue relationship : this._itemDimensionValues) {
/* 1880 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/* 1883 */     if (this._properties != null) {
/* 1884 */       for (IItemProperty relationship : this._properties) {
/* 1885 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getItemExt() {
/* 1891 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setItemExt(IDataModel argExt) {
/* 1895 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 1900 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 1904 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 1907 */     super.startTransaction();
/*      */     
/* 1909 */     this._itemOptionsSavepoint = this._itemOptions;
/* 1910 */     if (this._itemOptions != null) {
/* 1911 */       this._itemOptionsSavepoint = new HistoricalList((List)this._itemOptions);
/* 1912 */       Iterator<IDataModel> it = this._itemOptions.iterator();
/* 1913 */       while (it.hasNext()) {
/* 1914 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1918 */     this._parentItemSavepoint = this._parentItem;
/* 1919 */     if (this._parentItem != null) {
/* 1920 */       this._parentItem.startTransaction();
/*      */     }
/*      */     
/* 1923 */     this._itemDealPropertiesSavepoint = this._itemDealProperties;
/* 1924 */     if (this._itemDealProperties != null) {
/* 1925 */       this._itemDealPropertiesSavepoint = new HistoricalList((List)this._itemDealProperties);
/* 1926 */       Iterator<IDataModel> it = this._itemDealProperties.iterator();
/* 1927 */       while (it.hasNext()) {
/* 1928 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1932 */     this._itemPromptPropertiesSavepoint = this._itemPromptProperties;
/* 1933 */     if (this._itemPromptProperties != null) {
/* 1934 */       this._itemPromptPropertiesSavepoint = new HistoricalList((List)this._itemPromptProperties);
/* 1935 */       Iterator<IDataModel> it = this._itemPromptProperties.iterator();
/* 1936 */       while (it.hasNext()) {
/* 1937 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1941 */     this._itemLabelPropertiesSavepoint = this._itemLabelProperties;
/* 1942 */     if (this._itemLabelProperties != null) {
/* 1943 */       this._itemLabelProperties.startTransaction();
/*      */     }
/*      */     
/* 1946 */     this._itemImagesSavepoint = this._itemImages;
/* 1947 */     if (this._itemImages != null) {
/* 1948 */       this._itemImagesSavepoint = new HistoricalList((List)this._itemImages);
/* 1949 */       Iterator<IDataModel> it = this._itemImages.iterator();
/* 1950 */       while (it.hasNext()) {
/* 1951 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1955 */     this._itemDimensionTypesSavepoint = this._itemDimensionTypes;
/* 1956 */     if (this._itemDimensionTypes != null) {
/* 1957 */       this._itemDimensionTypesSavepoint = new HistoricalList((List)this._itemDimensionTypes);
/* 1958 */       Iterator<IDataModel> it = this._itemDimensionTypes.iterator();
/* 1959 */       while (it.hasNext()) {
/* 1960 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1964 */     this._itemDimensionValuesSavepoint = this._itemDimensionValues;
/* 1965 */     if (this._itemDimensionValues != null) {
/* 1966 */       this._itemDimensionValuesSavepoint = new HistoricalList((List)this._itemDimensionValues);
/* 1967 */       Iterator<IDataModel> it = this._itemDimensionValues.iterator();
/* 1968 */       while (it.hasNext()) {
/* 1969 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */     
/* 1973 */     this._propertiesSavepoint = this._properties;
/* 1974 */     if (this._properties != null) {
/* 1975 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 1976 */       Iterator<IDataModel> it = this._properties.iterator();
/* 1977 */       while (it.hasNext()) {
/* 1978 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1983 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 1988 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 1991 */     super.rollbackChanges();
/*      */     
/* 1993 */     this._itemOptions = this._itemOptionsSavepoint;
/* 1994 */     this._itemOptionsSavepoint = null;
/* 1995 */     if (this._itemOptions != null) {
/* 1996 */       Iterator<IDataModel> it = this._itemOptions.iterator();
/* 1997 */       while (it.hasNext()) {
/* 1998 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 2002 */     this._parentItem = this._parentItemSavepoint;
/* 2003 */     this._parentItemSavepoint = null;
/* 2004 */     if (this._parentItem != null) {
/* 2005 */       this._parentItem.rollbackChanges();
/*      */     }
/*      */     
/* 2008 */     this._itemDealProperties = this._itemDealPropertiesSavepoint;
/* 2009 */     this._itemDealPropertiesSavepoint = null;
/* 2010 */     if (this._itemDealProperties != null) {
/* 2011 */       Iterator<IDataModel> it = this._itemDealProperties.iterator();
/* 2012 */       while (it.hasNext()) {
/* 2013 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 2017 */     this._itemPromptProperties = this._itemPromptPropertiesSavepoint;
/* 2018 */     this._itemPromptPropertiesSavepoint = null;
/* 2019 */     if (this._itemPromptProperties != null) {
/* 2020 */       Iterator<IDataModel> it = this._itemPromptProperties.iterator();
/* 2021 */       while (it.hasNext()) {
/* 2022 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 2026 */     this._itemLabelProperties = this._itemLabelPropertiesSavepoint;
/* 2027 */     this._itemLabelPropertiesSavepoint = null;
/* 2028 */     if (this._itemLabelProperties != null) {
/* 2029 */       this._itemLabelProperties.rollbackChanges();
/*      */     }
/*      */     
/* 2032 */     this._itemImages = this._itemImagesSavepoint;
/* 2033 */     this._itemImagesSavepoint = null;
/* 2034 */     if (this._itemImages != null) {
/* 2035 */       Iterator<IDataModel> it = this._itemImages.iterator();
/* 2036 */       while (it.hasNext()) {
/* 2037 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 2041 */     this._itemDimensionTypes = this._itemDimensionTypesSavepoint;
/* 2042 */     this._itemDimensionTypesSavepoint = null;
/* 2043 */     if (this._itemDimensionTypes != null) {
/* 2044 */       Iterator<IDataModel> it = this._itemDimensionTypes.iterator();
/* 2045 */       while (it.hasNext()) {
/* 2046 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 2050 */     this._itemDimensionValues = this._itemDimensionValuesSavepoint;
/* 2051 */     this._itemDimensionValuesSavepoint = null;
/* 2052 */     if (this._itemDimensionValues != null) {
/* 2053 */       Iterator<IDataModel> it = this._itemDimensionValues.iterator();
/* 2054 */       while (it.hasNext()) {
/* 2055 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */     
/* 2059 */     this._properties = this._propertiesSavepoint;
/* 2060 */     this._propertiesSavepoint = null;
/* 2061 */     if (this._properties != null) {
/* 2062 */       Iterator<IDataModel> it = this._properties.iterator();
/* 2063 */       while (it.hasNext()) {
/* 2064 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 2072 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 2075 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 2078 */     super.commitTransaction();
/*      */     
/* 2080 */     this._itemOptionsSavepoint = this._itemOptions;
/* 2081 */     if (this._itemOptions != null) {
/* 2082 */       Iterator<IDataModel> it = this._itemOptions.iterator();
/* 2083 */       while (it.hasNext()) {
/* 2084 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 2086 */       this._itemOptions = new HistoricalList((List)this._itemOptions);
/*      */     } 
/*      */     
/* 2089 */     this._parentItemSavepoint = this._parentItem;
/* 2090 */     if (this._parentItem != null) {
/* 2091 */       this._parentItem.commitTransaction();
/*      */     }
/*      */     
/* 2094 */     this._itemDealPropertiesSavepoint = this._itemDealProperties;
/* 2095 */     if (this._itemDealProperties != null) {
/* 2096 */       Iterator<IDataModel> it = this._itemDealProperties.iterator();
/* 2097 */       while (it.hasNext()) {
/* 2098 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 2100 */       this._itemDealProperties = new HistoricalList((List)this._itemDealProperties);
/*      */     } 
/*      */     
/* 2103 */     this._itemPromptPropertiesSavepoint = this._itemPromptProperties;
/* 2104 */     if (this._itemPromptProperties != null) {
/* 2105 */       Iterator<IDataModel> it = this._itemPromptProperties.iterator();
/* 2106 */       while (it.hasNext()) {
/* 2107 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 2109 */       this._itemPromptProperties = new HistoricalList((List)this._itemPromptProperties);
/*      */     } 
/*      */     
/* 2112 */     this._itemLabelPropertiesSavepoint = this._itemLabelProperties;
/* 2113 */     if (this._itemLabelProperties != null) {
/* 2114 */       this._itemLabelProperties.commitTransaction();
/*      */     }
/*      */     
/* 2117 */     this._itemImagesSavepoint = this._itemImages;
/* 2118 */     if (this._itemImages != null) {
/* 2119 */       Iterator<IDataModel> it = this._itemImages.iterator();
/* 2120 */       while (it.hasNext()) {
/* 2121 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 2123 */       this._itemImages = new HistoricalList((List)this._itemImages);
/*      */     } 
/*      */     
/* 2126 */     this._itemDimensionTypesSavepoint = this._itemDimensionTypes;
/* 2127 */     if (this._itemDimensionTypes != null) {
/* 2128 */       Iterator<IDataModel> it = this._itemDimensionTypes.iterator();
/* 2129 */       while (it.hasNext()) {
/* 2130 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 2132 */       this._itemDimensionTypes = new HistoricalList((List)this._itemDimensionTypes);
/*      */     } 
/*      */     
/* 2135 */     this._itemDimensionValuesSavepoint = this._itemDimensionValues;
/* 2136 */     if (this._itemDimensionValues != null) {
/* 2137 */       Iterator<IDataModel> it = this._itemDimensionValues.iterator();
/* 2138 */       while (it.hasNext()) {
/* 2139 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 2141 */       this._itemDimensionValues = new HistoricalList((List)this._itemDimensionValues);
/*      */     } 
/*      */     
/* 2144 */     this._propertiesSavepoint = this._properties;
/* 2145 */     if (this._properties != null) {
/* 2146 */       Iterator<IDataModel> it = this._properties.iterator();
/* 2147 */       while (it.hasNext()) {
/* 2148 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 2150 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 2154 */     this._alreadyInCommit = false;
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */