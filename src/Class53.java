import ru.curoviyxru.phoenix.midlet.Midlet;

final class Class53 extends Button {
   private final VKUser Field153;

   Class53(Class360 var1, String var2, byte var3, VKUser var4) {
      super(var2, (byte)2);
      this.Field153 = var4;
   }

   public final void CommandExecuted() {
      Midlet.Method445(this.Field153.Field144);
   }
}
