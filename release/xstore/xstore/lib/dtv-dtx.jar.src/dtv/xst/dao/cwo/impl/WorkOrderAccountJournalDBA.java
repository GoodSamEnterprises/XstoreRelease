/*     */ package dtv.xst.dao.cwo.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IExtendedJDBCAdapter;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.util.ArrayUtils;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.CustomerAccountJournalId;
/*     */ import dtv.xst.dao.cat.impl.CustomerItemAccountJournalDBA;
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
/*     */ public class WorkOrderAccountJournalDBA
/*     */   extends CustomerItemAccountJournalDBA
/*     */   implements IExtendedJDBCAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 389449799L;
/*     */   private Long _organizationId;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private Long _journalSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _totalValue;
/*     */   private Date _estimatedCompletionDate;
/*     */   private BigDecimal _approvedWorkAmount;
/*     */   private Date _approvedWorkDate;
/*     */   private String _priorityCode;
/*     */   private String _contactMethod;
/*     */   private Date _lastCustomerNoticeDate;
/*     */   private String _categoryId;
/*     */   private String _serviceLocationId;
/*     */   private String _priceCodeString;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.cust_acct_id, t.cust_acct_code, t.journal_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.total_value, t.estimated_completion_date, t.approved_work_amt, t.approved_work_date, t.priority_code, t.contact_method, t.last_cust_notice, t.category_id, t.service_loc_id, t.price_code FROM cwo_work_order_acct_journal t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND journal_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  48 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  52 */     return "SELECT t.organization_id, t.cust_acct_id, t.cust_acct_code, t.journal_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.total_value, t.estimated_completion_date, t.approved_work_amt, t.approved_work_date, t.priority_code, t.contact_method, t.last_cust_notice, t.category_id, t.service_loc_id, t.price_code FROM cwo_work_order_acct_journal t";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  59 */     return " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND journal_seq = ?  ";
/*     */   }
/*     */   
/*  62 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO cwo_work_order_acct_journal(organization_id, cust_acct_id, cust_acct_code, journal_seq, create_date, create_user_id, update_date, update_user_id, total_value, estimated_completion_date, approved_work_amt, approved_work_date, priority_code, contact_method, last_cust_notice, category_id, service_loc_id, price_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */ 
/*     */   
/*     */   public String[] getInsert() {
/*  66 */     return (String[])ArrayUtils.combine((Object[])super.getInsert(), (Object[])INSERT_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  71 */     Object[][] insertParameterObject = { { this._organizationId, this._custAccountId, this._custAccountCode, this._journalSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._totalValue, this._estimatedCompletionDate, this._approvedWorkAmount, this._approvedWorkDate, this._priorityCode, this._contactMethod, this._lastCustomerNoticeDate, this._categoryId, this._serviceLocationId, this._priceCodeString } };
/*  72 */     return (Object[][])ArrayUtils.combine((Object[])super.getInsertParameters(), (Object[])insertParameterObject);
/*     */   }
/*     */   
/*  75 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, -5, 91, 12, 91, 12, 3, 91, 3, 91, 12, 12, 91, 12, 12, 12 } };
/*     */ 
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  79 */     return (int[][])ArrayUtils.combine((Object[])super.getInsertParameterTypes(), (Object[])INSERT_PARAMETER_TYPES_OBJECT);
/*     */   }
/*     */   
/*  82 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE cwo_work_order_acct_journal SET update_date = ?, update_user_id = ?, total_value = ?, estimated_completion_date = ?, approved_work_amt = ?, approved_work_date = ?, priority_code = ?, contact_method = ?, last_cust_notice = ?, category_id = ?, service_loc_id = ?, price_code = ?" };
/*     */ 
/*     */   
/*     */   public String[] getUpdate() {
/*  86 */     return (String[])ArrayUtils.combine((Object[])super.getUpdate(), (Object[])UPDATE_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  91 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._totalValue, this._estimatedCompletionDate, this._approvedWorkAmount, this._approvedWorkDate, this._priorityCode, this._contactMethod, this._lastCustomerNoticeDate, this._categoryId, this._serviceLocationId, this._priceCodeString } };
/*  92 */     return (Object[][])ArrayUtils.combine((Object[])super.getUpdateParameters(), (Object[])updateParameterObject);
/*     */   }
/*     */   
/*  95 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 3, 91, 3, 91, 12, 12, 91, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getUpdateParameterTypes() {
/*  98 */     return (int[][])ArrayUtils.combine((Object[])super.getUpdateParameterTypes(), (Object[])UPDATE_PARAMETER_TYPE_OBJECT);
/*     */   }
/*     */   
/* 101 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM cwo_work_order_acct_journal" };
/*     */   private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND journal_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 105 */     return (String[])ArrayUtils.combine((Object[])super.getDelete(), (Object[])DELETE_OBJECT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 112 */     return " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND journal_seq = ?  ";
/*     */   }
/*     */   
/*     */   public Object[] getWhereParameters() {
/* 116 */     return new Object[] { this._organizationId, this._custAccountId, this._custAccountCode, this._journalSequence };
/*     */   }
/*     */   
/* 119 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, -5 };
/*     */ 
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 123 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 127 */     return "cwo_work_order_acct_journal";
/*     */   }
/*     */ 
/*     */   
/*     */   public IFiller getFiller() {
/* 132 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 136 */     return new WorkOrderAccountJournalFiller(this);
/*     */   }
/*     */   
/*     */   private static class WorkOrderAccountJournalFiller
/*     */     implements IFiller {
/*     */     private WorkOrderAccountJournalDBA _parent;
/*     */     
/*     */     public WorkOrderAccountJournalFiller(WorkOrderAccountJournalDBA argParent) {
/* 144 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 149 */       long primitiveResult = argResultSet.getLong(1);
/* 150 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 151 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 155 */       this._parent._custAccountId = argResultSet.getString(2);
/* 156 */       this._parent._custAccountCode = argResultSet.getString(3);
/*     */ 
/*     */       
/* 159 */       primitiveResult = argResultSet.getLong(4);
/* 160 */       if (primitiveResult != 0L || argResultSet.getObject(4) != null) {
/* 161 */         this._parent._journalSequence = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 166 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 167 */       if (t5 != null) {
/* 168 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 171 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 174 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 176 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 177 */       if (t7 != null) {
/* 178 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 181 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 184 */       this._parent._updateUserId = argResultSet.getString(8);
/* 185 */       this._parent._totalValue = argResultSet.getBigDecimal(9);
/*     */       
/* 187 */       Timestamp t10 = argResultSet.getTimestamp(10);
/* 188 */       if (t10 != null) {
/* 189 */         this._parent._estimatedCompletionDate = (Date)new DtvDate(t10.getTime());
/*     */       } else {
/*     */         
/* 192 */         this._parent._estimatedCompletionDate = null;
/*     */       } 
/*     */       
/* 195 */       this._parent._approvedWorkAmount = argResultSet.getBigDecimal(11);
/*     */       
/* 197 */       Timestamp t12 = argResultSet.getTimestamp(12);
/* 198 */       if (t12 != null) {
/* 199 */         this._parent._approvedWorkDate = (Date)new DtvDate(t12.getTime());
/*     */       } else {
/*     */         
/* 202 */         this._parent._approvedWorkDate = null;
/*     */       } 
/*     */       
/* 205 */       this._parent._priorityCode = argResultSet.getString(13);
/* 206 */       this._parent._contactMethod = argResultSet.getString(14);
/*     */       
/* 208 */       Timestamp t15 = argResultSet.getTimestamp(15);
/* 209 */       if (t15 != null) {
/* 210 */         this._parent._lastCustomerNoticeDate = (Date)new DtvDate(t15.getTime());
/*     */       } else {
/*     */         
/* 213 */         this._parent._lastCustomerNoticeDate = null;
/*     */       } 
/*     */       
/* 216 */       this._parent._categoryId = argResultSet.getString(16);
/* 217 */       this._parent._serviceLocationId = argResultSet.getString(17);
/* 218 */       this._parent._priceCodeString = argResultSet.getString(18);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 224 */     super.loadDAO(argDAO);
/* 225 */     argDAO.suppressStateChanges(true);
/* 226 */     WorkOrderAccountJournalDAO dao = (WorkOrderAccountJournalDAO)argDAO;
/* 227 */     dao.setOrganizationId(this._organizationId);
/* 228 */     dao.setCustAccountId(this._custAccountId);
/* 229 */     dao.setCustAccountCode(this._custAccountCode);
/* 230 */     dao.setJournalSequence(this._journalSequence);
/* 231 */     dao.setCreateDate(this._createDate);
/* 232 */     dao.setCreateUserId(this._createUserId);
/* 233 */     dao.setUpdateDate(this._updateDate);
/* 234 */     dao.setUpdateUserId(this._updateUserId);
/* 235 */     dao.setTotalValue(this._totalValue);
/* 236 */     dao.setEstimatedCompletionDate(this._estimatedCompletionDate);
/* 237 */     dao.setApprovedWorkAmount(this._approvedWorkAmount);
/* 238 */     dao.setApprovedWorkDate(this._approvedWorkDate);
/* 239 */     dao.setPriorityCode(this._priorityCode);
/* 240 */     dao.setContactMethod(this._contactMethod);
/* 241 */     dao.setLastCustomerNoticeDate(this._lastCustomerNoticeDate);
/* 242 */     dao.setCategoryId(this._categoryId);
/* 243 */     dao.setServiceLocationId(this._serviceLocationId);
/* 244 */     dao.setPriceCodeString(this._priceCodeString);
/* 245 */     argDAO.suppressStateChanges(false);
/* 246 */     return (IDataAccessObject)dao;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 251 */     return loadDAO((IDataAccessObject)new WorkOrderAccountJournalDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 256 */     WorkOrderAccountJournalDAO dao = (WorkOrderAccountJournalDAO)argDAO;
/* 257 */     super.fill((IDataAccessObject)dao);
/* 258 */     this._organizationId = dao.getOrganizationId();
/* 259 */     this._custAccountId = dao.getCustAccountId();
/* 260 */     this._custAccountCode = dao.getCustAccountCode();
/* 261 */     this._journalSequence = dao.getJournalSequence();
/* 262 */     this._createDate = dao.getCreateDate();
/* 263 */     this._createUserId = dao.getCreateUserId();
/* 264 */     this._updateDate = dao.getUpdateDate();
/* 265 */     this._updateUserId = dao.getUpdateUserId();
/* 266 */     this._totalValue = dao.getTotalValue();
/* 267 */     this._estimatedCompletionDate = dao.getEstimatedCompletionDate();
/* 268 */     this._approvedWorkAmount = dao.getApprovedWorkAmount();
/* 269 */     this._approvedWorkDate = dao.getApprovedWorkDate();
/* 270 */     this._priorityCode = dao.getPriorityCode();
/* 271 */     this._contactMethod = dao.getContactMethod();
/* 272 */     this._lastCustomerNoticeDate = dao.getLastCustomerNoticeDate();
/* 273 */     this._categoryId = dao.getCategoryId();
/* 274 */     this._serviceLocationId = dao.getServiceLocationId();
/* 275 */     this._priceCodeString = dao.getPriceCodeString();
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 280 */     CustomerAccountJournalId id = (CustomerAccountJournalId)argId;
/* 281 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 282 */     argStatement.setString(2, id.getCustAccountId());
/* 283 */     argStatement.setString(3, id.getCustAccountCode());
/* 284 */     argStatement.setLong(4, id.getJournalSequence().longValue());
/* 285 */     return argStatement;
/*     */   }
/*     */   
/*     */   public String[] getAllSelects() {
/* 289 */     String[] sels = super.getAllSelects();
/* 290 */     String[] result = new String[sels.length + 1];
/* 291 */     result[0] = getSelectImpl();
/* 292 */     System.arraycopy(sels, 0, result, 1, sels.length);
/* 293 */     return result;
/*     */   }
/*     */   
/*     */   public IFiller[] getAllFillers() {
/* 297 */     IFiller[] fills = super.getAllFillers();
/* 298 */     IFiller[] result = new IFiller[fills.length + 1];
/* 299 */     result[0] = getFillerImpl();
/* 300 */     System.arraycopy(fills, 0, result, 1, fills.length);
/* 301 */     return result;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\impl\WorkOrderAccountJournalDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */