/*     */ package dtv.docbuilding.trace;
/*     */ 
/*     */ import dtv.util.CompositeObject;
/*     */ import dtv.util.FileUtils;
/*     */ import java.io.File;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.StringWriter;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import java.util.Stack;
/*     */ import java.util.TreeSet;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StringBufferTracer
/*     */   implements ITracer
/*     */ {
/*  23 */   private static final Logger logger_ = Logger.getLogger(StringBufferTracer.class);
/*     */ 
/*     */   
/*  26 */   private StringWriter writer_ = null;
/*  27 */   private PrintWriter out_ = null;
/*     */   private boolean inGraph_ = false;
/*  29 */   private final Set<String> nodes_ = new HashSet<>();
/*     */   
/*  31 */   private final Set<String> edges_ = new TreeSet<>();
/*     */   
/*  33 */   private final Stack<String> nodeStack_ = new Stack<>();
/*     */ 
/*     */   
/*     */   public StringBufferTracer() {
/*  37 */     open();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void attr(String argAttribute) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void endGraph() {
/*  48 */     if (this.inGraph_) {
/*  49 */       for (String element : this.nodes_) {
/*  50 */         this.out_.write("\"" + element + "\" [color=\"0.650 0.200 1.000\"];\n");
/*     */       }
/*  52 */       this.out_.write("}\n");
/*  53 */       this.inGraph_ = false;
/*     */     } 
/*  55 */     this.nodes_.clear();
/*  56 */     this.edges_.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void endNode(String argNode) {
/*  62 */     logger_.debug("-" + argNode);
/*  63 */     String prevParent = this.nodeStack_.pop();
/*  64 */     if (!prevParent.equals(argNode)) {
/*  65 */       warn("unexpected pop [" + argNode + "]");
/*     */     }
/*     */   }
/*     */   
/*     */   public File export(File argDir, CompositeObject type, String argFormat) {
/*  70 */     endGraph();
/*     */     
/*     */     try {
/*  73 */       File dotFile = File.createTempFile(type.toString(), ".dot", argDir);
/*  74 */       FileUtils.writeFile(dotFile, this.writer_.toString());
/*     */       
/*  76 */       File outFile = File.createTempFile(type.toString(), "." + argFormat, argDir);
/*  77 */       String[] dotArgs = { "dot", "-T", argFormat, "-o", outFile.getAbsolutePath(), dotFile.getAbsolutePath() };
/*  78 */       Runtime.getRuntime().exec(dotArgs);
/*     */ 
/*     */ 
/*     */       
/*  82 */       return outFile;
/*     */     }
/*  84 */     catch (Exception ex) {
/*  85 */       logger_.error("CAUGHT EXCEPTION", ex);
/*  86 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void startGraph(String argGraph) {
/*  91 */     open();
/*     */     
/*  93 */     this.out_.write("digraph " + argGraph + " {\n");
/*  94 */     this.out_.write("pack=true; ratio=auto; rankdir=\"LR\";");
/*     */     
/*  96 */     this.out_.write("  concentrate=true;\n");
/*  97 */     this.out_.write("  fontsize = 12;\n");
/*  98 */     this.out_.write("  node [style=filled];\n");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String startNode(String argNode) {
/* 104 */     logger_.debug("+" + argNode);
/* 105 */     if (!this.nodeStack_.isEmpty()) {
/* 106 */       addEdge("  \"" + (String)this.nodeStack_.peek() + "\" -> \"" + argNode + "\";");
/*     */     }
/* 108 */     this.nodes_.add(argNode);
/* 109 */     this.nodeStack_.push(argNode);
/* 110 */     return argNode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String startNode(String argNode, int argInstanceId) {
/* 116 */     return startNode(argNode + "@" + Integer.toHexString(argInstanceId));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void warn(String argString) {
/* 122 */     logger_.warn(argString);
/*     */   }
/*     */   
/*     */   private void addEdge(String argEdge) {
/* 126 */     if (this.edges_.add(argEdge)) {
/* 127 */       this.out_.write(argEdge + "\n");
/*     */     }
/*     */   }
/*     */   
/*     */   private void open() {
/* 132 */     this.writer_ = new StringWriter();
/* 133 */     this.out_ = new PrintWriter(this.writer_);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 143 */     this.inGraph_ = true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\trace\StringBufferTracer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */