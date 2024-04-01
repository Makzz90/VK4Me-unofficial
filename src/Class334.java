import ru.curoviyxru.phoenix.midlet.Midlet;

final class Class334 extends Button {
   Class334(Class442 var1, String var2, byte var3, Class425 var4) {
      super(var2, (byte)1);
   }

   public final void ButtonPressed() {
      Settings.Instance.ShowCmtFieldByOpen = this.GetIsChecked();
   }
}
