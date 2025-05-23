/*     */ package dtv.xst.dao.tax.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tax.TaxTaxGroupMappingId;
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
/*     */ public class TaxTaxGroupMappingDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -772656753L;
/*     */   private Long _organizationId;
/*     */   private String _customerGroup;
/*     */   private String _taxGroupId;
/*     */   private Integer _rtlLocId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Integer _priority;
/*     */   private String _newTaxGroupId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.customer_group_id, t.tax_group_id, t.rtl_loc_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.priority, t.new_tax_group_id FROM tax_tax_group_mapping t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND customer_group_id = ?  AND tax_group_id = ?  AND rtl_loc_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  39 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  43 */     return "SELECT t.organization_id, t.customer_group_id, t.tax_group_id, t.rtl_loc_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.priority, t.new_tax_group_id FROM tax_tax_group_mapping t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  49 */     return " WHERE organization_id = ?  AND customer_group_id = ?  AND tax_group_id = ?  AND rtl_loc_id = ?  ";
/*     */   }
/*     */   
/*  52 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO tax_tax_group_mapping(organization_id, customer_group_id, tax_group_id, rtl_loc_id, create_date, create_user_id, update_date, update_user_id, priority, new_tax_group_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  55 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  59 */     Object[][] insertParameterObject = { { this._organizationId, this._customerGroup, this._taxGroupId, this._rtlLocId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._priority, this._newTaxGroupId } };
/*  60 */     return insertParameterObject;
/*     */   }
/*     */   
/*  63 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, 4, 91, 12, 91, 12, 4, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  66 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  69 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE tax_tax_group_mapping SET update_date = ?, update_user_id = ?, priority = ?, new_tax_group_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  72 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  76 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._priority, this._newTaxGroupId } };
/*  77 */     return updateParameterObject;
/*     */   }
/*     */   
/*  80 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 4, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  82 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  85 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM tax_tax_group_mapping" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND customer_group_id = ?  AND tax_group_id = ?  AND rtl_loc_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  88 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  94 */     return " WHERE organization_id = ?  AND customer_group_id = ?  AND tax_group_id = ?  AND rtl_loc_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  97 */     return new Object[] { this._organizationId, this._customerGroup, this._taxGroupId, this._rtlLocId };
/*     */   }
/*     */   
/* 100 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 103 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 106 */     return "tax_tax_group_mapping";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 110 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 114 */     return new TaxTaxGroupMappingFiller(this);
/*     */   }
/*     */   
/*     */   private static class TaxTaxGroupMappingFiller
/*     */     implements IFiller {
/*     */     private TaxTaxGroupMappingDBA _parent;
/*     */     
/*     */     public TaxTaxGroupMappingFiller(TaxTaxGroupMappingDBA argParent) {
/* 122 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 127 */       long l = argResultSet.getLong(1);
/* 128 */       if (l != 0L || argResultSet.getObject(1) != null) {
/* 129 */         this._parent._organizationId = Long.valueOf(l);
/*     */       }
/*     */ 
/*     */       
/* 133 */       this._parent._customerGroup = argResultSet.getString(2);
/* 134 */       this._parent._taxGroupId = argResultSet.getString(3);
/*     */ 
/*     */       
/* 137 */       int primitiveResult = argResultSet.getInt(4);
/* 138 */       if (primitiveResult != 0 || argResultSet.getObject(4) != null) {
/* 139 */         this._parent._rtlLocId = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 144 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 145 */       if (t5 != null) {
/* 146 */         this._parent._createDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 149 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 152 */       this._parent._createUserId = argResultSet.getString(6);
/*     */       
/* 154 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 155 */       if (t7 != null) {
/* 156 */         this._parent._updateDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 159 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 162 */       this._parent._updateUserId = argResultSet.getString(8);
/*     */ 
/*     */       
/* 165 */       int i = argResultSet.getInt(9);
/* 166 */       if (i != 0 || argResultSet.getObject(9) != null) {
/* 167 */         this._parent._priority = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 171 */       this._parent._newTaxGroupId = argResultSet.getString(10);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 176 */     argDAO.suppressStateChanges(true);
/* 177 */     TaxTaxGroupMappingDAO dao = (TaxTaxGroupMappingDAO)argDAO;
/* 178 */     dao.setOrganizationId(this._organizationId);
/* 179 */     dao.setCustomerGroup(this._customerGroup);
/* 180 */     dao.setTaxGroupId(this._taxGroupId);
/* 181 */     dao.setRtlLocId(this._rtlLocId);
/* 182 */     dao.setCreateDate(this._createDate);
/* 183 */     dao.setCreateUserId(this._createUserId);
/* 184 */     dao.setUpdateDate(this._updateDate);
/* 185 */     dao.setUpdateUserId(this._updateUserId);
/* 186 */     dao.setPriority(this._priority);
/* 187 */     dao.setNewTaxGroupId(this._newTaxGroupId);
/* 188 */     argDAO.suppressStateChanges(false);
/* 189 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 193 */     return loadDAO((IDataAccessObject)new TaxTaxGroupMappingDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 197 */     TaxTaxGroupMappingDAO dao = (TaxTaxGroupMappingDAO)argDAO;
/* 198 */     this._organizationId = dao.getOrganizationId();
/* 199 */     this._customerGroup = dao.getCustomerGroup();
/* 200 */     this._taxGroupId = dao.getTaxGroupId();
/* 201 */     this._rtlLocId = dao.getRtlLocId();
/* 202 */     this._createDate = dao.getCreateDate();
/* 203 */     this._createUserId = dao.getCreateUserId();
/* 204 */     this._updateDate = dao.getUpdateDate();
/* 205 */     this._updateUserId = dao.getUpdateUserId();
/* 206 */     this._priority = dao.getPriority();
/* 207 */     this._newTaxGroupId = dao.getNewTaxGroupId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 211 */     TaxTaxGroupMappingId id = (TaxTaxGroupMappingId)argId;
/* 212 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 213 */     argStatement.setString(2, id.getCustomerGroup());
/* 214 */     argStatement.setString(3, id.getTaxGroupId());
/* 215 */     argStatement.setInt(4, id.getRtlLocId().intValue());
/* 216 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 220 */     TaxTaxGroupMappingId id = new TaxTaxGroupMappingId();
/* 221 */     id.setOrganizationId(this._organizationId);
/* 222 */     id.setCustomerGroup(this._customerGroup);
/* 223 */     id.setTaxGroupId(this._taxGroupId);
/* 224 */     id.setRtlLocId(this._rtlLocId);
/* 225 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 233 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 237 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\TaxTaxGroupMappingDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */