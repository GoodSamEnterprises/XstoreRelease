/*    */ package dtv.xst.dao.dsc.impl;
/*    */ 
/*    */ import dtv.data2.access.DataFactory;
/*    */ import dtv.data2.access.IQueryKey;
/*    */ import dtv.data2.access.IQueryResultList;
/*    */ import dtv.data2.access.QueryKey;
/*    */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*    */ import dtv.xst.dao.dsc.IDiscount;
/*    */ import dtv.xst.dao.dsc.IDiscountItemExclusions;
/*    */ import dtv.xst.dao.dsc.IDiscountItemInclusions;
/*    */ import dtv.xst.dao.dsc.IDiscountModel;
/*    */ import dtv.xst.dao.dsc.IDiscountProperty;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.stream.Collectors;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class DiscountBaseModel
/*    */   extends AbstractDataModelWithPropertyImpl<IDiscountProperty>
/*    */   implements IDiscountModel, IDiscount
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 32 */   private static final IQueryKey<IDiscountItemInclusions> DISCOUNT_ITEM_INCLUSION_LIST = (IQueryKey<IDiscountItemInclusions>)new QueryKey("DISCOUNT_ITEM_INCLUSION_LIST", IDiscountItemInclusions.class);
/*    */   
/* 34 */   private static final IQueryKey<IDiscountItemExclusions> DISCOUNT_ITEM_EXCLUSION_LIST = (IQueryKey<IDiscountItemExclusions>)new QueryKey("DISCOUNT_ITEM_EXCLUSION_LIST", IDiscountItemExclusions.class);
/*    */ 
/*    */   
/*    */   private transient List<String> includedItemIdcache;
/*    */ 
/*    */   
/*    */   private transient List<String> excludedItemIdcache;
/*    */ 
/*    */   
/*    */   public List<String> getExcludedItems() {
/* 44 */     if (this.excludedItemIdcache == null) {
/*    */       
/* 46 */       Map<String, Object> params = new HashMap<>(2);
/* 47 */       params.put("argOrganizationId", Long.valueOf(getOrganizationId()));
/* 48 */       params.put("argDiscountCode", getDiscountCode());
/*    */ 
/*    */       
/* 51 */       IQueryResultList iQueryResultList = DataFactory.getObjectByQueryNoThrow(DISCOUNT_ITEM_EXCLUSION_LIST, params);
/*    */       
/* 53 */       this
/* 54 */         .excludedItemIdcache = (List<String>)iQueryResultList.stream().map(IDiscountItemExclusions::getItemId).collect(Collectors.toList());
/*    */     } 
/*    */     
/* 57 */     return this.excludedItemIdcache;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public List<String> getIncludedItems() {
/* 63 */     if (this.includedItemIdcache == null) {
/*    */       
/* 65 */       Map<String, Object> params = new HashMap<>(2);
/* 66 */       params.put("argOrganizationId", Long.valueOf(getOrganizationId()));
/* 67 */       params.put("argDiscountCode", getDiscountCode());
/*    */ 
/*    */       
/* 70 */       IQueryResultList iQueryResultList = DataFactory.getObjectByQueryNoThrow(DISCOUNT_ITEM_INCLUSION_LIST, params);
/*    */       
/* 72 */       this
/* 73 */         .includedItemIdcache = (List<String>)iQueryResultList.stream().map(IDiscountItemInclusions::getItemId).collect(Collectors.toList());
/*    */     } 
/* 75 */     return this.includedItemIdcache;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\dsc\impl\DiscountBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */