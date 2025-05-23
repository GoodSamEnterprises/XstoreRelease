/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IExtendedJDBCAdapter;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.util.ArrayUtils;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.ItemId;
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
/*     */ public class NonPhysicalItemDBA
/*     */   extends ItemDBA
/*     */   implements IExtendedJDBCAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 2117171159L;
/*     */   private Long _organizationId;
/*     */   private String _itemId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private Integer _displayOrder;
/*     */   private String _nonPhysicalItemTypeCode;
/*     */   private String _nonPhysicalItemSubtype;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.item_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.display_order, t.non_phys_item_typcode, t.non_phys_item_subtype FROM itm_non_phys_item t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND item_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  39 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  43 */     return "SELECT t.organization_id, t.item_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.display_order, t.non_phys_item_typcode, t.non_phys_item_subtype FROM itm_non_phys_item t";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  50 */     return " WHERE organization_id = ?  AND item_id = ?  ";
/*     */   }
/*     */   
/*  53 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO itm_non_phys_item(organization_id, item_id, create_date, create_user_id, update_date, update_user_id, display_order, non_phys_item_typcode, non_phys_item_subtype) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */ 
/*     */   
/*     */   public String[] getInsert() {
/*  57 */     return (String[])ArrayUtils.combine((Object[])super.getInsert(), (Object[])INSERT_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  62 */     Object[][] insertParameterObject = { { this._organizationId, this._itemId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._displayOrder, this._nonPhysicalItemTypeCode, this._nonPhysicalItemSubtype } };
/*  63 */     return (Object[][])ArrayUtils.combine((Object[])super.getInsertParameters(), (Object[])insertParameterObject);
/*     */   }
/*     */   
/*  66 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 91, 12, 91, 12, 4, 12, 12 } };
/*     */ 
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  70 */     return (int[][])ArrayUtils.combine((Object[])super.getInsertParameterTypes(), (Object[])INSERT_PARAMETER_TYPES_OBJECT);
/*     */   }
/*     */   
/*  73 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE itm_non_phys_item SET update_date = ?, update_user_id = ?, display_order = ?, non_phys_item_typcode = ?, non_phys_item_subtype = ?" };
/*     */ 
/*     */   
/*     */   public String[] getUpdate() {
/*  77 */     return (String[])ArrayUtils.combine((Object[])super.getUpdate(), (Object[])UPDATE_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  82 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._displayOrder, this._nonPhysicalItemTypeCode, this._nonPhysicalItemSubtype } };
/*  83 */     return (Object[][])ArrayUtils.combine((Object[])super.getUpdateParameters(), (Object[])updateParameterObject);
/*     */   }
/*     */   
/*  86 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 4, 12, 12 } };
/*     */   
/*     */   public int[][] getUpdateParameterTypes() {
/*  89 */     return (int[][])ArrayUtils.combine((Object[])super.getUpdateParameterTypes(), (Object[])UPDATE_PARAMETER_TYPE_OBJECT);
/*     */   }
/*     */   
/*  92 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM itm_non_phys_item" };
/*     */   private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND item_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  96 */     return (String[])ArrayUtils.combine((Object[])super.getDelete(), (Object[])DELETE_OBJECT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 103 */     return " WHERE organization_id = ?  AND item_id = ?  ";
/*     */   }
/*     */   
/*     */   public Object[] getWhereParameters() {
/* 107 */     return new Object[] { this._organizationId, this._itemId };
/*     */   }
/*     */   
/* 110 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12 };
/*     */ 
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 114 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 118 */     return "itm_non_phys_item";
/*     */   }
/*     */ 
/*     */   
/*     */   public IFiller getFiller() {
/* 123 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 127 */     return new NonPhysicalItemFiller(this);
/*     */   }
/*     */   
/*     */   private static class NonPhysicalItemFiller
/*     */     implements IFiller {
/*     */     private NonPhysicalItemDBA _parent;
/*     */     
/*     */     public NonPhysicalItemFiller(NonPhysicalItemDBA argParent) {
/* 135 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 140 */       long primitiveResult = argResultSet.getLong(1);
/* 141 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 142 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 146 */       this._parent._itemId = argResultSet.getString(2);
/*     */       
/* 148 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 149 */       if (t3 != null) {
/* 150 */         this._parent._createDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 153 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 156 */       this._parent._createUserId = argResultSet.getString(4);
/*     */       
/* 158 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 159 */       if (t5 != null) {
/* 160 */         this._parent._updateDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 163 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 166 */       this._parent._updateUserId = argResultSet.getString(6);
/*     */ 
/*     */       
/* 169 */       int i = argResultSet.getInt(7);
/* 170 */       if (i != 0 || argResultSet.getObject(7) != null) {
/* 171 */         this._parent._displayOrder = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */       
/* 175 */       this._parent._nonPhysicalItemTypeCode = argResultSet.getString(8);
/* 176 */       this._parent._nonPhysicalItemSubtype = argResultSet.getString(9);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 182 */     super.loadDAO(argDAO);
/* 183 */     argDAO.suppressStateChanges(true);
/* 184 */     NonPhysicalItemDAO dao = (NonPhysicalItemDAO)argDAO;
/* 185 */     dao.setOrganizationId(this._organizationId);
/* 186 */     dao.setItemId(this._itemId);
/* 187 */     dao.setCreateDate(this._createDate);
/* 188 */     dao.setCreateUserId(this._createUserId);
/* 189 */     dao.setUpdateDate(this._updateDate);
/* 190 */     dao.setUpdateUserId(this._updateUserId);
/* 191 */     dao.setDisplayOrder(this._displayOrder);
/* 192 */     dao.setNonPhysicalItemTypeCode(this._nonPhysicalItemTypeCode);
/* 193 */     dao.setNonPhysicalItemSubtype(this._nonPhysicalItemSubtype);
/* 194 */     argDAO.suppressStateChanges(false);
/* 195 */     return (IDataAccessObject)dao;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 200 */     return loadDAO((IDataAccessObject)new NonPhysicalItemDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 205 */     NonPhysicalItemDAO dao = (NonPhysicalItemDAO)argDAO;
/* 206 */     super.fill((IDataAccessObject)dao);
/* 207 */     this._organizationId = dao.getOrganizationId();
/* 208 */     this._itemId = dao.getItemId();
/* 209 */     this._createDate = dao.getCreateDate();
/* 210 */     this._createUserId = dao.getCreateUserId();
/* 211 */     this._updateDate = dao.getUpdateDate();
/* 212 */     this._updateUserId = dao.getUpdateUserId();
/* 213 */     this._displayOrder = dao.getDisplayOrder();
/* 214 */     this._nonPhysicalItemTypeCode = dao.getNonPhysicalItemTypeCode();
/* 215 */     this._nonPhysicalItemSubtype = dao.getNonPhysicalItemSubtype();
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 220 */     ItemId id = (ItemId)argId;
/* 221 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 222 */     argStatement.setString(2, id.getItemId());
/* 223 */     return argStatement;
/*     */   }
/*     */   
/*     */   public String[] getAllSelects() {
/* 227 */     return new String[] { getSelectImpl() };
/*     */   }
/*     */   
/*     */   public IFiller[] getAllFillers() {
/* 231 */     return new IFiller[] { getFillerImpl() };
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\NonPhysicalItemDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */