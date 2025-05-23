/*    */ package dtv.xst.dao.ttr;
/*    */ 
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ 
/*    */ public interface ISendCheckTenderLineItem extends IDataModel, ISendCheckTenderLineItemModel, ITenderLineItem {
/*  9 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 10 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 11 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 12 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 13 */   public static final EventEnum SET_ADDRESS1 = new EventEnum("set address1");
/* 14 */   public static final EventEnum SET_ADDRESS2 = new EventEnum("set address2");
/* 15 */   public static final EventEnum SET_ADDRESS3 = new EventEnum("set address3");
/* 16 */   public static final EventEnum SET_ADDRESS4 = new EventEnum("set address4");
/* 17 */   public static final EventEnum SET_APARTMENT = new EventEnum("set apartment");
/* 18 */   public static final EventEnum SET_CITY = new EventEnum("set city");
/* 19 */   public static final EventEnum SET_COUNTRY = new EventEnum("set country");
/* 20 */   public static final EventEnum SET_PAYABLETONAME = new EventEnum("set payableToName");
/* 21 */   public static final EventEnum SET_POSTALCODE = new EventEnum("set postalCode");
/* 22 */   public static final EventEnum SET_STATE = new EventEnum("set state");
/* 23 */   public static final EventEnum SET_SENDCHECKREASONCODE = new EventEnum("set sendCheckReasonCode");
/* 24 */   public static final EventEnum SET_NEIGHBORHOOD = new EventEnum("set neighborhood");
/* 25 */   public static final EventEnum SET_COUNTY = new EventEnum("set county");
/* 26 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 27 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 28 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
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
/*    */   String getAddress1();
/*    */   
/*    */   void setAddress1(String paramString);
/*    */   
/*    */   String getAddress2();
/*    */   
/*    */   void setAddress2(String paramString);
/*    */   
/*    */   String getAddress3();
/*    */   
/*    */   void setAddress3(String paramString);
/*    */   
/*    */   String getAddress4();
/*    */   
/*    */   void setAddress4(String paramString);
/*    */   
/*    */   String getApartment();
/*    */   
/*    */   void setApartment(String paramString);
/*    */   
/*    */   String getCity();
/*    */   
/*    */   void setCity(String paramString);
/*    */   
/*    */   String getCountry();
/*    */   
/*    */   void setCountry(String paramString);
/*    */   
/*    */   String getPayableToName();
/*    */   
/*    */   void setPayableToName(String paramString);
/*    */   
/*    */   String getPostalCode();
/*    */   
/*    */   void setPostalCode(String paramString);
/*    */   
/*    */   String getState();
/*    */   
/*    */   void setState(String paramString);
/*    */   
/*    */   String getSendCheckReasonCode();
/*    */   
/*    */   void setSendCheckReasonCode(String paramString);
/*    */   
/*    */   String getNeighborhood();
/*    */   
/*    */   void setNeighborhood(String paramString);
/*    */   
/*    */   String getCounty();
/*    */   
/*    */   void setCounty(String paramString);
/*    */   
/*    */   IDataModel getSendCheckTenderLineItemExt();
/*    */   
/*    */   void setSendCheckTenderLineItemExt(IDataModel paramIDataModel);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\ISendCheckTenderLineItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */