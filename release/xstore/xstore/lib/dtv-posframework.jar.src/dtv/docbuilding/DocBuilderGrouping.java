/*     */ package dtv.docbuilding;
/*     */ 
/*     */ import dtv.docbuilding.conditions.IDocBuilderCondition;
/*     */ import dtv.docbuilding.config.ICollectionFilter;
/*     */ import dtv.docbuilding.trace.ITracer;
/*     */ import dtv.util.DtvMultiStorage;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.ClassConfig;
/*     */ import dtv.util.config.IReflectionParameterCapable;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DocBuilderGrouping
/*     */   extends AbstractDocBuilderSectionMember
/*     */   implements IDocBuilderIteratorMember
/*     */ {
/*  29 */   private static final Logger logger_ = Logger.getLogger(DocBuilderGrouping.class);
/*     */   
/*     */   private final String method_;
/*     */   
/*     */   private final Class<?>[] methodArgTypes_;
/*     */   
/*     */   private final Object[] methodArgs_;
/*     */   
/*     */   private final String groupByMethod_;
/*     */   
/*     */   private final List<IDocBuilderCondition> groupConditions_;
/*     */   
/*     */   private final List<IDocBuilderCondition> itemConditions_;
/*     */   
/*     */   private final Comparator<Object> groupComparator_;
/*     */   
/*     */   private final Comparator<Object> itemComparator_;
/*     */   private final IDocBuilderIteratorMember headerSection_;
/*     */   private final IDocBuilderIteratorMember itemSection_;
/*     */   private final IDocBuilderIteratorMember footerSection_;
/*     */   private final ICollectionFilter filter_;
/*     */   
/*     */   public DocBuilderGrouping(String argMethod, IReflectionParameterCapable[] argMethodParams, String argGroupByMethod, List<IDocBuilderCondition> argGroupConditions, List<IDocBuilderCondition> argItemConditions, ClassConfig argGroupComparator, ClassConfig argItemComparator, IDocBuilderIteratorMember argHeaderSection, IDocBuilderIteratorMember argItemSection, IDocBuilderIteratorMember argFooterSection, ICollectionFilter argFilter) {
/*  52 */     this.method_ = argMethod;
/*  53 */     this.groupByMethod_ = argGroupByMethod;
/*  54 */     this.headerSection_ = argHeaderSection;
/*  55 */     this.itemSection_ = argItemSection;
/*  56 */     this.footerSection_ = argFooterSection;
/*  57 */     this.filter_ = argFilter;
/*     */     
/*  59 */     this.groupConditions_ = argGroupConditions;
/*  60 */     this.itemConditions_ = argItemConditions;
/*     */     
/*  62 */     if (argMethodParams == null) {
/*  63 */       this.methodArgTypes_ = new Class[0];
/*  64 */       this.methodArgs_ = new Object[0];
/*     */     } else {
/*     */       
/*  67 */       this.methodArgTypes_ = new Class[argMethodParams.length];
/*  68 */       this.methodArgs_ = new Object[argMethodParams.length];
/*  69 */       for (int i = 0; i < argMethodParams.length; i++) {
/*  70 */         this.methodArgTypes_[i] = argMethodParams[i].getParamDataType();
/*  71 */         this.methodArgs_[i] = argMethodParams[i].getParamValue();
/*     */       } 
/*     */     } 
/*     */     
/*  75 */     this
/*  76 */       .groupComparator_ = (argGroupComparator != null) ? (Comparator<Object>)ObjectUtils.createInstance(argGroupComparator.getValue()) : null;
/*     */ 
/*     */     
/*  79 */     this
/*  80 */       .itemComparator_ = (argItemComparator != null) ? (Comparator<Object>)ObjectUtils.createInstance(argItemComparator.getValue()) : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void buildDoc(IPosDocument argDoc, Object argSource, IDocElementFactory argElementFactory) throws IOException {
/*     */     try {
/*  89 */       buildDocImpl(argDoc, argSource, argElementFactory);
/*     */     }
/*  91 */     catch (IOException ex) {
/*  92 */       throw ex;
/*     */     }
/*  94 */     catch (Exception ex) {
/*  95 */       logger_.error("CAUGHT EXCEPTION wtih config='" + getSourceDescription() + "'", ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void trace(ITracer argTracer) {
/* 101 */     String node = argTracer.startNode("GROUPING", hashCode());
/* 102 */     argTracer.attr(getSourceDescription());
/*     */     
/* 104 */     if (this.headerSection_ != null) {
/* 105 */       this.headerSection_.trace(argTracer);
/*     */     }
/* 107 */     if (this.itemSection_ != null) {
/* 108 */       this.itemSection_.trace(argTracer);
/*     */     }
/* 110 */     if (this.footerSection_ != null) {
/* 111 */       this.footerSection_.trace(argTracer);
/*     */     }
/* 113 */     argTracer.endNode(node);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void buildDocImpl(IPosDocument argDoc, Object argSource, IDocElementFactory argElementFactory) throws IOException {
/*     */     Collection<?> target;
/* 121 */     if (StringUtils.isEmpty(this.method_)) {
/*     */       
/* 123 */       target = (Collection)argSource;
/*     */     }
/*     */     else {
/*     */       
/* 127 */       target = (Collection)DocBuilderHelper.invokeMethodChain(this.method_, argSource, this.methodArgTypes_, this.methodArgs_, 
/* 128 */           getSourceDescription());
/*     */     } 
/*     */     
/* 131 */     if (this.filter_ != null) {
/* 132 */       target = this.filter_.filter(target);
/*     */     }
/*     */ 
/*     */     
/* 136 */     DtvMultiStorage<Object, Object> groupings = new DtvMultiStorage();
/* 137 */     List<Object> uniqueGroupingValues = new ArrayList();
/*     */     
/* 139 */     for (Object item : target) {
/* 140 */       if (DocBuilderHelper.meetsConditions(item, this.itemConditions_)) {
/*     */         
/* 142 */         Object groupingValue = DocBuilderHelper.invokeMethodChain(this.groupByMethod_, item, null, null, getSourceDescription());
/*     */         
/* 144 */         if (DocBuilderHelper.meetsConditions(groupingValue, this.groupConditions_)) {
/* 145 */           groupings.put(groupingValue, item);
/* 146 */           if (!uniqueGroupingValues.contains(groupingValue)) {
/* 147 */             uniqueGroupingValues.add(groupingValue);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 153 */     if (this.groupComparator_ != null) {
/* 154 */       Collections.sort(uniqueGroupingValues, this.groupComparator_);
/*     */     }
/*     */ 
/*     */     
/* 158 */     for (Object groupingValue : uniqueGroupingValues) {
/* 159 */       List<Object> values = groupings.getList(groupingValue);
/*     */       
/* 161 */       if (this.headerSection_ != null) {
/* 162 */         this.headerSection_.buildDoc(argDoc, values, argElementFactory);
/*     */       }
/*     */ 
/*     */       
/* 166 */       if (this.itemSection_ != null) {
/*     */         
/* 168 */         if (this.itemComparator_ != null) {
/* 169 */           Collections.sort(values, this.itemComparator_);
/*     */         }
/* 171 */         for (Object value : values) {
/* 172 */           this.itemSection_.buildDoc(argDoc, value, argElementFactory);
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 177 */       if (this.footerSection_ != null)
/* 178 */         this.footerSection_.buildDoc(argDoc, values, argElementFactory); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\DocBuilderGrouping.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */