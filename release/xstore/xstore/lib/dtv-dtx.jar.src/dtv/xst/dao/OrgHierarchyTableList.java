/*    */ package dtv.xst.dao;
/*    */ 
/*    */ import dtv.data2.access.impl.daogen.IHasOrgHierarchyTables;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OrgHierarchyTableList
/*    */   implements IHasOrgHierarchyTables
/*    */ {
/*    */   private final List<String> _entries;
/*    */   
/*    */   public OrgHierarchyTableList() {
/* 16 */     this._entries = new ArrayList<>();
/*    */ 
/*    */ 
/*    */     
/* 20 */     addTable("itm_kit_component");
/* 21 */     addTable("itm_item_restrict_calendar");
/* 22 */     addTable("itm_item_restriction");
/* 23 */     addTable("itm_item_restrict_mapping");
/* 24 */     addTable("itm_item_dimension_type");
/* 25 */     addTable("itm_item_dimension_value");
/* 26 */     addTable("itm_item_msg");
/* 27 */     addTable("itm_merch_hierarchy");
/* 28 */     addTable("itm_quick_items");
/* 29 */     addTable("itm_warranty_journal");
/* 30 */     addTable("itm_item");
/* 31 */     addTable("itm_vendor");
/* 32 */     addTable("itm_item_cross_reference");
/* 33 */     addTable("itm_item_deal_prop");
/* 34 */     addTable("itm_item_msg_cross_reference");
/* 35 */     addTable("itm_item_msg_types");
/* 36 */     addTable("itm_item_prompt_properties");
/* 37 */     addTable("itm_restrict_gs1");
/* 38 */     addTable("itm_refund_schedule");
/* 39 */     addTable("itm_warranty_item_xref");
/* 40 */     addTable("itm_warranty_item_price");
/* 41 */     addTable("itm_item_images");
/* 42 */     addTable("itm_item_label_properties");
/* 43 */     addTable("itm_matrix_sort_order");
/* 44 */     addTable("cat_cust_acct_plan");
/* 45 */     addTable("prc_deal");
/* 46 */     addTable("prc_deal_cust_groups");
/* 47 */     addTable("prc_deal_document_xref");
/* 48 */     addTable("prc_deal_field_test");
/* 49 */     addTable("prc_deal_item");
/* 50 */     addTable("prc_deal_trig");
/* 51 */     addTable("prc_deal_week");
/* 52 */     addTable("com_translations");
/* 53 */     addTable("com_address");
/* 54 */     addTable("com_report_data");
/* 55 */     addTable("com_report_lookup");
/* 56 */     addTable("com_shipping_cost");
/* 57 */     addTable("com_trans_prompt_properties");
/* 58 */     addTable("com_shipping_fee");
/* 59 */     addTable("com_shipping_fee_tier");
/* 60 */     addTable("hrs_work_codes");
/* 61 */     addTable("hrs_employee_message");
/* 62 */     addTable("inv_shipper");
/* 63 */     addTable("inv_shipper_method");
/* 64 */     addTable("dsc_coupon_xref");
/* 65 */     addTable("cwo_category_service_loc");
/* 66 */     addTable("cwo_service_loc");
/* 67 */     addTable("cwo_work_order_category");
/* 68 */     addTable("cwo_price_code");
/* 69 */     addTable("cwo_work_order_pricing");
/* 70 */     addTable("tax_tax_authority");
/* 71 */     addTable("tax_tax_group");
/* 72 */     addTable("tax_tax_group_rule");
/* 73 */     addTable("tax_tax_loc");
/* 74 */     addTable("tax_tax_rate_rule");
/* 75 */     addTable("tax_tax_bracket");
/* 76 */     addTable("tax_tax_rate_rule_override");
/* 77 */     addTable("doc_document");
/* 78 */     addTable("doc_document_definition");
/* 79 */     addTable("doc_document_def_properties");
/* 80 */     addTable("sch_shift");
/* 81 */     addTable("sls_sales_goal");
/*    */   }
/*    */   
/*    */   protected void addTable(String argTable) {
/* 85 */     this._entries.add(argTable);
/*    */   }
/*    */ 
/*    */   
/*    */   public List<String> getOrgHierarchyTables() {
/* 90 */     return this._entries;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\OrgHierarchyTableList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */