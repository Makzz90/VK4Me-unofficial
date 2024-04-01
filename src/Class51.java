import ru.curoviyxru.phoenix.midlet.Midlet;

final class Class51 extends Button {
   private final VKGroup Field151;

   Class51(Class360 var1, String var2, byte var3, VKGroup var4) {
      super(var2, (byte)2);
      this.Field151 = var4;
   }

   public final void CommandExecuted() {
      Midlet.Method445(this.Field151.site);
   }
}
