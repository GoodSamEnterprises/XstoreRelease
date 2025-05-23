/*    */ package dtv.xst.dao;
/*    */ 
/*    */ import dtv.data2.access.impl.daogen.IHasConfigElementTables;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ConfigElementTableList
/*    */   implements IHasConfigElementTables
/*    */ {
/*    */   private final List<String> _entries;
/*    */   
/*    */   public ConfigElementTableList() {
/* 16 */     this._entries = new ArrayList<>();
/*    */ 
/*    */ 
/*    */     
/* 20 */     addTable("tnd_tndr_options");
/* 21 */     addTable("tnd_tndr_user_settings");
/* 22 */     addTable("com_code_value");
/* 23 */     addTable("com_reason_code");
/* 24 */     addTable("com_receipt_text");
/* 25 */     addTable("sec_groups");
/* 26 */     addTable("sec_privilege");
/* 27 */     addTable("dsc_discount");
/* 28 */     addTable("dsc_discount_group_mapping");
/* 29 */     addTable("dsc_disc_type_eligibility");
/* 30 */     addTable("tnd_tndr_options_p");
/* 31 */     addTable("tnd_tndr_user_settings_p");
/* 32 */     addTable("com_receipt_text_p");
/*    */   }
/*    */   
/*    */   protected void addTable(String argTable) {
/* 36 */     this._entries.add(argTable);
/*    */   }
/*    */ 
/*    */   
/*    */   public List<String> getConfigElementTables() {
/* 41 */     return this._entries;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ConfigElementTableList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */