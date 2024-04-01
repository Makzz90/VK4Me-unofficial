final class Class488 extends Class28 {
   private final VKVideo Field1331;
   private final String Field1332;
   private final String Field1333;
   private final AttachmentItemUC Field1334;

   Class488(AttachmentItemUC var1, String var2, VKVideo var3, String var4, String var5) {
      super(var2);
      this.Field1334 = var1;
      this.Field1331 = var3;
      this.Field1332 = var4;
      this.Field1333 = var5;
   }

   public final void CommandExecuted() {
      Class198.Instance.Method487();
      this.Field1334.Method219(false, this.Field1331, this.Field1332, this.Field1333);
   }
}
