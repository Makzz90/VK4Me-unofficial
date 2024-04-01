import ru.curoviyxru.phoenix.midlet.Midlet;

final class Class86 implements Runnable {
   Class86(Class322 var1) {
   }

   public final void run() {
      if (!Settings.Instance.IsAutorized()) {
         Settings.Instance.ApplyUrls();
      } else {
         Class198.Instance.ShowError(Localized.GetString("error.proxyRestartRequired"));
      }
   }
}
