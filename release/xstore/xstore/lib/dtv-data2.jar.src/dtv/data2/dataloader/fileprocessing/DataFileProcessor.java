/*     */ package dtv.data2.dataloader.fileprocessing;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.dataloader.DataLoaderEventLogger;
/*     */ import dtv.data2.dataloader.DataLoaderException;
/*     */ import dtv.data2.dataloader.config.DataLoaderConfig;
/*     */ import dtv.data2.dataloader.config.DataLoaderConfigHelper;
/*     */ import dtv.data2.dataloader.filelocator.DataFileSorter;
/*     */ import dtv.data2.dataloader.pluggable.DataFileException;
/*     */ import dtv.util.StringUtils;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.Set;
/*     */ import java.util.regex.Pattern;
/*     */ import javax.inject.Inject;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class DataFileProcessor
/*     */ {
/*  34 */   private static final Logger logger_ = Logger.getLogger(DataFileProcessor.class);
/*     */   
/*  36 */   private static final String ENCODING = DataLoaderConfigHelper.getDataLoaderConfig().getCharacterEncoding();
/*     */   
/*     */   private static final String INVALID_INSTRUCTION_EXTENSION = "INVALID.INSTRUCTION";
/*  39 */   private final DataFileHeaderProcessor headerProcessor_ = new DataFileHeaderProcessor();
/*     */   
/*  41 */   private File currentFile_ = null;
/*  42 */   private String currentDelimiter_ = null;
/*  43 */   private Pattern currentDelimiterPattern_ = null;
/*  44 */   private BufferedReader reader_ = null;
/*     */ 
/*     */   
/*     */   private boolean delimiterDetectionAttempted_ = false;
/*     */ 
/*     */   
/*     */   private List<SplitFile> _splitFiles;
/*     */ 
/*     */   
/*     */   private SortedFileLineIterator _fileLineIterator;
/*     */   
/*     */   @Inject
/*     */   private IPersistenceDefaults _persistanceDefaults;
/*     */ 
/*     */   
/*     */   public void cleanup() {
/*  60 */     if (this._splitFiles != null) {
/*  61 */       cleanUpFiles((List)this._splitFiles);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void cleanUpDataFile(File argFile) {
/*  70 */     boolean success = cleanUpFiles(Arrays.asList(new File[] { argFile }));
/*  71 */     if (success) {
/*  72 */       logger_.info("Data file: " + argFile + " was successfully deleted.");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean cleanUpFiles(List<? extends File> argSplitFiles) {
/*  81 */     releaseCurrentFile();
/*  82 */     boolean successOk = false;
/*     */     
/*  84 */     for (File splitFile : argSplitFiles) {
/*     */       
/*     */       try {
/*  87 */         if (splitFile.exists()) {
/*  88 */           boolean success = splitFile.delete();
/*  89 */           if (success) {
/*  90 */             successOk = true;
/*     */             continue;
/*     */           } 
/*  93 */           logger_.warn("Failed to remove file: " + splitFile.getAbsolutePath() + " reason unknown.  Forcing GC and trying again");
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  98 */           System.gc();
/*  99 */           success = splitFile.delete();
/* 100 */           if (success) {
/* 101 */             successOk = true;
/*     */             continue;
/*     */           } 
/* 104 */           logger_.warn("Really failed to delete.  Waiting 2 seconds");
/* 105 */           Thread.currentThread().wait(2000L);
/* 106 */           success = splitFile.delete();
/* 107 */           logger_.warn("Last delete attempt result was " + success);
/*     */         
/*     */         }
/*     */       
/*     */       }
/* 112 */       catch (Exception ee) {
/* 113 */         if (logger_.isDebugEnabled()) {
/* 114 */           logger_.warn("Failed to remove file: " + splitFile.getAbsolutePath(), ee);
/*     */         } else {
/*     */           
/* 117 */           logger_.warn("Failed to remove file: " + splitFile.getAbsolutePath() + " " + ee);
/*     */         } 
/* 119 */         successOk = false;
/*     */       } 
/*     */     } 
/*     */     
/* 123 */     return successOk;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FileLine getNextFileLine(SplitFile argSplitFile) {
/*     */     try {
/* 134 */       if (this.currentFile_ != argSplitFile) {
/* 135 */         this.currentFile_ = argSplitFile;
/* 136 */         if (this.reader_ != null) {
/* 137 */           this.reader_.close();
/*     */         }
/* 139 */         this.reader_ = new BufferedReader(new InputStreamReader(new FileInputStream(this.currentFile_), ENCODING));
/*     */       } 
/*     */       
/* 142 */       String line = this.reader_.readLine();
/*     */       
/* 144 */       if (line == null) {
/* 145 */         if (this.reader_ != null) {
/* 146 */           this.reader_.close();
/*     */         }
/* 148 */         return null;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 154 */       boolean instructionIsValid = !argSplitFile.getIsErrorFile();
/* 155 */       FileLine fileLine = new FileLine(line, this.currentDelimiterPattern_, instructionIsValid);
/*     */       
/* 157 */       return fileLine;
/*     */     }
/* 159 */     catch (Exception ee) {
/* 160 */       logger_.error("An exception occurred while processing split file: " + argSplitFile, ee);
/* 161 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public SortedFileLineIterator getSortedFileLineIterator(File argDataFile) {
/* 166 */     this._splitFiles = splitFile(argDataFile);
/* 167 */     this._fileLineIterator = new SortedFileLineIterator(this._splitFiles);
/*     */     
/* 169 */     return this._fileLineIterator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void releaseCurrentFile() {
/* 176 */     if (this.reader_ != null) {
/*     */       try {
/*     */         try {
/* 179 */           this.reader_.close();
/*     */         } finally {
/*     */           
/* 182 */           this.reader_.close();
/*     */         }
/*     */       
/* 185 */       } catch (IOException e) {
/* 186 */         logger_.warn("Failed to close reader.", e);
/*     */       } 
/* 188 */       this.reader_ = null;
/*     */     } 
/*     */     
/* 191 */     if (this.currentFile_ != null) {
/* 192 */       this.currentFile_ = null;
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
/*     */   public List<SplitFile> splitFile(File argDataFile) {
/* 204 */     this.currentDelimiter_ = null;
/* 205 */     this.currentDelimiterPattern_ = null;
/* 206 */     this.delimiterDetectionAttempted_ = false;
/*     */     
/* 208 */     HeaderLine headerLine = null;
/* 209 */     Map<String, SplitFile> splitFiles = new HashMap<>();
/*     */     
/* 211 */     File dataFile = argDataFile;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 216 */     try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(dataFile), ENCODING))) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 221 */       DataLoaderEventLogger.setCurrentHeader(this._persistanceDefaults, null);
/*     */       String line;
/* 223 */       while (reader.ready() && (line = reader.readLine()) != null) {
/*     */ 
/*     */ 
/*     */         
/* 227 */         if (StringUtils.isEmpty(line) || line.trim().startsWith("#")) {
/*     */           continue;
/*     */         }
/*     */         
/* 231 */         if (this.headerProcessor_.isHeaderLine(line)) {
/* 232 */           if (headerLine != null) {
/* 233 */             throw new DataLoaderException("More than one header was encountered in file [" + dataFile
/* 234 */                 .getAbsolutePath() + "]");
/*     */           }
/* 236 */           headerLine = this.headerProcessor_.processHeader(line);
/*     */           
/* 238 */           if (headerLine != null) {
/* 239 */             DataLoaderEventLogger.setCurrentHeader(this._persistanceDefaults, headerLine);
/*     */           }
/*     */           
/*     */           continue;
/*     */         } 
/* 244 */         if (!autoDetectDelimiter(line)) {
/* 245 */           logNoDelimiter(line);
/* 246 */           SplitFile invalidInstructionFile = splitFiles.get("INVALID.INSTRUCTION");
/*     */           
/* 248 */           if (invalidInstructionFile == null) {
/* 249 */             invalidInstructionFile = new SplitFile(argDataFile, "INVALID", "INSTRUCTION", ENCODING, true);
/* 250 */             splitFiles.put("INVALID.INSTRUCTION", invalidInstructionFile);
/*     */           } 
/*     */           
/* 253 */           invalidInstructionFile.writeLine(line);
/*     */           
/*     */           continue;
/*     */         } 
/*     */         try {
/* 258 */           ParsingUtils.Instruction instruction = ParsingUtils.getInstance().parseInstruction(line);
/*     */           
/* 260 */           String key = (new StringBuilder(32)).append(instruction.recordType).append(".").append(instruction.action).toString();
/*     */           
/* 262 */           SplitFile splitFile = splitFiles.get(key);
/*     */           
/* 264 */           if (splitFile == null) {
/* 265 */             splitFile = new SplitFile(argDataFile, instruction.recordType, instruction.action, ENCODING, false);
/*     */             
/* 267 */             splitFiles.put(key, splitFile);
/*     */           } 
/*     */           
/* 270 */           splitFile.writeLine(line);
/*     */         }
/* 272 */         catch (Exception ex) {
/* 273 */           SplitFile invalidInstructionFile = splitFiles.get("INVALID.INSTRUCTION");
/*     */           
/* 275 */           if (invalidInstructionFile == null) {
/* 276 */             invalidInstructionFile = new SplitFile(argDataFile, "INVALID", "INSTRUCTION", ENCODING, true);
/* 277 */             splitFiles.put("INVALID.INSTRUCTION", invalidInstructionFile);
/*     */           } 
/*     */           
/* 280 */           invalidInstructionFile.writeLine(line);
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 287 */       if (DataFileSorter.isReorganizeFile(argDataFile)) {
/* 288 */         handleReorganizationDataFile(splitFiles, argDataFile);
/*     */       }
/*     */       
/* 291 */       return finishSplitFiles(splitFiles, headerLine);
/*     */     }
/* 293 */     catch (Exception ee) {
/* 294 */       closeSplitFilesWriter(splitFiles);
/* 295 */       handleSplitFileException(ee, argDataFile);
/*     */ 
/*     */       
/* 298 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean autoDetectDelimiter(String argFileLine) {
/* 307 */     boolean success = this.delimiterDetectionAttempted_;
/*     */     
/* 309 */     if (!this.delimiterDetectionAttempted_) {
/*     */       try {
/* 311 */         this.currentDelimiter_ = ParsingUtils.getInstance().determineDelimiter(argFileLine);
/* 312 */         this.currentDelimiterPattern_ = Pattern.compile(Pattern.quote(this.currentDelimiter_));
/*     */         
/* 314 */         logger_.info("Delimiter determined to be: " + this.currentDelimiter_ + " int value: " + this.currentDelimiter_
/* 315 */             .charAt(0));
/* 316 */         success = true;
/*     */       }
/* 318 */       catch (Exception ee) {
/* 319 */         logger_.warn("Exception occurred while trying to determine delimiter", ee);
/*     */         
/* 321 */         StringBuilder buf = new StringBuilder(128);
/* 322 */         buf.append("Dumping character values of line. ");
/*     */         
/* 324 */         for (int ii = 0; ii < argFileLine.length(); ii++) {
/* 325 */           buf.append("[").append(argFileLine.charAt(ii)).append(" int: ").append(argFileLine.charAt(ii))
/* 326 */             .append("] ");
/*     */         }
/* 328 */         logger_.warn(buf.toString());
/*     */         
/* 330 */         success = false;
/*     */       } 
/*     */       
/* 333 */       this.delimiterDetectionAttempted_ = true;
/*     */     } 
/*     */     
/* 336 */     return success;
/*     */   }
/*     */   
/*     */   private void closeSplitFilesWriter(Map<String, SplitFile> argSplitFiles) {
/* 340 */     Collection<SplitFile> filesCollection = argSplitFiles.values();
/* 341 */     List<SplitFile> files = new ArrayList<>(filesCollection);
/* 342 */     for (SplitFile file : files) {
/*     */       try {
/* 344 */         file.closeFileWriter();
/*     */       }
/* 346 */       catch (IOException ex) {
/* 347 */         logger_.warn("Error closing the split file writer.");
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
/*     */ 
/*     */   
/*     */   private List<SplitFile> finishSplitFiles(Map<String, SplitFile> argSplitFiles, HeaderLine argHeaderLine) throws IOException {
/* 364 */     Collection<SplitFile> filesCollection = argSplitFiles.values();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 372 */     List<SplitFile> files = new ArrayList<>(filesCollection);
/* 373 */     Collections.sort(files, new SplitFileComparator());
/*     */     
/* 375 */     int totalLines = 0;
/*     */     
/* 377 */     for (SplitFile file : files) {
/* 378 */       file.finishedWriting();
/* 379 */       totalLines += file.getLineCount();
/*     */     } 
/*     */     
/* 382 */     if (argHeaderLine != null && argHeaderLine.getDeclaredLineCount() != null)
/*     */     {
/* 384 */       if (argHeaderLine.getDeclaredLineCount().intValue() != totalLines) {
/*     */         
/* 386 */         String msg = "Total file line count [" + totalLines + "] does not equal expected line count [" + argHeaderLine.getDeclaredLineCount() + "] as specified in header.";
/*     */         
/* 388 */         DataLoaderEventLogger.warn(msg);
/* 389 */         logger_.warn(msg);
/*     */       } 
/*     */     }
/*     */     
/* 393 */     return files;
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
/*     */   
/*     */   private void handleReorganizationDataFile(Map<String, SplitFile> argSplitFiles, File argSourceDataFile) {
/* 407 */     if (this.currentDelimiter_ == null) {
/* 408 */       logger_.error("Delimiter must be set to process reorganization and replacement files.");
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 413 */     Set<String> recordTypeSet = new HashSet<>();
/*     */ 
/*     */     
/* 416 */     for (SplitFile splitFile : argSplitFiles.values()) {
/* 417 */       recordTypeSet.add(splitFile.getRecordType());
/*     */     }
/*     */ 
/*     */     
/* 421 */     for (String recordType : recordTypeSet) {
/*     */       
/* 423 */       String key = recordType + "." + "DELETE_BY_ORGANIZATION";
/*     */       
/* 425 */       if (argSplitFiles.get(key) == null) {
/* 426 */         SplitFile newSplitFile = new SplitFile(argSourceDataFile, recordType, "DELETE_BY_ORGANIZATION", ENCODING, false);
/*     */ 
/*     */         
/*     */         try {
/* 430 */           newSplitFile.writeLine(makeReorgOrReplaceCommandLine("DELETE_BY_ORGANIZATION", recordType));
/*     */         }
/* 432 */         catch (Exception e) {
/* 433 */           logger_.error("Exception occurred while trying to write operation:DELETE_BY_ORGANIZATION to split file.", e);
/*     */         } 
/*     */         
/* 436 */         argSplitFiles.put(key, newSplitFile);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void handleSplitFileException(Exception argException, File argDataFile) throws DataFileException {
/* 444 */     String msg = "An exception occurred while spliting datafile: [" + argDataFile + "]";
/* 445 */     logger_.error(msg, argException);
/* 446 */     DataLoaderEventLogger.error(msg, argException);
/* 447 */     throw new DataFileException(msg + argException.getMessage());
/*     */   }
/*     */   
/*     */   private void logNoDelimiter(String argCurrentLine) {
/* 451 */     String msg = "Bad line is being skipped because the delimiter could not be determined for the current file.";
/*     */ 
/*     */     
/* 454 */     logger_.warn("Bad line is being skipped because the delimiter could not be determined for the current file.\n" + argCurrentLine);
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
/*     */   private String makeReorgOrReplaceCommandLine(String argAction, String argRecordType) {
/* 466 */     StringBuilder command = (new StringBuilder(argAction)).append(this.currentDelimiter_).append(argRecordType);
/*     */ 
/*     */     
/* 469 */     if (argAction.equals("DELETE_BY_ORGANIZATION")) {
/* 470 */       command.append(this.currentDelimiter_)
/* 471 */         .append(System.getProperty("dtv.location.organizationId").toString());
/*     */     }
/* 473 */     return command.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public class SortedFileLineIterator
/*     */     implements Iterator<FileLine>
/*     */   {
/*     */     private DataFileProcessor.SplitFileLineIterator _lineIterator;
/*     */ 
/*     */ 
/*     */     
/*     */     private final Iterator<SplitFile> _fileListIterator;
/*     */ 
/*     */ 
/*     */     
/*     */     public SortedFileLineIterator(List<SplitFile> argFiles) {
/* 491 */       this._fileListIterator = argFiles.iterator();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 496 */       if (this._lineIterator != null && this._lineIterator.hasNext()) {
/* 497 */         return true;
/*     */       }
/*     */       
/* 500 */       if (this._fileListIterator.hasNext()) {
/* 501 */         this._lineIterator = new DataFileProcessor.SplitFileLineIterator(this._fileListIterator.next());
/*     */         
/* 503 */         return this._lineIterator.hasNext();
/*     */       } 
/*     */       
/* 506 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public FileLine next() {
/* 511 */       if (this._lineIterator != null && this._lineIterator.hasNext()) {
/* 512 */         return this._lineIterator.next();
/*     */       }
/*     */       
/* 515 */       if (this._fileListIterator.hasNext()) {
/* 516 */         this._lineIterator = new DataFileProcessor.SplitFileLineIterator(this._fileListIterator.next());
/*     */         
/* 518 */         if (this._lineIterator.hasNext()) {
/* 519 */           return this._lineIterator.next();
/*     */         }
/*     */       } 
/*     */       
/* 523 */       throw new NoSuchElementException();
/*     */     }
/*     */ 
/*     */     
/*     */     public final void remove() {
/* 528 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   class SplitFileComparator
/*     */     implements Comparator<SplitFile>
/*     */   {
/*     */     public int compare(SplitFile arg1, SplitFile arg2) {
/* 537 */       int sort1 = 0;
/* 538 */       int sort2 = 0;
/*     */       
/* 540 */       if (!DataLoaderConfig.isRunSql(arg1.getActionType()) && !DataLoaderConfig.isRunSql(arg2.getActionType())) {
/* 541 */         sort1 = DataLoaderConfigHelper.getDataLoaderConfig().getRecordTypeSortOrder(arg1.getRecordType());
/* 542 */         sort2 = DataLoaderConfigHelper.getDataLoaderConfig().getRecordTypeSortOrder(arg2.getRecordType());
/*     */       } 
/*     */       
/* 545 */       if (sort1 != sort2) {
/* 546 */         return (sort1 < sort2) ? -1 : 1;
/*     */       }
/*     */       
/* 549 */       sort1 = DataLoaderConfigHelper.getDataLoaderConfig().getActionTypeSortOrder(arg1.getActionType());
/* 550 */       sort2 = DataLoaderConfigHelper.getDataLoaderConfig().getActionTypeSortOrder(arg2.getActionType());
/*     */       
/* 552 */       return (sort1 == sort2) ? 0 : ((sort1 < sort2) ? -1 : 1);
/*     */     }
/*     */   }
/*     */   
/*     */   private class SplitFileLineIterator
/*     */     implements Iterator<FileLine>
/*     */   {
/* 559 */     private FileLine _nextLine = null;
/*     */     private final SplitFile _file;
/*     */     private boolean _needToGetNext = true;
/*     */     
/*     */     public SplitFileLineIterator(SplitFile argSplitFile) {
/* 564 */       this._file = argSplitFile;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 570 */       if (this._needToGetNext) {
/* 571 */         this._nextLine = DataFileProcessor.this.getNextFileLine(this._file);
/* 572 */         this._needToGetNext = false;
/*     */       } 
/*     */       
/* 575 */       return (this._nextLine != null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public FileLine next() {
/* 581 */       if (this._needToGetNext) {
/* 582 */         this._nextLine = DataFileProcessor.this.getNextFileLine(this._file);
/*     */       }
/* 584 */       this._needToGetNext = true;
/*     */       
/* 586 */       return this._nextLine;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void remove() {
/* 592 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\fileprocessing\DataFileProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */