final class Class301 extends Class28 {
   private final PostFooterUC Field933;

   Class301(PostFooterUC var1, String var2) {
      super(var2);
      this.Field933 = var1;
   }

   public final void CommandExecuted()  {
      Class198.Instance.Method487();
      if (!this.Field933._isReposted) {
         this.Field933._isReposted = true;
         Class443 var10000 = new Class443();
         VKNewsfeedPost var2 = this.Field933._post;
         Class443 var1 = var10000;
         var10000.AddParameter("object", var2 == null ? null : var2.toString());
         Class431 var3 = (Class431)var1.DoDispatch();
         this.Field933._isReposted = var3 != null && var3.Field1200;
         if (var3 != null) {
            this.Field933._repostsCount = Class467.Method12(var3.Field1201);
            this.Field933._likesCount = Class467.Method12(var3.Field1202);
         }
      }

   }
}
