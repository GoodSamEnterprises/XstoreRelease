/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.itm.RefundScheduleId;
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
/*     */ public class RefundScheduleDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1284811343L;
/*     */   private Long _organizationId;
/*     */   private String _itemId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Date _effectiveDate;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Date _expirationDate;
/*     */   private Integer _maximumFullRefundTime;
/*     */   private Integer _minimumNoRefundTime;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.item_id, t.org_code, t.org_value, t.effective_date, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.expiration_date, t.max_full_refund_time, t.min_no_refund_time FROM itm_refund_schedule t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND item_id = ?  AND effective_date = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  41 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  45 */     return "SELECT t.organization_id, t.item_id, t.org_code, t.org_value, t.effective_date, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.expiration_date, t.max_full_refund_time, t.min_no_refund_time FROM itm_refund_schedule t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  51 */     return " WHERE organization_id = ?  AND item_id = ?  AND effective_date = ?  ";
/*     */   }
/*     */   
/*  54 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_refund_schedule(organization_id, item_id, org_code, org_value, effective_date, create_date, create_user_id, update_date, update_user_id, expiration_date, max_full_refund_time, min_no_refund_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  57 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  61 */     Object[][] insertParameterObject = { { this._organizationId, this._itemId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._effectiveDate, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._expirationDate, this._maximumFullRefundTime, this._minimumNoRefundTime } };
/*  62 */     return insertParameterObject;
/*     */   }
/*     */   
/*  65 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 12, 91, 91, 12, 91, 12, 91, 4, 4 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  68 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  71 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_refund_schedule SET org_code = ?, org_value = ?, update_date = ?, update_user_id = ?, expiration_date = ?, max_full_refund_time = ?, min_no_refund_time = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  74 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  78 */     Object[][] updateParameterObject = { { this._orgCode, this._orgValue, this._updateDate, this._updateUserId, this._expirationDate, this._maximumFullRefundTime, this._minimumNoRefundTime } };
/*  79 */     return updateParameterObject;
/*     */   }
/*     */   
/*  82 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 12, 91, 4, 4 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  84 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  87 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_refund_schedule" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND item_id = ?  AND effective_date = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  90 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  96 */     return " WHERE organization_id = ?  AND item_id = ?  AND effective_date = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  99 */     return new Object[] { this._organizationId, this._itemId, this._effectiveDate };
/*     */   }
/*     */   
/* 102 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 91 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 105 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 108 */     return "itm_refund_schedule";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 112 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 116 */     return new RefundScheduleFiller(this);
/*     */   }
/*     */   
/*     */   private static class RefundScheduleFiller
/*     */     implements IFiller {
/*     */     private RefundScheduleDBA _parent;
/*     */     
/*     */     public RefundScheduleFiller(RefundScheduleDBA argParent) {
/* 124 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 129 */       long primitiveResult = argResultSet.getLong(1);
/* 130 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 131 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 135 */       this._parent._itemId = argResultSet.getString(2);
/* 136 */       this._parent._orgCode = argResultSet.getString(3);
/* 137 */       this._parent._orgValue = argResultSet.getString(4);
/*     */       
/* 139 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 140 */       if (t5 != null) {
/* 141 */         this._parent._effectiveDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 144 */         this._parent._effectiveDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 148 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 149 */       if (t6 != null) {
/* 150 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 153 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 156 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 158 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 159 */       if (t8 != null) {
/* 160 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 163 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 166 */       this._parent._updateUserId = argResultSet.getString(9);
/*     */       
/* 168 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 169 */       if (t10 != null) {
/* 170 */         this._parent._expirationDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 173 */         this._parent._expirationDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 178 */       int i = argResultSet.getInt(11);
/* 179 */       if (i != 0 || argResultSet.getObject(11) != null) {
/* 180 */         this._parent._maximumFullRefundTime = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 186 */       i = argResultSet.getInt(12);
/* 187 */       if (i != 0 || argResultSet.getObject(12) != null) {
/* 188 */         this._parent._minimumNoRefundTime = Integer.valueOf(i);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 196 */     argDAO.suppressStateChanges(true);
/* 197 */     RefundScheduleDAO dao = (RefundScheduleDAO)argDAO;
/* 198 */     dao.setOrganizationId(this._organizationId);
/* 199 */     dao.setItemId(this._itemId);
/* 200 */     dao.setOrgCode(this._orgCode);
/* 201 */     dao.setOrgValue(this._orgValue);
/* 202 */     dao.setEffectiveDate(this._effectiveDate);
/* 203 */     dao.setCreateDate(this._createDate);
/* 204 */     dao.setCreateUserId(this._createUserId);
/* 205 */     dao.setUpdateDate(this._updateDate);
/* 206 */     dao.setUpdateUserId(this._updateUserId);
/* 207 */     dao.setExpirationDate(this._expirationDate);
/* 208 */     dao.setMaximumFullRefundTime(this._maximumFullRefundTime);
/* 209 */     dao.setMinimumNoRefundTime(this._minimumNoRefundTime);
/* 210 */     argDAO.suppressStateChanges(false);
/* 211 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 215 */     return loadDAO((IDataAccessObject)new RefundScheduleDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 219 */     RefundScheduleDAO dao = (RefundScheduleDAO)argDAO;
/* 220 */     this._organizationId = dao.getOrganizationId();
/* 221 */     this._itemId = dao.getItemId();
/* 222 */     this._orgCode = dao.getOrgCode();
/* 223 */     this._orgValue = dao.getOrgValue();
/* 224 */     this._effectiveDate = dao.getEffectiveDate();
/* 225 */     this._createDate = dao.getCreateDate();
/* 226 */     this._createUserId = dao.getCreateUserId();
/* 227 */     this._updateDate = dao.getUpdateDate();
/* 228 */     this._updateUserId = dao.getUpdateUserId();
/* 229 */     this._expirationDate = dao.getExpirationDate();
/* 230 */     this._maximumFullRefundTime = dao.getMaximumFullRefundTime();
/* 231 */     this._minimumNoRefundTime = dao.getMinimumNoRefundTime();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 235 */     RefundScheduleId id = (RefundScheduleId)argId;
/* 236 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 237 */     argStatement.setString(2, id.getItemId());
/* 238 */     argStatement.setTimestamp(3, new Timestamp(id.getEffectiveDate().getTime()));
/* 239 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 243 */     RefundScheduleId id = new RefundScheduleId();
/* 244 */     id.setOrganizationId(this._organizationId);
/* 245 */     id.setItemId(this._itemId);
/* 246 */     id.setEffectiveDate(this._effectiveDate);
/* 247 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 255 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 259 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\RefundScheduleDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */