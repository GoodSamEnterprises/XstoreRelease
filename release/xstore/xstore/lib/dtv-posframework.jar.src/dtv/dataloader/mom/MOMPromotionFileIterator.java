/*     */ package dtv.dataloader.mom;
/*     */ 
/*     */ import dtv.data2.dataloader.pluggable.DataFileException;
/*     */ import dtv.data2.dataloader.pluggable.DataFileMetaData;
/*     */ import java.util.ArrayList;
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
/*     */ public class MOMPromotionFileIterator
/*     */   extends AbstractMOMDataFileIterator
/*     */ {
/*  33 */   private static final Logger _logger = Logger.getLogger(MOMPromotionFileIterator.class);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<MOMFileLine> _promoComponent;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  43 */   private Mode _mode = Mode.PROMO_ENDED;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MOMPromotionFileIterator(DataFileMetaData<MOMFileConfiguration> argMetaData) {
/*  51 */     super(argMetaData);
/*  52 */     this._promoComponent = new ArrayList<>();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected MOMUnit getCompletedUnit(MOMFileLine argLine) {
/*  58 */     MOMUnit completedUnit = null;
/*  59 */     String recordType = argLine.getRecordType();
/*  60 */     switch (recordType)
/*     */     
/*     */     { case "TMBPE":
/*  63 */         validateRecord(argLine, recordType);
/*  64 */         completedUnit = new MOMUnit(argLine, recordType);
/*  65 */         this._mode = Mode.PROMO_STARTED;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 100 */         return completedUnit;case "TPDTL": validateRecord(argLine, recordType); completedUnit = nextPromoComponent(); this._promoComponent.add(argLine); this._mode = Mode.PROMO_COMPONENT_STARTED; return completedUnit;case "TTAIL": validateRecord(argLine, recordType); completedUnit = nextPromoComponent(); this._mode = Mode.PROMO_ENDED; return completedUnit;case "FPDEL": validateRecord(argLine, recordType); completedUnit = new MOMUnit(argLine, recordType); return completedUnit; }  validateRecord(argLine, "OTHER"); this._promoComponent.add(argLine); return completedUnit;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private MOMUnit nextPromoComponent() {
/* 107 */     MOMUnit unit = null;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 112 */     if (this._mode == Mode.PROMO_COMPONENT_STARTED) {
/* 113 */       unit = new MOMUnit(this._promoComponent, ((MOMFileLine)this._promoComponent.get(0)).getRecordType());
/*     */     }
/*     */ 
/*     */     
/* 117 */     this._promoComponent = new ArrayList<>();
/* 118 */     return unit;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void validateRecord(MOMFileLine argLine, String argRecordType) {
/* 126 */     if (!this._mode.supportRecordType(argRecordType)) {
/*     */       
/* 128 */       this._mode = Mode.ERROR;
/* 129 */       throw new DataFileException("Record " + argLine.getFileLine() + " at line " + this._fileLineCnt + " is ignored since it is not expected.");
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
/*     */   private enum Mode
/*     */   {
/* 146 */     PROMO_STARTED((String)new String[] { "TPDTL", "TTAIL" }), PROMO_COMPONENT_STARTED((String)new String[] { "TPDTL", "TTAIL", "OTHER" }),
/* 147 */     PROMO_ENDED((String)new String[] { "TMBPE", "FPDEL" }), ERROR;
/*     */     
/*     */     private String[] _supportedRecordTypes;
/*     */     
/*     */     Mode() {
/* 152 */       this._supportedRecordTypes = new String[0];
/*     */     }
/*     */     
/*     */     Mode(String[] argValidRecTypes) {
/* 156 */       this._supportedRecordTypes = argValidRecTypes;
/*     */     }
/*     */     
/*     */     private boolean supportRecordType(String argRecordType) {
/* 160 */       for (String recordType : this._supportedRecordTypes) {
/* 161 */         if (recordType.equalsIgnoreCase(argRecordType)) {
/* 162 */           return true;
/*     */         }
/*     */       } 
/*     */       
/* 166 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\dataloader\mom\MOMPromotionFileIterator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */