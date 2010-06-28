package http_parser;

import java.nio.charset.Charset;

public enum HTTPMethod {
    HTTP_DELETE("DELETE")//    = 0
  , HTTP_GET("GET")
  , HTTP_HEAD("HEAD")
  , HTTP_POST("POST")
  , HTTP_PUT("PUT")
  /* pathological */
  , HTTP_CONNECT("CONNECT")
  , HTTP_OPTIONS("OPTIONS")
  , HTTP_TRACE("TRACE")
  /* webdav */
  , HTTP_COPY("COPY")
  , HTTP_LOCK("LOCK")
  , HTTP_MKCOL("MKCOL")
  , HTTP_MOVE("MOVE")
  , HTTP_PROPFIND("PROPFIND")
  , HTTP_PROPPATCH("PROPPATCH")
  , HTTP_UNLOCK("UNLOCK");
	
	private static Charset ASCII;
	static {
		ASCII = Charset.forName("US-ASCII");;
	}
	byte[] bytes;

	HTTPMethod(String name) {
		// good grief, Charlie Brown, the following is necessary because 
		// java is retarded:
		// illegal reference to static field from initializer
    //            this.bytes = name.getBytes(ASCII);
		// yet it's not illegal to reference static fields from
		// methods called from initializer.
		init(name);
	}
	public static HTTPMethod parse(String s) {
				 if ("HTTP_DELETE".equalsIgnoreCase(s))  {return HTTP_DELETE;}
		else if ("DELETE".equalsIgnoreCase(s))       {return HTTP_DELETE;}
		else if ("HTTP_GET".equalsIgnoreCase(s))     {return HTTP_GET;}
		else if ("GET".equalsIgnoreCase(s))          {return HTTP_GET;}
		else if ("HTTP_HEAD".equalsIgnoreCase(s))    {return HTTP_HEAD;}
		else if ("HEAD".equalsIgnoreCase(s))         {return HTTP_HEAD;}
		else if ("HTTP_POST".equalsIgnoreCase(s))    {return HTTP_POST;}
		else if ("POST".equalsIgnoreCase(s))         {return HTTP_POST;}
		else if ("HTTP_PUT".equalsIgnoreCase(s))     {return HTTP_PUT;}
		else if ("PUT".equalsIgnoreCase(s))          {return HTTP_PUT;}
		else if ("HTTP_CONNECT".equalsIgnoreCase(s)) {return HTTP_CONNECT;}
		else if ("CONNECT".equalsIgnoreCase(s))      {return HTTP_CONNECT;}
		else if ("HTTP_OPTIONS".equalsIgnoreCase(s)) {return HTTP_OPTIONS;}
		else if ("OPTIONS".equalsIgnoreCase(s))      {return HTTP_OPTIONS;}
		else if ("HTTP_TRACE".equalsIgnoreCase(s))   {return HTTP_TRACE;}
		else if ("TRACE".equalsIgnoreCase(s))        {return HTTP_TRACE;}
		else if ("HTTP_COPY".equalsIgnoreCase(s))    {return HTTP_COPY;}
		else if ("COPY".equalsIgnoreCase(s))         {return HTTP_COPY;}
		else if ("HTTP_LOCK".equalsIgnoreCase(s))    {return HTTP_LOCK;}
		else if ("LOCK".equalsIgnoreCase(s))         {return HTTP_LOCK;}
		else if ("HTTP_MKCOL".equalsIgnoreCase(s))   {return HTTP_MKCOL;}
		else if ("MKCOL".equalsIgnoreCase(s))        {return HTTP_MKCOL;}
		else if ("HTTP_MOVE".equalsIgnoreCase(s))    {return HTTP_MOVE;}
		else if ("MOVE".equalsIgnoreCase(s))         {return HTTP_MOVE;}
		else if ("HTTP_PROPFIND".equalsIgnoreCase(s)){return HTTP_PROPFIND;}
		else if ("PROPFIND".equalsIgnoreCase(s))     {return HTTP_PROPFIND;}
		else if ("HTTP_PROPPATCH".equalsIgnoreCase(s)){return HTTP_PROPPATCH;}
		else if ("PROPPATCH".equalsIgnoreCase(s))    {return HTTP_PROPPATCH;}
		else if ("HTTP_UNLOCK".equalsIgnoreCase(s))  {return HTTP_UNLOCK;}
		else if ("UNLOCK".equalsIgnoreCase(s))       {return HTTP_UNLOCK;}
	  else                                         {return null;}
	}	
	void init (String name) {
		ASCII = null == ASCII ? Charset.forName("US-ASCII") : ASCII;
		this.bytes = name.getBytes(ASCII);
	}

}