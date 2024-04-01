final class Class382 extends Button {
   Class382(String var1, byte var2) {
      super(var1, (byte)3);
   }

   public final void CommandExecuted()  {
      Page var1 = LoginForm.HomePage;
      Class446 var2 = (Class446)(new DocumentsPage(Localized.GetString("title.docs"), true)).Method361(var1);
      Class198.Instance.NavigateForward(var2);
   }
}
