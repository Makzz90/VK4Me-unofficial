final class Class204 extends Button {
   private final Class467 Field699;

   Class204(Class467 var1, String var2, byte var3) {
      super(var2, (byte)3);
      this.Field699 = var1;
   }

   public final void CommandExecuted() {
      try {
		LoginForm.Method253(this.Field699, this.Field699.Field1289.GetId());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}
