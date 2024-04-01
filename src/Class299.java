final class Class299 extends Button {
   private final boolean _showToken;
   private final SettingsPage Field931;

   Class299(SettingsPage var1, String var2, byte var3, boolean showToken) {
      super(var2, (byte)2);
      this.Field931 = var1;
      this._showToken = showToken;
   }

   public final void CommandExecuted() {
      (new SettingsBehaviorForm(this.Field931, this._showToken)).Method361(this.Field931);
   }
}
