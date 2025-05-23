/*    */ package dtv.dataloader.mom;
/*    */ 
/*    */ import java.util.regex.Pattern;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MOMFileLine
/*    */ {
/*    */   private static final int FIELD_INDX_RECORD_TYPE = 0;
/*    */   private static final int FIELD_INDX_FHEAD_FEED_TYPE = 2;
/*    */   private static final String RECORD_TYPE_FHEAD = "FHEAD";
/*    */   private static final String REORD_TYPE_FTAIL = "FTAIL";
/* 24 */   private static final Pattern _delimiter = Pattern.compile(Pattern.quote("|"));
/*    */   
/*    */   private static final int PRESERVE_TRAILING_BLANKS = -1;
/*    */   private final int _lineNo;
/*    */   private final String _fileLine;
/*    */   private final String[] _fields;
/*    */   
/*    */   public MOMFileLine(int argLineNo, String argFileLine) {
/* 32 */     this._lineNo = argLineNo;
/* 33 */     this._fileLine = argFileLine;
/* 34 */     this._fields = _delimiter.split(argFileLine, -1);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getFeedType() {
/* 42 */     String feedType = "";
/* 43 */     if (isFileHeader() && 
/* 44 */       this._fields.length > 2) {
/* 45 */       feedType = this._fields[2];
/*    */     }
/*    */     
/* 48 */     return feedType;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String[] getFields() {
/* 56 */     return this._fields;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getFileLine() {
/* 64 */     return this._fileLine;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getLineNo() {
/* 72 */     return this._lineNo;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getRecordType() {
/* 79 */     String recordType = "";
/* 80 */     if (this._fields.length > 0) {
/* 81 */       recordType = this._fields[0];
/*    */     }
/* 83 */     return recordType;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isFileHeader() {
/* 90 */     return "FHEAD".equals(getRecordType());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isFileTail() {
/* 97 */     return "FTAIL".equals(getRecordType());
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\dataloader\mom\MOMFileLine.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */