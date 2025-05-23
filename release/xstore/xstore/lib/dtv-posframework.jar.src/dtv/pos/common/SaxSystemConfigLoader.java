/*     */ package dtv.pos.common;
/*     */ 
/*     */ import dtv.util.config.ConfigException;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.StringConfig;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.URL;
/*     */ import java.util.LinkedList;
/*     */ import javax.xml.parsers.SAXParser;
/*     */ import javax.xml.parsers.SAXParserFactory;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.xml.sax.Attributes;
/*     */ import org.xml.sax.Locator;
/*     */ import org.xml.sax.SAXException;
/*     */ import org.xml.sax.helpers.DefaultHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SaxSystemConfigLoader
/*     */   extends DefaultHandler
/*     */ {
/*  29 */   private static final Logger logger_ = Logger.getLogger(SaxSystemConfigLoader.class);
/*     */   
/*  31 */   private final StringBuilder characters_ = new StringBuilder();
/*     */   private Locator locator_;
/*  33 */   private final LinkedList<IConfigObject> parentStack_ = new LinkedList<>();
/*  34 */   private final LinkedList<String> xpathStack_ = new LinkedList<>();
/*     */   private SystemConfigHelper callback_;
/*     */   private String currentFilePath_;
/*     */   private final boolean _preserveCaseSensitiveConfigPathKeys;
/*     */   
/*     */   public SaxSystemConfigLoader() {
/*  40 */     this(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public SaxSystemConfigLoader(boolean argPreserveCaseSensitiveConfigPathKeys) {
/*  45 */     this._preserveCaseSensitiveConfigPathKeys = argPreserveCaseSensitiveConfigPathKeys;
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
/*     */   public void characters(char[] argCharacters, int argStart, int argLength) throws SAXException {
/*  79 */     this.characters_.append(argCharacters, argStart, argLength);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void endElement(String argNamespaceURI, String argLocalName, String qName) throws SAXException {
/* 107 */     IConfigObject configObject = popParent();
/*     */     try {
/* 109 */       String xpath = popXpath();
/* 110 */       if (configObject != null) {
/* 111 */         configObject.setValue(this.characters_.toString());
/* 112 */         this.callback_.addLeaf(xpath, configObject);
/*     */       } 
/* 114 */       this.characters_.setLength(0);
/*     */       
/* 116 */       IConfigObject parent = peekParent();
/* 117 */       if (parent != null) {
/* 118 */         parent.setConfigObject(qName, configObject);
/*     */       
/*     */       }
/*     */     }
/* 122 */     catch (Exception ex) {
/* 123 */       logger_.error("CAUGHT EXCEPTION", ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void loadDocument(SystemConfigHelper argCallback, URL argCurrentFile, InputStream argInputStream) throws IOException {
/* 129 */     this.callback_ = argCallback;
/* 130 */     this.currentFilePath_ = argCurrentFile.toExternalForm();
/*     */ 
/*     */     
/* 133 */     SAXParserFactory factory = SAXParserFactory.newInstance();
/* 134 */     factory.setValidating(false);
/*     */ 
/*     */     
/* 137 */     SAXParser parser = null;
/*     */     try {
/* 139 */       parser = factory.newSAXParser();
/* 140 */       parser.parse(argInputStream, this);
/*     */     }
/* 142 */     catch (ConfigException ex) {
/* 143 */       ex.setConfigLocationDescription(this.currentFilePath_ + ":" + this.locator_.getLineNumber());
/* 144 */       throw ex;
/*     */     }
/* 146 */     catch (RuntimeException ex) {
/* 147 */       throw ex;
/*     */     }
/* 149 */     catch (IOException ex) {
/* 150 */       throw ex;
/*     */     }
/* 152 */     catch (Exception ex) {
/* 153 */       throw new RuntimeException(ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentLocator(Locator argLocator) {
/* 164 */     this.locator_ = argLocator;
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
/*     */   public void startElement(String argNamespaceURI, String argLocalName, String qName, Attributes argAttributes) throws SAXException {
/* 224 */     String dtype = getDtype(qName, argAttributes);
/*     */     
/* 226 */     IConfigObject configObject = this.callback_.getConfigObject(qName, dtype, this.currentFilePath_ + ":" + this.locator_
/* 227 */         .getLineNumber());
/* 228 */     if (configObject != null) {
/* 229 */       configObject.setSourceInfo(this.currentFilePath_, this.locator_.getLineNumber());
/*     */       
/* 231 */       for (int i = 0; i < argAttributes.getLength(); i++) {
/* 232 */         String attName = argAttributes.getQName(i);
/* 233 */         if (attName.indexOf(':') <= -1)
/*     */         {
/*     */           
/* 236 */           if (!"dtype".equals(attName))
/*     */           {
/*     */             
/* 239 */             configObject.setConfigObject(attName, (IConfigObject)new StringConfig(argAttributes.getValue(i))); } 
/*     */         }
/*     */       } 
/*     */     } 
/* 243 */     pushParent(configObject);
/* 244 */     pushTag(qName);
/* 245 */     this.characters_.setLength(0);
/*     */   }
/*     */ 
/*     */   
/*     */   private String getDtype(String qName, Attributes argAttributes) {
/* 250 */     String value = argAttributes.getValue("dtype");
/* 251 */     if (value == null) {
/* 252 */       return qName;
/*     */     }
/*     */     
/* 255 */     return value;
/*     */   }
/*     */ 
/*     */   
/*     */   private IConfigObject peekParent() {
/* 260 */     if (this.parentStack_.isEmpty()) {
/* 261 */       return null;
/*     */     }
/*     */     
/* 264 */     return this.parentStack_.getLast();
/*     */   }
/*     */ 
/*     */   
/*     */   private IConfigObject popParent() {
/* 269 */     return this.parentStack_.removeLast();
/*     */   }
/*     */   
/*     */   private String popXpath() {
/* 273 */     return ((String)this.xpathStack_.removeLast()).toString();
/*     */   }
/*     */   
/*     */   private void pushParent(IConfigObject argParent) {
/* 277 */     this.parentStack_.addLast(argParent);
/*     */   }
/*     */ 
/*     */   
/*     */   private void pushTag(String argTag) {
/* 282 */     if (this.xpathStack_.isEmpty()) {
/* 283 */       tag = "";
/*     */     } else {
/*     */       
/* 286 */       tag = ((String)this.xpathStack_.getLast()).toString() + "---";
/*     */     } 
/* 288 */     String tag = tag + (this._preserveCaseSensitiveConfigPathKeys ? argTag : argTag.toUpperCase());
/* 289 */     this.xpathStack_.addLast(tag);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\common\SaxSystemConfigLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */