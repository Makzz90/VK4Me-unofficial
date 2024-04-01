final class Class404 extends Class28 {
   private final Class446 Field1147;

   Class404(String var1, Class446 var2) {
      super(var1);
      this.Field1147 = var2;
   }

   public final void CommandExecuted() {
      Class198.Instance.Method487();
      try {
		LoginForm.Method257(this.Field1147, true);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}
