/*     */ package dtv.docbuilding.types;
/*     */ 
/*     */ import dtv.docbuilding.IDocBuilderField;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.HashMap;
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
/*     */ public class DocBuilderRowCharSize
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -543304572861289223L;
/*     */   private static final String JPOS_ESC = "\033|";
/*     */   private static final String NORMAL_SIZE = "\033|1C";
/*  27 */   private static final Logger logger_ = Logger.getLogger(DocBuilderRowCharSize.class);
/*     */ 
/*     */   
/*  30 */   public static final DocBuilderRowCharSize NORMAL = make(false, "", "", new String[] { "NORMAL" });
/*     */   
/*  32 */   public static final DocBuilderRowCharSize DOUBLEHIGH = make(false, "\033|3C", "\033|1C", new String[] { "DOUBLEHIGH", "X2H" });
/*     */ 
/*     */   
/*  35 */   public static final DocBuilderRowCharSize DOUBLEWIDE = make(true, "\033|2C", "\033|1C", new String[] { "DOUBLEWIDE", "X2W" });
/*     */ 
/*     */   
/*  38 */   public static final DocBuilderRowCharSize DOUBLEHIGHDOUBLEWIDE = make(true, "\033|4C", "\033|1C", new String[] { "DOUBLEHIGHDOUBLEWIDE", "X2HW" });
/*     */   
/*     */   private static Map<String, DocBuilderRowCharSize> values_;
/*     */   
/*     */   private String name_;
/*     */   
/*     */   protected final boolean isDoubleWide_;
/*     */   
/*     */   protected final String fontBegin_;
/*     */   protected final String fontEnd_;
/*     */   
/*     */   public static DocBuilderRowCharSize forName(String argName) {
/*  50 */     if (argName == null) {
/*  51 */       return null;
/*     */     }
/*  53 */     DocBuilderRowCharSize found = values_.get(argName.trim().toUpperCase());
/*  54 */     if (found == null) {
/*  55 */       found = NORMAL;
/*  56 */       logger_.warn("There is no instance of [" + DocBuilderRowCharSize.class.getName() + "] named [" + argName + "].", new Throwable("STACK TRACE"));
/*     */     } 
/*     */     
/*  59 */     return found;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static DocBuilderRowCharSize make(boolean argIsDoubleWide, String argFontBegin, String argFontEnd, String... argNames) {
/*  65 */     DocBuilderRowCharSize instance = null;
/*     */     
/*  67 */     for (String name : argNames) {
/*  68 */       if (instance == null) {
/*  69 */         instance = new DocBuilderRowCharSize(name, argIsDoubleWide, argFontBegin, argFontEnd);
/*     */       } else {
/*     */         
/*  72 */         values_.put(name.trim().toUpperCase(), instance);
/*     */       } 
/*     */     } 
/*  75 */     return instance;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DocBuilderRowCharSize(String argName, boolean argIsDoubleWide, String argFontBegin, String argFontEnd) {
/*  96 */     this.name_ = argName.trim().toUpperCase();
/*  97 */     this.isDoubleWide_ = argIsDoubleWide;
/*  98 */     this.fontBegin_ = argFontBegin;
/*  99 */     this.fontEnd_ = argFontEnd;
/* 100 */     if (values_ == null) {
/* 101 */       values_ = new HashMap<>();
/*     */     }
/* 103 */     values_.put(this.name_, this);
/*     */   }
/*     */   
/*     */   public IDocBuilderField.FontInfo getFieldFontInfo() {
/* 107 */     return new IDocBuilderField.FontInfo()
/*     */       {
/*     */         public String getBeginFont()
/*     */         {
/* 111 */           return DocBuilderRowCharSize.this.fontBegin_;
/*     */         }
/*     */ 
/*     */         
/*     */         public String getEndFont() {
/* 116 */           return DocBuilderRowCharSize.this.fontEnd_;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean isDoubleWide() {
/* 121 */           return DocBuilderRowCharSize.this.isDoubleWide_;
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   public boolean isDoubleWide() {
/* 127 */     return this.isDoubleWide_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 137 */     return this.name_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Object readResolve() {
/* 146 */     Object found = values_.get(this.name_);
/* 147 */     if (found == null) {
/* 148 */       return this;
/*     */     }
/*     */     
/* 151 */     return found;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
/* 159 */     this.name_ = (String)in.readObject();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeObject(ObjectOutputStream out) throws IOException {
/* 166 */     out.writeObject(this.name_);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\types\DocBuilderRowCharSize.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */