/*     */ package dtv.xst.dao.trn.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trn.RainCheckId;
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
/*     */ public class RainCheckDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1279387060L;
/*     */   private Long _organizationId;
/*     */   private String _rainCheckId;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _itemId;
/*     */   private BigDecimal _salePrice;
/*     */   private Date _expirationBusinessDate;
/*     */   private Boolean _redeemedFlag;
/*     */   private Long _retailLocationId;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rain_check_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.item_id, t.sale_price, t.expiration_business_date, t.redeemed_flag, t.rtl_loc_id FROM trn_raincheck t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rain_check_id = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  40 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  44 */     return "SELECT t.organization_id, t.rain_check_id, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.item_id, t.sale_price, t.expiration_business_date, t.redeemed_flag, t.rtl_loc_id FROM trn_raincheck t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  50 */     return " WHERE organization_id = ?  AND rain_check_id = ?  ";
/*     */   }
/*     */   
/*  53 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO trn_raincheck(organization_id, rain_check_id, create_date, create_user_id, update_date, update_user_id, item_id, sale_price, expiration_business_date, redeemed_flag, rtl_loc_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  56 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  60 */     Object[][] insertParameterObject = { { this._organizationId, this._rainCheckId, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._itemId, this._salePrice, this._expirationBusinessDate, this._redeemedFlag, this._retailLocationId } };
/*  61 */     return insertParameterObject;
/*     */   }
/*     */   
/*  64 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 91, 12, 91, 12, 12, 3, 91, -7, -5 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  67 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  70 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE trn_raincheck SET update_date = ?, update_user_id = ?, item_id = ?, sale_price = ?, expiration_business_date = ?, redeemed_flag = ?, rtl_loc_id = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  73 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  77 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._itemId, this._salePrice, this._expirationBusinessDate, this._redeemedFlag, this._retailLocationId } };
/*  78 */     return updateParameterObject;
/*     */   }
/*     */   
/*  81 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 3, 91, -7, -5 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  83 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  86 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM trn_raincheck" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rain_check_id = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  89 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  95 */     return " WHERE organization_id = ?  AND rain_check_id = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/*  98 */     return new Object[] { this._organizationId, this._rainCheckId };
/*     */   }
/*     */   
/* 101 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 104 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 107 */     return "trn_raincheck";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 111 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 115 */     return new RainCheckFiller(this);
/*     */   }
/*     */   
/*     */   private static class RainCheckFiller
/*     */     implements IFiller {
/*     */     private RainCheckDBA _parent;
/*     */     
/*     */     public RainCheckFiller(RainCheckDBA argParent) {
/* 123 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 128 */       long primitiveResult = argResultSet.getLong(1);
/* 129 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 130 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */       
/* 134 */       this._parent._rainCheckId = argResultSet.getString(2);
/*     */       
/* 136 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 137 */       if (t3 != null) {
/* 138 */         this._parent._createDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 141 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 144 */       this._parent._createUserId = argResultSet.getString(4);
/*     */       
/* 146 */       Timestamp t5 = argResultSet.getTimestamp(5);
/* 147 */       if (t5 != null) {
/* 148 */         this._parent._updateDate = (Date)new DtvDate(t5.getTime());
/*     */       } else {
/*     */         
/* 151 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 154 */       this._parent._updateUserId = argResultSet.getString(6);
/* 155 */       this._parent._itemId = argResultSet.getString(7);
/* 156 */       this._parent._salePrice = argResultSet.getBigDecimal(8);
/*     */       
/* 158 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 159 */       if (t9 != null) {
/* 160 */         this._parent._expirationBusinessDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 163 */         this._parent._expirationBusinessDate = null;
/*     */       } 
/*     */       
/* 166 */       this._parent._redeemedFlag = Boolean.valueOf(argResultSet.getBoolean(10));
/*     */ 
/*     */       
/* 169 */       long l1 = argResultSet.getLong(11);
/* 170 */       if (l1 != 0L || argResultSet.getObject(11) != null) {
/* 171 */         this._parent._retailLocationId = Long.valueOf(l1);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 179 */     argDAO.suppressStateChanges(true);
/* 180 */     RainCheckDAO dao = (RainCheckDAO)argDAO;
/* 181 */     dao.setOrganizationId(this._organizationId);
/* 182 */     dao.setRainCheckId(this._rainCheckId);
/* 183 */     dao.setCreateDate(this._createDate);
/* 184 */     dao.setCreateUserId(this._createUserId);
/* 185 */     dao.setUpdateDate(this._updateDate);
/* 186 */     dao.setUpdateUserId(this._updateUserId);
/* 187 */     dao.setItemId(this._itemId);
/* 188 */     dao.setSalePrice(this._salePrice);
/* 189 */     dao.setExpirationBusinessDate(this._expirationBusinessDate);
/* 190 */     dao.setRedeemedFlag(this._redeemedFlag);
/* 191 */     dao.setRetailLocationId(this._retailLocationId);
/* 192 */     argDAO.suppressStateChanges(false);
/* 193 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 197 */     return loadDAO((IDataAccessObject)new RainCheckDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 201 */     RainCheckDAO dao = (RainCheckDAO)argDAO;
/* 202 */     this._organizationId = dao.getOrganizationId();
/* 203 */     this._rainCheckId = dao.getRainCheckId();
/* 204 */     this._createDate = dao.getCreateDate();
/* 205 */     this._createUserId = dao.getCreateUserId();
/* 206 */     this._updateDate = dao.getUpdateDate();
/* 207 */     this._updateUserId = dao.getUpdateUserId();
/* 208 */     this._itemId = dao.getItemId();
/* 209 */     this._salePrice = dao.getSalePrice();
/* 210 */     this._expirationBusinessDate = dao.getExpirationBusinessDate();
/* 211 */     this._redeemedFlag = (dao.getRedeemedFlag() != null) ? dao.getRedeemedFlag() : Boolean.valueOf(false);
/* 212 */     this._retailLocationId = dao.getRetailLocationId();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 216 */     RainCheckId id = (RainCheckId)argId;
/* 217 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 218 */     argStatement.setString(2, id.getRainCheckId());
/* 219 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 223 */     RainCheckId id = new RainCheckId();
/* 224 */     id.setOrganizationId(this._organizationId);
/* 225 */     id.setRainCheckId(this._rainCheckId);
/* 226 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 234 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 238 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\RainCheckDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */