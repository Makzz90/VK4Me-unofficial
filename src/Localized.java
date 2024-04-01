import java.io.InputStream;
import java.util.Hashtable;
import java.util.Vector;

public class Localized {
   private static ApplicationLang[] _lang;
   public static Localized Instance;
   private Hashtable _dict;

   public Localized(String var1) {
      this._dict = new Hashtable();
      this.Method395(var1);
   }

   private void Method395(String var1) {
      if (var1 != null) {
         try {
            Vector var6 = Class291.Separete(var1, "\n");

            for(int i = 0; i < var6.size(); i++)
            {
               String var3;
               int var4;
               if ((var3 = (String)var6.elementAt(i)) != null && !var3.startsWith("#") && (var4 = var3.indexOf(61)) != -1) {
                  String var7 = var3.substring(var4 + 1);
                  var3 = var3.substring(0, var3.length() - 1 - var7.length()).trim();
                  this._dict.put(var3, var7.trim());
               }
            }

         } catch (OutOfMemoryError var5) {
            this._dict = new Hashtable();
            System.gc();
         }
      }
   }

   public static ApplicationLang[] GetLangs() {
      if (_lang != null) {
         return _lang;
      } else {
         Vector var0 = new Vector();

         try {
        	 InputStream stream = Runtime.getRuntime().getClass().getResourceAsStream("/lang/list.langs");
            Vector list = Class291.Separete(new String(Class278.Method378(stream), Class514.Field1364), "\n");

            for(int i = 0; i < list.size(); i++) {
               String var3 = (String)list.elementAt(i);
               if (var3 != null && !var3.startsWith("#")) {
                  Vector var6 = Class291.Separete(var3, ";");
                  ApplicationLang lang = new ApplicationLang();
                  if (var6.size() > 2) {
                     lang.Version = ((String)var6.elementAt(2)).trim();
                     lang.Name = ((String)var6.elementAt(1)).trim();
                     lang.Code = ((String)var6.elementAt(0)).trim();
                  }

                  if (!Class291.IsNullOrEmpty(lang.Code) && IsLangExists(lang.Code)) {
                     var0.addElement(lang);
                  }
               }
            }

            _lang = new ApplicationLang[var0.size()];
            var0.copyInto(_lang);
         } catch (Exception ex) {
        	 String temp = ex.getMessage();
            _lang = new ApplicationLang[0];
            System.gc();
         }

         return _lang;
      }
   }

   public static String GetString(String key) {
      if (key == null) {
         return key;
      } else if (Instance == null) {
         return key;
      } else {
         String temp = key;
         key = (String)Instance._dict.get(temp);
            return (key) == null ? temp : key;
         
      }
   }

   public static String Method398(String var0, String var1, String var2) {
      if (var0 == null) {
         return var0;
      } else {
         var0 = GetString(var0);
         if (var1 == null) {
            return var0;
         } else {
            var0 = Class291.Method438(var0, "%%", var1);
            return var2 == null ? var0 : Class291.Method438(var0, "%%", var2);
         }
      }
   }

   private static boolean IsLangExists(String lang) {
      try {
         Runtime.getRuntime().getClass().getResourceAsStream("/lang/" + lang + ".lang").close();
         return true;
      } catch (Exception var1) {
         return false;
      }
   }

   public static String GetLang()
   {
      String loc = System.getProperty("microedition.locale");
      if (loc == null) {
         return "en";
      } else {
         ApplicationLang[] langs = GetLangs();

         for(int i = 0; i < langs.length; i++) {
            ApplicationLang var3 = langs[i];
            if (var3 != null && var3.Code != null && loc.indexOf(var3.Code) != -1) {
               return var3.Code;
            }
         }

         return "en";
      }
   }

   public Localized() {
   }

   public static Class512 Method401(String username, String password, String captcha_key, String captcha_sid, String code, boolean force_sms) throws Exception {
      Class470 var7 = (new Class470(username, password)).SetCaptchaKey(captcha_key).SetCaptchaSid(captcha_sid).SetCode(code).SetForceSms(force_sms);
      password = Class278.Field877.Method54(var7);

      JSONObject json;
      try {
         json = new JSONObject(password);
      } catch (Exception var6) {//Class116
         Logger.PrintError(var6);
         json = null;
      }

      //AuthData var8 = (AuthData)var7.GetErrorFromClass();
      //
      AuthData auth = new AuthData();
      //
      if (json != null && auth != null) {
         auth = (AuthData)auth.ProcessFields(json);
      } else {
         auth = null;
      }

      int var10 = 0;
      if (auth == null) {
         return new Class512(0, auth, 0, json);
      } else {
         if (auth.Method36() && force_sms) {
            Class298 var12;
            if ((var12 = (Class298)(new Class191(auth.validation_sid)).DoDispatch()) != null) {
               var10 = var12.Field929;
            }

            if (var10 < 120) {
               var10 = 120;
            }
         }

         if (auth.IsSucsess()) {
            //Class190.Field603 = new Class229(var8.AccessToken);
        	 Settings.Instance.Token = auth.access_token;
            return new Class512(4, auth, var10, json);
         } else if (!AuthData.IsStringEmpty(auth.phone_mask) || !AuthData.IsStringEmpty(auth.validation_type) || auth.Method36()) {
            return new Class512(2, auth, var10, json);
         } else if (!AuthData.IsStringEmpty(auth.captcha_sid) || !AuthData.IsStringEmpty(auth.captcha_img)) {
            return new Class512(1, auth, var10, json);
         } else if (auth.IsErrorExists() && auth.error_type.equals("username_or_password_is_incorrect")) {
            return new Class512(3, auth, var10, json);
         } else if (auth.IsErrorExists() && auth.error_type.equals("wrong_otp")) {
            return new Class512(-2, auth, var10, json);
         } else if (auth.IsErrorExists() && auth.error_type.equals("otp_format_is_incorrect")) {
            return new Class512(-1, auth, var10, json);
         } else {
            return !auth.IsSucsess() ? new Class512(-3, auth, var10, json) : new Class512(0, auth, var10, json);
         }
      }
   }
}
