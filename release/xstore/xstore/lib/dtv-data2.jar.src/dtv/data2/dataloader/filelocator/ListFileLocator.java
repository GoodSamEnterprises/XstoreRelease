/*     */ package dtv.data2.dataloader.filelocator;
/*     */ 
/*     */ import dtv.data2.dataloader.DataLoaderEventLogger;
/*     */ import dtv.util.FileUtils;
/*     */ import dtv.util.StringUtils;
/*     */ import java.io.File;
/*     */ import java.io.FileFilter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ListFileLocator
/*     */   extends AbstractDataFileLocator
/*     */ {
/*  28 */   private static final Logger logger_ = Logger.getLogger(ListFileLocator.class);
/*     */   
/*     */   private static final String LIST_FILE_EXTENTION = "*.lst";
/*     */   
/*     */   private List<File> lstFiles_;
/*     */   
/*     */   public ListFileLocator(String argDataFilePath) {
/*  35 */     super(argDataFilePath);
/*     */   }
/*     */   
/*     */   public boolean anyListFilesPresent() {
/*  39 */     File dataFile = getConfiguredDataFile();
/*  40 */     List<File> files = getListFiles(dataFile);
/*  41 */     return !files.isEmpty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void cleanup() {
/*  47 */     if (this.lstFiles_ == null || this.lstFiles_.isEmpty()) {
/*     */       return;
/*     */     }
/*     */     
/*  51 */     for (File listFile : this.lstFiles_) {
/*     */       try {
/*  53 */         boolean success = listFile.delete();
/*  54 */         if (success) {
/*  55 */           logger_.info("Deleted list file: " + listFile.getAbsolutePath());
/*     */           continue;
/*     */         } 
/*  58 */         logger_.warn("Failed to delete list file: " + listFile.getAbsolutePath() + " - reason UNKNOWN.");
/*     */         
/*  60 */         DataLoaderEventLogger.warn("Failed to delete list file: " + listFile.getAbsolutePath() + " - reason UNKNOWN.");
/*     */ 
/*     */       
/*     */       }
/*  64 */       catch (Exception ee) {
/*  65 */         logger_.warn("Failed to delete list file: " + listFile.getAbsolutePath() + " - due to exception.", ee);
/*     */ 
/*     */         
/*  68 */         DataLoaderEventLogger.warn("Failed to delete list file: " + listFile.getAbsolutePath() + " - due to exception.", ee);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<File> getDataFiles() {
/*  80 */     File dataFile = getConfiguredDataFile();
/*  81 */     if (dataFile == null || !dataFile.isDirectory()) {
/*  82 */       return Collections.EMPTY_LIST;
/*     */     }
/*     */     
/*  85 */     List<File> listFiles = getListFiles(dataFile);
/*  86 */     if (listFiles == null) {
/*  87 */       return null;
/*     */     }
/*     */     
/*  90 */     return getDataFilesFromListFiles(listFiles);
/*     */   }
/*     */ 
/*     */   
/*     */   protected List<File> getDataFilesFromListFiles(List<File> argLstFiles) {
/*  95 */     List<File> dataFiles = new ArrayList<>();
/*     */     
/*  97 */     for (File lstFile : argLstFiles) {
/*     */       try {
/*  99 */         String fileContents = FileUtils.loadFile(lstFile);
/*     */         
/* 101 */         if (StringUtils.isEmpty(fileContents)) {
/* 102 */           String msg = "List file: " + lstFile.getAbsolutePath() + " - was found to be empty and will not be processed";
/*     */           
/* 104 */           logger_.warn(msg);
/* 105 */           DataLoaderEventLogger.warn(msg);
/*     */           
/*     */           continue;
/*     */         } 
/* 109 */         String[] fileLines = fileContents.split("\n");
/*     */         
/* 111 */         if (fileLines == null || fileLines.length == 0) {
/* 112 */           String msg = "Unable to split : " + lstFile.getAbsolutePath() + " into LINES - this file will not be processed";
/*     */           
/* 114 */           logger_.warn(msg);
/* 115 */           DataLoaderEventLogger.warn(msg);
/*     */           
/*     */           continue;
/*     */         } 
/* 119 */         for (String lstFileLine : fileLines) {
/*     */           
/* 121 */           File dataFile = new File(getConfiguredDataFile().getAbsolutePath() + File.separatorChar + lstFileLine.trim());
/*     */           
/* 123 */           if (!dataFile.exists())
/*     */           {
/* 125 */             String msg = "Data file: " + dataFile + " does not exist and will be ignored. (from list file: " + lstFile.getAbsolutePath() + ")";
/* 126 */             logger_.warn(msg);
/* 127 */             DataLoaderEventLogger.warn(msg);
/*     */           
/*     */           }
/* 130 */           else if (dataFile.isDirectory())
/*     */           {
/*     */             
/* 133 */             String msg = "Supposed Data file: " + dataFile + " is actually a directory and will be ignored. (from list file: " + lstFile.getAbsolutePath();
/* 134 */             logger_.warn(msg);
/* 135 */             DataLoaderEventLogger.warn(msg);
/*     */           }
/*     */           else
/*     */           {
/* 139 */             dataFiles.add(dataFile);
/*     */           }
/*     */         
/*     */         } 
/* 143 */       } catch (Exception ee) {
/* 144 */         if (logger_.isDebugEnabled()) {
/* 145 */           logger_.warn("Could not load contents of list file: " + lstFile.getAbsolutePath() + " - this .lst file will not be processed.", ee);
/*     */         }
/*     */         else {
/*     */           
/* 149 */           logger_.warn("Could not load contents of list file: " + lstFile.getAbsolutePath() + " - this .lst file will not be processed." + ee);
/*     */         } 
/*     */ 
/*     */         
/* 153 */         DataLoaderEventLogger.warn("Could not load contents of list file: " + lstFile.getAbsolutePath() + " - this .lst file will not be processed." + ee);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 158 */     if (dataFiles.isEmpty()) {
/* 159 */       String msg = "No valid data files were found in list files: " + argLstFiles + " - the DataLoader will exit without loading any data.";
/*     */       
/* 161 */       logger_.warn(msg);
/* 162 */       DataLoaderEventLogger.warn(msg);
/* 163 */       return null;
/*     */     } 
/*     */     
/* 166 */     return dataFiles;
/*     */   }
/*     */   
/*     */   protected List<File> getListFiles(File argDataFileDir) {
/* 170 */     File[] files = argDataFileDir.listFiles(getFileFilter());
/* 171 */     List<File> lstFiles = Arrays.asList(files);
/*     */     
/* 173 */     this.lstFiles_ = lstFiles;
/* 174 */     return this.lstFiles_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private FileFilter getFileFilter() {
/* 182 */     FileExtensionFilter filter = new FileExtensionFilter(new String[] { "*.lst" });
/* 183 */     return (FileFilter)filter;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\filelocator\ListFileLocator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */