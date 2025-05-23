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
/*    */ public class ItemItemOptionsRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(2);
/*    */   
/*    */   public String getSelect() {
/* 22 */     return "SELECT organization_id, item_id, level_code, level_value, create_date, create_user_id, update_date, update_user_id, apply_restocking_fee_flag, attached_items_flag, compare_at_price, disallow_discounts_flag, disallow_deals_flag, disallow_price_change_flag, disallow_send_sale_flag, disallow_commission_flag, disallow_layaway_flag, disallow_work_order_flag, disallow_special_order_flag, disallow_order_flag, disallow_rain_check, force_quantity_of_one_flag, max_sale_unit_count, min_sale_unit_count, no_giveaways_flag, not_returnable_flag, part_number, prompt_for_price_flag, prompt_for_quantity_flag, prompt_for_description_flag, prompt_for_customer, restocking_fee, season_code, substitute_available_flag, unit_cost, vendor, special_order_lead_days, qty_scale, messages_flag, unit_of_measure_code, tax_group_id, warranty_flag, generic_item_flag, curr_sale_price, initial_sale_qty, disposition_code, item_availability_code, min_age_required, stock_status, foodstamp_eligible_flag, shipping_weight, pack_size, default_source_type, default_source_id, selling_group_id, exclude_from_net_sales_flag, fiscal_item_id, fiscal_item_description, external_system, tare_value, tare_unit_of_measure_code FROM itm_item_options WHERE item_id = ? AND organization_id = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 27 */     ItemDAO dao = (ItemDAO)argDAO;
/* 28 */     this._parameterList.add(dao.getItemId());
/* 29 */     this._parameterList.add(dao.getOrganizationId());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isOrgHierarchyJoinRequired() {
/* 34 */     return false;
/*    */   }
/*    */   
/*    */   public List getParameterList() {
/* 38 */     return this._parameterList;
/*    */   }
/*    */   
/*    */   public IObjectId getChildObjectId() {
/* 42 */     throw new DtxException("getChildObjectId() can only be called on ONE-ONE relationships. This is an invalid call for relationship adapter: " + getClass().getName());
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemItemOptionsRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */