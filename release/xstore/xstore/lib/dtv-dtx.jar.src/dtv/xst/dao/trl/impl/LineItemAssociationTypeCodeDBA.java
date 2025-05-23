/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.LineItemAssociationTypeCodeId;
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
/*     */ public class LineItemAssociationTypeCodeDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 326133537L;
/*     */   private String _lineItemAssociationTypeCode;
/*     */   private Long _organizationId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Boolean _cascadeDelete;
/*     */   private Boolean _cascadeQuantity;
/*     */   private Boolean _childRestrictDelete;
/*     */   private Boolean _childRestrictPrice;
/*     */   private Boolean _childRestrictQuantity;
/*     */   private String _description;
/*     */   private Boolean _parentRestrictDelete;
/*     */   private Boolean _parentRestrictPrice;
/*     */   private Boolean _parentRestrictQuantity;
/*     */   private Integer _sortOrder;
/*     */   private static final String SELECT_OBJECT = "SELECT t.lineitm_assoc_typcode, t.organization_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.cascade_delete_flag, t.cascade_quantity_flag, t.child_restrict_delete_flag, t.child_restrict_price_flag, t.child_restrict_quantity_flag, t.description, t.parent_restrict_delete_flag, t.parent_restrict_price_flag, t.parent_restrict_quantity_flag, t.sort_order FROM trl_lineitm_assoc_typcode t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE lineitm_assoc_typcode = ?  AND organization_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  45 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  49 */     return "SELECT t.lineitm_assoc_typcode, t.organization_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.cascade_delete_flag, t.cascade_quantity_flag, t.child_restrict_delete_flag, t.child_restrict_price_flag, t.child_restrict_quantity_flag, t.description, t.parent_restrict_delete_flag, t.parent_restrict_price_flag, t.parent_restrict_quantity_flag, t.sort_order FROM trl_lineitm_assoc_typcode t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  55 */     return " WHERE lineitm_assoc_typcode = ?  AND organization_id = ?  ";
/*     */   }
/*     */   
/*  58 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trl_lineitm_assoc_typcode(lineitm_assoc_typcode, organization_id, create_date, create_user_id, update_date, update_user_id, cascade_delete_flag, cascade_quantity_flag, child_restrict_delete_flag, child_restrict_price_flag, child_restrict_quantity_flag, description, parent_restrict_delete_flag, parent_restrict_price_flag, parent_restrict_quantity_flag, sort_order) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  61 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  65 */     Object[][] insertParameterObject = { { this._lineItemAssociationTypeCode, this._organizationId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._cascadeDelete, this._cascadeQuantity, this._childRestrictDelete, this._childRestrictPrice, this._childRestrictQuantity, this._description, this._parentRestrictDelete, this._parentRestrictPrice, this._parentRestrictQuantity, this._sortOrder } };
/*  66 */     return insertParameterObject;
/*     */   }
/*     */   
/*  69 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { 12, -5, 91, 12, 91, 12, -7, -7, -7, -7, -7, 12, -7, -7, -7, 4 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  72 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  75 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trl_lineitm_assoc_typcode SET update_date = ?, update_user_id = ?, cascade_delete_flag = ?, cascade_quantity_flag = ?, child_restrict_delete_flag = ?, child_restrict_price_flag = ?, child_restrict_quantity_flag = ?, description = ?, parent_restrict_delete_flag = ?, parent_restrict_price_flag = ?, parent_restrict_quantity_flag = ?, sort_order = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  78 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  82 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._cascadeDelete, this._cascadeQuantity, this._childRestrictDelete, this._childRestrictPrice, this._childRestrictQuantity, this._description, this._parentRestrictDelete, this._parentRestrictPrice, this._parentRestrictQuantity, this._sortOrder } };
/*  83 */     return updateParameterObject;
/*     */   }
/*     */   
/*  86 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, -7, -7, -7, -7, -7, 12, -7, -7, -7, 4 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  88 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  91 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trl_lineitm_assoc_typcode" }; private static final String WHERE_OBJECT = " WHERE lineitm_assoc_typcode = ?  AND organization_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  94 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 100 */     return " WHERE lineitm_assoc_typcode = ?  AND organization_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 103 */     return new Object[] { this._lineItemAssociationTypeCode, this._organizationId };
/*     */   }
/*     */   
/* 106 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { 12, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 109 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 112 */     return "trl_lineitm_assoc_typcode";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 116 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 120 */     return new LineItemAssociationTypeCodeFiller(this);
/*     */   }
/*     */   
/*     */   private static class LineItemAssociationTypeCodeFiller
/*     */     implements IFiller {
/*     */     private LineItemAssociationTypeCodeDBA _parent;
/*     */     
/*     */     public LineItemAssociationTypeCodeFiller(LineItemAssociationTypeCodeDBA argParent) {
/* 128 */       this._parent = argParent;
/*     */     }
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 131 */       this._parent._lineItemAssociationTypeCode = argResultSet.getString(1);
/*     */ 
/*     */       
/* 134 */       long primitiveResult = argResultSet.getLong(2);
/* 135 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 136 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 141 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 142 */       if (t3 != null) {
/* 143 */         this._parent._createDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 146 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 149 */       this._parent._createUserId = argResultSet.getString(4);
/*     */       
/* 151 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 152 */       if (t5 != null) {
/* 153 */         this._parent._updateDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 156 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 159 */       this._parent._updateUserId = argResultSet.getString(6);
/* 160 */       this._parent._cascadeDelete = Boolean.valueOf(argResultSet.getBoolean(7));
/* 161 */       this._parent._cascadeQuantity = Boolean.valueOf(argResultSet.getBoolean(8));
/* 162 */       this._parent._childRestrictDelete = Boolean.valueOf(argResultSet.getBoolean(9));
/* 163 */       this._parent._childRestrictPrice = Boolean.valueOf(argResultSet.getBoolean(10));
/* 164 */       this._parent._childRestrictQuantity = Boolean.valueOf(argResultSet.getBoolean(11));
/* 165 */       this._parent._description = argResultSet.getString(12);
/* 166 */       this._parent._parentRestrictDelete = Boolean.valueOf(argResultSet.getBoolean(13));
/* 167 */       this._parent._parentRestrictPrice = Boolean.valueOf(argResultSet.getBoolean(14));
/* 168 */       this._parent._parentRestrictQuantity = Boolean.valueOf(argResultSet.getBoolean(15));
/*     */ 
/*     */       
/* 171 */       int i = argResultSet.getInt(16);
/* 172 */       if (i != 0 || argResultSet.getObject(16) != null) {
/* 173 */         this._parent._sortOrder = Integer.valueOf(i);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 181 */     argDAO.suppressStateChanges(true);
/* 182 */     LineItemAssociationTypeCodeDAO dao = (LineItemAssociationTypeCodeDAO)argDAO;
/* 183 */     dao.setLineItemAssociationTypeCode(this._lineItemAssociationTypeCode);
/* 184 */     dao.setOrganizationId(this._organizationId);
/* 185 */     dao.setCreateDate(this._createDate);
/* 186 */     dao.setCreateUserId(this._createUserId);
/* 187 */     dao.setUpdateDate(this._updateDate);
/* 188 */     dao.setUpdateUserId(this._updateUserId);
/* 189 */     dao.setCascadeDelete(this._cascadeDelete);
/* 190 */     dao.setCascadeQuantity(this._cascadeQuantity);
/* 191 */     dao.setChildRestrictDelete(this._childRestrictDelete);
/* 192 */     dao.setChildRestrictPrice(this._childRestrictPrice);
/* 193 */     dao.setChildRestrictQuantity(this._childRestrictQuantity);
/* 194 */     dao.setDescription(this._description);
/* 195 */     dao.setParentRestrictDelete(this._parentRestrictDelete);
/* 196 */     dao.setParentRestrictPrice(this._parentRestrictPrice);
/* 197 */     dao.setParentRestrictQuantity(this._parentRestrictQuantity);
/* 198 */     dao.setSortOrder(this._sortOrder);
/* 199 */     argDAO.suppressStateChanges(false);
/* 200 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 204 */     return loadDAO((IDataAccessObject)new LineItemAssociationTypeCodeDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 208 */     LineItemAssociationTypeCodeDAO dao = (LineItemAssociationTypeCodeDAO)argDAO;
/* 209 */     this._lineItemAssociationTypeCode = dao.getLineItemAssociationTypeCode();
/* 210 */     this._organizationId = dao.getOrganizationId();
/* 211 */     this._createDate = dao.getCreateDate();
/* 212 */     this._createUserId = dao.getCreateUserId();
/* 213 */     this._updateDate = dao.getUpdateDate();
/* 214 */     this._updateUserId = dao.getUpdateUserId();
/* 215 */     this._cascadeDelete = (dao.getCascadeDelete() != null) ? dao.getCascadeDelete() : Boolean.valueOf(false);
/* 216 */     this._cascadeQuantity = (dao.getCascadeQuantity() != null) ? dao.getCascadeQuantity() : Boolean.valueOf(false);
/* 217 */     this._childRestrictDelete = (dao.getChildRestrictDelete() != null) ? dao.getChildRestrictDelete() : Boolean.valueOf(false);
/* 218 */     this._childRestrictPrice = (dao.getChildRestrictPrice() != null) ? dao.getChildRestrictPrice() : Boolean.valueOf(false);
/* 219 */     this._childRestrictQuantity = (dao.getChildRestrictQuantity() != null) ? dao.getChildRestrictQuantity() : Boolean.valueOf(false);
/* 220 */     this._description = dao.getDescription();
/* 221 */     this._parentRestrictDelete = (dao.getParentRestrictDelete() != null) ? dao.getParentRestrictDelete() : Boolean.valueOf(false);
/* 222 */     this._parentRestrictPrice = (dao.getParentRestrictPrice() != null) ? dao.getParentRestrictPrice() : Boolean.valueOf(false);
/* 223 */     this._parentRestrictQuantity = (dao.getParentRestrictQuantity() != null) ? dao.getParentRestrictQuantity() : Boolean.valueOf(false);
/* 224 */     this._sortOrder = dao.getSortOrder();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 228 */     LineItemAssociationTypeCodeId id = (LineItemAssociationTypeCodeId)argId;
/* 229 */     argStatement.setString(1, id.getLineItemAssociationTypeCode());
/* 230 */     argStatement.setLong(2, id.getOrganizationId().longValue());
/* 231 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 235 */     LineItemAssociationTypeCodeId id = new LineItemAssociationTypeCodeId();
/* 236 */     id.setLineItemAssociationTypeCode(this._lineItemAssociationTypeCode);
/* 237 */     id.setOrganizationId(this._organizationId);
/* 238 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 246 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 250 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\LineItemAssociationTypeCodeDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */