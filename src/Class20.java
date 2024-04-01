final class Class20 extends Button {
   private final TextBlock Field39;
   private final Class288 Field40;
   private final SettingsBehaviorForm Field41;

   Class20(SettingsBehaviorForm var1, String var2, SettingsPage var3, TextBlock var4, Class288 var5) {
      super(var2);
      this.Field41 = var1;
      this.Field39 = var4;
      this.Field40 = var5;
   }

   public final void CommandExecuted() {
      this.Field41.Method379(this.Field40, false);
   }
}
