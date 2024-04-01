final class Class300 extends Button {
   private final SettingsPage Field932;

   Class300(SettingsPage var1, String var2, byte var3) {
      super(var2, (byte)2);
      this.Field932 = var1;
   }

   public final void CommandExecuted() {
      (new SettingsInterfaceForm(this.Field932)).Method361(this.Field932);
   }
}
