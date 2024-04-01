import ru.curoviyxru.phoenix.midlet.Midlet;

final class AboutForm extends Page {
   private AboutForm(SettingsPage var1, boolean var2, byte var3) {
      super(Localized.GetString("title.aboutSettings"));
      int size = Math.min(Class198.Instance.getWidth() / 3, Class198.Instance.getHeight() / 3);
      ImageElement var10001 = new ImageElement(null, "new/phmini.png", true, size, size);
      
      ImageElement var6 = var10001;
      var10001.Field1185 = 1;
      
      var6.Field1184 = true;
      this.AddElement(var6);
      TextBlock textBlock = new TextBlock("VK4ME");
      
      TextBlock var7 = textBlock;
      textBlock.IsBold = true;
      
      var7.Field1199 = 1;
//      this.AddElement(var7);
      StringBuffer sb = new StringBuffer();
      
      
      String version;
      try
      {
    	  version = Midlet.Instance.getAppProperty("MIDlet-Version");
      }
      catch (Exception ex)
      {
    	   version = "3.0.0";
      }
      
      String var10 = version;
      textBlock = new TextBlock(sb.append(Localized.Method398("general.buildNumber", var10, null)).append("\ncuroviyxru, 2024").toString());
      
      var7 = textBlock;
      textBlock.Field1199 = 1;
      this.AddElement(var7);
      this.AddElement(new OffsetElementUI());
      /*
      if (SettingsPage.isUpdateAvaliable)
      {
         Class232 var12 = new Class232(this, Localized.GetString("settings.downloadUpdate"), (byte)2, var1);
         var10 = null + "";
         
         this.AddElement(var12.SetSubtitle(Localized.Method398("settings.updateToVersion", var10, null)).SetRleIcon("new/cloud-download.rle"));
      }
*/
//      this.AddElement((new Class233(this, "vk4me.crx.moe", (byte)2, var1)).SetSubtitle(Localized.GetString("settings.applicationsWebsite")).SetRleIcon("new/web.rle"));
//      this.AddElement((new Class227(this, "vk.com/vk4me_app", (byte)(var2 ? 2 : 0), var1, var2)).SetSubtitle(Localized.GetString("settings.vkGroup")).SetRleIcon("new/vk.rle"));
//      this.AddElement((new Class230(this, "donationalerts.com/r/curoviyxru", (byte)2, var1)).SetSubtitle(Localized.GetString("settings.donation")).SetRleIcon("new/currency-usd.rle"));
      this.AddElement(new OffsetElementUI());
      textBlock = new TextBlock(Localized.GetString("settings.specialThanks"));
      
      var7 = textBlock;
      textBlock.Field1199 = 1;
      
      var7.IsBold = true;
//      this.AddElement(var7);
      textBlock = new TextBlock("rmn20\nuninterestingrunt\nBodyZ\nKyrtovich\nshinovon\nmostwantedcheater\nJSON.org authors\n" + Localized.GetString("settings.thanksTesters") + "\n" + Localized.GetString("settings.thanksYou"));
      
      var7 = textBlock;
      textBlock.Field1199 = 1;
//      this.AddElement(var7);
      textBlock = new TextBlock("vk4me. vk4you. vk4everyone.");
      
      var7 = textBlock;
      textBlock.Field1199 = 1;
      
      var7.IsBold = true;
//      this.AddElement(var7);
      Class198.Instance.NavigateForward(this);
   }

   AboutForm(SettingsPage var1, boolean var2) {
      this(var1, var2, (byte)0);
   }
}
