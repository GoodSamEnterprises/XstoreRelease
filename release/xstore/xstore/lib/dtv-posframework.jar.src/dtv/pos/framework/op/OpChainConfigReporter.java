/*     */ package dtv.pos.framework.op;
/*     */ 
/*     */ import com.micros.xstore.config.impl.LocatableObject;
/*     */ import com.micros.xstore.config.opchain.OpChainChildTypeEnum;
/*     */ import com.micros.xstore.config.opchain.OpChainRouteType;
/*     */ import com.micros.xstore.config.opchain.OpChainType;
/*     */ import com.micros.xstore.config.opchain.OperationType;
/*     */ import dtv.jmx.HtmlReportHelper;
/*     */ import dtv.pos.common.OpChainKey;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.xml.bind.JAXBElement;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OpChainConfigReporter
/*     */ {
/*     */   private final Map<OpChainKey, OpChainType> chainMap_;
/*     */   
/*     */   public OpChainConfigReporter(Map<OpChainKey, OpChainType> map) {
/*  27 */     this.chainMap_ = map;
/*     */   }
/*     */   
/*     */   public String getReport() {
/*  31 */     HtmlReportHelper html = new HtmlReportHelper();
/*  32 */     html.append("\n<table width=\"100%\" style=\"font-family: Lucida\">\n");
/*  33 */     html.createTableHeader(new String[] { "Chain", "source" });
/*     */     
/*  35 */     OpChainKey[] keys = (OpChainKey[])this.chainMap_.keySet().toArray((Object[])new OpChainKey[0]);
/*     */     
/*  37 */     Arrays.sort((Object[])keys);
/*     */     
/*  39 */     for (OpChainKey key : keys) {
/*  40 */       appendChain(html, this.chainMap_.get(key), 0);
/*     */     }
/*     */     
/*  43 */     html.append("</table>\n");
/*  44 */     return html.toString();
/*     */   }
/*     */   
/*     */   private void appendChain(HtmlReportHelper html, OpChainType argConfig, int level) {
/*  48 */     html.createTableRow(new String[] {
/*     */           
/*  50 */           StringUtils.fill("&#x2514", level) + "<a name=\"argConfig.getOpChainKey().getName()\">" + argConfig
/*  51 */           .getName() + "</a>", "", argConfig.getSourceDescription() }"#F0F0FF");
/*     */ 
/*     */     
/*  54 */     List<JAXBElement<? extends LocatableObject>> content = argConfig.getOpChainReferencesAndOpChainLinksAndOperations();
/*  55 */     for (JAXBElement<? extends LocatableObject> element : content) {
/*  56 */       LocatableObject opConfig = element.getValue();
/*  57 */       OpChainChildTypeEnum opType = OpChainChildTypeEnum.fromValue(element.getName().getLocalPart());
/*     */       
/*  59 */       switch (opType) {
/*     */         case OP_CHAIN_LINK:
/*  61 */           appendChainRoute(html, (OpChainRouteType)opConfig, true);
/*     */           continue;
/*     */         
/*     */         case OP_CHAIN_REFERENCE:
/*  65 */           appendChainRoute(html, (OpChainRouteType)opConfig, false);
/*     */           continue;
/*     */         
/*     */         case OPERATION:
/*     */         case OP:
/*     */         case VALIDATION_OP:
/*     */         case PROMPT_OP:
/*     */         case WORKER_OP:
/*  73 */           appendOperation(html, (OperationType)opConfig);
/*     */           continue;
/*     */       } 
/*     */       
/*  77 */       appendUnknown(html, opConfig);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void appendChainRoute(HtmlReportHelper html, OpChainRouteType argConfig, boolean argLink) {
/*  84 */     if (argLink) {
/*  85 */       html.createTableRow(new String[] { "::link", "<a href=\"#" + argConfig
/*     */             
/*  87 */             .getChainKey() + "\">" + argConfig.getChainKey() + "</a>" }, "#FFFFFF");
/*     */     }
/*     */     else {
/*     */       
/*  91 */       html.createTableRow(new String[] { "::reference", argConfig.getChainKey().toString() }, "#FFFFFF");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void appendOperation(HtmlReportHelper html, OperationType argConfig) {
/*     */     String name;
/*     */     try {
/*  99 */       name = (argConfig.getClazz() != null) ? argConfig.getClazz().getName() : "";
/*     */     }
/* 101 */     catch (Exception ex) {
/*     */       
/* 103 */       name = ex.getMessage();
/*     */     } 
/*     */     
/* 106 */     html.createTableRow(new String[] { "::operation", name }, "#FFFFFF");
/*     */   }
/*     */   
/*     */   private void appendUnknown(HtmlReportHelper html, LocatableObject argO) {}
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\OpChainConfigReporter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */