import ru.curoviyxru.phoenix.midlet.Midlet;

final class Class329 extends Button {
   private final NetworkForm Field966;

   Class329(NetworkForm var1, String var2, byte var3, SettingsBehaviorForm var4) {
      super(var2, (byte)1);
      this.Field966 = var1;
   }

   public final void CommandExecuted() {
      Settings.Instance.NetworkMode = 7;
      Class198.Instance.NavigateBack(NetworkForm.Method200(this.Field966));
      Button var10000 = NetworkForm.Method200(this.Field966)._btnNetworkMode;
      String var2 = Localized.GetString(Settings.Instance.NetworkMode == 1 ? "settings.https" : (Settings.Instance.NetworkMode == 2 ? "settings.custom" : (Settings.Instance.NetworkMode == 3 ? "settings.openvkHttp" : (Settings.Instance.NetworkMode == 4 ? "settings.openvkHttps" : "settings.http"))));
      var10000.SetSubtitle(Localized.Method398("settings.currentMode", var2, null));
      Class198.Instance.Method484(Localized.GetString("general.caution"), Localized.GetString("element.proxyDisclaimer"), new Class315(this));
   }
}
