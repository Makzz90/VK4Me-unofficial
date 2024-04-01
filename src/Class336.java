import java.io.InputStream;
import javax.microedition.lcdui.Command;

public class Class336 {
   Command Field971;
   String Field972;
   int Field973;
   String Field974;
   private boolean Field975;

   public Class336(String var1) {
      this(var1, false);
   }

   public Class336(String var1, boolean var2) {
      this.Field975 = var2;
      this.Method133(var1);
   }

   public final void Method133(String var1) {
      this.Field972 = var1 == null ? null : var1.intern();
      this.Field971 = var1 == null ? null : new Command(var1, this.Field975 ? 2 : 1, 1);
      this.Field974 = null;
      this.Field973 = 0;
   }

   public void Method134() {
   }

   public Class336() {
   }

   public static VKPhoto Method135(long var0, String var2, long var3, InputStream var5, Class80 var6) throws Exception {
      Class183 var7;
      if ((var7 = (Class183)(new Class245(var0)).DoDispatch()) != null && !Class183.IsStringEmpty(var7.upload_url)) {
         String var8 = Class278.Method375(var7.upload_url, "photo", var2, var3, var5, var6);
         JSONObject var9 = new JSONObject(var8);
         Class210 var10;
         if ((var10 = (Class210)(new Class59(var9.optGetString("photo"), var9.optLong("server"), var9.optGetString("hash"))).DoDispatch()) != null) {
            return var10.Field705;
         }
      }

      return null;
   }

   public static VKAttachment Method136(long var0, String var2, long var3, InputStream var5, Class80 var6) throws Exception{
      Class154 var7;
      if ((var7 = (Class154)(new Class380(var0)).DoDispatch()) != null && !Class154.IsStringEmpty(var7.Field542)) {
         String var8 = Class278.Method375(var7.Field542, "file", var2, var3, var5, var6);
         JSONObject var9 = new JSONObject(var8);
         Class364 var10;
         if ((var10 = (Class364)(new Class284(var9.optGetString("file"))).DoDispatch()) != null) {
            return var10.Field1052;
         }
      }

      return null;
   }
}
