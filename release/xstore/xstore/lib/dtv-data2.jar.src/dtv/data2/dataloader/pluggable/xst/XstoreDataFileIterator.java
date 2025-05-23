/*     */ package dtv.data2.dataloader.pluggable.xst;
/*     */ 
/*     */ import dtv.data2.access.DataModelFactory;
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.access.IQueryKey;
/*     */ import dtv.data2.access.QueryKey;
/*     */ import dtv.data2.access.impl.jdbc.IJDBCTableAdapter;
/*     */ import dtv.data2.access.impl.jdbc.JDBCAdapterMap;
/*     */ import dtv.data2.access.query.QueryRequest;
/*     */ import dtv.data2.dataloader.DataLoaderUtils;
/*     */ import dtv.data2.dataloader.config.DaoConfig;
/*     */ import dtv.data2.dataloader.config.DataLoaderConfigHelper;
/*     */ import dtv.data2.dataloader.config.PersistableConfig;
/*     */ import dtv.data2.dataloader.config.RecordTypeConfig;
/*     */ import dtv.data2.dataloader.fileprocessing.DataFileProcessor;
/*     */ import dtv.data2.dataloader.fileprocessing.FileLine;
/*     */ import dtv.data2.dataloader.fileprocessing.IFileLineParser;
/*     */ import dtv.data2.dataloader.fileprocessing.IFileLineParserFactory;
/*     */ import dtv.data2.dataloader.pluggable.AbstractDataFileIterator;
/*     */ import dtv.data2.dataloader.pluggable.AtomicPersistables;
/*     */ import dtv.data2.dataloader.pluggable.DataFileException;
/*     */ import dtv.data2.dataloader.pluggable.DataFileMetaData;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.inject.Inject;
/*     */ 
/*     */ public class XstoreDataFileIterator
/*     */   extends AbstractDataFileIterator<XstoreFileConfiguration>
/*     */ {
/*  33 */   private static final IQueryKey<Object[]> TRUNCATE_TABLE = (IQueryKey<Object[]>)new QueryKey("TRUNCATE_TABLE", Object[].class);
/*     */   
/*     */   @Inject
/*     */   private DataFileProcessor _processor;
/*     */   
/*     */   @Inject
/*     */   private IFileLineParserFactory _fileLineParserFactory;
/*     */   
/*     */   private Iterator<FileLine> _fileLineIterator;
/*     */ 
/*     */   
/*     */   public XstoreDataFileIterator(DataFileMetaData<XstoreFileConfiguration> argMetaData) {
/*  45 */     super(argMetaData);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/*  51 */     this._processor.cleanup();
/*     */   }
/*     */   
/*     */   public List<IPersistable> getPersistablesFromFileLine(FileLine argLine) {
/*  55 */     List<IPersistable> persistables = new ArrayList<>();
/*     */     
/*  57 */     String actionType = argLine.getActionType();
/*     */     
/*  59 */     if (actionType.equals("TRUNCATE")) {
/*  60 */       persistables = getTruncateTablePersistables(argLine);
/*     */     }
/*  62 */     else if (actionType.equals("DELETE_BY_ORGANIZATION")) {
/*  63 */       persistables = getDeleteByOrganizationPersistables(argLine);
/*     */     } else {
/*     */       
/*  66 */       IFileLineParser lineParser = null;
/*     */       
/*     */       try {
/*  69 */         lineParser = this._fileLineParserFactory.getFileLineParser(argLine.getRecordType());
/*     */       }
/*  71 */       catch (Exception ex) {
/*     */         
/*  73 */         lineParser = this._fileLineParserFactory.getFileLineParser("");
/*     */       } 
/*     */       
/*  76 */       persistables = lineParser.parse(argLine);
/*     */     } 
/*     */     
/*  79 */     return persistables;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected AtomicPersistables getNext() throws DataFileException {
/*  87 */     FileLine nextLine = null;
/*     */ 
/*     */     
/*     */     try {
/*  91 */       if (this._fileLineIterator == null) {
/*  92 */         this._fileLineIterator = (Iterator<FileLine>)this._processor.getSortedFileLineIterator(getMetaData().getFile());
/*     */       }
/*     */       
/*  95 */       AtomicPersistables persistablesFromOneLine = null;
/*     */       
/*  97 */       if (this._fileLineIterator.hasNext()) {
/*  98 */         nextLine = this._fileLineIterator.next();
/*     */ 
/*     */ 
/*     */         
/* 102 */         if (!nextLine.getIsInstructionValid()) {
/* 103 */           throw new DataFileException("Invalid instruction{Action|RecordType}", nextLine.toString());
/*     */         }
/*     */         
/* 106 */         List<IPersistable> persistables = getPersistablesFromFileLine(nextLine);
/* 107 */         persistablesFromOneLine = new AtomicPersistables(persistables, nextLine.toString());
/*     */       } 
/*     */       
/* 110 */       return persistablesFromOneLine;
/*     */     }
/* 112 */     catch (Exception ex) {
/* 113 */       throw new DataFileException(ex.getMessage(), ex, nextLine.toString());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<IPersistable> getDAOsFromLine(FileLine argLine) {
/* 123 */     List<IPersistable> daos = new ArrayList<>();
/*     */     
/* 125 */     RecordTypeConfig recordConfig = DataLoaderConfigHelper.getDataLoaderConfig().getRecordType(argLine.getRecordType());
/*     */     
/* 127 */     for (PersistableConfig persistableConfig : recordConfig.getPersistables()) {
/* 128 */       if (persistableConfig instanceof DaoConfig) {
/* 129 */         daos.add(DataModelFactory.getDaoForDaoName(((DaoConfig)persistableConfig).getDaoName()));
/*     */       }
/*     */     } 
/*     */     
/* 133 */     return daos;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<IPersistable> getDeleteByOrganizationPersistables(FileLine argLine) {
/* 142 */     List<IPersistable> deletePersistables = new ArrayList<>();
/* 143 */     List<IPersistable> daos = getDAOsFromLine(argLine);
/*     */     
/* 145 */     for (IPersistable dao : daos) {
/* 146 */       String tableName = getTableNameFromDAO(dao);
/* 147 */       IPersistable deleteByOrgQuery = DataLoaderUtils.getDeleteByOrganizationPersistable(tableName);
/*     */       
/* 149 */       deletePersistables.add(deleteByOrgQuery);
/*     */     } 
/*     */     
/* 152 */     return deletePersistables;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String getTableNameFromDAO(IPersistable argDAO) {
/* 161 */     IJDBCTableAdapter tableAdapter = JDBCAdapterMap.getTableAdapter(argDAO.getClass().getName());
/* 162 */     return tableAdapter.getTableName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<IPersistable> getTruncateTablePersistables(FileLine argLine) {
/* 170 */     List<IPersistable> truncatePersistables = new ArrayList<>();
/* 171 */     List<IPersistable> daos = getDAOsFromLine(argLine);
/*     */     
/* 173 */     for (IPersistable dao : daos) {
/* 174 */       String tableName = getTableNameFromDAO(dao);
/*     */       
/* 176 */       Map<String, Object> queryParams = new HashMap<>();
/* 177 */       queryParams.put("$argTableName", tableName);
/*     */       
/* 179 */       QueryRequest truncateQuery = new QueryRequest();
/* 180 */       truncateQuery.setQueryKey(TRUNCATE_TABLE);
/* 181 */       truncateQuery.setParams(queryParams);
/*     */       
/* 183 */       truncatePersistables.add(truncateQuery);
/*     */     } 
/*     */     
/* 186 */     return truncatePersistables;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\pluggable\xst\XstoreDataFileIterator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */