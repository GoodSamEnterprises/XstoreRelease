/*     */ package dtv.xst.dao.cwo.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IExtendedJDBCAdapter;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.util.ArrayUtils;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.ItemId;
/*     */ import dtv.xst.dao.itm.impl.NonPhysicalItemDBA;
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
/*     */ public class TaskDBA
/*     */   extends NonPhysicalItemDBA
/*     */   implements IExtendedJDBCAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 2599333L;
/*     */   private Long _organizationId;
/*     */   private String _itemId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _categoryId;
/*     */   private String _priceType;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.item_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.category_id, t.price_type_enum FROM cwo_task t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND item_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  38 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  42 */     return "SELECT t.organization_id, t.item_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.category_id, t.price_type_enum FROM cwo_task t";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  49 */     return " WHERE organization_id = ?  AND item_id = ?  ";
/*     */   }
/*     */   
/*  52 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO cwo_task(organization_id, item_id, create_date, create_user_id, update_date, update_user_id, category_id, price_type_enum) VALUES (?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */ 
/*     */   
/*     */   public String[] getInsert() {
/*  56 */     return (String[])ArrayUtils.combine((Object[])super.getInsert(), (Object[])INSERT_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  61 */     Object[][] insertParameterObject = { { this._organizationId, this._itemId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._categoryId, this._priceType } };
/*  62 */     return (Object[][])ArrayUtils.combine((Object[])super.getInsertParameters(), (Object[])insertParameterObject);
/*     */   }
/*     */   
/*  65 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 91, 12, 91, 12, 12, 12 } };
/*     */ 
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  69 */     return (int[][])ArrayUtils.combine((Object[])super.getInsertParameterTypes(), (Object[])INSERT_PARAMETER_TYPES_OBJECT);
/*     */   }
/*     */   
/*  72 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE cwo_task SET update_date = ?, update_user_id = ?, category_id = ?, price_type_enum = ?" };
/*     */ 
/*     */   
/*     */   public String[] getUpdate() {
/*  76 */     return (String[])ArrayUtils.combine((Object[])super.getUpdate(), (Object[])UPDATE_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  81 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._categoryId, this._priceType } };
/*  82 */     return (Object[][])ArrayUtils.combine((Object[])super.getUpdateParameters(), (Object[])updateParameterObject);
/*     */   }
/*     */   
/*  85 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getUpdateParameterTypes() {
/*  88 */     return (int[][])ArrayUtils.combine((Object[])super.getUpdateParameterTypes(), (Object[])UPDATE_PARAMETER_TYPE_OBJECT);
/*     */   }
/*     */   
/*  91 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM cwo_task" };
/*     */   private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND item_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  95 */     return (String[])ArrayUtils.combine((Object[])super.getDelete(), (Object[])DELETE_OBJECT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 102 */     return " WHERE organization_id = ?  AND item_id = ?  ";
/*     */   }
/*     */   
/*     */   public Object[] getWhereParameters() {
/* 106 */     return new Object[] { this._organizationId, this._itemId };
/*     */   }
/*     */   
/* 109 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12 };
/*     */ 
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 113 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 117 */     return "cwo_task";
/*     */   }
/*     */ 
/*     */   
/*     */   public IFiller getFiller() {
/* 122 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 126 */     return new TaskFiller(this);
/*     */   }
/*     */   
/*     */   private static class TaskFiller
/*     */     implements IFiller {
/*     */     private TaskDBA _parent;
/*     */     
/*     */     public TaskFiller(TaskDBA argParent) {
/* 134 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 139 */       long primitiveResult = argResultSet.getLong(1);
/* 140 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 141 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 145 */       this._parent._itemId = argResultSet.getString(2);
/*     */       
/* 147 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 148 */       if (t3 != null) {
/* 149 */         this._parent._createDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 152 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 155 */       this._parent._createUserId = argResultSet.getString(4);
/*     */       
/* 157 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 158 */       if (t5 != null) {
/* 159 */         this._parent._updateDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 162 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 165 */       this._parent._updateUserId = argResultSet.getString(6);
/* 166 */       this._parent._categoryId = argResultSet.getString(7);
/* 167 */       this._parent._priceType = argResultSet.getString(8);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 173 */     super.loadDAO(argDAO);
/* 174 */     argDAO.suppressStateChanges(true);
/* 175 */     TaskDAO dao = (TaskDAO)argDAO;
/* 176 */     dao.setOrganizationId(this._organizationId);
/* 177 */     dao.setItemId(this._itemId);
/* 178 */     dao.setCreateDate(this._createDate);
/* 179 */     dao.setCreateUserId(this._createUserId);
/* 180 */     dao.setUpdateDate(this._updateDate);
/* 181 */     dao.setUpdateUserId(this._updateUserId);
/* 182 */     dao.setCategoryId(this._categoryId);
/* 183 */     dao.setPriceType(this._priceType);
/* 184 */     argDAO.suppressStateChanges(false);
/* 185 */     return (IDataAccessObject)dao;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 190 */     return loadDAO((IDataAccessObject)new TaskDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 195 */     TaskDAO dao = (TaskDAO)argDAO;
/* 196 */     super.fill((IDataAccessObject)dao);
/* 197 */     this._organizationId = dao.getOrganizationId();
/* 198 */     this._itemId = dao.getItemId();
/* 199 */     this._createDate = dao.getCreateDate();
/* 200 */     this._createUserId = dao.getCreateUserId();
/* 201 */     this._updateDate = dao.getUpdateDate();
/* 202 */     this._updateUserId = dao.getUpdateUserId();
/* 203 */     this._categoryId = dao.getCategoryId();
/* 204 */     this._priceType = dao.getPriceType();
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 209 */     ItemId id = (ItemId)argId;
/* 210 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 211 */     argStatement.setString(2, id.getItemId());
/* 212 */     return argStatement;
/*     */   }
/*     */   
/*     */   public String[] getAllSelects() {
/* 216 */     String[] sels = super.getAllSelects();
/* 217 */     String[] result = new String[sels.length + 1];
/* 218 */     result[0] = getSelectImpl();
/* 219 */     System.arraycopy(sels, 0, result, 1, sels.length);
/* 220 */     return result;
/*     */   }
/*     */   
/*     */   public IFiller[] getAllFillers() {
/* 224 */     IFiller[] fills = super.getAllFillers();
/* 225 */     IFiller[] result = new IFiller[fills.length + 1];
/* 226 */     result[0] = getFillerImpl();
/* 227 */     System.arraycopy(fills, 0, result, 1, fills.length);
/* 228 */     return result;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\impl\TaskDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */