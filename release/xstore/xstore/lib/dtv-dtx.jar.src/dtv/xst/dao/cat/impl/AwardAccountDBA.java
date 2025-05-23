/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.AwardAccountId;
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
/*     */ public class AwardAccountDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1907951920L;
/*     */   private Long _organizationId;
/*     */   private String _cardNumber;
/*     */   private String _accountId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.cust_card_nbr, t.acct_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM cat_award_acct t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND cust_card_nbr = ?  AND acct_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  36 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  40 */     return "SELECT t.organization_id, t.cust_card_nbr, t.acct_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM cat_award_acct t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  46 */     return " WHERE organization_id = ?  AND cust_card_nbr = ?  AND acct_id = ?  ";
/*     */   }
/*     */   
/*  49 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO cat_award_acct(organization_id, cust_card_nbr, acct_id, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  52 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  56 */     Object[][] insertParameterObject = { { this._organizationId, this._cardNumber, this._accountId, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  57 */     return insertParameterObject;
/*     */   }
/*     */   
/*  60 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  63 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  66 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE cat_award_acct SET update_date = ?, update_user_id = ?" };
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
/*  82 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM cat_award_acct" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND cust_card_nbr = ?  AND acct_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  85 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  91 */     return " WHERE organization_id = ?  AND cust_card_nbr = ?  AND acct_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  94 */     return new Object[] { this._organizationId, this._cardNumber, this._accountId };
/*     */   }
/*     */   
/*  97 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 100 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 103 */     return "cat_award_acct";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 107 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 111 */     return new AwardAccountFiller(this);
/*     */   }
/*     */   
/*     */   private static class AwardAccountFiller
/*     */     implements IFiller {
/*     */     private AwardAccountDBA _parent;
/*     */     
/*     */     public AwardAccountFiller(AwardAccountDBA argParent) {
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
/* 130 */       this._parent._cardNumber = argResultSet.getString(2);
/* 131 */       this._parent._accountId = argResultSet.getString(3);
/*     */       
/* 133 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 134 */       if (t4 != null) {
/* 135 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 138 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 141 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 143 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 144 */       if (t6 != null) {
/* 145 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 148 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 151 */       this._parent._updateUserId = argResultSet.getString(7);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 156 */     argDAO.suppressStateChanges(true);
/* 157 */     AwardAccountDAO dao = (AwardAccountDAO)argDAO;
/* 158 */     dao.setOrganizationId(this._organizationId);
/* 159 */     dao.setCardNumber(this._cardNumber);
/* 160 */     dao.setAccountId(this._accountId);
/* 161 */     dao.setCreateDate(this._createDate);
/* 162 */     dao.setCreateUserId(this._createUserId);
/* 163 */     dao.setUpdateDate(this._updateDate);
/* 164 */     dao.setUpdateUserId(this._updateUserId);
/* 165 */     argDAO.suppressStateChanges(false);
/* 166 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 170 */     return loadDAO((IDataAccessObject)new AwardAccountDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 174 */     AwardAccountDAO dao = (AwardAccountDAO)argDAO;
/* 175 */     this._organizationId = dao.getOrganizationId();
/* 176 */     this._cardNumber = dao.getCardNumber();
/* 177 */     this._accountId = dao.getAccountId();
/* 178 */     this._createDate = dao.getCreateDate();
/* 179 */     this._createUserId = dao.getCreateUserId();
/* 180 */     this._updateDate = dao.getUpdateDate();
/* 181 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 185 */     AwardAccountId id = (AwardAccountId)argId;
/* 186 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 187 */     argStatement.setString(2, id.getCardNumber());
/* 188 */     argStatement.setString(3, id.getAccountId());
/* 189 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 193 */     AwardAccountId id = new AwardAccountId();
/* 194 */     id.setOrganizationId(this._organizationId);
/* 195 */     id.setCardNumber(this._cardNumber);
/* 196 */     id.setAccountId(this._accountId);
/* 197 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 205 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 209 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\AwardAccountDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */