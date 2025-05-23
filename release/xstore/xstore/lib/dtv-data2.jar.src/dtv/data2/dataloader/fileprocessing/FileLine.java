/*     */ package dtv.data2.dataloader.fileprocessing;
/*     */ 
/*     */ import dtv.data2.dataloader.DataLoaderException;
/*     */ import dtv.data2.dataloader.config.DataLoaderConfig;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.regex.Pattern;
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
/*     */ public class FileLine
/*     */ {
/*     */   private static final int PRESERVE_TRAILING_BLANKS = -1;
/*     */   private final String fileLine_;
/*     */   private final Pattern delimiter_;
/*     */   private List<String> fields_;
/*     */   private String recordType_;
/*     */   private String actionType_;
/*     */   private final boolean isInstructionValid_;
/*     */   
/*     */   public FileLine(String argFileLine, Pattern argDelimiter) {
/*  34 */     this(argFileLine, argDelimiter, true);
/*     */   }
/*     */   
/*     */   public FileLine(String argFileLine, Pattern argDelimiter, boolean argIsInstructionValid) {
/*  38 */     this.fileLine_ = argFileLine;
/*  39 */     this.delimiter_ = argDelimiter;
/*  40 */     this.isInstructionValid_ = argIsInstructionValid;
/*     */     
/*  42 */     this.recordType_ = System.getProperty("dtv.data2.dataloader.defaultRecordType");
/*  43 */     this.actionType_ = System.getProperty("dtv.data2.dataloader.defaultActionType");
/*     */ 
/*     */ 
/*     */     
/*  47 */     if (this.isInstructionValid_) {
/*  48 */       tokenize();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getActionType() {
/*  56 */     return this.actionType_;
/*     */   }
/*     */   
/*     */   public String getFieldValue(int argOneBasedIndex) {
/*  60 */     return getFieldValueRaw(argOneBasedIndex);
/*     */   }
/*     */   
/*     */   public String getFieldValue(int argStart, int argEnd) {
/*  64 */     return this.fileLine_.substring(argStart, argEnd);
/*     */   }
/*     */   
/*     */   public int getFieldValueCount() {
/*  68 */     return this.fields_.size();
/*     */   }
/*     */   
/*     */   public String getFieldValueRaw(int argOneBasedIndex) {
/*  72 */     if (argOneBasedIndex <= 0) {
/*  73 */       throw new DataLoaderException("getFieldValue takes a ONE based index, but [" + argOneBasedIndex + "] was passed.)");
/*     */     }
/*     */     
/*  76 */     return (argOneBasedIndex > this.fields_.size()) ? "" : this.fields_.get(argOneBasedIndex - 1);
/*     */   }
/*     */   
/*     */   public boolean getIsInstructionValid() {
/*  80 */     return this.isInstructionValid_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRecordType() {
/*  87 */     return this.recordType_;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  92 */     return this.fileLine_;
/*     */   }
/*     */ 
/*     */   
/*     */   private void tokenize() {
/*  97 */     String[] tokens = this.delimiter_.split(this.fileLine_, -1);
/*  98 */     this.fields_ = new ArrayList<>(tokens.length);
/*     */     
/* 100 */     int counter = 0;
/*     */     
/* 102 */     if (tokens.length > 1) {
/* 103 */       for (String field : tokens) {
/* 104 */         field = StringUtils.replaceVariables(field, System.getProperties());
/* 105 */         if (counter == 0) {
/* 106 */           this.actionType_ = field;
/*     */         }
/* 108 */         else if (counter == 1) {
/*     */           
/* 110 */           if (DataLoaderConfig.isRunSql(this.actionType_)) {
/* 111 */             this.recordType_ = this.actionType_;
/* 112 */             this.fields_.add(field);
/*     */           } else {
/*     */             
/* 115 */             this.recordType_ = field;
/*     */           } 
/*     */         } else {
/*     */           
/* 119 */           this.fields_.add(field);
/*     */         } 
/*     */         
/* 122 */         counter++;
/*     */       } 
/*     */     } else {
/*     */       
/* 126 */       this.fields_.add(tokens[0]);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\fileprocessing\FileLine.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */