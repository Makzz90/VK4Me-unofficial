import ru.curoviyxru.phoenix.midlet.Midlet;

final class Class69 extends Button {
   Class69(SettingsBehaviorForm var1, String var2, byte var3, Class425 var4) {
      super(var2, (byte)1);
   }

   public final void ButtonPressed() {
      Settings.Instance.Field428 = this.GetIsChecked();
   }
}
