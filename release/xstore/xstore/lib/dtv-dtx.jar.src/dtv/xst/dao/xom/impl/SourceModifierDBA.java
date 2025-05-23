/*     */ package dtv.xst.dao.xom.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.xom.SourceModifierId;
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
/*     */ public class SourceModifierDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1313951794L;
/*     */   private Long _organizationId;
/*     */   private String _orderId;
/*     */   private Integer _sequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _locationId;
/*     */   private String _locationType;
/*     */   private String _locationName1;
/*     */   private String _locationName2;
/*     */   private String _telephone1;
/*     */   private String _emailAddress;
/*     */   private Long _addressSequence;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.order_id, t.detail_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.loc_id, t.loc_type, t.loc_name1, t.loc_name2, t.telephone, t.email_address, t.address_seq FROM xom_source_mod t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND order_id = ?  AND detail_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  43 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  47 */     return "SELECT t.organization_id, t.order_id, t.detail_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.loc_id, t.loc_type, t.loc_name1, t.loc_name2, t.telephone, t.email_address, t.address_seq FROM xom_source_mod t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  53 */     return " WHERE organization_id = ?  AND order_id = ?  AND detail_seq = ?  ";
/*     */   }
/*     */   
/*  56 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO xom_source_mod(organization_id, order_id, detail_seq, create_date, create_user_id, update_date, update_user_id, loc_id, loc_type, loc_name1, loc_name2, telephone, email_address, address_seq) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  59 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  63 */     Object[][] insertParameterObject = { { this._organizationId, this._orderId, this._sequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._locationId, this._locationType, this._locationName1, this._locationName2, this._telephone1, this._emailAddress, this._addressSequence } };
/*  64 */     return insertParameterObject;
/*     */   }
/*     */   
/*  67 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 4, 91, 12, 91, 12, 12, 12, 12, 12, 12, 12, -5 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  70 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  73 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE xom_source_mod SET update_date = ?, update_user_id = ?, loc_id = ?, loc_type = ?, loc_name1 = ?, loc_name2 = ?, telephone = ?, email_address = ?, address_seq = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  76 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  80 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._locationId, this._locationType, this._locationName1, this._locationName2, this._telephone1, this._emailAddress, this._addressSequence } };
/*  81 */     return updateParameterObject;
/*     */   }
/*     */   
/*  84 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12, 12, 12, -5 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  86 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  89 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM xom_source_mod" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND order_id = ?  AND detail_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  92 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  98 */     return " WHERE organization_id = ?  AND order_id = ?  AND detail_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 101 */     return new Object[] { this._organizationId, this._orderId, this._sequence };
/*     */   }
/*     */   
/* 104 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 107 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 110 */     return "xom_source_mod";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 114 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 118 */     return new SourceModifierFiller(this);
/*     */   }
/*     */   
/*     */   private static class SourceModifierFiller
/*     */     implements IFiller {
/*     */     private SourceModifierDBA _parent;
/*     */     
/*     */     public SourceModifierFiller(SourceModifierDBA argParent) {
/* 126 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 131 */       long l1 = argResultSet.getLong(1);
/* 132 */       if (l1 != 0L || argResultSet.getObject(1) != null) {
/* 133 */         this._parent._organizationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 137 */       this._parent._orderId = argResultSet.getString(2);
/*     */ 
/*     */       
/* 140 */       int primitiveResult = argResultSet.getInt(3);
/* 141 */       if (primitiveResult != 0 || argResultSet.getObject(3) != null) {
/* 142 */         this._parent._sequence = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 147 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 148 */       if (t4 != null) {
/* 149 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 152 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 155 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 157 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 158 */       if (t6 != null) {
/* 159 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 162 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 165 */       this._parent._updateUserId = argResultSet.getString(7);
/* 166 */       this._parent._locationId = argResultSet.getString(8);
/* 167 */       this._parent._locationType = argResultSet.getString(9);
/* 168 */       this._parent._locationName1 = argResultSet.getString(10);
/* 169 */       this._parent._locationName2 = argResultSet.getString(11);
/* 170 */       this._parent._telephone1 = argResultSet.getString(12);
/* 171 */       this._parent._emailAddress = argResultSet.getString(13);
/*     */ 
/*     */       
/* 174 */       long l2 = argResultSet.getLong(14);
/* 175 */       if (l2 != 0L || argResultSet.getObject(14) != null) {
/* 176 */         this._parent._addressSequence = Long.valueOf(l2);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 184 */     argDAO.suppressStateChanges(true);
/* 185 */     SourceModifierDAO dao = (SourceModifierDAO)argDAO;
/* 186 */     dao.setOrganizationId(this._organizationId);
/* 187 */     dao.setOrderId(this._orderId);
/* 188 */     dao.setSequence(this._sequence);
/* 189 */     dao.setCreateDate(this._createDate);
/* 190 */     dao.setCreateUserId(this._createUserId);
/* 191 */     dao.setUpdateDate(this._updateDate);
/* 192 */     dao.setUpdateUserId(this._updateUserId);
/* 193 */     dao.setLocationId(this._locationId);
/* 194 */     dao.setLocationType(this._locationType);
/* 195 */     dao.setLocationName1(this._locationName1);
/* 196 */     dao.setLocationName2(this._locationName2);
/* 197 */     dao.setTelephone1(this._telephone1);
/* 198 */     dao.setEmailAddress(this._emailAddress);
/* 199 */     dao.setAddressSequence(this._addressSequence);
/* 200 */     argDAO.suppressStateChanges(false);
/* 201 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 205 */     return loadDAO((IDataAccessObject)new SourceModifierDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 209 */     SourceModifierDAO dao = (SourceModifierDAO)argDAO;
/* 210 */     this._organizationId = dao.getOrganizationId();
/* 211 */     this._orderId = dao.getOrderId();
/* 212 */     this._sequence = dao.getSequence();
/* 213 */     this._createDate = dao.getCreateDate();
/* 214 */     this._createUserId = dao.getCreateUserId();
/* 215 */     this._updateDate = dao.getUpdateDate();
/* 216 */     this._updateUserId = dao.getUpdateUserId();
/* 217 */     this._locationId = dao.getLocationId();
/* 218 */     this._locationType = dao.getLocationType();
/* 219 */     this._locationName1 = dao.getLocationName1();
/* 220 */     this._locationName2 = dao.getLocationName2();
/* 221 */     this._telephone1 = dao.getTelephone1();
/* 222 */     this._emailAddress = dao.getEmailAddress();
/* 223 */     this._addressSequence = dao.getAddressSequence();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 227 */     SourceModifierId id = (SourceModifierId)argId;
/* 228 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 229 */     argStatement.setString(2, id.getOrderId());
/* 230 */     argStatement.setInt(3, id.getSequence().intValue());
/* 231 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 235 */     SourceModifierId id = new SourceModifierId();
/* 236 */     id.setOrganizationId(this._organizationId);
/* 237 */     id.setOrderId(this._orderId);
/* 238 */     id.setSequence(this._sequence);
/* 239 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 247 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 251 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\SourceModifierDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */