import ru.curoviyxru.phoenix.midlet.Midlet;

final class Class228 extends Button {
   private final Class197 Field731;

   Class228(Class197 var1, String var2, byte var3, SettingsBehaviorForm var4) {
      super(var2, (byte)1);
      this.Field731 = var1;
   }

   public final void CommandExecuted() {
      Settings.Instance.DownloadMode = 0;
      Class198.Instance.NavigateBack(Class197.Method501(this.Field731));
      Button var10000 = Class197.Method501(this.Field731)._btnDownloadMode;
      String var2 = Localized.GetString(Settings.Instance.DownloadMode == 1 ? "settings.downloadFile" : (Settings.Instance.DownloadMode == 2 ? "settings.openBrowser" : "settings.askEverytime"));
      String var1 = "settings.currentMode";
      var10000.SetSubtitle(Localized.Method398("settings.currentMode", var2, null));
   }
}
