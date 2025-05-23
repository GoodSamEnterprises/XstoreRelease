/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.com.ReceiptTextId;
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
/*     */ public class ReceiptTextDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -593496219L;
/*     */   private Long _organizationId;
/*     */   private String _textCode;
/*     */   private Integer _textSequence;
/*     */   private String _textSubcode;
/*     */   private String _configElement;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _receiptText;
/*     */   private Date _effectiveDate;
/*     */   private Date _expirationDate;
/*     */   private String _lineFormat;
/*     */   private Boolean _reformat;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.text_code, t.text_seq, t.text_subcode, t.config_element, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.receipt_text, t.effective_date, t.expiration_date, t.line_format, t.reformat_flag FROM com_receipt_text t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND text_code = ?  AND text_seq = ?  AND text_subcode = ?  AND config_element = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  43 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  47 */     return "SELECT t.organization_id, t.text_code, t.text_seq, t.text_subcode, t.config_element, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.receipt_text, t.effective_date, t.expiration_date, t.line_format, t.reformat_flag FROM com_receipt_text t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  53 */     return " WHERE organization_id = ?  AND text_code = ?  AND text_seq = ?  AND text_subcode = ?  AND config_element = ?  ";
/*     */   }
/*     */   
/*  56 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO com_receipt_text(organization_id, text_code, text_seq, text_subcode, config_element, create_date, create_user_id, update_date, update_user_id, receipt_text, effective_date, expiration_date, line_format, reformat_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  59 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  63 */     Object[][] insertParameterObject = { { this._organizationId, this._textCode, this._textSequence, this._textSubcode, ObjectUtils.coalesce((Object[])new String[] { this._configElement, "*" }), this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._receiptText, this._effectiveDate, this._expirationDate, this._lineFormat, this._reformat } };
/*  64 */     return insertParameterObject;
/*     */   }
/*     */   
/*  67 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 4, 12, 12, 91, 12, 91, 12, 12, 91, 91, 12, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  70 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  73 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE com_receipt_text SET update_date = ?, update_user_id = ?, receipt_text = ?, effective_date = ?, expiration_date = ?, line_format = ?, reformat_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  76 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  80 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._receiptText, this._effectiveDate, this._expirationDate, this._lineFormat, this._reformat } };
/*  81 */     return updateParameterObject;
/*     */   }
/*     */   
/*  84 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 91, 91, 12, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  86 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  89 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM com_receipt_text" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND text_code = ?  AND text_seq = ?  AND text_subcode = ?  AND config_element = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  92 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  98 */     return " WHERE organization_id = ?  AND text_code = ?  AND text_seq = ?  AND text_subcode = ?  AND config_element = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 101 */     return new Object[] { this._organizationId, this._textCode, this._textSequence, this._textSubcode, ObjectUtils.coalesce((Object[])new String[] { this._configElement, "*" }) };
/*     */   }
/*     */   
/* 104 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 4, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 107 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 110 */     return "com_receipt_text";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 114 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 118 */     return new ReceiptTextFiller(this);
/*     */   }
/*     */   
/*     */   private static class ReceiptTextFiller
/*     */     implements IFiller {
/*     */     private ReceiptTextDBA _parent;
/*     */     
/*     */     public ReceiptTextFiller(ReceiptTextDBA argParent) {
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
/* 137 */       this._parent._textCode = argResultSet.getString(2);
/*     */ 
/*     */       
/* 140 */       int primitiveResult = argResultSet.getInt(3);
/* 141 */       if (primitiveResult != 0 || argResultSet.getObject(3) != null) {
/* 142 */         this._parent._textSequence = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 146 */       this._parent._textSubcode = argResultSet.getString(4);
/* 147 */       this._parent._configElement = argResultSet.getString(5);
/*     */       
/* 149 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 150 */       if (t6 != null) {
/* 151 */         this._parent._createDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 154 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 157 */       this._parent._createUserId = argResultSet.getString(7);
/*     */       
/* 159 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 160 */       if (t8 != null) {
/* 161 */         this._parent._updateDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 164 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 167 */       this._parent._updateUserId = argResultSet.getString(9);
/* 168 */       this._parent._receiptText = argResultSet.getString(10);
/*     */       
/* 170 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 171 */       if (t11 != null) {
/* 172 */         this._parent._effectiveDate = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 175 */         this._parent._effectiveDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 179 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 180 */       if (t12 != null) {
/* 181 */         this._parent._expirationDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 184 */         this._parent._expirationDate = null;
/*     */       } 
/*     */       
/* 187 */       this._parent._lineFormat = argResultSet.getString(13);
/* 188 */       this._parent._reformat = Boolean.valueOf(argResultSet.getBoolean(14));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 193 */     argDAO.suppressStateChanges(true);
/* 194 */     ReceiptTextDAO dao = (ReceiptTextDAO)argDAO;
/* 195 */     dao.setOrganizationId(this._organizationId);
/* 196 */     dao.setTextCode(this._textCode);
/* 197 */     dao.setTextSequence(this._textSequence);
/* 198 */     dao.setTextSubcode(this._textSubcode);
/* 199 */     dao.setConfigElement(this._configElement);
/* 200 */     dao.setCreateDate(this._createDate);
/* 201 */     dao.setCreateUserId(this._createUserId);
/* 202 */     dao.setUpdateDate(this._updateDate);
/* 203 */     dao.setUpdateUserId(this._updateUserId);
/* 204 */     dao.setReceiptText(this._receiptText);
/* 205 */     dao.setEffectiveDate(this._effectiveDate);
/* 206 */     dao.setExpirationDate(this._expirationDate);
/* 207 */     dao.setLineFormat(this._lineFormat);
/* 208 */     dao.setReformat(this._reformat);
/* 209 */     argDAO.suppressStateChanges(false);
/* 210 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 214 */     return loadDAO((IDataAccessObject)new ReceiptTextDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 218 */     ReceiptTextDAO dao = (ReceiptTextDAO)argDAO;
/* 219 */     this._organizationId = dao.getOrganizationId();
/* 220 */     this._textCode = dao.getTextCode();
/* 221 */     this._textSequence = dao.getTextSequence();
/* 222 */     this._textSubcode = dao.getTextSubcode();
/* 223 */     this._configElement = dao.getConfigElement();
/* 224 */     this._createDate = dao.getCreateDate();
/* 225 */     this._createUserId = dao.getCreateUserId();
/* 226 */     this._updateDate = dao.getUpdateDate();
/* 227 */     this._updateUserId = dao.getUpdateUserId();
/* 228 */     this._receiptText = dao.getReceiptText();
/* 229 */     this._effectiveDate = dao.getEffectiveDate();
/* 230 */     this._expirationDate = dao.getExpirationDate();
/* 231 */     this._lineFormat = dao.getLineFormat();
/* 232 */     this._reformat = (dao.getReformat() != null) ? dao.getReformat() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 236 */     ReceiptTextId id = (ReceiptTextId)argId;
/* 237 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 238 */     argStatement.setString(2, id.getTextCode());
/* 239 */     argStatement.setInt(3, id.getTextSequence().intValue());
/* 240 */     argStatement.setString(4, id.getTextSubcode());
/* 241 */     argStatement.setString(5, id.getConfigElement());
/* 242 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 246 */     ReceiptTextId id = new ReceiptTextId();
/* 247 */     id.setOrganizationId(this._organizationId);
/* 248 */     id.setTextCode(this._textCode);
/* 249 */     id.setTextSequence(this._textSequence);
/* 250 */     id.setTextSubcode(this._textSubcode);
/* 251 */     id.setConfigElement(this._configElement);
/* 252 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 260 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 264 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\ReceiptTextDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */