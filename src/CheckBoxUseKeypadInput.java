final class CheckBoxUseKeypadInput extends Button {
   CheckBoxUseKeypadInput(SettingsBehaviorForm var1, String var2, byte var3, Class425 var4) {
      super(var2, (byte)1);
   }

   public final void ButtonPressed() {
      Settings.Instance.UseKeypadInput = this.GetIsChecked();
   }
}
