/*     */ package dtv.xst.dao.trn.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trn.PosTransactionLinkPropertyId;
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
/*     */ public class PosTransactionLinkPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1196197145L;
/*     */   private Date _businessDate;
/*     */   private Date _linkBusinessDate;
/*     */   private Long _linkRetailLocationId;
/*     */   private Long _linkTransactionSequence;
/*     */   private Long _linkWorkstationId;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.business_date, t.link_business_date, t.link_rtl_loc_id, t.link_trans_seq, t.link_wkstn_id, t.organization_id, t.rtl_loc_id, t.trans_seq, t.wkstn_id, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM trn_trans_link_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE business_date = ?  AND link_business_date = ?  AND link_rtl_loc_id = ?  AND link_trans_seq = ?  AND link_wkstn_id = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND trans_seq = ?  AND wkstn_id = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  47 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  51 */     return "SELECT t.business_date, t.link_business_date, t.link_rtl_loc_id, t.link_trans_seq, t.link_wkstn_id, t.organization_id, t.rtl_loc_id, t.trans_seq, t.wkstn_id, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM trn_trans_link_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  57 */     return " WHERE business_date = ?  AND link_business_date = ?  AND link_rtl_loc_id = ?  AND link_trans_seq = ?  AND link_wkstn_id = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND trans_seq = ?  AND wkstn_id = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  60 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trn_trans_link_p(business_date, link_business_date, link_rtl_loc_id, link_trans_seq, link_wkstn_id, organization_id, rtl_loc_id, trans_seq, wkstn_id, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  63 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  67 */     Object[][] insertParameterObject = { { this._businessDate, this._linkBusinessDate, this._linkRetailLocationId, this._linkTransactionSequence, this._linkWorkstationId, this._organizationId, this._retailLocationId, this._transactionSequence, this._workstationId, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  68 */     return insertParameterObject;
/*     */   }
/*     */   
/*  71 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 91, 91, -5, -5, -5, -5, -5, -5, -5, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  74 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  77 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trn_trans_link_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  80 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  84 */     Object[][] updateParameterObject = { { this._type, this._stringValue, this._dateValue, this._decimalValue, this._updateDate, this._updateUserId } };
/*  85 */     return updateParameterObject;
/*     */   }
/*     */   
/*  88 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 12, 12, 91, 3, 91, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  90 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  93 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trn_trans_link_p" }; private static final String WHERE_OBJECT = " WHERE business_date = ?  AND link_business_date = ?  AND link_rtl_loc_id = ?  AND link_trans_seq = ?  AND link_wkstn_id = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND trans_seq = ?  AND wkstn_id = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  96 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 102 */     return " WHERE business_date = ?  AND link_business_date = ?  AND link_rtl_loc_id = ?  AND link_trans_seq = ?  AND link_wkstn_id = ?  AND organization_id = ?  AND rtl_loc_id = ?  AND trans_seq = ?  AND wkstn_id = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 105 */     return new Object[] { this._businessDate, this._linkBusinessDate, this._linkRetailLocationId, this._linkTransactionSequence, this._linkWorkstationId, this._organizationId, this._retailLocationId, this._transactionSequence, this._workstationId, this._propertyCode };
/*     */   }
/*     */   
/* 108 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 91, 91, -5, -5, -5, -5, -5, -5, -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 111 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 114 */     return "trn_trans_link_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 118 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 122 */     return new PosTransactionLinkPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class PosTransactionLinkPropertyFiller
/*     */     implements IFiller {
/*     */     private PosTransactionLinkPropertyDBA _parent;
/*     */     
/*     */     public PosTransactionLinkPropertyFiller(PosTransactionLinkPropertyDBA argParent) {
/* 130 */       this._parent = argParent;
/*     */     }
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 134 */       Timestamp t1 = argResultSet.getTimestamp(1);
/* 135 */       if (t1 != null) {
/* 136 */         this._parent._businessDate = (Date)new DtvDate(t1.getTime());
/*     */       } else {
/*     */         
/* 139 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 143 */       Timestamp t2 = argResultSet.getTimestamp(2);
/* 144 */       if (t2 != null) {
/* 145 */         this._parent._linkBusinessDate = (Date)new DtvDate(t2.getTime());
/*     */       } else {
/*     */         
/* 148 */         this._parent._linkBusinessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 153 */       long primitiveResult = argResultSet.getLong(3);
/* 154 */       if (primitiveResult != 0L || argResultSet.getObject(3) != null) {
/* 155 */         this._parent._linkRetailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 161 */       primitiveResult = argResultSet.getLong(4);
/* 162 */       if (primitiveResult != 0L || argResultSet.getObject(4) != null) {
/* 163 */         this._parent._linkTransactionSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 169 */       primitiveResult = argResultSet.getLong(5);
/* 170 */       if (primitiveResult != 0L || argResultSet.getObject(5) != null) {
/* 171 */         this._parent._linkWorkstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 177 */       primitiveResult = argResultSet.getLong(6);
/* 178 */       if (primitiveResult != 0L || argResultSet.getObject(6) != null) {
/* 179 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 185 */       primitiveResult = argResultSet.getLong(7);
/* 186 */       if (primitiveResult != 0L || argResultSet.getObject(7) != null) {
/* 187 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 193 */       primitiveResult = argResultSet.getLong(8);
/* 194 */       if (primitiveResult != 0L || argResultSet.getObject(8) != null) {
/* 195 */         this._parent._transactionSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 201 */       primitiveResult = argResultSet.getLong(9);
/* 202 */       if (primitiveResult != 0L || argResultSet.getObject(9) != null) {
/* 203 */         this._parent._workstationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 207 */       this._parent._propertyCode = argResultSet.getString(10);
/* 208 */       this._parent._type = argResultSet.getString(11);
/* 209 */       this._parent._stringValue = argResultSet.getString(12);
/*     */       
/* 211 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 212 */       if (t13 != null) {
/* 213 */         this._parent._dateValue = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 216 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 219 */       this._parent._decimalValue = argResultSet.getBigDecimal(14);
/*     */       
/* 221 */       Timestamp t15 = argResultSet.getTimestamp(15);
/* 222 */       if (t15 != null) {
/* 223 */         this._parent._createDate = (Date)new DtvDate(t15.getTime());
/*     */       } else {
/*     */         
/* 226 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 229 */       this._parent._createUserId = argResultSet.getString(16);
/*     */       
/* 231 */       Timestamp t17 = argResultSet.getTimestamp(17);
/* 232 */       if (t17 != null) {
/* 233 */         this._parent._updateDate = (Date)new DtvDate(t17.getTime());
/*     */       } else {
/*     */         
/* 236 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 239 */       this._parent._updateUserId = argResultSet.getString(18);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 244 */     argDAO.suppressStateChanges(true);
/* 245 */     PosTransactionLinkPropertyDAO dao = (PosTransactionLinkPropertyDAO)argDAO;
/* 246 */     dao.setBusinessDate(this._businessDate);
/* 247 */     dao.setLinkBusinessDate(this._linkBusinessDate);
/* 248 */     dao.setLinkRetailLocationId(this._linkRetailLocationId);
/* 249 */     dao.setLinkTransactionSequence(this._linkTransactionSequence);
/* 250 */     dao.setLinkWorkstationId(this._linkWorkstationId);
/* 251 */     dao.setOrganizationId(this._organizationId);
/* 252 */     dao.setRetailLocationId(this._retailLocationId);
/* 253 */     dao.setTransactionSequence(this._transactionSequence);
/* 254 */     dao.setWorkstationId(this._workstationId);
/* 255 */     dao.setPropertyCode(this._propertyCode);
/* 256 */     dao.setType(this._type);
/* 257 */     dao.setStringValue(this._stringValue);
/* 258 */     dao.setDateValue(this._dateValue);
/* 259 */     dao.setDecimalValue(this._decimalValue);
/* 260 */     dao.setCreateDate(this._createDate);
/* 261 */     dao.setCreateUserId(this._createUserId);
/* 262 */     dao.setUpdateDate(this._updateDate);
/* 263 */     dao.setUpdateUserId(this._updateUserId);
/* 264 */     argDAO.suppressStateChanges(false);
/* 265 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 269 */     return loadDAO((IDataAccessObject)new PosTransactionLinkPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 273 */     PosTransactionLinkPropertyDAO dao = (PosTransactionLinkPropertyDAO)argDAO;
/* 274 */     this._businessDate = dao.getBusinessDate();
/* 275 */     this._linkBusinessDate = dao.getLinkBusinessDate();
/* 276 */     this._linkRetailLocationId = dao.getLinkRetailLocationId();
/* 277 */     this._linkTransactionSequence = dao.getLinkTransactionSequence();
/* 278 */     this._linkWorkstationId = dao.getLinkWorkstationId();
/* 279 */     this._organizationId = dao.getOrganizationId();
/* 280 */     this._retailLocationId = dao.getRetailLocationId();
/* 281 */     this._transactionSequence = dao.getTransactionSequence();
/* 282 */     this._workstationId = dao.getWorkstationId();
/* 283 */     this._propertyCode = dao.getPropertyCode();
/* 284 */     this._type = dao.getType();
/* 285 */     this._stringValue = dao.getStringValue();
/* 286 */     this._dateValue = dao.getDateValue();
/* 287 */     this._decimalValue = dao.getDecimalValue();
/* 288 */     this._createDate = dao.getCreateDate();
/* 289 */     this._createUserId = dao.getCreateUserId();
/* 290 */     this._updateDate = dao.getUpdateDate();
/* 291 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 295 */     PosTransactionLinkPropertyId id = (PosTransactionLinkPropertyId)argId;
/* 296 */     argStatement.setTimestamp(1, new Timestamp(id.getBusinessDate().getTime()));
/* 297 */     argStatement.setTimestamp(2, new Timestamp(id.getLinkBusinessDate().getTime()));
/* 298 */     argStatement.setLong(3, id.getLinkRetailLocationId().longValue());
/* 299 */     argStatement.setLong(4, id.getLinkTransactionSequence().longValue());
/* 300 */     argStatement.setLong(5, id.getLinkWorkstationId().longValue());
/* 301 */     argStatement.setLong(6, id.getOrganizationId().longValue());
/* 302 */     argStatement.setLong(7, id.getRetailLocationId().longValue());
/* 303 */     argStatement.setLong(8, id.getTransactionSequence().longValue());
/* 304 */     argStatement.setLong(9, id.getWorkstationId().longValue());
/* 305 */     argStatement.setString(10, id.getPropertyCode());
/* 306 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 310 */     PosTransactionLinkPropertyId id = new PosTransactionLinkPropertyId();
/* 311 */     id.setBusinessDate(this._businessDate);
/* 312 */     id.setLinkBusinessDate(this._linkBusinessDate);
/* 313 */     id.setLinkRetailLocationId(this._linkRetailLocationId);
/* 314 */     id.setLinkTransactionSequence(this._linkTransactionSequence);
/* 315 */     id.setLinkWorkstationId(this._linkWorkstationId);
/* 316 */     id.setOrganizationId(this._organizationId);
/* 317 */     id.setRetailLocationId(this._retailLocationId);
/* 318 */     id.setTransactionSequence(this._transactionSequence);
/* 319 */     id.setWorkstationId(this._workstationId);
/* 320 */     id.setPropertyCode(this._propertyCode);
/* 321 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 329 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 333 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\PosTransactionLinkPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */