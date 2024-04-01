import ru.curoviyxru.phoenix.midlet.Midlet;

final class Class7 implements Runnable {
   Class7(Class324 var1) {
   }

   public final void run() {
      if (!Settings.Instance.IsAutorized()) {
         Settings.Instance.ApplyUrls();
      } else {
         Class198.Instance.ShowError(Localized.GetString("error.proxyRestartRequired"));
      }
   }
}
