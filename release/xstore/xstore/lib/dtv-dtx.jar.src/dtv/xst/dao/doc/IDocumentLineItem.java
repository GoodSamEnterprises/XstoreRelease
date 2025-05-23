/*    */ package dtv.xst.dao.doc;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.trl.IRetailTransactionLineItem;
/*    */ import java.util.Date;
/*    */ 
/*    */ public interface IDocumentLineItem extends IDataModel, IDocumentLineItemModel, IRetailTransactionLineItem {
/*  9 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 10 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 11 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 12 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 13 */   public static final EventEnum SET_SERIESID = new EventEnum("set seriesId");
/* 14 */   public static final EventEnum SET_DOCUMENTID = new EventEnum("set documentId");
/* 15 */   public static final EventEnum SET_DOCUMENTTYPE = new EventEnum("set documentType");
/* 16 */   public static final EventEnum SET_ACTIVITYCODE = new EventEnum("set activityCode");
/* 17 */   public static final EventEnum SET_DOCUMENT = new EventEnum("set Document");
/* 18 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 19 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 20 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
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
/*    */   String getSeriesId();
/*    */   
/*    */   void setSeriesId(String paramString);
/*    */   
/*    */   String getDocumentId();
/*    */   
/*    */   void setDocumentId(String paramString);
/*    */   
/*    */   String getDocumentType();
/*    */   
/*    */   void setDocumentType(String paramString);
/*    */   
/*    */   String getActivityCode();
/*    */   
/*    */   void setActivityCode(String paramString);
/*    */   
/*    */   IDataModel getDocumentLineItemExt();
/*    */   
/*    */   void setDocumentLineItemExt(IDataModel paramIDataModel);
/*    */   
/*    */   IDocument getDocument();
/*    */   
/*    */   void setDocument(IDocument paramIDocument);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\doc\IDocumentLineItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */