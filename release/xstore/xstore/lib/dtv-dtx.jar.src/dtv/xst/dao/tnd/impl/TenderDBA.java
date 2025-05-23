/*     */ package dtv.xst.dao.tnd.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tnd.TenderId;
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
/*     */ 
/*     */ public class TenderDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1793466636L;
/*     */   private Long _organizationId;
/*     */   private String _tenderId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _currencyId;
/*     */   private String _description;
/*     */   private Integer _displayOrder;
/*     */   private Integer _flashSalesDisplayOrder;
/*     */   private String _tenderTypecode;
/*     */   private Boolean _disabled;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.tndr_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.currency_id, t.description, t.display_order, t.flash_sales_display_order, t.tndr_typcode, t.disabled_flag FROM tnd_tndr t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND tndr_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  41 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  45 */     return "SELECT t.organization_id, t.tndr_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.currency_id, t.description, t.display_order, t.flash_sales_display_order, t.tndr_typcode, t.disabled_flag FROM tnd_tndr t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  51 */     return " WHERE organization_id = ?  AND tndr_id = ?  ";
/*     */   }
/*     */   
/*  54 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tnd_tndr(organization_id, tndr_id, create_date, create_user_id, update_date, update_user_id, currency_id, description, display_order, flash_sales_display_order, tndr_typcode, disabled_flag) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  57 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  61 */     Object[][] insertParameterObject = { { this._organizationId, this._tenderId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._currencyId, this._description, this._displayOrder, this._flashSalesDisplayOrder, this._tenderTypecode, this._disabled } };
/*  62 */     return insertParameterObject;
/*     */   }
/*     */   
/*  65 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 91, 12, 91, 12, 12, 12, 4, 4, 12, -7 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  68 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  71 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tnd_tndr SET update_date = ?, update_user_id = ?, currency_id = ?, description = ?, display_order = ?, flash_sales_display_order = ?, tndr_typcode = ?, disabled_flag = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  74 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  78 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._currencyId, this._description, this._displayOrder, this._flashSalesDisplayOrder, this._tenderTypecode, this._disabled } };
/*  79 */     return updateParameterObject;
/*     */   }
/*     */   
/*  82 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 4, 4, 12, -7 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  84 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  87 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tnd_tndr" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND tndr_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  90 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  96 */     return " WHERE organization_id = ?  AND tndr_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  99 */     return new Object[] { this._organizationId, this._tenderId };
/*     */   }
/*     */   
/* 102 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 105 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 108 */     return "tnd_tndr";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 112 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 116 */     return new TenderFiller(this);
/*     */   }
/*     */   
/*     */   private static class TenderFiller
/*     */     implements IFiller {
/*     */     private TenderDBA _parent;
/*     */     
/*     */     public TenderFiller(TenderDBA argParent) {
/* 124 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 129 */       long primitiveResult = argResultSet.getLong(1);
/* 130 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 131 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 135 */       this._parent._tenderId = argResultSet.getString(2);
/*     */       
/* 137 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 138 */       if (t3 != null) {
/* 139 */         this._parent._createDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 142 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 145 */       this._parent._createUserId = argResultSet.getString(4);
/*     */       
/* 147 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 148 */       if (t5 != null) {
/* 149 */         this._parent._updateDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 152 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 155 */       this._parent._updateUserId = argResultSet.getString(6);
/* 156 */       this._parent._currencyId = argResultSet.getString(7);
/* 157 */       this._parent._description = argResultSet.getString(8);
/*     */ 
/*     */       
/* 160 */       int i = argResultSet.getInt(9);
/* 161 */       if (i != 0 || argResultSet.getObject(9) != null) {
/* 162 */         this._parent._displayOrder = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 168 */       i = argResultSet.getInt(10);
/* 169 */       if (i != 0 || argResultSet.getObject(10) != null) {
/* 170 */         this._parent._flashSalesDisplayOrder = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 174 */       this._parent._tenderTypecode = argResultSet.getString(11);
/* 175 */       this._parent._disabled = Boolean.valueOf(argResultSet.getBoolean(12));
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 180 */     argDAO.suppressStateChanges(true);
/* 181 */     TenderDAO dao = (TenderDAO)argDAO;
/* 182 */     dao.setOrganizationId(this._organizationId);
/* 183 */     dao.setTenderId(this._tenderId);
/* 184 */     dao.setCreateDate(this._createDate);
/* 185 */     dao.setCreateUserId(this._createUserId);
/* 186 */     dao.setUpdateDate(this._updateDate);
/* 187 */     dao.setUpdateUserId(this._updateUserId);
/* 188 */     dao.setCurrencyId(this._currencyId);
/* 189 */     dao.setDescription(this._description);
/* 190 */     dao.setDisplayOrder(this._displayOrder);
/* 191 */     dao.setFlashSalesDisplayOrder(this._flashSalesDisplayOrder);
/* 192 */     dao.setTenderTypecode(this._tenderTypecode);
/* 193 */     dao.setDisabled(this._disabled);
/* 194 */     argDAO.suppressStateChanges(false);
/* 195 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 199 */     return loadDAO((IDataAccessObject)new TenderDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 203 */     TenderDAO dao = (TenderDAO)argDAO;
/* 204 */     this._organizationId = dao.getOrganizationId();
/* 205 */     this._tenderId = dao.getTenderId();
/* 206 */     this._createDate = dao.getCreateDate();
/* 207 */     this._createUserId = dao.getCreateUserId();
/* 208 */     this._updateDate = dao.getUpdateDate();
/* 209 */     this._updateUserId = dao.getUpdateUserId();
/* 210 */     this._currencyId = dao.getCurrencyId();
/* 211 */     this._description = dao.getDescription();
/* 212 */     this._displayOrder = dao.getDisplayOrder();
/* 213 */     this._flashSalesDisplayOrder = dao.getFlashSalesDisplayOrder();
/* 214 */     this._tenderTypecode = dao.getTenderTypecode();
/* 215 */     this._disabled = (dao.getDisabled() != null) ? dao.getDisabled() : Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 219 */     TenderId id = (TenderId)argId;
/* 220 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 221 */     argStatement.setString(2, id.getTenderId());
/* 222 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 226 */     TenderId id = new TenderId();
/* 227 */     id.setOrganizationId(this._organizationId);
/* 228 */     id.setTenderId(this._tenderId);
/* 229 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 237 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 241 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tnd\impl\TenderDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */