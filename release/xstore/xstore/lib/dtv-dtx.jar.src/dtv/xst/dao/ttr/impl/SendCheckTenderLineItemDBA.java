/*     */ package dtv.xst.dao.ttr.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IExtendedJDBCAdapter;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
/*     */ import dtv.util.ArrayUtils;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.RetailTransactionLineItemId;
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
/*     */ public class SendCheckTenderLineItemDBA
/*     */   extends TenderLineItemDBA
/*     */   implements IExtendedJDBCAdapter
/*     */ {
/*     */   private static final long serialVersionUID = -1307877765L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Date _createDate;
/*     */   private String _createUserId;
/*     */   private Date _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _address1;
/*     */   private String _address2;
/*     */   private String _address3;
/*     */   private String _address4;
/*     */   private String _apartment;
/*     */   private String _city;
/*     */   private String _country;
/*     */   private String _payableToName;
/*     */   private String _postalCode;
/*     */   private String _state;
/*     */   private String _sendCheckReasonCode;
/*     */   private String _neighborhood;
/*     */   private String _county;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.payable_to_address, t.payable_to_address2, t.payable_to_address3, t.payable_to_address4, t.payable_to_apt, t.payable_to_city, t.payable_to_country, t.payable_to_name, t.payable_to_postal_code, t.payable_to_state, t.reascode, t.payable_to_neighborhood, t.payable_to_county FROM ttr_send_check_tndr_lineitm t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  53 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  57 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq, t.create_date, t.create_user_id, t.update_date, t.update_user_id, t.payable_to_address, t.payable_to_address2, t.payable_to_address3, t.payable_to_address4, t.payable_to_apt, t.payable_to_city, t.payable_to_country, t.payable_to_name, t.payable_to_postal_code, t.payable_to_state, t.reascode, t.payable_to_neighborhood, t.payable_to_county FROM ttr_send_check_tndr_lineitm t";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  64 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*  67 */   private static final String[] INSERT_OBJECT = new String[] { "INSERT INTO ttr_send_check_tndr_lineitm(organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, rtrans_lineitm_seq, create_date, create_user_id, update_date, update_user_id, payable_to_address, payable_to_address2, payable_to_address3, payable_to_address4, payable_to_apt, payable_to_city, payable_to_country, payable_to_name, payable_to_postal_code, payable_to_state, reascode, payable_to_neighborhood, payable_to_county) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" };
/*     */ 
/*     */   
/*     */   public String[] getInsert() {
/*  71 */     return (String[])ArrayUtils.combine((Object[])super.getInsert(), (Object[])INSERT_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getInsertParameters() {
/*  76 */     Object[][] insertParameterObject = { { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence, this._createDate, this._createUserId, this._updateDate, this._updateUserId, this._address1, this._address2, this._address3, this._address4, this._apartment, this._city, this._country, this._payableToName, this._postalCode, this._state, this._sendCheckReasonCode, this._neighborhood, this._county } };
/*  77 */     return (Object[][])ArrayUtils.combine((Object[])super.getInsertParameters(), (Object[])insertParameterObject);
/*     */   }
/*     */   
/*  80 */   private static final int[][] INSERT_PARAMETER_TYPES_OBJECT = new int[][] { { -5, -5, 91, -5, -5, 4, 91, 12, 91, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12 } };
/*     */ 
/*     */   
/*     */   public int[][] getInsertParameterTypes() {
/*  84 */     return (int[][])ArrayUtils.combine((Object[])super.getInsertParameterTypes(), (Object[])INSERT_PARAMETER_TYPES_OBJECT);
/*     */   }
/*     */   
/*  87 */   private static final String[] UPDATE_OBJECT = new String[] { "UPDATE ttr_send_check_tndr_lineitm SET update_date = ?, update_user_id = ?, payable_to_address = ?, payable_to_address2 = ?, payable_to_address3 = ?, payable_to_address4 = ?, payable_to_apt = ?, payable_to_city = ?, payable_to_country = ?, payable_to_name = ?, payable_to_postal_code = ?, payable_to_state = ?, reascode = ?, payable_to_neighborhood = ?, payable_to_county = ?" };
/*     */ 
/*     */   
/*     */   public String[] getUpdate() {
/*  91 */     return (String[])ArrayUtils.combine((Object[])super.getUpdate(), (Object[])UPDATE_OBJECT);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[][] getUpdateParameters() {
/*  96 */     Object[][] updateParameterObject = { { this._updateDate, this._updateUserId, this._address1, this._address2, this._address3, this._address4, this._apartment, this._city, this._country, this._payableToName, this._postalCode, this._state, this._sendCheckReasonCode, this._neighborhood, this._county } };
/*  97 */     return (Object[][])ArrayUtils.combine((Object[])super.getUpdateParameters(), (Object[])updateParameterObject);
/*     */   }
/*     */   
/* 100 */   private static final int[][] UPDATE_PARAMETER_TYPE_OBJECT = new int[][] { { 91, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12 } };
/*     */   
/*     */   public int[][] getUpdateParameterTypes() {
/* 103 */     return (int[][])ArrayUtils.combine((Object[])super.getUpdateParameterTypes(), (Object[])UPDATE_PARAMETER_TYPE_OBJECT);
/*     */   }
/*     */   
/* 106 */   private static final String[] DELETE_OBJECT = new String[] { "DELETE FROM ttr_send_check_tndr_lineitm" };
/*     */   private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String[] getDelete() {
/* 110 */     return (String[])ArrayUtils.combine((Object[])super.getDelete(), (Object[])DELETE_OBJECT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/* 117 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*     */   public Object[] getWhereParameters() {
/* 121 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence };
/*     */   }
/*     */   
/* 124 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5, 4 };
/*     */ 
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/* 128 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/* 132 */     return "ttr_send_check_tndr_lineitm";
/*     */   }
/*     */ 
/*     */   
/*     */   public IFiller getFiller() {
/* 137 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/* 141 */     return new SendCheckTenderLineItemFiller(this);
/*     */   }
/*     */   
/*     */   private static class SendCheckTenderLineItemFiller
/*     */     implements IFiller {
/*     */     private SendCheckTenderLineItemDBA _parent;
/*     */     
/*     */     public SendCheckTenderLineItemFiller(SendCheckTenderLineItemDBA argParent) {
/* 149 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/* 154 */       long primitiveResult = argResultSet.getLong(1);
/* 155 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/* 156 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 162 */       primitiveResult = argResultSet.getLong(2);
/* 163 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 164 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 169 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 170 */       if (t3 != null) {
/* 171 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 174 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 179 */       long l1 = argResultSet.getLong(4);
/* 180 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 181 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 187 */       l1 = argResultSet.getLong(5);
/* 188 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 189 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 195 */       int i = argResultSet.getInt(6);
/* 196 */       if (i != 0 || argResultSet.getObject(6) != null) {
/* 197 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 202 */       Timestamp t7 = argResultSet.getTimestamp(7);
/* 203 */       if (t7 != null) {
/* 204 */         this._parent._createDate = (Date)new DtvDate(t7.getTime());
/*     */       } else {
/*     */         
/* 207 */         this._parent._createDate = null;
/*     */       } 
/*     */       
/* 210 */       this._parent._createUserId = argResultSet.getString(8);
/*     */       
/* 212 */       Timestamp t9 = argResultSet.getTimestamp(9);
/* 213 */       if (t9 != null) {
/* 214 */         this._parent._updateDate = (Date)new DtvDate(t9.getTime());
/*     */       } else {
/*     */         
/* 217 */         this._parent._updateDate = null;
/*     */       } 
/*     */       
/* 220 */       this._parent._updateUserId = argResultSet.getString(10);
/* 221 */       this._parent._address1 = argResultSet.getString(11);
/* 222 */       this._parent._address2 = argResultSet.getString(12);
/* 223 */       this._parent._address3 = argResultSet.getString(13);
/* 224 */       this._parent._address4 = argResultSet.getString(14);
/* 225 */       this._parent._apartment = argResultSet.getString(15);
/* 226 */       this._parent._city = argResultSet.getString(16);
/* 227 */       this._parent._country = argResultSet.getString(17);
/* 228 */       this._parent._payableToName = argResultSet.getString(18);
/* 229 */       this._parent._postalCode = argResultSet.getString(19);
/* 230 */       this._parent._state = argResultSet.getString(20);
/* 231 */       this._parent._sendCheckReasonCode = argResultSet.getString(21);
/* 232 */       this._parent._neighborhood = argResultSet.getString(22);
/* 233 */       this._parent._county = argResultSet.getString(23);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 239 */     super.loadDAO(argDAO);
/* 240 */     argDAO.suppressStateChanges(true);
/* 241 */     SendCheckTenderLineItemDAO dao = (SendCheckTenderLineItemDAO)argDAO;
/* 242 */     dao.setOrganizationId(this._organizationId);
/* 243 */     dao.setRetailLocationId(this._retailLocationId);
/* 244 */     dao.setBusinessDate(this._businessDate);
/* 245 */     dao.setWorkstationId(this._workstationId);
/* 246 */     dao.setTransactionSequence(this._transactionSequence);
/* 247 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 248 */     dao.setCreateDate(this._createDate);
/* 249 */     dao.setCreateUserId(this._createUserId);
/* 250 */     dao.setUpdateDate(this._updateDate);
/* 251 */     dao.setUpdateUserId(this._updateUserId);
/* 252 */     dao.setAddress1(this._address1);
/* 253 */     dao.setAddress2(this._address2);
/* 254 */     dao.setAddress3(this._address3);
/* 255 */     dao.setAddress4(this._address4);
/* 256 */     dao.setApartment(this._apartment);
/* 257 */     dao.setCity(this._city);
/* 258 */     dao.setCountry(this._country);
/* 259 */     dao.setPayableToName(this._payableToName);
/* 260 */     dao.setPostalCode(this._postalCode);
/* 261 */     dao.setState(this._state);
/* 262 */     dao.setSendCheckReasonCode(this._sendCheckReasonCode);
/* 263 */     dao.setNeighborhood(this._neighborhood);
/* 264 */     dao.setCounty(this._county);
/* 265 */     argDAO.suppressStateChanges(false);
/* 266 */     return (IDataAccessObject)dao;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 271 */     return loadDAO((IDataAccessObject)new SendCheckTenderLineItemDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 276 */     SendCheckTenderLineItemDAO dao = (SendCheckTenderLineItemDAO)argDAO;
/* 277 */     super.fill((IDataAccessObject)dao);
/* 278 */     this._organizationId = dao.getOrganizationId();
/* 279 */     this._retailLocationId = dao.getRetailLocationId();
/* 280 */     this._businessDate = dao.getBusinessDate();
/* 281 */     this._workstationId = dao.getWorkstationId();
/* 282 */     this._transactionSequence = dao.getTransactionSequence();
/* 283 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/* 284 */     this._createDate = dao.getCreateDate();
/* 285 */     this._createUserId = dao.getCreateUserId();
/* 286 */     this._updateDate = dao.getUpdateDate();
/* 287 */     this._updateUserId = dao.getUpdateUserId();
/* 288 */     this._address1 = dao.getAddress1();
/* 289 */     this._address2 = dao.getAddress2();
/* 290 */     this._address3 = dao.getAddress3();
/* 291 */     this._address4 = dao.getAddress4();
/* 292 */     this._apartment = dao.getApartment();
/* 293 */     this._city = dao.getCity();
/* 294 */     this._country = dao.getCountry();
/* 295 */     this._payableToName = dao.getPayableToName();
/* 296 */     this._postalCode = dao.getPostalCode();
/* 297 */     this._state = dao.getState();
/* 298 */     this._sendCheckReasonCode = dao.getSendCheckReasonCode();
/* 299 */     this._neighborhood = dao.getNeighborhood();
/* 300 */     this._county = dao.getCounty();
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 305 */     RetailTransactionLineItemId id = (RetailTransactionLineItemId)argId;
/* 306 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 307 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 308 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 309 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 310 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 311 */     argStatement.setInt(6, id.getRetailTransactionLineItemSequence().intValue());
/* 312 */     return argStatement;
/*     */   }
/*     */   
/*     */   public String[] getAllSelects() {
/* 316 */     String[] sels = super.getAllSelects();
/* 317 */     String[] result = new String[sels.length + 1];
/* 318 */     result[0] = getSelectImpl();
/* 319 */     System.arraycopy(sels, 0, result, 1, sels.length);
/* 320 */     return result;
/*     */   }
/*     */   
/*     */   public IFiller[] getAllFillers() {
/* 324 */     IFiller[] fills = super.getAllFillers();
/* 325 */     IFiller[] result = new IFiller[fills.length + 1];
/* 326 */     result[0] = getFillerImpl();
/* 327 */     System.arraycopy(fills, 0, result, 1, fills.length);
/* 328 */     return result;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\SendCheckTenderLineItemDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */