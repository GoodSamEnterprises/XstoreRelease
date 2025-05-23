/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.itm.ItemRestrictionCalendarId;
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
/*     */ public class ItemRestrictionCalendarDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1566239497L;
/*     */   private Long _organizationId;
/*     */   private String _restrictionCategory;
/*     */   private String _restrictionCode;
/*     */   private String _dayCode;
/*     */   private Date _effectiveDate;
/*     */   private Date _startTime;
/*     */   private String _saleLineItemTypeCode;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Date _expirationDate;
/*     */   private Date _endTime;
/*     */   private Boolean _exemption;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.restriction_category, t.restriction_code, t.day_code, t.effective_date, t.start_time, t.sale_lineitm_typecode, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.expiration_date, t.end_time, t.exemption_flag FROM itm_item_restrict_calendar t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND restriction_category = ?  AND restriction_code = ?  AND day_code = ?  AND effective_date = ?  AND start_time = ?  AND sale_lineitm_typecode = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  45 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  49 */     return "SELECT t.organization_id, t.restriction_category, t.restriction_code, t.day_code, t.effective_date, t.start_time, t.sale_lineitm_typecode, t.org_code, t.org_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.expiration_date, t.end_time, t.exemption_flag FROM itm_item_restrict_calendar t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  55 */     return " WHERE organization_id = ?  AND restriction_category = ?  AND restriction_code = ?  AND day_code = ?  AND effective_date = ?  AND start_time = ?  AND sale_lineitm_typecode = ?  ";
/*     */   }
/*     */   
/*  58 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_item_restrict_calendar(organization_id, restriction_category, restriction_code, day_code, effective_date, start_time, sale_lineitm_typecode, org_code, org_value, create_date, create_user_id, update_date, update_user_id, expiration_date, end_time, exemption_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  61 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  65 */     Object[][] insertParameterObject = { { this._organizationId, this._restrictionCategory, this._restrictionCode, this._dayCode, this._effectiveDate, this._startTime, this._saleLineItemTypeCode, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._expirationDate, this._endTime, this._exemption } };
/*  66 */     return insertParameterObject;
/*     */   }
/*     */   
/*  69 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 12, 91, 91, 12, 12, 12, 91, 12, 91, 12, 91, 91, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  72 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  75 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_item_restrict_calendar SET org_code = ?, org_value = ?, update_date = ?, update_user_id = ?, expiration_date = ?, end_time = ?, exemption_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  78 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  82 */     Object[][] updateParameterObject = { { this._orgCode, this._orgValue, this._updateDate, this._updateUserId, this._expirationDate, this._endTime, this._exemption } };
/*  83 */     return updateParameterObject;
/*     */   }
/*     */   
/*  86 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 12, 91, 91, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  88 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  91 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_item_restrict_calendar" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND restriction_category = ?  AND restriction_code = ?  AND day_code = ?  AND effective_date = ?  AND start_time = ?  AND sale_lineitm_typecode = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  94 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 100 */     return " WHERE organization_id = ?  AND restriction_category = ?  AND restriction_code = ?  AND day_code = ?  AND effective_date = ?  AND start_time = ?  AND sale_lineitm_typecode = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 103 */     return new Object[] { this._organizationId, this._restrictionCategory, this._restrictionCode, this._dayCode, this._effectiveDate, this._startTime, this._saleLineItemTypeCode };
/*     */   }
/*     */   
/* 106 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, 12, 91, 91, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 109 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 112 */     return "itm_item_restrict_calendar";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 116 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 120 */     return new ItemRestrictionCalendarFiller(this);
/*     */   }
/*     */   
/*     */   private static class ItemRestrictionCalendarFiller
/*     */     implements IFiller {
/*     */     private ItemRestrictionCalendarDBA _parent;
/*     */     
/*     */     public ItemRestrictionCalendarFiller(ItemRestrictionCalendarDBA argParent) {
/* 128 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 133 */       long primitiveResult = argResultSet.getLong(1);
/* 134 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 135 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 139 */       this._parent._restrictionCategory = argResultSet.getString(2);
/* 140 */       this._parent._restrictionCode = argResultSet.getString(3);
/* 141 */       this._parent._dayCode = argResultSet.getString(4);
/*     */       
/* 143 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 144 */       if (t5 != null) {
/* 145 */         this._parent._effectiveDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 148 */         this._parent._effectiveDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 152 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 153 */       if (t6 != null) {
/* 154 */         this._parent._startTime = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 157 */         this._parent._startTime = null;
/*     */       } 
/*     */       
/* 160 */       this._parent._saleLineItemTypeCode = argResultSet.getString(7);
/* 161 */       this._parent._orgCode = argResultSet.getString(8);
/* 162 */       this._parent._orgValue = argResultSet.getString(9);
/*     */       
/* 164 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 165 */       if (t10 != null) {
/* 166 */         this._parent._createDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 169 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 172 */       this._parent._createUserId = argResultSet.getString(11);
/*     */       
/* 174 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 175 */       if (t12 != null) {
/* 176 */         this._parent._updateDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 179 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 182 */       this._parent._updateUserId = argResultSet.getString(13);
/*     */       
/* 184 */       Timestamp t14 = argResultSet.getTimestamp(14);
/* 185 */       if (t14 != null) {
/* 186 */         this._parent._expirationDate = (Date)new DtvDate(t14.getTime());
/*     */       } else {
/*     */         
/* 189 */         this._parent._expirationDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 193 */       Timestamp t15 = argResultSet.getTimestamp(15);
/* 194 */       if (t15 != null) {
/* 195 */         this._parent._endTime = (Date)new DtvDate(t15.getTime());
/*     */       } else {
/*     */         
/* 198 */         this._parent._endTime = null;
/*     */       } 
/*     */       
/* 201 */       this._parent._exemption = Boolean.valueOf(argResultSet.getBoolean(16));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 206 */     argDAO.suppressStateChanges(true);
/* 207 */     ItemRestrictionCalendarDAO dao = (ItemRestrictionCalendarDAO)argDAO;
/* 208 */     dao.setOrganizationId(this._organizationId);
/* 209 */     dao.setRestrictionCategory(this._restrictionCategory);
/* 210 */     dao.setRestrictionCode(this._restrictionCode);
/* 211 */     dao.setDayCode(this._dayCode);
/* 212 */     dao.setEffectiveDate(this._effectiveDate);
/* 213 */     dao.setStartTime(this._startTime);
/* 214 */     dao.setSaleLineItemTypeCode(this._saleLineItemTypeCode);
/* 215 */     dao.setOrgCode(this._orgCode);
/* 216 */     dao.setOrgValue(this._orgValue);
/* 217 */     dao.setCreateDate(this._createDate);
/* 218 */     dao.setCreateUserId(this._createUserId);
/* 219 */     dao.setUpdateDate(this._updateDate);
/* 220 */     dao.setUpdateUserId(this._updateUserId);
/* 221 */     dao.setExpirationDate(this._expirationDate);
/* 222 */     dao.setEndTime(this._endTime);
/* 223 */     dao.setExemption(this._exemption);
/* 224 */     argDAO.suppressStateChanges(false);
/* 225 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 229 */     return loadDAO((IDataAccessObject)new ItemRestrictionCalendarDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 233 */     ItemRestrictionCalendarDAO dao = (ItemRestrictionCalendarDAO)argDAO;
/* 234 */     this._organizationId = dao.getOrganizationId();
/* 235 */     this._restrictionCategory = dao.getRestrictionCategory();
/* 236 */     this._restrictionCode = dao.getRestrictionCode();
/* 237 */     this._dayCode = dao.getDayCode();
/* 238 */     this._effectiveDate = dao.getEffectiveDate();
/* 239 */     this._startTime = dao.getStartTime();
/* 240 */     this._saleLineItemTypeCode = dao.getSaleLineItemTypeCode();
/* 241 */     this._orgCode = dao.getOrgCode();
/* 242 */     this._orgValue = dao.getOrgValue();
/* 243 */     this._createDate = dao.getCreateDate();
/* 244 */     this._createUserId = dao.getCreateUserId();
/* 245 */     this._updateDate = dao.getUpdateDate();
/* 246 */     this._updateUserId = dao.getUpdateUserId();
/* 247 */     this._expirationDate = dao.getExpirationDate();
/* 248 */     this._endTime = dao.getEndTime();
/* 249 */     this._exemption = (dao.getExemption() != null) ? dao.getExemption() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 253 */     ItemRestrictionCalendarId id = (ItemRestrictionCalendarId)argId;
/* 254 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 255 */     argStatement.setString(2, id.getRestrictionCategory());
/* 256 */     argStatement.setString(3, id.getRestrictionCode());
/* 257 */     argStatement.setString(4, id.getDayCode());
/* 258 */     argStatement.setTimestamp(5, new Timestamp(id.getEffectiveDate().getTime()));
/* 259 */     argStatement.setTimestamp(6, new Timestamp(id.getStartTime().getTime()));
/* 260 */     argStatement.setString(7, id.getSaleLineItemTypeCode());
/* 261 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 265 */     ItemRestrictionCalendarId id = new ItemRestrictionCalendarId();
/* 266 */     id.setOrganizationId(this._organizationId);
/* 267 */     id.setRestrictionCategory(this._restrictionCategory);
/* 268 */     id.setRestrictionCode(this._restrictionCode);
/* 269 */     id.setDayCode(this._dayCode);
/* 270 */     id.setEffectiveDate(this._effectiveDate);
/* 271 */     id.setStartTime(this._startTime);
/* 272 */     id.setSaleLineItemTypeCode(this._saleLineItemTypeCode);
/* 273 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 281 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 285 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemRestrictionCalendarDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */