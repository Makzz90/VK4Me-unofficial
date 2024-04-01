

final class Class83 extends Button {
   Class83(SettingsBehaviorForm var1, String var2, byte var3, SettingsPage var4) {
      super(var2, (byte)1);
   }

   public final void ButtonPressed() {
      Settings.Instance.UseFlushUpload = this.GetIsChecked();
      Settings.Instance.Method129();
   }
}
