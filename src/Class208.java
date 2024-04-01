final class Class208 extends Button {
   private final Class467 Field703;

   Class208(Class467 var1, String var2, byte var3) {
      super(var2, (byte)3);
      this.Field703 = var1;
   }

   public final void CommandExecuted() {
      try {
		LoginForm.Method259(this.Field703, this.Field703.Field1289.GetId());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}
