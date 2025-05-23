/*     */ package dtv.docbuilding;
/*     */ 
/*     */ import dtv.docbuilding.types.DocBuilderAlignmentType;
/*     */ import dtv.i18n.formatter.output.IOutputFormatter;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.config.IReflectionParameterCapable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import org.apache.commons.collections.iterators.ArrayIterator;
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
/*     */ public class IteratingDocBuilderField
/*     */   extends AbstractDocBuilderField
/*     */ {
/*  28 */   private static final Logger logger_ = Logger.getLogger(IteratingDocBuilderField.class);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Class<?>[] paramClasses_;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Object[] params_;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final IDocBuilderField[] memberFields_;
/*     */ 
/*     */ 
/*     */   
/*     */   private final IDocBuilderField separator_;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IteratingDocBuilderField(String argMethodName, List<IReflectionParameterCapable<?>> argMethodParamList, IDocBuilderField argSeparator, List<IDocBuilderField> argMemberFields, String argStyle, Integer argLocation, DocBuilderAlignmentType argAlignment, int argPriority, IOutputFormatter argFormatter) {
/*  53 */     super(argMethodName, argStyle, argLocation, argAlignment, argPriority, argFormatter);
/*     */     
/*  55 */     if (argMethodParamList != null && argMethodParamList.size() > 0) {
/*  56 */       this.paramClasses_ = new Class[argMethodParamList.size()];
/*  57 */       this.params_ = new Object[argMethodParamList.size()];
/*  58 */       for (int i = 0; i < this.paramClasses_.length; i++) {
/*  59 */         IReflectionParameterCapable<?> config = argMethodParamList.get(i);
/*  60 */         this.paramClasses_[i] = config.getParamDataType();
/*  61 */         this.params_[i] = config.getParamValue();
/*     */       } 
/*     */     } else {
/*     */       
/*  65 */       this.paramClasses_ = new Class[0];
/*  66 */       this.params_ = new Object[0];
/*     */     } 
/*  68 */     this.memberFields_ = argMemberFields.<IDocBuilderField>toArray(new IDocBuilderField[0]);
/*  69 */     this.separator_ = argSeparator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FormattedString[] buildField(Object argSource, IDocElementFactory argFactory, IDocBuilderField.FontInfo argFontInfo, Locale argLocale) {
/*     */     try {
/*  78 */       Object o = DocBuilderHelper.invokeMethodChain(
/*  79 */           getContents(), argSource, this.paramClasses_, this.params_, getSourceDescription());
/*     */       
/*  81 */       FormattedString[] contents = iterate(argFactory, o, argFontInfo, argLocale);
/*     */ 
/*     */       
/*  84 */       StringBuffer sb = new StringBuffer();
/*  85 */       for (FormattedString element : contents) {
/*  86 */         sb.append(element.getRawText());
/*     */       }
/*  88 */       String preformatting = argFontInfo.getBeginFont() + argFactory.getFieldStyleStart(getStyle());
/*  89 */       String postFormatting = argFactory.getFieldStyleEnd(getStyle()) + argFontInfo.getEndFont();
/*     */ 
/*     */       
/*  92 */       FormattedString result = new FormattedString(preformatting, sb.toString(), postFormatting, argFontInfo.isDoubleWide());
/*     */       
/*  94 */       return new FormattedString[] { result };
/*     */     }
/*  96 */     catch (Exception ex) {
/*  97 */       logger_.warn("CAUGHT EXCEPTION with source='" + ObjectUtils.getClassNameFromObject(argSource) + "':'" + argSource + "', method='" + 
/*  98 */           getContents() + "', config='" + getSourceDescription() + "'", ex);
/*  99 */       return new FormattedString[0];
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
/*     */   public String getContents(Object argSource, IDocElementFactory argFactory, Locale argLocale) {
/* 111 */     throw new UnsupportedOperationException("not implemented");
/*     */   }
/*     */   
/*     */   protected IDocBuilderField[] getMembers() {
/* 115 */     return this.memberFields_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected FormattedString[] iterate(IDocElementFactory argElementFactory, Object o, IDocBuilderField.FontInfo argFontInfo, Locale argLocale) {
/* 123 */     if (o == null) {
/* 124 */       return new FormattedString[0];
/*     */     }
/* 126 */     if (o instanceof Object[]) {
/* 127 */       return iterate((Iterator<Object>)new ArrayIterator(o), argElementFactory, argFontInfo, argLocale);
/*     */     }
/* 129 */     if (o instanceof dtv.data2.access.IHasGenericProperties) {
/* 130 */       return iterate(Collections.<Object>singleton(o).iterator(), argElementFactory, argFontInfo, argLocale);
/*     */     }
/* 132 */     if (o instanceof Iterable) {
/* 133 */       return iterate(((Iterable<Object>)o).iterator(), argElementFactory, argFontInfo, argLocale);
/*     */     }
/*     */     
/* 136 */     return iterate(Collections.<Object>singleton(o).iterator(), argElementFactory, argFontInfo, argLocale);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected FormattedString[] iterate(Iterator<Object> argIterator, IDocElementFactory argElementFactory, IDocBuilderField.FontInfo argFontInfo, Locale argLocale) {
/* 143 */     IDocBuilderField[] members = getMembers();
/* 144 */     List<FormattedString> results = new ArrayList<>();
/* 145 */     FormattedString[] sep = null;
/*     */     
/* 147 */     while (argIterator.hasNext()) {
/*     */ 
/*     */       
/* 150 */       if (sep != null) {
/* 151 */         results.addAll(Arrays.asList(sep));
/*     */       }
/* 153 */       Object o = argIterator.next();
/* 154 */       for (IDocBuilderField member : members) {
/* 155 */         results.addAll(Arrays.asList(member.buildField(o, argElementFactory, argFontInfo, argLocale)));
/*     */       }
/* 157 */       if (this.separator_ != null)
/*     */       {
/*     */         
/* 160 */         sep = this.separator_.buildField(o, argElementFactory, argFontInfo, argLocale);
/*     */       }
/*     */     } 
/* 163 */     return results.<FormattedString>toArray(new FormattedString[results.size()]);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\IteratingDocBuilderField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */