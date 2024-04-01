

public final class Class197 extends Page {
   private final SettingsBehaviorForm Field615;

   private Class197(SettingsBehaviorForm var1, byte var2) {
      super(Localized.GetString("title.downloadMode"));
      this.Field615 = var1;
      this.AddElement((new Class228(this, Localized.GetString("settings.askEverytime"), (byte)1, var1)).Method115(Settings.Instance.DownloadMode == 0).TurnBottomLine(true));
      this.AddElement((new Class221(this, Localized.GetString("settings.downloadFile"), (byte)1, var1)).Method115(Settings.Instance.DownloadMode == 1).TurnBottomLine(true));
      this.AddElement((new Class223(this, Localized.GetString("settings.openBrowser"), (byte)1, var1)).Method115(Settings.Instance.DownloadMode == 2).TurnBottomLine(true));
      Class198.Instance.NavigateForward(this);
   }

   Class197(SettingsBehaviorForm var1) {
      this(var1, (byte)0);
   }

   static SettingsBehaviorForm Method501(Class197 var0) {
      return var0.Field615;
   }
}
