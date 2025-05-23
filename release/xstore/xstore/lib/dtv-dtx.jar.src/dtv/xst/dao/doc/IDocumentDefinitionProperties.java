/*    */ package dtv.xst.dao.doc;
/*    */ import dtv.data2.access.IDataModel;
/*    */ import dtv.event.EventEnum;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface IDocumentDefinitionProperties extends IDataModel, IHasDataProperty<IDocumentDefinitionPropertiesProperty> {
/*  9 */   public static final EventEnum SET_SERIESID = new EventEnum("set seriesId");
/* 10 */   public static final EventEnum SET_ORGANIZATIONID = new EventEnum("set organizationId");
/* 11 */   public static final EventEnum SET_DOCUMENTTYPE = new EventEnum("set documentType");
/* 12 */   public static final EventEnum SET_SEQUENCE = new EventEnum("set sequence");
/* 13 */   public static final EventEnum SET_CREATEDATE = new EventEnum("set createDate");
/* 14 */   public static final EventEnum SET_CREATEUSERID = new EventEnum("set createUserId");
/* 15 */   public static final EventEnum SET_UPDATEDATE = new EventEnum("set updateDate");
/* 16 */   public static final EventEnum SET_UPDATEUSERID = new EventEnum("set updateUserId");
/* 17 */   public static final EventEnum SET_ORGCODE = new EventEnum("set orgCode");
/* 18 */   public static final EventEnum SET_ORGVALUE = new EventEnum("set orgValue");
/* 19 */   public static final EventEnum SET_PROPERTYCODE = new EventEnum("set propertyCode");
/* 20 */   public static final EventEnum SET_TYPE = new EventEnum("set type");
/* 21 */   public static final EventEnum SET_STRINGVALUE = new EventEnum("set stringValue");
/* 22 */   public static final EventEnum SET_DATEVALUE = new EventEnum("set dateValue");
/* 23 */   public static final EventEnum SET_DECIMALVALUE = new EventEnum("set decimalValue");
/* 24 */   public static final EventEnum ADD_PROPERTIES = new EventEnum("add Properties");
/* 25 */   public static final EventEnum REMOVE_PROPERTIES = new EventEnum("remove Properties");
/* 26 */   public static final EventEnum SET_PROPERTIES = new EventEnum("set Properties");
/* 27 */   public static final EventEnum START_TRANSACTION = new EventEnum("start transaction");
/* 28 */   public static final EventEnum ROLLBACK_TRANSACTION = new EventEnum("rollback transaction");
/* 29 */   public static final EventEnum COMMIT_TRANSACTION = new EventEnum("commit transaction");
/*    */   
/*    */   void setDAO(IDataAccessObject paramIDataAccessObject);
/*    */   
/*    */   String getSeriesId();
/*    */   
/*    */   void setSeriesId(String paramString);
/*    */   
/*    */   long getOrganizationId();
/*    */   
/*    */   void setOrganizationId(long paramLong);
/*    */   
/*    */   String getDocumentType();
/*    */   
/*    */   void setDocumentType(String paramString);
/*    */   
/*    */   long getSequence();
/*    */   
/*    */   void setSequence(long paramLong);
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
/*    */   String getOrgCode();
/*    */   
/*    */   void setOrgCode(String paramString);
/*    */   
/*    */   String getOrgValue();
/*    */   
/*    */   void setOrgValue(String paramString);
/*    */   
/*    */   String getPropertyCode();
/*    */   
/*    */   void setPropertyCode(String paramString);
/*    */   
/*    */   String getType();
/*    */   
/*    */   void setType(String paramString);
/*    */   
/*    */   String getStringValue();
/*    */   
/*    */   void setStringValue(String paramString);
/*    */   
/*    */   Date getDateValue();
/*    */   
/*    */   void setDateValue(Date paramDate);
/*    */   
/*    */   BigDecimal getDecimalValue();
/*    */   
/*    */   void setDecimalValue(BigDecimal paramBigDecimal);
/*    */   
/*    */   IDataModel getDocumentDefinitionPropertiesExt();
/*    */   
/*    */   void setDocumentDefinitionPropertiesExt(IDataModel paramIDataModel);
/*    */   
/*    */   List<IDocumentDefinitionPropertiesProperty> getProperties();
/*    */   
/*    */   void setProperties(List<IDocumentDefinitionPropertiesProperty> paramList);
/*    */   
/*    */   void addDocumentDefinitionPropertiesProperty(IDocumentDefinitionPropertiesProperty paramIDocumentDefinitionPropertiesProperty);
/*    */   
/*    */   void removeDocumentDefinitionPropertiesProperty(IDocumentDefinitionPropertiesProperty paramIDocumentDefinitionPropertiesProperty);
/*    */   
/*    */   void setParentDocumentDefinition(IDocumentDefinition paramIDocumentDefinition);
/*    */   
/*    */   IDocumentDefinition getParentDocumentDefinition();
/*    */   
/*    */   void startTransaction();
/*    */   
/*    */   void rollbackChanges();
/*    */   
/*    */   void commitTransaction();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\doc\IDocumentDefinitionProperties.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */