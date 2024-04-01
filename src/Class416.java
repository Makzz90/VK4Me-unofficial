final class Class416 extends Class28 {
   private final VKVideo Field1166;
   private final AttachmentItemUC Field1167;

   Class416(AttachmentItemUC var1, String var2, VKVideo var3) {
      super(var2);
      this.Field1167 = var1;
      this.Field1166 = var3;
   }

   public final void CommandExecuted() {
      Class198.Instance.Method487();
      this.Field1167.Method218(this.Field1166, this.Field1166.Field1115, "1080p");
   }
}
