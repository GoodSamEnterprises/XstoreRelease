/*     */ package dtv.xst.dao.dsc.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.dsc.CouponId;
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
/*     */ public class CouponDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 2024260678L;
/*     */   private String _couponSerialNumber;
/*     */   private Long _organizationId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _discountCode;
/*     */   private String _couponType;
/*     */   private String _tenderId;
/*     */   private Date _effectiveDate;
/*     */   private Date _expirationDate;
/*     */   private Boolean _serialized;
/*     */   private static final String SELECT_OBJECT = "SELECT t.coupon_serial_nbr, t.organization_id, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.discount_code, t.coupon_type, t.tndr_id, t.effective_date, t.expiration_date, t.serialized_flag FROM dsc_coupon_xref t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE coupon_serial_nbr = ?  AND organization_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  43 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  47 */     return "SELECT t.coupon_serial_nbr, t.organization_id, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.discount_code, t.coupon_type, t.tndr_id, t.effective_date, t.expiration_date, t.serialized_flag FROM dsc_coupon_xref t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  53 */     return " WHERE coupon_serial_nbr = ?  AND organization_id = ?  ";
/*     */   }
/*     */   
/*  56 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO dsc_coupon_xref(coupon_serial_nbr, organization_id, org_code, org_value, create_date, create_user_id, update_date, update_user_id, discount_code, coupon_type, tndr_id, effective_date, expiration_date, serialized_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  59 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  63 */     Object[][] insertParameterObject = { { this._couponSerialNumber, this._organizationId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._discountCode, this._couponType, this._tenderId, this._effectiveDate, this._expirationDate, this._serialized } };
/*  64 */     return insertParameterObject;
/*     */   }
/*     */   
/*  67 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, -5, 12, 12, 91, 12, 91, 12, 12, 12, 12, 91, 91, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  70 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  73 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE dsc_coupon_xref SET org_code = ?, org_value = ?, update_date = ?, update_user_id = ?, discount_code = ?, coupon_type = ?, tndr_id = ?, effective_date = ?, expiration_date = ?, serialized_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  76 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  80 */     Object[][] updateParameterObject = { { this._orgCode, this._orgValue, this._updateDate, this._updateUserId, this._discountCode, this._couponType, this._tenderId, this._effectiveDate, this._expirationDate, this._serialized } };
/*  81 */     return updateParameterObject;
/*     */   }
/*     */   
/*  84 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 12, 12, 12, 12, 91, 91, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  86 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  89 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM dsc_coupon_xref" }; private static final String WHERE_OBJECT = " WHERE coupon_serial_nbr = ?  AND organization_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  92 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  98 */     return " WHERE coupon_serial_nbr = ?  AND organization_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 101 */     return new Object[] { this._couponSerialNumber, this._organizationId };
/*     */   }
/*     */   
/* 104 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 107 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 110 */     return "dsc_coupon_xref";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 114 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 118 */     return new CouponFiller(this);
/*     */   }
/*     */   
/*     */   private static class CouponFiller
/*     */     implements IFiller {
/*     */     private CouponDBA _parent;
/*     */     
/*     */     public CouponFiller(CouponDBA argParent) {
/* 126 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 129 */       this._parent._couponSerialNumber = argResultSet.getString(1);
/*     */ 
/*     */       
/* 132 */       long primitiveResult = argResultSet.getLong(2);
/* 133 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 134 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 138 */       this._parent._orgCode = argResultSet.getString(3);
/* 139 */       this._parent._orgValue = argResultSet.getString(4);
/*     */       
/* 141 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 142 */       if (t5 != null) {
/* 143 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 146 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 149 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 151 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 152 */       if (t7 != null) {
/* 153 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 156 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 159 */       this._parent._updateUserId = argResultSet.getString(8);
/* 160 */       this._parent._discountCode = argResultSet.getString(9);
/* 161 */       this._parent._couponType = argResultSet.getString(10);
/* 162 */       this._parent._tenderId = argResultSet.getString(11);
/*     */       
/* 164 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 165 */       if (t12 != null) {
/* 166 */         this._parent._effectiveDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 169 */         this._parent._effectiveDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 173 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 174 */       if (t13 != null) {
/* 175 */         this._parent._expirationDate = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 178 */         this._parent._expirationDate = null;
/*     */       } 
/*     */       
/* 181 */       this._parent._serialized = Boolean.valueOf(argResultSet.getBoolean(14));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 186 */     argDAO.suppressStateChanges(true);
/* 187 */     CouponDAO dao = (CouponDAO)argDAO;
/* 188 */     dao.setCouponSerialNumber(this._couponSerialNumber);
/* 189 */     dao.setOrganizationId(this._organizationId);
/* 190 */     dao.setOrgCode(this._orgCode);
/* 191 */     dao.setOrgValue(this._orgValue);
/* 192 */     dao.setCreateDate(this._createDate);
/* 193 */     dao.setCreateUserId(this._createUserId);
/* 194 */     dao.setUpdateDate(this._updateDate);
/* 195 */     dao.setUpdateUserId(this._updateUserId);
/* 196 */     dao.setDiscountCode(this._discountCode);
/* 197 */     dao.setCouponType(this._couponType);
/* 198 */     dao.setTenderId(this._tenderId);
/* 199 */     dao.setEffectiveDate(this._effectiveDate);
/* 200 */     dao.setExpirationDate(this._expirationDate);
/* 201 */     dao.setSerialized(this._serialized);
/* 202 */     argDAO.suppressStateChanges(false);
/* 203 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 207 */     return loadDAO((IDataAccessObject)new CouponDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 211 */     CouponDAO dao = (CouponDAO)argDAO;
/* 212 */     this._couponSerialNumber = dao.getCouponSerialNumber();
/* 213 */     this._organizationId = dao.getOrganizationId();
/* 214 */     this._orgCode = dao.getOrgCode();
/* 215 */     this._orgValue = dao.getOrgValue();
/* 216 */     this._createDate = dao.getCreateDate();
/* 217 */     this._createUserId = dao.getCreateUserId();
/* 218 */     this._updateDate = dao.getUpdateDate();
/* 219 */     this._updateUserId = dao.getUpdateUserId();
/* 220 */     this._discountCode = dao.getDiscountCode();
/* 221 */     this._couponType = dao.getCouponType();
/* 222 */     this._tenderId = dao.getTenderId();
/* 223 */     this._effectiveDate = dao.getEffectiveDate();
/* 224 */     this._expirationDate = dao.getExpirationDate();
/* 225 */     this._serialized = (dao.getSerialized() != null) ? dao.getSerialized() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 229 */     CouponId id = (CouponId)argId;
/* 230 */     argStatement.setString(1, id.getCouponSerialNumber());
/* 231 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 232 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 236 */     CouponId id = new CouponId();
/* 237 */     id.setCouponSerialNumber(this._couponSerialNumber);
/* 238 */     id.setOrganizationId(this._organizationId);
/* 239 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 247 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 251 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\dsc\impl\CouponDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */