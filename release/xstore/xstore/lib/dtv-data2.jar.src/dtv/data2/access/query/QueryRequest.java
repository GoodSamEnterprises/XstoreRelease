/*     */ package dtv.data2.access.query;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IPersistable;
/*     */ import dtv.data2.access.IPersistenceMgrType;
/*     */ import dtv.data2.access.IQueryKey;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.EncodingHelper;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.XmlUtils;
/*     */ import java.io.Serializable;
/*     */ import java.io.StringReader;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.HashMap;
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
/*     */ public class QueryRequest
/*     */   implements IPersistable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final boolean GZIP = true;
/*     */   public static final String XML_ELEMENT_NAME = "QueryRequest";
/*     */   private String queryKey_;
/*     */   private Map<String, Object> params_;
/*     */   private IPersistenceMgrType _pmType;
/*     */   
/*     */   public QueryRequest() {}
/*     */   
/*     */   public QueryRequest(String argQueryKey, Map<String, Object> argParams) {
/*  42 */     this(argQueryKey, argParams, null);
/*     */   }
/*     */   
/*     */   public QueryRequest(String argQueryKey, Map<String, Object> argParams, IPersistenceMgrType argPmType) {
/*  46 */     this.queryKey_ = argQueryKey;
/*  47 */     setParams(argParams);
/*  48 */     this._pmType = argPmType;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object argObject) {
/*  53 */     if (argObject instanceof QueryRequest) {
/*  54 */       QueryRequest other = (QueryRequest)argObject;
/*  55 */       if (this.queryKey_.equals(other.queryKey_) && ObjectUtils.equivalent(this.params_, other.params_) && 
/*  56 */         ObjectUtils.equivalent(this._pmType, other.getPmType())) {
/*  57 */         return true;
/*     */       }
/*     */     } 
/*  60 */     return false;
/*     */   }
/*     */   
/*     */   public Map<String, Object> getParams() {
/*  64 */     return this.params_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IPersistenceMgrType getPmType() {
/*  74 */     return this._pmType;
/*     */   }
/*     */   
/*     */   public String getQueryKey() {
/*  78 */     return this.queryKey_;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  83 */     return this.queryKey_.hashCode() + ((this.params_ != null) ? this.params_.hashCode() : 0) + ((this._pmType != null) ? this._pmType
/*  84 */       .hashCode() : 0);
/*     */   }
/*     */   
/*     */   public void setParams(Map<String, Object> argParams) {
/*     */     Map<String, Object> params;
/*  89 */     if (argParams == null) {
/*  90 */       params = new HashMap<>(8);
/*     */     } else {
/*     */       
/*  93 */       params = argParams;
/*     */     } 
/*     */     
/*  96 */     DaoUtils.massageQueryParams(params, Long.getLong("dtv.location.organizationId"));
/*  97 */     this.params_ = params;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setQueryKey(IQueryKey<?> argQueryKey) {
/* 104 */     this.queryKey_ = argQueryKey.getName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setQueryKey(String argQueryKey) {
/* 111 */     this.queryKey_ = argQueryKey;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 116 */     return getClass().getSimpleName() + " [QueryKey: {" + this.queryKey_ + "} {params: " + this.params_ + "} {pmType: " + this._pmType + "}]";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toXmlString() {
/* 127 */     StringBuilder buf = new StringBuilder(512);
/*     */     
/* 129 */     buf.append("<QueryRequest>");
/* 130 */     buf.append("<QueryKey>").append(this.queryKey_).append("</QueryKey>");
/* 131 */     buf.append("<Params>");
/*     */     
/* 133 */     for (String key : this.params_.keySet()) {
/* 134 */       Object value = this.params_.get(key);
/* 135 */       ParamType type = getXmlType(value);
/* 136 */       buf.append("<Param name=\"").append(key).append("\" type=\"").append(type.name()).append("\">");
/* 137 */       buf.append(getXmlValue(type, value));
/* 138 */       buf.append("</Param>");
/*     */     } 
/* 140 */     buf.append("</Params>");
/* 141 */     buf.append("</QueryRequest>");
/*     */     
/* 143 */     return buf.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unmarshall(String argXmlString) {
/*     */     try {
/* 152 */       XMLInputFactory factory = XMLInputFactory.newInstance();
/* 153 */       factory.setProperty("javax.xml.stream.supportDTD", Boolean.valueOf(false));
/* 154 */       XMLStreamReader reader = factory.createXMLStreamReader(new StringReader(argXmlString));
/*     */       try {
/* 156 */         while (reader.hasNext()) {
/*     */           
/* 158 */           int event = reader.next();
/* 159 */           if (event == 1 && reader.getLocalName().equals("QueryRequest")) {
/* 160 */             unmarshall(reader);
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } finally {
/* 166 */         reader.close();
/*     */       }
/*     */     
/* 169 */     } catch (Exception ee) {
/* 170 */       throw new DtxException("An error occurred while parsing XML: " + argXmlString, ee);
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
/*     */   public void unmarshall(XMLStreamReader argReader) throws XMLStreamException {
/* 183 */     Map<String, Object> params = new HashMap<>(8);
/* 184 */     while (argReader.hasNext()) {
/* 185 */       int eventType = argReader.next();
/* 186 */       if (eventType == 1) {
/*     */         
/* 188 */         if (argReader.getLocalName().equals("QueryKey")) {
/* 189 */           setQueryKey(argReader.getElementText()); continue;
/*     */         } 
/* 191 */         if (argReader.getLocalName().equals("Params"))
/*     */         {
/* 193 */           while (argReader.hasNext()) {
/* 194 */             eventType = argReader.nextTag();
/* 195 */             if (eventType == 1) {
/* 196 */               String name = null;
/* 197 */               ParamType type = null;
/*     */ 
/*     */               
/* 200 */               for (int i = 0; i < argReader.getAttributeCount(); i++) {
/* 201 */                 if (argReader.getAttributeLocalName(i).equals("name")) {
/* 202 */                   name = argReader.getAttributeValue(i);
/*     */                 }
/* 204 */                 else if (argReader.getAttributeLocalName(i).equals("type")) {
/* 205 */                   type = ParamType.valueOf(argReader.getAttributeValue(i));
/*     */                 } 
/*     */               } 
/*     */ 
/*     */               
/* 210 */               String rawValue = argReader.getElementText();
/* 211 */               params.put(name, getValueForQueryRequestXml(type, rawValue)); continue;
/*     */             } 
/* 213 */             if (eventType == 2) {
/*     */               break;
/*     */             }
/*     */           } 
/*     */         }
/*     */         continue;
/*     */       } 
/* 220 */       if (eventType == 2) {
/*     */         
/* 222 */         setParams(params);
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
/*     */   private Object getValueForQueryRequestXml(ParamType argType, String argParam) {
/* 235 */     switch (argType) {
/*     */       case STRING:
/* 237 */         return argParam;
/*     */ 
/*     */ 
/*     */       
/*     */       case DATE:
/* 242 */         return DaoUtils.getFieldValueForXmlString(93, argParam);
/*     */       case BOOL:
/* 244 */         return Boolean.valueOf("1".equals(argParam));
/*     */       case INT:
/* 246 */         return Integer.valueOf(Integer.parseInt(argParam));
/*     */       case LONG:
/* 248 */         return Long.valueOf(Long.parseLong(argParam));
/*     */       case DECIMAL:
/* 250 */         return new BigDecimal(argParam);
/*     */       case CLASS:
/*     */         try {
/* 253 */           return EncodingHelper.decodeObject(argParam, true);
/*     */         }
/* 255 */         catch (Exception ee) {
/* 256 */           throw new DtxException("Failed to decode parameter: " + argParam + " For query requst: " + this, ee);
/*     */         } 
/*     */     } 
/*     */     
/* 260 */     throw new DtxException("This point should not be reached. QueryRequst: " + this);
/*     */   }
/*     */   
/*     */   private ParamType getXmlType(Object argParam) {
/* 264 */     if (argParam instanceof String) {
/* 265 */       return ParamType.STRING;
/*     */     }
/* 267 */     if (argParam instanceof java.util.Date) {
/* 268 */       return ParamType.DATE;
/*     */     }
/* 270 */     if (argParam instanceof Boolean) {
/* 271 */       return ParamType.BOOL;
/*     */     }
/* 273 */     if (argParam instanceof Integer) {
/* 274 */       return ParamType.INT;
/*     */     }
/* 276 */     if (argParam instanceof Long) {
/* 277 */       return ParamType.LONG;
/*     */     }
/* 279 */     if (argParam instanceof BigDecimal) {
/* 280 */       return ParamType.DECIMAL;
/*     */     }
/*     */     
/* 283 */     return ParamType.CLASS;
/*     */   }
/*     */   
/*     */   private String getXmlValue(ParamType argType, Object argParam) {
/*     */     BigDecimal dec;
/* 288 */     switch (argType) {
/*     */       case STRING:
/* 290 */         return XmlUtils.toXmlSafe(argParam.toString());
/*     */       case DATE:
/* 292 */         return String.valueOf(((DtvDate)argParam).getTimeSerializable());
/*     */       case BOOL:
/* 294 */         return ((Boolean)argParam).booleanValue() ? "1" : "0";
/*     */       case INT:
/*     */       case LONG:
/* 297 */         return argParam.toString();
/*     */       case DECIMAL:
/* 299 */         dec = ((BigDecimal)argParam).stripTrailingZeros();
/* 300 */         return dec.toPlainString();
/*     */       case CLASS:
/*     */         try {
/* 303 */           return XmlUtils.toXmlSafe(EncodingHelper.encodeObject(argParam, true));
/*     */         }
/* 305 */         catch (Exception ee) {
/* 306 */           throw new DtxException("Failed to encode parameter: " + argParam + " For query requst: " + this, ee);
/*     */         } 
/*     */     } 
/* 309 */     throw new DtxException("This point should not be reached. QueryRequst: " + this);
/*     */   }
/*     */   
/*     */   public enum ParamType {
/* 313 */     STRING, DATE, BOOL, INT, LONG, DECIMAL, CLASS;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\query\QueryRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */