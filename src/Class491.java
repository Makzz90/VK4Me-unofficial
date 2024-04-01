final class Class491 extends Class28 {
   private final VKVideo Field1339;
   private final String Field1340;
   private final String Field1341;
   private final AttachmentItemUC Field1342;

   Class491(AttachmentItemUC var1, String var2, VKVideo var3, String var4, String var5) {
      super(var2);
      this.Field1342 = var1;
      this.Field1339 = var3;
      this.Field1340 = var4;
      this.Field1341 = var5;
   }

   public final void CommandExecuted() {
      Class198.Instance.Method487();
      this.Field1342.Method219(true, this.Field1339, this.Field1340, this.Field1341);
   }
}
