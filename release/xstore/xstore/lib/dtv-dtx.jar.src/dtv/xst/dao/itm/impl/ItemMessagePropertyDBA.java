/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.ItemMessagePropertyId;
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
/*     */ public class ItemMessagePropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1322608457L;
/*     */   private String _messageId;
/*     */   private Long _organizationId;
/*     */   private Date _effectiveDate;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.msg_id, t.organization_id, t.effective_datetime, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM itm_item_msg_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE msg_id = ?  AND organization_id = ?  AND effective_datetime = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  41 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  45 */     return "SELECT t.msg_id, t.organization_id, t.effective_datetime, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM itm_item_msg_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  51 */     return " WHERE msg_id = ?  AND organization_id = ?  AND effective_datetime = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  54 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_item_msg_p(msg_id, organization_id, effective_datetime, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  57 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  61 */     Object[][] insertParameterObject = { { this._messageId, this._organizationId, this._effectiveDate, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  62 */     return insertParameterObject;
/*     */   }
/*     */   
/*  65 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, -5, 91, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  68 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  71 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_item_msg_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
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
/*  87 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_item_msg_p" }; private static final String WHERE_OBJECT = " WHERE msg_id = ?  AND organization_id = ?  AND effective_datetime = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  90 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  96 */     return " WHERE msg_id = ?  AND organization_id = ?  AND effective_datetime = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  99 */     return new Object[] { this._messageId, this._organizationId, this._effectiveDate, this._propertyCode };
/*     */   }
/*     */   
/* 102 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, -5, 91, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 105 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 108 */     return "itm_item_msg_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 112 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 116 */     return new ItemMessagePropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class ItemMessagePropertyFiller
/*     */     implements IFiller {
/*     */     private ItemMessagePropertyDBA _parent;
/*     */     
/*     */     public ItemMessagePropertyFiller(ItemMessagePropertyDBA argParent) {
/* 124 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 127 */       this._parent._messageId = argResultSet.getString(1);
/*     */ 
/*     */       
/* 130 */       long primitiveResult = argResultSet.getLong(2);
/* 131 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 132 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 137 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 138 */       if (t3 != null) {
/* 139 */         this._parent._effectiveDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 142 */         this._parent._effectiveDate = null;
/*     */       } 
/*     */       
/* 145 */       this._parent._propertyCode = argResultSet.getString(4);
/* 146 */       this._parent._type = argResultSet.getString(5);
/* 147 */       this._parent._stringValue = argResultSet.getString(6);
/*     */       
/* 149 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 150 */       if (t7 != null) {
/* 151 */         this._parent._dateValue = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 154 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 157 */       this._parent._decimalValue = argResultSet.getBigDecimal(8);
/*     */       
/* 159 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 160 */       if (t9 != null) {
/* 161 */         this._parent._createDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 164 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 167 */       this._parent._createUserId = argResultSet.getString(10);
/*     */       
/* 169 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 170 */       if (t11 != null) {
/* 171 */         this._parent._updateDate = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 174 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 177 */       this._parent._updateUserId = argResultSet.getString(12);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 182 */     argDAO.suppressStateChanges(true);
/* 183 */     ItemMessagePropertyDAO dao = (ItemMessagePropertyDAO)argDAO;
/* 184 */     dao.setMessageId(this._messageId);
/* 185 */     dao.setOrganizationId(this._organizationId);
/* 186 */     dao.setEffectiveDate(this._effectiveDate);
/* 187 */     dao.setPropertyCode(this._propertyCode);
/* 188 */     dao.setType(this._type);
/* 189 */     dao.setStringValue(this._stringValue);
/* 190 */     dao.setDateValue(this._dateValue);
/* 191 */     dao.setDecimalValue(this._decimalValue);
/* 192 */     dao.setCreateDate(this._createDate);
/* 193 */     dao.setCreateUserId(this._createUserId);
/* 194 */     dao.setUpdateDate(this._updateDate);
/* 195 */     dao.setUpdateUserId(this._updateUserId);
/* 196 */     argDAO.suppressStateChanges(false);
/* 197 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 201 */     return loadDAO((IDataAccessObject)new ItemMessagePropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 205 */     ItemMessagePropertyDAO dao = (ItemMessagePropertyDAO)argDAO;
/* 206 */     this._messageId = dao.getMessageId();
/* 207 */     this._organizationId = dao.getOrganizationId();
/* 208 */     this._effectiveDate = dao.getEffectiveDate();
/* 209 */     this._propertyCode = dao.getPropertyCode();
/* 210 */     this._type = dao.getType();
/* 211 */     this._stringValue = dao.getStringValue();
/* 212 */     this._dateValue = dao.getDateValue();
/* 213 */     this._decimalValue = dao.getDecimalValue();
/* 214 */     this._createDate = dao.getCreateDate();
/* 215 */     this._createUserId = dao.getCreateUserId();
/* 216 */     this._updateDate = dao.getUpdateDate();
/* 217 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 221 */     ItemMessagePropertyId id = (ItemMessagePropertyId)argId;
/* 222 */     argStatement.setString(1, id.getMessageId());
/* 223 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 224 */     argStatement.setTimestamp(3, new Timestamp(id.getEffectiveDate().getTime()));
/* 225 */     argStatement.setString(4, id.getPropertyCode());
/* 226 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 230 */     ItemMessagePropertyId id = new ItemMessagePropertyId();
/* 231 */     id.setMessageId(this._messageId);
/* 232 */     id.setOrganizationId(this._organizationId);
/* 233 */     id.setEffectiveDate(this._effectiveDate);
/* 234 */     id.setPropertyCode(this._propertyCode);
/* 235 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 243 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 247 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\ItemMessagePropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */