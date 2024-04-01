final class Class135 extends Button {
   Class135(String var1, byte var2) {
      super(var1, (byte)2);
   }

   public final void CommandExecuted() {
      try {
		LoginForm.Method254(LoginForm.HomePage, Class31.GetUser(0L));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}
