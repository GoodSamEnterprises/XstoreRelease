/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.com.ReasonCodeId;
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
/*     */ public class ReasonCodeDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1579364751L;
/*     */   private Long _organizationId;
/*     */   private String _reasonTypeCode;
/*     */   private String _reasonCode;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _configElement;
/*     */   private String _description;
/*     */   private String _commentRequired;
/*     */   private Integer _sortOrder;
/*     */   private String _parentCode;
/*     */   private String _glAccountNumber;
/*     */   private BigDecimal _minimumAmt;
/*     */   private BigDecimal _maximumAmt;
/*     */   private String _customerMessage;
/*     */   private String _inventoryActionCode;
/*     */   private String _inventoryLocationId;
/*     */   private String _inventoryBucketId;
/*     */   private Boolean _hidden;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.reason_typcode, t.reason_code, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.config_element, t.description, t.comment_req, t.sort_order, t.parent_code, t.gl_acct_nbr, t.minimum_amt, t.maximum_amt, t.cust_msg, t.inv_action_code, t.location_id, t.bucket_id, t.hidden_flag FROM com_reason_code t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND reason_typcode = ?  AND reason_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  49 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  53 */     return "SELECT t.organization_id, t.reason_typcode, t.reason_code, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.config_element, t.description, t.comment_req, t.sort_order, t.parent_code, t.gl_acct_nbr, t.minimum_amt, t.maximum_amt, t.cust_msg, t.inv_action_code, t.location_id, t.bucket_id, t.hidden_flag FROM com_reason_code t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  59 */     return " WHERE organization_id = ?  AND reason_typcode = ?  AND reason_code = ?  ";
/*     */   }
/*     */   
/*  62 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO com_reason_code(organization_id, reason_typcode, reason_code, create_date, create_user_id, update_date, update_user_id, config_element, description, comment_req, sort_order, parent_code, gl_acct_nbr, minimum_amt, maximum_amt, cust_msg, inv_action_code, location_id, bucket_id, hidden_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  65 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  69 */     Object[][] insertParameterObject = { { this._organizationId, this._reasonTypeCode, this._reasonCode, this._createDate, this._createUserId, this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._configElement, "*" }), this._description, this._commentRequired, this._sortOrder, this._parentCode, this._glAccountNumber, this._minimumAmt, this._maximumAmt, this._customerMessage, this._inventoryActionCode, this._inventoryLocationId, this._inventoryBucketId, this._hidden } };
/*  70 */     return insertParameterObject;
/*     */   }
/*     */   
/*  73 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 91, 12, 91, 12, 12, 12, 12, 4, 12, 12, 3, 3, 12, 12, 12, 12, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  76 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  79 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE com_reason_code SET update_date = ?, update_user_id = ?, config_element = ?, description = ?, comment_req = ?, sort_order = ?, parent_code = ?, gl_acct_nbr = ?, minimum_amt = ?, maximum_amt = ?, cust_msg = ?, inv_action_code = ?, location_id = ?, bucket_id = ?, hidden_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  82 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  86 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._configElement, "*" }), this._description, this._commentRequired, this._sortOrder, this._parentCode, this._glAccountNumber, this._minimumAmt, this._maximumAmt, this._customerMessage, this._inventoryActionCode, this._inventoryLocationId, this._inventoryBucketId, this._hidden } };
/*  87 */     return updateParameterObject;
/*     */   }
/*     */   
/*  90 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 4, 12, 12, 3, 3, 12, 12, 12, 12, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  92 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  95 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM com_reason_code" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND reason_typcode = ?  AND reason_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  98 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 104 */     return " WHERE organization_id = ?  AND reason_typcode = ?  AND reason_code = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 107 */     return new Object[] { this._organizationId, this._reasonTypeCode, this._reasonCode };
/*     */   }
/*     */   
/* 110 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 113 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 116 */     return "com_reason_code";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 120 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 124 */     return new ReasonCodeFiller(this);
/*     */   }
/*     */   
/*     */   private static class ReasonCodeFiller
/*     */     implements IFiller {
/*     */     private ReasonCodeDBA _parent;
/*     */     
/*     */     public ReasonCodeFiller(ReasonCodeDBA argParent) {
/* 132 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 137 */       long primitiveResult = argResultSet.getLong(1);
/* 138 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 139 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 143 */       this._parent._reasonTypeCode = argResultSet.getString(2);
/* 144 */       this._parent._reasonCode = argResultSet.getString(3);
/*     */       
/* 146 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 147 */       if (t4 != null) {
/* 148 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 151 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 154 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 156 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 157 */       if (t6 != null) {
/* 158 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 161 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 164 */       this._parent._updateUserId = argResultSet.getString(7);
/* 165 */       this._parent._configElement = argResultSet.getString(8);
/* 166 */       this._parent._description = argResultSet.getString(9);
/* 167 */       this._parent._commentRequired = argResultSet.getString(10);
/*     */ 
/*     */       
/* 170 */       int i = argResultSet.getInt(11);
/* 171 */       if (i != 0 || argResultSet.getObject(11) != null) {
/* 172 */         this._parent._sortOrder = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 176 */       this._parent._parentCode = argResultSet.getString(12);
/* 177 */       this._parent._glAccountNumber = argResultSet.getString(13);
/* 178 */       this._parent._minimumAmt = argResultSet.getBigDecimal(14);
/* 179 */       this._parent._maximumAmt = argResultSet.getBigDecimal(15);
/* 180 */       this._parent._customerMessage = argResultSet.getString(16);
/* 181 */       this._parent._inventoryActionCode = argResultSet.getString(17);
/* 182 */       this._parent._inventoryLocationId = argResultSet.getString(18);
/* 183 */       this._parent._inventoryBucketId = argResultSet.getString(19);
/* 184 */       this._parent._hidden = Boolean.valueOf(argResultSet.getBoolean(20));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 189 */     argDAO.suppressStateChanges(true);
/* 190 */     ReasonCodeDAO dao = (ReasonCodeDAO)argDAO;
/* 191 */     dao.setOrganizationId(this._organizationId);
/* 192 */     dao.setReasonTypeCode(this._reasonTypeCode);
/* 193 */     dao.setReasonCode(this._reasonCode);
/* 194 */     dao.setCreateDate(this._createDate);
/* 195 */     dao.setCreateUserId(this._createUserId);
/* 196 */     dao.setUpdateDate(this._updateDate);
/* 197 */     dao.setUpdateUserId(this._updateUserId);
/* 198 */     dao.setConfigElement(this._configElement);
/* 199 */     dao.setDescription(this._description);
/* 200 */     dao.setCommentRequired(this._commentRequired);
/* 201 */     dao.setSortOrder(this._sortOrder);
/* 202 */     dao.setParentCode(this._parentCode);
/* 203 */     dao.setGlAccountNumber(this._glAccountNumber);
/* 204 */     dao.setMinimumAmt(this._minimumAmt);
/* 205 */     dao.setMaximumAmt(this._maximumAmt);
/* 206 */     dao.setCustomerMessage(this._customerMessage);
/* 207 */     dao.setInventoryActionCode(this._inventoryActionCode);
/* 208 */     dao.setInventoryLocationId(this._inventoryLocationId);
/* 209 */     dao.setInventoryBucketId(this._inventoryBucketId);
/* 210 */     dao.setHidden(this._hidden);
/* 211 */     argDAO.suppressStateChanges(false);
/* 212 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 216 */     return loadDAO((IDataAccessObject)new ReasonCodeDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 220 */     ReasonCodeDAO dao = (ReasonCodeDAO)argDAO;
/* 221 */     this._organizationId = dao.getOrganizationId();
/* 222 */     this._reasonTypeCode = dao.getReasonTypeCode();
/* 223 */     this._reasonCode = dao.getReasonCode();
/* 224 */     this._createDate = dao.getCreateDate();
/* 225 */     this._createUserId = dao.getCreateUserId();
/* 226 */     this._updateDate = dao.getUpdateDate();
/* 227 */     this._updateUserId = dao.getUpdateUserId();
/* 228 */     this._configElement = dao.getConfigElement();
/* 229 */     this._description = dao.getDescription();
/* 230 */     this._commentRequired = dao.getCommentRequired();
/* 231 */     this._sortOrder = dao.getSortOrder();
/* 232 */     this._parentCode = dao.getParentCode();
/* 233 */     this._glAccountNumber = dao.getGlAccountNumber();
/* 234 */     this._minimumAmt = dao.getMinimumAmt();
/* 235 */     this._maximumAmt = dao.getMaximumAmt();
/* 236 */     this._customerMessage = dao.getCustomerMessage();
/* 237 */     this._inventoryActionCode = dao.getInventoryActionCode();
/* 238 */     this._inventoryLocationId = dao.getInventoryLocationId();
/* 239 */     this._inventoryBucketId = dao.getInventoryBucketId();
/* 240 */     this._hidden = (dao.getHidden() != null) ? dao.getHidden() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 244 */     ReasonCodeId id = (ReasonCodeId)argId;
/* 245 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 246 */     argStatement.setString(2, id.getReasonTypeCode());
/* 247 */     argStatement.setString(3, id.getReasonCode());
/* 248 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 252 */     ReasonCodeId id = new ReasonCodeId();
/* 253 */     id.setOrganizationId(this._organizationId);
/* 254 */     id.setReasonTypeCode(this._reasonTypeCode);
/* 255 */     id.setReasonCode(this._reasonCode);
/* 256 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 264 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 268 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\ReasonCodeDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */