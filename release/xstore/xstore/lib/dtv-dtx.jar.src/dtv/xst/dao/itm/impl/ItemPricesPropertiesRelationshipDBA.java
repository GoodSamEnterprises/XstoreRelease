/*    */ package dtv.xst.dao.itm.impl;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.exception.DtxException;
/*    */ import dtv.data2.access.impl.jdbc.IJDBCRelationshipAdapter;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemPricesPropertiesRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(7);
/*    */   
/*    */   public String getSelect() {
/* 22 */     return "SELECT organization_id, item_id, level_code, level_value, itm_price_property_code, effective_date, price_qty, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id FROM itm_item_prices_p WHERE organization_id = ? AND item_id = ? AND level_code = ? AND level_value = ? AND itm_price_property_code = ? AND effective_date = ? AND price_qty = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 27 */     ItemPricesDAO dao = (ItemPricesDAO)argDAO;
/* 28 */     this._parameterList.add(dao.getOrganizationId());
/* 29 */     this._parameterList.add(dao.getItemId());
/* 30 */     this._parameterList.add(dao.getLevelCode());
/* 31 */     this._parameterList.add(dao.getLevelValue());
/* 32 */     this._parameterList.add(dao.getItemPricePropertyCode());
/* 33 */     this._parameterList.add(dao.getEffectiveDate());
/* 34 */     this._parameterList.add(dao.getPricingQuantity());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isOrgHierarchyJoinRequired() {
/* 39 */     return false;
/*    */   }
/*    */   
/*    */   public List getParameterList() {
/* 43 */     return this._parameterList;
/*    */   }
/*    */   
/*    */   public IObjectId getChildObjectId() {
/* 47 */     throw new DtxException("getChildObjectId() can only be called on ONE-ONE relationships. This is an invalid call for relationship adapter: " + getClass().getName());
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemPricesPropertiesRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */