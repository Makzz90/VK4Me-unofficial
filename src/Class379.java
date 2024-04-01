final class Class379 extends Button {
   Class379(String lable, byte var2) {
      super(lable, (byte)0);
   }

   public final void CommandExecuted() {
      Page var1 = LoginForm.HomePage;
      Class198.Instance.NavigateForward((new NewsfeedPage()).Method361(var1));
   }
}
