final class Class347 extends Button {
   private final Page _page;
   private final VKGroupOrUser _owner;

   Class347(String title, Page var2, VKGroupOrUser var3) {
      super(title);
      this._page = var2;
      this._owner = var3;
   }

   public final void CommandExecuted() {
      LoginForm.Method254(this._page == null ? LoginForm.HomePage : this._page, this._owner);
   }
}
