/*    */ package dtv.xst.dao.prc;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.doc.IDocumentDefinition;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IDealDocumentXref extends IDataModel, IHasDataProperty<IDealDocumentXrefProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_DEALID = new EventEnum("set dealId");
/* 11 */   public static final EventEnum SET_SERIESID = new EventEnum("set seriesId");
/* 12 */   public static final EventEnum SET_DOCUMENTTYPE = new EventEnum("set documentType");
/* 13 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 14 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 15 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 16 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 17 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 18 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 19 */   public static final EventEnum ADD_DEALS = new EventEnum("add Deals");
/* 20 */   public static final EventEnum REMOVE_DEALS = new EventEnum("remove Deals");
/* 21 */   public static final EventEnum SET_DEALS = new EventEnum("set Deals");
/* 22 */   public static final EventEnum ADD_DOCDEFINITIONS = new EventEnum("add DocDefinitions");
/* 23 */   public static final EventEnum REMOVE_DOCDEFINITIONS = new EventEnum("remove DocDefinitions");
/* 24 */   public static final EventEnum SET_DOCDEFINITIONS = new EventEnum("set DocDefinitions");
/* 25 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 26 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 27 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 28 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 29 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 30 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getDealId();
/*    */   
/*    */   void setDealId(String paramString);
/*    */   
/*    */   String getSeriesId();
/*    */   
/*    */   void setSeriesId(String paramString);
/*    */   
/*    */   String getDocumentType();
/*    */   
/*    */   void setDocumentType(String paramString);
/*    */   
/*    */   String getOrgCode();
/*    */   
/*    */   void setOrgCode(String paramString);
/*    */   
/*    */   String getOrgValue();
/*    */   
/*    */   void setOrgValue(String paramString);
/*    */   
/*    */   Date getCreateDate();
/*    */   
/*    */   void setCreateDate(Date paramDate);
/*    */   
/*    */   String getCreateUserId();
/*    */   
/*    */   void setCreateUserId(String paramString);
/*    */   
/*    */   Date getUpdateDate();
/*    */   
/*    */   void setUpdateDate(Date paramDate);
/*    */   
/*    */   String getUpdateUserId();
/*    */   
/*    */   void setUpdateUserId(String paramString);
/*    */   
/*    */   IDataModel getDealDocumentXrefExt();
/*    */   
/*    */   void setDealDocumentXrefExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IDeal> getDeals();
/*    */   
/*    */   void setDeals(List<IDeal> paramList);
/*    */   
/*    */   void addDeal(IDeal paramIDeal);
/*    */   
/*    */   void removeDeal(IDeal paramIDeal);
/*    */   
/*    */   List<IDocumentDefinition> getDocDefinitions();
/*    */   
/*    */   void setDocDefinitions(List<IDocumentDefinition> paramList);
/*    */   
/*    */   void addDocumentDefinition(IDocumentDefinition paramIDocumentDefinition);
/*    */   
/*    */   void removeDocumentDefinition(IDocumentDefinition paramIDocumentDefinition);
/*    */   
/*    */   List<IDealDocumentXrefProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IDealDocumentXrefProperty> paramList);
/*    */   
/*    */   void addDealDocumentXrefProperty(IDealDocumentXrefProperty paramIDealDocumentXrefProperty);
/*    */   
/*    */   void removeDealDocumentXrefProperty(IDealDocumentXrefProperty paramIDealDocumentXrefProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\prc\IDealDocumentXref.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */