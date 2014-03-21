package info.re4k.asfc.croudia;

import info.re4k.asfc.croudia.http.HttpResponseCode;

public class CroudiaException extends Exception{
	private static final long serialVersionUID = 1L;
	private String message = null;
	private int statusCode = -1;
	private String errorMessage = null;
	private String errorResponseMessage = null;

	public CroudiaException(String message){
		this.message = message;
	}

	public CroudiaException(String message,int statusCode){
		this.message = message;
		this.statusCode = statusCode;
		this.errorMessage = getErrorMessage(statusCode);
	}

	public CroudiaException(String message,int statusCode,String errorResponseMessage){
		this.message = message;
		this.statusCode = statusCode;
		this.errorMessage = getErrorMessage(statusCode);
		this.errorResponseMessage = errorResponseMessage;
	}

	@Override
	public String getMessage(){
		return message;
	}

	public int getStatusCode(){
		return statusCode;
	}

	public String getErrorMessage(){
		return errorMessage;
	}

	public String getErrorResponseMessage(){
		return errorResponseMessage;
	}

	// http://developer.croudia.com/docs/206_response
	public static String getErrorMessage(int statusCode){
		if(statusCode==HttpResponseCode.Http_Success){// これは呼び出されないはず
			return "http request ok";
		}else if(statusCode==HttpResponseCode.Http_Not_Modified){
			return "新しいデータがない";
		}else if(statusCode==HttpResponseCode.Http_Bad_Request){
			return "リクエストに不正がある or レートリミットに達している or OAuthのシグニチャに問題がある";
		}else if(statusCode==HttpResponseCode.Http_Unauthorized){
			return "認証情報に誤りがある";
		}else if(statusCode==HttpResponseCode.Http_Forbidden){
			return "リクエスト拒否された";
		}else if(statusCode==HttpResponseCode.Http_Not_Found){
			return "リソースが存在していない";
		}else if(statusCode==HttpResponseCode.Http_Server_Internal_Error){
			return "サーバー側で問題が発生した";
		}else if(statusCode==HttpResponseCode.Http_Bad_Gateway){
			return "サーバ側に障害がある or サーバーの更新中";
		}else if(statusCode==HttpResponseCode.Http_Service_Unavailable){
			return "サーバーが過負荷になっている";
		}
		return "不明なエラーコード";
	}
}
