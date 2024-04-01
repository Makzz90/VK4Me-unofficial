

final class Class144 extends Button {
   private final Button Field532;
   private final Button Field533;

   Class144(SettingsInterfaceForm var1, String var2,  Button var5, Button var6) {
      super(var2, (byte)1);
      this.Field532 = var5;
      this.Field533 = var6;
   }

   public final void ButtonPressed() {
      Settings.Instance.GuiTouchHud =this.GetIsChecked();
      this.Field532.IsChecked = (short)(!Settings.Instance.GuiShowFooter && !Settings.Instance.GuiFullscreen && !Settings.Instance.GuiTouchHud ? 0 : 1);
      this.Field533.IsChecked = (short)(!Settings.Instance.GuiShowHeader && !Settings.Instance.GuiFullscreen && !Settings.Instance.GuiTouchHud ? 0 : 1);
      Class198.Instance.Method464(false);
   }
}
