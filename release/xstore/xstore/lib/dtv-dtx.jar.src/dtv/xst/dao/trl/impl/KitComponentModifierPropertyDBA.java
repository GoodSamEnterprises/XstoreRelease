/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.KitComponentModifierPropertyId;
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
/*     */ public class KitComponentModifierPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1967630637L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private String _componentItemId;
/*     */   private Long _sequenceNumber;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.component_item_id, t.seq_nbr, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM trl_kit_component_mod_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  AND component_item_id = ?  AND seq_nbr = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  46 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  50 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.component_item_id, t.seq_nbr, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM trl_kit_component_mod_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  56 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  AND component_item_id = ?  AND seq_nbr = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  59 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trl_kit_component_mod_p(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, rtrans_lineitm_seq, component_item_id, seq_nbr, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  62 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  66 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence, this._componentItemId, this._sequenceNumber, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  67 */     return insertParameterObject;
/*     */   }
/*     */   
/*  70 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 4, 12, -5, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  73 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  76 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trl_kit_component_mod_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  79 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  83 */     Object[][] updateParameterObject = { { this._type, this._stringValue, this._dateValue, this._decimalValue, this._updateDate, this._updateUserId } };
/*  84 */     return updateParameterObject;
/*     */   }
/*     */   
/*  87 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 3, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  89 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  92 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trl_kit_component_mod_p" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  AND component_item_id = ?  AND seq_nbr = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  95 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 101 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  AND component_item_id = ?  AND seq_nbr = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 104 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence, this._componentItemId, this._sequenceNumber, this._propertyCode };
/*     */   }
/*     */   
/* 107 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5, 4, 12, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 110 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 113 */     return "trl_kit_component_mod_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 117 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 121 */     return new KitComponentModifierPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class KitComponentModifierPropertyFiller
/*     */     implements IFiller {
/*     */     private KitComponentModifierPropertyDBA _parent;
/*     */     
/*     */     public KitComponentModifierPropertyFiller(KitComponentModifierPropertyDBA argParent) {
/* 129 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 134 */       long primitiveResult = argResultSet.getLong(1);
/* 135 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 136 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 142 */       primitiveResult = argResultSet.getLong(2);
/* 143 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 144 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 149 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 150 */       if (t3 != null) {
/* 151 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 154 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 159 */       long l2 = argResultSet.getLong(4);
/* 160 */       if (l2 != 0L || argResultSet.getObject(4) != null) {
/* 161 */         this._parent._workstationId = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 167 */       l2 = argResultSet.getLong(5);
/* 168 */       if (l2 != 0L || argResultSet.getObject(5) != null) {
/* 169 */         this._parent._transactionSequence = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 175 */       int i = argResultSet.getInt(6);
/* 176 */       if (i != 0 || argResultSet.getObject(6) != null) {
/* 177 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 181 */       this._parent._componentItemId = argResultSet.getString(7);
/*     */ 
/*     */       
/* 184 */       long l1 = argResultSet.getLong(8);
/* 185 */       if (l1 != 0L || argResultSet.getObject(8) != null) {
/* 186 */         this._parent._sequenceNumber = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 190 */       this._parent._propertyCode = argResultSet.getString(9);
/* 191 */       this._parent._type = argResultSet.getString(10);
/* 192 */       this._parent._stringValue = argResultSet.getString(11);
/*     */       
/* 194 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 195 */       if (t12 != null) {
/* 196 */         this._parent._dateValue = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 199 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 202 */       this._parent._decimalValue = argResultSet.getBigDecimal(13);
/*     */       
/* 204 */       Timestamp t14 = argResultSet.getTimestamp(14);
/* 205 */       if (t14 != null) {
/* 206 */         this._parent._createDate = (Date)new DtvDate(t14.getTime());
/*     */       } else {
/*     */         
/* 209 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 212 */       this._parent._createUserId = argResultSet.getString(15);
/*     */       
/* 214 */       Timestamp t16 = argResultSet.getTimestamp(16);
/* 215 */       if (t16 != null) {
/* 216 */         this._parent._updateDate = (Date)new DtvDate(t16.getTime());
/*     */       } else {
/*     */         
/* 219 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 222 */       this._parent._updateUserId = argResultSet.getString(17);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 227 */     argDAO.suppressStateChanges(true);
/* 228 */     KitComponentModifierPropertyDAO dao = (KitComponentModifierPropertyDAO)argDAO;
/* 229 */     dao.setOrganizationId(this._organizationId);
/* 230 */     dao.setRetailLocationId(this._retailLocationId);
/* 231 */     dao.setBusinessDate(this._businessDate);
/* 232 */     dao.setWorkstationId(this._workstationId);
/* 233 */     dao.setTransactionSequence(this._transactionSequence);
/* 234 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 235 */     dao.setComponentItemId(this._componentItemId);
/* 236 */     dao.setSequenceNumber(this._sequenceNumber);
/* 237 */     dao.setPropertyCode(this._propertyCode);
/* 238 */     dao.setType(this._type);
/* 239 */     dao.setStringValue(this._stringValue);
/* 240 */     dao.setDateValue(this._dateValue);
/* 241 */     dao.setDecimalValue(this._decimalValue);
/* 242 */     dao.setCreateDate(this._createDate);
/* 243 */     dao.setCreateUserId(this._createUserId);
/* 244 */     dao.setUpdateDate(this._updateDate);
/* 245 */     dao.setUpdateUserId(this._updateUserId);
/* 246 */     argDAO.suppressStateChanges(false);
/* 247 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 251 */     return loadDAO((IDataAccessObject)new KitComponentModifierPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 255 */     KitComponentModifierPropertyDAO dao = (KitComponentModifierPropertyDAO)argDAO;
/* 256 */     this._organizationId = dao.getOrganizationId();
/* 257 */     this._retailLocationId = dao.getRetailLocationId();
/* 258 */     this._businessDate = dao.getBusinessDate();
/* 259 */     this._workstationId = dao.getWorkstationId();
/* 260 */     this._transactionSequence = dao.getTransactionSequence();
/* 261 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 262 */     this._componentItemId = dao.getComponentItemId();
/* 263 */     this._sequenceNumber = dao.getSequenceNumber();
/* 264 */     this._propertyCode = dao.getPropertyCode();
/* 265 */     this._type = dao.getType();
/* 266 */     this._stringValue = dao.getStringValue();
/* 267 */     this._dateValue = dao.getDateValue();
/* 268 */     this._decimalValue = dao.getDecimalValue();
/* 269 */     this._createDate = dao.getCreateDate();
/* 270 */     this._createUserId = dao.getCreateUserId();
/* 271 */     this._updateDate = dao.getUpdateDate();
/* 272 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 276 */     KitComponentModifierPropertyId id = (KitComponentModifierPropertyId)argId;
/* 277 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 278 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 279 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 280 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 281 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 282 */     argStatement.setInt(6, id.getRetailTransactionLineItemSequence().intValue());
/* 283 */     argStatement.setString(7, id.getComponentItemId());
/* 284 */     argStatement.setLong(8, id.getSequenceNumber().longValue());
/* 285 */     argStatement.setString(9, id.getPropertyCode());
/* 286 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 290 */     KitComponentModifierPropertyId id = new KitComponentModifierPropertyId();
/* 291 */     id.setOrganizationId(this._organizationId);
/* 292 */     id.setRetailLocationId(this._retailLocationId);
/* 293 */     id.setBusinessDate(this._businessDate);
/* 294 */     id.setWorkstationId(this._workstationId);
/* 295 */     id.setTransactionSequence(this._transactionSequence);
/* 296 */     id.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 297 */     id.setComponentItemId(this._componentItemId);
/* 298 */     id.setSequenceNumber(this._sequenceNumber);
/* 299 */     id.setPropertyCode(this._propertyCode);
/* 300 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 308 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 312 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\KitComponentModifierPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */