

final class Class141 extends Button {
   Class141(SettingsInterfaceForm var1, String var2, byte var3, SettingsPage var4) {
      super(var2, (byte)1);
   }

   public final void ButtonPressed() {
	   Settings.Instance.GuiUseDrawer = this.GetIsChecked();
      if (Settings.Instance.GuiTouchHud) {
         Class198.Instance.Method464(false);
      }

   }
}
