
final class Class8 extends Button {
   private final SettingsBehaviorForm Field17;

   Class8(SettingsBehaviorForm var1, String var2, SettingsPage var3) {
      super(var2);
      this.Field17 = var1;
   }

   public final void CommandExecuted() {
      if (!Settings.Instance.LoggerEnabled) {
         Class198.Instance.ShowError(Localized.GetString("settings.logDisabled"));
      } else {
         Class198.Instance.NavigateForward(new Class335(this, true, this.Field17));
      }
   }

   static SettingsBehaviorForm Method333(Class8 var0) {
      return var0.Field17;
   }
}
