import java.util.Vector;

final class Class302 extends Class28 {
   private final PostFooterUC Field934;

   Class302(PostFooterUC var1, String var2) {
      super(var2);
      this.Field934 = var1;
   }

   public final void CommandExecuted() {
      Class198.Instance.Method487();
      Vector var1;
      (var1 = new Vector()).addElement(this.Field934._post);
      try {
		LoginForm.Method252(this.Field934._page, var1, 3);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}
