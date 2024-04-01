final class Class209 extends Button {
   private final Class467 Field704;

   Class209(Class467 var1, String var2, byte var3) {
      super(var2, (byte)3);
      this.Field704 = var1;
   }

   public final void CommandExecuted() {
      try {
		LoginForm.Method258(this.Field704, this.Field704.Field1289.GetId());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}
