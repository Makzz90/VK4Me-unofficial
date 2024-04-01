

final class Class323 extends Button {
   private final NetworkForm Field948;

   Class323(NetworkForm var1, String var2, byte var3, SettingsBehaviorForm var4) {
      super(var2, (byte)1);
      this.Field948 = var1;
   }

   public final void CommandExecuted() {
      Settings.Instance.NetworkMode = 1;
      Class198.Instance.NavigateBack(NetworkForm.Method200(this.Field948));
      Button var10000 = NetworkForm.Method200(this.Field948)._btnNetworkMode;
      String var2 = Localized.GetString(Settings.Instance.NetworkMode == 1 ? "settings.https" : (Settings.Instance.NetworkMode == 2 ? "settings.custom" : (Settings.Instance.NetworkMode == 3 ? "settings.openvkHttp" : (Settings.Instance.NetworkMode == 4 ? "settings.openvkHttps" : "settings.http"))));
      //String var1 = "settings.currentMode";
      var10000.SetSubtitle(Localized.Method398("settings.currentMode", var2, null));
      if (Settings.Instance.IsAutorized()) {
         Settings.Instance.ApplyUrls();
      } else {
         Class198.Instance.ShowError(Localized.GetString("error.proxyRestartRequired"));
      }
   }
}
