/*     */ package dtv.xst.dao.xom.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.xom.FulfillmentModifierId;
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
/*     */ public class FulfillmentModifierDBA
/*     */   implements IJDBCTableAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -914701643L;
/*     */   private Long _organizationId;
/*     */   private String _orderId;
/*     */   private Integer _sequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _locationId;
/*     */   private String _organizationName;
/*     */   private String _salutation;
/*     */   private String _locationName1;
/*     */   private String _locationName2;
/*     */   private String _middleName;
/*     */   private String _suffix;
/*     */   private Long _addressSequence;
/*     */   private String _telephone1;
/*     */   private String _emailAddress;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.order_id, t.detail_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.loc_id, t.organization_name, t.salutation, t.loc_name1, t.loc_name2, t.middle_name, t.suffix, t.address_seq, t.telephone, t.email_address FROM xom_fulfillment_mod t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND order_id = ?  AND detail_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  46 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  50 */     return "SELECT t.organization_id, t.order_id, t.detail_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.loc_id, t.organization_name, t.salutation, t.loc_name1, t.loc_name2, t.middle_name, t.suffix, t.address_seq, t.telephone, t.email_address FROM xom_fulfillment_mod t";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  56 */     return " WHERE organization_id = ?  AND order_id = ?  AND detail_seq = ?  ";
/*     */   }
/*     */   
/*  59 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO xom_fulfillment_mod(organization_id, order_id, detail_seq, create_date, create_user_id, update_date, update_user_id, loc_id, organization_name, salutation, loc_name1, loc_name2, middle_name, suffix, address_seq, telephone, email_address) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */   
/*     */   public String[] getInsert() {
/*  62 */     return INSERT_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  66 */     Object[][] insertParameterObject = { { this._organizationId, this._orderId, this._sequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._locationId, this._organizationName, this._salutation, this._locationName1, this._locationName2, this._middleName, this._suffix, this._addressSequence, this._telephone1, this._emailAddress } };
/*  67 */     return insertParameterObject;
/*     */   }
/*     */   
/*  70 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, 12, 4, 91, 12, 91, 12, 12, 12, 12, 12, 12, 12, 12, -5, 12, 12 } };
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  73 */     return INSERT_PARAMETER_TYPES_OBJECT;
/*     */   }
/*     */   
/*  76 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE xom_fulfillment_mod SET update_date = ?, update_user_id = ?, loc_id = ?, organization_name = ?, salutation = ?, loc_name1 = ?, loc_name2 = ?, middle_name = ?, suffix = ?, address_seq = ?, telephone = ?, email_address = ?" };
/*     */   
/*     */   public String[] getUpdate() {
/*  79 */     return UPDATE_OBJECT;
/*     */   }
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  83 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._locationId, this._organizationName, this._salutation, this._locationName1, this._locationName2, this._middleName, this._suffix, this._addressSequence, this._telephone1, this._emailAddress } };
/*  84 */     return updateParameterObject;
/*     */   }
/*     */   
/*  87 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12, 12, 12, 12, -5, 12, 12 } };
/*     */   public int[][] getUpdateParameterTypes() {
/*  89 */     return UPDATE_PARAMETER_TYPE_OBJECT;
/*     */   }
/*     */   
/*  92 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM xom_fulfillment_mod" }; private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND order_id = ?  AND detail_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/*  95 */     return DELETE_OBJECT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 101 */     return " WHERE organization_id = ?  AND order_id = ?  AND detail_seq = ?  ";
/*     */   }
/*     */   public Object[] getWhereParameters() {
/* 104 */     return new Object[] { this._organizationId, this._orderId, this._sequence };
/*     */   }
/*     */   
/* 107 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, 12, 4 };
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 110 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   public String getTableName() {
/* 113 */     return "xom_fulfillment_mod";
/*     */   }
/*     */   
/*     */   public IFiller getFiller() {
/* 117 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 121 */     return new FulfillmentModifierFiller(this);
/*     */   }
/*     */   
/*     */   private static class FulfillmentModifierFiller
/*     */     implements IFiller {
/*     */     private FulfillmentModifierDBA _parent;
/*     */     
/*     */     public FulfillmentModifierFiller(FulfillmentModifierDBA argParent) {
/* 129 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 134 */       long l1 = argResultSet.getLong(1);
/* 135 */       if (l1 != 0L || argResultSet.getObject(1) != null) {
/* 136 */         this._parent._organizationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */       
/* 140 */       this._parent._orderId = argResultSet.getString(2);
/*     */ 
/*     */       
/* 143 */       int primitiveResult = argResultSet.getInt(3);
/* 144 */       if (primitiveResult != 0 || argResultSet.getObject(3) != null) {
/* 145 */         this._parent._sequence = Integer.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 150 */       Timestamp t4 = argResultSet.getTimestamp(4);
/* 151 */       if (t4 != null) {
/* 152 */         this._parent._createDate = (Date)new DtvDate(t4.getTime());
/*     */       } else {
/*     */         
/* 155 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 158 */       this._parent._createUserId = argResultSet.getString(5);
/*     */       
/* 160 */       Timestamp t6 = argResultSet.getTimestamp(6);
/* 161 */       if (t6 != null) {
/* 162 */         this._parent._updateDate = (Date)new DtvDate(t6.getTime());
/*     */       } else {
/*     */         
/* 165 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 168 */       this._parent._updateUserId = argResultSet.getString(7);
/* 169 */       this._parent._locationId = argResultSet.getString(8);
/* 170 */       this._parent._organizationName = argResultSet.getString(9);
/* 171 */       this._parent._salutation = argResultSet.getString(10);
/* 172 */       this._parent._locationName1 = argResultSet.getString(11);
/* 173 */       this._parent._locationName2 = argResultSet.getString(12);
/* 174 */       this._parent._middleName = argResultSet.getString(13);
/* 175 */       this._parent._suffix = argResultSet.getString(14);
/*     */ 
/*     */       
/* 178 */       long l2 = argResultSet.getLong(15);
/* 179 */       if (l2 != 0L || argResultSet.getObject(15) != null) {
/* 180 */         this._parent._addressSequence = Long.valueOf(l2);
/*     */       }
/*     */ 
/*     */       
/* 184 */       this._parent._telephone1 = argResultSet.getString(16);
/* 185 */       this._parent._emailAddress = argResultSet.getString(17);
/*     */     }
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 190 */     argDAO.suppressStateChanges(true);
/* 191 */     FulfillmentModifierDAO dao = (FulfillmentModifierDAO)argDAO;
/* 192 */     dao.setOrganizationId(this._organizationId);
/* 193 */     dao.setOrderId(this._orderId);
/* 194 */     dao.setSequence(this._sequence);
/* 195 */     dao.setCreateDate(this._createDate);
/* 196 */     dao.setCreateUserId(this._createUserId);
/* 197 */     dao.setUpdateDate(this._updateDate);
/* 198 */     dao.setUpdateUserId(this._updateUserId);
/* 199 */     dao.setLocationId(this._locationId);
/* 200 */     dao.setOrganizationName(this._organizationName);
/* 201 */     dao.setSalutation(this._salutation);
/* 202 */     dao.setLocationName1(this._locationName1);
/* 203 */     dao.setLocationName2(this._locationName2);
/* 204 */     dao.setMiddleName(this._middleName);
/* 205 */     dao.setSuffix(this._suffix);
/* 206 */     dao.setAddressSequence(this._addressSequence);
/* 207 */     dao.setTelephone1(this._telephone1);
/* 208 */     dao.setEmailAddress(this._emailAddress);
/* 209 */     argDAO.suppressStateChanges(false);
/* 210 */     return (IDataAccessObject)dao;
/*     */   }
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 214 */     return loadDAO((IDataAccessObject)new FulfillmentModifierDAO());
/*     */   }
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 218 */     FulfillmentModifierDAO dao = (FulfillmentModifierDAO)argDAO;
/* 219 */     this._organizationId = dao.getOrganizationId();
/* 220 */     this._orderId = dao.getOrderId();
/* 221 */     this._sequence = dao.getSequence();
/* 222 */     this._createDate = dao.getCreateDate();
/* 223 */     this._createUserId = dao.getCreateUserId();
/* 224 */     this._updateDate = dao.getUpdateDate();
/* 225 */     this._updateUserId = dao.getUpdateUserId();
/* 226 */     this._locationId = dao.getLocationId();
/* 227 */     this._organizationName = dao.getOrganizationName();
/* 228 */     this._salutation = dao.getSalutation();
/* 229 */     this._locationName1 = dao.getLocationName1();
/* 230 */     this._locationName2 = dao.getLocationName2();
/* 231 */     this._middleName = dao.getMiddleName();
/* 232 */     this._suffix = dao.getSuffix();
/* 233 */     this._addressSequence = dao.getAddressSequence();
/* 234 */     this._telephone1 = dao.getTelephone1();
/* 235 */     this._emailAddress = dao.getEmailAddress();
/*     */   }
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 239 */     FulfillmentModifierId id = (FulfillmentModifierId)argId;
/* 240 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 241 */     argStatement.setString(2, id.getOrderId());
/* 242 */     argStatement.setInt(3, id.getSequence().intValue());
/* 243 */     return argStatement;
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 247 */     FulfillmentModifierId id = new FulfillmentModifierId();
/* 248 */     id.setOrganizationId(this._organizationId);
/* 249 */     id.setOrderId(this._orderId);
/* 250 */     id.setSequence(this._sequence);
/* 251 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IJDBCTableAdapter argAdapter) {}
/*     */ 
/*     */   
/*     */   public boolean isExtensible() {
/* 259 */     return false;
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 263 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\FulfillmentModifierDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */