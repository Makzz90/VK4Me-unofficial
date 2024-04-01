

final class Class22 extends Class288 {
   private final TextBlock _tb;

   Class22(SettingsBehaviorForm var1, int var2, SettingsPage var3, TextBlock var4) {
      super(var2);
      this._tb = var4;
   }

   public final void Method1(long value) {
      
      int temp = (int)(value + 10L);
      Settings.Instance.LpsSpeed = temp;
      String var2 = (temp) + " " + Localized.GetString("general.secs");
      
      this._tb.Method57(Localized.Method398("settings.longpollSleepSpeed", var2, null));
      Settings.Instance.Method129();
   }
}
