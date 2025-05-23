/*     */ package dtv.xst.dao.crm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.crm.CustomerAffiliationId;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CustomerAffiliationDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1596359662L;
/*     */   private Long _organizationId;
/*     */   private Long _partyId;
/*     */   private String _customerGroupId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.party_id, t.cust_group_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM crm_customer_affiliation t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND party_id = ?  AND cust_group_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  36 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  40 */     return "SELECT t.organization_id, t.party_id, t.cust_group_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM crm_customer_affiliation t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  46 */     return " WHERE organization_id = ?  AND party_id = ?  AND cust_group_id = ?  ";
/*     */   }
/*     */   
/*  49 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO crm_customer_affiliation(organization_id, party_id, cust_group_id, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  52 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  56 */     Object[][] insertParameterObject = { { this._organizationId, this._partyId, this._customerGroupId, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  57 */     return insertParameterObject;
/*     */   }
/*     */   
/*  60 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  63 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  66 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE crm_customer_affiliation SET update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  69 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  73 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId } };
/*  74 */     return updateParameterObject;
/*     */   }
/*     */   
/*  77 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  79 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  82 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM crm_customer_affiliation" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND party_id = ?  AND cust_group_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  85 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  91 */     return " WHERE organization_id = ?  AND party_id = ?  AND cust_group_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  94 */     return new Object[] { this._organizationId, this._partyId, this._customerGroupId };
/*     */   }
/*     */   
/*  97 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 100 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 103 */     return "crm_customer_affiliation";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 107 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 111 */     return new CustomerAffiliationFiller(this);
/*     */   }
/*     */   
/*     */   private static class CustomerAffiliationFiller
/*     */     implements IFiller {
/*     */     private CustomerAffiliationDBA _parent;
/*     */     
/*     */     public CustomerAffiliationFiller(CustomerAffiliationDBA argParent) {
/* 119 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 124 */       long primitiveResult = argResultSet.getLong(1);
/* 125 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 126 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 132 */       primitiveResult = argResultSet.getLong(2);
/* 133 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 134 */         this._parent._partyId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 138 */       this._parent._customerGroupId = argResultSet.getString(3);
/*     */       
/* 140 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 141 */       if (t4 != null) {
/* 142 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 145 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 148 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 150 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 151 */       if (t6 != null) {
/* 152 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 155 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 158 */       this._parent._updateUserId = argResultSet.getString(7);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 163 */     argDAO.suppressStateChanges(true);
/* 164 */     CustomerAffiliationDAO dao = (CustomerAffiliationDAO)argDAO;
/* 165 */     dao.setOrganizationId(this._organizationId);
/* 166 */     dao.setPartyId(this._partyId);
/* 167 */     dao.setCustomerGroupId(this._customerGroupId);
/* 168 */     dao.setCreateDate(this._createDate);
/* 169 */     dao.setCreateUserId(this._createUserId);
/* 170 */     dao.setUpdateDate(this._updateDate);
/* 171 */     dao.setUpdateUserId(this._updateUserId);
/* 172 */     argDAO.suppressStateChanges(false);
/* 173 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 177 */     return loadDAO((IDataAccessObject)new CustomerAffiliationDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 181 */     CustomerAffiliationDAO dao = (CustomerAffiliationDAO)argDAO;
/* 182 */     this._organizationId = dao.getOrganizationId();
/* 183 */     this._partyId = dao.getPartyId();
/* 184 */     this._customerGroupId = dao.getCustomerGroupId();
/* 185 */     this._createDate = dao.getCreateDate();
/* 186 */     this._createUserId = dao.getCreateUserId();
/* 187 */     this._updateDate = dao.getUpdateDate();
/* 188 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 192 */     CustomerAffiliationId id = (CustomerAffiliationId)argId;
/* 193 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 194 */     argStatement.setLong(2, id.getPartyId().longValue());
/* 195 */     argStatement.setString(3, id.getCustomerGroupId());
/* 196 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 200 */     CustomerAffiliationId id = new CustomerAffiliationId();
/* 201 */     id.setOrganizationId(this._organizationId);
/* 202 */     id.setPartyId(this._partyId);
/* 203 */     id.setCustomerGroupId(this._customerGroupId);
/* 204 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 212 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 216 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\impl\CustomerAffiliationDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */