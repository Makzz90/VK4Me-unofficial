import ru.curoviyxru.phoenix.midlet.Midlet;

final class Class23 extends Button {
   Class23(SettingsBehaviorForm var1, String var2, byte var3, Class425 var4) {
      super(var2, (byte)1);
   }

   public final void ButtonPressed() {
      Settings.Instance.Field395 = this.GetIsChecked();
   }
}
