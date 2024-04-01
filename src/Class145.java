

final class Class145 extends Class336 {
   private final Page Field534;
   private final Page Field535;

   Class145(Page var1, String var2, boolean var3, Page var4) {
      super(var2, true);
      this.Field535 = var1;
      this.Field534 = var4;
   }

   public final void Method134() {
      if (Settings.Instance.GuiUseDrawer && Settings.Instance.GuiTouchHud && LoginForm.HomePage != null) {
         if (Class198.Instance._page == null) {
            if (LoginForm.HomePage != null) {
               Class198.Instance.NavigateBack(LoginForm.HomePage.Method361(this.Field535));
            }

            Class198.Instance._page = this.Field535;
         } else {
            Class198.Instance.NavigateForward(Class198.Instance._page);
            if (LoginForm.HomePage != null) {
               LoginForm.HomePage.Method361(null);
            }

            Class198.Instance._page = null;
         }
      } else {
         if (LoginForm.HomePage != null) {
            LoginForm.HomePage.Method361(null);
         }

         Class198.Instance.NavigateBack(this.Field534);
      }
   }
}
