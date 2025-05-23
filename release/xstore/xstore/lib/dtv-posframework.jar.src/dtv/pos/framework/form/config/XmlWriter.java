/*     */ package dtv.pos.framework.form.config;
/*     */ 
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.IReflectionParameterCapable;
/*     */ import dtv.util.config.ISavableConfig;
/*     */ import dtv.util.config.IXmlWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.Writer;
/*     */ import java.util.Arrays;
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
/*     */ public class XmlWriter
/*     */   extends Writer
/*     */   implements IXmlWriter
/*     */ {
/*  26 */   private static final Logger logger_ = Logger.getLogger(XmlWriter.class);
/*     */   
/*     */   private static void sort(Object[] argObjects) {
/*  29 */     if (argObjects != null && argObjects.length > 0 && argObjects[0] instanceof Comparable) {
/*  30 */       Arrays.sort(argObjects);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private final Writer parent_;
/*  36 */   private int level_ = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlWriter(Writer argParent) {
/*  44 */     this.parent_ = argParent;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/*  52 */     this.parent_.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void flush() throws IOException {
/*  60 */     this.parent_.flush();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(char[] cbuf) throws IOException {
/*  68 */     this.parent_.write(cbuf);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(char[] cbuf, int off, int len) throws IOException {
/*  76 */     this.parent_.write(cbuf, off, len);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(int c) throws IOException {
/*  84 */     this.parent_.write(c);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(String str) throws IOException {
/*  92 */     this.parent_.write(str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(String str, int off, int len) throws IOException {
/* 100 */     this.parent_.write(str, off, len);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeComment(String argComment) throws IOException {
/* 108 */     writeSpaces(this.level_);
/* 109 */     this.parent_.write("<!--");
/* 110 */     this.parent_.write(argComment);
/* 111 */     this.parent_.write("-->\n");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeElement(String argTag, String argAttributes) throws IOException {
/* 119 */     writeSpaces(this.level_);
/* 120 */     this.parent_.write("<");
/* 121 */     this.parent_.write(argTag);
/* 122 */     if (!StringUtils.isEmpty(argAttributes)) {
/* 123 */       this.parent_.write(" ");
/* 124 */       this.parent_.write(argAttributes);
/*     */     } 
/* 126 */     this.parent_.write(" />\n");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeFooter(String argMainTag) throws IOException {
/* 134 */     writeSpaces(--this.level_);
/* 135 */     this.parent_.write("</");
/* 136 */     this.parent_.write(argMainTag);
/* 137 */     this.parent_.write(">\n");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeHeader(String argMainTag, String argMainType) throws IOException {
/* 145 */     writeHeader(argMainTag, argMainType, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeHeader(String argMainTag, String argMainType, String argMoreProperties) throws IOException {
/* 153 */     writeSpaces(this.level_++);
/* 154 */     this.parent_.write("<");
/* 155 */     this.parent_.write(argMainTag);
/* 156 */     if (!argMainTag.equals(argMainType)) {
/* 157 */       this.parent_.write(" dtype=\"");
/* 158 */       this.parent_.write(argMainType);
/* 159 */       this.parent_.write("\"");
/*     */     } 
/* 161 */     if (argMoreProperties != null && argMoreProperties.length() > 0) {
/* 162 */       this.parent_.write(" ");
/* 163 */       this.parent_.write(argMoreProperties);
/*     */     } 
/* 165 */     this.parent_.write(">\n");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeSpaces(int count) throws IOException {
/* 173 */     for (int i = 0; i < count; i++) {
/* 174 */       this.parent_.write("  ");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeTableLayoutComments(double[] doubleValues) throws IOException {
/* 183 */     writeSpaces(this.level_);
/* 184 */     this.parent_.write("<!--");
/*     */     
/* 186 */     for (int i = 0; i < doubleValues.length; i++) {
/* 187 */       if (doubleValues[i] == -1.0D) {
/* 188 */         this.parent_.write("FILL");
/*     */       }
/* 190 */       else if (doubleValues[i] == -2.0D) {
/* 191 */         this.parent_.write("PREFERRED");
/*     */       }
/* 193 */       else if (doubleValues[i] == -3.0D) {
/* 194 */         this.parent_.write("MINIMUM");
/*     */       } else {
/*     */         
/* 197 */         this.parent_.write(String.valueOf(doubleValues[i]));
/*     */       } 
/* 199 */       if (i < doubleValues.length - 1) {
/* 200 */         this.parent_.write(", ");
/*     */       }
/*     */     } 
/* 203 */     this.parent_.write("-->\n");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeValue(ISavableConfig argObject) throws IOException {
/* 211 */     if (argObject != null) {
/* 212 */       argObject.write(this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeValue(ISavableConfig[] argObjects) throws IOException {
/* 221 */     sort((Object[])argObjects);
/* 222 */     if (argObjects != null) {
/* 223 */       for (ISavableConfig argObject : argObjects) {
/* 224 */         argObject.write(this);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeValue(String argTag, IReflectionParameterCapable<?> argValue) throws IOException {
/* 234 */     if (argValue != null && argValue.getConfigValue() != null) {
/* 235 */       writeSpaces(this.level_);
/* 236 */       this.parent_.write("<");
/* 237 */       this.parent_.write(argTag);
/* 238 */       if (!argTag.equals(argValue.getConfigDataType())) {
/* 239 */         this.parent_.write(" dtype=\"");
/* 240 */         this.parent_.write(argValue.getConfigDataType());
/* 241 */         this.parent_.write("\"");
/*     */       } 
/* 243 */       this.parent_.write(">");
/* 244 */       this.parent_.write(argValue.getConfigValue());
/* 245 */       this.parent_.write("</");
/* 246 */       this.parent_.write(argTag);
/* 247 */       this.parent_.write(">\n");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeValue(String argTag, String argDtype, Object argValue) throws IOException {
/* 256 */     if (argValue != null) {
/* 257 */       if (argValue instanceof IReflectionParameterCapable) {
/* 258 */         logger_.warn("TRY LEAVING OFF THE DTYPE FOR THIS ONE", new Throwable("STACK TRACE"));
/*     */       }
/* 260 */       String stringValue = StringUtils.nonNull(argValue);
/* 261 */       if (!StringUtils.isEmpty(stringValue)) {
/* 262 */         writeSpaces(this.level_);
/* 263 */         this.parent_.write("<");
/* 264 */         this.parent_.write(argTag);
/* 265 */         if (!argTag.equals(argDtype)) {
/* 266 */           this.parent_.write(" dtype=\"");
/* 267 */           this.parent_.write(argDtype);
/* 268 */           this.parent_.write("\"");
/*     */         } 
/* 270 */         this.parent_.write(">");
/* 271 */         this.parent_.write(StringUtils.nonNull(argValue));
/* 272 */         this.parent_.write("</");
/* 273 */         this.parent_.write(argTag);
/* 274 */         this.parent_.write(">\n");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\config\XmlWriter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */