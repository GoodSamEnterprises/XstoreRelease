/*     */ package dtv.xst.dao.cwo.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cwo.InvoiceLineItemPropertyId;
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
/*     */ public class InvoiceLineItemPropertyDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1391596873L;
/*     */   private Long _organizationId;
/*     */   private String _serviceLocationId;
/*     */   private String _invoiceNumber;
/*     */   private Integer _invoiceLineItemSequence;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private Date _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.service_loc_id, t.invoice_number, t.invoice_lineitm_seq, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM cwo_invoice_lineitm_p t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND service_loc_id = ?  AND invoice_number = ?  AND invoice_lineitm_seq = ?  AND property_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  42 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  46 */     return "SELECT t.organization_id, t.service_loc_id, t.invoice_number, t.invoice_lineitm_seq, t.property_code, t.type, t.string_value, t.date_value, t.decimal_value, t.create_date, t.create_user_id, t.update_date, t.update_user_id FROM cwo_invoice_lineitm_p t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  52 */     return " WHERE organization_id = ?  AND service_loc_id = ?  AND invoice_number = ?  AND invoice_lineitm_seq = ?  AND property_code = ?  ";
/*     */   }
/*     */   
/*  55 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO cwo_invoice_lineitm_p(organization_id, service_loc_id, invoice_number, invoice_lineitm_seq, property_code, type, string_value, date_value, decimal_value, create_date, create_user_id, update_date, update_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  58 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  62 */     Object[][] insertParameterObject = { { this._organizationId, this._serviceLocationId, this._invoiceNumber, this._invoiceLineItemSequence, this._propertyCode, this._type, this._stringValue, this._dateValue, this._decimalValue, this._createDate, this._createUserId, this._updateDate, this._updateUserId } };
/*  63 */     return insertParameterObject;
/*     */   }
/*     */   
/*  66 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 4, 12, 12, 12, 91, 3, 91, 12, 91, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  69 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  72 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE cwo_invoice_lineitm_p SET type = ?, string_value = ?, date_value = ?, decimal_value = ?, update_date = ?, update_user_id = ?" };
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
/*  88 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM cwo_invoice_lineitm_p" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND service_loc_id = ?  AND invoice_number = ?  AND invoice_lineitm_seq = ?  AND property_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  91 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  97 */     return " WHERE organization_id = ?  AND service_loc_id = ?  AND invoice_number = ?  AND invoice_lineitm_seq = ?  AND property_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 100 */     return new Object[] { this._organizationId, this._serviceLocationId, this._invoiceNumber, this._invoiceLineItemSequence, this._propertyCode };
/*     */   }
/*     */   
/* 103 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, 4, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 106 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 109 */     return "cwo_invoice_lineitm_p";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 113 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 117 */     return new InvoiceLineItemPropertyFiller(this);
/*     */   }
/*     */   
/*     */   private static class InvoiceLineItemPropertyFiller
/*     */     implements IFiller {
/*     */     private InvoiceLineItemPropertyDBA _parent;
/*     */     
/*     */     public InvoiceLineItemPropertyFiller(InvoiceLineItemPropertyDBA argParent) {
/* 125 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 130 */       long l = argResultSet.getLong(1);
/* 131 */       if (l != 0L || argResultSet.getObject(1) != null) {
/* 132 */         this._parent._organizationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */       
/* 136 */       this._parent._serviceLocationId = argResultSet.getString(2);
/* 137 */       this._parent._invoiceNumber = argResultSet.getString(3);
/*     */ 
/*     */       
/* 140 */       int primitiveResult = argResultSet.getInt(4);
/* 141 */       if (primitiveResult != 0 || argResultSet.getObject(4) != null) {
/* 142 */         this._parent._invoiceLineItemSequence = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 146 */       this._parent._propertyCode = argResultSet.getString(5);
/* 147 */       this._parent._type = argResultSet.getString(6);
/* 148 */       this._parent._stringValue = argResultSet.getString(7);
/*     */       
/* 150 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 151 */       if (t8 != null) {
/* 152 */         this._parent._dateValue = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 155 */         this._parent._dateValue = null;
/*     */       } 
/*     */       
/* 158 */       this._parent._decimalValue = argResultSet.getBigDecimal(9);
/*     */       
/* 160 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 161 */       if (t10 != null) {
/* 162 */         this._parent._createDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 165 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 168 */       this._parent._createUserId = argResultSet.getString(11);
/*     */       
/* 170 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 171 */       if (t12 != null) {
/* 172 */         this._parent._updateDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 175 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 178 */       this._parent._updateUserId = argResultSet.getString(13);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 183 */     argDAO.suppressStateChanges(true);
/* 184 */     InvoiceLineItemPropertyDAO dao = (InvoiceLineItemPropertyDAO)argDAO;
/* 185 */     dao.setOrganizationId(this._organizationId);
/* 186 */     dao.setServiceLocationId(this._serviceLocationId);
/* 187 */     dao.setInvoiceNumber(this._invoiceNumber);
/* 188 */     dao.setInvoiceLineItemSequence(this._invoiceLineItemSequence);
/* 189 */     dao.setPropertyCode(this._propertyCode);
/* 190 */     dao.setType(this._type);
/* 191 */     dao.setStringValue(this._stringValue);
/* 192 */     dao.setDateValue(this._dateValue);
/* 193 */     dao.setDecimalValue(this._decimalValue);
/* 194 */     dao.setCreateDate(this._createDate);
/* 195 */     dao.setCreateUserId(this._createUserId);
/* 196 */     dao.setUpdateDate(this._updateDate);
/* 197 */     dao.setUpdateUserId(this._updateUserId);
/* 198 */     argDAO.suppressStateChanges(false);
/* 199 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 203 */     return loadDAO((IDataAccessObject)new InvoiceLineItemPropertyDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 207 */     InvoiceLineItemPropertyDAO dao = (InvoiceLineItemPropertyDAO)argDAO;
/* 208 */     this._organizationId = dao.getOrganizationId();
/* 209 */     this._serviceLocationId = dao.getServiceLocationId();
/* 210 */     this._invoiceNumber = dao.getInvoiceNumber();
/* 211 */     this._invoiceLineItemSequence = dao.getInvoiceLineItemSequence();
/* 212 */     this._propertyCode = dao.getPropertyCode();
/* 213 */     this._type = dao.getType();
/* 214 */     this._stringValue = dao.getStringValue();
/* 215 */     this._dateValue = dao.getDateValue();
/* 216 */     this._decimalValue = dao.getDecimalValue();
/* 217 */     this._createDate = dao.getCreateDate();
/* 218 */     this._createUserId = dao.getCreateUserId();
/* 219 */     this._updateDate = dao.getUpdateDate();
/* 220 */     this._updateUserId = dao.getUpdateUserId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 224 */     InvoiceLineItemPropertyId id = (InvoiceLineItemPropertyId)argId;
/* 225 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 226 */     argStatement.setString(2, id.getServiceLocationId());
/* 227 */     argStatement.setString(3, id.getInvoiceNumber());
/* 228 */     argStatement.setInt(4, id.getInvoiceLineItemSequence().intValue());
/* 229 */     argStatement.setString(5, id.getPropertyCode());
/* 230 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 234 */     InvoiceLineItemPropertyId id = new InvoiceLineItemPropertyId();
/* 235 */     id.setOrganizationId(this._organizationId);
/* 236 */     id.setServiceLocationId(this._serviceLocationId);
/* 237 */     id.setInvoiceNumber(this._invoiceNumber);
/* 238 */     id.setInvoiceLineItemSequence(this._invoiceLineItemSequence);
/* 239 */     id.setPropertyCode(this._propertyCode);
/* 240 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 248 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 252 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\impl\InvoiceLineItemPropertyDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */