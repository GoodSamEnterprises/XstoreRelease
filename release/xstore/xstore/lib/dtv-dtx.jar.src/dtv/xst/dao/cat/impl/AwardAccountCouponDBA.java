/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.AwardAccountCouponId;
/*     */ import java.math.BigDecimal;
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
/*     */ public class AwardAccountCouponDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -18798218L;
/*     */   private Long _organizationId;
/*     */   private String _cardNumber;
/*     */   private String _accountId;
/*     */   private String _couponId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _amount;
/*     */   private Date _expirationDate;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.cust_card_nbr, t.acct_id, t.coupon_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.amount, t.expiration_date FROM cat_award_acct_coupon t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND cust_card_nbr = ?  AND acct_id = ?  AND coupon_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  39 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  43 */     return "SELECT t.organization_id, t.cust_card_nbr, t.acct_id, t.coupon_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.amount, t.expiration_date FROM cat_award_acct_coupon t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  49 */     return " WHERE organization_id = ?  AND cust_card_nbr = ?  AND acct_id = ?  AND coupon_id = ?  ";
/*     */   }
/*     */   
/*  52 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO cat_award_acct_coupon(organization_id, cust_card_nbr, acct_id, coupon_id, create_date, create_user_id, update_date, update_user_id, amount, expiration_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  55 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  59 */     Object[][] insertParameterObject = { { this._organizationId, this._cardNumber, this._accountId, this._couponId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._amount, this._expirationDate } };
/*  60 */     return insertParameterObject;
/*     */   }
/*     */   
/*  63 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 12, 91, 12, 91, 12, 3, 91 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  66 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  69 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE cat_award_acct_coupon SET update_date = ?, update_user_id = ?, amount = ?, expiration_date = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  72 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  76 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._amount, this._expirationDate } };
/*  77 */     return updateParameterObject;
/*     */   }
/*     */   
/*  80 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 3, 91 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  82 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  85 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM cat_award_acct_coupon" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND cust_card_nbr = ?  AND acct_id = ?  AND coupon_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  88 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  94 */     return " WHERE organization_id = ?  AND cust_card_nbr = ?  AND acct_id = ?  AND coupon_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  97 */     return new Object[] { this._organizationId, this._cardNumber, this._accountId, this._couponId };
/*     */   }
/*     */   
/* 100 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 103 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 106 */     return "cat_award_acct_coupon";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 110 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 114 */     return new AwardAccountCouponFiller(this);
/*     */   }
/*     */   
/*     */   private static class AwardAccountCouponFiller
/*     */     implements IFiller {
/*     */     private AwardAccountCouponDBA _parent;
/*     */     
/*     */     public AwardAccountCouponFiller(AwardAccountCouponDBA argParent) {
/* 122 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 127 */       long primitiveResult = argResultSet.getLong(1);
/* 128 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 129 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 133 */       this._parent._cardNumber = argResultSet.getString(2);
/* 134 */       this._parent._accountId = argResultSet.getString(3);
/* 135 */       this._parent._couponId = argResultSet.getString(4);
/*     */       
/* 137 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 138 */       if (t5 != null) {
/* 139 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 142 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 145 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 147 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 148 */       if (t7 != null) {
/* 149 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 152 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 155 */       this._parent._updateUserId = argResultSet.getString(8);
/* 156 */       this._parent._amount = argResultSet.getBigDecimal(9);
/*     */       
/* 158 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 159 */       if (t10 != null) {
/* 160 */         this._parent._expirationDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 163 */         this._parent._expirationDate = null;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 170 */     argDAO.suppressStateChanges(true);
/* 171 */     AwardAccountCouponDAO dao = (AwardAccountCouponDAO)argDAO;
/* 172 */     dao.setOrganizationId(this._organizationId);
/* 173 */     dao.setCardNumber(this._cardNumber);
/* 174 */     dao.setAccountId(this._accountId);
/* 175 */     dao.setCouponId(this._couponId);
/* 176 */     dao.setCreateDate(this._createDate);
/* 177 */     dao.setCreateUserId(this._createUserId);
/* 178 */     dao.setUpdateDate(this._updateDate);
/* 179 */     dao.setUpdateUserId(this._updateUserId);
/* 180 */     dao.setAmount(this._amount);
/* 181 */     dao.setExpirationDate(this._expirationDate);
/* 182 */     argDAO.suppressStateChanges(false);
/* 183 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 187 */     return loadDAO((IDataAccessObject)new AwardAccountCouponDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 191 */     AwardAccountCouponDAO dao = (AwardAccountCouponDAO)argDAO;
/* 192 */     this._organizationId = dao.getOrganizationId();
/* 193 */     this._cardNumber = dao.getCardNumber();
/* 194 */     this._accountId = dao.getAccountId();
/* 195 */     this._couponId = dao.getCouponId();
/* 196 */     this._createDate = dao.getCreateDate();
/* 197 */     this._createUserId = dao.getCreateUserId();
/* 198 */     this._updateDate = dao.getUpdateDate();
/* 199 */     this._updateUserId = dao.getUpdateUserId();
/* 200 */     this._amount = dao.getAmount();
/* 201 */     this._expirationDate = dao.getExpirationDate();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 205 */     AwardAccountCouponId id = (AwardAccountCouponId)argId;
/* 206 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 207 */     argStatement.setString(2, id.getCardNumber());
/* 208 */     argStatement.setString(3, id.getAccountId());
/* 209 */     argStatement.setString(4, id.getCouponId());
/* 210 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 214 */     AwardAccountCouponId id = new AwardAccountCouponId();
/* 215 */     id.setOrganizationId(this._organizationId);
/* 216 */     id.setCardNumber(this._cardNumber);
/* 217 */     id.setAccountId(this._accountId);
/* 218 */     id.setCouponId(this._couponId);
/* 219 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 227 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 231 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\AwardAccountCouponDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */