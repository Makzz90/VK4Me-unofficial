final class Class414 extends Class28 {
   private final VKVideo Field1162;
   private final AttachmentItemUC Field1163;

   Class414(AttachmentItemUC var1, String var2, VKVideo var3) {
      super(var2);
      this.Field1163 = var1;
      this.Field1162 = var3;
   }

   public final void CommandExecuted() {
      Class198.Instance.Method487();
      this.Field1163.Method218(this.Field1162, this.Field1162.Field1117, "480p");
   }
}
