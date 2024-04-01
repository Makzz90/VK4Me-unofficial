final class Class150 extends Class28 {
   private final Class240 Field538;
   private final Class64 Field539;

   Class150(Class64 var1, String var2, Class240 var3) {
      super(var2);
      this.Field539 = var1;
      this.Field538 = var3;
   }

   public final void CommandExecuted()  {
      Class293 var10000 = new Class293();
      int var2 = this.Field539.Field163.id;
      long var3 = this.Field539.Field163.owner_id;
      Class293 var1 = var10000;
      var10000.AddLong("owner_id", var3);
      var1.AddIntiger("comment_id", var2);
      Class249 var5 = (Class249)var1.DoDispatch();
      Class198.Instance.Method487();
      if (var5 != null && var5.Method26(this.Field539.Field163.id)) {
         Class240.Method298(this.Field539.Field163.id);
      } else {
         Class198.Instance.ShowError(Localized.GetString("element.deleteError"));
      }
   }
}
