final class Class413 extends Class28 {
   private final VKVideo Field1160;
   private final AttachmentItemUC Field1161;

   Class413(AttachmentItemUC var1, String var2, VKVideo var3) {
      super(var2);
      this.Field1161 = var1;
      this.Field1160 = var3;
   }

   public final void CommandExecuted() {
      Class198.Instance.Method487();
      this.Field1161.Method218(this.Field1160, this.Field1160.Field1118, "360p");
   }
}
