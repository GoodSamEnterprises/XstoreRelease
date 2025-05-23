/*     */ package dtv.xst.dao.ctl.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.ctl.VersionPropertyId;
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
/*     */ public class VersionPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1930542765L;
/*     */   private Long _organizationId;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM ctl_version_history_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  39 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  43 */     return "SELECT t.organization_id, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM ctl_version_history_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  49 */     return " WHERE organization_id = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  52 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO ctl_version_history_p(organization_id, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  55 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  59 */     Object[][] insertParameterObject = { { this._organizationId, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  60 */     return insertParameterObject;
/*     */   }
/*     */   
/*  63 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  66 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  69 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE ctl_version_history_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  72 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  76 */     Object[][] updateParameterObject = { { this._type, this._stringValue, this._dateValue, this._decimalValue, this._updateDate, this._updateUserId } };
/*  77 */     return updateParameterObject;
/*     */   }
/*     */   
/*  80 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 3, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  82 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  85 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM ctl_version_history_p" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  88 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  94 */     return " WHERE organization_id = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  97 */     return new Object[] { this._organizationId, this._propertyCode };
/*     */   }
/*     */   
/* 100 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 103 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 106 */     return "ctl_version_history_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 110 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 114 */     return new VersionPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class VersionPropertyFiller
/*     */     implements IFiller {
/*     */     private VersionPropertyDBA _parent;
/*     */     
/*     */     public VersionPropertyFiller(VersionPropertyDBA argParent) {
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
/* 133 */       this._parent._propertyCode = argResultSet.getString(2);
/* 134 */       this._parent._type = argResultSet.getString(3);
/* 135 */       this._parent._stringValue = argResultSet.getString(4);
/*     */       
/* 137 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 138 */       if (t5 != null) {
/* 139 */         this._parent._dateValue = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 142 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 145 */       this._parent._decimalValue = argResultSet.getBigDecimal(6);
/*     */       
/* 147 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 148 */       if (t7 != null) {
/* 149 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 152 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 155 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 157 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 158 */       if (t9 != null) {
/* 159 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 162 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 165 */       this._parent._updateUserId = argResultSet.getString(10);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 170 */     argDAO.suppressStateChanges(true);
/* 171 */     VersionPropertyDAO dao = (VersionPropertyDAO)argDAO;
/* 172 */     dao.setOrganizationId(this._organizationId);
/* 173 */     dao.setPropertyCode(this._propertyCode);
/* 174 */     dao.setType(this._type);
/* 175 */     dao.setStringValue(this._stringValue);
/* 176 */     dao.setDateValue(this._dateValue);
/* 177 */     dao.setDecimalValue(this._decimalValue);
/* 178 */     dao.setCreateDate(this._createDate);
/* 179 */     dao.setCreateUserId(this._createUserId);
/* 180 */     dao.setUpdateDate(this._updateDate);
/* 181 */     dao.setUpdateUserId(this._updateUserId);
/* 182 */     argDAO.suppressStateChanges(false);
/* 183 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 187 */     return loadDAO((IDataAccessObject)new VersionPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 191 */     VersionPropertyDAO dao = (VersionPropertyDAO)argDAO;
/* 192 */     this._organizationId = dao.getOrganizationId();
/* 193 */     this._propertyCode = dao.getPropertyCode();
/* 194 */     this._type = dao.getType();
/* 195 */     this._stringValue = dao.getStringValue();
/* 196 */     this._dateValue = dao.getDateValue();
/* 197 */     this._decimalValue = dao.getDecimalValue();
/* 198 */     this._createDate = dao.getCreateDate();
/* 199 */     this._createUserId = dao.getCreateUserId();
/* 200 */     this._updateDate = dao.getUpdateDate();
/* 201 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 205 */     VersionPropertyId id = (VersionPropertyId)argId;
/* 206 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 207 */     argStatement.setString(2, id.getPropertyCode());
/* 208 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 212 */     VersionPropertyId id = new VersionPropertyId();
/* 213 */     id.setOrganizationId(this._organizationId);
/* 214 */     id.setPropertyCode(this._propertyCode);
/* 215 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 223 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 227 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ctl\impl\VersionPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */