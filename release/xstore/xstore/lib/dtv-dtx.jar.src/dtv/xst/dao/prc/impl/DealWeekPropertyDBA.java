/*     */ package dtv.xst.dao.prc.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.prc.DealWeekPropertyId;
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
/*     */ public class DealWeekPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 276168853L;
/*     */   private Long _organizationId;
/*     */   private String _dealId;
/*     */   private String _dayCode;
/*     */   private Date _startTime;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.deal_id, t.day_code, t.start_time, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM prc_deal_week_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND deal_id = ?  AND day_code = ?  AND start_time = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  42 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  46 */     return "SELECT t.organization_id, t.deal_id, t.day_code, t.start_time, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM prc_deal_week_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  52 */     return " WHERE organization_id = ?  AND deal_id = ?  AND day_code = ?  AND start_time = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  55 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO prc_deal_week_p(organization_id, deal_id, day_code, start_time, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  58 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  62 */     Object[][] insertParameterObject = { { this._organizationId, this._dealId, this._dayCode, this._startTime, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  63 */     return insertParameterObject;
/*     */   }
/*     */   
/*  66 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 91, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  69 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  72 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE prc_deal_week_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
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
/*  88 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM prc_deal_week_p" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND deal_id = ?  AND day_code = ?  AND start_time = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  91 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  97 */     return " WHERE organization_id = ?  AND deal_id = ?  AND day_code = ?  AND start_time = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 100 */     return new Object[] { this._organizationId, this._dealId, this._dayCode, this._startTime, this._propertyCode };
/*     */   }
/*     */   
/* 103 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, 91, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 106 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 109 */     return "prc_deal_week_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 113 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 117 */     return new DealWeekPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class DealWeekPropertyFiller
/*     */     implements IFiller {
/*     */     private DealWeekPropertyDBA _parent;
/*     */     
/*     */     public DealWeekPropertyFiller(DealWeekPropertyDBA argParent) {
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
/* 136 */       this._parent._dealId = argResultSet.getString(2);
/* 137 */       this._parent._dayCode = argResultSet.getString(3);
/*     */       
/* 139 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 140 */       if (t4 != null) {
/* 141 */         this._parent._startTime = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 144 */         this._parent._startTime = null;
/*     */       } 
/*     */       
/* 147 */       this._parent._propertyCode = argResultSet.getString(5);
/* 148 */       this._parent._type = argResultSet.getString(6);
/* 149 */       this._parent._stringValue = argResultSet.getString(7);
/*     */       
/* 151 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 152 */       if (t8 != null) {
/* 153 */         this._parent._dateValue = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 156 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 159 */       this._parent._decimalValue = argResultSet.getBigDecimal(9);
/*     */       
/* 161 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 162 */       if (t10 != null) {
/* 163 */         this._parent._createDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 166 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 169 */       this._parent._createUserId = argResultSet.getString(11);
/*     */       
/* 171 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 172 */       if (t12 != null) {
/* 173 */         this._parent._updateDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 176 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 179 */       this._parent._updateUserId = argResultSet.getString(13);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 184 */     argDAO.suppressStateChanges(true);
/* 185 */     DealWeekPropertyDAO dao = (DealWeekPropertyDAO)argDAO;
/* 186 */     dao.setOrganizationId(this._organizationId);
/* 187 */     dao.setDealId(this._dealId);
/* 188 */     dao.setDayCode(this._dayCode);
/* 189 */     dao.setStartTime(this._startTime);
/* 190 */     dao.setPropertyCode(this._propertyCode);
/* 191 */     dao.setType(this._type);
/* 192 */     dao.setStringValue(this._stringValue);
/* 193 */     dao.setDateValue(this._dateValue);
/* 194 */     dao.setDecimalValue(this._decimalValue);
/* 195 */     dao.setCreateDate(this._createDate);
/* 196 */     dao.setCreateUserId(this._createUserId);
/* 197 */     dao.setUpdateDate(this._updateDate);
/* 198 */     dao.setUpdateUserId(this._updateUserId);
/* 199 */     argDAO.suppressStateChanges(false);
/* 200 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 204 */     return loadDAO((IDataAccessObject)new DealWeekPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 208 */     DealWeekPropertyDAO dao = (DealWeekPropertyDAO)argDAO;
/* 209 */     this._organizationId = dao.getOrganizationId();
/* 210 */     this._dealId = dao.getDealId();
/* 211 */     this._dayCode = dao.getDayCode();
/* 212 */     this._startTime = dao.getStartTime();
/* 213 */     this._propertyCode = dao.getPropertyCode();
/* 214 */     this._type = dao.getType();
/* 215 */     this._stringValue = dao.getStringValue();
/* 216 */     this._dateValue = dao.getDateValue();
/* 217 */     this._decimalValue = dao.getDecimalValue();
/* 218 */     this._createDate = dao.getCreateDate();
/* 219 */     this._createUserId = dao.getCreateUserId();
/* 220 */     this._updateDate = dao.getUpdateDate();
/* 221 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 225 */     DealWeekPropertyId id = (DealWeekPropertyId)argId;
/* 226 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 227 */     argStatement.setString(2, id.getDealId());
/* 228 */     argStatement.setString(3, id.getDayCode());
/* 229 */     argStatement.setTimestamp(4, new Timestamp(id.getStartTime().getTime()));
/* 230 */     argStatement.setString(5, id.getPropertyCode());
/* 231 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 235 */     DealWeekPropertyId id = new DealWeekPropertyId();
/* 236 */     id.setOrganizationId(this._organizationId);
/* 237 */     id.setDealId(this._dealId);
/* 238 */     id.setDayCode(this._dayCode);
/* 239 */     id.setStartTime(this._startTime);
/* 240 */     id.setPropertyCode(this._propertyCode);
/* 241 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 249 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 253 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\prc\impl\DealWeekPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */