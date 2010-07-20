package http_parser;

import java.nio.ByteBuffer;

import http_parser.lolevel.Util;
import http_parser.lolevel.HTTPErrorCallback;


public class HTTPParser extends http_parser.lolevel.HTTPParser {
  
  public HTTPParser() { super(); }
  public HTTPParser(ParserType type) { super(type); }
  
  /**
   * retrieve the HTTP major version of this message
   */
  public int getMajor() {
    return super.http_major;
  }

  /**
   * retrieve the HTTP minor version of this message
   */
  public int getMinor() {
    return super.http_minor;
  }

  /**
   * retrieve the HTTP status code of this message 
   */
  public int getStatusCode() {
    return super.status_code;
  }

  /**
   * retrieve the HTTP method of this message 
   */
  public HTTPMethod getHTTPMethod() {
    return super.method;
  }

  /**
   * is this an upgrade request ... e.g. CONNECT
   */
  public boolean getUpgrade() {
    return super.upgrade;
  }
} 



class ParserSettings extends http_parser.lolevel.ParserSettings {
  ParserSettings() {
    this.on_error = DefaultErrorCallback.CALLBACK;
  }
}

class DefaultErrorCallback implements HTTPErrorCallback {
  static final DefaultErrorCallback CALLBACK = new DefaultErrorCallback();
  private DefaultErrorCallback() {
    super();
  }
  public void cb (http_parser.lolevel.HTTPParser p, String mes, ByteBuffer buf, int initial_position) {
    StringBuilder builder = new StringBuilder();
    builder.append (p.toString());
    builder.append (" : ");
    builder.append (mes);
    builder.append ("\n");
    builder.append (Util.prettyPrintErrorCtx(buf, initial_position));
    throw new HTTPException(builder.toString()); 
  }

}
