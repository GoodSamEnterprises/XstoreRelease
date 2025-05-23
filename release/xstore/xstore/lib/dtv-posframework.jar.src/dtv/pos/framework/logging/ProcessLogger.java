/*     */ package dtv.pos.framework.logging;
/*     */ 
/*     */ import dtv.pos.iframework.op.IOpChain;
/*     */ import dtv.pos.iframework.op.IOperation;
/*     */ import dtv.pos.iframework.op.TraversalStrategyType;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.IHasSourceDescription;
/*     */ import org.apache.log4j.Level;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.apache.log4j.Priority;
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
/*     */ public class ProcessLogger
/*     */ {
/*  25 */   private static final Logger _eventLogger = Logger.getLogger("XSTORE_FLOW");
/*  26 */   private static final String _flowBoundary = StringUtils.fill("-", 40);
/*  27 */   private static final String _eventBoundary = StringUtils.fill("*", 60);
/*     */   
/*     */   private static final String _traversalTypeChanged = " Traversal Type Changed -> ";
/*     */   
/*     */   private final Logger _logger;
/*     */   private final boolean _debugLogging;
/*     */   
/*     */   public static void logSignificantEvent(String argMessage) {
/*  35 */     _eventLogger.info(_eventBoundary);
/*  36 */     _eventLogger.info("**" + StringUtils.center(argMessage, 56) + "**");
/*  37 */     _eventLogger.info(_eventBoundary);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  43 */   private TraversalStrategyType _traversalType = null;
/*  44 */   private int _processDepth = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ProcessLogger() {
/*  51 */     this._logger = Logger.getLogger("OPCHAIN_FLOW");
/*  52 */     this._debugLogging = this._logger.isDebugEnabled();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearProcessDepth() {
/*  60 */     this._processDepth = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void debug(IOperation argOp, TraversalStrategyType argTraversalType, boolean argApplicable) {
/*  71 */     log(argOp, argTraversalType, argApplicable, Level.DEBUG);
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
/*     */   public void debug(String argOpDetailQualifier) {
/*  84 */     log(argOpDetailQualifier, Level.DEBUG);
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
/*     */   public void debug(String argOpDetailType, Object argOpDetailId, IHasSourceDescription argOpDetailSource, String argPrefix, String argSuffix) {
/* 105 */     log(argOpDetailType, argOpDetailId, argOpDetailSource, argPrefix, argSuffix, Level.DEBUG);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void decrementProcessDepth() {
/* 113 */     if (this._processDepth > 0) {
/* 114 */       this._processDepth--;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void incrementProcessDepth() {
/* 123 */     this._processDepth++;
/* 124 */     if (this._processDepth > 10) {
/* 125 */       this._processDepth = 0;
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
/*     */   public void info(IOperation argOp, TraversalStrategyType argTraversalType, boolean argApplicable) {
/* 137 */     log(argOp, argTraversalType, argApplicable, Level.INFO);
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
/*     */   public void info(String argOpDetailQualifier) {
/* 150 */     log(argOpDetailQualifier, Level.INFO);
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
/*     */   public void info(String argOpDetailType, Object argOpDetailId, IHasSourceDescription argOpDetailSource, String argPrefix, String argSuffix) {
/* 171 */     log(argOpDetailType, argOpDetailId, argOpDetailSource, argPrefix, argSuffix, Level.INFO);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void warn(IOperation argOp, TraversalStrategyType argTraversalType, boolean argApplicable) {
/* 182 */     log(argOp, argTraversalType, argApplicable, Level.WARN);
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
/*     */   public void warn(String argOpDetailQualifier) {
/* 195 */     log(argOpDetailQualifier, Level.WARN);
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
/*     */   public void warn(String argOpDetailType, Object argOpDetailId, IHasSourceDescription argOpDetailSource, String argPrefix, String argSuffix) {
/* 216 */     log(argOpDetailType, argOpDetailId, argOpDetailSource, argPrefix, argSuffix, Level.WARN);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String getIndent(int argProcessDepth) {
/* 226 */     return StringUtils.fill(" ", argProcessDepth * 4);
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
/*     */   private String getSourceInfoDivider(int argMessageLength) {
/* 238 */     int sourceGapLength = 100 - argMessageLength;
/* 239 */     String divider = (sourceGapLength > 0) ? StringUtils.fill(" ", sourceGapLength) : "";
/* 240 */     return divider + "@@ ";
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
/*     */   private void log(IOperation argOp, TraversalStrategyType argTraversalType, boolean argApplicable, Level argLevel) {
/* 253 */     IOpChain chain = (argOp instanceof IOpChain) ? (IOpChain)argOp : null;
/* 254 */     boolean isChain = (chain != null);
/*     */     
/* 256 */     String type = argOp.getOpType();
/* 257 */     String id = argOp.getLogId();
/* 258 */     String prefix = argApplicable ? "+" : "-";
/*     */ 
/*     */     
/* 261 */     String suffix = (isChain && chain.getRollbackLevel() > 0) ? ("[<<" + chain.getRollbackLevel() + "]") : ((!isChain && argOp.hasBreakPoint()) ? "[<*]" : "");
/*     */     
/* 263 */     String sourceInfo = "";
/* 264 */     String sourceDivider = "";
/*     */     
/* 266 */     if (this._debugLogging) {
/* 267 */       sourceInfo = argOp.getSourceDescription();
/* 268 */       sourceDivider = getSourceInfoDivider(type.length() + id.length() + prefix.length() + suffix.length());
/*     */     } 
/*     */     
/* 271 */     if (argTraversalType != this._traversalType) {
/* 272 */       log(argTraversalType, argLevel);
/* 273 */       this._traversalType = argTraversalType;
/*     */     } 
/*     */     
/* 276 */     String opState = (argOp.getOpState() == null) ? "" : ("[state = " + argOp.getOpState() + "] ");
/*     */     
/* 278 */     String indent = getIndent(this._processDepth);
/*     */     
/* 280 */     if (isChain) {
/* 281 */       StringBuilder flowBoundryString = new StringBuilder(indent.length() + _flowBoundary.length());
/* 282 */       flowBoundryString.append(indent).append(_flowBoundary);
/* 283 */       this._logger.log((Priority)argLevel, flowBoundryString.toString());
/*     */     } 
/*     */     
/* 286 */     StringBuilder logString = new StringBuilder(256);
/* 287 */     logString.append(indent).append(this._traversalType.getLogPrefix()).append(" ");
/* 288 */     logString.append(prefix).append("[").append(type).append("] ");
/* 289 */     logString.append(id).append(" ").append(opState).append(suffix).append(sourceDivider).append(sourceInfo);
/* 290 */     this._logger.log((Priority)argLevel, logString.toString());
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
/*     */   private void log(String argOpDetailQualifier, Level argLevel) {
/* 304 */     String indent = getIndent(this._processDepth + 4);
/* 305 */     StringBuilder logStringBuilder = new StringBuilder(indent.length() + argOpDetailQualifier.length());
/* 306 */     logStringBuilder.append(indent).append(argOpDetailQualifier);
/* 307 */     this._logger.log((Priority)argLevel, logStringBuilder.toString());
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
/*     */   
/*     */   private void log(String argOpDetailType, Object argOpDetailId, IHasSourceDescription argOpDetailSource, String argPrefix, String argSuffix, Level argLevel) {
/* 329 */     String detailType = (argOpDetailType == null) ? "" : argOpDetailType;
/* 330 */     String detailId = (argOpDetailId == null) ? "" : argOpDetailId.toString();
/* 331 */     String prefix = (argPrefix == null) ? " " : argPrefix;
/* 332 */     String suffix = (argSuffix == null) ? "" : argSuffix;
/*     */     
/* 334 */     String sourceInfo = "";
/* 335 */     String sourceDivider = "";
/*     */     
/* 337 */     if (this._debugLogging && argOpDetailSource != null) {
/* 338 */       sourceInfo = argOpDetailSource.getSourceDescription();
/*     */       
/* 340 */       sourceDivider = getSourceInfoDivider(prefix.length() + detailType.length() + detailId.length() + suffix.length());
/*     */     } 
/* 342 */     StringBuilder logString = new StringBuilder(256);
/* 343 */     logString.append(getIndent(this._processDepth + 2)).append(prefix).append("[").append(detailType).append("] ");
/* 344 */     logString.append(detailId).append(suffix).append(sourceDivider).append(sourceInfo);
/* 345 */     this._logger.log((Priority)argLevel, logString.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void log(TraversalStrategyType argTraversalType, Level argLevel) {
/* 355 */     String indent = getIndent(this._processDepth);
/* 356 */     StringBuilder flowBoundryString = new StringBuilder(indent.length() + _flowBoundary.length());
/* 357 */     flowBoundryString.append(indent).append(_flowBoundary);
/* 358 */     this._logger.log((Priority)argLevel, flowBoundryString.toString());
/*     */     
/* 360 */     StringBuilder logString = new StringBuilder(indent.length() + " Traversal Type Changed -> ".length() + argTraversalType.name().length());
/* 361 */     logString.append(indent).append(" Traversal Type Changed -> ").append(argTraversalType.name());
/* 362 */     this._logger.log((Priority)argLevel, logString.toString());
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\logging\ProcessLogger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */