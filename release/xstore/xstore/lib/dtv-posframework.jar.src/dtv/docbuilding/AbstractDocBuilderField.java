/*     */ package dtv.docbuilding;
/*     */ 
/*     */ import dtv.docbuilding.trace.ITracer;
/*     */ import dtv.docbuilding.types.DocBuilderAlignmentType;
/*     */ import dtv.i18n.formatter.output.IOutputFormatter;
/*     */ import dtv.i18n.formatter.output.NullFormatter;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import java.util.Locale;
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
/*     */ public abstract class AbstractDocBuilderField
/*     */   implements IDocBuilderField
/*     */ {
/*  28 */   private static final Logger logger_ = Logger.getLogger(AbstractDocBuilderField.class);
/*  29 */   private static final IOutputFormatter _defaultFormatter = (IOutputFormatter)new NullFormatter();
/*     */ 
/*     */   
/*     */   private final String contents_;
/*     */ 
/*     */   
/*     */   private final String style_;
/*     */ 
/*     */   
/*     */   private final Integer location_;
/*     */ 
/*     */   
/*     */   private final DocBuilderAlignmentType alignment_;
/*     */ 
/*     */   
/*     */   private final int priority_;
/*     */   
/*     */   private final IOutputFormatter formatter_;
/*     */   
/*     */   private String sourceDescription_;
/*     */   
/*     */   private Integer colWidth_;
/*     */ 
/*     */   
/*     */   public AbstractDocBuilderField(String argContents, String argStyle, Integer argLocation, DocBuilderAlignmentType argAlignment, int argPriority, IOutputFormatter argFormatter) {
/*  54 */     this.contents_ = StringUtils.nonNull(argContents);
/*  55 */     this.style_ = argStyle;
/*  56 */     this.location_ = argLocation;
/*  57 */     this.alignment_ = argAlignment;
/*  58 */     this.priority_ = argPriority;
/*  59 */     this.formatter_ = (argFormatter == null) ? _defaultFormatter : argFormatter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FormattedString[] buildField(Object argSource, IDocElementFactory argFactory, IDocBuilderField.FontInfo argFontInfo, Locale argLocale) {
/*     */     try {
/*  67 */       String preformatting = argFontInfo.getBeginFont() + argFactory.getFieldStyleStart(getStyle());
/*  68 */       String postFormatting = argFactory.getFieldStyleEnd(getStyle()) + argFontInfo.getEndFont();
/*  69 */       String contents = getContents(argSource, argFactory, argLocale);
/*     */       
/*  71 */       (new FormattedString[1])[0] = new FormattedString(preformatting, contents, postFormatting, argFontInfo
/*     */ 
/*     */           
/*  74 */           .isDoubleWide());
/*     */       return (excludeEmpty() && StringUtils.isEmpty(contents)) ? new FormattedString[0] : new FormattedString[1];
/*  76 */     } catch (Exception ex) {
/*  77 */       logger_.error("CAUGHT EXCEPTION with config [" + this + "] @@ [" + getSourceDescription() + "]", ex);
/*  78 */       return new FormattedString[] { new FormattedString("", "", "") };
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final DocBuilderAlignmentType getAlignment() {
/*  84 */     return this.alignment_;
/*     */   }
/*     */   
/*     */   public Integer getColWidth() {
/*  88 */     return this.colWidth_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Integer getLocation() {
/*  98 */     return this.location_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getPriority() {
/* 108 */     return this.priority_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSourceDescription() {
/* 114 */     return this.sourceDescription_;
/*     */   }
/*     */   
/*     */   public void setColWidth(Integer argColWidth) {
/* 118 */     this.colWidth_ = argColWidth;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParameter(String argName, IConfigObject argValue) {
/* 124 */     logger_.warn("Unexpected parameter for " + getClass().getName() + ":" + argName + "=" + argValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSourceDescription(String argValue) {
/* 130 */     this.sourceDescription_ = argValue;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void trace(String argString, ITracer argTracer) {
/* 136 */     argTracer.attr(getClass().getName() + " " + this.contents_);
/*     */   }
/*     */   
/*     */   protected void ensureNonNull(Object o, String argMessage) {
/* 140 */     if (o == null) {
/* 141 */       throw new NullPointerException(argMessage);
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
/*     */   protected boolean excludeEmpty() {
/* 154 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final String getContents() {
/* 165 */     return this.contents_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final IOutputFormatter getFormatter() {
/* 174 */     return this.formatter_;
/*     */   }
/*     */   
/*     */   protected final String getStyle() {
/* 178 */     return this.style_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\AbstractDocBuilderField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */