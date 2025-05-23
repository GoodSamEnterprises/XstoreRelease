/*    */ package dtv.xst.dao.inv;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.crm.IParty;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IDocumentLineItemNote extends IDataModel, IHasDataProperty<IDocumentLineItemNoteProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_DOCUMENTID = new EventEnum("set documentId");
/* 12 */   public static final EventEnum SET_DOCUMENTTYPECODE = new EventEnum("set documentTypeCode");
/* 13 */   public static final EventEnum SET_INVENTORYDOCUMENTLINENUMBER = new EventEnum("set inventoryDocumentLineNumber");
/* 14 */   public static final EventEnum SET_NOTEID = new EventEnum("set noteId");
/* 15 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 16 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 17 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 18 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 19 */   public static final EventEnum SET_NOTEDATETIMESTAMP = new EventEnum("set noteDatetimestamp");
/* 20 */   public static final EventEnum SET_NOTE = new EventEnum("set note");
/* 21 */   public static final EventEnum SET_CREATORPARTYID = new EventEnum("set creatorPartyId");
/* 22 */   public static final EventEnum SET_NOTETYPE = new EventEnum("set noteType");
/* 23 */   public static final EventEnum SET_RECORDCREATIONTYPE = new EventEnum("set recordCreationType");
/* 24 */   public static final EventEnum SET_CREATORPARTY = new EventEnum("set CreatorParty");
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
/*    */   long getRetailLocationId();
/*    */   
/*    */   void setRetailLocationId(long paramLong);
/*    */   
/*    */   String getDocumentId();
/*    */   
/*    */   void setDocumentId(String paramString);
/*    */   
/*    */   String getDocumentTypeCode();
/*    */   
/*    */   void setDocumentTypeCode(String paramString);
/*    */   
/*    */   int getInventoryDocumentLineNumber();
/*    */   
/*    */   void setInventoryDocumentLineNumber(int paramInt);
/*    */   
/*    */   long getNoteId();
/*    */   
/*    */   void setNoteId(long paramLong);
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
/*    */   Date getNoteDatetimestamp();
/*    */   
/*    */   void setNoteDatetimestamp(Date paramDate);
/*    */   
/*    */   String getNote();
/*    */   
/*    */   void setNote(String paramString);
/*    */   
/*    */   long getCreatorPartyId();
/*    */   
/*    */   void setCreatorPartyId(long paramLong);
/*    */   
/*    */   String getNoteType();
/*    */   
/*    */   void setNoteType(String paramString);
/*    */   
/*    */   String getRecordCreationType();
/*    */   
/*    */   void setRecordCreationType(String paramString);
/*    */   
/*    */   IDataModel getDocumentLineItemNoteExt();
/*    */   
/*    */   void setDocumentLineItemNoteExt(IDataModel paramIDataModel);
/*    */   
/*    */   IParty getCreatorParty();
/*    */   
/*    */   void setCreatorParty(IParty paramIParty);
/*    */   
/*    */   List<IDocumentLineItemNoteProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IDocumentLineItemNoteProperty> paramList);
/*    */   
/*    */   void addDocumentLineItemNoteProperty(IDocumentLineItemNoteProperty paramIDocumentLineItemNoteProperty);
/*    */   
/*    */   void removeDocumentLineItemNoteProperty(IDocumentLineItemNoteProperty paramIDocumentLineItemNoteProperty);
/*    */   
/*    */   void setParentDocument(IInventoryDocumentLineItem paramIInventoryDocumentLineItem);
/*    */   
/*    */   IInventoryDocumentLineItem getParentDocument();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IDocumentLineItemNote.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */