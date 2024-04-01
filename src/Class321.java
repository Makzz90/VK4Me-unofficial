

final class Class321 extends Button {
   private final TextBox2 Field944;
   private final TextBox2 Field945;
   private final TextBox2 Field946;

   Class321(NetworkForm var1, String var2, SettingsBehaviorForm var3, TextBox2 var4, TextBox2 var5, TextBox2 var6) {
      super(var2);
      this.Field944 = var4;
      this.Field945 = var5;
      this.Field946 = var6;
   }

   public final void CommandExecuted() {
	   Settings.Instance.CustomPROXY = this.Field944.GetContent();
	   Settings.Instance.CustomAPI = this.Field945.GetContent();
	   Settings.Instance.CustomAUTH = this.Field946.GetContent();
      if (Settings.Instance.IsAutorized())
      {
         Settings.Instance.ApplyUrls();
      } else {
         Class198.Instance.ShowError(Localized.GetString("error.proxyRestartRequired"));
      }

      Settings.Instance.Save();
   }
}
