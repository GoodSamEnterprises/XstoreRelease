/*     */ package dtv.data2.dataloader;
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.access.IPersistenceMgr;
/*     */ import dtv.data2.access.IQueryKey;
/*     */ import dtv.data2.dataloader.filelocator.FileLocator;
/*     */ import dtv.data2.dataloader.filelocator.IDataFileLocator;
/*     */ import dtv.data2.dataloader.filelocator.ListFileLocator;
/*     */ import dtv.data2.dataloader.fileprocessing.FileProcessingStats;
/*     */ import dtv.data2.dataloader.fileprocessing.IHasSourceData;
/*     */ import dtv.data2.dataloader.pluggable.AtomicPersistables;
/*     */ import dtv.data2.dataloader.pluggable.DataFileException;
/*     */ import dtv.data2.dataloader.pluggable.DataFileMetaData;
/*     */ import dtv.data2.dataloader.pluggable.IDataFileIterator;
/*     */ import dtv.data2.dataloader.pluggable.IDataFileTypeDetector;
/*     */ import dtv.data2.dataloader.pluggable.IFileNameSortingStrategy;
/*     */ import dtv.data2.dataloader.pluggable.StubDataFileIterator;
/*     */ import dtv.util.EndsWithNameFilter;
/*     */ import dtv.util.config.SystemPropertiesLoader;
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Comparator;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.inject.Inject;
/*     */ import org.apache.logging.log4j.Level;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.springframework.beans.BeansException;
/*     */ import org.springframework.context.ConfigurableApplicationContext;
/*     */ import org.springframework.context.support.ClassPathXmlApplicationContext;
/*     */ 
/*     */ public class DataLoader {
/*  36 */   private static final Logger _logger = LogManager.getLogger(DataLoader.class);
/*     */   
/*     */   private static final String SPRING_DEFAULT_ACTIVE_PROFILES = "dataloader";
/*     */   private static final String ARCHIVED_FAILURE_EXTENSION = ".failed";
/*  40 */   private static final IQueryKey<?> _healthQuery = (IQueryKey<?>)new QueryKey("CHECK_HEALTH", Object.class);
/*     */ 
/*     */ 
/*     */   
/*     */   private static ConfigurableApplicationContext _springContext;
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/*     */     try {
/*  50 */       (new SystemPropertiesLoader()).loadSystemProperties();
/*     */ 
/*     */       
/*  53 */       String springProfiles = System.getProperty("spring.profiles.active");
/*     */       
/*  55 */       if (springProfiles == null) {
/*  56 */         System.setProperty("spring.profiles.active", "dataloader");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  62 */       String[] files = ClassPathUtils.getDirectoryBasedConfigFileListRelativePaths("spring", (INameFilter)new EndsWithNameFilter(new String[] { ".xml" }));
/*     */ 
/*     */       
/*  65 */       _springContext = (ConfigurableApplicationContext)new ClassPathXmlApplicationContext(files);
/*     */       
/*  67 */       DataLoaderConfigHelper.getDataLoaderConfig();
/*     */     }
/*  69 */     catch (Exception ee) {
/*  70 */       _logger.fatal("Dataloader encounted an exception while attempting to load system properties.", ee);
/*     */       
/*  72 */       DataLoaderEventLogger.fatal("Dataloader encounted an exception while attempting to load system properties.", ee);
/*  73 */       System.exit(1);
/*     */     } 
/*     */     
/*  76 */     if (!isDBAvailable()) {
/*  77 */       _logger.fatal("No database connection available.");
/*  78 */       System.exit(1);
/*     */     } 
/*     */     
/*     */     try {
/*  82 */       DataLoader dataLoader = (DataLoader)_springContext.getBean(DataLoader.class);
/*  83 */       dataLoader.run(null);
/*     */     }
/*  85 */     catch (DataLoaderException ex) {
/*  86 */       _logger.error(ex.getMessage(), ex);
/*     */     } 
/*     */     
/*  89 */     System.exit(0);
/*     */   }
/*     */   
/*     */   protected static boolean isDBAvailable() {
/*     */     try {
/*  94 */       DataFactory.getObjectByQuery(_healthQuery, new HashMap<>());
/*     */     }
/*  96 */     catch (Exception ex) {
/*  97 */       _logger.warn("Error interrogating online status of local DB: " + ex);
/*  98 */       return false;
/*     */     } 
/* 100 */     return true;
/*     */   }
/*     */ 
/*     */   
/* 104 */   private Map<IFileNameSortingStrategy, List<DataFileMetaData<?>>> _sortingStrategyMap = null;
/*     */ 
/*     */   
/* 107 */   private int numOfSuccesses = 0;
/*     */ 
/*     */   
/* 110 */   private int numOfFailures = 0;
/*     */   
/*     */   private IDataFileLocator _dataFileLocator;
/*     */   
/*     */   private List<IDataFileTypeDetector> _detectors;
/*     */   
/*     */   @Inject
/*     */   private ConfigParameters _configParameters;
/*     */   
/*     */   @Inject
/*     */   private IFileArchiver _fileArchiver;
/*     */   
/*     */   @Inject
/*     */   private IDataFileIteratorFactory _dataFileLoaderFactory;
/*     */   
/*     */   @Inject
/*     */   private IResultsWriter _resultsWriter;
/*     */   
/* 128 */   private String _optionalRunId = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DataLoader() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DataLoader(List<IDataFileTypeDetector> argDetectors) {
/* 140 */     this._detectors = argDetectors;
/*     */   }
/*     */   
/*     */   public IDataFileLocator getDataFileLocator() {
/* 144 */     if (this._dataFileLocator == null) {
/* 145 */       if (this._configParameters.getProcessListFiles()) {
/* 146 */         this._dataFileLocator = (IDataFileLocator)new ListFileLocator(this._configParameters.getDataFileLocation());
/*     */       } else {
/*     */         
/* 149 */         this._dataFileLocator = (IDataFileLocator)new FileLocator(this._configParameters.getDataFileLocation());
/*     */       } 
/*     */     }
/*     */     
/* 153 */     return this._dataFileLocator;
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
/*     */   public HashMap<IFileNameSortingStrategy, List<DataFileMetaData<?>>> getMetaDataSortingMap(List<File> argDataFiles) {
/* 165 */     HashMap<IFileNameSortingStrategy, List<DataFileMetaData<?>>> sortingStrategyMap = new HashMap<>();
/*     */     
/* 167 */     if (argDataFiles != null) {
/* 168 */       for (File dataFile : argDataFiles) {
/* 169 */         boolean foundDetectorForFile = false;
/* 170 */         for (IDataFileTypeDetector detector : this._detectors) {
/* 171 */           DataFileMetaData<?> metaData = detector.detect(dataFile);
/*     */ 
/*     */           
/* 174 */           if (metaData != null) {
/* 175 */             foundDetectorForFile = true;
/* 176 */             if (!metaData.getSkipThisFile()) {
/*     */               
/* 178 */               List<DataFileMetaData<?>> listOfMetaData = sortingStrategyMap.get(detector.getFileNameSortingStrategy());
/* 179 */               if (listOfMetaData == null) {
/* 180 */                 listOfMetaData = new ArrayList<>();
/* 181 */                 sortingStrategyMap.put(detector.getFileNameSortingStrategy(), listOfMetaData);
/*     */               } 
/* 183 */               listOfMetaData.add(metaData);
/*     */             } 
/*     */           } 
/*     */         } 
/* 187 */         if (!foundDetectorForFile) {
/* 188 */           _logger.warn("No detectors recognized this file: " + dataFile.getName());
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 193 */           this._resultsWriter.setFileBeingProcessed(dataFile.getName());
/* 194 */           FileProcessingStats stats = new FileProcessingStats();
/* 195 */           stats.failureCounter++;
/* 196 */           this._resultsWriter.writeResultsSummary(stats);
/*     */         } 
/*     */       } 
/*     */     }
/* 200 */     return sortingStrategyMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadData(List<File> argFilesToLoad) {
/*     */     List<File> dataFiles;
/*     */     String operationDescription;
/* 209 */     long startTime = System.currentTimeMillis();
/* 210 */     this._resultsWriter.start(this._optionalRunId, new Date(startTime));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 215 */     if (argFilesToLoad != null) {
/* 216 */       operationDescription = "DataLoader (processing specific file(s))";
/* 217 */       dataFiles = argFilesToLoad;
/* 218 */       logDataLoadStartSpecificFile(operationDescription, argFilesToLoad);
/*     */     } else {
/*     */       
/* 221 */       operationDescription = "DataLoader (scanning for newly effective files)";
/* 222 */       String argDataFilePath = this._configParameters.getDataFileLocation();
/* 223 */       File dataFilePath = new File(argDataFilePath);
/*     */       
/* 225 */       if (!dataFilePath.isDirectory()) {
/* 226 */         logInvalidDataFilePath(operationDescription, argDataFilePath);
/* 227 */         throw new DataLoaderException("An invalid data file path is configured [" + dataFilePath
/* 228 */             .getAbsolutePath() + "].");
/*     */       } 
/*     */ 
/*     */       
/* 232 */       dataFiles = getDataFileLocator().getDataFiles();
/*     */       
/* 234 */       int numberOfFiles = (dataFiles != null) ? dataFiles.size() : 0;
/* 235 */       logDataLoadStartDetectFiles(operationDescription, argDataFilePath, numberOfFiles);
/*     */     } 
/*     */ 
/*     */     
/* 239 */     this._sortingStrategyMap = getMetaDataSortingMap(dataFiles);
/*     */ 
/*     */     
/* 242 */     for (IFileNameSortingStrategy sortingStrategy : this._sortingStrategyMap.keySet()) {
/* 243 */       sortDataFiles(sortingStrategy, this._sortingStrategyMap.get(sortingStrategy));
/* 244 */       _logger.info("Sort files based on :" + sortingStrategy.getClass().getName());
/*     */       
/* 246 */       readDataFromFiles(this._sortingStrategyMap.get(sortingStrategy), operationDescription, startTime);
/*     */     } 
/*     */     
/* 249 */     logDataLoadEnd(operationDescription, startTime, this.numOfSuccesses, this.numOfFailures);
/* 250 */     this._resultsWriter.finish(this._optionalRunId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void run(List<File> argFilesToLoad) {
/* 257 */     run(argFilesToLoad, null);
/*     */   }
/*     */   
/*     */   public void run(List<File> argFilesToLoad, String argOptionalRunID) {
/* 261 */     this._optionalRunId = argOptionalRunID;
/*     */     
/* 263 */     String trickleProp = System.getProperty("dtv.dataloader.trickle", "false");
/* 264 */     boolean trickleMode = Boolean.valueOf(trickleProp).booleanValue();
/*     */     
/* 266 */     if (trickleMode) {
/* 267 */       _logger.info("DataLoader is running in trickle mode.");
/*     */     }
/*     */     
/* 270 */     this._fileArchiver.cleanUpStatusFiles();
/*     */ 
/*     */     
/* 273 */     loadData(argFilesToLoad);
/*     */ 
/*     */ 
/*     */     
/* 277 */     if (this._fileArchiver.archiveStatusFiles()) {
/* 278 */       this._fileArchiver.archiveSummaryFile();
/*     */     }
/*     */     
/* 281 */     this._fileArchiver.cleanUpArchives();
/*     */     
/*     */     try {
/* 284 */       Thread.sleep(5000L);
/*     */     }
/* 286 */     catch (Exception exception) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDataFileLocator(IDataFileLocator argDataFileLocator) {
/* 296 */     this._dataFileLocator = argDataFileLocator;
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
/*     */   public void sortDataFiles(final IFileNameSortingStrategy argSortingStrategy, List<DataFileMetaData<?>> argMetaDataList) {
/* 308 */     Collections.sort(argMetaDataList, new Comparator<DataFileMetaData<?>>()
/*     */         {
/*     */           public int compare(DataFileMetaData<?> arg1, DataFileMetaData<?> arg2) {
/* 311 */             return argSortingStrategy.compare(arg1, arg2);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   protected void logDataFileResults(File argDataFile, int argSuccessCount, int argFailureCount, long startTime) {
/* 318 */     boolean success = (argFailureCount == 0);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 323 */     String successIndicator = " success_flag=" + success;
/*     */     
/* 325 */     long fileEndTime = System.currentTimeMillis();
/*     */     
/* 327 */     String msg = "Dataloader processed data file" + argDataFile + " in " + ((fileEndTime - startTime) / 1000L) + " seconds with " + (argSuccessCount + argFailureCount) + " persistables. Successful persistables: " + argSuccessCount + ". Failed persistables: " + argFailureCount + "." + successIndicator;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 332 */     Level l = success ? Level.INFO : Level.ERROR;
/* 333 */     DataLoaderEventLogger.log(l, msg);
/* 334 */     logInfo(msg);
/*     */   }
/*     */   
/*     */   protected void logDataFileStart(File dataFile) {
/* 338 */     DataLoaderEventLogger.setCurrentHeader(null, null);
/* 339 */     DataLoaderEventLogger.info("DataLoader processing data file: " + dataFile);
/* 340 */     logInfo("DataLoader processing data file: " + dataFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void logDataLoadEnd(String argOperationDescription, long startTime, int argSuccessCount, int argFailureCount) {
/* 345 */     DataLoaderEventLogger.setCurrentHeader(null, null);
/* 346 */     long endTime = System.currentTimeMillis();
/*     */     
/* 348 */     String msg = argOperationDescription + " finished running in " + ((endTime - startTime) / 1000L) + " seconds. Processed " + (argSuccessCount + argFailureCount) + " total persistables. Successful persistables: " + argSuccessCount + ". Failed persistables: " + argFailureCount + ".";
/*     */ 
/*     */ 
/*     */     
/* 352 */     DataLoaderEventLogger.info(msg);
/*     */     
/* 354 */     boolean success = (argSuccessCount > 0 && argFailureCount == 0);
/* 355 */     logSuccess(msg, success);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void logDataLoadStartDetectFiles(String argOperationDescription, String argDataFilePath, int argNumDataFiles) {
/* 361 */     String message = argOperationDescription + " started. Data file path: " + argDataFilePath + ". Number of datafiles to be processed: " + String.valueOf(argNumDataFiles);
/*     */     
/* 363 */     logInfo(message);
/* 364 */     DataLoaderEventLogger.info(message);
/*     */   }
/*     */   
/*     */   protected void logDataLoadStartSpecificFile(String argOperationDescription, List<File> argFilesToLoad) {
/* 368 */     StringBuilder messageBuilder = new StringBuilder(argOperationDescription);
/* 369 */     messageBuilder.append(" started. " + argFilesToLoad.size() + " file(s) were specified for processing: ");
/*     */     
/* 371 */     for (File file : argFilesToLoad) {
/* 372 */       messageBuilder.append(file.getAbsolutePath());
/* 373 */       messageBuilder.append("; ");
/*     */     } 
/*     */     
/* 376 */     String message = messageBuilder.toString();
/* 377 */     logInfo(message);
/* 378 */     DataLoaderEventLogger.info(message);
/*     */   }
/*     */   
/*     */   protected void logInfo(String argMsg) {
/* 382 */     if (_logger.isInfoEnabled()) {
/* 383 */       _logger.info(argMsg);
/*     */     } else {
/*     */       
/* 386 */       System.out.println(argMsg);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void logInvalidDataFilePath(String argDescription, String argDataFilePath) {
/* 391 */     String message = argDescription + " run. Data file path [" + argDataFilePath + "] must be a directory. No files will be processed.";
/*     */ 
/*     */     
/* 394 */     DataLoaderEventLogger.error(message);
/* 395 */     _logger.error(message);
/*     */   }
/*     */   
/*     */   protected void logSuccess(String argMsg, boolean argSuccess) {
/* 399 */     if (argSuccess) {
/* 400 */       this._resultsWriter.writeSuccess(argMsg);
/*     */     }
/*     */     
/* 403 */     logInfo(argMsg);
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
/*     */   protected void readDataFromFiles(List<DataFileMetaData<?>> metaDataList, String operationDescription, long startTime) {
/* 415 */     this.numOfSuccesses = 0;
/* 416 */     this.numOfFailures = 0;
/*     */     
/* 418 */     for (DataFileMetaData<?> metaData : metaDataList) {
/* 419 */       IDataFileIterator iDataFileIterator; File dataFile = metaData.getFile();
/*     */       
/* 421 */       this._resultsWriter.setFileBeingProcessed(dataFile.getName());
/* 422 */       logDataFileStart(dataFile);
/*     */       
/* 424 */       FileProcessingStats fileStats = new FileProcessingStats();
/*     */       
/* 426 */       StubDataFileIterator stubDataFileIterator = new StubDataFileIterator();
/*     */       try {
/* 428 */         iDataFileIterator = this._dataFileLoaderFactory.createDataFileIterator(metaData);
/*     */       }
/* 430 */       catch (BeansException e) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 436 */         fileStats.failureCounter++;
/* 437 */         _logger.error("SEVERE: Spring failed to initialize datafile iterator", (Throwable)e);
/*     */       } 
/*     */       
/* 440 */       fileStats = process(iDataFileIterator, fileStats);
/*     */       
/* 442 */       this.numOfSuccesses += fileStats.successCounter;
/* 443 */       this.numOfFailures += fileStats.failureCounter;
/*     */       
/*     */       try {
/* 446 */         iDataFileIterator.close();
/*     */       }
/* 448 */       catch (Throwable t) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 453 */         _logger.error("SEVERE: IDataFileIterator did not .close() cleanly after processing " + dataFile
/* 454 */             .getAbsolutePath(), t);
/* 455 */         fileStats.failureCounter++;
/*     */       } 
/*     */       
/* 458 */       this._resultsWriter.writeResultsSummary(fileStats);
/* 459 */       logDataFileResults(dataFile, fileStats.successCounter, fileStats.failureCounter, startTime);
/*     */       
/* 461 */       if (fileStats.failureCounter == 0) {
/* 462 */         this._fileArchiver.archiveDataFile(dataFile, null);
/*     */         continue;
/*     */       } 
/* 465 */       String archiveName = dataFile.getName().concat(".failed");
/* 466 */       this._fileArchiver.archiveDataFile(dataFile, archiveName);
/*     */     } 
/*     */ 
/*     */     
/* 470 */     if (metaDataList.size() > 0) {
/* 471 */       getDataFileLocator().cleanup();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private FileProcessingStats process(IDataFileIterator argDataFileIterator, FileProcessingStats stats) {
/* 477 */     Batch currentBatch = new Batch(this._configParameters.getRecordsPerTransaction());
/*     */     
/*     */     try {
/* 480 */       while (argDataFileIterator.hasNext()) {
/*     */         try {
/* 482 */           AtomicPersistables persistables = argDataFileIterator.next();
/*     */           
/* 484 */           currentBatch.addAtomicPersistables(persistables);
/*     */           
/* 486 */           if (currentBatch.isFull()) {
/* 487 */             PersistenceResult persistenceResult = savePersistablesToDatabase(currentBatch);
/* 488 */             stats.addPersistenceResult(persistenceResult);
/*     */ 
/*     */             
/* 491 */             currentBatch = new Batch(this._configParameters.getRecordsPerTransaction());
/*     */           }
/*     */         
/* 494 */         } catch (DataFileException ex) {
/* 495 */           stats.failureCounter++;
/*     */ 
/*     */           
/* 498 */           _logger.error(ex.getMessage());
/* 499 */           this._resultsWriter.writeFailure(ex.getMessage(), (IHasSourceData)ex);
/*     */ 
/*     */           
/* 502 */           stats.addProcessingException(ex);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 507 */       if (!currentBatch.isEmpty()) {
/* 508 */         PersistenceResult persistenceResult = savePersistablesToDatabase(currentBatch);
/* 509 */         stats.addPersistenceResult(persistenceResult);
/*     */       }
/*     */     
/* 512 */     } catch (Throwable t) {
/* 513 */       DataFileException unexpected = new DataFileException(t.toString(), t);
/*     */ 
/*     */       
/* 516 */       _logger.error(t);
/* 517 */       this._resultsWriter.writeFailure(unexpected.getMessage(), (IHasSourceData)unexpected);
/* 518 */       stats.addProcessingException(unexpected);
/*     */     } 
/*     */     
/* 521 */     return stats;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PersistenceResult savePersistablesToDatabase(Batch argBatch) {
/* 529 */     PersistenceResult result = new PersistenceResult();
/* 530 */     IPersistenceMgr pmNoReplication = DataFactory.getInstance().getPersistenceMgr();
/* 531 */     pmNoReplication.setReplicationEnabled(false);
/*     */ 
/*     */     
/*     */     try {
/* 535 */       List<IPersistable> allPersistables = argBatch.getAllPersistables();
/* 536 */       DataFactory.makePersistent(allPersistables, pmNoReplication);
/*     */       
/* 538 */       result.successfulAtomicPersists = argBatch.getAtomicPersistablesList().size();
/* 539 */       _logger.debug("Successfully persisted a batch of daos with size: " + result.successfulAtomicPersists);
/*     */     }
/* 541 */     catch (Exception ex) {
/* 542 */       String msg = "An exception occurred while persisting a batch of daos. Attempting one atomic group of daos at a time...";
/*     */       
/* 544 */       _logger.warn(msg, ex);
/* 545 */       DataLoaderEventLogger.warn(msg, ex);
/*     */ 
/*     */       
/* 548 */       for (AtomicPersistables atomicPersistables : argBatch.getAtomicPersistablesList()) {
/*     */         try {
/* 550 */           DataFactory.makePersistent(atomicPersistables.getPersistables(), pmNoReplication);
/* 551 */           result.successfulAtomicPersists++;
/*     */         }
/* 553 */         catch (Exception ex2) {
/*     */           
/* 555 */           result.addPersistenceExceptionCount(ex2);
/*     */           
/* 557 */           if (_logger.isDebugEnabled()) {
/* 558 */             _logger.debug("An exception occurred while persisting: " + atomicPersistables, ex2);
/*     */           }
/*     */           
/* 561 */           this._resultsWriter.writeFailure(ex2.getMessage(), (IHasSourceData)atomicPersistables);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 566 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class PersistenceResult
/*     */   {
/* 574 */     public int successfulAtomicPersists = 0;
/* 575 */     public Map<Class<?>, Integer> exceptionCounts = new HashMap<>();
/*     */ 
/*     */     
/*     */     public void addPersistenceExceptionCount(Exception argException) {
/* 579 */       Class<?> causeClass = argException.getClass();
/*     */ 
/*     */       
/* 582 */       Integer exceptionCount = Integer.valueOf(this.exceptionCounts.containsKey(causeClass) ? (((Integer)this.exceptionCounts.get(causeClass)).intValue() + 1) : 1);
/* 583 */       this.exceptionCounts.put(causeClass, exceptionCount);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private class Batch
/*     */   {
/*     */     private int _maxSize;
/*     */     
/* 592 */     private List<IPersistable> _allPersistables = new ArrayList<>();
/* 593 */     private List<AtomicPersistables> _atomicPersistablesList = new ArrayList<>();
/*     */     
/*     */     public Batch(int argMaxSize) {
/* 596 */       this._maxSize = argMaxSize;
/*     */     }
/*     */     
/*     */     public void addAtomicPersistables(AtomicPersistables argAtomicPersistables) {
/* 600 */       this._atomicPersistablesList.add(argAtomicPersistables);
/* 601 */       this._allPersistables.addAll(argAtomicPersistables.getPersistables());
/*     */     }
/*     */     
/*     */     public List<IPersistable> getAllPersistables() {
/* 605 */       return this._allPersistables;
/*     */     }
/*     */     
/*     */     public List<AtomicPersistables> getAtomicPersistablesList() {
/* 609 */       return this._atomicPersistablesList;
/*     */     }
/*     */     
/*     */     public boolean isEmpty() {
/* 613 */       return this._atomicPersistablesList.isEmpty();
/*     */     }
/*     */     
/*     */     public boolean isFull() {
/* 617 */       return (this._atomicPersistablesList.size() >= this._maxSize);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\DataLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */