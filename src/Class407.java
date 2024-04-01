final class Class407 extends Class446 {
   private final boolean Field1150;

   Class407(String var1, boolean var2, boolean var3) throws Exception{
      super(var1, true);
      this.Field1150 = var3;
   }

   public final void LoadData() {
      Class198.Instance.SetInLoadingState(true);
      if (this.next_from == null) {
         this.next_from = new Integer(-1);
      }

      this.next_from = new Integer(((Integer)this.next_from).intValue() + 1);
      Class170 var1;
      if ((var1 = (Class170)(new Class263(5, ((Integer)this.next_from).intValue() * 5, this.Field1150)).DoDispatch()) != null && var1.Field571 != null && var1.Field571.length > 0) {
         if (var1.Field571.length < 5) {
            this.IsAllLoaded = true;
         }

         for(int i = 0; i < var1.Field571.length; i++) {
            VKUser var3 = var1.Field571[i];
            this.AddElement(LoginForm.GetHeaderElement(var3, false, false, true, false, this));
         }
      } else {
         this.IsAllLoaded = true;
         if (var1 == null) {
            Class198.Instance.ShowError(Localized.GetString("general.loadError"));
         }
      }

      Class198.Instance.SetInLoadingState(false);
   }
}
