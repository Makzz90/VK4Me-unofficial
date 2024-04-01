

final class Class153 extends Button {
   Class153(SettingsInterfaceForm var1, String var2, byte var3, SettingsPage var4) {
      super(var2, (byte)1);
   }

   public final void ButtonPressed() {
      Settings.Instance.GuiShowHeader = this.GetIsChecked() || Settings.Instance.GuiFullscreen || Settings.Instance.GuiTouchHud;
      this.IsChecked = (short)(Settings.Instance.GuiShowHeader ? 1 : 0);
      Class198.Instance.Method464(false);
      if (Settings.Instance.GuiFullscreen || Settings.Instance.GuiTouchHud) {
         Class198.Instance.ShowError(Localized.GetString("error.disableFullscreenTouch"));
      }

   }
}
