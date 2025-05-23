/*    */ package dtv.xst.dao.crm;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IPartyEmail extends IDataModel, IHasDataProperty<IPartyEmailProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_PARTYID = new EventEnum("set partyId");
/* 11 */   public static final EventEnum SET_SEQUENCE = new EventEnum("set sequence");
/* 12 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 13 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 14 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 15 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 16 */   public static final EventEnum SET_EMAILADDRESS = new EventEnum("set emailAddress");
/* 17 */   public static final EventEnum SET_EMAILTYPE = new EventEnum("set emailType");
/* 18 */   public static final EventEnum SET_EMAILFORMAT = new EventEnum("set emailFormat");
/* 19 */   public static final EventEnum SET_CONTACT = new EventEnum("set contact");
/* 20 */   public static final EventEnum SET_PRIMARY = new EventEnum("set primary");
/* 21 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 22 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 23 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 24 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 25 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 26 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   long getPartyId();
/*    */   
/*    */   void setPartyId(long paramLong);
/*    */   
/*    */   int getSequence();
/*    */   
/*    */   void setSequence(int paramInt);
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
/*    */   String getEmailAddress();
/*    */   
/*    */   void setEmailAddress(String paramString);
/*    */   
/*    */   String getEmailType();
/*    */   
/*    */   void setEmailType(String paramString);
/*    */   
/*    */   String getEmailFormat();
/*    */   
/*    */   void setEmailFormat(String paramString);
/*    */   
/*    */   boolean getContact();
/*    */   
/*    */   void setContact(boolean paramBoolean);
/*    */   
/*    */   boolean getPrimary();
/*    */   
/*    */   void setPrimary(boolean paramBoolean);
/*    */   
/*    */   IDataModel getPartyEmailExt();
/*    */   
/*    */   void setPartyEmailExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IPartyEmailProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IPartyEmailProperty> paramList);
/*    */   
/*    */   void addPartyEmailProperty(IPartyEmailProperty paramIPartyEmailProperty);
/*    */   
/*    */   void removePartyEmailProperty(IPartyEmailProperty paramIPartyEmailProperty);
/*    */   
/*    */   void setParentParty(IParty paramIParty);
/*    */   
/*    */   IParty getParentParty();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\IPartyEmail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */