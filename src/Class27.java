import ru.curoviyxru.phoenix.midlet.Midlet;

final class Class27 implements Runnable {
   Class27(Class325 var1) {
   }

   public final void run() {
      if (Settings.Instance.IsAutorized()) {
         Settings.Instance.ApplyUrls();
      } else {
         Class198.Instance.ShowError(Localized.GetString("error.proxyRestartRequired"));
      }
   }
}
