/*     */ package dtv.xst.dao.cwo.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cwo.WorkItemId;
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
/*     */ public class WorkItemDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 99166692L;
/*     */   private Long _organizationId;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private Integer _workItemSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _itemId;
/*     */   private String _description;
/*     */   private BigDecimal _valueAmount;
/*     */   private String _warrantyNumber;
/*     */   private String _workItemSerialNumber;
/*     */   private Boolean _void;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.cust_acct_id, t.cust_acct_code, t.work_item_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.item_id, t.description, t.value_amt, t.warranty_number, t.work_item_serial_nbr, t.void_flag FROM cwo_work_item t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND work_item_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  43 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  47 */     return "SELECT t.organization_id, t.cust_acct_id, t.cust_acct_code, t.work_item_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.item_id, t.description, t.value_amt, t.warranty_number, t.work_item_serial_nbr, t.void_flag FROM cwo_work_item t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  53 */     return " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND work_item_seq = ?  ";
/*     */   }
/*     */   
/*  56 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO cwo_work_item(organization_id, cust_acct_id, cust_acct_code, work_item_seq, create_date, create_user_id, update_date, update_user_id, item_id, description, value_amt, warranty_number, work_item_serial_nbr, void_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  59 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  63 */     Object[][] insertParameterObject = { { this._organizationId, this._custAccountId, this._custAccountCode, this._workItemSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._itemId, this._description, this._valueAmount, this._warrantyNumber, this._workItemSerialNumber, this._void } };
/*  64 */     return insertParameterObject;
/*     */   }
/*     */   
/*  67 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 4, 91, 12, 91, 12, 12, 12, 3, 12, 12, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  70 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  73 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE cwo_work_item SET update_date = ?, update_user_id = ?, item_id = ?, description = ?, value_amt = ?, warranty_number = ?, work_item_serial_nbr = ?, void_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  76 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  80 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._itemId, this._description, this._valueAmount, this._warrantyNumber, this._workItemSerialNumber, this._void } };
/*  81 */     return updateParameterObject;
/*     */   }
/*     */   
/*  84 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 3, 12, 12, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  86 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  89 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM cwo_work_item" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND work_item_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  92 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  98 */     return " WHERE organization_id = ?  AND cust_acct_id = ?  AND cust_acct_code = ?  AND work_item_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 101 */     return new Object[] { this._organizationId, this._custAccountId, this._custAccountCode, this._workItemSequence };
/*     */   }
/*     */   
/* 104 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 107 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 110 */     return "cwo_work_item";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 114 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 118 */     return new WorkItemFiller(this);
/*     */   }
/*     */   
/*     */   private static class WorkItemFiller
/*     */     implements IFiller {
/*     */     private WorkItemDBA _parent;
/*     */     
/*     */     public WorkItemFiller(WorkItemDBA argParent) {
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
/* 137 */       this._parent._custAccountId = argResultSet.getString(2);
/* 138 */       this._parent._custAccountCode = argResultSet.getString(3);
/*     */ 
/*     */       
/* 141 */       int primitiveResult = argResultSet.getInt(4);
/* 142 */       if (primitiveResult != 0 || argResultSet.getObject(4) != null) {
/* 143 */         this._parent._workItemSequence = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 148 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 149 */       if (t5 != null) {
/* 150 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 153 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 156 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 158 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 159 */       if (t7 != null) {
/* 160 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 163 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 166 */       this._parent._updateUserId = argResultSet.getString(8);
/* 167 */       this._parent._itemId = argResultSet.getString(9);
/* 168 */       this._parent._description = argResultSet.getString(10);
/* 169 */       this._parent._valueAmount = argResultSet.getBigDecimal(11);
/* 170 */       this._parent._warrantyNumber = argResultSet.getString(12);
/* 171 */       this._parent._workItemSerialNumber = argResultSet.getString(13);
/* 172 */       this._parent._void = Boolean.valueOf(argResultSet.getBoolean(14));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 177 */     argDAO.suppressStateChanges(true);
/* 178 */     WorkItemDAO dao = (WorkItemDAO)argDAO;
/* 179 */     dao.setOrganizationId(this._organizationId);
/* 180 */     dao.setCustAccountId(this._custAccountId);
/* 181 */     dao.setCustAccountCode(this._custAccountCode);
/* 182 */     dao.setWorkItemSequence(this._workItemSequence);
/* 183 */     dao.setCreateDate(this._createDate);
/* 184 */     dao.setCreateUserId(this._createUserId);
/* 185 */     dao.setUpdateDate(this._updateDate);
/* 186 */     dao.setUpdateUserId(this._updateUserId);
/* 187 */     dao.setItemId(this._itemId);
/* 188 */     dao.setDescription(this._description);
/* 189 */     dao.setValueAmount(this._valueAmount);
/* 190 */     dao.setWarrantyNumber(this._warrantyNumber);
/* 191 */     dao.setWorkItemSerialNumber(this._workItemSerialNumber);
/* 192 */     dao.setVoid(this._void);
/* 193 */     argDAO.suppressStateChanges(false);
/* 194 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 198 */     return loadDAO((IDataAccessObject)new WorkItemDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 202 */     WorkItemDAO dao = (WorkItemDAO)argDAO;
/* 203 */     this._organizationId = dao.getOrganizationId();
/* 204 */     this._custAccountId = dao.getCustAccountId();
/* 205 */     this._custAccountCode = dao.getCustAccountCode();
/* 206 */     this._workItemSequence = dao.getWorkItemSequence();
/* 207 */     this._createDate = dao.getCreateDate();
/* 208 */     this._createUserId = dao.getCreateUserId();
/* 209 */     this._updateDate = dao.getUpdateDate();
/* 210 */     this._updateUserId = dao.getUpdateUserId();
/* 211 */     this._itemId = dao.getItemId();
/* 212 */     this._description = dao.getDescription();
/* 213 */     this._valueAmount = dao.getValueAmount();
/* 214 */     this._warrantyNumber = dao.getWarrantyNumber();
/* 215 */     this._workItemSerialNumber = dao.getWorkItemSerialNumber();
/* 216 */     this._void = (dao.getVoid() != null) ? dao.getVoid() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 220 */     WorkItemId id = (WorkItemId)argId;
/* 221 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 222 */     argStatement.setString(2, id.getCustAccountId());
/* 223 */     argStatement.setString(3, id.getCustAccountCode());
/* 224 */     argStatement.setInt(4, id.getWorkItemSequence().intValue());
/* 225 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 229 */     WorkItemId id = new WorkItemId();
/* 230 */     id.setOrganizationId(this._organizationId);
/* 231 */     id.setCustAccountId(this._custAccountId);
/* 232 */     id.setCustAccountCode(this._custAccountCode);
/* 233 */     id.setWorkItemSequence(this._workItemSequence);
/* 234 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 242 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 246 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\impl\WorkItemDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */