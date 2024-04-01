package ru.curoviyxru.phoenix.midlet;


//import Class190;
import Class198;
import Class246;
import Class278;
import LongPollInstanse;
//import Class402;
import Class432;
import Class455;
import Logger;
import Settings;
import javax.microedition.midlet.MIDlet;

public class Midlet extends MIDlet /*implements Class402*/ {
   public static Midlet Instance;
   private boolean _loaded;
   public boolean IsPaused;

   protected void startApp() {
      Instance = this;
      //
      Class278.Field877 = new Class432();
      Class278.Field878 = new Class455();
      Settings.Instance = new Settings();
      Settings.Instance.Initialize();
      //
      LongPollInstanse.IsAppPaused = this.IsPaused = false;
      if (Class198.Instance != null) {
         Class198.Instance.Field688 = 0;
      }

      if (!this._loaded) {
    	  /*
         try {
            this.Version = this.getAppProperty("MIDlet-Version");
         } catch (Exception var4) {
            this.Version = "3.0.0";
         }

         try
         {
            Settings.Instance.HasEmoji = this.getAppProperty("VK4ME-Has-Emojis").toLowerCase().equals("true");
         }
         catch (Exception var3)
         {
            Settings.Instance.SetBool(Settings.HasEmoji,false);
         }
*/
         try {
            
            //Class190.Field607 = new Logger();
            //Class190.Field608 = this;
            LongPollInstanse.Field889 = new Class246();
            new Class198();
            //this.SettingsInstanse = new Settings();
            Class198.Instance.Method472();
            this._loaded = true;
         } catch (Exception var2) {
            Logger.PrintErrorWithMessage(var2);
         }
      }
   }

   protected void pauseApp() {
      this.IsPaused = true;
      //if (Settings.Instanse.SetOffline && Class190.Field603 != null) {
      //   Class190.Field603.Method36();
      //}

      if (!Settings.Instance.SleepWithTimeout)
      {
         LongPollInstanse.IsAppPaused = true;
      }

   }

   protected void destroyApp(boolean var1) {
      if (Settings.Instance != null) {
         //if (Settings.Instanse.SetOffline && Class190.Field603 != null) {
         //   Class190.Field603.Method36();
         //}

         Settings.Instance.Save();
      }

   }

   public final void Method444() {
      this.destroyApp(false);
      this.notifyDestroyed();
   }
   /*
   public final void SaveTokenToStore() {
      if (this.SettingsInstanse != null && Class190.Field603 != null) {
         this.SettingsInstanse.Token = Class190.Field603.Token;
         this.SettingsInstanse.SaveToken();
      }

   }

*/
   public static void Method445(String var0) {
      try {
         if (var0 != null) {
            Instance.platformRequest(var0);
         }

      } catch (Exception var1) {
      }
   }
}
