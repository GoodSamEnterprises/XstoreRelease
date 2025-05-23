/*     */ package dtv.data2.dataloader.filelocator;
/*     */ 
/*     */ import dtv.util.StringUtils;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileFilter;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
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
/*     */ public class FileLocator
/*     */   extends AbstractDataFileLocator
/*     */ {
/*  29 */   private static final Logger logger_ = LogManager.getLogger(FileLocator.class);
/*     */   private static final String EXCLUSIONS_FILE_NAME = "readme.txt";
/*     */   private static final String REORG_FILE_EXCLUSION = "*.reo";
/*     */   
/*     */   public FileLocator(String argDataFilePath) {
/*  34 */     super(argDataFilePath);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void cleanup() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public File getDataFileDir() {
/*  44 */     File dataFile = getConfiguredDataFile();
/*  45 */     if (dataFile == null || dataFile.isDirectory()) {
/*  46 */       return dataFile;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  52 */     int lastSeperator = dataFile.getAbsolutePath().lastIndexOf(File.separatorChar);
/*     */     
/*  54 */     if (lastSeperator != -1) {
/*  55 */       File dataFileDir = new File(dataFile.getAbsolutePath().substring(0, lastSeperator));
/*  56 */       if (dataFileDir.exists() && dataFileDir.isDirectory()) {
/*  57 */         return dataFileDir;
/*     */       }
/*     */     } 
/*     */     
/*  61 */     logger_.warn("Could not determine dataFileDir for configured data file: {}", dataFile);
/*  62 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<File> getDataFiles() {
/*  68 */     File dataFileDir = getDataFileDir();
/*  69 */     if (dataFileDir == null) {
/*  70 */       return Collections.emptyList();
/*     */     }
/*     */     
/*  73 */     return getDataFiles(dataFileDir);
/*     */   }
/*     */   
/*     */   protected List<File> getDataFiles(File argDataDir) {
/*  77 */     FileFilter filter = getFileExclusionFilter(argDataDir);
/*  78 */     File[] files = argDataDir.listFiles(filter);
/*     */     
/*  80 */     if (files == null || files.length == 0) {
/*  81 */       return Collections.emptyList();
/*     */     }
/*     */     
/*  84 */     List<File> dataFiles = new ArrayList<>(files.length);
/*     */     
/*  86 */     for (File file : files) {
/*  87 */       if (!file.isDirectory()) {
/*  88 */         dataFiles.add(file);
/*     */       }
/*     */     } 
/*     */     
/*  92 */     return dataFiles;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private FileFilter getFileExclusionFilter(File argDataDir) {
/* 102 */     List<String> exclusions = new ArrayList<>();
/* 103 */     exclusions.add("summary.ini");
/*     */     
/* 105 */     File exclusionsFile = new File(argDataDir, "readme.txt");
/* 106 */     try (BufferedReader reader = new BufferedReader(new FileReader(exclusionsFile))) {
/*     */       
/* 108 */       String read = null;
/* 109 */       while ((read = reader.readLine()) != null) {
/* 110 */         if (StringUtils.isEmpty(read) || read.trim().startsWith("#")) {
/*     */           continue;
/*     */         }
/* 113 */         exclusions.add(read);
/*     */       } 
/*     */       
/* 116 */       String trickleProp = System.getProperty("dtv.dataloader.trickle", "false");
/* 117 */       boolean trickleMode = Boolean.valueOf(trickleProp).booleanValue();
/*     */       
/* 119 */       if (trickleMode) {
/* 120 */         exclusions.add("*.reo");
/*     */       }
/*     */     }
/* 123 */     catch (FileNotFoundException ex) {
/* 124 */       logger_.info("{} was not found.  No file exclusions will be processed.", "readme.txt");
/*     */     }
/* 126 */     catch (IOException ex) {
/* 127 */       logger_.error("An exception was caught attempting to read readme.txt exclusions file.", ex);
/*     */     } 
/*     */     
/* 130 */     FileExtensionFilter filter = new FileExtensionFilter(exclusions.<String>toArray(new String[exclusions.size()]));
/* 131 */     filter.setInvert(true);
/*     */     
/* 133 */     return (FileFilter)filter;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\filelocator\FileLocator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */