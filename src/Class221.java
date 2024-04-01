

final class Class221 extends Button {
   private final Class197 Field722;

   Class221(Class197 var1, String var2, byte var3, SettingsBehaviorForm var4) {
      super(var2, (byte)1);
      this.Field722 = var1;
   }

   public final void CommandExecuted() {
      Settings.Instance.DownloadMode = 1;
      Class198.Instance.NavigateBack(Class197.Method501(this.Field722));
      Button var10000 = Class197.Method501(this.Field722)._btnDownloadMode;
      String var2 = Localized.GetString(Settings.Instance.DownloadMode == 1 ? "settings.downloadFile" : (Settings.Instance.DownloadMode == 2 ? "settings.openBrowser" : "settings.askEverytime"));
      
      var10000.SetSubtitle(Localized.Method398("settings.currentMode", var2, null));
   }
}
