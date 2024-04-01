
public final class NetworkForm extends Page {
   private final SettingsBehaviorForm Field1043;

   private NetworkForm(SettingsBehaviorForm var1, byte var2) {
      super(Localized.GetString("title.networkMode"));
      this.Field1043 = var1;
      int temp = Settings.Instance.NetworkMode;
      this.AddElement((new Class322(this, Localized.GetString("settings.httpByVK4MEMode"), (byte)1, var1)).Method115(temp == 5).TurnBottomLine(true));
      this.AddElement((new Class323(this, Localized.GetString(  "settings.httpsByVKMode"), (byte)1, var1)).Method115(temp == 1).TurnBottomLine(true));
      this.AddElement((new Class324(this, Localized.GetString("settings.httpByOpenvk"), (byte)1, var1)).Method115(temp == 3).TurnBottomLine(true));
      this.AddElement((new Class325(this, Localized.GetString(  "settings.httpsByOpenvk"), (byte)1, var1)).Method115(temp == 4).TurnBottomLine(true));
      this.AddElement((new Class326(this, Localized.GetString(  "settings.httpsByCustomMode"), (byte)1, var1)).Method115(temp == 2).TurnBottomLine(true));
      this.AddElement((new Class327(this, Localized.GetString("settings.httpByProxy"), (byte)1, var1)).Method115(temp == 6).TurnBottomLine(true));
      this.AddElement((new Class329(this, Localized.GetString("settings.httpByProxyAndAPI"), (byte)1, var1)).Method115(temp == 7).TurnBottomLine(true));
      TextBox2 var4 = new TextBox2(Localized.GetString("settings.customPROXY"), Settings.Instance.CustomPROXY);
      this.AddElement(var4);
      TextBox2 var7 = new TextBox2(Localized.GetString("settings.customAPI"), Settings.Instance.CustomAPI);
      this.AddElement(var7);
      TextBox2 var3= new TextBox2(Localized.GetString("settings.customAUTH"), Settings.Instance.CustomAUTH);
      this.AddElement(var3);
      this.AddElement((new Class321(this, Localized.GetString("settings.saveAPIs"), var1, var4, var7, var3)).TurnBottomLine(true));
      TextBlock var10001 = new TextBlock(Localized.GetString("element.proxyDisclaimer"));
      //byte var8 = 1;
      TextBlock var6 = var10001;
      var10001.Field1199 = 1;
      this.AddElement(var6.Method55(Class6.ColorsInstanse.Field294).Method157(false));
      var10001 = new TextBlock(Localized.GetString("element.openvkDisclaimer"));
      //var8 = 1;
      var6 = var10001;
      var10001.Field1199 = 1;
      this.AddElement(var6.Method55(Class6.ColorsInstanse.Field294).Method157(false));

      try {
         if (!Class377.Method302()) {
            throw new IllegalStateException("No HTTPS.");
         }
      } catch (Throwable var5) {
         var10001 = new TextBlock(Localized.GetString("settings.httpsNotSupportedDisclaimer"));
         //var8 = 1;
         var6 = var10001;
         var10001.Field1199 = 1;
         this.AddElement(var6.Method55(Class6.ColorsInstanse.Field294).Method157(false));
      }

      Class198.Instance.NavigateForward(this);
   }

   NetworkForm(SettingsBehaviorForm var1) {
      this(var1, (byte)0);
   }

   static SettingsBehaviorForm Method200(NetworkForm var0) {
      return var0.Field1043;
   }
}
