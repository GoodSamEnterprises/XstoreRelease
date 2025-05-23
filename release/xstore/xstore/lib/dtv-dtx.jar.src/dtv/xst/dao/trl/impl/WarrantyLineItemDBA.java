/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataAccessObject;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.jdbc.IExtendedJDBCAdapter;
/*     */ import dtv.data2.access.impl.jdbc.IFiller;
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
/*     */ public class WarrantyLineItemDBA
/*     */   extends SaleReturnLineItemDBA
/*     */   implements IExtendedJDBCAdapter
/*     */ {
/*     */   private static final long serialVersionUID = 1958048355L;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Date _businessDate;
/*     */   private Long _workstationId;
/*     */   private Long _transactionSequence;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private static final String SELECT_OBJECT = "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq FROM trl_sale_lineitm t";
/*     */   private static final String SELECT_WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   private static final String WHERE_OBJECT = " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   
/*     */   public String getSelect() {
/*  36 */     return getSelectImpl();
/*     */   }
/*     */   
/*     */   private String getSelectImpl() {
/*  40 */     return "SELECT t.organization_id, t.rtl_loc_id, t.business_date, t.wkstn_id, t.trans_seq, t.rtrans_lineitm_seq FROM trl_sale_lineitm t";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSelectWhere() {
/*  47 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWhere() {
/*  54 */     return " WHERE organization_id = ?  AND rtl_loc_id = ?  AND business_date = ?  AND wkstn_id = ?  AND trans_seq = ?  AND rtrans_lineitm_seq = ?  ";
/*     */   }
/*     */   
/*     */   public Object[] getWhereParameters() {
/*  58 */     return new Object[] { this._organizationId, this._retailLocationId, this._businessDate, this._workstationId, this._transactionSequence, this._retailTransactionLineItemSequence };
/*     */   }
/*     */   
/*  61 */   private static final int[] WHERE_PARAMETER_OBJECT = new int[] { -5, -5, 91, -5, -5, 4 };
/*     */ 
/*     */   
/*     */   public int[] getWhereParameterTypes() {
/*  65 */     return WHERE_PARAMETER_OBJECT;
/*     */   }
/*     */   
/*     */   public String getTableName() {
/*  69 */     return "trl_sale_lineitm";
/*     */   }
/*     */ 
/*     */   
/*     */   public IFiller getFiller() {
/*  74 */     return getFillerImpl();
/*     */   }
/*     */   
/*     */   private IFiller getFillerImpl() {
/*  78 */     return new WarrantyLineItemFiller(this);
/*     */   }
/*     */   
/*     */   private static class WarrantyLineItemFiller
/*     */     implements IFiller {
/*     */     private WarrantyLineItemDBA _parent;
/*     */     
/*     */     public WarrantyLineItemFiller(WarrantyLineItemDBA argParent) {
/*  86 */       this._parent = argParent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(ResultSet argResultSet) throws SQLException {
/*  91 */       long primitiveResult = argResultSet.getLong(1);
/*  92 */       if (primitiveResult != 0L || argResultSet.getObject(1) != null) {
/*  93 */         this._parent._organizationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  99 */       primitiveResult = argResultSet.getLong(2);
/* 100 */       if (primitiveResult != 0L || argResultSet.getObject(2) != null) {
/* 101 */         this._parent._retailLocationId = Long.valueOf(primitiveResult);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 106 */       Timestamp t3 = argResultSet.getTimestamp(3);
/* 107 */       if (t3 != null) {
/* 108 */         this._parent._businessDate = (Date)new DtvDate(t3.getTime());
/*     */       } else {
/*     */         
/* 111 */         this._parent._businessDate = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 116 */       long l1 = argResultSet.getLong(4);
/* 117 */       if (l1 != 0L || argResultSet.getObject(4) != null) {
/* 118 */         this._parent._workstationId = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 124 */       l1 = argResultSet.getLong(5);
/* 125 */       if (l1 != 0L || argResultSet.getObject(5) != null) {
/* 126 */         this._parent._transactionSequence = Long.valueOf(l1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 132 */       int i = argResultSet.getInt(6);
/* 133 */       if (i != 0 || argResultSet.getObject(6) != null) {
/* 134 */         this._parent._retailTransactionLineItemSequence = Integer.valueOf(i);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDAO(IDataAccessObject argDAO) {
/* 143 */     super.loadDAO(argDAO);
/* 144 */     argDAO.suppressStateChanges(true);
/* 145 */     WarrantyLineItemDAO dao = (WarrantyLineItemDAO)argDAO;
/* 146 */     dao.setOrganizationId(this._organizationId);
/* 147 */     dao.setRetailLocationId(this._retailLocationId);
/* 148 */     dao.setBusinessDate(this._businessDate);
/* 149 */     dao.setWorkstationId(this._workstationId);
/* 150 */     dao.setTransactionSequence(this._transactionSequence);
/* 151 */     dao.setRetailTransactionLineItemSequence(this._retailTransactionLineItemSequence);
/* 152 */     argDAO.suppressStateChanges(false);
/* 153 */     return (IDataAccessObject)dao;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDataAccessObject loadDefaultDAO() {
/* 158 */     return loadDAO((IDataAccessObject)new WarrantyLineItemDAO());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fill(IDataAccessObject argDAO) {
/* 163 */     WarrantyLineItemDAO dao = (WarrantyLineItemDAO)argDAO;
/* 164 */     super.fill((IDataAccessObject)dao);
/* 165 */     this._organizationId = dao.getOrganizationId();
/* 166 */     this._retailLocationId = dao.getRetailLocationId();
/* 167 */     this._businessDate = dao.getBusinessDate();
/* 168 */     this._workstationId = dao.getWorkstationId();
/* 169 */     this._transactionSequence = dao.getTransactionSequence();
/* 170 */     this._retailTransactionLineItemSequence = dao.getRetailTransactionLineItemSequence();
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement writeObjectId(IObjectId argId, PreparedStatement argStatement) throws SQLException {
/* 175 */     RetailTransactionLineItemId id = (RetailTransactionLineItemId)argId;
/* 176 */     argStatement.setLong(1, id.getOrganizationId().longValue());
/* 177 */     argStatement.setLong(2, id.getRetailLocationId().longValue());
/* 178 */     argStatement.setTimestamp(3, new Timestamp(id.getBusinessDate().getTime()));
/* 179 */     argStatement.setLong(4, id.getWorkstationId().longValue());
/* 180 */     argStatement.setLong(5, id.getTransactionSequence().longValue());
/* 181 */     argStatement.setInt(6, id.getRetailTransactionLineItemSequence().intValue());
/* 182 */     return argStatement;
/*     */   }
/*     */   
/*     */   public String[] getAllSelects() {
/* 186 */     String[] sels = super.getAllSelects();
/* 187 */     String[] result = new String[sels.length + 1];
/* 188 */     result[0] = getSelectImpl();
/* 189 */     System.arraycopy(sels, 0, result, 1, sels.length);
/* 190 */     return result;
/*     */   }
/*     */   
/*     */   public IFiller[] getAllFillers() {
/* 194 */     IFiller[] fills = super.getAllFillers();
/* 195 */     IFiller[] result = new IFiller[fills.length + 1];
/* 196 */     result[0] = getFillerImpl();
/* 197 */     System.arraycopy(fills, 0, result, 1, fills.length);
/* 198 */     return result;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\WarrantyLineItemDBA.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */