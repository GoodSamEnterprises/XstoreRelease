package dtv.logbuilder.writers;

import dtv.util.TypeSafeMapKey;
import java.io.IOException;
import java.util.Map;

public interface ILogEntryWriter {
  void close() throws IOException;
  
  void initialize(Map<TypeSafeMapKey<?>, Object> paramMap) throws IOException;
  
  void write(String paramString) throws IOException;
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\writers\ILogEntryWriter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */