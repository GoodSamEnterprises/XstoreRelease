/*     */ package dtv.data2.dataloader.pluggable;
/*     */ 
/*     */ import java.util.NoSuchElementException;
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
/*     */ public abstract class AbstractDataFileIterator<T>
/*     */   implements IDataFileIterator
/*     */ {
/*     */   private final DataFileMetaData<T> _metaData;
/*     */   private boolean _needToGetNext = true;
/*     */   private ResultContainer _nextResultContainer;
/*     */   
/*     */   public AbstractDataFileIterator(DataFileMetaData<T> argMetaData) {
/*  24 */     this._metaData = argMetaData;
/*     */   }
/*     */ 
/*     */   
/*     */   public DataFileMetaData<T> getMetaData() {
/*  29 */     return this._metaData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasNext() throws DataFileException {
/*  37 */     if (this._needToGetNext) {
/*  38 */       this._nextResultContainer = getNextResultContainer();
/*  39 */       this._needToGetNext = false;
/*     */     } 
/*     */     
/*  42 */     return (this._nextResultContainer != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AtomicPersistables next() throws DataFileException {
/*  49 */     if (this._needToGetNext) {
/*  50 */       this._nextResultContainer = getNextResultContainer();
/*     */     }
/*     */     
/*  53 */     this._needToGetNext = true;
/*     */     
/*  55 */     if (this._nextResultContainer == null) {
/*  56 */       throw new NoSuchElementException();
/*     */     }
/*     */     
/*  59 */     if (this._nextResultContainer._dataFileException != null) {
/*  60 */       throw this._nextResultContainer._dataFileException;
/*     */     }
/*     */     
/*  63 */     return this._nextResultContainer._persistables;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void remove() {
/*  68 */     throw new UnsupportedOperationException();
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
/*     */   private ResultContainer getNextResultContainer() {
/*     */     try {
/*  82 */       AtomicPersistables next = getNext();
/*  83 */       return (next != null) ? new ResultContainer(next) : null;
/*     */     }
/*  85 */     catch (DataFileException ex) {
/*  86 */       return new ResultContainer(ex);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected abstract AtomicPersistables getNext() throws DataFileException;
/*     */   
/*     */   private class ResultContainer { public final AtomicPersistables _persistables;
/*     */     
/*     */     ResultContainer(AtomicPersistables argSuccessData) {
/*  95 */       this._persistables = argSuccessData;
/*  96 */       this._dataFileException = null;
/*     */     }
/*     */     public final DataFileException _dataFileException;
/*     */     ResultContainer(DataFileException argDataFileException) {
/* 100 */       this._persistables = null;
/* 101 */       this._dataFileException = argDataFileException;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\pluggable\AbstractDataFileIterator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */