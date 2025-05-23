/*     */ package dtv.dataloader.mom;
/*     */ 
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.dataloader.DataLoaderException;
/*     */ import dtv.data2.dataloader.fileprocessing.DataFileHeaderProcessor;
/*     */ import dtv.data2.dataloader.pluggable.AbstractDataFileIterator;
/*     */ import dtv.data2.dataloader.pluggable.AtomicPersistables;
/*     */ import dtv.data2.dataloader.pluggable.DataFileException;
/*     */ import dtv.data2.dataloader.pluggable.DataFileMetaData;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import org.apache.commons.lang3.StringUtils;
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
/*     */ public abstract class AbstractMOMDataFileIterator
/*     */   extends AbstractDataFileIterator<MOMFileConfiguration>
/*     */ {
/*  35 */   private static final Logger _logger = Logger.getLogger(AbstractMOMDataFileIterator.class);
/*     */   
/*     */   @Resource(name = "momTransformers")
/*     */   private Map<String, IMOMDataTransformer> _transformers;
/*     */   
/*     */   private boolean _truncated = false;
/*     */   
/*     */   private BufferedReader _br;
/*     */   
/*     */   private File _dataFile;
/*  45 */   protected int _fileLineCnt = 0;
/*     */   
/*  47 */   private int _fileLineCntWithoutHeadTail = 0;
/*     */   
/*  49 */   private DataFileHeaderProcessor _headerProc = new DataFileHeaderProcessor();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AbstractMOMDataFileIterator(DataFileMetaData<MOMFileConfiguration> argMetaData) {
/*  57 */     super(argMetaData);
/*     */     
/*  59 */     this._dataFile = argMetaData.getFile();
/*  60 */     this._fileLineCnt = 0;
/*  61 */     this._fileLineCntWithoutHeadTail = 0;
/*     */     
/*     */     try {
/*  64 */       this._br = new BufferedReader(new FileReader(this._dataFile));
/*     */     }
/*  66 */     catch (IOException ex) {
/*  67 */       throw new DataLoaderException("Unable to read file " + this._dataFile.getAbsolutePath(), ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/*  74 */     if (this._br != null) {
/*     */       try {
/*  76 */         this._br.close();
/*     */       }
/*  78 */       catch (IOException ex) {
/*  79 */         _logger.error("Unable to close the reader for file " + this._dataFile.getAbsolutePath(), ex);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract MOMUnit getCompletedUnit(MOMFileLine paramMOMFileLine);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected AtomicPersistables getNext() throws DataFileException {
/*  97 */     DataFileMetaData<MOMFileConfiguration> metaData = getMetaData();
/*  98 */     IMOMDataTransformer transformer = getTransformer();
/*  99 */     List<IPersistable> persistables = null;
/*     */ 
/*     */     
/* 102 */     if (!this._truncated && metaData.getIsFullReload()) {
/* 103 */       this._truncated = true;
/* 104 */       persistables = transformer.purgeData(metaData);
/*     */       
/* 106 */       return new AtomicPersistables(persistables);
/*     */     } 
/*     */ 
/*     */     
/* 110 */     MOMUnit unit = parseUnit();
/* 111 */     if (unit != null) {
/*     */ 
/*     */       
/* 114 */       persistables = transformer.transform(metaData, unit);
/*     */       
/* 116 */       List<String> sourceLines = new ArrayList<>();
/* 117 */       for (MOMFileLine line : unit.getData()) {
/* 118 */         sourceLines.add(line.getFileLine());
/*     */       }
/*     */       
/* 121 */       return new AtomicPersistables(persistables, sourceLines);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 126 */     if (((MOMFileConfiguration)metaData.getConfigObject()).getNumberOfLines() != null && ((MOMFileConfiguration)metaData
/* 127 */       .getConfigObject()).getNumberOfLines().intValue() != this._fileLineCntWithoutHeadTail) {
/*     */ 
/*     */       
/* 130 */       String warnMsg = "Unexpected number of lines (expected=" + ((MOMFileConfiguration)metaData.getConfigObject()).getNumberOfLines() + ", actual=" + this._fileLineCntWithoutHeadTail + ") found in file: " + getMetaData().getFile().getAbsolutePath();
/* 131 */       _logger.warn(warnMsg);
/*     */     } 
/*     */ 
/*     */     
/* 135 */     return null;
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
/*     */   private IMOMDataTransformer getTransformer() throws DataFileException {
/* 149 */     String feedType = getMetaData().getType();
/* 150 */     IMOMDataTransformer transformer = this._transformers.get(feedType);
/*     */     
/* 152 */     if (transformer == null)
/*     */     {
/*     */       
/* 155 */       throw new DataFileException("Unable to find a transformer for feed type " + feedType);
/*     */     }
/*     */     
/* 158 */     return transformer;
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
/*     */   private MOMUnit parseUnit() throws DataFileException {
/*     */     try {
/* 172 */       String fileLine = null;
/*     */       
/* 174 */       while ((fileLine = this._br.readLine()) != null) {
/* 175 */         this._fileLineCnt++;
/*     */ 
/*     */ 
/*     */         
/* 179 */         if (this._headerProc.isHeaderLine(fileLine)) {
/*     */           continue;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 186 */         if (StringUtils.isBlank(fileLine)) {
/*     */           continue;
/*     */         }
/*     */ 
/*     */         
/* 191 */         MOMFileLine momFileLine = new MOMFileLine(this._fileLineCnt, fileLine);
/* 192 */         if (momFileLine.isFileHeader()) {
/*     */           continue;
/*     */         }
/* 195 */         if (momFileLine.isFileTail()) {
/* 196 */           ((MOMFileConfiguration)getMetaData().getConfigObject()).setNumberOfLines(new Integer(momFileLine.getFields()[2]));
/*     */           
/*     */           continue;
/*     */         } 
/* 200 */         this._fileLineCntWithoutHeadTail++;
/*     */ 
/*     */         
/* 203 */         MOMUnit completedUnit = getCompletedUnit(momFileLine);
/* 204 */         if (completedUnit != null) {
/* 205 */           return completedUnit;
/*     */         }
/*     */       }
/*     */     
/* 209 */     } catch (IOException ex) {
/* 210 */       String errorMsg = "Unable to parse the next unit for file " + this._dataFile.getPath();
/* 211 */       _logger.error(errorMsg, ex);
/* 212 */       throw new DataFileException(errorMsg, ex);
/*     */     } 
/*     */ 
/*     */     
/* 216 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\dataloader\mom\AbstractMOMDataFileIterator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */