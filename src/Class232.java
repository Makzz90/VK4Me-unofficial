import ru.curoviyxru.phoenix.midlet.Midlet;

final class Class232 extends Button {
   Class232(AboutForm var1, String var2, byte var3, SettingsPage var4) {
      super(var2, (byte)2);
   }

   public final void CommandExecuted() {
      Midlet.Method445("http://vk4me.crx.moe/next/latest" + (Settings.Instance.HasEmoji ? "-emoji" : "") + ".jad");
   }
}