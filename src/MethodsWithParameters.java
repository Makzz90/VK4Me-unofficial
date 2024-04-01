import java.util.Hashtable;

public class MethodsWithParameters extends SomeStringUtils {
   private String _method;
   private Hashtable _params;
   //private Class _class;

   public final Hashtable GetParameters() {
      return this._params;
   }

   public final MethodsWithParameters AddParameter(String key, Object value) {
      if (value != null && !IsStringEmpty(value.toString()) && !IsStringEmpty(key)) {
         this._params.put(key, value.toString());
      } else if (!IsStringEmpty(key) && this._params.containsKey(key)) {
         this._params.remove(key);
      }

      return this;
   }

   public final MethodsWithParameters AddIntiger(String key, int value) {
      return this.AddParameter(key, String.valueOf(value));
   }

   public final MethodsWithParameters AddLong(String var1, long var2) {
      return this.AddParameter(var1, String.valueOf(var2));
   }

   public VKError DoDispatch()  {
      return this.Method423(/*null,*/ false);
   }

   public final VKError Method423(/*Class229 var1,*/ boolean var2)  {
      while(/*var1 != null ||*/ Settings.Instance.IsAutorized())
      {/*
         if (var1 == null)
         {
            //var1 = Class190.Field603;
         }

         if (this instanceof Class54 && !var1.Field733) {
            var1.RefreshToken();
         }

         if (this instanceof Class206 && !((Class206)this).Method36()) {
            //Class206 var10000 = (Class206)this;
            long var7 = 0;//var1.UserId;
            Class206 var3 = (Class206)this;
            var3.owner_id = var7;
            if (var3.Method36()) {
               var3.AddLong("owner_id", var3.owner_id);
            } else {
               var3.AddParameter("owner_id", null);
            }
         }

         if (this instanceof Class429 && !((Class429)this).Method36()) {
            //((Class429)this).Method77(var1.UserId);
         }
*/
         this.AddParameter("access_token", Settings.Instance.Token);
         String var9 = Class278.Method376(this);
         JSONObject json=null;
		try {
			json = new JSONObject(var9);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         VKError error = new VKError();//this.GetErrorFromClass();
         //if (json == null || error == null) {
         //   return error;
         //}
         error.ProcessFields(json);
         Class31.Method516(error);
         if (var2 || error.error_code != 25 && (/*!(this instanceof Class54) ||*/ var9 == null || var9.indexOf("vk.com/mp3/audio_api_unavailable.mp3") == -1) && (/*!(this instanceof Class54) ||*/ var9 == null || var9.indexOf("index.m3u8") == -1)) {
            return error;
         }

        
			//var1.RefreshToken();
		
         var2 = true;
      }

      LoginForm.ShowLoginForm();
      return null;//this.GetErrorFromClass();//todo
   }
   
   public JSONObject GetResponse()
   {
	   this.AddParameter("access_token", Settings.Instance.Token);
	   String var9 = Class278.Method376(this);
       JSONObject json=null;
	   try {
			json = new JSONObject(var9);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	   return json;
   }
/*
   public final VKError GetErrorFromClass() {
      try {
         //return this._class;
         return (VKError)this._class.newInstance();
      } catch (Exception var2) {
         Logger.PrintError(var2);
         return null;
      }
   }
*/
   public MethodsWithParameters(/*Class var1, */String method) {
      //this._class = var1;
      this._params = new Hashtable();
      this.AddParameter("v", "5.103");
      if (!IsStringEmpty(method)) {
         this._method = method;
      }

   }

   public final String GetUrl() {
      return this._method + "?" + GetCommaSepareted(this);
   }

   public String toString() {
      return Settings.Instance.GetApiUrl() + "method/" + this.GetUrl();
   }
}
