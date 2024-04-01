import java.io.DataInputStream;
import java.io.IOException;

public final class ApplicationTheme {
   public String Name = "null";
   public String Version = "0.0.1";

   public final void Method512(DataInputStream var1) throws IOException {
      StringBuffer sb = new StringBuffer();

      int len;
      while((len = var1.read()) != 10) {
         sb.append((char)len);
      }

      if (!sb.toString().trim().equals("VK4ME Theme")) {
         throw new IllegalArgumentException("This is not a theme");
      } else {
         sb.setLength(0);

         while((len = var1.read()) != 10) {
            sb.append((char)len);
         }

         this.Name = sb.toString().trim();
         sb.setLength(0);

         while((len = var1.read()) != 10) {
            sb.append((char)len);
         }

         this.Version = sb.toString().trim();
      }
   }
}
