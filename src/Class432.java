import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.io.HttpsConnection;

public final class Class432 implements Class344 {
   public static boolean UseFlush = false;

   public final byte[] Method42(InputStream stream) throws IOException
   {
      if (stream == null) {
         return null;
      } else {
         ByteArrayOutputStream var2 = new ByteArrayOutputStream();
         byte[] var3 = new byte[1024];

         int len;
         while((len = stream.read(var3)) != -1) {
            var2.write(var3, 0, len);
         }

         stream.close();
         byte[] var5 = var2.toByteArray();
         var2.close();
         return var5;
      }
   }

   public final String Method43(String var1) {
      try {
         return new String(this.Method49(var1), Class514.Field1364);
      } catch (Exception var2) {
         Logger.PrintError(var2);
         return null;
      }
   }

   public final Object Method44(String url, boolean var2) throws IOException
   {
	   //https://sun9-44.userapi.com/s/v1/ig2/p4UxGM5u-DJyESezy58m-ROaQR05RGrRrmHoR7ykCsdalWpsLl_NU4ETuTtQYzoqzx6eXbzBDLGc8_QhRBH4_6Mk.jpg?size=100x100&quality=95&crop=51,51,437,437
	   int temp = Settings.Instance.NetworkMode;
	   if(url.toLowerCase().indexOf("https") != -1 && (temp == 1 || temp == 2 || temp == 4))
	   {
		   return this.GetHttpsClient(url, var2, false);
	   }
	   else
	   {
		   return this.GetHttpClient(url, var2, false);
	   }
      
   }
   
   private HttpsConnection GetHttpsClient(String url, boolean noRedirect, boolean paramBoolean2) throws IOException
   {
		HttpsConnection httpsConnection;
		while (true)
		{
			//if (Settings.Instance.GetApiUrl().startsWith("http:") && paramString.startsWith("https:"))
			//	paramString = "http" + paramString.substring(5);
			// Logger.PrintToConsole("[OHC]: " + paramString);
			String proxy = Settings.Instance.ProxyUrl;
			httpsConnection = (HttpsConnection) Connector.open((proxy != null /*&& !paramString.startsWith("http:")*/) ? proxy: url);
			if (proxy != null /*&& !paramString.startsWith("http:")*/)
				httpsConnection.setRequestMethod("POST");
			httpsConnection.setRequestProperty("User-Agent","VKAndroidApp/5.40-3906 (Android 6.0.0; SDK 23; armeabi-v7a; LGE Nexus 5; ru; 1920x1080)");
			
			if (proxy != null && !url.startsWith("http:") && !paramBoolean2)
			{
				String str1 = System.currentTimeMillis() + ""+ System.currentTimeMillis();
				byte[] arrayOfByte1 = ("--" + str1 + "\r\n").getBytes(Class514.Field1364);
				byte[] arrayOfByte2 = ("--" + str1 + "--").getBytes(Class514.Field1364);
				httpsConnection.setRequestProperty("Content-Type","multipart/form-data; charset=UTF-8; boundary=" + str1);
				OutputStream outputStream = httpsConnection.openOutputStream();
				outputStream.write(arrayOfByte1);
				Method52(outputStream, "proxy_link", url);
				outputStream.write(arrayOfByte2);
				outputStream.close();
			}
			String location = httpsConnection.getHeaderField("Location");
			if (noRedirect && location != null)
			{
				httpsConnection.close();
				// paramBoolean1 = paramBoolean1;
				url = location;
				// this = this;
				continue;
			}
			break;
		}
		return httpsConnection;
	}

	private HttpConnection GetHttpClient(String paramString, boolean noRedirect, boolean paramBoolean2) throws IOException {
		HttpConnection httpConnection;
		while (true) {
			if (Settings.Instance.GetApiUrl().startsWith("http:") && paramString.startsWith("https:"))
				paramString = "http" + paramString.substring(5);
			// Logger.PrintToConsole("[OHC]: " + paramString);
			String temp = Settings.Instance.ProxyUrl;
			httpConnection = (HttpConnection) Connector.open((temp != null && !paramString.startsWith("http:")) ? temp: paramString);
			if (temp != null && !paramString.startsWith("http:"))
				httpConnection.setRequestMethod("POST");
			httpConnection.setRequestProperty("User-Agent","VKAndroidApp/5.40-3906 (Android 6.0.0; SDK 23; armeabi-v7a; LGE Nexus 5; ru; 1920x1080)");
			if (temp != null && !paramString.startsWith("http:") && !paramBoolean2) {
				String str1 = System.currentTimeMillis() + ""+ System.currentTimeMillis();
				byte[] arrayOfByte1 = ("--" + str1 + "\r\n").getBytes(Class514.Field1364);
				byte[] arrayOfByte2 = ("--" + str1 + "--").getBytes(Class514.Field1364);
				httpConnection.setRequestProperty("Content-Type","multipart/form-data; charset=UTF-8; boundary=" + str1);
				OutputStream outputStream = httpConnection.openOutputStream();
				outputStream.write(arrayOfByte1);
				Method52(outputStream, "proxy_link", paramString);
				outputStream.write(arrayOfByte2);
				outputStream.close();
			}
			String str = httpConnection.getHeaderField("Location");
			if (noRedirect && str != null)
			{
				httpConnection.close();
				// paramBoolean1 = paramBoolean1;
				paramString = str;
				// this = this;
				continue;
			}
			break;
		}
		return httpConnection;
	}

   public final String Method46(MethodsWithParameters var1) {
      if (var1 == null) {
         return null;
      } else {
         String var2 = var1.toString();
         Logger.PrintToConsole("[REQ]: " + var2);
         var2 = this.Method43(var2);
         Logger.PrintToConsole("[RES]: " + var2);
         return var2;
      }
   }

   public final String Method47(String text) {
      if (text == null) {
         return null;
      } else {
         StringBuffer sb = new StringBuffer();
         char[] var5 = text.toCharArray();

         for(int i = 0; i < var5.length; i++) {
            char ch = var5[i];
            if ('A' <= ch && ch <= 'Z') {
               sb.append((char)ch);
            } else if ('a' <= ch && ch <= 'z') {
               sb.append((char)ch);
            } else if ('0' <= ch && ch <= '9') {
               sb.append((char)ch);
            } else if (ch == ' ') {
               sb.append("%20");
            } else if (ch != '-' && ch != '_' && ch != '.' && ch != '!' && ch != '~' && ch != '*' && ch != '\'' && ch != '(' && ch != ')') {
               if (ch <= 127) {
                  sb.append(IntToHex(ch));
               } else if (ch <= 2047) {
                  sb.append(IntToHex(192 | ch >> 6));
                  sb.append(IntToHex(128 | ch & 63));
               } else {
                  sb.append(IntToHex(224 | ch >> 12));
                  sb.append(IntToHex(128 | ch >> 6 & 63));
                  sb.append(IntToHex(128 | ch & 63));
               }
            } else {
               sb.append((char)ch);
            }
         }

         return sb.toString();
      }
   }

   private static String IntToHex(int var0) {
      String var1 = Integer.toHexString(var0);
      return "%" + (var1.length() < 2 ? "0" : "") + var1;
   }

   private byte[] Method49(String var1) {
      try {
         boolean var3 = true;
         HttpConnection var5 = (HttpConnection)this.GetHttpClient(var1, var3, false);
         InputStream var2 = var5.openInputStream();
         byte[] var6 = this.Method42(var2);
         var5.close();
         return var6;
      } catch (Exception var4) {
         return null;
      }
   }

   public final String UploadFile(String var1, String var2, String var3, long var4, InputStream var6, Class80 var7) throws Exception {
      try {
         Logger.PrintToConsole("[UPL]: " + var1);
         String var8 = System.currentTimeMillis() + "" + System.currentTimeMillis();
         byte[] var9 = ("--" + var8 + "\r\n").getBytes(Class514.Field1364);
         byte[] var10 = ("--" + var8 + "--").getBytes(Class514.Field1364);
         String temp = Settings.Instance.ProxyUrl;
         HttpConnection var11 = (HttpConnection)this.GetHttpClient(var1, false, true);
         if (temp == null || var1.startsWith("http:")) {
            var11.setRequestMethod("POST");
         }

         var11.setRequestProperty("Content-Type", "multipart/form-data; charset=UTF-8; boundary=" + var8);
         OutputStream os = var11.openOutputStream();
         os.write(var9);
         if (temp != null && !var1.startsWith("http:")) {
            this.Method52(os, "proxy_link", var1);
         }

         os.write(var9);
         this.Upload(os, var2, var6, var3, var4, var7);
         os.write(var10);
         os.close();
         InputStream var16 = var11.openInputStream();
         var1 = new String(this.Method42(var16), Class514.Field1364);
         var11.close();
         if (var7 != null) {
            var7.Method1(100L);
         }

         if (var7 != null) {
            if (var1 != null) {
               var7.Method72();
            } else {
               var7.Method27("Upload failed.");
            }
         }

         return var1;
      } catch (Exception ex) {
         if (var7 != null) {
            var7.Method27(ex.toString());
         }

         throw ex;
      }
   }

   private void Upload(OutputStream var1, String fileName, InputStream var3, String var4, long var5, Class80 var7) throws Exception {
      var5 = Math.max(var5, (long)var3.available());
      fileName = "Content-Disposition: form-data; name=\"" + this.Method47(fileName) + "\"; filename=\"" + this.Method47(var4) + "\"\r\n\r\n";
      var1.write(fileName.getBytes(Class514.Field1364));
      byte[] var12 = new byte[2048];
      long var10 = 0L;

      for(int i = 0; i >= 0; i = var3.read(var12)) {
         var10 += (long)i;
         var1.write(var12, 0, i);
         if (UseFlush) {
            var1.flush();
         }

         if (var7 != null) {
            var7.Method1(Math.max(0L, var10 * 100L / var5 - 1L));
         }
      }

      var1.write("\r\n".getBytes(Class514.Field1364));
   }

   private void Method52(OutputStream var1, String var2, String var3) throws IOException {
      var2 = "Content-Disposition: form-data; name=\"" + this.Method47(var2) + "\"\r\n\r\n";
      var1.write(var2.getBytes(Class514.Field1364));
      var1.write(var3.getBytes(Class514.Field1364));
      var1.write("\r\n".getBytes(Class514.Field1364));
   }

   public final long Method53(String var1, OutputStream var2, Class80 var3, int var4) throws Exception {
      try {
         Class80 var5 = var3;
         OutputStream var22 = var2;
         boolean var6 = true;
         HttpConnection var20;
         InputStream var21 = (var20 = (HttpConnection)this.GetHttpClient(var1, var6, false)).openInputStream();
         long var13 = var20.getLength();
         byte[] var23 = new byte[16384];
         long var17 = 0L;

         int var7;
         while((var7 = var21.read(var23)) != -1) {
            var17 += (long)var7;
            var22.write(var23, 0, var7);
            var22.flush();
            if (var5 != null) {
               var5.Method1(var17 * 100L / var13);
            }
         }

         var21.close();
         var20.close();
         var22.close();
         if (var5 != null) {
            var5.Method1(100L);
         }

         if (var3 != null) {
            if (var13 != 0L) {
               var3.Method72();
            } else {
               var3.Method27("File corrupted.");
            }
         }

         return var13;
      } catch (Exception var19) {
         if (var3 != null) {
            var3.Method27(var19.toString());
         }

         throw var19;
      }
   }

   public final String Method54(MethodsWithParameters var1) throws Exception {
      if (var1 == null) {
         return null;
      } else {
         String var6 = var1.toString();
         Logger.PrintToConsole("[REQ]: " + var6);
         boolean var3 = true;
         HttpConnection var7;
         if ((var7 = (HttpConnection)this.GetHttpClient(var6, var3, false)) == null) {
            throw new Exception("Can't connect to destination.");
         } else {
            InputStream var2 = var7.openInputStream();
            ByteArrayOutputStream var9 = new ByteArrayOutputStream();
            byte[] var4 = new byte[1024];

            int var5;
            while((var5 = var2.read(var4)) != -1) {
               var9.write(var4, 0, var5);
            }

            var2.close();
            byte[] var8 = var9.toByteArray();
            var9.close();
            var7.close();
            var6 = new String(var8, Class514.Field1364);
            Logger.PrintToConsole("[RES]: " + var6);
            return var6;
         }
      }
   }
}
