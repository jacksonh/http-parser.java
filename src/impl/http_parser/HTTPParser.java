package http_parser;

public class HTTPParser extends http_parser.lolevel.HTTPParser {
  
  public HTTPParser() { super(); }
  public HTTPParser(ParserType type) { super(type); }

  public int getMajor() {
    return super.http_major;
  }

  public int getMinor() {
    return super.http_minor;
  }

  public int getStatusCode() {
    return super.status_code;
  }

  public HTTPMethod getHTTPMethod() {
    return super.method;
  }

  public boolean getUpgrade() {
    return super.upgrade;
  }
} 
