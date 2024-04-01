final class Class310 extends Button {
   private final SettingsPage Field943;

   Class310(SettingsPage var1, String var2, byte var3) {
      super(var2, (byte)2);
      this.Field943 = var1;
   }

   public final void CommandExecuted() {
      (new LocalizationPage(this.Field943)).Method361(this.Field943);
   }
}
