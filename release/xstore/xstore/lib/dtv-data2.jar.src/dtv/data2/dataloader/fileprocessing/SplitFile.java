/*     */ package dtv.data2.dataloader.fileprocessing;
/*     */ 
/*     */ import dtv.data2.dataloader.DataLoaderException;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStreamWriter;
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
/*     */ public class SplitFile
/*     */   extends File
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private String _encoding;
/*     */   private String recordType_;
/*     */   private String actionType_;
/*     */   private String sourceDataFileName;
/*     */   private BufferedWriter myWriter_;
/*  30 */   private int lineCount_ = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isErrorFile_ = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SplitFile(File argDataFile, String argRecordType, String argAction, String argCharacterEncoding, boolean argIsErrorFile) {
/*  43 */     this((new StringBuilder(argDataFile.getAbsolutePath().length() + 32)).append(argDataFile.getAbsolutePath())
/*  44 */         .append('.').append(argRecordType).append('.').append(argAction).toString());
/*  45 */     setRecordType(argRecordType);
/*  46 */     setActionType(argAction);
/*  47 */     if (argDataFile != null) {
/*  48 */       setSourceDataFileName(argDataFile.getName());
/*     */     }
/*     */     
/*  51 */     this._encoding = argCharacterEncoding;
/*  52 */     this.isErrorFile_ = argIsErrorFile;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SplitFile(String argPathname) {
/*  59 */     super(argPathname);
/*     */     
/*     */     try {
/*  62 */       if (!exists()) {
/*  63 */         boolean success = createNewFile();
/*     */         
/*  65 */         if (!success) {
/*  66 */           throw new DataLoaderException("Could not create split file: " + this);
/*     */         }
/*     */       }
/*     */     
/*  70 */     } catch (Exception ee) {
/*  71 */       throw new DataLoaderException("An exception occurred while setting up split file: " + argPathname, ee);
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
/*     */   public void closeFileWriter() throws IOException {
/*  84 */     if (this.myWriter_ != null) {
/*     */       try {
/*  86 */         this.myWriter_.close();
/*     */       } finally {
/*     */         
/*  89 */         this.myWriter_ = null;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void finishedWriting() throws IOException {
/*  97 */     if (this.myWriter_ != null) {
/*  98 */       this.myWriter_.flush();
/*  99 */       this.myWriter_.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getActionType() {
/* 107 */     return this.actionType_;
/*     */   }
/*     */   
/*     */   public boolean getIsErrorFile() {
/* 111 */     return this.isErrorFile_;
/*     */   }
/*     */   
/*     */   public int getLineCount() {
/* 115 */     return this.lineCount_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRecordType() {
/* 122 */     return this.recordType_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSourceDataFileName() {
/* 130 */     return this.sourceDataFileName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setActionType(String argActionType) {
/* 137 */     this.actionType_ = argActionType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRecordType(String argRecordType) {
/* 144 */     this.recordType_ = argRecordType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSourceDataFileName(String argSourceDataFileName) {
/* 152 */     this.sourceDataFileName = argSourceDataFileName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeLine(String argLine) throws IOException {
/* 163 */     if (this.myWriter_ == null) {
/* 164 */       this.myWriter_ = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this), this._encoding));
/*     */     }
/* 166 */     this.myWriter_.write(argLine);
/* 167 */     this.myWriter_.write(10);
/*     */     
/* 169 */     this.lineCount_++;
/*     */     
/* 171 */     if (this.lineCount_ % 200 == 0)
/* 172 */       this.myWriter_.flush(); 
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\fileprocessing\SplitFile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */