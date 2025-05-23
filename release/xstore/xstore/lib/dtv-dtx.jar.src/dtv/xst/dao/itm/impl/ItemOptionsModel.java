/*      */ package dtv.xst.dao.itm.impl;
/*      */ import dtv.data2.IPersistenceDefaults;
/*      */ import dtv.data2.access.DataFactory;
/*      */ import dtv.data2.access.IDataAccessObject;
/*      */ import dtv.data2.access.IDataModel;
/*      */ import dtv.data2.access.IDataProperty;
/*      */ import dtv.data2.access.IObjectId;
/*      */ import dtv.data2.access.ModelEventor;
/*      */ import dtv.data2.access.impl.IDataModelImpl;
/*      */ import dtv.data2.access.impl.Relationship;
/*      */ import dtv.event.EventDescriptor;
/*      */ import dtv.event.EventHandler;
/*      */ import dtv.event.EventManager;
/*      */ import dtv.event.Eventor;
/*      */ import dtv.event.IEventAware;
/*      */ import dtv.event.IEventSource;
/*      */ import dtv.event.handler.CascadingHandler;
/*      */ import dtv.util.HistoricalList;
/*      */ import dtv.util.StringUtils;
/*      */ import dtv.xst.dao.itm.IItem;
/*      */ import dtv.xst.dao.itm.IItemOptions;
/*      */ import dtv.xst.dao.itm.IItemOptionsProperty;
/*      */ import dtv.xst.dao.itm.IVendor;
/*      */ import dtv.xst.dao.itm.ItemOptionsPropertyId;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ public class ItemOptionsModel extends ItemOptionsBaseModel implements IItemOptions {
/*      */   private static final long serialVersionUID = -115523605L;
/*      */   private IItem _item;
/*      */   private transient boolean _alreadyInStart = false;
/*      */   private transient boolean _alreadyInCommit = false;
/*      */   
/*      */   public String toString() {
/*   37 */     return super.toString() + " Id: " + getObjectId();
/*      */   }
/*      */   private IDataModel _myExtension; private IVendor _itemVendor; private transient IVendor _itemVendorSavepoint; private HistoricalList<IItemOptionsProperty> _properties; private transient HistoricalList<IItemOptionsProperty> _propertiesSavepoint;
/*      */   
/*      */   public void initDAO() {
/*   42 */     setDAO((IDataAccessObject)new ItemOptionsDAO());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private ItemOptionsDAO getDAO_() {
/*   50 */     return (ItemOptionsDAO)this._daoImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getOrganizationId() {
/*   58 */     if (getDAO_().getOrganizationId() != null) {
/*   59 */       return getDAO_().getOrganizationId().longValue();
/*      */     }
/*   61 */     if (getParentOptions() != null) {
/*   62 */       return getParentOptions().getOrganizationId();
/*      */     }
/*      */     
/*   65 */     return 0L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOrganizationId(long argOrganizationId) {
/*   74 */     if (setOrganizationId_noev(argOrganizationId) && 
/*   75 */       this._events != null && 
/*   76 */       postEventsForChanges()) {
/*   77 */       this._events.post(IItemOptions.SET_ORGANIZATIONID, Long.valueOf(argOrganizationId));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setOrganizationId_noev(long argOrganizationId) {
/*   84 */     boolean ev_postable = false;
/*      */     
/*   86 */     if ((getDAO_().getOrganizationId() == null && Long.valueOf(argOrganizationId) != null) || (
/*   87 */       getDAO_().getOrganizationId() != null && !getDAO_().getOrganizationId().equals(Long.valueOf(argOrganizationId)))) {
/*   88 */       getDAO_().setOrganizationId(Long.valueOf(argOrganizationId));
/*   89 */       ev_postable = true;
/*   90 */       if (this._properties != null) {
/*      */         
/*   92 */         Iterator<ItemOptionsPropertyModel> it = this._properties.iterator();
/*   93 */         while (it.hasNext())
/*      */         {
/*   95 */           ((ItemOptionsPropertyModel)it.next()).setOrganizationId_noev(argOrganizationId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  100 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getItemId() {
/*  108 */     if (getDAO_().getItemId() == null && getParentOptions() != null) {
/*  109 */       return getParentOptions().getItemId();
/*      */     }
/*      */     
/*  112 */     return getDAO_().getItemId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setItemId(String argItemId) {
/*  121 */     if (setItemId_noev(argItemId) && 
/*  122 */       this._events != null && 
/*  123 */       postEventsForChanges()) {
/*  124 */       this._events.post(IItemOptions.SET_ITEMID, argItemId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setItemId_noev(String argItemId) {
/*  131 */     boolean ev_postable = false;
/*      */     
/*  133 */     if ((getDAO_().getItemId() == null && argItemId != null) || (
/*  134 */       getDAO_().getItemId() != null && !getDAO_().getItemId().equals(argItemId))) {
/*  135 */       getDAO_().setItemId(argItemId);
/*  136 */       ev_postable = true;
/*  137 */       if (this._properties != null) {
/*      */         
/*  139 */         Iterator<ItemOptionsPropertyModel> it = this._properties.iterator();
/*  140 */         while (it.hasNext())
/*      */         {
/*  142 */           ((ItemOptionsPropertyModel)it.next()).setItemId_noev(argItemId);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  147 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getLevelCode() {
/*  155 */     if (getDAO_().getLevelCode() == null && getParentOptions() != null) {
/*  156 */       return getParentOptions().getLevelCode();
/*      */     }
/*      */     
/*  159 */     return getDAO_().getLevelCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLevelCode(String argLevelCode) {
/*  168 */     if (setLevelCode_noev(argLevelCode) && 
/*  169 */       this._events != null && 
/*  170 */       postEventsForChanges()) {
/*  171 */       this._events.post(IItemOptions.SET_LEVELCODE, argLevelCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLevelCode_noev(String argLevelCode) {
/*  178 */     boolean ev_postable = false;
/*      */     
/*  180 */     if ((getDAO_().getLevelCode() == null && argLevelCode != null) || (
/*  181 */       getDAO_().getLevelCode() != null && !getDAO_().getLevelCode().equals(argLevelCode))) {
/*  182 */       getDAO_().setLevelCode(argLevelCode);
/*  183 */       ev_postable = true;
/*  184 */       if (this._properties != null) {
/*      */         
/*  186 */         Iterator<ItemOptionsPropertyModel> it = this._properties.iterator();
/*  187 */         while (it.hasNext())
/*      */         {
/*  189 */           ((ItemOptionsPropertyModel)it.next()).setLevelCode_noev(argLevelCode);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  194 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getLevelValue() {
/*  202 */     if (getDAO_().getLevelValue() == null && getParentOptions() != null) {
/*  203 */       return getParentOptions().getLevelValue();
/*      */     }
/*      */     
/*  206 */     return getDAO_().getLevelValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLevelValue(String argLevelValue) {
/*  215 */     if (setLevelValue_noev(argLevelValue) && 
/*  216 */       this._events != null && 
/*  217 */       postEventsForChanges()) {
/*  218 */       this._events.post(IItemOptions.SET_LEVELVALUE, argLevelValue);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setLevelValue_noev(String argLevelValue) {
/*  225 */     boolean ev_postable = false;
/*      */     
/*  227 */     if ((getDAO_().getLevelValue() == null && argLevelValue != null) || (
/*  228 */       getDAO_().getLevelValue() != null && !getDAO_().getLevelValue().equals(argLevelValue))) {
/*  229 */       getDAO_().setLevelValue(argLevelValue);
/*  230 */       ev_postable = true;
/*  231 */       if (this._properties != null) {
/*      */         
/*  233 */         Iterator<ItemOptionsPropertyModel> it = this._properties.iterator();
/*  234 */         while (it.hasNext())
/*      */         {
/*  236 */           ((ItemOptionsPropertyModel)it.next()).setLevelValue_noev(argLevelValue);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  241 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getCreateDate() {
/*  249 */     if (getDAO_().getCreateDate() == null && getParentOptions() != null) {
/*  250 */       return getParentOptions().getCreateDate();
/*      */     }
/*      */     
/*  253 */     return getDAO_().getCreateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateDate(Date argCreateDate) {
/*  262 */     if (setCreateDate_noev(argCreateDate) && 
/*  263 */       this._events != null && 
/*  264 */       postEventsForChanges()) {
/*  265 */       this._events.post(IItemOptions.SET_CREATEDATE, argCreateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateDate_noev(Date argCreateDate) {
/*  272 */     boolean ev_postable = false;
/*      */     
/*  274 */     if ((getDAO_().getCreateDate() == null && argCreateDate != null) || (
/*  275 */       getDAO_().getCreateDate() != null && !getDAO_().getCreateDate().equals(argCreateDate))) {
/*  276 */       getDAO_().setCreateDate(argCreateDate);
/*  277 */       ev_postable = true;
/*      */     } 
/*      */     
/*  280 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCreateUserId() {
/*  288 */     if (getDAO_().getCreateUserId() == null && getParentOptions() != null) {
/*  289 */       return getParentOptions().getCreateUserId();
/*      */     }
/*      */     
/*  292 */     return getDAO_().getCreateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCreateUserId(String argCreateUserId) {
/*  301 */     if (setCreateUserId_noev(argCreateUserId) && 
/*  302 */       this._events != null && 
/*  303 */       postEventsForChanges()) {
/*  304 */       this._events.post(IItemOptions.SET_CREATEUSERID, argCreateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCreateUserId_noev(String argCreateUserId) {
/*  311 */     boolean ev_postable = false;
/*      */     
/*  313 */     if ((getDAO_().getCreateUserId() == null && argCreateUserId != null) || (
/*  314 */       getDAO_().getCreateUserId() != null && !getDAO_().getCreateUserId().equals(argCreateUserId))) {
/*  315 */       getDAO_().setCreateUserId(argCreateUserId);
/*  316 */       ev_postable = true;
/*      */     } 
/*      */     
/*  319 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getUpdateDate() {
/*  327 */     if (getDAO_().getUpdateDate() == null && getParentOptions() != null) {
/*  328 */       return getParentOptions().getUpdateDate();
/*      */     }
/*      */     
/*  331 */     return getDAO_().getUpdateDate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateDate(Date argUpdateDate) {
/*  340 */     if (setUpdateDate_noev(argUpdateDate) && 
/*  341 */       this._events != null && 
/*  342 */       postEventsForChanges()) {
/*  343 */       this._events.post(IItemOptions.SET_UPDATEDATE, argUpdateDate);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateDate_noev(Date argUpdateDate) {
/*  350 */     boolean ev_postable = false;
/*      */     
/*  352 */     if ((getDAO_().getUpdateDate() == null && argUpdateDate != null) || (
/*  353 */       getDAO_().getUpdateDate() != null && !getDAO_().getUpdateDate().equals(argUpdateDate))) {
/*  354 */       getDAO_().setUpdateDate(argUpdateDate);
/*  355 */       ev_postable = true;
/*      */     } 
/*      */     
/*  358 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUpdateUserId() {
/*  366 */     if (getDAO_().getUpdateUserId() == null && getParentOptions() != null) {
/*  367 */       return getParentOptions().getUpdateUserId();
/*      */     }
/*      */     
/*  370 */     return getDAO_().getUpdateUserId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpdateUserId(String argUpdateUserId) {
/*  379 */     if (setUpdateUserId_noev(argUpdateUserId) && 
/*  380 */       this._events != null && 
/*  381 */       postEventsForChanges()) {
/*  382 */       this._events.post(IItemOptions.SET_UPDATEUSERID, argUpdateUserId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUpdateUserId_noev(String argUpdateUserId) {
/*  389 */     boolean ev_postable = false;
/*      */     
/*  391 */     if ((getDAO_().getUpdateUserId() == null && argUpdateUserId != null) || (
/*  392 */       getDAO_().getUpdateUserId() != null && !getDAO_().getUpdateUserId().equals(argUpdateUserId))) {
/*  393 */       getDAO_().setUpdateUserId(argUpdateUserId);
/*  394 */       ev_postable = true;
/*      */     } 
/*      */     
/*  397 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getApplyRestockingFee() {
/*  405 */     if (getDAO_().getApplyRestockingFee() != null) {
/*  406 */       return getDAO_().getApplyRestockingFee().booleanValue();
/*      */     }
/*  408 */     if (getParentOptions() != null) {
/*  409 */       return getParentOptions().getApplyRestockingFee();
/*      */     }
/*      */     
/*  412 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setApplyRestockingFee(boolean argApplyRestockingFee) {
/*  421 */     if (setApplyRestockingFee_noev(argApplyRestockingFee) && 
/*  422 */       this._events != null && 
/*  423 */       postEventsForChanges()) {
/*  424 */       this._events.post(IItemOptions.SET_APPLYRESTOCKINGFEE, Boolean.valueOf(argApplyRestockingFee));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setApplyRestockingFee_noev(boolean argApplyRestockingFee) {
/*  431 */     boolean ev_postable = false;
/*      */     
/*  433 */     if ((getDAO_().getApplyRestockingFee() == null && Boolean.valueOf(argApplyRestockingFee) != null) || (
/*  434 */       getDAO_().getApplyRestockingFee() != null && !getDAO_().getApplyRestockingFee().equals(Boolean.valueOf(argApplyRestockingFee)))) {
/*  435 */       getDAO_().setApplyRestockingFee(Boolean.valueOf(argApplyRestockingFee));
/*  436 */       ev_postable = true;
/*      */     } 
/*      */     
/*  439 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getAttachedItems() {
/*  447 */     if (getDAO_().getAttachedItems() != null) {
/*  448 */       return getDAO_().getAttachedItems().booleanValue();
/*      */     }
/*  450 */     if (getParentOptions() != null) {
/*  451 */       return getParentOptions().getAttachedItems();
/*      */     }
/*      */     
/*  454 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAttachedItems(boolean argAttachedItems) {
/*  463 */     if (setAttachedItems_noev(argAttachedItems) && 
/*  464 */       this._events != null && 
/*  465 */       postEventsForChanges()) {
/*  466 */       this._events.post(IItemOptions.SET_ATTACHEDITEMS, Boolean.valueOf(argAttachedItems));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setAttachedItems_noev(boolean argAttachedItems) {
/*  473 */     boolean ev_postable = false;
/*      */     
/*  475 */     if ((getDAO_().getAttachedItems() == null && Boolean.valueOf(argAttachedItems) != null) || (
/*  476 */       getDAO_().getAttachedItems() != null && !getDAO_().getAttachedItems().equals(Boolean.valueOf(argAttachedItems)))) {
/*  477 */       getDAO_().setAttachedItems(Boolean.valueOf(argAttachedItems));
/*  478 */       ev_postable = true;
/*      */     } 
/*      */     
/*  481 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getCompareAtPrice() {
/*  489 */     if (getDAO_().getCompareAtPrice() == null && getParentOptions() != null) {
/*  490 */       return getParentOptions().getCompareAtPrice();
/*      */     }
/*      */     
/*  493 */     return getDAO_().getCompareAtPrice();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCompareAtPrice(BigDecimal argCompareAtPrice) {
/*  502 */     if (setCompareAtPrice_noev(argCompareAtPrice) && 
/*  503 */       this._events != null && 
/*  504 */       postEventsForChanges()) {
/*  505 */       this._events.post(IItemOptions.SET_COMPAREATPRICE, argCompareAtPrice);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCompareAtPrice_noev(BigDecimal argCompareAtPrice) {
/*  512 */     boolean ev_postable = false;
/*      */     
/*  514 */     if ((getDAO_().getCompareAtPrice() == null && argCompareAtPrice != null) || (
/*  515 */       getDAO_().getCompareAtPrice() != null && !getDAO_().getCompareAtPrice().equals(argCompareAtPrice))) {
/*  516 */       getDAO_().setCompareAtPrice(argCompareAtPrice);
/*  517 */       ev_postable = true;
/*      */     } 
/*      */     
/*  520 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getDisallowDiscounts() {
/*  528 */     if (getDAO_().getDisallowDiscounts() != null) {
/*  529 */       return getDAO_().getDisallowDiscounts().booleanValue();
/*      */     }
/*  531 */     if (getParentOptions() != null) {
/*  532 */       return getParentOptions().getDisallowDiscounts();
/*      */     }
/*      */     
/*  535 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDisallowDiscounts(boolean argDisallowDiscounts) {
/*  544 */     if (setDisallowDiscounts_noev(argDisallowDiscounts) && 
/*  545 */       this._events != null && 
/*  546 */       postEventsForChanges()) {
/*  547 */       this._events.post(IItemOptions.SET_DISALLOWDISCOUNTS, Boolean.valueOf(argDisallowDiscounts));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDisallowDiscounts_noev(boolean argDisallowDiscounts) {
/*  554 */     boolean ev_postable = false;
/*      */     
/*  556 */     if ((getDAO_().getDisallowDiscounts() == null && Boolean.valueOf(argDisallowDiscounts) != null) || (
/*  557 */       getDAO_().getDisallowDiscounts() != null && !getDAO_().getDisallowDiscounts().equals(Boolean.valueOf(argDisallowDiscounts)))) {
/*  558 */       getDAO_().setDisallowDiscounts(Boolean.valueOf(argDisallowDiscounts));
/*  559 */       ev_postable = true;
/*      */     } 
/*      */     
/*  562 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getDisallowDeals() {
/*  570 */     if (getDAO_().getDisallowDeals() != null) {
/*  571 */       return getDAO_().getDisallowDeals().booleanValue();
/*      */     }
/*  573 */     if (getParentOptions() != null) {
/*  574 */       return getParentOptions().getDisallowDeals();
/*      */     }
/*      */     
/*  577 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDisallowDeals(boolean argDisallowDeals) {
/*  586 */     if (setDisallowDeals_noev(argDisallowDeals) && 
/*  587 */       this._events != null && 
/*  588 */       postEventsForChanges()) {
/*  589 */       this._events.post(IItemOptions.SET_DISALLOWDEALS, Boolean.valueOf(argDisallowDeals));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDisallowDeals_noev(boolean argDisallowDeals) {
/*  596 */     boolean ev_postable = false;
/*      */     
/*  598 */     if ((getDAO_().getDisallowDeals() == null && Boolean.valueOf(argDisallowDeals) != null) || (
/*  599 */       getDAO_().getDisallowDeals() != null && !getDAO_().getDisallowDeals().equals(Boolean.valueOf(argDisallowDeals)))) {
/*  600 */       getDAO_().setDisallowDeals(Boolean.valueOf(argDisallowDeals));
/*  601 */       ev_postable = true;
/*      */     } 
/*      */     
/*  604 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getDisallowPriceChange() {
/*  612 */     if (getDAO_().getDisallowPriceChange() != null) {
/*  613 */       return getDAO_().getDisallowPriceChange().booleanValue();
/*      */     }
/*  615 */     if (getParentOptions() != null) {
/*  616 */       return getParentOptions().getDisallowPriceChange();
/*      */     }
/*      */     
/*  619 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDisallowPriceChange(boolean argDisallowPriceChange) {
/*  628 */     if (setDisallowPriceChange_noev(argDisallowPriceChange) && 
/*  629 */       this._events != null && 
/*  630 */       postEventsForChanges()) {
/*  631 */       this._events.post(IItemOptions.SET_DISALLOWPRICECHANGE, Boolean.valueOf(argDisallowPriceChange));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDisallowPriceChange_noev(boolean argDisallowPriceChange) {
/*  638 */     boolean ev_postable = false;
/*      */     
/*  640 */     if ((getDAO_().getDisallowPriceChange() == null && Boolean.valueOf(argDisallowPriceChange) != null) || (
/*  641 */       getDAO_().getDisallowPriceChange() != null && !getDAO_().getDisallowPriceChange().equals(Boolean.valueOf(argDisallowPriceChange)))) {
/*  642 */       getDAO_().setDisallowPriceChange(Boolean.valueOf(argDisallowPriceChange));
/*  643 */       ev_postable = true;
/*      */     } 
/*      */     
/*  646 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getDisallowSendSale() {
/*  654 */     if (getDAO_().getDisallowSendSale() != null) {
/*  655 */       return getDAO_().getDisallowSendSale().booleanValue();
/*      */     }
/*  657 */     if (getParentOptions() != null) {
/*  658 */       return getParentOptions().getDisallowSendSale();
/*      */     }
/*      */     
/*  661 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDisallowSendSale(boolean argDisallowSendSale) {
/*  670 */     if (setDisallowSendSale_noev(argDisallowSendSale) && 
/*  671 */       this._events != null && 
/*  672 */       postEventsForChanges()) {
/*  673 */       this._events.post(IItemOptions.SET_DISALLOWSENDSALE, Boolean.valueOf(argDisallowSendSale));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDisallowSendSale_noev(boolean argDisallowSendSale) {
/*  680 */     boolean ev_postable = false;
/*      */     
/*  682 */     if ((getDAO_().getDisallowSendSale() == null && Boolean.valueOf(argDisallowSendSale) != null) || (
/*  683 */       getDAO_().getDisallowSendSale() != null && !getDAO_().getDisallowSendSale().equals(Boolean.valueOf(argDisallowSendSale)))) {
/*  684 */       getDAO_().setDisallowSendSale(Boolean.valueOf(argDisallowSendSale));
/*  685 */       ev_postable = true;
/*      */     } 
/*      */     
/*  688 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getDisallowCommission() {
/*  696 */     if (getDAO_().getDisallowCommission() != null) {
/*  697 */       return getDAO_().getDisallowCommission().booleanValue();
/*      */     }
/*  699 */     if (getParentOptions() != null) {
/*  700 */       return getParentOptions().getDisallowCommission();
/*      */     }
/*      */     
/*  703 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDisallowCommission(boolean argDisallowCommission) {
/*  712 */     if (setDisallowCommission_noev(argDisallowCommission) && 
/*  713 */       this._events != null && 
/*  714 */       postEventsForChanges()) {
/*  715 */       this._events.post(IItemOptions.SET_DISALLOWCOMMISSION, Boolean.valueOf(argDisallowCommission));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDisallowCommission_noev(boolean argDisallowCommission) {
/*  722 */     boolean ev_postable = false;
/*      */     
/*  724 */     if ((getDAO_().getDisallowCommission() == null && Boolean.valueOf(argDisallowCommission) != null) || (
/*  725 */       getDAO_().getDisallowCommission() != null && !getDAO_().getDisallowCommission().equals(Boolean.valueOf(argDisallowCommission)))) {
/*  726 */       getDAO_().setDisallowCommission(Boolean.valueOf(argDisallowCommission));
/*  727 */       ev_postable = true;
/*      */     } 
/*      */     
/*  730 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getDisallowLayaway() {
/*  738 */     if (getDAO_().getDisallowLayaway() != null) {
/*  739 */       return getDAO_().getDisallowLayaway().booleanValue();
/*      */     }
/*  741 */     if (getParentOptions() != null) {
/*  742 */       return getParentOptions().getDisallowLayaway();
/*      */     }
/*      */     
/*  745 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDisallowLayaway(boolean argDisallowLayaway) {
/*  754 */     if (setDisallowLayaway_noev(argDisallowLayaway) && 
/*  755 */       this._events != null && 
/*  756 */       postEventsForChanges()) {
/*  757 */       this._events.post(IItemOptions.SET_DISALLOWLAYAWAY, Boolean.valueOf(argDisallowLayaway));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDisallowLayaway_noev(boolean argDisallowLayaway) {
/*  764 */     boolean ev_postable = false;
/*      */     
/*  766 */     if ((getDAO_().getDisallowLayaway() == null && Boolean.valueOf(argDisallowLayaway) != null) || (
/*  767 */       getDAO_().getDisallowLayaway() != null && !getDAO_().getDisallowLayaway().equals(Boolean.valueOf(argDisallowLayaway)))) {
/*  768 */       getDAO_().setDisallowLayaway(Boolean.valueOf(argDisallowLayaway));
/*  769 */       ev_postable = true;
/*      */     } 
/*      */     
/*  772 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getDisallowWorkOrder() {
/*  780 */     if (getDAO_().getDisallowWorkOrder() != null) {
/*  781 */       return getDAO_().getDisallowWorkOrder().booleanValue();
/*      */     }
/*  783 */     if (getParentOptions() != null) {
/*  784 */       return getParentOptions().getDisallowWorkOrder();
/*      */     }
/*      */     
/*  787 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDisallowWorkOrder(boolean argDisallowWorkOrder) {
/*  796 */     if (setDisallowWorkOrder_noev(argDisallowWorkOrder) && 
/*  797 */       this._events != null && 
/*  798 */       postEventsForChanges()) {
/*  799 */       this._events.post(IItemOptions.SET_DISALLOWWORKORDER, Boolean.valueOf(argDisallowWorkOrder));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDisallowWorkOrder_noev(boolean argDisallowWorkOrder) {
/*  806 */     boolean ev_postable = false;
/*      */     
/*  808 */     if ((getDAO_().getDisallowWorkOrder() == null && Boolean.valueOf(argDisallowWorkOrder) != null) || (
/*  809 */       getDAO_().getDisallowWorkOrder() != null && !getDAO_().getDisallowWorkOrder().equals(Boolean.valueOf(argDisallowWorkOrder)))) {
/*  810 */       getDAO_().setDisallowWorkOrder(Boolean.valueOf(argDisallowWorkOrder));
/*  811 */       ev_postable = true;
/*      */     } 
/*      */     
/*  814 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getDisallowSpecialOrder() {
/*  822 */     if (getDAO_().getDisallowSpecialOrder() != null) {
/*  823 */       return getDAO_().getDisallowSpecialOrder().booleanValue();
/*      */     }
/*  825 */     if (getParentOptions() != null) {
/*  826 */       return getParentOptions().getDisallowSpecialOrder();
/*      */     }
/*      */     
/*  829 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDisallowSpecialOrder(boolean argDisallowSpecialOrder) {
/*  838 */     if (setDisallowSpecialOrder_noev(argDisallowSpecialOrder) && 
/*  839 */       this._events != null && 
/*  840 */       postEventsForChanges()) {
/*  841 */       this._events.post(IItemOptions.SET_DISALLOWSPECIALORDER, Boolean.valueOf(argDisallowSpecialOrder));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDisallowSpecialOrder_noev(boolean argDisallowSpecialOrder) {
/*  848 */     boolean ev_postable = false;
/*      */     
/*  850 */     if ((getDAO_().getDisallowSpecialOrder() == null && Boolean.valueOf(argDisallowSpecialOrder) != null) || (
/*  851 */       getDAO_().getDisallowSpecialOrder() != null && !getDAO_().getDisallowSpecialOrder().equals(Boolean.valueOf(argDisallowSpecialOrder)))) {
/*  852 */       getDAO_().setDisallowSpecialOrder(Boolean.valueOf(argDisallowSpecialOrder));
/*  853 */       ev_postable = true;
/*      */     } 
/*      */     
/*  856 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getDisallowOrder() {
/*  864 */     if (getDAO_().getDisallowOrder() != null) {
/*  865 */       return getDAO_().getDisallowOrder().booleanValue();
/*      */     }
/*  867 */     if (getParentOptions() != null) {
/*  868 */       return getParentOptions().getDisallowOrder();
/*      */     }
/*      */     
/*  871 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDisallowOrder(boolean argDisallowOrder) {
/*  880 */     if (setDisallowOrder_noev(argDisallowOrder) && 
/*  881 */       this._events != null && 
/*  882 */       postEventsForChanges()) {
/*  883 */       this._events.post(IItemOptions.SET_DISALLOWORDER, Boolean.valueOf(argDisallowOrder));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDisallowOrder_noev(boolean argDisallowOrder) {
/*  890 */     boolean ev_postable = false;
/*      */     
/*  892 */     if ((getDAO_().getDisallowOrder() == null && Boolean.valueOf(argDisallowOrder) != null) || (
/*  893 */       getDAO_().getDisallowOrder() != null && !getDAO_().getDisallowOrder().equals(Boolean.valueOf(argDisallowOrder)))) {
/*  894 */       getDAO_().setDisallowOrder(Boolean.valueOf(argDisallowOrder));
/*  895 */       ev_postable = true;
/*      */     } 
/*      */     
/*  898 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getDisallowRainCheck() {
/*  906 */     if (getDAO_().getDisallowRainCheck() != null) {
/*  907 */       return getDAO_().getDisallowRainCheck().booleanValue();
/*      */     }
/*  909 */     if (getParentOptions() != null) {
/*  910 */       return getParentOptions().getDisallowRainCheck();
/*      */     }
/*      */     
/*  913 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDisallowRainCheck(boolean argDisallowRainCheck) {
/*  922 */     if (setDisallowRainCheck_noev(argDisallowRainCheck) && 
/*  923 */       this._events != null && 
/*  924 */       postEventsForChanges()) {
/*  925 */       this._events.post(IItemOptions.SET_DISALLOWRAINCHECK, Boolean.valueOf(argDisallowRainCheck));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDisallowRainCheck_noev(boolean argDisallowRainCheck) {
/*  932 */     boolean ev_postable = false;
/*      */     
/*  934 */     if ((getDAO_().getDisallowRainCheck() == null && Boolean.valueOf(argDisallowRainCheck) != null) || (
/*  935 */       getDAO_().getDisallowRainCheck() != null && !getDAO_().getDisallowRainCheck().equals(Boolean.valueOf(argDisallowRainCheck)))) {
/*  936 */       getDAO_().setDisallowRainCheck(Boolean.valueOf(argDisallowRainCheck));
/*  937 */       ev_postable = true;
/*      */     } 
/*      */     
/*  940 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getForceQuantityOfOne() {
/*  948 */     if (getDAO_().getForceQuantityOfOne() != null) {
/*  949 */       return getDAO_().getForceQuantityOfOne().booleanValue();
/*      */     }
/*  951 */     if (getParentOptions() != null) {
/*  952 */       return getParentOptions().getForceQuantityOfOne();
/*      */     }
/*      */     
/*  955 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setForceQuantityOfOne(boolean argForceQuantityOfOne) {
/*  964 */     if (setForceQuantityOfOne_noev(argForceQuantityOfOne) && 
/*  965 */       this._events != null && 
/*  966 */       postEventsForChanges()) {
/*  967 */       this._events.post(IItemOptions.SET_FORCEQUANTITYOFONE, Boolean.valueOf(argForceQuantityOfOne));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setForceQuantityOfOne_noev(boolean argForceQuantityOfOne) {
/*  974 */     boolean ev_postable = false;
/*      */     
/*  976 */     if ((getDAO_().getForceQuantityOfOne() == null && Boolean.valueOf(argForceQuantityOfOne) != null) || (
/*  977 */       getDAO_().getForceQuantityOfOne() != null && !getDAO_().getForceQuantityOfOne().equals(Boolean.valueOf(argForceQuantityOfOne)))) {
/*  978 */       getDAO_().setForceQuantityOfOne(Boolean.valueOf(argForceQuantityOfOne));
/*  979 */       ev_postable = true;
/*      */     } 
/*      */     
/*  982 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getMaximumSaleUnitCount() {
/*  990 */     if (getDAO_().getMaximumSaleUnitCount() == null && getParentOptions() != null) {
/*  991 */       return getParentOptions().getMaximumSaleUnitCount();
/*      */     }
/*      */     
/*  994 */     return getDAO_().getMaximumSaleUnitCount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMaximumSaleUnitCount(BigDecimal argMaximumSaleUnitCount) {
/* 1003 */     if (setMaximumSaleUnitCount_noev(argMaximumSaleUnitCount) && 
/* 1004 */       this._events != null && 
/* 1005 */       postEventsForChanges()) {
/* 1006 */       this._events.post(IItemOptions.SET_MAXIMUMSALEUNITCOUNT, argMaximumSaleUnitCount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setMaximumSaleUnitCount_noev(BigDecimal argMaximumSaleUnitCount) {
/* 1013 */     boolean ev_postable = false;
/*      */     
/* 1015 */     if ((getDAO_().getMaximumSaleUnitCount() == null && argMaximumSaleUnitCount != null) || (
/* 1016 */       getDAO_().getMaximumSaleUnitCount() != null && !getDAO_().getMaximumSaleUnitCount().equals(argMaximumSaleUnitCount))) {
/* 1017 */       getDAO_().setMaximumSaleUnitCount(argMaximumSaleUnitCount);
/* 1018 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1021 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getMinimumSaleUnitCount() {
/* 1029 */     if (getDAO_().getMinimumSaleUnitCount() == null && getParentOptions() != null) {
/* 1030 */       return getParentOptions().getMinimumSaleUnitCount();
/*      */     }
/*      */     
/* 1033 */     return getDAO_().getMinimumSaleUnitCount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMinimumSaleUnitCount(BigDecimal argMinimumSaleUnitCount) {
/* 1042 */     if (setMinimumSaleUnitCount_noev(argMinimumSaleUnitCount) && 
/* 1043 */       this._events != null && 
/* 1044 */       postEventsForChanges()) {
/* 1045 */       this._events.post(IItemOptions.SET_MINIMUMSALEUNITCOUNT, argMinimumSaleUnitCount);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setMinimumSaleUnitCount_noev(BigDecimal argMinimumSaleUnitCount) {
/* 1052 */     boolean ev_postable = false;
/*      */     
/* 1054 */     if ((getDAO_().getMinimumSaleUnitCount() == null && argMinimumSaleUnitCount != null) || (
/* 1055 */       getDAO_().getMinimumSaleUnitCount() != null && !getDAO_().getMinimumSaleUnitCount().equals(argMinimumSaleUnitCount))) {
/* 1056 */       getDAO_().setMinimumSaleUnitCount(argMinimumSaleUnitCount);
/* 1057 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1060 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getNoGiveaways() {
/* 1068 */     if (getDAO_().getNoGiveaways() != null) {
/* 1069 */       return getDAO_().getNoGiveaways().booleanValue();
/*      */     }
/* 1071 */     if (getParentOptions() != null) {
/* 1072 */       return getParentOptions().getNoGiveaways();
/*      */     }
/*      */     
/* 1075 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNoGiveaways(boolean argNoGiveaways) {
/* 1084 */     if (setNoGiveaways_noev(argNoGiveaways) && 
/* 1085 */       this._events != null && 
/* 1086 */       postEventsForChanges()) {
/* 1087 */       this._events.post(IItemOptions.SET_NOGIVEAWAYS, Boolean.valueOf(argNoGiveaways));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setNoGiveaways_noev(boolean argNoGiveaways) {
/* 1094 */     boolean ev_postable = false;
/*      */     
/* 1096 */     if ((getDAO_().getNoGiveaways() == null && Boolean.valueOf(argNoGiveaways) != null) || (
/* 1097 */       getDAO_().getNoGiveaways() != null && !getDAO_().getNoGiveaways().equals(Boolean.valueOf(argNoGiveaways)))) {
/* 1098 */       getDAO_().setNoGiveaways(Boolean.valueOf(argNoGiveaways));
/* 1099 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1102 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getNotReturnable() {
/* 1110 */     if (getDAO_().getNotReturnable() != null) {
/* 1111 */       return getDAO_().getNotReturnable().booleanValue();
/*      */     }
/* 1113 */     if (getParentOptions() != null) {
/* 1114 */       return getParentOptions().getNotReturnable();
/*      */     }
/*      */     
/* 1117 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNotReturnable(boolean argNotReturnable) {
/* 1126 */     if (setNotReturnable_noev(argNotReturnable) && 
/* 1127 */       this._events != null && 
/* 1128 */       postEventsForChanges()) {
/* 1129 */       this._events.post(IItemOptions.SET_NOTRETURNABLE, Boolean.valueOf(argNotReturnable));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setNotReturnable_noev(boolean argNotReturnable) {
/* 1136 */     boolean ev_postable = false;
/*      */     
/* 1138 */     if ((getDAO_().getNotReturnable() == null && Boolean.valueOf(argNotReturnable) != null) || (
/* 1139 */       getDAO_().getNotReturnable() != null && !getDAO_().getNotReturnable().equals(Boolean.valueOf(argNotReturnable)))) {
/* 1140 */       getDAO_().setNotReturnable(Boolean.valueOf(argNotReturnable));
/* 1141 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1144 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPartNumber() {
/* 1152 */     if (getDAO_().getPartNumber() == null && getParentOptions() != null) {
/* 1153 */       return getParentOptions().getPartNumber();
/*      */     }
/*      */     
/* 1156 */     return getDAO_().getPartNumber();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPartNumber(String argPartNumber) {
/* 1165 */     if (setPartNumber_noev(argPartNumber) && 
/* 1166 */       this._events != null && 
/* 1167 */       postEventsForChanges()) {
/* 1168 */       this._events.post(IItemOptions.SET_PARTNUMBER, argPartNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPartNumber_noev(String argPartNumber) {
/* 1175 */     boolean ev_postable = false;
/*      */     
/* 1177 */     if ((getDAO_().getPartNumber() == null && argPartNumber != null) || (
/* 1178 */       getDAO_().getPartNumber() != null && !getDAO_().getPartNumber().equals(argPartNumber))) {
/* 1179 */       getDAO_().setPartNumber(argPartNumber);
/* 1180 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1183 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getPromptForPrice() {
/* 1191 */     if (getDAO_().getPromptForPrice() != null) {
/* 1192 */       return getDAO_().getPromptForPrice().booleanValue();
/*      */     }
/* 1194 */     if (getParentOptions() != null) {
/* 1195 */       return getParentOptions().getPromptForPrice();
/*      */     }
/*      */     
/* 1198 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPromptForPrice(boolean argPromptForPrice) {
/* 1207 */     if (setPromptForPrice_noev(argPromptForPrice) && 
/* 1208 */       this._events != null && 
/* 1209 */       postEventsForChanges()) {
/* 1210 */       this._events.post(IItemOptions.SET_PROMPTFORPRICE, Boolean.valueOf(argPromptForPrice));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPromptForPrice_noev(boolean argPromptForPrice) {
/* 1217 */     boolean ev_postable = false;
/*      */     
/* 1219 */     if ((getDAO_().getPromptForPrice() == null && Boolean.valueOf(argPromptForPrice) != null) || (
/* 1220 */       getDAO_().getPromptForPrice() != null && !getDAO_().getPromptForPrice().equals(Boolean.valueOf(argPromptForPrice)))) {
/* 1221 */       getDAO_().setPromptForPrice(Boolean.valueOf(argPromptForPrice));
/* 1222 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1225 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getPromptForQuantity() {
/* 1233 */     if (getDAO_().getPromptForQuantity() != null) {
/* 1234 */       return getDAO_().getPromptForQuantity().booleanValue();
/*      */     }
/* 1236 */     if (getParentOptions() != null) {
/* 1237 */       return getParentOptions().getPromptForQuantity();
/*      */     }
/*      */     
/* 1240 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPromptForQuantity(boolean argPromptForQuantity) {
/* 1249 */     if (setPromptForQuantity_noev(argPromptForQuantity) && 
/* 1250 */       this._events != null && 
/* 1251 */       postEventsForChanges()) {
/* 1252 */       this._events.post(IItemOptions.SET_PROMPTFORQUANTITY, Boolean.valueOf(argPromptForQuantity));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPromptForQuantity_noev(boolean argPromptForQuantity) {
/* 1259 */     boolean ev_postable = false;
/*      */     
/* 1261 */     if ((getDAO_().getPromptForQuantity() == null && Boolean.valueOf(argPromptForQuantity) != null) || (
/* 1262 */       getDAO_().getPromptForQuantity() != null && !getDAO_().getPromptForQuantity().equals(Boolean.valueOf(argPromptForQuantity)))) {
/* 1263 */       getDAO_().setPromptForQuantity(Boolean.valueOf(argPromptForQuantity));
/* 1264 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1267 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getPromptForDescription() {
/* 1275 */     if (getDAO_().getPromptForDescription() != null) {
/* 1276 */       return getDAO_().getPromptForDescription().booleanValue();
/*      */     }
/* 1278 */     if (getParentOptions() != null) {
/* 1279 */       return getParentOptions().getPromptForDescription();
/*      */     }
/*      */     
/* 1282 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPromptForDescription(boolean argPromptForDescription) {
/* 1291 */     if (setPromptForDescription_noev(argPromptForDescription) && 
/* 1292 */       this._events != null && 
/* 1293 */       postEventsForChanges()) {
/* 1294 */       this._events.post(IItemOptions.SET_PROMPTFORDESCRIPTION, Boolean.valueOf(argPromptForDescription));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPromptForDescription_noev(boolean argPromptForDescription) {
/* 1301 */     boolean ev_postable = false;
/*      */     
/* 1303 */     if ((getDAO_().getPromptForDescription() == null && Boolean.valueOf(argPromptForDescription) != null) || (
/* 1304 */       getDAO_().getPromptForDescription() != null && !getDAO_().getPromptForDescription().equals(Boolean.valueOf(argPromptForDescription)))) {
/* 1305 */       getDAO_().setPromptForDescription(Boolean.valueOf(argPromptForDescription));
/* 1306 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1309 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPromptForCustomer() {
/* 1317 */     if (getDAO_().getPromptForCustomer() == null && getParentOptions() != null) {
/* 1318 */       return getParentOptions().getPromptForCustomer();
/*      */     }
/*      */     
/* 1321 */     return getDAO_().getPromptForCustomer();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPromptForCustomer(String argPromptForCustomer) {
/* 1330 */     if (setPromptForCustomer_noev(argPromptForCustomer) && 
/* 1331 */       this._events != null && 
/* 1332 */       postEventsForChanges()) {
/* 1333 */       this._events.post(IItemOptions.SET_PROMPTFORCUSTOMER, argPromptForCustomer);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPromptForCustomer_noev(String argPromptForCustomer) {
/* 1340 */     boolean ev_postable = false;
/*      */     
/* 1342 */     if ((getDAO_().getPromptForCustomer() == null && argPromptForCustomer != null) || (
/* 1343 */       getDAO_().getPromptForCustomer() != null && !getDAO_().getPromptForCustomer().equals(argPromptForCustomer))) {
/* 1344 */       getDAO_().setPromptForCustomer(argPromptForCustomer);
/* 1345 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1348 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getRestockingFee() {
/* 1356 */     if (getDAO_().getRestockingFee() == null && getParentOptions() != null) {
/* 1357 */       return getParentOptions().getRestockingFee();
/*      */     }
/*      */     
/* 1360 */     return getDAO_().getRestockingFee();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRestockingFee(BigDecimal argRestockingFee) {
/* 1369 */     if (setRestockingFee_noev(argRestockingFee) && 
/* 1370 */       this._events != null && 
/* 1371 */       postEventsForChanges()) {
/* 1372 */       this._events.post(IItemOptions.SET_RESTOCKINGFEE, argRestockingFee);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setRestockingFee_noev(BigDecimal argRestockingFee) {
/* 1379 */     boolean ev_postable = false;
/*      */     
/* 1381 */     if ((getDAO_().getRestockingFee() == null && argRestockingFee != null) || (
/* 1382 */       getDAO_().getRestockingFee() != null && !getDAO_().getRestockingFee().equals(argRestockingFee))) {
/* 1383 */       getDAO_().setRestockingFee(argRestockingFee);
/* 1384 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1387 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSeasonCode() {
/* 1395 */     if (getDAO_().getSeasonCode() == null && getParentOptions() != null) {
/* 1396 */       return getParentOptions().getSeasonCode();
/*      */     }
/*      */     
/* 1399 */     return getDAO_().getSeasonCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSeasonCode(String argSeasonCode) {
/* 1408 */     if (setSeasonCode_noev(argSeasonCode) && 
/* 1409 */       this._events != null && 
/* 1410 */       postEventsForChanges()) {
/* 1411 */       this._events.post(IItemOptions.SET_SEASONCODE, argSeasonCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSeasonCode_noev(String argSeasonCode) {
/* 1418 */     boolean ev_postable = false;
/*      */     
/* 1420 */     if ((getDAO_().getSeasonCode() == null && argSeasonCode != null) || (
/* 1421 */       getDAO_().getSeasonCode() != null && !getDAO_().getSeasonCode().equals(argSeasonCode))) {
/* 1422 */       getDAO_().setSeasonCode(argSeasonCode);
/* 1423 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1426 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getSubstituteAvailable() {
/* 1434 */     if (getDAO_().getSubstituteAvailable() != null) {
/* 1435 */       return getDAO_().getSubstituteAvailable().booleanValue();
/*      */     }
/* 1437 */     if (getParentOptions() != null) {
/* 1438 */       return getParentOptions().getSubstituteAvailable();
/*      */     }
/*      */     
/* 1441 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSubstituteAvailable(boolean argSubstituteAvailable) {
/* 1450 */     if (setSubstituteAvailable_noev(argSubstituteAvailable) && 
/* 1451 */       this._events != null && 
/* 1452 */       postEventsForChanges()) {
/* 1453 */       this._events.post(IItemOptions.SET_SUBSTITUTEAVAILABLE, Boolean.valueOf(argSubstituteAvailable));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSubstituteAvailable_noev(boolean argSubstituteAvailable) {
/* 1460 */     boolean ev_postable = false;
/*      */     
/* 1462 */     if ((getDAO_().getSubstituteAvailable() == null && Boolean.valueOf(argSubstituteAvailable) != null) || (
/* 1463 */       getDAO_().getSubstituteAvailable() != null && !getDAO_().getSubstituteAvailable().equals(Boolean.valueOf(argSubstituteAvailable)))) {
/* 1464 */       getDAO_().setSubstituteAvailable(Boolean.valueOf(argSubstituteAvailable));
/* 1465 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1468 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getUnitCost() {
/* 1476 */     if (getDAO_().getUnitCost() == null && getParentOptions() != null) {
/* 1477 */       return getParentOptions().getUnitCost();
/*      */     }
/*      */     
/* 1480 */     return getDAO_().getUnitCost();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUnitCost(BigDecimal argUnitCost) {
/* 1489 */     if (setUnitCost_noev(argUnitCost) && 
/* 1490 */       this._events != null && 
/* 1491 */       postEventsForChanges()) {
/* 1492 */       this._events.post(IItemOptions.SET_UNITCOST, argUnitCost);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUnitCost_noev(BigDecimal argUnitCost) {
/* 1499 */     boolean ev_postable = false;
/*      */     
/* 1501 */     if ((getDAO_().getUnitCost() == null && argUnitCost != null) || (
/* 1502 */       getDAO_().getUnitCost() != null && !getDAO_().getUnitCost().equals(argUnitCost))) {
/* 1503 */       getDAO_().setUnitCost(argUnitCost);
/* 1504 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1507 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getVendorId() {
/* 1515 */     if (getDAO_().getVendorId() == null && getParentOptions() != null) {
/* 1516 */       return getParentOptions().getVendorId();
/*      */     }
/*      */     
/* 1519 */     return getDAO_().getVendorId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVendorId(String argVendorId) {
/* 1528 */     if (setVendorId_noev(argVendorId) && 
/* 1529 */       this._events != null && 
/* 1530 */       postEventsForChanges()) {
/* 1531 */       this._events.post(IItemOptions.SET_VENDORID, argVendorId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setVendorId_noev(String argVendorId) {
/* 1538 */     boolean ev_postable = false;
/*      */     
/* 1540 */     if ((getDAO_().getVendorId() == null && argVendorId != null) || (
/* 1541 */       getDAO_().getVendorId() != null && !getDAO_().getVendorId().equals(argVendorId))) {
/* 1542 */       getDAO_().setVendorId(argVendorId);
/* 1543 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1546 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getSpecialOrderLeadDays() {
/* 1554 */     if (getDAO_().getSpecialOrderLeadDays() != null) {
/* 1555 */       return getDAO_().getSpecialOrderLeadDays().intValue();
/*      */     }
/* 1557 */     if (getParentOptions() != null) {
/* 1558 */       return getParentOptions().getSpecialOrderLeadDays();
/*      */     }
/*      */     
/* 1561 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSpecialOrderLeadDays(int argSpecialOrderLeadDays) {
/* 1570 */     if (setSpecialOrderLeadDays_noev(argSpecialOrderLeadDays) && 
/* 1571 */       this._events != null && 
/* 1572 */       postEventsForChanges()) {
/* 1573 */       this._events.post(IItemOptions.SET_SPECIALORDERLEADDAYS, Integer.valueOf(argSpecialOrderLeadDays));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSpecialOrderLeadDays_noev(int argSpecialOrderLeadDays) {
/* 1580 */     boolean ev_postable = false;
/*      */     
/* 1582 */     if ((getDAO_().getSpecialOrderLeadDays() == null && Integer.valueOf(argSpecialOrderLeadDays) != null) || (
/* 1583 */       getDAO_().getSpecialOrderLeadDays() != null && !getDAO_().getSpecialOrderLeadDays().equals(Integer.valueOf(argSpecialOrderLeadDays)))) {
/* 1584 */       getDAO_().setSpecialOrderLeadDays(Integer.valueOf(argSpecialOrderLeadDays));
/* 1585 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1588 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getQtyScale() {
/* 1596 */     if (getDAO_().getQtyScale() != null) {
/* 1597 */       return getDAO_().getQtyScale().intValue();
/*      */     }
/* 1599 */     if (getParentOptions() != null) {
/* 1600 */       return getParentOptions().getQtyScale();
/*      */     }
/*      */     
/* 1603 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setQtyScale(int argQtyScale) {
/* 1612 */     if (setQtyScale_noev(argQtyScale) && 
/* 1613 */       this._events != null && 
/* 1614 */       postEventsForChanges()) {
/* 1615 */       this._events.post(IItemOptions.SET_QTYSCALE, Integer.valueOf(argQtyScale));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setQtyScale_noev(int argQtyScale) {
/* 1622 */     boolean ev_postable = false;
/*      */     
/* 1624 */     if ((getDAO_().getQtyScale() == null && Integer.valueOf(argQtyScale) != null) || (
/* 1625 */       getDAO_().getQtyScale() != null && !getDAO_().getQtyScale().equals(Integer.valueOf(argQtyScale)))) {
/* 1626 */       getDAO_().setQtyScale(Integer.valueOf(argQtyScale));
/* 1627 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1630 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getMessages() {
/* 1638 */     if (getDAO_().getMessages() != null) {
/* 1639 */       return getDAO_().getMessages().booleanValue();
/*      */     }
/* 1641 */     if (getParentOptions() != null) {
/* 1642 */       return getParentOptions().getMessages();
/*      */     }
/*      */     
/* 1645 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMessages(boolean argMessages) {
/* 1654 */     if (setMessages_noev(argMessages) && 
/* 1655 */       this._events != null && 
/* 1656 */       postEventsForChanges()) {
/* 1657 */       this._events.post(IItemOptions.SET_MESSAGES, Boolean.valueOf(argMessages));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setMessages_noev(boolean argMessages) {
/* 1664 */     boolean ev_postable = false;
/*      */     
/* 1666 */     if ((getDAO_().getMessages() == null && Boolean.valueOf(argMessages) != null) || (
/* 1667 */       getDAO_().getMessages() != null && !getDAO_().getMessages().equals(Boolean.valueOf(argMessages)))) {
/* 1668 */       getDAO_().setMessages(Boolean.valueOf(argMessages));
/* 1669 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1672 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUnitOfMeasureCode() {
/* 1680 */     if (getDAO_().getUnitOfMeasureCode() == null && getParentOptions() != null) {
/* 1681 */       return getParentOptions().getUnitOfMeasureCode();
/*      */     }
/*      */     
/* 1684 */     return getDAO_().getUnitOfMeasureCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUnitOfMeasureCode(String argUnitOfMeasureCode) {
/* 1693 */     if (setUnitOfMeasureCode_noev(argUnitOfMeasureCode) && 
/* 1694 */       this._events != null && 
/* 1695 */       postEventsForChanges()) {
/* 1696 */       this._events.post(IItemOptions.SET_UNITOFMEASURECODE, argUnitOfMeasureCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setUnitOfMeasureCode_noev(String argUnitOfMeasureCode) {
/* 1703 */     boolean ev_postable = false;
/*      */     
/* 1705 */     if ((getDAO_().getUnitOfMeasureCode() == null && argUnitOfMeasureCode != null) || (
/* 1706 */       getDAO_().getUnitOfMeasureCode() != null && !getDAO_().getUnitOfMeasureCode().equals(argUnitOfMeasureCode))) {
/* 1707 */       getDAO_().setUnitOfMeasureCode(argUnitOfMeasureCode);
/* 1708 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1711 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTaxGroupId() {
/* 1719 */     if (getDAO_().getTaxGroupId() == null && getParentOptions() != null) {
/* 1720 */       return getParentOptions().getTaxGroupId();
/*      */     }
/*      */     
/* 1723 */     return getDAO_().getTaxGroupId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTaxGroupId(String argTaxGroupId) {
/* 1732 */     if (setTaxGroupId_noev(argTaxGroupId) && 
/* 1733 */       this._events != null && 
/* 1734 */       postEventsForChanges()) {
/* 1735 */       this._events.post(IItemOptions.SET_TAXGROUPID, argTaxGroupId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTaxGroupId_noev(String argTaxGroupId) {
/* 1742 */     boolean ev_postable = false;
/*      */     
/* 1744 */     if ((getDAO_().getTaxGroupId() == null && argTaxGroupId != null) || (
/* 1745 */       getDAO_().getTaxGroupId() != null && !getDAO_().getTaxGroupId().equals(argTaxGroupId))) {
/* 1746 */       getDAO_().setTaxGroupId(argTaxGroupId);
/* 1747 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1750 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getWarranty() {
/* 1758 */     if (getDAO_().getWarranty() != null) {
/* 1759 */       return getDAO_().getWarranty().booleanValue();
/*      */     }
/* 1761 */     if (getParentOptions() != null) {
/* 1762 */       return getParentOptions().getWarranty();
/*      */     }
/*      */     
/* 1765 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWarranty(boolean argWarranty) {
/* 1774 */     if (setWarranty_noev(argWarranty) && 
/* 1775 */       this._events != null && 
/* 1776 */       postEventsForChanges()) {
/* 1777 */       this._events.post(IItemOptions.SET_WARRANTY, Boolean.valueOf(argWarranty));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setWarranty_noev(boolean argWarranty) {
/* 1784 */     boolean ev_postable = false;
/*      */     
/* 1786 */     if ((getDAO_().getWarranty() == null && Boolean.valueOf(argWarranty) != null) || (
/* 1787 */       getDAO_().getWarranty() != null && !getDAO_().getWarranty().equals(Boolean.valueOf(argWarranty)))) {
/* 1788 */       getDAO_().setWarranty(Boolean.valueOf(argWarranty));
/* 1789 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1792 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getGenericItem() {
/* 1800 */     if (getDAO_().getGenericItem() != null) {
/* 1801 */       return getDAO_().getGenericItem().booleanValue();
/*      */     }
/* 1803 */     if (getParentOptions() != null) {
/* 1804 */       return getParentOptions().getGenericItem();
/*      */     }
/*      */     
/* 1807 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setGenericItem(boolean argGenericItem) {
/* 1816 */     if (setGenericItem_noev(argGenericItem) && 
/* 1817 */       this._events != null && 
/* 1818 */       postEventsForChanges()) {
/* 1819 */       this._events.post(IItemOptions.SET_GENERICITEM, Boolean.valueOf(argGenericItem));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setGenericItem_noev(boolean argGenericItem) {
/* 1826 */     boolean ev_postable = false;
/*      */     
/* 1828 */     if ((getDAO_().getGenericItem() == null && Boolean.valueOf(argGenericItem) != null) || (
/* 1829 */       getDAO_().getGenericItem() != null && !getDAO_().getGenericItem().equals(Boolean.valueOf(argGenericItem)))) {
/* 1830 */       getDAO_().setGenericItem(Boolean.valueOf(argGenericItem));
/* 1831 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1834 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getCurrentSalePrice() {
/* 1842 */     if (getDAO_().getCurrentSalePrice() == null && getParentOptions() != null) {
/* 1843 */       return getParentOptions().getCurrentSalePrice();
/*      */     }
/*      */     
/* 1846 */     return getDAO_().getCurrentSalePrice();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCurrentSalePrice(BigDecimal argCurrentSalePrice) {
/* 1855 */     if (setCurrentSalePrice_noev(argCurrentSalePrice) && 
/* 1856 */       this._events != null && 
/* 1857 */       postEventsForChanges()) {
/* 1858 */       this._events.post(IItemOptions.SET_CURRENTSALEPRICE, argCurrentSalePrice);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setCurrentSalePrice_noev(BigDecimal argCurrentSalePrice) {
/* 1865 */     boolean ev_postable = false;
/*      */     
/* 1867 */     if ((getDAO_().getCurrentSalePrice() == null && argCurrentSalePrice != null) || (
/* 1868 */       getDAO_().getCurrentSalePrice() != null && !getDAO_().getCurrentSalePrice().equals(argCurrentSalePrice))) {
/* 1869 */       getDAO_().setCurrentSalePrice(argCurrentSalePrice);
/* 1870 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1873 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getInitialSaleQuantity() {
/* 1881 */     if (getDAO_().getInitialSaleQuantity() == null && getParentOptions() != null) {
/* 1882 */       return getParentOptions().getInitialSaleQuantity();
/*      */     }
/*      */     
/* 1885 */     return getDAO_().getInitialSaleQuantity();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setInitialSaleQuantity(BigDecimal argInitialSaleQuantity) {
/* 1894 */     if (setInitialSaleQuantity_noev(argInitialSaleQuantity) && 
/* 1895 */       this._events != null && 
/* 1896 */       postEventsForChanges()) {
/* 1897 */       this._events.post(IItemOptions.SET_INITIALSALEQUANTITY, argInitialSaleQuantity);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setInitialSaleQuantity_noev(BigDecimal argInitialSaleQuantity) {
/* 1904 */     boolean ev_postable = false;
/*      */     
/* 1906 */     if ((getDAO_().getInitialSaleQuantity() == null && argInitialSaleQuantity != null) || (
/* 1907 */       getDAO_().getInitialSaleQuantity() != null && !getDAO_().getInitialSaleQuantity().equals(argInitialSaleQuantity))) {
/* 1908 */       getDAO_().setInitialSaleQuantity(argInitialSaleQuantity);
/* 1909 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1912 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDispositionCode() {
/* 1920 */     if (getDAO_().getDispositionCode() == null && getParentOptions() != null) {
/* 1921 */       return getParentOptions().getDispositionCode();
/*      */     }
/*      */     
/* 1924 */     return getDAO_().getDispositionCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDispositionCode(String argDispositionCode) {
/* 1933 */     if (setDispositionCode_noev(argDispositionCode) && 
/* 1934 */       this._events != null && 
/* 1935 */       postEventsForChanges()) {
/* 1936 */       this._events.post(IItemOptions.SET_DISPOSITIONCODE, argDispositionCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDispositionCode_noev(String argDispositionCode) {
/* 1943 */     boolean ev_postable = false;
/*      */     
/* 1945 */     if ((getDAO_().getDispositionCode() == null && argDispositionCode != null) || (
/* 1946 */       getDAO_().getDispositionCode() != null && !getDAO_().getDispositionCode().equals(argDispositionCode))) {
/* 1947 */       getDAO_().setDispositionCode(argDispositionCode);
/* 1948 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1951 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getItemAvailabilityCode() {
/* 1959 */     if (getDAO_().getItemAvailabilityCode() == null && getParentOptions() != null) {
/* 1960 */       return getParentOptions().getItemAvailabilityCode();
/*      */     }
/*      */     
/* 1963 */     return getDAO_().getItemAvailabilityCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setItemAvailabilityCode(String argItemAvailabilityCode) {
/* 1972 */     if (setItemAvailabilityCode_noev(argItemAvailabilityCode) && 
/* 1973 */       this._events != null && 
/* 1974 */       postEventsForChanges()) {
/* 1975 */       this._events.post(IItemOptions.SET_ITEMAVAILABILITYCODE, argItemAvailabilityCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setItemAvailabilityCode_noev(String argItemAvailabilityCode) {
/* 1982 */     boolean ev_postable = false;
/*      */     
/* 1984 */     if ((getDAO_().getItemAvailabilityCode() == null && argItemAvailabilityCode != null) || (
/* 1985 */       getDAO_().getItemAvailabilityCode() != null && !getDAO_().getItemAvailabilityCode().equals(argItemAvailabilityCode))) {
/* 1986 */       getDAO_().setItemAvailabilityCode(argItemAvailabilityCode);
/* 1987 */       ev_postable = true;
/*      */     } 
/*      */     
/* 1990 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMinAgeRequired() {
/* 1998 */     if (getDAO_().getMinAgeRequired() != null) {
/* 1999 */       return getDAO_().getMinAgeRequired().intValue();
/*      */     }
/* 2001 */     if (getParentOptions() != null) {
/* 2002 */       return getParentOptions().getMinAgeRequired();
/*      */     }
/*      */     
/* 2005 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMinAgeRequired(int argMinAgeRequired) {
/* 2014 */     if (setMinAgeRequired_noev(argMinAgeRequired) && 
/* 2015 */       this._events != null && 
/* 2016 */       postEventsForChanges()) {
/* 2017 */       this._events.post(IItemOptions.SET_MINAGEREQUIRED, Integer.valueOf(argMinAgeRequired));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setMinAgeRequired_noev(int argMinAgeRequired) {
/* 2024 */     boolean ev_postable = false;
/*      */     
/* 2026 */     if ((getDAO_().getMinAgeRequired() == null && Integer.valueOf(argMinAgeRequired) != null) || (
/* 2027 */       getDAO_().getMinAgeRequired() != null && !getDAO_().getMinAgeRequired().equals(Integer.valueOf(argMinAgeRequired)))) {
/* 2028 */       getDAO_().setMinAgeRequired(Integer.valueOf(argMinAgeRequired));
/* 2029 */       ev_postable = true;
/*      */     } 
/*      */     
/* 2032 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getStockStatus() {
/* 2040 */     if (getDAO_().getStockStatus() == null && getParentOptions() != null) {
/* 2041 */       return getParentOptions().getStockStatus();
/*      */     }
/*      */     
/* 2044 */     return getDAO_().getStockStatus();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStockStatus(String argStockStatus) {
/* 2053 */     if (setStockStatus_noev(argStockStatus) && 
/* 2054 */       this._events != null && 
/* 2055 */       postEventsForChanges()) {
/* 2056 */       this._events.post(IItemOptions.SET_STOCKSTATUS, argStockStatus);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setStockStatus_noev(String argStockStatus) {
/* 2063 */     boolean ev_postable = false;
/*      */     
/* 2065 */     if ((getDAO_().getStockStatus() == null && argStockStatus != null) || (
/* 2066 */       getDAO_().getStockStatus() != null && !getDAO_().getStockStatus().equals(argStockStatus))) {
/* 2067 */       getDAO_().setStockStatus(argStockStatus);
/* 2068 */       ev_postable = true;
/*      */     } 
/*      */     
/* 2071 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getFoodStampEligible() {
/* 2079 */     if (getDAO_().getFoodStampEligible() != null) {
/* 2080 */       return getDAO_().getFoodStampEligible().booleanValue();
/*      */     }
/* 2082 */     if (getParentOptions() != null) {
/* 2083 */       return getParentOptions().getFoodStampEligible();
/*      */     }
/*      */     
/* 2086 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFoodStampEligible(boolean argFoodStampEligible) {
/* 2095 */     if (setFoodStampEligible_noev(argFoodStampEligible) && 
/* 2096 */       this._events != null && 
/* 2097 */       postEventsForChanges()) {
/* 2098 */       this._events.post(IItemOptions.SET_FOODSTAMPELIGIBLE, Boolean.valueOf(argFoodStampEligible));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setFoodStampEligible_noev(boolean argFoodStampEligible) {
/* 2105 */     boolean ev_postable = false;
/*      */     
/* 2107 */     if ((getDAO_().getFoodStampEligible() == null && Boolean.valueOf(argFoodStampEligible) != null) || (
/* 2108 */       getDAO_().getFoodStampEligible() != null && !getDAO_().getFoodStampEligible().equals(Boolean.valueOf(argFoodStampEligible)))) {
/* 2109 */       getDAO_().setFoodStampEligible(Boolean.valueOf(argFoodStampEligible));
/* 2110 */       ev_postable = true;
/*      */     } 
/*      */     
/* 2113 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getShippingWeight() {
/* 2121 */     if (getDAO_().getShippingWeight() == null && getParentOptions() != null) {
/* 2122 */       return getParentOptions().getShippingWeight();
/*      */     }
/*      */     
/* 2125 */     return getDAO_().getShippingWeight();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setShippingWeight(BigDecimal argShippingWeight) {
/* 2134 */     if (setShippingWeight_noev(argShippingWeight) && 
/* 2135 */       this._events != null && 
/* 2136 */       postEventsForChanges()) {
/* 2137 */       this._events.post(IItemOptions.SET_SHIPPINGWEIGHT, argShippingWeight);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setShippingWeight_noev(BigDecimal argShippingWeight) {
/* 2144 */     boolean ev_postable = false;
/*      */     
/* 2146 */     if ((getDAO_().getShippingWeight() == null && argShippingWeight != null) || (
/* 2147 */       getDAO_().getShippingWeight() != null && !getDAO_().getShippingWeight().equals(argShippingWeight))) {
/* 2148 */       getDAO_().setShippingWeight(argShippingWeight);
/* 2149 */       ev_postable = true;
/*      */     } 
/*      */     
/* 2152 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getPackSize() {
/* 2160 */     if (getDAO_().getPackSize() == null && getParentOptions() != null) {
/* 2161 */       return getParentOptions().getPackSize();
/*      */     }
/*      */     
/* 2164 */     return getDAO_().getPackSize();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPackSize(BigDecimal argPackSize) {
/* 2173 */     if (setPackSize_noev(argPackSize) && 
/* 2174 */       this._events != null && 
/* 2175 */       postEventsForChanges()) {
/* 2176 */       this._events.post(IItemOptions.SET_PACKSIZE, argPackSize);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setPackSize_noev(BigDecimal argPackSize) {
/* 2183 */     boolean ev_postable = false;
/*      */     
/* 2185 */     if ((getDAO_().getPackSize() == null && argPackSize != null) || (
/* 2186 */       getDAO_().getPackSize() != null && !getDAO_().getPackSize().equals(argPackSize))) {
/* 2187 */       getDAO_().setPackSize(argPackSize);
/* 2188 */       ev_postable = true;
/*      */     } 
/*      */     
/* 2191 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDefaultSourceType() {
/* 2199 */     if (getDAO_().getDefaultSourceType() == null && getParentOptions() != null) {
/* 2200 */       return getParentOptions().getDefaultSourceType();
/*      */     }
/*      */     
/* 2203 */     return getDAO_().getDefaultSourceType();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDefaultSourceType(String argDefaultSourceType) {
/* 2212 */     if (setDefaultSourceType_noev(argDefaultSourceType) && 
/* 2213 */       this._events != null && 
/* 2214 */       postEventsForChanges()) {
/* 2215 */       this._events.post(IItemOptions.SET_DEFAULTSOURCETYPE, argDefaultSourceType);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDefaultSourceType_noev(String argDefaultSourceType) {
/* 2222 */     boolean ev_postable = false;
/*      */     
/* 2224 */     if ((getDAO_().getDefaultSourceType() == null && argDefaultSourceType != null) || (
/* 2225 */       getDAO_().getDefaultSourceType() != null && !getDAO_().getDefaultSourceType().equals(argDefaultSourceType))) {
/* 2226 */       getDAO_().setDefaultSourceType(argDefaultSourceType);
/* 2227 */       ev_postable = true;
/*      */     } 
/*      */     
/* 2230 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDefaultSourceId() {
/* 2238 */     if (getDAO_().getDefaultSourceId() == null && getParentOptions() != null) {
/* 2239 */       return getParentOptions().getDefaultSourceId();
/*      */     }
/*      */     
/* 2242 */     return getDAO_().getDefaultSourceId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDefaultSourceId(String argDefaultSourceId) {
/* 2251 */     if (setDefaultSourceId_noev(argDefaultSourceId) && 
/* 2252 */       this._events != null && 
/* 2253 */       postEventsForChanges()) {
/* 2254 */       this._events.post(IItemOptions.SET_DEFAULTSOURCEID, argDefaultSourceId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDefaultSourceId_noev(String argDefaultSourceId) {
/* 2261 */     boolean ev_postable = false;
/*      */     
/* 2263 */     if ((getDAO_().getDefaultSourceId() == null && argDefaultSourceId != null) || (
/* 2264 */       getDAO_().getDefaultSourceId() != null && !getDAO_().getDefaultSourceId().equals(argDefaultSourceId))) {
/* 2265 */       getDAO_().setDefaultSourceId(argDefaultSourceId);
/* 2266 */       ev_postable = true;
/*      */     } 
/*      */     
/* 2269 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSellingGroupId() {
/* 2277 */     if (getDAO_().getSellingGroupId() == null && getParentOptions() != null) {
/* 2278 */       return getParentOptions().getSellingGroupId();
/*      */     }
/*      */     
/* 2281 */     return getDAO_().getSellingGroupId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSellingGroupId(String argSellingGroupId) {
/* 2290 */     if (setSellingGroupId_noev(argSellingGroupId) && 
/* 2291 */       this._events != null && 
/* 2292 */       postEventsForChanges()) {
/* 2293 */       this._events.post(IItemOptions.SET_SELLINGGROUPID, argSellingGroupId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setSellingGroupId_noev(String argSellingGroupId) {
/* 2300 */     boolean ev_postable = false;
/*      */     
/* 2302 */     if ((getDAO_().getSellingGroupId() == null && argSellingGroupId != null) || (
/* 2303 */       getDAO_().getSellingGroupId() != null && !getDAO_().getSellingGroupId().equals(argSellingGroupId))) {
/* 2304 */       getDAO_().setSellingGroupId(argSellingGroupId);
/* 2305 */       ev_postable = true;
/*      */     } 
/*      */     
/* 2308 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getExcludeFromNetSales() {
/* 2316 */     if (getDAO_().getExcludeFromNetSales() != null) {
/* 2317 */       return getDAO_().getExcludeFromNetSales().booleanValue();
/*      */     }
/* 2319 */     if (getParentOptions() != null) {
/* 2320 */       return getParentOptions().getExcludeFromNetSales();
/*      */     }
/*      */     
/* 2323 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExcludeFromNetSales(boolean argExcludeFromNetSales) {
/* 2332 */     if (setExcludeFromNetSales_noev(argExcludeFromNetSales) && 
/* 2333 */       this._events != null && 
/* 2334 */       postEventsForChanges()) {
/* 2335 */       this._events.post(IItemOptions.SET_EXCLUDEFROMNETSALES, Boolean.valueOf(argExcludeFromNetSales));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setExcludeFromNetSales_noev(boolean argExcludeFromNetSales) {
/* 2342 */     boolean ev_postable = false;
/*      */     
/* 2344 */     if ((getDAO_().getExcludeFromNetSales() == null && Boolean.valueOf(argExcludeFromNetSales) != null) || (
/* 2345 */       getDAO_().getExcludeFromNetSales() != null && !getDAO_().getExcludeFromNetSales().equals(Boolean.valueOf(argExcludeFromNetSales)))) {
/* 2346 */       getDAO_().setExcludeFromNetSales(Boolean.valueOf(argExcludeFromNetSales));
/* 2347 */       ev_postable = true;
/*      */     } 
/*      */     
/* 2350 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getFiscalItemId() {
/* 2358 */     if (getDAO_().getFiscalItemId() == null && getParentOptions() != null) {
/* 2359 */       return getParentOptions().getFiscalItemId();
/*      */     }
/*      */     
/* 2362 */     return getDAO_().getFiscalItemId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFiscalItemId(String argFiscalItemId) {
/* 2371 */     if (setFiscalItemId_noev(argFiscalItemId) && 
/* 2372 */       this._events != null && 
/* 2373 */       postEventsForChanges()) {
/* 2374 */       this._events.post(IItemOptions.SET_FISCALITEMID, argFiscalItemId);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setFiscalItemId_noev(String argFiscalItemId) {
/* 2381 */     boolean ev_postable = false;
/*      */     
/* 2383 */     if ((getDAO_().getFiscalItemId() == null && argFiscalItemId != null) || (
/* 2384 */       getDAO_().getFiscalItemId() != null && !getDAO_().getFiscalItemId().equals(argFiscalItemId))) {
/* 2385 */       getDAO_().setFiscalItemId(argFiscalItemId);
/* 2386 */       ev_postable = true;
/*      */     } 
/*      */     
/* 2389 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getFiscalItemDescription() {
/* 2397 */     if (getDAO_().getFiscalItemDescription() == null && getParentOptions() != null) {
/* 2398 */       return getParentOptions().getFiscalItemDescription();
/*      */     }
/*      */     
/* 2401 */     return getDAO_().getFiscalItemDescription();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFiscalItemDescription(String argFiscalItemDescription) {
/* 2410 */     if (setFiscalItemDescription_noev(argFiscalItemDescription) && 
/* 2411 */       this._events != null && 
/* 2412 */       postEventsForChanges()) {
/* 2413 */       this._events.post(IItemOptions.SET_FISCALITEMDESCRIPTION, argFiscalItemDescription);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setFiscalItemDescription_noev(String argFiscalItemDescription) {
/* 2420 */     boolean ev_postable = false;
/*      */     
/* 2422 */     if ((getDAO_().getFiscalItemDescription() == null && argFiscalItemDescription != null) || (
/* 2423 */       getDAO_().getFiscalItemDescription() != null && !getDAO_().getFiscalItemDescription().equals(argFiscalItemDescription))) {
/* 2424 */       getDAO_().setFiscalItemDescription(argFiscalItemDescription);
/* 2425 */       ev_postable = true;
/*      */     } 
/*      */     
/* 2428 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getExternalSystem() {
/* 2436 */     if (getDAO_().getExternalSystem() == null && getParentOptions() != null) {
/* 2437 */       return getParentOptions().getExternalSystem();
/*      */     }
/*      */     
/* 2440 */     return getDAO_().getExternalSystem();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setExternalSystem(String argExternalSystem) {
/* 2449 */     if (setExternalSystem_noev(argExternalSystem) && 
/* 2450 */       this._events != null && 
/* 2451 */       postEventsForChanges()) {
/* 2452 */       this._events.post(IItemOptions.SET_EXTERNALSYSTEM, argExternalSystem);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setExternalSystem_noev(String argExternalSystem) {
/* 2459 */     boolean ev_postable = false;
/*      */     
/* 2461 */     if ((getDAO_().getExternalSystem() == null && argExternalSystem != null) || (
/* 2462 */       getDAO_().getExternalSystem() != null && !getDAO_().getExternalSystem().equals(argExternalSystem))) {
/* 2463 */       getDAO_().setExternalSystem(argExternalSystem);
/* 2464 */       ev_postable = true;
/*      */     } 
/*      */     
/* 2467 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigDecimal getTareValue() {
/* 2475 */     if (getDAO_().getTareValue() == null && getParentOptions() != null) {
/* 2476 */       return getParentOptions().getTareValue();
/*      */     }
/*      */     
/* 2479 */     return getDAO_().getTareValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTareValue(BigDecimal argTareValue) {
/* 2488 */     if (setTareValue_noev(argTareValue) && 
/* 2489 */       this._events != null && 
/* 2490 */       postEventsForChanges()) {
/* 2491 */       this._events.post(IItemOptions.SET_TAREVALUE, argTareValue);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTareValue_noev(BigDecimal argTareValue) {
/* 2498 */     boolean ev_postable = false;
/*      */     
/* 2500 */     if ((getDAO_().getTareValue() == null && argTareValue != null) || (
/* 2501 */       getDAO_().getTareValue() != null && !getDAO_().getTareValue().equals(argTareValue))) {
/* 2502 */       getDAO_().setTareValue(argTareValue);
/* 2503 */       ev_postable = true;
/*      */     } 
/*      */     
/* 2506 */     return ev_postable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTareUnitOfMeasureCode() {
/* 2514 */     if (getDAO_().getTareUnitOfMeasureCode() == null && getParentOptions() != null) {
/* 2515 */       return getParentOptions().getTareUnitOfMeasureCode();
/*      */     }
/*      */     
/* 2518 */     return getDAO_().getTareUnitOfMeasureCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTareUnitOfMeasureCode(String argTareUnitOfMeasureCode) {
/* 2527 */     if (setTareUnitOfMeasureCode_noev(argTareUnitOfMeasureCode) && 
/* 2528 */       this._events != null && 
/* 2529 */       postEventsForChanges()) {
/* 2530 */       this._events.post(IItemOptions.SET_TAREUNITOFMEASURECODE, argTareUnitOfMeasureCode);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setTareUnitOfMeasureCode_noev(String argTareUnitOfMeasureCode) {
/* 2537 */     boolean ev_postable = false;
/*      */     
/* 2539 */     if ((getDAO_().getTareUnitOfMeasureCode() == null && argTareUnitOfMeasureCode != null) || (
/* 2540 */       getDAO_().getTareUnitOfMeasureCode() != null && !getDAO_().getTareUnitOfMeasureCode().equals(argTareUnitOfMeasureCode))) {
/* 2541 */       getDAO_().setTareUnitOfMeasureCode(argTareUnitOfMeasureCode);
/* 2542 */       ev_postable = true;
/*      */     } 
/*      */     
/* 2545 */     return ev_postable;
/*      */   }
/*      */   
/*      */   protected IItemOptionsProperty newProperty(String argPropertyName) {
/* 2549 */     ItemOptionsPropertyId id = new ItemOptionsPropertyId();
/*      */     
/* 2551 */     id.setItemId(getItemId());
/* 2552 */     id.setLevelCode(getLevelCode());
/* 2553 */     id.setLevelValue(getLevelValue());
/* 2554 */     id.setPropertyCode(argPropertyName);
/*      */     
/* 2556 */     IItemOptionsProperty prop = (IItemOptionsProperty)DataFactory.getInstance().createNewObject((IObjectId)id, IItemOptionsProperty.class);
/* 2557 */     return prop;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Relationship(name = "ItemVendor")
/*      */   public IVendor getItemVendor() {
/* 2569 */     return this._itemVendor;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setItemVendor(IVendor argItemVendor) {
/* 2574 */     if (argItemVendor == null) {
/*      */       
/* 2576 */       getDAO_().setVendorId(null);
/* 2577 */       if (this._itemVendor != null)
/*      */       {
/* 2579 */         if (postEventsForChanges()) {
/* 2580 */           this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(this._itemVendor));
/*      */         }
/*      */       }
/*      */     } else {
/*      */       
/* 2585 */       getDAO_().setVendorId(argItemVendor.getVendorId());
/*      */       
/* 2587 */       if (postEventsForChanges()) {
/* 2588 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemVendor));
/*      */       }
/*      */     } 
/*      */     
/* 2592 */     this._itemVendor = argItemVendor;
/* 2593 */     if (postEventsForChanges()) {
/* 2594 */       this._events.post(IItemOptions.SET_ITEMVENDOR, argItemVendor);
/*      */     }
/*      */   }
/*      */   
/*      */   @Relationship(name = "Properties")
/*      */   public List<IItemOptionsProperty> getProperties() {
/* 2600 */     if (this._properties == null) {
/* 2601 */       this._properties = new HistoricalList(null);
/*      */     }
/* 2603 */     return (List<IItemOptionsProperty>)this._properties;
/*      */   }
/*      */   
/*      */   public void setProperties(List<IItemOptionsProperty> argProperties) {
/* 2607 */     if (this._properties == null) {
/* 2608 */       this._properties = new HistoricalList(argProperties);
/*      */     } else {
/* 2610 */       this._properties.setCurrentList(argProperties);
/*      */     } 
/*      */     
/* 2613 */     for (IItemOptionsProperty child : this._properties) {
/* 2614 */       ItemOptionsPropertyModel model = (ItemOptionsPropertyModel)child;
/* 2615 */       model.setOrganizationId_noev(getOrganizationId());
/* 2616 */       model.setItemId_noev(getItemId());
/* 2617 */       model.setLevelCode_noev(getLevelCode());
/* 2618 */       model.setLevelValue_noev(getLevelValue());
/* 2619 */       if (child instanceof IDataModelImpl) {
/* 2620 */         IDataAccessObject childDao = ((IDataModelImpl)child).getDAO();
/* 2621 */         if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 2622 */           !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 2623 */           childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */         }
/*      */       } 
/* 2626 */       if (postEventsForChanges()) {
/* 2627 */         this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)child);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addItemOptionsProperty(IItemOptionsProperty argItemOptionsProperty) {
/* 2633 */     if (this._properties == null) {
/* 2634 */       this._properties = new HistoricalList(null);
/*      */     }
/* 2636 */     argItemOptionsProperty.setOrganizationId(getOrganizationId());
/* 2637 */     argItemOptionsProperty.setItemId(getItemId());
/* 2638 */     argItemOptionsProperty.setLevelCode(getLevelCode());
/* 2639 */     argItemOptionsProperty.setLevelValue(getLevelValue());
/* 2640 */     if (argItemOptionsProperty instanceof IDataModelImpl) {
/* 2641 */       IDataAccessObject childDao = ((IDataModelImpl)argItemOptionsProperty).getDAO();
/* 2642 */       if (StringUtils.isEmpty(childDao.getOriginDataSource()) && 
/* 2643 */         !StringUtils.isEmpty(getDAO().getOriginDataSource())) {
/* 2644 */         childDao.setOriginDataSource(getDAO().getOriginDataSource());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 2649 */     if (postEventsForChanges()) {
/* 2650 */       this._eventManager.registerEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemOptionsProperty));
/*      */     }
/*      */     
/* 2653 */     this._properties.add(argItemOptionsProperty);
/* 2654 */     if (postEventsForChanges()) {
/* 2655 */       this._events.post(IItemOptions.ADD_PROPERTIES, argItemOptionsProperty);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeItemOptionsProperty(IItemOptionsProperty argItemOptionsProperty) {
/* 2660 */     if (this._properties != null) {
/*      */       
/* 2662 */       if (postEventsForChanges()) {
/* 2663 */         this._eventManager.deregisterEventHandler((IEventAware)this._eventCascade, (IEventSource)new EventDescriptor(argItemOptionsProperty));
/*      */       }
/* 2665 */       this._properties.remove(argItemOptionsProperty);
/* 2666 */       if (postEventsForChanges()) {
/* 2667 */         this._events.post(IItemOptions.REMOVE_PROPERTIES, argItemOptionsProperty);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setItem(IItem argItem) {
/* 2673 */     this._item = argItem;
/*      */   }
/*      */   
/*      */   public IItem getItem() {
/* 2677 */     return this._item;
/*      */   }
/*      */ 
/*      */   
/*      */   public Object getValue(String argFieldId) {
/* 2682 */     if ("ItemVendor".equals(argFieldId)) {
/* 2683 */       return getItemVendor();
/*      */     }
/* 2685 */     if ("Properties".equals(argFieldId)) {
/* 2686 */       return getProperties();
/*      */     }
/* 2688 */     if ("ItemOptionsExtension".equals(argFieldId)) {
/* 2689 */       return this._myExtension;
/*      */     }
/*      */     
/* 2692 */     return super.getValue(argFieldId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setValue(String argFieldId, Object argValue) {
/* 2698 */     if ("ItemVendor".equals(argFieldId)) {
/* 2699 */       setItemVendor((IVendor)argValue);
/*      */     }
/* 2701 */     else if ("Properties".equals(argFieldId)) {
/* 2702 */       setProperties(changeToList(argValue, IItemOptionsProperty.class));
/*      */     }
/* 2704 */     else if ("ItemOptionsExtension".equals(argFieldId)) {
/* 2705 */       this._myExtension = (IDataModel)argValue;
/*      */     } else {
/*      */       
/* 2708 */       super.setValue(argFieldId, argValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDependencies(IPersistenceDefaults argPD, EventManager argEM) {
/* 2714 */     this._persistenceDefaults = argPD;
/* 2715 */     this._daoImpl.setPersistenceDefaults(argPD);
/* 2716 */     this._eventManager = argEM;
/* 2717 */     this._events = (Eventor)new ModelEventor((IDataModel)this, argEM);
/* 2718 */     this._eventCascade = (EventHandler)new CascadingHandler(this);
/* 2719 */     if (this._itemVendor != null) {
/* 2720 */       ((IDataModelImpl)this._itemVendor).setDependencies(argPD, argEM);
/*      */     }
/* 2722 */     if (this._properties != null) {
/* 2723 */       for (IItemOptionsProperty relationship : this._properties) {
/* 2724 */         ((IDataModelImpl)relationship).setDependencies(argPD, argEM);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IDataModel getItemOptionsExt() {
/* 2730 */     return this._myExtension;
/*      */   }
/*      */   
/*      */   public void setItemOptionsExt(IDataModel argExt) {
/* 2734 */     this._myExtension = argExt;
/*      */   }
/*      */ 
/*      */   
/*      */   public void startTransaction() {
/* 2739 */     if (this._alreadyInStart) {
/*      */       return;
/*      */     }
/*      */     
/* 2743 */     this._alreadyInStart = true;
/*      */ 
/*      */     
/* 2746 */     super.startTransaction();
/*      */     
/* 2748 */     this._itemVendorSavepoint = this._itemVendor;
/* 2749 */     if (this._itemVendor != null) {
/* 2750 */       this._itemVendor.startTransaction();
/*      */     }
/*      */     
/* 2753 */     this._propertiesSavepoint = this._properties;
/* 2754 */     if (this._properties != null) {
/* 2755 */       this._propertiesSavepoint = new HistoricalList((List)this._properties);
/* 2756 */       Iterator<IDataModel> it = this._properties.iterator();
/* 2757 */       while (it.hasNext()) {
/* 2758 */         ((IDataModel)it.next()).startTransaction();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 2763 */     this._alreadyInStart = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rollbackChanges() {
/* 2768 */     if (isAlreadyRolledBack()) {
/*      */       return;
/*      */     }
/* 2771 */     super.rollbackChanges();
/*      */     
/* 2773 */     this._itemVendor = this._itemVendorSavepoint;
/* 2774 */     this._itemVendorSavepoint = null;
/* 2775 */     if (this._itemVendor != null) {
/* 2776 */       this._itemVendor.rollbackChanges();
/*      */     }
/*      */     
/* 2779 */     this._properties = this._propertiesSavepoint;
/* 2780 */     this._propertiesSavepoint = null;
/* 2781 */     if (this._properties != null) {
/* 2782 */       Iterator<IDataModel> it = this._properties.iterator();
/* 2783 */       while (it.hasNext()) {
/* 2784 */         ((IDataModel)it.next()).rollbackChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void commitTransaction() {
/* 2792 */     if (this._alreadyInCommit) {
/*      */       return;
/*      */     }
/* 2795 */     this._alreadyInCommit = true;
/*      */ 
/*      */     
/* 2798 */     super.commitTransaction();
/*      */     
/* 2800 */     this._itemVendorSavepoint = this._itemVendor;
/* 2801 */     if (this._itemVendor != null) {
/* 2802 */       this._itemVendor.commitTransaction();
/*      */     }
/*      */     
/* 2805 */     this._propertiesSavepoint = this._properties;
/* 2806 */     if (this._properties != null) {
/* 2807 */       Iterator<IDataModel> it = this._properties.iterator();
/* 2808 */       while (it.hasNext()) {
/* 2809 */         ((IDataModel)it.next()).commitTransaction();
/*      */       }
/* 2811 */       this._properties = new HistoricalList((List)this._properties);
/*      */     } 
/*      */ 
/*      */     
/* 2815 */     this._alreadyInCommit = false;
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemOptionsModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */