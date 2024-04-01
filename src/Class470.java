

public final class Class470 extends MethodsWithParameters {
   private String Code;
   private String CaptchaSid;
   private String CaptchaKey;
   private boolean ForceSms = false;
   //private static Class Field1296;

   public Class470(String username, String password)
   {
	   
	   
      super(/*Field1296 == null ? (Field1296 = GetClassByName("AuthData")) : Field1296,*/ "token");//todo: nameof AuthData
      
    
	   
	   
	   
      this.AddIntiger("libverify_support", 1);
      this.AddParameter("grant_type", "password");
      this.AddParameter("client_id", "2274003");
//      this.AddParameter("client_name", "vk4me");
      this.AddParameter("client_secret", "hHbZxrka2uZ6jB1inYsH");
      this.AddParameter("scope", "all");
      this.AddIntiger("2fa_supported", 1);
      this.AddParameter("username", username == null ? null : Class278.Method377(username));
      this.AddParameter("password", password == null ? null : Class278.Method377(password));
   }

   public final Class470 SetCode(String code) {
      this.Code = code;
      this.AddParameter("code", this.Code);
      return this;
   }

   public final Class470 SetForceSms(boolean var1) {
      this.ForceSms = var1;
      this.AddParameter("force_sms", this.ForceSms ? "1" : null);
      return this;
   }

   public final VKError DoDispatch()  {
      String var1 = Class278.Method376(this);

      JSONObject json;
      try {
         json = new JSONObject(var1);
      } catch (Throwable th) {//todo: exp
         Logger.PrintError(th);
         json = null;
      }

      //VKError error = this.GetErrorFromClass();
      //return json != null && error != null ? (VKError)error.ProcessFields(json) : error;
      VKError error = new VKError();
      error.ProcessFields(json);
      return error;
   }

   public final Class470 SetCaptchaSid(String captcha_sid) {
      this.CaptchaSid = captcha_sid;
      this.AddParameter("captcha_sid", this.CaptchaSid);
      return this;
   }

   public final Class470 SetCaptchaKey(String captcha_key) {
      this.CaptchaKey = captcha_key;
      this.AddParameter("captcha_key", this.CaptchaKey);
      return this;
   }

   public final String toString() {
	   String temp = Settings.Instance.OauthUrl;
      return (temp == null ? "https://oauth.vk.com/" : temp) + this.GetUrl();
   }
/*
   private static Class GetClassByName(String name) {
      try {
         return Class.forName(name);
      } catch (ClassNotFoundException var1) {
         throw new NoClassDefFoundError(var1.getMessage());
      }
   }*/
}
