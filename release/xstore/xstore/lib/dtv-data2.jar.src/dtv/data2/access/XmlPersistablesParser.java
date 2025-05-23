/*     */ package dtv.data2.access;
/*     */ 
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.DaoState;
/*     */ import dtv.data2.access.query.QueryRequest;
/*     */ import dtv.util.StringUtils;
/*     */ import java.io.StringReader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.xml.stream.XMLInputFactory;
/*     */ import javax.xml.stream.XMLStreamException;
/*     */ import javax.xml.stream.XMLStreamReader;
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
/*     */ public class XmlPersistablesParser
/*     */ {
/*     */   public static final String XML_HEADER_PREFIX = "<?xml";
/*     */   public static final String XML_TIMEOUT_PREFIX = "<Timeout";
/*     */   public static final String XML_DAO_PREFIX = "<dao";
/*     */   public static final String XML_DAO_NAME_ATTR = "name";
/*     */   public static final String XML_DAO_CMD_ATTR = "cmd";
/*     */   public static final String XML_DAO_FIELD_ID_ATTR = "id";
/*     */   public static final String XML_DAO_FIELD_VAL_ATTR = "val";
/*     */   public static final String QUERY_REQUEST_PREFIX = "<QueryRequest";
/*     */   public static final String XML_BEGIN_TAG = "<req>";
/*     */   public static final String XML_END_TAG = "</req>";
/*     */   public static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
/*     */   private final String _xml;
/*     */   private Integer _timeout;
/*     */   
/*     */   public static String normalizeXml(String argXml) {
/*  48 */     if (argXml.startsWith("<?xml")) {
/*  49 */       return argXml;
/*     */     }
/*     */ 
/*     */     
/*  53 */     String trimmedXml = argXml.trim();
/*  54 */     StringBuilder builder = new StringBuilder(trimmedXml);
/*     */ 
/*     */     
/*  57 */     if (trimmedXml.startsWith("<dao") || trimmedXml.startsWith("<Timeout") || trimmedXml
/*  58 */       .startsWith("<QueryRequest")) {
/*  59 */       builder.insert(0, "<req>");
/*  60 */       builder.append("</req>");
/*     */     } 
/*     */ 
/*     */     
/*  64 */     if (!trimmedXml.startsWith("<?xml")) {
/*  65 */       builder.insert(0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
/*     */     }
/*     */     
/*  68 */     return builder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  74 */   private final List<IPersistable> _persistables = new ArrayList<>(8);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlPersistablesParser(String argXml) {
/*  81 */     this._xml = argXml;
/*     */   }
/*     */   
/*     */   public PersistablesPackage getPersistablePackage() {
/*     */     try {
/*  86 */       XMLInputFactory factory = XMLInputFactory.newInstance();
/*  87 */       factory.setProperty("javax.xml.stream.supportDTD", Boolean.valueOf(false));
/*  88 */       XMLStreamReader reader = factory.createXMLStreamReader(new StringReader(normalizeXml(this._xml)));
/*     */       try {
/*  90 */         readDocument(reader);
/*  91 */         return new PersistablesPackage(this._persistables, this._timeout);
/*     */       } finally {
/*     */         
/*  94 */         reader.close();
/*     */       }
/*     */     
/*  97 */     } catch (Exception e) {
/*  98 */       throw new DtxException("An exception occurred when parsing persistables.", e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void parseDaoFieldFromReader(XMLStreamReader argReader, Map<String, String> fieldValues) {
/* 109 */     String id = null;
/* 110 */     String val = null;
/* 111 */     for (int i = 0; i < argReader.getAttributeCount(); i++) {
/* 112 */       switch (argReader.getAttributeLocalName(i)) {
/*     */         case "id":
/* 114 */           id = argReader.getAttributeValue(i);
/*     */           break;
/*     */         case "val":
/* 117 */           val = argReader.getAttributeValue(i);
/*     */           break;
/*     */       } 
/*     */     } 
/* 121 */     fieldValues.put(id, val);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void parseDaoFromReader(XMLStreamReader argReader) throws XMLStreamException {
/* 131 */     String name = null;
/* 132 */     String cmd = null;
/* 133 */     for (int i = 0; i < argReader.getAttributeCount(); i++) {
/* 134 */       switch (argReader.getAttributeLocalName(i)) {
/*     */         case "name":
/* 136 */           name = argReader.getAttributeValue(i);
/*     */           break;
/*     */         case "cmd":
/* 139 */           cmd = argReader.getAttributeValue(i);
/*     */           break;
/*     */       } 
/*     */ 
/*     */     
/*     */     } 
/* 145 */     IDataAccessObject dao = DataModelFactory.getDaoForDaoName(name);
/* 146 */     Map<String, String> fieldValues = new HashMap<>();
/* 147 */     while (argReader.hasNext()) {
/* 148 */       int eventType = argReader.nextTag();
/* 149 */       if (eventType == 1) {
/*     */         
/* 151 */         if ("originDS".equalsIgnoreCase(argReader.getLocalName())) {
/* 152 */           String originDataSource = argReader.getElementText();
/* 153 */           if (!StringUtils.isEmpty(originDataSource)) {
/* 154 */             dao.setOriginDataSource(originDataSource);
/*     */           }
/*     */           
/*     */           continue;
/*     */         } 
/* 159 */         parseDaoFieldFromReader(argReader, fieldValues);
/*     */         continue;
/*     */       } 
/* 162 */       if (eventType == 2 && argReader
/* 163 */         .getLocalName().equals("dao")) {
/*     */         
/* 165 */         dao.setValues(fieldValues);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 174 */         dao.setObjectState(DaoState.CLEAN.intVal());
/* 175 */         dao.setObjectState(cmd);
/*     */ 
/*     */         
/* 178 */         this._persistables.add(dao);
/*     */         break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void parseQueryRequestFromReader(XMLStreamReader argReader) throws XMLStreamException {
/* 191 */     QueryRequest request = new QueryRequest();
/* 192 */     request.unmarshall(argReader);
/* 193 */     this._persistables.add(request);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void readDocument(XMLStreamReader argReader) throws XMLStreamException {
/* 203 */     while (argReader.hasNext()) {
/* 204 */       int elementType = argReader.next();
/* 205 */       if (elementType == 1) {
/* 206 */         readElements(argReader); continue;
/*     */       } 
/* 208 */       if (elementType == 2) {
/*     */         break;
/*     */       }
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
/*     */   protected void readElements(XMLStreamReader argReader) throws XMLStreamException {
/* 222 */     while (argReader.hasNext()) {
/* 223 */       int eventType = argReader.next();
/* 224 */       if (eventType == 1) {
/* 225 */         switch (argReader.getLocalName()) {
/*     */           case "dao":
/* 227 */             parseDaoFromReader(argReader);
/*     */             continue;
/*     */           case "QueryRequest":
/* 230 */             parseQueryRequestFromReader(argReader);
/*     */             continue;
/*     */           case "Timeout":
/* 233 */             parseTimeoutFromReader(argReader);
/*     */             continue;
/*     */         } 
/* 236 */         throw new DtxException("Unknown element detected in persistables XML: " + argReader
/* 237 */             .getLocalName());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void parseTimeoutFromReader(XMLStreamReader argReader) {
/* 248 */     for (int i = 0; i < argReader.getAttributeCount(); i++) {
/* 249 */       if (argReader.getAttributeLocalName(i).equals("t")) {
/* 250 */         String timeoutString = argReader.getAttributeValue(i);
/* 251 */         if (!StringUtils.isEmpty(timeoutString))
/* 252 */           this._timeout = Integer.valueOf(timeoutString); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\XmlPersistablesParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */