/*     */ package dtv.xst.query.results;
/*     */ 
/*     */ import dtv.data2.access.AbstractQueryResult;
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ObjectNotFoundException;
/*     */ import dtv.xst.dao.doc.DocumentDefinitionId;
/*     */ import dtv.xst.dao.prc.DealId;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DocumentDealQueryResult
/*     */   extends AbstractQueryResult
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private long _organizationId;
/*     */   private String _dealId;
/*     */   private String _seriesId;
/*     */   private String _documentType;
/*     */   
/*     */   public String getDealId() {
/*  34 */     return this._dealId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IObjectId getDealObjectId() {
/*  43 */     DealId id = new DealId();
/*  44 */     id.setOrganizationId(Long.valueOf(getOrganizationId()));
/*  45 */     id.setDealId(getDealId());
/*  46 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IObjectId getDocumentDefObjectId() {
/*  55 */     DocumentDefinitionId id = new DocumentDefinitionId();
/*     */     
/*  57 */     id.setOrganizationId(Long.valueOf(getOrganizationId()));
/*  58 */     id.setDocumentType(getDataSource());
/*  59 */     id.setSeriesId(getDataSource());
/*     */     
/*  61 */     return (IObjectId)id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDocumentType() {
/*  70 */     return this._documentType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/*  79 */     return this._organizationId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataModel getPopulatedDealObject() {
/*     */     try {
/*  89 */       Object obj = DataFactory.getObjectById(getDealObjectId());
/*  90 */       return (obj != null) ? (IDataModel)obj : null;
/*     */     }
/*  92 */     catch (ObjectNotFoundException ex) {
/*  93 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataModel getPopulatedDocumentDefObject() {
/*     */     try {
/* 104 */       Object obj = DataFactory.getObjectById(getDocumentDefObjectId());
/* 105 */       return (obj != null) ? (IDataModel)obj : null;
/*     */     }
/* 107 */     catch (ObjectNotFoundException ex) {
/* 108 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSeriesId() {
/* 118 */     return this._seriesId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDealId(String argDealId) {
/* 127 */     this._dealId = argDealId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentType(String argDocumentType) {
/* 136 */     this._documentType = argDocumentType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 145 */     this._organizationId = argOrganizationId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSeriesId(String argSeriesId) {
/* 154 */     this._seriesId = argSeriesId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected IObjectId getObjectIdImpl() {
/* 160 */     return getDealObjectId();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\DocumentDealQueryResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */