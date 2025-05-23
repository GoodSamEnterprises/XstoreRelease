/*     */ package dtv.dataloader.mom;
/*     */ 
/*     */ import dtv.data2.dataloader.pluggable.DataFileException;
/*     */ import dtv.data2.dataloader.pluggable.IFileNameSortingStrategy;
/*     */ import java.io.File;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Properties;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import javax.annotation.Resource;
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
/*     */ 
/*     */ public class MOMFileTypeDetectorbyFName
/*     */   extends AbstractMOMFileTypeDetector
/*     */ {
/*  31 */   private static final Logger _logger = Logger.getLogger(MOMFileTypeDetectorbyFName.class);
/*     */ 
/*     */   
/*     */   private static final String FILL_TYPE_PROPERTY_VALUE_FULL = "full";
/*     */ 
/*     */   
/*     */   private static final String FILL_TYPE_PROPERTY_VALUE_DELTA = "delta";
/*     */   
/*     */   @Resource(name = "momFileNameSortingStrategy")
/*     */   private IFileNameSortingStrategy _fileNameSortingStrategy;
/*     */   
/*     */   @Resource(name = "momFileNameExpr")
/*     */   private Properties _fileNameExpr;
/*     */   
/*     */   @Resource(name = "momNumberOfLinesExpr")
/*     */   private Properties _momNumberOfLinesExpr;
/*     */   
/*     */   @Resource(name = "momStoreIdExpr")
/*     */   private Properties _momStoreIdExpr;
/*     */   
/*     */   @Resource(name = "momFillTypeExpr")
/*     */   private Properties _fillTypeExpr;
/*     */   
/*     */   @Resource(name = "momTimestampExpr")
/*     */   private Properties _momTimestampExpr;
/*     */ 
/*     */   
/*     */   protected String detectMOMFileType(File argDataFile) {
/*  59 */     Enumeration<?> e = this._fileNameExpr.propertyNames();
/*  60 */     while (e.hasMoreElements()) {
/*  61 */       String fileTypeKey = (String)e.nextElement();
/*  62 */       String regExpr = this._fileNameExpr.getProperty(fileTypeKey);
/*     */       
/*  64 */       if (Pattern.matches(regExpr, argDataFile.getName())) {
/*     */         
/*  66 */         _logger
/*  67 */           .debug("MOM flat file type " + fileTypeKey + " is detected with path " + argDataFile.getPath());
/*  68 */         return fileTypeKey;
/*     */       } 
/*     */     } 
/*  71 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected String detectStoreId(String argFileTypeKey, File argDataFile) {
/*  77 */     String storeId = null;
/*     */     try {
/*  79 */       String regExpr = this._momStoreIdExpr.getProperty(argFileTypeKey);
/*  80 */       if (regExpr != null) {
/*  81 */         Matcher matcher = Pattern.compile(regExpr).matcher(argDataFile.getName());
/*  82 */         if (matcher.find()) {
/*  83 */           storeId = matcher.group(1);
/*     */         }
/*     */       }
/*     */     
/*  87 */     } catch (Exception e) {
/*  88 */       _logger.error("Unable to determine store id for file " + argDataFile.getAbsolutePath(), e);
/*  89 */       throw new DataFileException("Unable to determine storeId for file " + argDataFile.getAbsolutePath(), e);
/*     */     } 
/*  91 */     return storeId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean shouldTruncateBeforeLoading(String argFileTypeKey, File argDataFile) {
/*     */     try {
/*  98 */       String regExpr = this._fillTypeExpr.getProperty(argFileTypeKey);
/*     */       
/* 100 */       if (regExpr == null) return false;
/*     */       
/* 102 */       Matcher matcher = Pattern.compile(regExpr).matcher(argDataFile.getName());
/* 103 */       if (matcher.find()) {
/* 104 */         String fillType = matcher.group(1);
/* 105 */         if ("full".equals(fillType)) {
/* 106 */           return true;
/*     */         }
/* 108 */         if ("delta".equals(fillType)) {
/* 109 */           return false;
/*     */         }
/*     */       } 
/* 112 */       _logger.error("Unable to determine fill type for file " + argDataFile.getAbsolutePath());
/* 113 */       throw new DataFileException("Unable to determine fill type for file " + argDataFile.getAbsolutePath());
/*     */     }
/* 115 */     catch (Exception e) {
/* 116 */       _logger.error("Unable to determine fill type for file " + argDataFile.getAbsolutePath(), e);
/* 117 */       throw new DataFileException("Unable to determine fill type for file " + argDataFile.getAbsolutePath(), e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Integer detectNumberOfLines(String argFileTypeKey, File argDataFile) {
/* 125 */     Integer numberOfLines = null;
/*     */     try {
/* 127 */       String regExpr = this._momNumberOfLinesExpr.getProperty(argFileTypeKey);
/*     */       
/* 129 */       if (regExpr != null) {
/* 130 */         Matcher matcher = Pattern.compile(regExpr).matcher(argDataFile.getName());
/* 131 */         if (matcher.find()) {
/* 132 */           numberOfLines = Integer.valueOf(matcher.group());
/*     */         }
/*     */       }
/*     */     
/* 136 */     } catch (Exception e) {
/* 137 */       _logger.error("Unable to determine number of lines for file " + argDataFile.getAbsolutePath(), e);
/* 138 */       throw new DataFileException("Unable to determine number of lines for file " + argDataFile
/* 139 */           .getAbsolutePath(), e);
/*     */     } 
/* 141 */     return numberOfLines;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Date detectTimestamp(String argFileTypeKey, File argDataFile) {
/* 148 */     Date date = null;
/* 149 */     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
/*     */     try {
/* 151 */       String regExpr = this._momTimestampExpr.getProperty(argFileTypeKey);
/* 152 */       if (regExpr != null) {
/* 153 */         Matcher matcher = Pattern.compile(regExpr).matcher(argDataFile.getName());
/* 154 */         if (matcher.find()) {
/* 155 */           String strTimestamp = matcher.group(0);
/* 156 */           date = dateFormat.parse(strTimestamp);
/*     */         }
/*     */       
/*     */       } 
/* 160 */     } catch (Exception e) {
/* 161 */       _logger.error("Unable to determine number of lines for file " + argDataFile.getAbsolutePath(), e);
/* 162 */       throw new DataFileException("Unable to determine number of lines for file " + argDataFile
/* 163 */           .getAbsolutePath(), e);
/*     */     } 
/* 165 */     return date;
/*     */   }
/*     */ 
/*     */   
/*     */   public IFileNameSortingStrategy getFileNameSortingStrategy() {
/* 170 */     return this._fileNameSortingStrategy;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\dataloader\mom\MOMFileTypeDetectorbyFName.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */