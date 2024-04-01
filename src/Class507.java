import ru.curoviyxru.phoenix.midlet.Midlet;

final class Class507 extends Button {
   Class507(SettingsBehaviorForm var1, String var2, byte var3, Class425 var4) {
      super(var2, (byte)1);
   }

   public final void ButtonPressed() {
      Settings.Instance.Field407 = this.GetIsChecked();
   }
}
