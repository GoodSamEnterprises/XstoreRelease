/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.xst.dao.itm.KitComponentId;
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
/*     */ public class KitComponentDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 673268455L;
/*     */   private Long _organizationId;
/*     */   private String _kitItemId;
/*     */   private String _componentItemId;
/*     */   private Long _sequenceNumber;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private Integer _displayOrder;
/*     */   private Integer _quantityPerKit;
/*     */   private Date _beginDatetime;
/*     */   private Date _endDatetime;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.kit_item_id, t.component_item_id, t.seq_nbr, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.display_order, t.quantity_per_kit, t.begin_datetime, t.end_datetime FROM itm_kit_component t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND kit_item_id = ?  AND component_item_id = ?  AND seq_nbr = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  43 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  47 */     return "SELECT t.organization_id, t.kit_item_id, t.component_item_id, t.seq_nbr, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.org_code, t.org_value, t.display_order, t.quantity_per_kit, t.begin_datetime, t.end_datetime FROM itm_kit_component t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  53 */     return " WHERE organization_id = ?  AND kit_item_id = ?  AND component_item_id = ?  AND seq_nbr = ?  ";
/*     */   }
/*     */   
/*  56 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_kit_component(organization_id, kit_item_id, component_item_id, seq_nbr, create_date, create_user_id, update_date, update_user_id, org_code, org_value, display_order, quantity_per_kit, begin_datetime, end_datetime) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  59 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  63 */     Object[][] insertParameterObject = { { this._organizationId, this._kitItemId, this._componentItemId, this._sequenceNumber, this._createDate, this._createUserId, this._updateDate, this._updateUserId, ObjectUtils.coalesce((Object[])new String[] { this._orgCode, "*" }), ObjectUtils.coalesce((Object[])new String[] { this._orgValue, "*" }), this._displayOrder, this._quantityPerKit, this._beginDatetime, this._endDatetime } };
/*  64 */     return insertParameterObject;
/*     */   }
/*     */   
/*  67 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 12, -5, 91, 12, 91, 12, 12, 12, 4, 4, 91, 91 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  70 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  73 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_kit_component SET update_date = ?, update_user_id = ?, org_code = ?, org_value = ?, display_order = ?, quantity_per_kit = ?, begin_datetime = ?, end_datetime = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  76 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  80 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._orgCode, this._orgValue, this._displayOrder, this._quantityPerKit, this._beginDatetime, this._endDatetime } };
/*  81 */     return updateParameterObject;
/*     */   }
/*     */   
/*  84 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 4, 4, 91, 91 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  86 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  89 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_kit_component" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND kit_item_id = ?  AND component_item_id = ?  AND seq_nbr = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  92 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  98 */     return " WHERE organization_id = ?  AND kit_item_id = ?  AND component_item_id = ?  AND seq_nbr = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 101 */     return new Object[] { this._organizationId, this._kitItemId, this._componentItemId, this._sequenceNumber };
/*     */   }
/*     */   
/* 104 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 12, -5 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 107 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 110 */     return "itm_kit_component";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 114 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 118 */     return new KitComponentFiller(this);
/*     */   }
/*     */   
/*     */   private static class KitComponentFiller
/*     */     implements IFiller {
/*     */     private KitComponentDBA _parent;
/*     */     
/*     */     public KitComponentFiller(KitComponentDBA argParent) {
/* 126 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 131 */       long primitiveResult = argResultSet.getLong(1);
/* 132 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 133 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 137 */       this._parent._kitItemId = argResultSet.getString(2);
/* 138 */       this._parent._componentItemId = argResultSet.getString(3);
/*     */ 
/*     */       
/* 141 */       primitiveResult = argResultSet.getLong(4);
/* 142 */       if (primitiveResult != 0L || argResultSet.getObject(4) != null) {
/* 143 */         this._parent._sequenceNumber = Long.valueOf(primitiveResult);
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
/* 167 */       this._parent._orgCode = argResultSet.getString(9);
/* 168 */       this._parent._orgValue = argResultSet.getString(10);
/*     */ 
/*     */       
/* 171 */       int i = argResultSet.getInt(11);
/* 172 */       if (i != 0 || argResultSet.getObject(11) != null) {
/* 173 */         this._parent._displayOrder = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 179 */       i = argResultSet.getInt(12);
/* 180 */       if (i != 0 || argResultSet.getObject(12) != null) {
/* 181 */         this._parent._quantityPerKit = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 186 */       Timestamp t13 = argResultSet.getTimestamp(13);
/* 187 */       if (t13 != null) {
/* 188 */         this._parent._beginDatetime = (Date)new DtvDate(t13.getTime());
/*     */       } else {
/*     */         
/* 191 */         this._parent._beginDatetime = null;
/*     */       } 
/*     */ 
/*     */       
/* 195 */       Timestamp t14 = argResultSet.getTimestamp(14);
/* 196 */       if (t14 != null) {
/* 197 */         this._parent._endDatetime = (Date)new DtvDate(t14.getTime());
/*     */       } else {
/*     */         
/* 200 */         this._parent._endDatetime = null;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 207 */     argDAO.suppressStateChanges(true);
/* 208 */     KitComponentDAO dao = (KitComponentDAO)argDAO;
/* 209 */     dao.setOrganizationId(this._organizationId);
/* 210 */     dao.setKitItemId(this._kitItemId);
/* 211 */     dao.setComponentItemId(this._componentItemId);
/* 212 */     dao.setSequenceNumber(this._sequenceNumber);
/* 213 */     dao.setCreateDate(this._createDate);
/* 214 */     dao.setCreateUserId(this._createUserId);
/* 215 */     dao.setUpdateDate(this._updateDate);
/* 216 */     dao.setUpdateUserId(this._updateUserId);
/* 217 */     dao.setOrgCode(this._orgCode);
/* 218 */     dao.setOrgValue(this._orgValue);
/* 219 */     dao.setDisplayOrder(this._displayOrder);
/* 220 */     dao.setQuantityPerKit(this._quantityPerKit);
/* 221 */     dao.setBeginDatetime(this._beginDatetime);
/* 222 */     dao.setEndDatetime(this._endDatetime);
/* 223 */     argDAO.suppressStateChanges(false);
/* 224 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 228 */     return loadDAO((IDataAccessObject)new KitComponentDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 232 */     KitComponentDAO dao = (KitComponentDAO)argDAO;
/* 233 */     this._organizationId = dao.getOrganizationId();
/* 234 */     this._kitItemId = dao.getKitItemId();
/* 235 */     this._componentItemId = dao.getComponentItemId();
/* 236 */     this._sequenceNumber = dao.getSequenceNumber();
/* 237 */     this._createDate = dao.getCreateDate();
/* 238 */     this._createUserId = dao.getCreateUserId();
/* 239 */     this._updateDate = dao.getUpdateDate();
/* 240 */     this._updateUserId = dao.getUpdateUserId();
/* 241 */     this._orgCode = dao.getOrgCode();
/* 242 */     this._orgValue = dao.getOrgValue();
/* 243 */     this._displayOrder = dao.getDisplayOrder();
/* 244 */     this._quantityPerKit = dao.getQuantityPerKit();
/* 245 */     this._beginDatetime = dao.getBeginDatetime();
/* 246 */     this._endDatetime = dao.getEndDatetime();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 250 */     KitComponentId id = (KitComponentId)argId;
/* 251 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 252 */     argStatement.setString(2, id.getKitItemId());
/* 253 */     argStatement.setString(3, id.getComponentItemId());
/* 254 */     argStatement.setLong(4, id.getSequenceNumber().longValue());
/* 255 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 259 */     KitComponentId id = new KitComponentId();
/* 260 */     id.setOrganizationId(this._organizationId);
/* 261 */     id.setKitItemId(this._kitItemId);
/* 262 */     id.setComponentItemId(this._componentItemId);
/* 263 */     id.setSequenceNumber(this._sequenceNumber);
/* 264 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 272 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 276 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\KitComponentDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */