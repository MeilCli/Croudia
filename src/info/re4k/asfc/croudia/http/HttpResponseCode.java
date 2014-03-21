package info.re4k.asfc.croudia.http;

public interface HttpResponseCode{
	public static int Http_Success = 200;
	public static int Http_Not_Modified = 304;
	public static int Http_Bad_Request = 400;
	public static int Http_Unauthorized = 401;
	public static int Http_Forbidden = 403;
	public static int Http_Not_Found = 404;
	public static int Http_Server_Internal_Error = 500;
	public static int Http_Bad_Gateway = 502;
	public static int Http_Service_Unavailable = 503;
}
