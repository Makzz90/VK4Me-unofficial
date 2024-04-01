import ru.curoviyxru.phoenix.midlet.Midlet;

final class Class457 implements Runnable {
   Class457(Class327 var1) {
   }

   public final void run() {
      if (Settings.Instance.IsAutorized()) {
         Settings.Instance.ApplyUrls();
      } else {
         Class198.Instance.ShowError(Localized.GetString("error.proxyRestartRequired"));
      }
   }
}
