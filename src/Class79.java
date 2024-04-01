final class Class79 extends Button {
   private final SettingsBehaviorForm Field225;

   Class79(SettingsBehaviorForm var1, String var2, byte var3, SettingsPage var4) {
      super(var2, (byte)2);
      this.Field225 = var1;
   }

   public final void CommandExecuted() {
      (new NetworkForm(this.Field225)).Method361(this.Field225);
   }
}
