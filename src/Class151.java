final class Class151 extends Button {
   private final Class442 Field540;

   Class151(Class442 var1, String var2, byte var3, SettingsPage var4) {
      super(var2, (byte)2);
      this.Field540 = var1;
   }

   public final void CommandExecuted() {
      (new ThemesForm(this.Field540)).Method361(this.Field540);
   }
}
