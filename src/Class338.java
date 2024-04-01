import ru.curoviyxru.phoenix.midlet.Midlet;

final class Class338 extends Button {
   Class338(Class442 var1, String var2, byte var3, Class425 var4) {
      super(var2, (byte)1);
   }

   public final void ButtonPressed() {
      Settings.Instance.Gradients = this.GetIsChecked();
   }
}
