/*     */ package dtv.xst.dao.cwo.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IExtendedJDBCAdapter;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.util.ArrayUtils;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.CustomerAccountId;
/*     */ import dtv.xst.dao.cat.impl.CustomerItemAccountDBA;
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
/*     */ public class WorkOrderAccountDBA
/*     */   extends CustomerItemAccountDBA
/*     */   implements IExtendedJDBCAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -588729136L;
/*     */   private Long _organizationId;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _totalValueDao;
/*     */   private Date _estimatedCompletionDate;
/*     */   private BigDecimal _approvedWorkAmount;
/*     */   private Date _approvedWorkDate;
/*     */   private Date _lastCustomerNoticeDate;
/*     */   private String _contactMethodCode;
/*     */   private String _priorityCode;
/*     */   private String _serviceLocationId;
/*     */   private String _categoryId;
/*     */   private String _priceCodeString;
/*     */   private BigDecimal _cost;
/*     */   private String _invoiceNumber;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.cust_acct_id, t.cust_acct_code, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.total_value, t.estimated_completion_date, t.approved_work_amt, t.approved_work_date, t.last_cust_notice, t.contact_method_code, t.priority_code, t.service_loc_id, t.category_id, t.price_code, t.cost, t.invoice_number FROM cwo_work_order_acct t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  49 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  53 */     return "SELECT t.organization_id, t.cust_acct_id, t.cust_acct_code, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.total_value, t.estimated_completion_date, t.approved_work_amt, t.approved_work_date, t.last_cust_notice, t.contact_method_code, t.priority_code, t.service_loc_id, t.category_id, t.price_code, t.cost, t.invoice_number FROM cwo_work_order_acct t";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  60 */     return " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  ";
/*     */   }
/*     */   
/*  63 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO cwo_work_order_acct(organization_id, cust_acct_id, cust_acct_code, create_date, create_user_id, update_date, update_user_id, total_value, estimated_completion_date, approved_work_amt, approved_work_date, last_cust_notice, contact_method_code, priority_code, service_loc_id, category_id, price_code, cost, invoice_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */ 
/*     */   
/*     */   public String[] getInsert() {
/*  67 */     return (String[])ArrayUtils.combine((Object[])super.getInsert(), (Object[])INSERT_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  72 */     Object[][] insertParameterObject = { { this._organizationId, this._custAccountId, this._custAccountCode, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._totalValueDao, this._estimatedCompletionDate, this._approvedWorkAmount, this._approvedWorkDate, this._lastCustomerNoticeDate, this._contactMethodCode, this._priorityCode, this._serviceLocationId, this._categoryId, this._priceCodeString, this._cost, this._invoiceNumber } };
/*  73 */     return (Object[][])ArrayUtils.combine((Object[])super.getInsertParameters(), (Object[])insertParameterObject);
/*     */   }
/*     */   
/*  76 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 91, 12, 91, 12, 3, 91, 3, 91, 91, 12, 12, 12, 12, 12, 3, 12 } };
/*     */ 
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  80 */     return (int[][])ArrayUtils.combine((Object[])super.getInsertParameterTypes(), (Object[])INSERT_PARAMETER_TYPES_OBJECT);
/*     */   }
/*     */   
/*  83 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE cwo_work_order_acct SET update_date = ?, update_user_id = ?, total_value = ?, estimated_completion_date = ?, approved_work_amt = ?, approved_work_date = ?, last_cust_notice = ?, contact_method_code = ?, priority_code = ?, service_loc_id = ?, category_id = ?, price_code = ?, cost = ?, invoice_number = ?" };
/*     */ 
/*     */   
/*     */   public String[] getUpdate() {
/*  87 */     return (String[])ArrayUtils.combine((Object[])super.getUpdate(), (Object[])UPDATE_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  92 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._totalValueDao, this._estimatedCompletionDate, this._approvedWorkAmount, this._approvedWorkDate, this._lastCustomerNoticeDate, this._contactMethodCode, this._priorityCode, this._serviceLocationId, this._categoryId, this._priceCodeString, this._cost, this._invoiceNumber } };
/*  93 */     return (Object[][])ArrayUtils.combine((Object[])super.getUpdateParameters(), (Object[])updateParameterObject);
/*     */   }
/*     */   
/*  96 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 3, 91, 3, 91, 91, 12, 12, 12, 12, 12, 3, 12 } };
/*     */   
/*     */   public int[][] getUpdateParameterTypes() {
/*  99 */     return (int[][])ArrayUtils.combine((Object[])super.getUpdateParameterTypes(), (Object[])UPDATE_PARAMETER_TYPE_OBJECT);
/*     */   }
/*     */   
/* 102 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM cwo_work_order_acct" };
/*     */   private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 106 */     return (String[])ArrayUtils.combine((Object[])super.getDelete(), (Object[])DELETE_OBJECT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 113 */     return " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  ";
/*     */   }
/*     */   
/*     */   public Object[] getWhereParameters() {
/* 117 */     return new Object[] { this._organizationId, this._custAccountId, this._custAccountCode };
/*     */   }
/*     */   
/* 120 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12 };
/*     */ 
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 124 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 128 */     return "cwo_work_order_acct";
/*     */   }
/*     */ 
/*     */   
/*     */   public IFiller getFiller() {
/* 133 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 137 */     return new WorkOrderAccountFiller(this);
/*     */   }
/*     */   
/*     */   private static class WorkOrderAccountFiller
/*     */     implements IFiller {
/*     */     private WorkOrderAccountDBA _parent;
/*     */     
/*     */     public WorkOrderAccountFiller(WorkOrderAccountDBA argParent) {
/* 145 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 150 */       long primitiveResult = argResultSet.getLong(1);
/* 151 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 152 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 156 */       this._parent._custAccountId = argResultSet.getString(2);
/* 157 */       this._parent._custAccountCode = argResultSet.getString(3);
/*     */       
/* 159 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 160 */       if (t4 != null) {
/* 161 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 164 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 167 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 169 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 170 */       if (t6 != null) {
/* 171 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 174 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 177 */       this._parent._updateUserId = argResultSet.getString(7);
/* 178 */       this._parent._totalValueDao = argResultSet.getBigDecimal(8);
/*     */       
/* 180 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 181 */       if (t9 != null) {
/* 182 */         this._parent._estimatedCompletionDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 185 */         this._parent._estimatedCompletionDate = null;
/*     */       } 
/*     */       
/* 188 */       this._parent._approvedWorkAmount = argResultSet.getBigDecimal(10);
/*     */       
/* 190 */       Timestamp t11 = argResultSet.getTimestamp(11);
/* 191 */       if (t11 != null) {
/* 192 */         this._parent._approvedWorkDate = (Date)new DtvDate(t11.getTime());
/*     */       } else {
/*     */         
/* 195 */         this._parent._approvedWorkDate = null;
/*     */       } 
/*     */ 
/*     */       
/* 199 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 200 */       if (t12 != null) {
/* 201 */         this._parent._lastCustomerNoticeDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 204 */         this._parent._lastCustomerNoticeDate = null;
/*     */       } 
/*     */       
/* 207 */       this._parent._contactMethodCode = argResultSet.getString(13);
/* 208 */       this._parent._priorityCode = argResultSet.getString(14);
/* 209 */       this._parent._serviceLocationId = argResultSet.getString(15);
/* 210 */       this._parent._categoryId = argResultSet.getString(16);
/* 211 */       this._parent._priceCodeString = argResultSet.getString(17);
/* 212 */       this._parent._cost = argResultSet.getBigDecimal(18);
/* 213 */       this._parent._invoiceNumber = argResultSet.getString(19);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 219 */     super.loadDAO(argDAO);
/* 220 */     argDAO.suppressStateChanges(true);
/* 221 */     WorkOrderAccountDAO dao = (WorkOrderAccountDAO)argDAO;
/* 222 */     dao.setOrganizationId(this._organizationId);
/* 223 */     dao.setCustAccountId(this._custAccountId);
/* 224 */     dao.setCustAccountCode(this._custAccountCode);
/* 225 */     dao.setCreateDate(this._createDate);
/* 226 */     dao.setCreateUserId(this._createUserId);
/* 227 */     dao.setUpdateDate(this._updateDate);
/* 228 */     dao.setUpdateUserId(this._updateUserId);
/* 229 */     dao.setTotalValueDao(this._totalValueDao);
/* 230 */     dao.setEstimatedCompletionDate(this._estimatedCompletionDate);
/* 231 */     dao.setApprovedWorkAmount(this._approvedWorkAmount);
/* 232 */     dao.setApprovedWorkDate(this._approvedWorkDate);
/* 233 */     dao.setLastCustomerNoticeDate(this._lastCustomerNoticeDate);
/* 234 */     dao.setContactMethodCode(this._contactMethodCode);
/* 235 */     dao.setPriorityCode(this._priorityCode);
/* 236 */     dao.setServiceLocationId(this._serviceLocationId);
/* 237 */     dao.setCategoryId(this._categoryId);
/* 238 */     dao.setPriceCodeString(this._priceCodeString);
/* 239 */     dao.setCost(this._cost);
/* 240 */     dao.setInvoiceNumber(this._invoiceNumber);
/* 241 */     argDAO.suppressStateChanges(false);
/* 242 */     return (IDataAccessObject)dao;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 247 */     return loadDAO((IDataAccessObject)new WorkOrderAccountDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 252 */     WorkOrderAccountDAO dao = (WorkOrderAccountDAO)argDAO;
/* 253 */     super.fill((IDataAccessObject)dao);
/* 254 */     this._organizationId = dao.getOrganizationId();
/* 255 */     this._custAccountId = dao.getCustAccountId();
/* 256 */     this._custAccountCode = dao.getCustAccountCode();
/* 257 */     this._createDate = dao.getCreateDate();
/* 258 */     this._createUserId = dao.getCreateUserId();
/* 259 */     this._updateDate = dao.getUpdateDate();
/* 260 */     this._updateUserId = dao.getUpdateUserId();
/* 261 */     this._totalValueDao = dao.getTotalValueDao();
/* 262 */     this._estimatedCompletionDate = dao.getEstimatedCompletionDate();
/* 263 */     this._approvedWorkAmount = dao.getApprovedWorkAmount();
/* 264 */     this._approvedWorkDate = dao.getApprovedWorkDate();
/* 265 */     this._lastCustomerNoticeDate = dao.getLastCustomerNoticeDate();
/* 266 */     this._contactMethodCode = dao.getContactMethodCode();
/* 267 */     this._priorityCode = dao.getPriorityCode();
/* 268 */     this._serviceLocationId = dao.getServiceLocationId();
/* 269 */     this._categoryId = dao.getCategoryId();
/* 270 */     this._priceCodeString = dao.getPriceCodeString();
/* 271 */     this._cost = dao.getCost();
/* 272 */     this._invoiceNumber = dao.getInvoiceNumber();
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 277 */     CustomerAccountId id = (CustomerAccountId)argId;
/* 278 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 279 */     argStatement.setString(2, id.getCustAccountId());
/* 280 */     argStatement.setString(3, id.getCustAccountCode());
/* 281 */     return argStatement;
/*     */   }
/*     */   
/*     */   public String[] getAllSelects() {
/* 285 */     String[] sels = super.getAllSelects();
/* 286 */     String[] result = new String[sels.length + 1];
/* 287 */     result[0] = getSelectImpl();
/* 288 */     System.arraycopy(sels, 0, result, 1, sels.length);
/* 289 */     return result;
/*     */   }
/*     */   
/*     */   public IFiller[] getAllFillers() {
/* 293 */     IFiller[] fills = super.getAllFillers();
/* 294 */     IFiller[] result = new IFiller[fills.length + 1];
/* 295 */     result[0] = getFillerImpl();
/* 296 */     System.arraycopy(fills, 0, result, 1, fills.length);
/* 297 */     return result;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\impl\WorkOrderAccountDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */