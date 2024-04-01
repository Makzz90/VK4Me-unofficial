

final class Class132 extends Button {
   private final TextBox2 _textBox;
   private final PasswordBox _passwordBox;
   private final Button _button;

   Class132(String var1, TextBox2 var2, PasswordBox var3, Button var4) {
      super(var1);
      this._textBox = var2;
      this._passwordBox = var3;
      this._button = var4;
   }

   public final void CommandExecuted() {
      switch(Settings.Instance.NetworkMode) {
      case 1:
         LoginForm.Method251(true, null, null, this._textBox.GetContent(), this._passwordBox.GetContent(), this._button.GetIsChecked(), null);
         return;
      case 2:
      default:
         Class198.Instance.Method484(Localized.GetString("general.caution"), Localized.GetString("element.proxyDisclaimer"), new Class40(this));
         return;
      case 3:
      case 4:
         Class198.Instance.Method484(Localized.GetString("general.caution"), Localized.GetString("element.openvkDisclaimer"), new Class41(this));
      }
   }

   static TextBox2 Method314(Class132 var0) {
      return var0._textBox;
   }

   static PasswordBox Method315(Class132 var0) {
      return var0._passwordBox;
   }

   static Button Method316(Class132 var0) {
      return var0._button;
   }
}
