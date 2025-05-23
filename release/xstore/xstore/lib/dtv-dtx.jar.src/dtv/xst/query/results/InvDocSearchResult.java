/*     */ package dtv.xst.query.results;
/*     */ 
/*     */ import dtv.data2.access.AbstractQueryResult;
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.xst.dao.inv.IInventoryDocument;
/*     */ import dtv.xst.dao.inv.InventoryDocumentId;
/*     */ import java.util.Date;
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
/*     */ 
/*     */ 
/*     */ public class InvDocSearchResult
/*     */   extends AbstractQueryResult
/*     */ {
/*     */   private static final long serialVersionUID = 8675309L;
/*     */   private long _organizationId;
/*     */   private String _dataSource;
/*     */   private String _documentId;
/*     */   private String _statusCode;
/*     */   private String _description;
/*     */   private String _destinationName;
/*     */   private String _docType;
/*     */   private String _docSubType;
/*     */   private String _recordCreationType;
/*     */   private Date _expectedDeliveryDate;
/*     */   private Date _lastActivityDate;
/*     */   private Date _createDateTime;
/*     */   private Long _retailLocationId;
/*     */   private Date _expectedShipDate;
/*     */   private IInventoryDocument _fullyRealizedDocument;
/*     */   private String _referenceId;
/*     */   
/*     */   public Date getCreateDateTime() {
/*  48 */     return this._createDateTime;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDataSource() {
/*  54 */     return this._dataSource;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/*  63 */     return this._description;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDestinationName() {
/*  72 */     return this._destinationName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDocSubType() {
/*  81 */     return this._docSubType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDocType() {
/*  90 */     return this._docType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDocumentId() {
/*  99 */     return this._documentId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getExpectedDeliveryDate() {
/* 108 */     return this._expectedDeliveryDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getExpectedShipDate() {
/* 117 */     return this._expectedShipDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getLastActivityDate() {
/* 126 */     return this._lastActivityDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getOrganizationId() {
/* 135 */     return this._organizationId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IDataModel getPopulatedObject() {
/* 143 */     if (this._fullyRealizedDocument != null) {
/* 144 */       return (IDataModel)this._fullyRealizedDocument;
/*     */     }
/* 146 */     InventoryDocumentId id = (InventoryDocumentId)getObjectId();
/* 147 */     Object obj = DataFactory.getObjectById((IObjectId)id);
/*     */     
/* 149 */     return (obj != null) ? (IDataModel)obj : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRecordCreationType() {
/* 158 */     return this._recordCreationType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getReferenceId() {
/* 167 */     return this._referenceId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getRetailLocationId() {
/* 176 */     return this._retailLocationId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStatusCode() {
/* 185 */     return this._statusCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void putExpectedDeliveryDate(Object o1, Object o2) {
/* 195 */     this._expectedDeliveryDate = (Date)o1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreateDateTime(Date createDateTime) {
/* 204 */     this._createDateTime = createDateTime;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDataSource(String argDataSource) {
/* 210 */     this._dataSource = argDataSource;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String description) {
/* 219 */     this._description = description;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDestinationName(String destinationName) {
/* 228 */     this._destinationName = destinationName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocSubType(String docSubType) {
/* 237 */     this._docSubType = docSubType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocType(String docType) {
/* 246 */     this._docType = docType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentId(String documentId) {
/* 255 */     this._documentId = documentId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
/* 264 */     this._expectedDeliveryDate = expectedDeliveryDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExpectedShipDate(Date expectedShipDate) {
/* 273 */     this._expectedShipDate = expectedShipDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLastActivityDate(Date lastActivityDate) {
/* 282 */     this._lastActivityDate = lastActivityDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrganizationId(long argOrganizationId) {
/* 291 */     this._organizationId = argOrganizationId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPopulatedObject(IInventoryDocument argDoc) {
/* 300 */     this._fullyRealizedDocument = argDoc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRecordCreationType(String recordCreationType) {
/* 309 */     this._recordCreationType = recordCreationType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReferenceId(String argReferenceId) {
/* 318 */     this._referenceId = argReferenceId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/* 327 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStatusCode(String statusCode) {
/* 336 */     this._statusCode = statusCode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected IObjectId getObjectIdImpl() {
/* 342 */     InventoryDocumentId id = new InventoryDocumentId();
/* 343 */     id.setOrganizationId(Long.valueOf(this._organizationId));
/* 344 */     id.setRetailLocationId(this._retailLocationId);
/* 345 */     id.setDocumentId(this._documentId);
/* 346 */     id.setDocumentTypeCode(this._docType);
/* 347 */     return (IObjectId)id;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\InvDocSearchResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */