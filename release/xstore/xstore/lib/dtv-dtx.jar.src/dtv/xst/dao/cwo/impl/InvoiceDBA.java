/*     */ package dtv.xst.dao.cwo.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cwo.InvoiceId;
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
/*     */ public class InvoiceDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -670115059L;
/*     */   private Long _organizationId;
/*     */   private String _serviceLocationId;
/*     */   private String _invoiceNumber;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Date _invoiceDate;
/*     */   private BigDecimal _amountDue;
/*     */   private String _notes;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.service_loc_id, t.invoice_number, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.invoice_date, t.amount_due, t.notes FROM cwo_invoice t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND service_loc_id = ?  AND invoice_number = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  39 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  43 */     return "SELECT t.organization_id, t.service_loc_id, t.invoice_number, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.invoice_date, t.amount_due, t.notes FROM cwo_invoice t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  49 */     return " WHERE organization_id = ?  AND service_loc_id = ?  AND invoice_number = ?  ";
/*     */   }
/*     */   
/*  52 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO cwo_invoice(organization_id, service_loc_id, invoice_number, create_date, create_user_id, update_date, update_user_id, invoice_date, amount_due, notes) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  55 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  59 */     Object[][] insertParameterObject = { { this._organizationId, this._serviceLocationId, this._invoiceNumber, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._invoiceDate, this._amountDue, this._notes } };
/*  60 */     return insertParameterObject;
/*     */   }
/*     */   
/*  63 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 91, 12, 91, 12, 91, 3, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  66 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  69 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE cwo_invoice SET update_date = ?, update_user_id = ?, invoice_date = ?, amount_due = ?, notes = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  72 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  76 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._invoiceDate, this._amountDue, this._notes } };
/*  77 */     return updateParameterObject;
/*     */   }
/*     */   
/*  80 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 91, 3, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  82 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  85 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM cwo_invoice" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND service_loc_id = ?  AND invoice_number = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  88 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  94 */     return " WHERE organization_id = ?  AND service_loc_id = ?  AND invoice_number = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  97 */     return new Object[] { this._organizationId, this._serviceLocationId, this._invoiceNumber };
/*     */   }
/*     */   
/* 100 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 103 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 106 */     return "cwo_invoice";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 110 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 114 */     return new InvoiceFiller(this);
/*     */   }
/*     */   
/*     */   private static class InvoiceFiller
/*     */     implements IFiller {
/*     */     private InvoiceDBA _parent;
/*     */     
/*     */     public InvoiceFiller(InvoiceDBA argParent) {
/* 122 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 127 */       long primitiveResult = argResultSet.getLong(1);
/* 128 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 129 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 133 */       this._parent._serviceLocationId = argResultSet.getString(2);
/* 134 */       this._parent._invoiceNumber = argResultSet.getString(3);
/*     */       
/* 136 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 137 */       if (t4 != null) {
/* 138 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 141 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 144 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 146 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 147 */       if (t6 != null) {
/* 148 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 151 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 154 */       this._parent._updateUserId = argResultSet.getString(7);
/*     */       
/* 156 */       Timestamp t8 = argResultSet.getTimestamp(8);
/* 157 */       if (t8 != null) {
/* 158 */         this._parent._invoiceDate = (Date)new DtvDate(t8.getTime());
/*     */       } else {
/*     */         
/* 161 */         this._parent._invoiceDate = null;
/*     */       } 
/*     */       
/* 164 */       this._parent._amountDue = argResultSet.getBigDecimal(9);
/* 165 */       this._parent._notes = argResultSet.getString(10);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 170 */     argDAO.suppressStateChanges(true);
/* 171 */     InvoiceDAO dao = (InvoiceDAO)argDAO;
/* 172 */     dao.setOrganizationId(this._organizationId);
/* 173 */     dao.setServiceLocationId(this._serviceLocationId);
/* 174 */     dao.setInvoiceNumber(this._invoiceNumber);
/* 175 */     dao.setCreateDate(this._createDate);
/* 176 */     dao.setCreateUserId(this._createUserId);
/* 177 */     dao.setUpdateDate(this._updateDate);
/* 178 */     dao.setUpdateUserId(this._updateUserId);
/* 179 */     dao.setInvoiceDate(this._invoiceDate);
/* 180 */     dao.setAmountDue(this._amountDue);
/* 181 */     dao.setNotes(this._notes);
/* 182 */     argDAO.suppressStateChanges(false);
/* 183 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 187 */     return loadDAO((IDataAccessObject)new InvoiceDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 191 */     InvoiceDAO dao = (InvoiceDAO)argDAO;
/* 192 */     this._organizationId = dao.getOrganizationId();
/* 193 */     this._serviceLocationId = dao.getServiceLocationId();
/* 194 */     this._invoiceNumber = dao.getInvoiceNumber();
/* 195 */     this._createDate = dao.getCreateDate();
/* 196 */     this._createUserId = dao.getCreateUserId();
/* 197 */     this._updateDate = dao.getUpdateDate();
/* 198 */     this._updateUserId = dao.getUpdateUserId();
/* 199 */     this._invoiceDate = dao.getInvoiceDate();
/* 200 */     this._amountDue = dao.getAmountDue();
/* 201 */     this._notes = dao.getNotes();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 205 */     InvoiceId id = (InvoiceId)argId;
/* 206 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 207 */     argStatement.setString(2, id.getServiceLocationId());
/* 208 */     argStatement.setString(3, id.getInvoiceNumber());
/* 209 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 213 */     InvoiceId id = new InvoiceId();
/* 214 */     id.setOrganizationId(this._organizationId);
/* 215 */     id.setServiceLocationId(this._serviceLocationId);
/* 216 */     id.setInvoiceNumber(this._invoiceNumber);
/* 217 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 225 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 229 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\impl\InvoiceDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */