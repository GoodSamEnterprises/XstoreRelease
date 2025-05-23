/*     */ package dtv.docbuilding.xml;
/*     */ 
/*     */ import dtv.docbuilding.DocBuilderRow;
/*     */ import dtv.docbuilding.DocBuilderRowSet;
/*     */ import dtv.docbuilding.DocSectionRef;
/*     */ import dtv.docbuilding.IDocBuilderField;
/*     */ import dtv.docbuilding.IDocBuilderIterator;
/*     */ import dtv.docbuilding.IDocBuilderIteratorMember;
/*     */ import dtv.docbuilding.IDocBuilderSectionMember;
/*     */ import dtv.docbuilding.IDocElementFactory;
/*     */ import dtv.docbuilding.conditions.IDocBuilderCondition;
/*     */ import dtv.docbuilding.config.DocBuilderCallConfig;
/*     */ import dtv.docbuilding.config.DocBuilderConditionConfig;
/*     */ import dtv.docbuilding.config.DocBuilderIteratorConfig;
/*     */ import dtv.docbuilding.config.DocBuilderSectionRefConfig;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.StringConfig;
/*     */ import java.util.ArrayDeque;
/*     */ import java.util.Deque;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DocXmlContentHandler
/*     */   implements IDocXmlContentHandler
/*     */ {
/*  27 */   private final Deque<IDocBuilderIterator> _iterators = new ArrayDeque<>();
/*  28 */   private final Deque<String> _customElementNames = new ArrayDeque<>();
/*     */   
/*  30 */   private IDocXmlParserCallback _callback = null;
/*  31 */   private IDocXmlFieldFactory _fieldFactory = null;
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleCall(DocXmlInstruction argInstr, Object argSource, IDocElementFactory argFactory) {
/*  36 */     if (argInstr.getTarget().startsWith("_")) {
/*  37 */       handleCallEnd(argInstr);
/*     */     } else {
/*     */       
/*  40 */       handleCallStart(argInstr, argSource, argFactory);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleCondition(DocXmlInstruction argInstr, Object argSource, IDocElementFactory argFactory) {
/*  47 */     if (argInstr.getTarget().startsWith("_")) {
/*  48 */       handleConditionEnd(argInstr);
/*     */     } else {
/*     */       
/*  51 */       handleConditionStart(argInstr, argSource, argFactory);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleElement(IDocXmlElement argElem, Object argSource, IDocElementFactory argFactory) {
/*  58 */     if (argElem instanceof DocXmlRootElement) {
/*     */       
/*  60 */       parseChildren(argElem, argSource, argFactory);
/*     */     }
/*     */     else {
/*     */       
/*  64 */       DocBuilderRow elemRow = handleElementImpl(argElem, true);
/*     */ 
/*     */       
/*  67 */       parseChildren(argElem, argSource, argFactory);
/*     */       
/*  69 */       if (StringUtils.isEmpty(argElem.getText())) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  74 */         if (!argElem.getChildren().isEmpty()) {
/*  75 */           elemRow = new DocBuilderRow();
/*  76 */           addMember((IDocBuilderSectionMember)elemRow);
/*     */         } 
/*     */         
/*  79 */         IDocXmlElement elem = new DocXmlElement(argElem.getName(), argElem.getNamespace());
/*  80 */         elemRow.addField(getFieldFactory().createElementCloseField(elem, true));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleElement(DocXmlInstruction argInstr, Object argSource, IDocElementFactory argFactory) {
/*  88 */     if (argInstr.getTarget().startsWith("_")) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  96 */       String closeTagName = this._customElementNames.pop();
/*     */ 
/*     */       
/*  99 */       DocBuilderRow row = new DocBuilderRow();
/* 100 */       IDocXmlElement elem = new DocXmlElement(closeTagName);
/* 101 */       row.addField(getFieldFactory().createElementCloseField(elem, false));
/*     */       
/* 103 */       addMember((IDocBuilderSectionMember)row);
/*     */     }
/*     */     else {
/*     */       
/* 107 */       String elemName = argInstr.getAttributeValue("name");
/* 108 */       String elemText = argInstr.getAttributeValue("value");
/* 109 */       boolean isTextElem = !StringUtils.isEmpty(elemText);
/*     */       
/* 111 */       DocXmlElement element = new DocXmlElement(elemName);
/* 112 */       element.setText(elemText);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 119 */       handleElementImpl(element, false);
/*     */       
/* 121 */       if (!isTextElem)
/*     */       {
/*     */         
/* 124 */         this._customElementNames.push(elemName);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleIterator(DocXmlInstruction argInstr, Object argSource, IDocElementFactory argFactory) {
/* 132 */     if (argInstr.getTarget().startsWith("_")) {
/* 133 */       handleIteratorEnd(argInstr);
/*     */     } else {
/*     */       
/* 136 */       handleIteratorStart(argInstr, argSource, argFactory);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleLiteral(DocXmlInstruction argInstr, Object argSource, IDocElementFactory argFactory) {
/* 143 */     String content = argInstr.getAttributeValue("value");
/*     */     
/* 145 */     DocBuilderRow row = new DocBuilderRow();
/* 146 */     IDocBuilderField literalField = getFieldFactory().createLiteralField(content);
/*     */     
/* 148 */     row.addField(literalField);
/* 149 */     addMember((IDocBuilderSectionMember)row);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleSectionRef(DocXmlInstruction argInstr, Object argSource, IDocElementFactory argFactory) {
/* 155 */     String refName = argInstr.getAttributeValue("name");
/*     */     
/* 157 */     DocBuilderSectionRefConfig cfg = new DocBuilderSectionRefConfig();
/* 158 */     cfg.setSectionName(refName);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 163 */     for (String attrName : argInstr.getAttributeNames()) {
/* 164 */       if (!"name".equalsIgnoreCase(attrName)) {
/* 165 */         cfg.setParameter(attrName, argInstr.getAttributeValue(attrName));
/*     */       }
/*     */     } 
/*     */     
/* 169 */     DocSectionRef sectionRef = cfg.makeSectionRef(getCallback().getFacilities().getSectionMap());
/* 170 */     sectionRef.setSourceDescription(getCallback().getFacilities().getSourceDescription());
/*     */     
/* 172 */     addMember((IDocBuilderSectionMember)sectionRef);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize(IDocXmlParserCallback argCallback) {
/* 178 */     this._callback = argCallback;
/* 179 */     this._fieldFactory = createFieldFactory(argCallback.getFacilities());
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
/*     */   protected void addMember(IDocBuilderSectionMember argMember) {
/* 193 */     if (argMember instanceof IDocBuilderIteratorMember && !this._iterators.isEmpty()) {
/*     */ 
/*     */       
/* 196 */       ((IDocBuilderIterator)this._iterators.peek()).addMember((IDocBuilderIteratorMember)argMember);
/*     */     }
/*     */     else {
/*     */       
/* 200 */       getCallback().addRootMember(argMember);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 205 */     if (argMember instanceof IDocBuilderIterator) {
/* 206 */       this._iterators.push((IDocBuilderIterator)argMember);
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
/*     */ 
/*     */ 
/*     */   
/*     */   protected void applyAttributesToConfig(DocXmlInstruction argInstr, IConfigObject argConfig, IDocElementFactory argFactory) {
/* 222 */     for (String attrName : argInstr.getAttributeNames()) {
/* 223 */       String attrValue = argFactory.getParameterMap().resolveParamValue(argInstr.getAttributeValue(attrName));
/* 224 */       argConfig.setConfigObject(attrName, (IConfigObject)new StringConfig(attrValue));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IDocXmlFieldFactory createFieldFactory(DocXmlFacilities argFacilities) {
/* 235 */     IDocXmlFieldFactory factory = new DocXmlFieldFactory();
/* 236 */     factory.initialize(argFacilities);
/*     */     
/* 238 */     return factory;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void endIterationScope() {
/* 245 */     this._iterators.poll();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final IDocXmlParserCallback getCallback() {
/* 255 */     return this._callback;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IDocXmlFieldFactory getFieldFactory() {
/* 265 */     return this._fieldFactory;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void handleCallEnd(DocXmlInstruction argInstr) {
/* 273 */     endIterationScope();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void handleCallStart(DocXmlInstruction argInstr, Object argSource, IDocElementFactory argFactory) {
/* 284 */     DocBuilderCallConfig cfg = new DocBuilderCallConfig();
/*     */ 
/*     */ 
/*     */     
/* 288 */     applyAttributesToConfig(argInstr, (IConfigObject)cfg, argFactory);
/*     */ 
/*     */     
/* 291 */     IDocBuilderIterator call = (IDocBuilderIterator)cfg.makeCall(argFactory, getCallback().getFacilities().getSectionMap(), 
/* 292 */         getCallback().getFacilities().getFormatterMap());
/*     */     
/* 294 */     call.setSourceDescription(getCallback().getFacilities().getSourceDescription());
/*     */ 
/*     */ 
/*     */     
/* 298 */     addMember((IDocBuilderSectionMember)call);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void handleConditionEnd(DocXmlInstruction argInstr) {
/* 309 */     endIterationScope();
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
/*     */   protected void handleConditionStart(DocXmlInstruction argInstr, Object argSource, IDocElementFactory argFactory) {
/* 329 */     DocBuilderConditionConfig cfg = new DocBuilderConditionConfig();
/*     */ 
/*     */ 
/*     */     
/* 333 */     applyAttributesToConfig(argInstr, (IConfigObject)cfg, argFactory);
/*     */     
/* 335 */     IDocBuilderCondition condition = cfg.makeCondition();
/* 336 */     condition.setSourceDescription(getCallback().getFacilities().getSourceDescription());
/*     */     
/* 338 */     DocBuilderRowSet rowSet = new DocBuilderRowSet();
/* 339 */     rowSet.addCondition(condition);
/* 340 */     rowSet.setSourceDescription(getCallback().getFacilities().getSourceDescription());
/*     */ 
/*     */ 
/*     */     
/* 344 */     addMember((IDocBuilderSectionMember)rowSet);
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
/*     */   protected DocBuilderRow handleElementImpl(IDocXmlElement argElem, boolean argNameIsLiteral) {
/* 361 */     DocBuilderRow elemRow = new DocBuilderRow();
/*     */ 
/*     */ 
/*     */     
/* 365 */     IDocBuilderField elemField = StringUtils.isEmpty(argElem.getText()) ? getFieldFactory().createElementOpenField(argElem, argNameIsLiteral) : getFieldFactory().createElementTextField(argElem, argNameIsLiteral);
/*     */     
/* 367 */     elemRow.addField(elemField);
/*     */ 
/*     */     
/* 370 */     addMember((IDocBuilderSectionMember)elemRow);
/*     */     
/* 372 */     return elemRow;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void handleIteratorEnd(DocXmlInstruction argInstr) {
/* 380 */     endIterationScope();
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
/*     */   protected void handleIteratorStart(DocXmlInstruction argInstr, Object argSource, IDocElementFactory argFactory) {
/* 393 */     DocBuilderIteratorConfig cfg = new DocBuilderIteratorConfig();
/*     */ 
/*     */ 
/*     */     
/* 397 */     applyAttributesToConfig(argInstr, (IConfigObject)cfg, argFactory);
/*     */ 
/*     */     
/* 400 */     IDocBuilderIterator iterator = (IDocBuilderIterator)cfg.makeIterator(argFactory, getCallback().getFacilities().getSectionMap(), 
/* 401 */         getCallback().getFacilities().getFormatterMap());
/*     */     
/* 403 */     iterator.setSourceDescription(getCallback().getFacilities().getSourceDescription());
/*     */ 
/*     */ 
/*     */     
/* 407 */     addMember((IDocBuilderSectionMember)iterator);
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
/*     */   protected void parseChildren(IDocXmlElement argElem, Object argSource, IDocElementFactory argFactory) {
/* 420 */     for (IDocXmlSimpleElement content : argElem.getChildren())
/* 421 */       getCallback().parse(content, argSource, argFactory); 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\xml\DocXmlContentHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */