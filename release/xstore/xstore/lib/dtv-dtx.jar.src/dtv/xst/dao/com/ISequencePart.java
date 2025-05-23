/*    */ package dtv.xst.dao.com;
/*    */ import dtv.data2.access.IDataAccessObject;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ISequencePart extends IDataModel, IHasDataProperty<ISequencePartProperty> {
/*  9 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 10 */   public static final EventEnum SET_SEQUENCEID = new EventEnum("set sequenceId");
/* 11 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 12 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 13 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 14 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 15 */   public static final EventEnum SET_PREFIX = new EventEnum("set prefix");
/* 16 */   public static final EventEnum SET_SUFFIX = new EventEnum("set suffix");
/* 17 */   public static final EventEnum SET_ENCODE = new EventEnum("set encode");
/* 18 */   public static final EventEnum SET_CHECKDIGITALGORITHM = new EventEnum("set checkDigitAlgorithm");
/* 19 */   public static final EventEnum SET_NUMERIC = new EventEnum("set numeric");
/* 20 */   public static final EventEnum SET_PADLENGTH = new EventEnum("set padLength");
/* 21 */   public static final EventEnum SET_PADCHARACTER = new EventEnum("set padCharacter");
/* 22 */   public static final EventEnum SET_INITIALVALUE = new EventEnum("set initialValue");
/* 23 */   public static final EventEnum SET_MAXVALUE = new EventEnum("set maxValue");
/* 24 */   public static final EventEnum SET_VALUEINCREMENT = new EventEnum("set valueIncrement");
/* 25 */   public static final EventEnum SET_INCLUDESTOREID = new EventEnum("set includeStoreId");
/* 26 */   public static final EventEnum SET_STOREPADLENGTH = new EventEnum("set storePadLength");
/* 27 */   public static final EventEnum SET_INCLUDEWORKSTATIONID = new EventEnum("set includeWorkstationId");
/* 28 */   public static final EventEnum SET_WORKSTATIONPADLENGTH = new EventEnum("set workstationPadLength");
/* 29 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 30 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 31 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 32 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 33 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 34 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getSequenceId();
/*    */   
/*    */   void setSequenceId(String paramString);
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
/*    */   String getPrefix();
/*    */   
/*    */   void setPrefix(String paramString);
/*    */   
/*    */   String getSuffix();
/*    */   
/*    */   void setSuffix(String paramString);
/*    */   
/*    */   boolean getEncode();
/*    */   
/*    */   void setEncode(boolean paramBoolean);
/*    */   
/*    */   String getCheckDigitAlgorithm();
/*    */   
/*    */   void setCheckDigitAlgorithm(String paramString);
/*    */   
/*    */   boolean getNumeric();
/*    */   
/*    */   void setNumeric(boolean paramBoolean);
/*    */   
/*    */   long getPadLength();
/*    */   
/*    */   void setPadLength(long paramLong);
/*    */   
/*    */   String getPadCharacter();
/*    */   
/*    */   void setPadCharacter(String paramString);
/*    */   
/*    */   long getInitialValue();
/*    */   
/*    */   void setInitialValue(long paramLong);
/*    */   
/*    */   long getMaxValue();
/*    */   
/*    */   void setMaxValue(long paramLong);
/*    */   
/*    */   long getValueIncrement();
/*    */   
/*    */   void setValueIncrement(long paramLong);
/*    */   
/*    */   boolean getIncludeStoreId();
/*    */   
/*    */   void setIncludeStoreId(boolean paramBoolean);
/*    */   
/*    */   long getStorePadLength();
/*    */   
/*    */   void setStorePadLength(long paramLong);
/*    */   
/*    */   boolean getIncludeWorkstationId();
/*    */   
/*    */   void setIncludeWorkstationId(boolean paramBoolean);
/*    */   
/*    */   long getWorkstationPadLength();
/*    */   
/*    */   void setWorkstationPadLength(long paramLong);
/*    */   
/*    */   IDataModel getSequencePartExt();
/*    */   
/*    */   void setSequencePartExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<ISequencePartProperty> getProperties();
/*    */   
/*    */   void setProperties(List<ISequencePartProperty> paramList);
/*    */   
/*    */   void addSequencePartProperty(ISequencePartProperty paramISequencePartProperty);
/*    */   
/*    */   void removeSequencePartProperty(ISequencePartProperty paramISequencePartProperty);
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\ISequencePart.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */