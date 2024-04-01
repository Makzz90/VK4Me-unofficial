final class Class15 extends Button {
   private final TextBlock Field27;
   private final Class288 Field28;
   private final SettingsBehaviorForm Field29;

   Class15(SettingsBehaviorForm var1, String var2, SettingsPage var3, TextBlock var4, Class288 var5) {
      super(var2);
      this.Field29 = var1;
      this.Field27 = var4;
      this.Field28 = var5;
   }

   public final void CommandExecuted() {
      this.Field29.Method379(this.Field28, true);
   }
}
