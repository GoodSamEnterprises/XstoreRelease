/*    */ package dtv.xst.dao.trn.impl;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.impl.jdbc.IJDBCRelationshipAdapter;
/*    */ import dtv.xst.dao.crm.PartyId;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PosTransactionOperatorPartyRelationshipDBA
/*    */   implements IJDBCRelationshipAdapter
/*    */ {
/* 19 */   private List<Object> _parameterList = new ArrayList(2);
/*    */   
/* 21 */   PartyId _childObjectId = null;
/*    */   
/*    */   public String getSelect() {
/* 24 */     return "SELECT organization_id, party_id, create_date, create_user_id, update_date, update_user_id, allegiance_rtl_loc_id, birth_date, cust_id, employee_id, national_tax_id, first_name, first_name2, gender, last_name, last_name2, middle_name, preferred_locale, organization_name, organization_typcode, party_typcode, picture_uri, salutation, sign_up_rtl_loc_id, social_security_nbr, personal_tax_id, suffix, void_flag, active_flag, email_rcpts_flag, anniversary_date, prospect_flag, rent_flag, privacy_card_flag, commercial_customer_flag, contact_pref FROM crm_party WHERE organization_id = ? AND party_id = ?";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setParent(IDataAccessObject argDAO) {
/* 29 */     PosTransactionDAO dao = (PosTransactionDAO)argDAO;
/* 30 */     this._childObjectId = new PartyId();
/* 31 */     this._parameterList.add(dao.getOrganizationId());
/* 32 */     this._childObjectId.setOrganizationId(dao.getOrganizationId());
/* 33 */     this._parameterList.add(dao.getOperatorPartyId());
/* 34 */     this._childObjectId.setPartyId(dao.getOperatorPartyId());
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
/* 47 */     return (IObjectId)this._childObjectId;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\PosTransactionOperatorPartyRelationshipDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */