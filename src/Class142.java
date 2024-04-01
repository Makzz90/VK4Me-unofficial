

final class Class142 extends Button {
   private final Button Field528;
   private final Button Field529;

   Class142(SettingsInterfaceForm var1, String var2,   Button var5, Button var6) {
      super(var2, (byte)1);
      this.Field528 = var5;
      this.Field529 = var6;
   }

   public final void ButtonPressed() {
	   Settings.Instance.GuiFullscreen = this.GetIsChecked();
      this.Field528.IsChecked = (short)(!Settings.Instance.GuiShowFooter && !Settings.Instance.GuiFullscreen && !Settings.Instance.GuiTouchHud ? 0 : 1);
      this.Field529.IsChecked = (short)(!Settings.Instance.GuiShowHeader && !Settings.Instance.GuiFullscreen && !Settings.Instance.GuiTouchHud ? 0 : 1);
      Class198.Instance.Method464(false);
      Class198.Instance.Method472();
   }
}
