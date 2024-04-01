
final class Class147 extends Button {
   Class147(String var2, byte var3) {
      super(var2, (byte)1);
   }

   public final void ButtonPressed() {
      Settings.Instance.GuiShowFooter = this.GetIsChecked() /*|| Settings.Instance.GuiFullscreen || Settings.Instance.GuiTouchHud*/;
      //this.IsChecked = (short)(Settings.Instance.GuiShowFooter ? 1 : 0);
      Class198.Instance.Method464(false);
      //if (Settings.Instance.GuiFullscreen || Settings.Instance.GuiTouchHud) {
      //   Class198.Field618.ShowError(Localized.GetString("error.disableFullscreenTouch"));
      //}

   }
}
