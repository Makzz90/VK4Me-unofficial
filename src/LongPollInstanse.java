import java.util.Timer;
import java.util.TimerTask;

public final class LongPollInstanse extends TimerTask {
   public static Class246 Field889;
   private static Timer _timer;
   private static int _ts;
   private static int Field892;
   public static int LpSpeed = 3;
   public static int LpsSpeed = 17;
   public static boolean IsAppPaused;
   public static boolean Field896;
   private String _key;
   private String _server;

   public static void Stop(boolean stopOnly)
   {
      try
      {
         if (_timer != null) {
            _timer.cancel();
         }

         if (Field889 != null) {
            Field889.Method249();
         }
      } catch (Exception var2) {
      }

      try {
         if (!stopOnly && Settings.Instance.IsAutorized()) {
            Start();
         }

      } catch (Exception var1) {
         Logger.PrintError(var1);
      }
   }

   public static void Start()
   {
      LongPollInstanse longPoll = new LongPollInstanse();
      if (Settings.Instance.IsAutorized())
      {
         //Class290 var1= (Class290)(new Class515()).DoDispatch();
    	  Class290 var1= new Class290();
    	  Class515 resp = new Class515();
    	  JSONObject result = resp.GetResponse();
    	  var1.ProcessFields(result);
    	  
         if (var1  != null && var1.IsSucsess())
         {
            _ts = var1.ts;
            longPoll._key = var1.key;
            longPoll._server = var1.server;
            (_timer = new Timer()).schedule(longPoll, 0L);
            return;
         }

         Stop(false);
      }

   }

   public final void run() {
      while(true) {
         try {
            if (!Settings.Instance.IsAutorized()) {
               return;
            }
        	

            Field892 = 0;
            Field896 = false;
            if (Field889 != null)
            {
//               Field889.Method248();//TODO WTF? Repaint
            }

            String var1 = (this._server.startsWith("http") ? "" : (Settings.Instance.GetApiUrl().startsWith("http:") ? "http://" : "https://")) + this._server + "?act=a_check&key=" + this._key + "&ts=" + _ts + "&wait=2&mode=202&version=3";
            String var2 = null;

            try {
               var2 = Class278.Field877.Method43(var1);
            } catch (Exception var8) {
               Logger.PrintError(var8);
            }

            if (!SomeStringUtils.IsStringEmpty(var2)) {
               JSONArray updates = null;

               try {
                  JSONObject var3= new JSONObject(var2);
                  int failed= var3.optGetInt("failed");
                  if (failed == 2 || failed == 3 || failed == 4)
                  {
                     Stop(false);
                     return;
                  }

                  if ((failed = var3.optGetInt("ts")) != 0) {
                     _ts = failed;
                  }

                  updates = var3.optJSONArray("updates");
               }
               catch (Exception ex)
               {
                  Logger.PrintError(ex);

                  try
                  {
                     updates = new JSONArray(var2);
                  }
                  catch (Exception var7)
                  {
                     Logger.PrintError(var7);
                  }
               }

               try {
                  Method393(updates);
               } catch (Exception var6) {
                  Logger.PrintError(var6);
               }
            }

            if (Field889 != null) {
               Field889.Method249();
            }

            for(; (IsAppPaused && Field892 < LpsSpeed || !IsAppPaused && Field892 < LpSpeed) && !Field896; Field892++)
            {
               try
               {
                  Thread.sleep(1000L);
               }
               catch (Exception var5) {
               }
            }
         } catch (Exception var10) {
            Logger.PrintError(var10);
         }
      }
   }

   private static void Method393(JSONArray json)
   {
      if (json != null && Field889 != null)
      {
         for(int i = 0; i < json.Count(); i++)
         {
            JSONArray ja = json.optJSONArray(i);
            if (ja != null)
            {
               try
               {
                  Field889.ProcessUpdates(ja);
               }
               catch (Exception ex)
               {
               }
            }
         }

      }
   }
}
