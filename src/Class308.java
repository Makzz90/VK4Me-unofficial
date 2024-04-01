final class Class308 extends Button {
   private final boolean Field940;
   private final SettingsPage Field941;

   Class308(SettingsPage var1, String var2, byte var3, boolean var4) {
      super(var2, (byte)3);
      this.Field941 = var1;
      this.Field940 = var4;
   }

   public final void CommandExecuted() {
      (new AboutForm(this.Field941, this.Field940)).Method361(this.Field941);
   }
}
