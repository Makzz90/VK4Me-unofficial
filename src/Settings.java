import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;


//import com.nokia.mid.ui.DeviceControl;

public final class Settings
{
	//private Hashtable _fields;
//	public ApplicationTheme[] ThemeList;
	   //private ApplicationLang[] LangList;
	   public static Settings Instance;
	   
	   //BOOL
	   public boolean HasEmoji;
	   public boolean GuiCloudBorder;
	   public boolean GuiReverseNames;
	   public boolean RenderDimm;
	   public boolean GuiAnimations;
	   public boolean GuiSmoothScroll;
	   public boolean GuiShowClouds;
	   public boolean DebugDrawFPS;
	   public boolean DebugDrawEmojiRed;
	   public boolean GuiFullscreen;
	   public boolean GuiMessagesAvatars;
	   public boolean GuiTouchHud;
	   public boolean FeedKeyVibro;
	   public boolean FeedNotVibro;
	   public boolean FeedNotSound;
	   public boolean DebugDrawImagesFrames;
	   public boolean GuiMessageDiffSides;
	   public boolean UseFlushUpload;
	   public boolean GuiReverseSofts;
	   public boolean TranslitFiles;
	   public boolean Gradients;
	   public boolean GuiShowHeader;
	   public boolean GuiShowFooter;
	   public boolean ShowMessagesFromEnd;
	   public boolean DoNotLoadImages;
	   public boolean UsePQSofts;
	   public boolean GuiSlimHeader;
	   public boolean GuiUseDrawer;
	   public boolean ShowReplies;
	   public boolean LocaleFromRMS;
	   public boolean DNR;
	   public boolean DNT;
	   public boolean LoggerEnabled;
	   public boolean IncreaseTextLimit;
	   public boolean OldMessagesSoft;
	   public boolean OldCommentsSoft;
	   public boolean ShowMsgFieldByOpen;
	   public boolean ShowCmtFieldByOpen;
	   public boolean ShiftTitleRight;
	   public boolean UseKeypadInput;
	   public boolean DebugLongPoll;
	   public boolean SleepWithTimeout;
	   public boolean HideAfterSending;
	   public boolean TypingInDialogs;
	   public boolean UpperFirstChar;
	   public boolean ReplaceEmailAtYo;
	   public boolean SetOffline;
   
   //INT
	   public int SleepTimeout;
	   public int GuiAvatarCircleType;
	   public int NetworkMode;
	   public int LpSpeed;
	   public int LpsSpeed;
	   public int GuiPhotosCircleType;
	   public int DownloadMode;
	   public int UserId;
   
   //STRING
	   public String Token;
	   public String CustomAPI;
	   public String CustomAUTH;
	   public String CustomPROXY;
	   public String LocaleCode;
	   public String ApiUrl;
	   public String OauthUrl;
	   public String ProxyUrl;
   
   
   

   public final void Method122() {
      this.ApplyUrls();
      String token = this.Token;
      if (token == null)
      {
         LoginForm.ShowLoginForm();
      }
      else
      {
         try
         {
            LoginForm.Method262();
         } catch (Exception ex) {
            Logger.PrintErrorWithMessage(ex);
            this.Token="";
            LoginForm.AuthError();
         }
      }
   }
   
   public void Initialize()
   {
	   Instance = new Settings();
	   //
	   Settings _settings = Instance;
	   DataInputStream stream=null;
	   
	   try {
		   ByteArrayInputStream var3 = new ByteArrayInputStream(RecordStoreHelper.GetRecord("cfg3"));
		   stream = new DataInputStream(var3);
		   
		   _settings.GuiCloudBorder = stream.readBoolean();
		   _settings.GuiReverseNames = stream.readBoolean();
		   _settings.GuiAvatarCircleType = stream.readInt();
		   _settings.NetworkMode = stream.readInt();
		   _settings.RenderDimm = stream.readBoolean();
		   _settings.DebugDrawFPS = stream.readBoolean();
		   _settings.DebugDrawEmojiRed = stream.readBoolean();
		   _settings.GuiAnimations = stream.readBoolean();
		   _settings.GuiSmoothScroll = stream.readBoolean();
		   _settings.FeedKeyVibro = stream.readBoolean();
		   _settings.FeedNotVibro = stream.readBoolean();
		   _settings.FeedNotSound = stream.readBoolean();
		   _settings.GuiFullscreen = stream.readBoolean();
		   _settings.GuiTouchHud = stream.readBoolean();//Class198.Field618 != null ? Class198.Field618.hasPointerEvents() : true;

		   _settings.LocaleCode = stream.readUTF();//Localized.GetLang();

		   _settings.LocaleFromRMS = stream.readBoolean();
		   _settings.DebugDrawImagesFrames = stream.readBoolean();
		   _settings.LpSpeed = stream.readInt();
		   _settings.LpsSpeed = stream.readInt();
		   _settings.GuiShowClouds = stream.readBoolean();
		   _settings.GuiMessageDiffSides = stream.readBoolean();
		   _settings.GuiMessagesAvatars = stream.readBoolean();
		   _settings.UseFlushUpload = stream.readBoolean();
		   _settings.GuiPhotosCircleType = stream.readInt();
		   _settings.GuiReverseSofts = stream.readBoolean();
		   _settings.TranslitFiles = stream.readBoolean();
		   _settings.Gradients = stream.readBoolean();
		   _settings.GuiShowHeader = stream.readBoolean();
		   _settings.GuiShowFooter = stream.readBoolean();
		   _settings.ShowMessagesFromEnd = stream.readBoolean();
		   _settings.DownloadMode = stream.readInt();
		   _settings.DNR = stream.readBoolean();
		   _settings.DNT = stream.readBoolean();
		   _settings.DoNotLoadImages = stream.readBoolean();
		   _settings.CustomAPI = stream.readUTF();
		   _settings.CustomAUTH = stream.readUTF();
		   _settings.CustomPROXY = stream.readUTF();

		   _settings.GuiSlimHeader = stream.readBoolean();
		   _settings.GuiUseDrawer = stream.readBoolean();
		   _settings.UsePQSofts = stream.readBoolean();
		   _settings.ShowReplies = stream.readBoolean();
		   _settings.LoggerEnabled = stream.readBoolean();
		   _settings.OldMessagesSoft = stream.readBoolean();
		   _settings.OldCommentsSoft = stream.readBoolean();
		   _settings.IncreaseTextLimit = stream.readBoolean();

		   _settings.ShowCmtFieldByOpen = stream.readBoolean();
		   _settings.ShowMsgFieldByOpen = stream.readBoolean();
		   _settings.ShiftTitleRight = stream.readBoolean();
		   _settings.UseKeypadInput = stream.readBoolean();
		   _settings.SleepWithTimeout = stream.readBoolean();
		   _settings.DebugLongPoll = stream.readBoolean();
		   _settings.HideAfterSending = stream.readBoolean();
		   _settings.TypingInDialogs = stream.readBoolean();
		   _settings.ReplaceEmailAtYo = stream.readBoolean();
		   _settings.UpperFirstChar = stream.readBoolean();
		   _settings.SleepTimeout = stream.readInt();
		   _settings.SetOffline = stream.readBoolean();
		   
		   _settings.Token = stream.readUTF();
		   _settings.UserId = stream.readInt();
	      }
	   catch (Throwable th)
	   {
	    	  
	    	  _settings.GuiCloudBorder = true;
	    	  _settings.GuiReverseNames = false;
	    	  _settings.GuiAvatarCircleType = 75;
	    	  _settings.NetworkMode = 5;
	    	  _settings.RenderDimm = false;
	    	  _settings.DebugDrawFPS = false;
	    	  _settings.DebugDrawEmojiRed = false;
	    	  _settings.GuiAnimations = true;
	    	  _settings.GuiSmoothScroll = true;
	    	  _settings.FeedKeyVibro = true;
	    	  _settings.FeedNotVibro = true;
	    	  _settings.FeedNotSound = true;
	    	  _settings.GuiFullscreen = true;
		         _settings.GuiTouchHud= Class198.Instance != null ? Class198.Instance.hasPointerEvents() : true;

		         _settings.LocaleCode = Localized.GetLang();
		         _settings.LocaleFromRMS = false;
		         _settings.DebugDrawImagesFrames = false;
		         _settings.LpSpeed = 3;
		         _settings.LpsSpeed = 20;
		         _settings.GuiShowClouds = true;
		         _settings.GuiMessageDiffSides = true;
		         _settings.GuiMessagesAvatars = true;
		         _settings.UseFlushUpload = false;
		         _settings.GuiPhotosCircleType = 100;
		         _settings.GuiReverseSofts = true;
		         _settings.TranslitFiles = true;
		         _settings.Gradients = false;
		         _settings.GuiShowHeader = true;
		         _settings.GuiShowFooter = true;
		         _settings.ShowMessagesFromEnd = false;
		         _settings.DownloadMode = 0;
		         _settings.DNR = false;
		         _settings.DNT = false;
		         _settings.DoNotLoadImages = false;
		         _settings.CustomAPI = "";
		         _settings.CustomAUTH = "";
		         _settings.CustomPROXY = "";

		         _settings.GuiSlimHeader = true;
		         _settings.GuiUseDrawer = false;
		         _settings.UsePQSofts = false;
		         _settings.ShowReplies = false;
		         _settings.LoggerEnabled = false;
		         _settings.OldMessagesSoft = false;
		         _settings.OldCommentsSoft = false;
		         _settings.IncreaseTextLimit = false;
		         _settings.ShowCmtFieldByOpen = true;
		         _settings.ShowMsgFieldByOpen = true;
		         _settings.ShiftTitleRight = false;
		         _settings.UseKeypadInput = true;
		         _settings.SleepWithTimeout = true;
		         _settings.DebugLongPoll = false;
		         _settings.HideAfterSending = true;
		         _settings.TypingInDialogs = true;
		         _settings.ReplaceEmailAtYo = false;
		         _settings.UpperFirstChar = false;
		         _settings.SleepTimeout = 90;
		         _settings.SetOffline = true;
	         
	         
	      }
	   finally
	   {
		   _settings.ApplyUrls();
		   _settings.Method129();
		   _settings.Method123();
	   }
	   
	   try
	   {
		   if(stream!=null)
			   stream.close();
	   }
	   catch (Exception ex)
	   {
		   
	   }
   }

   public Settings() {
	   //this._fields = new Hashtable();
	   
      //Settings _settings = this;
      //this.FeelToken();
	   
      //this.FeelThemeAndLangList();

      
   }

   private void Method123()
   {
      String lang = this.LocaleCode;

      try
      {
         Localized.Instance = new Localized(new String(Class278.Method378(Runtime.getRuntime().getClass().getResourceAsStream("/lang/" + lang + ".lang")), Class514.Field1364));
      }
      catch (Throwable th)
      {
         Logger.PrintErrorWithMessage(th);
         System.gc();
         Localized.Instance = new Localized(null);
      }

      SomeStringUtils.Field913[1] = Localized.GetString("j2vk.month1");
      SomeStringUtils.Field913[2] = Localized.GetString("j2vk.month2");
      SomeStringUtils.Field913[3] = Localized.GetString("j2vk.month3");
      SomeStringUtils.Field913[4] = Localized.GetString("j2vk.month4");
      SomeStringUtils.Field913[5] = Localized.GetString("j2vk.month5");
      SomeStringUtils.Field913[6] = Localized.GetString("j2vk.month6");
      SomeStringUtils.Field913[7] = Localized.GetString("j2vk.month7");
      SomeStringUtils.Field913[8] = Localized.GetString("j2vk.month8");
      SomeStringUtils.Field913[9] = Localized.GetString("j2vk.month9");
      SomeStringUtils.Field913[10] = Localized.GetString("j2vk.month10");
      SomeStringUtils.Field913[11] = Localized.GetString("j2vk.month11");
      SomeStringUtils.Field913[12] = Localized.GetString("j2vk.month12");
//      Class6.Method342(this.GetString(ThemeName), this.GetBool(ThemeFromRMS));
      Class6.Method342("Classic Dark", false);
   }
/*
   private void FeelThemeAndLangList() {
      try {
         JSONObject json;
         int i;
         JSONObject var4;
         json = new JSONObject(new String(RecordStoreHelper.GetRecord("insjson3"), Class514.Field1364));
         
         JSONArray array = json.optJSONArray("locales");
         if (array != null)
         {
            this.LangList = new ApplicationLang[array.Count()];

            for(i = 0; i < this.LangList.length; i++)
            {
               this.LangList[i] = new ApplicationLang();
               var4 = array.Method508(i);
               if (var4 != null)
               {
                  this.LangList[i].Name = var4.optGetString("name");
                  this.LangList[i].Version = var4.optGetString("version");
                  this.LangList[i].Code = var4.optGetString("code");
               }
            }
         }

      } catch (Throwable th) {
         //this.ThemeList = new ApplicationTheme[0];
         this.LangList = new ApplicationLang[0];
      }
   }

   public final void SaveThemesAndLangsCfg()
   {
      try {
         JSONObject var1 = new JSONObject();
         JSONArray var2 = new JSONArray();
         int i;
         JSONObject var4;
         
         var2 = new JSONArray();
         if (this.LangList != null) {
            for(i = 0; i < this.LangList.length; i++) {
               if (this.LangList[i] == null) {
                  this.LangList[i] = new ApplicationLang();
               }

               (var4 = new JSONObject()).put("name", this.LangList[i].Name);
               var4.put("version", this.LangList[i].Version);
               var4.put("code", this.LangList[i].Code);
               var2.put(var4);
            }
         }

         var1.put("locales", var2);
         RecordStoreHelper.AddRecord("insjson3", var1.toString().getBytes(Class514.Field1364));
      } catch (Throwable var5) {
         Logger.PrintErrorWithMessage(var5);
      }
   }
   */
/*
   public final void SaveToken() {
      try
      {
         if (this.Token == null)
         {
            Class98.DeleteRecord("tokenavk3");
            return;
         }

         Class98.AddRecord("tokenavk3", this.Token.getBytes(Class514.Field1364));
      } catch (Throwable var2) {
         Logger.Method522(var2);
      }

   }

   private void FeelToken() {
      try
      {
         this.Token = new String(Class98.GetRecord("tokenavk3"), Class514.Field1364);
      }
      catch (Throwable var1)
      {
         this.Token = null;
      }
   }
*/
   public final void ApplyUrls()
   {
      switch(this.NetworkMode) {
      case 0:
    	  this.ApiUrl = "http://vk-api-proxy.xtrafrancyz.net/";
    	  this.OauthUrl = "http://vk-oauth-proxy.xtrafrancyz.net/";
    	  this.ProxyUrl = null;
         return;
      case 1:
      default:
    	  this.ApiUrl = "https://api.vk.com/";
    	  this.OauthUrl = "https://oauth.vk.com/";
    	  this.ProxyUrl = null;
         return;
      case 2:
    	  this.ApiUrl = this.CustomAPI;
    	  this.OauthUrl = this.CustomAUTH;
    	  this.ProxyUrl = null;
         return;
      case 3:
    	  this.ApiUrl = "http://openvk.xyz/";
    	  this.OauthUrl = "http://openvk.xyz/";
    	  this.ProxyUrl = null;
         return;
      case 4:
    	  this.ApiUrl = "https://openvk.uk/";
    	  this.OauthUrl = "https://openvk.uk/";
    	  this.ProxyUrl = null;
         return;
      case 5:
    	  this.ApiUrl = "https://api.vk.com/";
    	  this.OauthUrl = "https://oauth.vk.com/";
    	  this.ProxyUrl = "http://vk4me.crx.moe/proxy.php";
         return;
      case 6:
    	  this.ApiUrl = "https://api.vk.com/";
    	  this.OauthUrl = "https://oauth.vk.com/";
    	  this.ProxyUrl = this.CustomPROXY;
         return;
      case 7:
    	  this.ApiUrl = this.CustomAPI;
    	  this.OauthUrl = this.CustomAUTH;
    	  this.ProxyUrl = this.CustomPROXY;
      }
   }

   public final void Method129() {
      Class432.UseFlush = this.UseFlushUpload;
      Logger.IsEnabled = this.LoggerEnabled;
      LongPollInstanse.LpSpeed = this.LpSpeed;
      LongPollInstanse.LpsSpeed = this.LpsSpeed;
      VKUser.ReverseNames = this.GuiReverseNames;
      /*
      if (this.Brightness != 0) {
         try {
            //DeviceControl.setLights(0, this.Field433);
            return;
         } catch (Throwable th) {
            this.Brightness = 0;
         }
      }
*/
   }

   public final void Save() {
      //this.SaveToken();
      //this.SaveThemesAndLangsCfg();
      	//if(this._fields.size()==0)
      	//		return;
      try {
    	  /*
         JSONObject json= new JSONObject();
         json.put("gui_cloudBorder", this.Field382);
         json.put("gui_reverseNames", this.Field383);
         json.put("gui_avatarCircleType", this.Field411);
         json.put("network_mode", this.NetworkMode);
         json.put("gui_disableDimm", this.RenderDimm);
         json.put("debug_drawFPS", this.DebugDrawFPS);
         json.put("debug_drawEmojiRed", this.Field389);
         json.put("gui_animations", this.GuiAnimations);
         json.put("gui_smoothScroll", this.GuiSmoothScroll);
         json.put("feed_keyVibro", this.Field393);
         json.put("feed_notVibro", this.Field394);
         json.put("feed_notSound", this.Field395);
         json.put("gui_fullscreen", this.Field390);
         json.put("gui_touchHud", this.Field392);
         json.put("themeName", this.Field424);
         json.put("localeCode", this.Field423);
         json.put("themeFromRMS", this.Field426);
         json.put("localeFromRMS", this.Field425);
         json.put("debug_drawImagesFrames", this.Field396);
         json.put("lpSpeed", this.Field413);
         json.put("lpsSpeed", this.Field414);
         json.put("gui_showClouds", this.Field387);
         json.put("gui_messageDiffSides", this.Field397);
         json.put("gui_messagesAvatars", this.Field391);
         json.put("useFlushUpload", this.Field398);
         json.put("gui_photosCircleType", this.Field415);
         json.put("gui_reverseSofts", this.Field399);
         json.put("translitFiles", this.Field400);
         json.put("gui_drawGradients", this.Gradients);
         json.put("gui_showHeader", this.Field402);
         json.put("gui_showFooter", this.Field403);
         json.put("showMessagesFromEnd", this.Field404);
         json.put("downloadMode", this.Field416);
         json.put("DNR", this.Field427);
         json.put("DNT", this.Field428);
         json.put("doNotLoadImages", this.DoNotLoadImages);
         json.put("customAPI", this.Field418);
         json.put("customAUTH", this.Field419);
         json.put("customPROXY", this.Field420);
         json.put("gui_showDock", false);
         json.put("gui_slimHeader", this.Field408);
         json.put("gui_useDrawer", this.Field409);
         json.put("usePQSofts", this.Field407);
         json.put("showReplies", this.Field410);
         json.put("loggerEnabled", this.Field429);
         json.put("oldMessagesSoft", this.Field431);
         json.put("oldCommentsSoft", this.Field432);
         json.put("increaseTextLimit", this.IncreaseTextLimit);
         json.put("brightness", this.Field433);
         json.put("showCmtFieldByOpen", this.Field435);
         json.put("showMsgFieldByOpen", this.Field434);
         json.put("shiftTitleRight", this.Field436);
         json.put("useKeypadInput", this.UseKeypadInput);
         json.put("sleepWithTimeout", this.SleepWithTimeout);
         json.put("debug_lp", this.DebugLongPoll);
         json.put("hideAfterSending", this.Field440);
         json.put("typingInDialogs", this.Field441);
         json.put("replaceEmailAtYo", this.Field443);
         json.put("upperFirstChar", this.Field442);
         json.put("sleepTimeout", this.SleepTimeout);
         json.put("setOffline", this.SetOffline);
         
         Enumeration enumerator = this._fields.keys();
         
         while(enumerator.hasMoreElements())
         {
            Object element = enumerator.nextElement();
            json.put(element.toString(), this._fields.get(element));
         }
         */
    	  ByteArrayOutputStream var2 = new ByteArrayOutputStream();
          DataOutputStream stream = new DataOutputStream(var2);
          
          stream.writeBoolean(this.GuiCloudBorder);
          stream.writeBoolean(this.GuiReverseNames);
          stream.writeInt(this.GuiAvatarCircleType);
          stream.writeInt(this.NetworkMode);
          stream.writeBoolean(this.RenderDimm);
          stream.writeBoolean(this.DebugDrawFPS);
          stream.writeBoolean(this.DebugDrawEmojiRed);
          stream.writeBoolean(this.GuiAnimations);
          stream.writeBoolean(this.GuiSmoothScroll);
          stream.writeBoolean(this.FeedKeyVibro);
          stream.writeBoolean(this.FeedNotVibro);
          stream.writeBoolean(this.FeedNotSound);
          stream.writeBoolean(this.GuiFullscreen);
          stream.writeBoolean(this.GuiTouchHud);
          stream.writeUTF(this.LocaleCode);
          stream.writeBoolean(this.LocaleFromRMS);
          stream.writeBoolean(this.DebugDrawImagesFrames);
          stream.writeInt(this.LpSpeed);
          stream.writeInt(this.LpsSpeed);
          stream.writeBoolean(this.GuiShowClouds);
          stream.writeBoolean(this.GuiMessageDiffSides);
          stream.writeBoolean(this.GuiMessagesAvatars);
          stream.writeBoolean(this.UseFlushUpload);
          stream.writeInt(this.GuiPhotosCircleType);
          stream.writeBoolean(this.GuiReverseSofts);
          stream.writeBoolean(this.TranslitFiles);
          stream.writeBoolean(this.Gradients);
          stream.writeBoolean(this.GuiShowHeader);
          stream.writeBoolean(this.GuiShowFooter);
          stream.writeBoolean(this.ShowMessagesFromEnd);
          stream.writeInt(this.DownloadMode);
          stream.writeBoolean(this.DNR);
          stream.writeBoolean(this.DNT);
          stream.writeBoolean(this.DoNotLoadImages);
          stream.writeUTF(this.CustomAPI);
          stream.writeUTF(this.CustomAUTH);
          stream.writeUTF(this.CustomPROXY);
          stream.writeBoolean(this.GuiSlimHeader);
          stream.writeBoolean(this.GuiUseDrawer);
          stream.writeBoolean(this.UsePQSofts);
          stream.writeBoolean(this.ShowReplies);
          stream.writeBoolean(this.LoggerEnabled);
          stream.writeBoolean(this.OldMessagesSoft);
          stream.writeBoolean(this.OldCommentsSoft);
          stream.writeBoolean(this.IncreaseTextLimit);
          stream.writeBoolean(this.ShowCmtFieldByOpen);
          stream.writeBoolean(this.ShowMsgFieldByOpen);
          stream.writeBoolean(this.ShiftTitleRight);
          stream.writeBoolean(this.UseKeypadInput);
          stream.writeBoolean(this.SleepWithTimeout);
          stream.writeBoolean(this.DebugLongPoll);
          stream.writeBoolean(this.HideAfterSending);
          stream.writeBoolean(this.TypingInDialogs);
          stream.writeBoolean(this.ReplaceEmailAtYo);
          stream.writeBoolean(this.UpperFirstChar);
          stream.writeInt(this.SleepTimeout);
          stream.writeBoolean(this.SetOffline);
          stream.writeUTF(this.Token);
          stream.writeInt(this.UserId);
          
          stream.close();
          
          byte[] var4 = var2.toByteArray();
          
         RecordStoreHelper.AddRecord("cfg3", var4);
         
         
      }
      catch (Exception ex)
      {
         Logger.PrintErrorWithMessage(ex);
      }
   }
   
   public String GetApiUrl()
   {
	   String temp = this.ApiUrl;
      return temp == null ? "https://api.vk.com/" : temp;
  }
   
   public boolean IsAutorized()
   {
	   String temp = this.Token;
	   return temp!=null && temp.length() > 0;
   }
}
