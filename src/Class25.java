

final class Class25 extends Class288 {
   private final TextBlock _tb;

   Class25(SettingsBehaviorForm var1, int var2, SettingsPage var3, TextBlock var4) {
      super(var2);
      this._tb = var4;
   }

   public final void Method1(long value) {
      
      int temp = (int)(value + 1L);
      Settings.Instance.LpSpeed = temp;
      
      String var2 = (temp) + " " + Localized.GetString("general.secs");
      
      this._tb.Method57(Localized.Method398("settings.longpollSpeed", var2, null));
      Settings.Instance.Method129();
   }
}
