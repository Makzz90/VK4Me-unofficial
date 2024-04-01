

public final class SettingsPage extends Page {
   private static boolean isUpdateAvaliable = false;
   //public static String Field1189 = null;

   public SettingsPage(boolean isAutorized) {
      super(Localized.GetString("title.settings"));
      this.AddElement((new Class300(this, Localized.GetString("element.interface"), (byte)2)).SetRleIcon("new/image.rle").TurnBottomLine(true));
      this.AddElement((new Class299(this, Localized.GetString("element.behavior"), (byte)2, isAutorized)).SetRleIcon("new/widgets.rle").TurnBottomLine(true));
      this.AddElement((new Class310(this, Localized.GetString("element.localization"), (byte)2)).SetRleIcon("new/translate.rle"));
      this.AddElement(new OffsetElementUI());
      Button var2= (Button)(new Class308(this, Localized.GetString("element.aboutApp"), (byte)3, isAutorized)).SetRleIcon("new/information.rle").Method96(true).TurnBottomLine(true);
//      this.AddElement(var2);
      if (isUpdateAvaliable)
      {
         var2.SetContent(Localized.GetString("event.updateAvaliable"));
      }

      if (isAutorized) {
         this.AddElement((new Class307(this, Localized.GetString("action.logOut"))).Method109(true).SetRleIcon("new/exit-to-app.rle").TurnBottomLine(true));
      }

      TextBlock var10;
      /*
      try {
         if (Class.forName("com.nokia.mid.ui.DeviceControl") != null) {
            String var6 = Settings.Instance.Brightness == 0 ? Localized.GetString("element.system") : Settings.Instance.Brightness + "";
            //String var9 = "settings.brightness";
            var10 = (TextBlock)(new TextBlock(Localized.Method398("settings.brightness", var6, null))).Method157(true);
            this.AddElement(var10);
            Class305 var11 = new Class305(this, Settings.Instance.Brightness, var10);
            //long var13 = 100L;
            //Class305 var11 = var10000;
            var11.Field1074 = 100L;
            Class288 var12 = (Class288)var11;
            this.AddElement(var12);
         } else {
            Settings.Instance.Brightness = 0;
            Settings.Instance.Method129();
         }
      } catch (Throwable var8) {
         Settings.Instance.Brightness = 0;*/
         Settings.Instance.Method129();
      //}

      TextBlock var10001 = new TextBlock(Localized.GetString("element.settingsRestartDisclaimer"));
      byte var14 = 1;
      var10 = var10001;
      var10001.Field1199 = var14;
      this.AddElement(var10.Method55(Class6.ColorsInstanse.Field294).Method157(false));
      Class198.Instance.NavigateForward(this);
   }
}
