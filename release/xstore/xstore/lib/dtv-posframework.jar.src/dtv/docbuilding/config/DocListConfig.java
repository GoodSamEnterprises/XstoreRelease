/*     */ package dtv.docbuilding.config;
/*     */ 
/*     */ import dtv.docbuilding.DocSectionMap;
/*     */ import dtv.docbuilding.IDocBuilder;
/*     */ import dtv.docbuilding.IPrinterTargetInfo;
/*     */ import dtv.docbuilding.trace.ITracer;
/*     */ import dtv.docbuilding.trace.StringBufferTracer;
/*     */ import dtv.util.CompositeObject;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.AbstractParentConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.SortedSet;
/*     */ import java.util.TreeSet;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DocListConfig
/*     */   extends AbstractParentConfig
/*     */ {
/*     */   public static final String MAIN_TAG = "DocList";
/*     */   private static final long serialVersionUID = 1L;
/*  31 */   private static final Logger logger_ = Logger.getLogger(DocListConfig.class);
/*     */   
/*  33 */   private final List<DocConfig> layoutConfigs_ = new ArrayList<>();
/*  34 */   private final Map<CompositeObject, IDocBuilder<CompositeObject>> layouts_ = new HashMap<>();
/*     */ 
/*     */   
/*     */   public File dumpConfigDot(File argDir) {
/*     */     try {
/*  39 */       StringBufferTracer tracer = new StringBufferTracer();
/*  40 */       SortedSet<CompositeObject> keys = new TreeSet<>(this.layouts_.keySet());
/*  41 */       for (CompositeObject k : keys) {
/*  42 */         IDocBuilder<CompositeObject> builder = this.layouts_.get(k);
/*  43 */         dumpConfigDotImpl(tracer, builder, argDir);
/*     */       }
/*     */     
/*  46 */     } catch (Throwable ex) {
/*  47 */       logger_.error("CAUGHT EXCEPTION", ex);
/*     */     } 
/*  49 */     return argDir;
/*     */   }
/*     */   
/*     */   public File dumpConfigDot(File argDir, String argDocType) {
/*  53 */     IDocBuilder<CompositeObject> builder = getBuilder(argDocType);
/*  54 */     return dumpConfigDotImpl(new StringBufferTracer(), builder, argDir);
/*     */   }
/*     */   
/*     */   public IDocBuilder<CompositeObject> getBuilder(String argDocType) {
/*  58 */     return this.layouts_.get(new CompositeObject(new Object[] { StringUtils.nonNull(argDocType).toUpperCase() }));
/*     */   }
/*     */   
/*     */   public String[] getPrinterTypes() {
/*  62 */     Set<String> results = new HashSet<>();
/*  63 */     for (Map.Entry<CompositeObject, IDocBuilder<CompositeObject>> entry : this.layouts_.entrySet()) {
/*  64 */       IPrinterTargetInfo pti = ((IDocBuilder)entry.getValue()).getPrinterTargetInfo();
/*  65 */       results.add(pti.getPrinterType());
/*  66 */       results.add(pti.getBackupPrinterType());
/*     */     } 
/*  68 */     results.remove(null);
/*  69 */     return results.<String>toArray(new String[results.size()]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize(DocSectionMap argSections) {
/*  78 */     for (DocConfig config : this.layoutConfigs_) {
/*  79 */       IDocBuilder<CompositeObject> builder = config.makeBuilder(argSections);
/*  80 */       if (builder != null) {
/*  81 */         CompositeObject key = builder.getDocType();
/*  82 */         if (logger_.isInfoEnabled() && this.layouts_.containsKey(key)) {
/*  83 */           logger_.info("Document ID " + key + " is defined more than once with config='" + 
/*  84 */               getSourceDescription() + "'");
/*     */         }
/*  86 */         this.layouts_.put(key, builder);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  95 */     if (argValue instanceof DocConfig) {
/*  96 */       this.layoutConfigs_.add((DocConfig)argValue);
/*     */     } else {
/*     */       
/*  99 */       warnUnsupported(argKey, argValue);
/*     */     } 
/*     */   }
/*     */   
/*     */   private File dumpConfigDotImpl(StringBufferTracer tracer, IDocBuilder<CompositeObject> builder, File argDir) {
/* 104 */     tracer.startGraph(builder.getDocType().toString());
/* 105 */     builder.trace((ITracer)tracer);
/* 106 */     tracer.endGraph();
/* 107 */     return tracer.export(argDir, builder.getDocType(), "svg");
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\config\DocListConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */