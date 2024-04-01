import ru.curoviyxru.phoenix.midlet.Midlet;

final class Class398 extends Class28 {
   private final VKVideo Field1141;

   Class398(AttachmentItemUC var1, String var2, VKVideo var3) {
      super(var2);
      this.Field1141 = var3;
   }

   public final void CommandExecuted() {
      Class198.Instance.Method487();

      try {
         if (Class366.Method272(Midlet.Instance, "JTube", "nnproject", "0xAFCE0816", 1260, "url=" + Page.Method374(this.Field1141.Field1114))) {
            Midlet.Instance.Method444();
         }

      } catch (Class110 var2) {
         Class198.Instance.ShowError(Localized.GetString("error.jtubeError"));
      } catch (Class55 var3) {
         Class198.Instance.ShowError("Launching protocol is not supported!");
      } catch (Exception var4) {
         Class198.Instance.ShowError(var4);
      }
   }
}
