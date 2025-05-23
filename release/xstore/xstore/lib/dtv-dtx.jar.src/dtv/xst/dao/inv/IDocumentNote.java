/*    */ package dtv.xst.dao.inv;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.xst.dao.crm.IParty;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IDocumentNote extends IDataModel, IHasDataProperty<IDocumentNoteProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_RETAILLOCATIONID = new EventEnum("set retailLocationId");
/* 11 */   public static final EventEnum SET_DOCUMENTID = new EventEnum("set documentId");
/* 12 */   public static final EventEnum SET_DOCUMENTTYPECODE = new EventEnum("set documentTypeCode");
/* 13 */   public static final EventEnum SET_NOTEID = new EventEnum("set noteId");
/* 14 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 15 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 16 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 17 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 18 */   public static final EventEnum SET_NOTEDATETIMESTAMP = new EventEnum("set noteDatetimestamp");
/* 19 */   public static final EventEnum SET_NOTE = new EventEnum("set note");
/* 20 */   public static final EventEnum SET_CREATORPARTYID = new EventEnum("set creatorPartyId");
/* 21 */   public static final EventEnum SET_NOTETYPE = new EventEnum("set noteType");
/* 22 */   public static final EventEnum SET_CREATORPARTY = new EventEnum("set CreatorParty");
/* 23 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 24 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 25 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 26 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 27 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 28 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   IDataModel getDocumentNoteExt();
/*    */   
/*    */   void setDocumentNoteExt(IDataModel paramIDataModel);
/*    */   
/*    */   IParty getCreatorParty();
/*    */   
/*    */   void setCreatorParty(IParty paramIParty);
/*    */   
/*    */   List<IDocumentNoteProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IDocumentNoteProperty> paramList);
/*    */   
/*    */   void addDocumentNoteProperty(IDocumentNoteProperty paramIDocumentNoteProperty);
/*    */   
/*    */   void removeDocumentNoteProperty(IDocumentNoteProperty paramIDocumentNoteProperty);
/*    */   
/*    */   void setParentDocument(IInventoryDocument paramIInventoryDocument);
/*    */   
/*    */   IInventoryDocument getParentDocument();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\IDocumentNote.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */