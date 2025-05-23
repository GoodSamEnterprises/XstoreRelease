/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryCountSheetLineItemPropertyId;
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
/*     */ public class InventoryCountSheetLineItemPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 119325736L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _inventoryCountId;
/*     */   private Integer _countSheetNumber;
/*     */   private Integer _lineItemNumber;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.inv_count_id, t.count_sheet_nbr, t.lineitm_nbr, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM inv_count_sheet_lineitm_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_count_id = ?  AND count_sheet_nbr = ?  AND lineitm_nbr = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  43 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  47 */     return "SELECT t.organization_id, t.rtl_loc_id, t.inv_count_id, t.count_sheet_nbr, t.lineitm_nbr, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM inv_count_sheet_lineitm_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  53 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_count_id = ?  AND count_sheet_nbr = ?  AND lineitm_nbr = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  56 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO inv_count_sheet_lineitm_p(organization_id, rtl_loc_id, inv_count_id, count_sheet_nbr, lineitm_nbr, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  59 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  63 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._inventoryCountId, this._countSheetNumber, this._lineItemNumber, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  64 */     return insertParameterObject;
/*     */   }
/*     */   
/*  67 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 12, 4, 4, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  70 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  73 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE inv_count_sheet_lineitm_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  76 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  80 */     Object[][] updateParameterObject = { { this._type, this._stringValue, this._dateValue, this._decimalValue, this._updateDate, this._updateUserId } };
/*  81 */     return updateParameterObject;
/*     */   }
/*     */   
/*  84 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 3, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  86 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  89 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM inv_count_sheet_lineitm_p" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_count_id = ?  AND count_sheet_nbr = ?  AND lineitm_nbr = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  92 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  98 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND inv_count_id = ?  AND count_sheet_nbr = ?  AND lineitm_nbr = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 101 */     return new Object[] { this._organizationId, this._retailLocationId, this._inventoryCountId, this._countSheetNumber, this._lineItemNumber, this._propertyCode };
/*     */   }
/*     */   
/* 104 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 12, 4, 4, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 107 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 110 */     return "inv_count_sheet_lineitm_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 114 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 118 */     return new InventoryCountSheetLineItemPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class InventoryCountSheetLineItemPropertyFiller
/*     */     implements IFiller {
/*     */     private InventoryCountSheetLineItemPropertyDBA _parent;
/*     */     
/*     */     public InventoryCountSheetLineItemPropertyFiller(InventoryCountSheetLineItemPropertyDBA argParent) {
/* 126 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 131 */       long l = argResultSet.getLong(1);
/* 132 */       if (l != 0L || argResultSet.getObject(1) != null) {
/* 133 */         this._parent._organizationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 139 */       l = argResultSet.getLong(2);
/* 140 */       if (l != 0L || argResultSet.getObject(2) != null) {
/* 141 */         this._parent._retailLocationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */       
/* 145 */       this._parent._inventoryCountId = argResultSet.getString(3);
/*     */ 
/*     */       
/* 148 */       int primitiveResult = argResultSet.getInt(4);
/* 149 */       if (primitiveResult != 0 || argResultSet.getObject(4) != null) {
/* 150 */         this._parent._countSheetNumber = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 156 */       primitiveResult = argResultSet.getInt(5);
/* 157 */       if (primitiveResult != 0 || argResultSet.getObject(5) != null) {
/* 158 */         this._parent._lineItemNumber = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 162 */       this._parent._propertyCode = argResultSet.getString(6);
/* 163 */       this._parent._type = argResultSet.getString(7);
/* 164 */       this._parent._stringValue = argResultSet.getString(8);
/*     */       
/* 166 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 167 */       if (t9 != null) {
/* 168 */         this._parent._dateValue = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 171 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 174 */       this._parent._decimalValue = argResultSet.getBigDecimal(10);
/*     */       
/* 176 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 177 */       if (t11 != null) {
/* 178 */         this._parent._createDate = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 181 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 184 */       this._parent._createUserId = argResultSet.getString(12);
/*     */       
/* 186 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 187 */       if (t13 != null) {
/* 188 */         this._parent._updateDate = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 191 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 194 */       this._parent._updateUserId = argResultSet.getString(14);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 199 */     argDAO.suppressStateChanges(true);
/* 200 */     InventoryCountSheetLineItemPropertyDAO dao = (InventoryCountSheetLineItemPropertyDAO)argDAO;
/* 201 */     dao.setOrganizationId(this._organizationId);
/* 202 */     dao.setRetailLocationId(this._retailLocationId);
/* 203 */     dao.setInventoryCountId(this._inventoryCountId);
/* 204 */     dao.setCountSheetNumber(this._countSheetNumber);
/* 205 */     dao.setLineItemNumber(this._lineItemNumber);
/* 206 */     dao.setPropertyCode(this._propertyCode);
/* 207 */     dao.setType(this._type);
/* 208 */     dao.setStringValue(this._stringValue);
/* 209 */     dao.setDateValue(this._dateValue);
/* 210 */     dao.setDecimalValue(this._decimalValue);
/* 211 */     dao.setCreateDate(this._createDate);
/* 212 */     dao.setCreateUserId(this._createUserId);
/* 213 */     dao.setUpdateDate(this._updateDate);
/* 214 */     dao.setUpdateUserId(this._updateUserId);
/* 215 */     argDAO.suppressStateChanges(false);
/* 216 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 220 */     return loadDAO((IDataAccessObject)new InventoryCountSheetLineItemPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 224 */     InventoryCountSheetLineItemPropertyDAO dao = (InventoryCountSheetLineItemPropertyDAO)argDAO;
/* 225 */     this._organizationId = dao.getOrganizationId();
/* 226 */     this._retailLocationId = dao.getRetailLocationId();
/* 227 */     this._inventoryCountId = dao.getInventoryCountId();
/* 228 */     this._countSheetNumber = dao.getCountSheetNumber();
/* 229 */     this._lineItemNumber = dao.getLineItemNumber();
/* 230 */     this._propertyCode = dao.getPropertyCode();
/* 231 */     this._type = dao.getType();
/* 232 */     this._stringValue = dao.getStringValue();
/* 233 */     this._dateValue = dao.getDateValue();
/* 234 */     this._decimalValue = dao.getDecimalValue();
/* 235 */     this._createDate = dao.getCreateDate();
/* 236 */     this._createUserId = dao.getCreateUserId();
/* 237 */     this._updateDate = dao.getUpdateDate();
/* 238 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 242 */     InventoryCountSheetLineItemPropertyId id = (InventoryCountSheetLineItemPropertyId)argId;
/* 243 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 244 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 245 */     argStatement.setString(3, id.getInventoryCountId());
/* 246 */     argStatement.setInt(4, id.getCountSheetNumber().intValue());
/* 247 */     argStatement.setInt(5, id.getLineItemNumber().intValue());
/* 248 */     argStatement.setString(6, id.getPropertyCode());
/* 249 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 253 */     InventoryCountSheetLineItemPropertyId id = new InventoryCountSheetLineItemPropertyId();
/* 254 */     id.setOrganizationId(this._organizationId);
/* 255 */     id.setRetailLocationId(this._retailLocationId);
/* 256 */     id.setInventoryCountId(this._inventoryCountId);
/* 257 */     id.setCountSheetNumber(this._countSheetNumber);
/* 258 */     id.setLineItemNumber(this._lineItemNumber);
/* 259 */     id.setPropertyCode(this._propertyCode);
/* 260 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 268 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 272 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryCountSheetLineItemPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */