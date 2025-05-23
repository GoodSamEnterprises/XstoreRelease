/*     */ package dtv.pos.framework.op.xflow;
/*     */ 
/*     */ import dtv.pos.iframework.op.IOperation;
/*     */ import dtv.ui.IUIResourceManager;
/*     */ import dtv.ui.UIResourceManager;
/*     */ import dtv.util.ImageUtils;
/*     */ import dtv.util.StringUtils;
/*     */ import java.awt.Dimension;
/*     */ import java.net.URL;
/*     */ import javax.swing.ImageIcon;
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
/*     */ public class StubHtmlMessage
/*     */ {
/*  28 */   private static final Logger logger_ = Logger.getLogger(StubHtmlMessage.class);
/*     */   private static final String WARNING_IMAGE_NAME = "classpath:graphics/xflow/exclaim.gif";
/*     */   private static final String WARNING_MSG = "WARNING: <u>Op not yet implemented</u>";
/*  31 */   private static final IUIResourceManager UIRM = UIResourceManager.getInstance();
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String SIMULATION_MSG = "This screen is provided for simulation purposes only. See below for a description of this operation and function keys to simulate its actions.";
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String MESSAGE_TEMPLATE = "<font face='Dialog' size='5'><p align='center'><img src='%s' width='%s' height='%s'></img>&nbsp;%s&nbsp;<img src='%s' width='%s' height='%s'></img></p><p align='center'><font face='Dialog' size='4'>%s</font></p></font><hr><br><font face='Dialog' size='4'><p align='center'><img src='%s' width='%s' height='%s'></img></p><p align='center'>%s</p></font>";
/*     */ 
/*     */ 
/*     */   
/*     */   private final IOperation stubbedOp_;
/*     */ 
/*     */ 
/*     */   
/*     */   private final StubPlaceholderOp placeholderOp_;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StubHtmlMessage(IOperation argStubbedOp, StubPlaceholderOp argPlaceholder) {
/*  53 */     this.stubbedOp_ = argStubbedOp;
/*  54 */     this.placeholderOp_ = argPlaceholder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getHtmlMessage() {
/*     */     try {
/*  64 */       Dimension warningIconDimension = getImageDimension("classpath:graphics/xflow/exclaim.gif");
/*  65 */       Dimension imageDimension = getImageDimension(getOpType().getIconName());
/*     */ 
/*     */       
/*  68 */       String htmlMessage = String.format("<font face='Dialog' size='5'><p align='center'><img src='%s' width='%s' height='%s'></img>&nbsp;%s&nbsp;<img src='%s' width='%s' height='%s'></img></p><p align='center'><font face='Dialog' size='4'>%s</font></p></font><hr><br><font face='Dialog' size='4'><p align='center'><img src='%s' width='%s' height='%s'></img></p><p align='center'>%s</p></font>", new Object[] { getWarningIconPath(), Integer.valueOf(warningIconDimension.width), 
/*  69 */             Integer.valueOf(warningIconDimension.height), getWarningMessage(), getWarningIconPath(), 
/*  70 */             Integer.valueOf(warningIconDimension.width), Integer.valueOf(warningIconDimension.height), 
/*  71 */             getSimulationMessage(), getOpTypeIconPath(), Integer.valueOf(imageDimension.width), 
/*  72 */             Integer.valueOf(imageDimension.height), getOpDescription() });
/*  73 */       return htmlMessage;
/*     */     }
/*  75 */     catch (Exception ex) {
/*  76 */       logger_.warn("An exeption occurred while genered the HTML for stubbed op " + 
/*  77 */           getStubbedOp().getClass().getName(), ex);
/*  78 */       return getOpDescription();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StubPlaceholderOp getPlaceholderOp() {
/*  89 */     return this.placeholderOp_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOperation getStubbedOp() {
/*  98 */     return this.stubbedOp_;
/*     */   }
/*     */   
/*     */   protected StubbedOperation getAnnotation() {
/* 102 */     return getStubbedOp().getClass().<StubbedOperation>getAnnotation(StubbedOperation.class);
/*     */   }
/*     */   
/*     */   protected Dimension getImageDimension(String argImageName) {
/* 106 */     ImageIcon image = UIRM.getImageIcon(argImageName);
/* 107 */     return new Dimension(image.getIconWidth(), image.getIconHeight());
/*     */   }
/*     */   
/*     */   protected URL getImageUrl(String argImageName) {
/* 111 */     URL imageUrl = ImageUtils.getImageURL(argImageName);
/* 112 */     if (imageUrl == null) {
/* 113 */       logger_.warn("Image [" + argImageName + "] was not found on the classpath.");
/* 114 */       return null;
/*     */     } 
/*     */     
/* 117 */     return imageUrl;
/*     */   }
/*     */   
/*     */   protected String getOpDescription() {
/* 121 */     String description = getAnnotation().description();
/* 122 */     if (StringUtils.isEmpty(description)) {
/* 123 */       String value = getPlaceholderOp().getParameter("Description");
/* 124 */       if (value != null) {
/* 125 */         description = value.toString();
/*     */       }
/*     */     } 
/* 128 */     return description;
/*     */   }
/*     */   
/*     */   protected OpType getOpType() {
/* 132 */     return getAnnotation().opType();
/*     */   }
/*     */   
/*     */   protected String getOpTypeIconPath() {
/* 136 */     return getImageUrl(getOpType().getIconName()).toString();
/*     */   }
/*     */   
/*     */   protected String getSimulationMessage() {
/* 140 */     return "This screen is provided for simulation purposes only. See below for a description of this operation and function keys to simulate its actions.";
/*     */   }
/*     */   
/*     */   protected String getWarningIconPath() {
/* 144 */     return getImageUrl("classpath:graphics/xflow/exclaim.gif").toString();
/*     */   }
/*     */   
/*     */   protected String getWarningMessage() {
/* 148 */     return "WARNING: <u>Op not yet implemented</u>";
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\xflow\StubHtmlMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */