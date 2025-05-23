/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.AwardAccountCouponPropertyId;
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
/*     */ public class AwardAccountCouponPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1545890453L;
/*     */   private Long _organizationId;
/*     */   private String _cardNumber;
/*     */   private String _accountId;
/*     */   private String _couponId;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.cust_card_nbr, t.acct_id, t.coupon_id, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM cat_award_acct_coupon_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND cust_card_nbr = ?  AND acct_id = ?  AND coupon_id = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  42 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  46 */     return "SELECT t.organization_id, t.cust_card_nbr, t.acct_id, t.coupon_id, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM cat_award_acct_coupon_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  52 */     return " WHERE organization_id = ?  AND cust_card_nbr = ?  AND acct_id = ?  AND coupon_id = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  55 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO cat_award_acct_coupon_p(organization_id, cust_card_nbr, acct_id, coupon_id, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  58 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  62 */     Object[][] insertParameterObject = { { this._organizationId, this._cardNumber, this._accountId, this._couponId, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  63 */     return insertParameterObject;
/*     */   }
/*     */   
/*  66 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 12, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  69 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  72 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE cat_award_acct_coupon_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  75 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  79 */     Object[][] updateParameterObject = { { this._type, this._stringValue, this._dateValue, this._decimalValue, this._updateDate, this._updateUserId } };
/*  80 */     return updateParameterObject;
/*     */   }
/*     */   
/*  83 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 3, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  85 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  88 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM cat_award_acct_coupon_p" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND cust_card_nbr = ?  AND acct_id = ?  AND coupon_id = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  91 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  97 */     return " WHERE organization_id = ?  AND cust_card_nbr = ?  AND acct_id = ?  AND coupon_id = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 100 */     return new Object[] { this._organizationId, this._cardNumber, this._accountId, this._couponId, this._propertyCode };
/*     */   }
/*     */   
/* 103 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 106 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 109 */     return "cat_award_acct_coupon_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 113 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 117 */     return new AwardAccountCouponPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class AwardAccountCouponPropertyFiller
/*     */     implements IFiller {
/*     */     private AwardAccountCouponPropertyDBA _parent;
/*     */     
/*     */     public AwardAccountCouponPropertyFiller(AwardAccountCouponPropertyDBA argParent) {
/* 125 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 130 */       long primitiveResult = argResultSet.getLong(1);
/* 131 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 132 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 136 */       this._parent._cardNumber = argResultSet.getString(2);
/* 137 */       this._parent._accountId = argResultSet.getString(3);
/* 138 */       this._parent._couponId = argResultSet.getString(4);
/* 139 */       this._parent._propertyCode = argResultSet.getString(5);
/* 140 */       this._parent._type = argResultSet.getString(6);
/* 141 */       this._parent._stringValue = argResultSet.getString(7);
/*     */       
/* 143 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 144 */       if (t8 != null) {
/* 145 */         this._parent._dateValue = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 148 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 151 */       this._parent._decimalValue = argResultSet.getBigDecimal(9);
/*     */       
/* 153 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 154 */       if (t10 != null) {
/* 155 */         this._parent._createDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 158 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 161 */       this._parent._createUserId = argResultSet.getString(11);
/*     */       
/* 163 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 164 */       if (t12 != null) {
/* 165 */         this._parent._updateDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 168 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 171 */       this._parent._updateUserId = argResultSet.getString(13);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 176 */     argDAO.suppressStateChanges(true);
/* 177 */     AwardAccountCouponPropertyDAO dao = (AwardAccountCouponPropertyDAO)argDAO;
/* 178 */     dao.setOrganizationId(this._organizationId);
/* 179 */     dao.setCardNumber(this._cardNumber);
/* 180 */     dao.setAccountId(this._accountId);
/* 181 */     dao.setCouponId(this._couponId);
/* 182 */     dao.setPropertyCode(this._propertyCode);
/* 183 */     dao.setType(this._type);
/* 184 */     dao.setStringValue(this._stringValue);
/* 185 */     dao.setDateValue(this._dateValue);
/* 186 */     dao.setDecimalValue(this._decimalValue);
/* 187 */     dao.setCreateDate(this._createDate);
/* 188 */     dao.setCreateUserId(this._createUserId);
/* 189 */     dao.setUpdateDate(this._updateDate);
/* 190 */     dao.setUpdateUserId(this._updateUserId);
/* 191 */     argDAO.suppressStateChanges(false);
/* 192 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 196 */     return loadDAO((IDataAccessObject)new AwardAccountCouponPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 200 */     AwardAccountCouponPropertyDAO dao = (AwardAccountCouponPropertyDAO)argDAO;
/* 201 */     this._organizationId = dao.getOrganizationId();
/* 202 */     this._cardNumber = dao.getCardNumber();
/* 203 */     this._accountId = dao.getAccountId();
/* 204 */     this._couponId = dao.getCouponId();
/* 205 */     this._propertyCode = dao.getPropertyCode();
/* 206 */     this._type = dao.getType();
/* 207 */     this._stringValue = dao.getStringValue();
/* 208 */     this._dateValue = dao.getDateValue();
/* 209 */     this._decimalValue = dao.getDecimalValue();
/* 210 */     this._createDate = dao.getCreateDate();
/* 211 */     this._createUserId = dao.getCreateUserId();
/* 212 */     this._updateDate = dao.getUpdateDate();
/* 213 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 217 */     AwardAccountCouponPropertyId id = (AwardAccountCouponPropertyId)argId;
/* 218 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 219 */     argStatement.setString(2, id.getCardNumber());
/* 220 */     argStatement.setString(3, id.getAccountId());
/* 221 */     argStatement.setString(4, id.getCouponId());
/* 222 */     argStatement.setString(5, id.getPropertyCode());
/* 223 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 227 */     AwardAccountCouponPropertyId id = new AwardAccountCouponPropertyId();
/* 228 */     id.setOrganizationId(this._organizationId);
/* 229 */     id.setCardNumber(this._cardNumber);
/* 230 */     id.setAccountId(this._accountId);
/* 231 */     id.setCouponId(this._couponId);
/* 232 */     id.setPropertyCode(this._propertyCode);
/* 233 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 241 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 245 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\AwardAccountCouponPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */