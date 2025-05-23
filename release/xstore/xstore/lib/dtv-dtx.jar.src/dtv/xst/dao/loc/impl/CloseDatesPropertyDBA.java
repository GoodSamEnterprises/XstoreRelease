/*     */ package dtv.xst.dao.loc.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.loc.CloseDatesPropertyId;
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
/*     */ public class CloseDatesPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1128690818L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _closeDate;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.close_date, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM loc_close_dates_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND close_date = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  41 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  45 */     return "SELECT t.organization_id, t.rtl_loc_id, t.close_date, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM loc_close_dates_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  51 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND close_date = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  54 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO loc_close_dates_p(organization_id, rtl_loc_id, close_date, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  57 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  61 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._closeDate, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  62 */     return insertParameterObject;
/*     */   }
/*     */   
/*  65 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  68 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  71 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE loc_close_dates_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  74 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  78 */     Object[][] updateParameterObject = { { this._type, this._stringValue, this._dateValue, this._decimalValue, this._updateDate, this._updateUserId } };
/*  79 */     return updateParameterObject;
/*     */   }
/*     */   
/*  82 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 3, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  84 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  87 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM loc_close_dates_p" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND close_date = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  90 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  96 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND close_date = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  99 */     return new Object[] { this._organizationId, this._retailLocationId, this._closeDate, this._propertyCode };
/*     */   }
/*     */   
/* 102 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 105 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 108 */     return "loc_close_dates_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 112 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 116 */     return new CloseDatesPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class CloseDatesPropertyFiller
/*     */     implements IFiller {
/*     */     private CloseDatesPropertyDBA _parent;
/*     */     
/*     */     public CloseDatesPropertyFiller(CloseDatesPropertyDBA argParent) {
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
/*     */ 
/*     */       
/* 137 */       primitiveResult = argResultSet.getLong(2);
/* 138 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 139 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 144 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 145 */       if (t3 != null) {
/* 146 */         this._parent._closeDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 149 */         this._parent._closeDate = null;
/*     */       } 
/*     */       
/* 152 */       this._parent._propertyCode = argResultSet.getString(4);
/* 153 */       this._parent._type = argResultSet.getString(5);
/* 154 */       this._parent._stringValue = argResultSet.getString(6);
/*     */       
/* 156 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 157 */       if (t7 != null) {
/* 158 */         this._parent._dateValue = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 161 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 164 */       this._parent._decimalValue = argResultSet.getBigDecimal(8);
/*     */       
/* 166 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 167 */       if (t9 != null) {
/* 168 */         this._parent._createDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 171 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 174 */       this._parent._createUserId = argResultSet.getString(10);
/*     */       
/* 176 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 177 */       if (t11 != null) {
/* 178 */         this._parent._updateDate = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 181 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 184 */       this._parent._updateUserId = argResultSet.getString(12);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 189 */     argDAO.suppressStateChanges(true);
/* 190 */     CloseDatesPropertyDAO dao = (CloseDatesPropertyDAO)argDAO;
/* 191 */     dao.setOrganizationId(this._organizationId);
/* 192 */     dao.setRetailLocationId(this._retailLocationId);
/* 193 */     dao.setCloseDate(this._closeDate);
/* 194 */     dao.setPropertyCode(this._propertyCode);
/* 195 */     dao.setType(this._type);
/* 196 */     dao.setStringValue(this._stringValue);
/* 197 */     dao.setDateValue(this._dateValue);
/* 198 */     dao.setDecimalValue(this._decimalValue);
/* 199 */     dao.setCreateDate(this._createDate);
/* 200 */     dao.setCreateUserId(this._createUserId);
/* 201 */     dao.setUpdateDate(this._updateDate);
/* 202 */     dao.setUpdateUserId(this._updateUserId);
/* 203 */     argDAO.suppressStateChanges(false);
/* 204 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 208 */     return loadDAO((IDataAccessObject)new CloseDatesPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 212 */     CloseDatesPropertyDAO dao = (CloseDatesPropertyDAO)argDAO;
/* 213 */     this._organizationId = dao.getOrganizationId();
/* 214 */     this._retailLocationId = dao.getRetailLocationId();
/* 215 */     this._closeDate = dao.getCloseDate();
/* 216 */     this._propertyCode = dao.getPropertyCode();
/* 217 */     this._type = dao.getType();
/* 218 */     this._stringValue = dao.getStringValue();
/* 219 */     this._dateValue = dao.getDateValue();
/* 220 */     this._decimalValue = dao.getDecimalValue();
/* 221 */     this._createDate = dao.getCreateDate();
/* 222 */     this._createUserId = dao.getCreateUserId();
/* 223 */     this._updateDate = dao.getUpdateDate();
/* 224 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 228 */     CloseDatesPropertyId id = (CloseDatesPropertyId)argId;
/* 229 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 230 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 231 */     argStatement.setTimestamp(3, new Timestamp(id.getCloseDate().getTime()));
/* 232 */     argStatement.setString(4, id.getPropertyCode());
/* 233 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 237 */     CloseDatesPropertyId id = new CloseDatesPropertyId();
/* 238 */     id.setOrganizationId(this._organizationId);
/* 239 */     id.setRetailLocationId(this._retailLocationId);
/* 240 */     id.setCloseDate(this._closeDate);
/* 241 */     id.setPropertyCode(this._propertyCode);
/* 242 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 250 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 254 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\loc\impl\CloseDatesPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */