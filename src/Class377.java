import java.io.OutputStream;
import javax.microedition.io.file.FileConnection;
import javax.microedition.media.Manager;

public final class Class377 {
   private static String Field1106;
   private static Boolean Field1107;

   public static String Method301() {
	    if (Field1106 != null)
	      return Field1106; 
	    try {
	      String[] arrayOfString = Manager.getSupportedContentTypes(null);
	      for (byte b = 0; b < arrayOfString.length; b++) {
	        if (arrayOfString[b] != null && arrayOfString[b].toLowerCase().equals("audio/mp3"))
	          return Field1106 = "audio/mp3"; 
	      } 
	    } catch (Exception exception) {}
	    return Field1106 = "audio/mpeg";
	  }

   public static boolean Method302()
   {
	    if (Field1107 != null)
	      return Field1107.booleanValue(); 
	    try
	    {
	      String[] arrayOfString = Manager.getSupportedProtocols(null);
	      for (byte b = 0; b < arrayOfString.length; b++)
	      {
	        if (arrayOfString[b] != null && arrayOfString[b].toLowerCase().indexOf("https") != -1)
	          return (Field1107 = Boolean.TRUE).booleanValue(); 
	      } 
	    } catch (Exception exception) {}
	    return (Field1107 = Boolean.FALSE).booleanValue();
	  }

   public static long Method303(String var0, Object var1, Class80 var2, int var3) throws Exception {
      Class198.Instance.SetInLoadingState(true);

      try {
         byte var4 = 0;
         FileConnection var16;
         if (!(var16 = (FileConnection)var1).exists()) {
            var16.create();
         }

         OutputStream var5 = var16.openOutputStream();
         Class58 var6 = new Class58(var2);
         long var13 = Class278.Field877.Method53(var0, var5, var6, var4);
         if (var6.Field464 != null) {
            throw new Exception(var6.Field464);
         } else {
            if (var2 != null) {
               var2.Method1(100L);
            }

            long var17 = Math.max(var16.fileSize(), var13);
            if (var2 != null) {
               if (var17 != 0L) {
                  var2.Method72();
               } else {
                  var2.Method27("Download failed.");
               }
            }

            Class198.Instance.SetInLoadingState(false);
            return var17;
         }
      } catch (Exception var15) {
         if (var2 != null) {
            var2.Method27(var15.toString());
         }

         Class198.Instance.SetInLoadingState(false);
         throw var15;
      }
   }
}
