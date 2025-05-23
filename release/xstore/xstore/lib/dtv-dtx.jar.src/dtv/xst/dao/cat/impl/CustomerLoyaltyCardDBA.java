/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.CustomerLoyaltyCardId;
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
/*     */ public class CustomerLoyaltyCardDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1934498200L;
/*     */   private Long _organizationId;
/*     */   private String _cardNumber;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Long _partyId;
/*     */   private Date _effectiveDate;
/*     */   private Date _expirationDate;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.cust_acct_card_nbr, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.party_id, t.effective_date, t.expr_date FROM cat_cust_acct_card t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_card_nbr = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  38 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  42 */     return "SELECT t.organization_id, t.cust_acct_card_nbr, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.party_id, t.effective_date, t.expr_date FROM cat_cust_acct_card t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  48 */     return " WHERE organization_id = ?  AND cust_acct_card_nbr = ?  ";
/*     */   }
/*     */   
/*  51 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO cat_cust_acct_card(organization_id, cust_acct_card_nbr, create_date, create_user_id, update_date, update_user_id, party_id, effective_date, expr_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  54 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  58 */     Object[][] insertParameterObject = { { this._organizationId, this._cardNumber, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._partyId, this._effectiveDate, this._expirationDate } };
/*  59 */     return insertParameterObject;
/*     */   }
/*     */   
/*  62 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 91, 12, 91, 12, -5, 91, 91 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  65 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  68 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE cat_cust_acct_card SET update_date = ?, update_user_id = ?, party_id = ?, effective_date = ?, expr_date = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  71 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  75 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._partyId, this._effectiveDate, this._expirationDate } };
/*  76 */     return updateParameterObject;
/*     */   }
/*     */   
/*  79 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, -5, 91, 91 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  81 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  84 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM cat_cust_acct_card" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_card_nbr = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  87 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  93 */     return " WHERE organization_id = ?  AND cust_acct_card_nbr = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  96 */     return new Object[] { this._organizationId, this._cardNumber };
/*     */   }
/*     */   
/*  99 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 102 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 105 */     return "cat_cust_acct_card";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 109 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 113 */     return new CustomerLoyaltyCardFiller(this);
/*     */   }
/*     */   
/*     */   private static class CustomerLoyaltyCardFiller
/*     */     implements IFiller {
/*     */     private CustomerLoyaltyCardDBA _parent;
/*     */     
/*     */     public CustomerLoyaltyCardFiller(CustomerLoyaltyCardDBA argParent) {
/* 121 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 126 */       long primitiveResult = argResultSet.getLong(1);
/* 127 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 128 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 132 */       this._parent._cardNumber = argResultSet.getString(2);
/*     */       
/* 134 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 135 */       if (t3 != null) {
/* 136 */         this._parent._createDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 139 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 142 */       this._parent._createUserId = argResultSet.getString(4);
/*     */       
/* 144 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 145 */       if (t5 != null) {
/* 146 */         this._parent._updateDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 149 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 152 */       this._parent._updateUserId = argResultSet.getString(6);
/*     */ 
/*     */       
/* 155 */       long l1 = argResultSet.getLong(7);
/* 156 */       if (l1 != 0L || argResultSet.getObject(7) != null) {
/* 157 */         this._parent._partyId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 162 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 163 */       if (t8 != null) {
/* 164 */         this._parent._effectiveDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 167 */         this._parent._effectiveDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 171 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 172 */       if (t9 != null) {
/* 173 */         this._parent._expirationDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 176 */         this._parent._expirationDate = null;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 183 */     argDAO.suppressStateChanges(true);
/* 184 */     CustomerLoyaltyCardDAO dao = (CustomerLoyaltyCardDAO)argDAO;
/* 185 */     dao.setOrganizationId(this._organizationId);
/* 186 */     dao.setCardNumber(this._cardNumber);
/* 187 */     dao.setCreateDate(this._createDate);
/* 188 */     dao.setCreateUserId(this._createUserId);
/* 189 */     dao.setUpdateDate(this._updateDate);
/* 190 */     dao.setUpdateUserId(this._updateUserId);
/* 191 */     dao.setPartyId(this._partyId);
/* 192 */     dao.setEffectiveDate(this._effectiveDate);
/* 193 */     dao.setExpirationDate(this._expirationDate);
/* 194 */     argDAO.suppressStateChanges(false);
/* 195 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 199 */     return loadDAO((IDataAccessObject)new CustomerLoyaltyCardDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 203 */     CustomerLoyaltyCardDAO dao = (CustomerLoyaltyCardDAO)argDAO;
/* 204 */     this._organizationId = dao.getOrganizationId();
/* 205 */     this._cardNumber = dao.getCardNumber();
/* 206 */     this._createDate = dao.getCreateDate();
/* 207 */     this._createUserId = dao.getCreateUserId();
/* 208 */     this._updateDate = dao.getUpdateDate();
/* 209 */     this._updateUserId = dao.getUpdateUserId();
/* 210 */     this._partyId = dao.getPartyId();
/* 211 */     this._effectiveDate = dao.getEffectiveDate();
/* 212 */     this._expirationDate = dao.getExpirationDate();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 216 */     CustomerLoyaltyCardId id = (CustomerLoyaltyCardId)argId;
/* 217 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 218 */     argStatement.setString(2, id.getCardNumber());
/* 219 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 223 */     CustomerLoyaltyCardId id = new CustomerLoyaltyCardId();
/* 224 */     id.setOrganizationId(this._organizationId);
/* 225 */     id.setCardNumber(this._cardNumber);
/* 226 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 234 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 238 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerLoyaltyCardDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */