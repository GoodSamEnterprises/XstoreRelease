package dtv.docbuilding;

import dtv.docbuilding.types.DocBuilderAlignmentType;
import dtv.docbuilding.types.DocBuilderFieldType;
import dtv.i18n.formatter.output.IOutputFormatter;
import dtv.util.config.IReflectionParameterCapable;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public interface IDocBuilderFieldFactory {
  public static final String KEYED_TEXT_SEPARATOR = "<br>";
  
  String getKeyedText(Date paramDate, String paramString1, String paramString2, Locale paramLocale);
  
  IDocBuilderField makeDocBuilderField(DocBuilderFieldType paramDocBuilderFieldType, Object paramObject, List<IReflectionParameterCapable<?>> paramList, String paramString, Integer paramInteger, DocBuilderAlignmentType paramDocBuilderAlignmentType, int paramInt, IOutputFormatter paramIOutputFormatter);
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\IDocBuilderFieldFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */