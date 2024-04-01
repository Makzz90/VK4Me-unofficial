

final class Class305 extends Class288 {
   private final TextBlock Field937;

   Class305(SettingsPage var1, int var2, TextBlock var3) {
      super(var2);
      this.Field937 = var3;
   }

   public final void Method1(long var1) {
      TextBlock var10000 = this.Field937;
      String var2 = (Settings.Instance.Brightness = (int)var1) == 0 ? Localized.GetString("element.system") : (Settings.Instance.Brightness = (int)var1) + "";
      String var3 = "settings.brightness";
      var10000.Method57(Localized.Method398("settings.brightness", var2, null));
      Settings.Instance.Method129();
   }
}
