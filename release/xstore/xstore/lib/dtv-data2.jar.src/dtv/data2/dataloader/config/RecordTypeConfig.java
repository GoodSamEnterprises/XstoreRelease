/*    */ package dtv.data2.dataloader.config;
/*    */ 
/*    */ import dtv.data2.dataloader.DataLoaderException;
/*    */ import dtv.data2.dataloader.fileprocessing.IFileLineParser;
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RecordTypeConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 24 */   private static final Collection<String> _ignoredFields = Arrays.asList(new String[] { "description" });
/*    */   
/*    */   private String recordTypeName_;
/*    */   private Class<IFileLineParser> fileLineParserClass_;
/* 28 */   private final List<PersistableConfig> persistableList_ = new ArrayList<>();
/*    */   
/*    */   public Class<IFileLineParser> getFileLineParserClass() {
/* 31 */     return this.fileLineParserClass_;
/*    */   }
/*    */   
/*    */   public List<PersistableConfig> getPersistables() {
/* 35 */     return this.persistableList_;
/*    */   }
/*    */   
/*    */   public String getRecordTypeName() {
/* 39 */     return this.recordTypeName_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 46 */     if ("name".equalsIgnoreCase(argKey)) {
/* 47 */       this.recordTypeName_ = argValue.toString();
/*    */     }
/* 49 */     else if ("fileLineParser".equalsIgnoreCase(argKey)) {
/*    */       try {
/* 51 */         this.fileLineParserClass_ = (Class)Class.forName(argValue.toString());
/*    */       }
/* 53 */       catch (Exception ex) {
/* 54 */         throw new DataLoaderException("An exception occurred while getting the fileLineParser class value: [" + argValue
/* 55 */             .toString() + "] source: [" + argValue.getSourceDescription() + "]", ex);
/*    */       }
/*    */     
/* 58 */     } else if (argValue instanceof PersistableConfig) {
/* 59 */       this.persistableList_.add((PersistableConfig)argValue);
/*    */     }
/* 61 */     else if (!_ignoredFields.contains(argKey)) {
/* 62 */       warnUnsupported(argKey, argValue);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void setRecordTypeName(String argRecordTypeName) {
/* 67 */     this.recordTypeName_ = argRecordTypeName;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\config\RecordTypeConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */