/*     */ package dtv.data2.dataloader;
/*     */ 
/*     */ import dtv.data2.dataloader.filelocator.StatusFileFilter;
/*     */ import dtv.data2.dataloader.fileprocessing.DataFileProcessor;
/*     */ import dtv.util.CalendarField;
/*     */ import dtv.util.DateUtils;
/*     */ import dtv.util.FileUtils;
/*     */ import java.io.File;
/*     */ import java.io.FileFilter;
/*     */ import java.io.IOException;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import javax.inject.Inject;
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
/*     */ 
/*     */ public class DefaultFileArchiver
/*     */   implements IFileArchiver
/*     */ {
/*  32 */   private static final Logger _logger = Logger.getLogger(DataFileProcessor.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  40 */   private final Date _runDate = new Date();
/*     */ 
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private ConfigParameters _configParameters;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void archiveDataFile(File argFile, String argNewFileName) {
/*  51 */     archiveDataFile(argFile, false, argNewFileName);
/*     */   }
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
/*     */   public boolean archiveStatusFiles() {
/*  64 */     String dataFilePath = this._configParameters.getDataFileLocation();
/*  65 */     File successFile = new File(dataFilePath, "success.dat");
/*  66 */     boolean isStatusFileArchived = false;
/*     */     
/*  68 */     if (successFile.exists()) {
/*  69 */       archiveDataFile(successFile, true, null);
/*  70 */       isStatusFileArchived = true;
/*     */     } 
/*     */     
/*  73 */     File failuresFile = new File(dataFilePath, "failures.dat");
/*     */     
/*  75 */     if (failuresFile.exists()) {
/*  76 */       archiveDataFile(failuresFile, true, null);
/*  77 */       isStatusFileArchived = true;
/*     */     } 
/*  79 */     return isStatusFileArchived;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void archiveSummaryFile() {
/*  88 */     String dataFilePath = this._configParameters.getDataFileLocation();
/*  89 */     File successFile = new File(dataFilePath, "summary.ini");
/*     */     
/*  91 */     if (successFile.exists()) {
/*  92 */       archiveDataFile(successFile, true, null);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void cleanUpArchives() {
/* 102 */     int archiveDays = this._configParameters.getArchiveDays();
/*     */     
/* 104 */     _logger.info("Cleaning up archive files that are older than " + archiveDays + " days...");
/*     */     
/* 106 */     String rootArchivePathName = this._configParameters.getArchivePath();
/* 107 */     File rootArchivePath = new File(rootArchivePathName);
/* 108 */     File[] files = rootArchivePath.listFiles();
/*     */     
/* 110 */     if (files != null) {
/* 111 */       Date oldestDate = DateUtils.dateAdd(CalendarField.DAY, -archiveDays, new Date());
/* 112 */       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
/*     */       
/* 114 */       for (File archiveFile : files) {
/*     */ 
/*     */         
/* 117 */         if (archiveFile.isDirectory()) {
/*     */           
/*     */           try {
/*     */ 
/*     */             
/* 122 */             Date archiveDate = dateFormat.parse(archiveFile.getName());
/*     */             
/* 124 */             if (archiveDate.before(oldestDate)) {
/* 125 */               FileUtils.deleteTree(archiveFile);
/*     */             }
/*     */           }
/* 128 */           catch (ParseException ex) {
/* 129 */             _logger.warn("Encountered a directory in the archive path that does conform to the naming convention [" + archiveFile
/* 130 */                 .getName() + "]. It will not be touched.");
/*     */           } 
/*     */         }
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
/*     */ 
/*     */ 
/*     */   
/*     */   public void cleanUpStatusFiles() {
/* 147 */     String dataFilePath = this._configParameters.getDataFileLocation();
/* 148 */     File filePath = new File(dataFilePath);
/* 149 */     File[] statusFiles = filePath.listFiles((FileFilter)new StatusFileFilter());
/*     */     
/* 151 */     if (!filePath.exists()) {
/* 152 */       _logger.warn("Data file path [" + filePath.getAbsolutePath() + "] does not exist..");
/*     */       
/*     */       return;
/*     */     } 
/* 156 */     for (File statusFile : statusFiles) {
/* 157 */       boolean success = statusFile.delete();
/*     */       
/* 159 */       if (!success) {
/* 160 */         _logger.error("Unable to delete pre-existing status file [" + statusFile.getPath() + "].");
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getRunDateDirectory() {
/* 166 */     SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmss");
/* 167 */     return format.format(this._runDate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void archiveDataFile(File argFile, boolean argCopy, String argOptionalNewFilename) {
/* 178 */     boolean success = true;
/* 179 */     String runDateDir = getRunDateDirectory();
/* 180 */     File rootArchivePath = new File(this._configParameters.getArchivePath());
/*     */     
/* 182 */     if (!rootArchivePath.exists()) {
/* 183 */       success = rootArchivePath.mkdir();
/*     */     }
/*     */     
/* 186 */     if (!rootArchivePath.isDirectory()) {
/* 187 */       _logger.error("Archive path [" + rootArchivePath + "] either does not exist or is not a directory: data files will not be archived");
/*     */       
/* 189 */       success = false;
/*     */     } 
/*     */     
/* 192 */     if (success) {
/* 193 */       File archivePath = new File(rootArchivePath, runDateDir);
/*     */ 
/*     */       
/* 196 */       if (!archivePath.exists()) {
/* 197 */         success = archivePath.mkdir();
/*     */       }
/*     */       
/* 200 */       if (success) {
/* 201 */         String newName = (argOptionalNewFilename == null) ? argFile.getName() : argOptionalNewFilename;
/*     */ 
/*     */         
/* 204 */         File archiveFile = new File(archivePath, newName);
/*     */         
/* 206 */         if (argCopy) {
/*     */           try {
/* 208 */             FileUtils.copyFile(argFile, archiveFile);
/* 209 */             success = true;
/*     */           }
/* 211 */           catch (IOException ex) {
/* 212 */             success = false;
/*     */           } 
/*     */         } else {
/*     */           
/* 216 */           success = argFile.renameTo(archiveFile);
/*     */         } 
/*     */         
/* 219 */         if (!success)
/* 220 */           _logger.error("Unable to rename file for archiving.  Old name [" + argFile + "]. New name [" + archiveFile + "]."); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\DefaultFileArchiver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */