/*     */ package dtv.logbuilder.writers;
/*     */ 
/*     */ import dtv.logbuilder.ILogBuilder;
/*     */ import dtv.logbuilder.LogBuilder;
/*     */ import dtv.util.DateUtils;
/*     */ import dtv.util.FileUtils;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.TypeSafeMapKey;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.FileConfig;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.RandomAccessFile;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.util.Map;
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
/*     */ public class LogEntryFileWriter
/*     */   implements ILogEntryWriter
/*     */ {
/*  31 */   private static final Logger logger_ = Logger.getLogger(LogEntryFileWriter.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  37 */   public static final TypeSafeMapKey<Object> FILE_PER_OBJECT = new TypeSafeMapKey("file_per_object", Object.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  44 */   public static final TypeSafeMapKey<Object> FILE_PER_LOG = new TypeSafeMapKey("file_per_log", Object.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  51 */   public static final TypeSafeMapKey<Object> FILE_PATH = new TypeSafeMapKey("file_path", Object.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  58 */   public static final TypeSafeMapKey<String> TRAINING_FILE_PATH = new TypeSafeMapKey("training_file_path", String.class);
/*     */ 
/*     */ 
/*     */   
/*  62 */   public static final TypeSafeMapKey<Object> FILE_PER_BUSINESSDAY = new TypeSafeMapKey("file_per_businessday", Object.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  69 */   public static final TypeSafeMapKey<Object> FILE_PER_REGISTER = new TypeSafeMapKey("file_per_register", Object.class);
/*     */ 
/*     */   
/*     */   private static File toFile(Object o) {
/*  73 */     if (o == null) {
/*  74 */       return null;
/*     */     }
/*  76 */     if (o instanceof File) {
/*  77 */       return (File)o;
/*     */     }
/*  79 */     return (new FileConfig(o.toString())).getFile();
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isAvailable_ = false;
/*     */   
/*     */   private Map<TypeSafeMapKey<?>, Object> settings_;
/*     */   
/*     */   private File outFile_;
/*     */   
/*     */   private FileChannel outChannel_;
/*     */   
/*     */   private RandomAccessFile fileStream_;
/*     */   
/*     */   public void close() throws IOException {
/*     */     try {
/*  95 */       String footer = (String)ILogBuilder.FOOTER.retrieve(this.settings_);
/*  96 */       if (!StringUtils.isEmpty(footer)) {
/*  97 */         write("\n" + (String)ILogBuilder.FOOTER.retrieve(this.settings_));
/*     */       }
/*     */     } finally {
/*     */       
/* 101 */       if (this.fileStream_ != null) {
/*     */         try {
/* 103 */           this.fileStream_.close();
/*     */         }
/* 105 */         catch (IOException ioEx) {
/* 106 */           logger_.warn("Error closing the RandomAccessFile stream", ioEx);
/*     */         } finally {
/*     */           
/* 109 */           this.isAvailable_ = false;
/* 110 */           this.outChannel_ = null;
/* 111 */           this.fileStream_ = null;
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize(Map<TypeSafeMapKey<?>, Object> argSettings) throws IOException {
/*     */     boolean isNewFile;
/* 122 */     this.settings_ = argSettings;
/*     */ 
/*     */ 
/*     */     
/* 126 */     File configuredFilePath = getFilePath();
/*     */     
/* 128 */     boolean filePerDay = toBoolean(FILE_PER_BUSINESSDAY.retrieve(argSettings));
/* 129 */     boolean filePerRegister = toBoolean(FILE_PER_REGISTER.retrieve(argSettings));
/*     */     
/* 131 */     if (toBoolean(FILE_PER_OBJECT.retrieve(this.settings_))) {
/* 132 */       String entryId = (String)ILogBuilder.ENTRY_ID.retrieve(argSettings);
/* 133 */       this.outFile_ = new File(configuredFilePath.getAbsolutePath() + "/" + entryId + ".xml");
/* 134 */       int index = 0;
/*     */       
/* 136 */       while (this.outFile_.exists()) {
/* 137 */         this.outFile_ = new File(configuredFilePath.getAbsolutePath() + "/" + entryId + "(" + ++index + ").xml");
/*     */       }
/* 139 */       isNewFile = true;
/*     */     }
/* 141 */     else if (FILE_PER_LOG.retrieve(this.settings_) != null) {
/* 142 */       Object obj = FILE_PER_LOG.retrieve(this.settings_);
/* 143 */       File path = (obj instanceof File) ? (File)obj : new File((String)obj);
/*     */       
/* 145 */       String[] originalParts = splitOnLast(path.getAbsolutePath(), File.separatorChar);
/* 146 */       String[] logParts = splitOnLast(configuredFilePath.getName().toString(), '.');
/*     */       
/* 148 */       this.outFile_ = new File(originalParts[0] + File.separatorChar + logParts[0] + "." + originalParts[1]);
/*     */       
/* 150 */       isNewFile = !this.outFile_.exists();
/*     */     }
/* 152 */     else if (filePerDay) {
/* 153 */       File file = configuredFilePath.getParentFile();
/* 154 */       String fileName = configuredFilePath.getName();
/* 155 */       String rootFileName = FileUtils.getRootName(fileName);
/* 156 */       String extension = FileUtils.getExtension(fileName);
/*     */       
/* 158 */       String newFileName = rootFileName + DateUtils.format(DateUtils.getNewDate()) + "." + extension;
/*     */       
/* 160 */       this.outFile_ = new File(file.getPath() + "/" + newFileName);
/* 161 */       isNewFile = !this.outFile_.exists();
/*     */     }
/* 163 */     else if (filePerRegister) {
/* 164 */       File file = configuredFilePath.getParentFile();
/* 165 */       String fileName = configuredFilePath.getName();
/* 166 */       String rootFileName = FileUtils.getRootName(fileName);
/* 167 */       String extension = FileUtils.getExtension(fileName);
/* 168 */       String entryId = (String)ILogBuilder.ENTRY_ID.retrieve(argSettings);
/* 169 */       String regNum = getRegisterNumber(entryId);
/* 170 */       regNum = StringUtils.isEmpty(regNum) ? "" : ("." + regNum);
/* 171 */       String newFileName = rootFileName + regNum + "." + extension;
/*     */       
/* 173 */       this.outFile_ = new File(file.getPath() + "/" + newFileName);
/* 174 */       isNewFile = !this.outFile_.exists();
/*     */     } else {
/*     */       
/* 177 */       this.outFile_ = configuredFilePath;
/* 178 */       isNewFile = !this.outFile_.exists();
/*     */     } 
/*     */ 
/*     */     
/* 182 */     File parentFile = this.outFile_.getParentFile();
/* 183 */     if (parentFile != null) {
/* 184 */       parentFile.mkdirs();
/*     */     }
/*     */     
/*     */     try {
/* 188 */       this.fileStream_ = new RandomAccessFile(this.outFile_, "rw");
/* 189 */       this.outChannel_ = this.fileStream_.getChannel();
/* 190 */       this.isAvailable_ = true;
/* 191 */       if (isNewFile) {
/* 192 */         createTlogFile();
/*     */       } else {
/*     */         
/* 195 */         removeOldEndTag(this.outChannel_);
/*     */       }
/*     */     
/* 198 */     } catch (IOException ex) {
/* 199 */       this.isAvailable_ = false;
/*     */       try {
/* 201 */         this.fileStream_.close();
/*     */       }
/* 203 */       catch (Exception ex2) {
/* 204 */         logger_.warn("CAUGHT EXCEPTION", ex2);
/*     */       } finally {
/*     */         
/* 207 */         this.outChannel_ = null;
/* 208 */         this.fileStream_ = null;
/*     */       } 
/* 210 */       throw ex;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void write(String argString) throws IOException {
/* 219 */     if (!this.isAvailable_) {
/* 220 */       throw new IllegalStateException();
/*     */     }
/* 222 */     String encoding = (String)ILogBuilder.ENCODING.retrieve(this.settings_);
/* 223 */     ByteBuffer b = ByteBuffer.wrap(argString.getBytes(encoding));
/* 224 */     this.outChannel_.write(b);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String[] splitOnLast(String argString, char argSplitChar) {
/* 235 */     int index = argString.lastIndexOf(argSplitChar);
/* 236 */     if (index == -1) {
/* 237 */       return null;
/*     */     }
/* 239 */     String[] split = new String[2];
/* 240 */     split[0] = argString.substring(0, index);
/* 241 */     split[1] = argString.substring(index + 1);
/* 242 */     return split;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void createTlogFile() throws IOException {
/* 253 */     String header = (String)ILogBuilder.HEADER.retrieve(this.settings_);
/* 254 */     if (!StringUtils.isEmpty(header)) {
/* 255 */       write((String)ILogBuilder.HEADER.retrieve(this.settings_) + "\n");
/*     */     }
/*     */   }
/*     */   
/*     */   private File getFilePath() {
/* 260 */     if (LogBuilder.getInstance().isTrainingMode()) {
/* 261 */       Object trainingConfig = TRAINING_FILE_PATH.retrieve(this.settings_);
/* 262 */       if (trainingConfig != null) {
/* 263 */         return toFile(trainingConfig);
/*     */       }
/*     */     } 
/* 266 */     return toFile(FILE_PATH.retrieve(this.settings_));
/*     */   }
/*     */   
/*     */   private String getRegisterNumber(String argStr) {
/* 270 */     String reg = "";
/* 271 */     if (!StringUtils.isEmpty(argStr)) {
/* 272 */       int end = argStr.lastIndexOf("_");
/* 273 */       if (end > 0) {
/* 274 */         String sub1 = argStr.substring(0, end);
/* 275 */         int begin = sub1.lastIndexOf("_");
/* 276 */         if (begin > 0) {
/* 277 */           reg = argStr.substring(begin + 1, end);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 282 */     return reg;
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
/*     */   private void removeOldEndTag(FileChannel argChannel) throws IOException {
/* 294 */     int LOOK_SIZE = 100;
/*     */ 
/*     */     
/* 297 */     long fileIndex = argChannel.size() - 100L;
/* 298 */     if (fileIndex < 0L) {
/* 299 */       fileIndex = 0L;
/*     */     }
/* 301 */     argChannel.position(fileIndex);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 306 */     byte[] buff = new byte[100];
/* 307 */     ByteBuffer byteBuffer = ByteBuffer.wrap(buff);
/* 308 */     argChannel.read(byteBuffer);
/*     */     
/* 310 */     String fileEndContents = new String(buff);
/*     */ 
/*     */     
/* 313 */     int tagIndex = fileEndContents.indexOf((String)ILogBuilder.FOOTER.retrieve(this.settings_));
/*     */     
/* 315 */     if (tagIndex < 0) {
/*     */       
/* 317 */       argChannel.position(argChannel.size());
/*     */     }
/*     */     else {
/*     */       
/* 321 */       argChannel.position(fileIndex + tagIndex + (100 - fileEndContents.length()));
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean toBoolean(Object argValue) {
/* 326 */     return (argValue == null) ? false : ConfigUtils.toBoolean(argValue.toString()).booleanValue();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\writers\LogEntryFileWriter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */