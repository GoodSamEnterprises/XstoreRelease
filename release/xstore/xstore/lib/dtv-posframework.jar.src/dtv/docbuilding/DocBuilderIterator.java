/*     */ package dtv.docbuilding;
/*     */ 
/*     */ import dtv.docbuilding.conditions.IDocBuilderCondition;
/*     */ import dtv.docbuilding.trace.ITracer;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.config.IReflectionParameterCapable;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
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
/*     */ 
/*     */ public class DocBuilderIterator
/*     */   extends AbstractDocBuilderSectionMember
/*     */   implements IDocBuilderIterator
/*     */ {
/*  27 */   private static final Logger logger_ = Logger.getLogger(DocBuilderIterator.class);
/*     */   
/*     */   private final List<IDocBuilderCondition> conditions_;
/*     */   
/*     */   private final List<IDocBuilderIteratorMember> members_;
/*  32 */   private String methodName_ = null;
/*  33 */   private Class<?>[] paramClasses_ = null;
/*  34 */   private Object[] params_ = null;
/*  35 */   private Comparator<? super Object> itemComparator_ = null;
/*     */   
/*     */   public DocBuilderIterator() {
/*  38 */     this(null, null);
/*     */   }
/*     */   
/*     */   public DocBuilderIterator(List<IDocBuilderCondition> argConditions) {
/*  42 */     this(argConditions, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DocBuilderIterator(List<IDocBuilderCondition> argConditions, List<IDocBuilderIteratorMember> argMembers) {
/*  49 */     this.conditions_ = (argConditions == null) ? new ArrayList<>() : new ArrayList<>(argConditions);
/*     */ 
/*     */ 
/*     */     
/*  53 */     this.members_ = (argConditions == null) ? new ArrayList<>() : new ArrayList<>(argMembers);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addCondition(IDocBuilderCondition argCondition) {
/*  61 */     if (argCondition != null) {
/*  62 */       getConditions().add(argCondition);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addMember(IDocBuilderIteratorMember argMember) {
/*  69 */     if (argMember != null) {
/*  70 */       this.members_.add(argMember);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void buildDoc(IPosDocument argDoc, Object argSource, IDocElementFactory argElementFactory) {
/*  77 */     String methodName = argElementFactory.getParameterMap().resolveParamValue(this.methodName_);
/*     */     
/*     */     try {
/*  80 */       Object o = DocBuilderHelper.invokeMethodChain(methodName, argSource, this.paramClasses_, this.params_, 
/*  81 */           getSourceDescription());
/*  82 */       iterate(argDoc, argElementFactory, o);
/*     */     }
/*  84 */     catch (Exception ex) {
/*  85 */       logger_.warn("CAUGHT EXCEPTION with source='" + ObjectUtils.getClassNameFromObject(argSource) + "':'" + argSource + "' method='" + this.methodName_ + "', config='" + 
/*  86 */           getSourceDescription(), ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConditions(List<IDocBuilderCondition> argConditions) {
/*  93 */     getConditions().clear();
/*  94 */     if (argConditions != null) {
/*  95 */       getConditions().addAll(argConditions);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemComparator(Comparator<? super Object> newValue) {
/* 102 */     this.itemComparator_ = newValue;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMembers(List<IDocBuilderIteratorMember> argMembers) {
/* 108 */     this.members_.clear();
/* 109 */     if (argMembers != null) {
/* 110 */       this.members_.addAll(argMembers);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMethodName(String newValue) {
/* 117 */     this.methodName_ = newValue;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMethodParams(List<IReflectionParameterCapable<?>> newValue) {
/* 123 */     if (newValue != null && newValue.size() > 0) {
/* 124 */       this.paramClasses_ = new Class[newValue.size()];
/* 125 */       this.params_ = new Object[newValue.size()];
/* 126 */       for (int i = 0; i < this.paramClasses_.length; i++) {
/* 127 */         IReflectionParameterCapable<?> config = newValue.get(i);
/* 128 */         this.paramClasses_[i] = config.getParamDataType();
/* 129 */         this.params_[i] = config.getParamValue();
/*     */       } 
/*     */     } else {
/*     */       
/* 133 */       this.paramClasses_ = new Class[0];
/* 134 */       this.params_ = new Object[0];
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void trace(ITracer argTracer) {
/* 142 */     argTracer.attr(getSourceDescription());
/* 143 */     for (IDocBuilderIteratorMember element : this.members_) {
/* 144 */       element.trace(argTracer);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void buildDocImpl(IPosDocument argDoc, Object argObj, List<IDocBuilderIteratorMember> argMembers, IDocElementFactory argElementFactory) throws IOException {
/* 153 */     if (argObj != null) {
/* 154 */       for (IDocBuilderIteratorMember member : argMembers) {
/* 155 */         if (DocBuilderHelper.meetsConditions(argObj, getConditions())) {
/* 156 */           member.buildDoc(argDoc, argObj, argElementFactory);
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   protected List<IDocBuilderCondition> getConditions() {
/* 163 */     return this.conditions_;
/*     */   }
/*     */   
/*     */   protected Comparator<? super Object> getItemComparator() {
/* 167 */     return this.itemComparator_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<IDocBuilderIteratorMember> getMembers() {
/* 175 */     return this.members_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void iterate(IPosDocument argDoc, IDocElementFactory argElementFactory, Object o) throws IOException {
/* 183 */     if (o instanceof Collection) {
/* 184 */       List<Object> list = (o instanceof List) ? (List<Object>)o : new ArrayList((Collection)o);
/* 185 */       iterateList(argDoc, argElementFactory, list);
/*     */     }
/* 187 */     else if (o instanceof Object[]) {
/* 188 */       iterateList(argDoc, argElementFactory, Arrays.asList((Object[])o));
/*     */     }
/* 190 */     else if (o != null) {
/* 191 */       logger_.warn("Unable to iterate over a [" + ObjectUtils.getClassNameFromObject(o) + "] @@ [" + 
/* 192 */           getSourceDescription() + "]");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void iterateList(IPosDocument argDoc, IDocElementFactory argElementFactory, List<?> argList) throws IOException {
/* 199 */     List<?> list = argList;
/* 200 */     if (getItemComparator() != null) {
/* 201 */       list = new ArrayList(list);
/* 202 */       Collections.sort(list, getItemComparator());
/*     */     } 
/*     */     
/* 205 */     List<IDocBuilderIteratorMember> members = getMembers();
/*     */     
/* 207 */     if (members != null)
/* 208 */       for (Object o : list)
/* 209 */         buildDocImpl(argDoc, o, members, argElementFactory);  
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\DocBuilderIterator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */