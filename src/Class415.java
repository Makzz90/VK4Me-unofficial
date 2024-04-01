final class Class415 extends Class28 {
   private final VKVideo Field1164;
   private final AttachmentItemUC Field1165;

   Class415(AttachmentItemUC var1, String var2, VKVideo var3) {
      super(var2);
      this.Field1165 = var1;
      this.Field1164 = var3;
   }

   public final void CommandExecuted() {
      Class198.Instance.Method487();
      this.Field1165.Method218(this.Field1164, this.Field1164.Field1116, "720p");
   }
}
