final class ButtonOnSettings extends Button
{
	private short _key;
	ButtonOnSettings(String lable, short key, byte type)
	{
		super(lable, type);
		this._key = key;
		this.IsChecked = this.GetValue() ? (short)1 : 0;
	}

   public final void ButtonPressed()
   {
      this.SetValue(this.GetIsChecked());
   }
   
   private boolean GetValue()
   {
		boolean ret = false;
	   switch(this._key)
	   {
	   case 2:
		   ret = Settings.Instance.GuiCloudBorder;
		   break;
	   case 3:
		   ret = Settings.Instance.GuiReverseNames;
		   break;
	   case 4:
		   ret = Settings.Instance.RenderDimm;
		   break;
	   case 5:
		   ret = Settings.Instance.GuiAnimations;
		   break;
	   case 6:
		   ret = Settings.Instance.GuiSmoothScroll;
		   break;
	   case 7:
		   ret = Settings.Instance.GuiShowClouds;
		   break;
	   case 8:
		   ret = Settings.Instance.DebugDrawFPS;
		   break;
	   case 9:
		   ret = Settings.Instance.DebugDrawEmojiRed;
		   break;
	   case 10:
		   ret = Settings.Instance.GuiFullscreen;
		   break;
		   
	   case 11:
		   ret = Settings.Instance.GuiMessagesAvatars;
		   break;
	   case 12:
		   ret = Settings.Instance.GuiTouchHud;
		   break;
	   case 13:
		   ret = Settings.Instance.FeedKeyVibro;
		   break;
	   case 14:
		   ret = Settings.Instance.FeedNotVibro;
		   break;
	   case 15:
		   ret = Settings.Instance.FeedNotSound;
		   break;
	   case 16:
		   ret = Settings.Instance.DebugDrawImagesFrames;
		   break;
	   case 17:
		   ret = Settings.Instance.GuiMessageDiffSides;
		   break;
	   case 18:
		   ret = Settings.Instance.UseFlushUpload;
		   break;
	   case 19:
		   ret = Settings.Instance.GuiReverseSofts;
		   break;
	   case 20:
		   ret = Settings.Instance.TranslitFiles;
		   break;
		   
		   
	   case 21:
		   ret = Settings.Instance.Gradients;
		   break;
	   case 22:
		   ret = Settings.Instance.GuiShowHeader;
		   break;
	   case 23:
		   ret = Settings.Instance.GuiShowFooter;
		   break;
	   case 24:
		   ret = Settings.Instance.ShowMessagesFromEnd;
		   break;
	   case 25:
		   ret = Settings.Instance.DoNotLoadImages;
		   break;
	   case 26:
		   ret = Settings.Instance.UsePQSofts;
		   break;
	   case 27:
		   ret = Settings.Instance.GuiSlimHeader;
		   break;
	   case 28:
		   ret = Settings.Instance.GuiUseDrawer;
		   break;
	   case 29:
		   ret = Settings.Instance.ShowReplies;
		   break;
	   case 30:
		   ret = Settings.Instance.LocaleFromRMS;
		   break;
		   
		   
	   case 31:
		   ret = Settings.Instance.DNR;
		   break;
	   case 32:
		   ret = Settings.Instance.DNT;
		   break;
	   case 33:
		   ret = Settings.Instance.LoggerEnabled;
		   break;
	   case 34:
		   ret = Settings.Instance.IncreaseTextLimit;
		   break;
	   case 35:
		   ret = Settings.Instance.OldMessagesSoft;
		   break;
	   case 36:
		   ret = Settings.Instance.OldCommentsSoft;
		   break;
	   case 37:
		   ret = Settings.Instance.ShowMsgFieldByOpen;
		   break;
	   case 38:
		   ret = Settings.Instance.ShowCmtFieldByOpen;
		   break;
	   case 39:
		   ret = Settings.Instance.ShiftTitleRight;
		   break;
	   case 40:
		   ret = Settings.Instance.UseKeypadInput;
		   break;
		   
		   
	   case 41:
		   ret = Settings.Instance.DebugLongPoll;
		   break;
	   case 42:
		   ret = Settings.Instance.SleepWithTimeout;
		   break;
	   case 43:
		   ret = Settings.Instance.HideAfterSending;
		   break;
	   case 44:
		   ret = Settings.Instance.TypingInDialogs;
		   break;
	   case 45:
		   ret = Settings.Instance.UpperFirstChar;
		   break;
	   case 46:
		   ret = Settings.Instance.ReplaceEmailAtYo;
		   break;
	   case 47:
		   ret = Settings.Instance.SetOffline;
		   break;
	   }
	   return ret;
   }
   
   private void SetValue(boolean value)
   {
	   switch(this._key)
	   {
	   case 2:
		   Settings.Instance.GuiCloudBorder = value;
		   break;
	   case 3:
		   Settings.Instance.GuiReverseNames = value;
		   break;
	   case 4:
		   Settings.Instance.RenderDimm = value;
		   break;
	   case 5:
		   Settings.Instance.GuiAnimations = value;
		   break;
	   case 6:
		   Settings.Instance.GuiSmoothScroll = value;
		   break;
	   case 7:
		   Settings.Instance.GuiShowClouds = value;
		   break;
	   case 8:
		   Settings.Instance.DebugDrawFPS = value;
		   break;
	   case 9:
		   Settings.Instance.DebugDrawEmojiRed = value;
		   break;
	   case 10:
		   Settings.Instance.GuiFullscreen = value;
		   break;
		   
	   case 11:
		   Settings.Instance.GuiMessagesAvatars = value;
		   break;
	   case 12:
		   Settings.Instance.GuiTouchHud = value;
		   break;
	   case 13:
		   Settings.Instance.FeedKeyVibro = value;
		   break;
	   case 14:
		   Settings.Instance.FeedNotVibro = value;
		   break;
	   case 15:
		   Settings.Instance.FeedNotSound = value;
		   break;
	   case 16:
		   Settings.Instance.DebugDrawImagesFrames = value;
		   break;
	   case 17:
		   Settings.Instance.GuiMessageDiffSides = value;
		   break;
	   case 18:
		   Settings.Instance.UseFlushUpload = value;
		   break;
	   case 19:
		   Settings.Instance.GuiReverseSofts = value;
		   break;
	   case 20:
		   Settings.Instance.TranslitFiles = value;
		   break;
		   
		   
	   case 21:
		   Settings.Instance.Gradients = value;
		   break;
	   case 22:
		   Settings.Instance.GuiShowHeader = value;
		   break;
	   case 23:
		   Settings.Instance.GuiShowFooter = value;
		   break;
	   case 24:
		   Settings.Instance.ShowMessagesFromEnd = value;
		   break;
	   case 25:
		   Settings.Instance.DoNotLoadImages = value;
		   break;
	   case 26:
		   Settings.Instance.UsePQSofts = value;
		   break;
	   case 27:
		   Settings.Instance.GuiSlimHeader = value;
		   break;
	   case 28:
		   Settings.Instance.GuiUseDrawer = value;
		   break;
	   case 29:
		   Settings.Instance.ShowReplies = value;
		   break;
	   case 30:
		   Settings.Instance.LocaleFromRMS = value;
		   break;
		   
		   
	   case 31:
		   Settings.Instance.DNR = value;
		   break;
	   case 32:
		   Settings.Instance.DNT = value;
		   break;
	   case 33:
		   Settings.Instance.LoggerEnabled = value;
		   break;
	   case 34:
		   Settings.Instance.IncreaseTextLimit = value;
		   break;
	   case 35:
		   Settings.Instance.OldMessagesSoft = value;
		   break;
	   case 36:
		   Settings.Instance.OldCommentsSoft = value;
		   break;
	   case 37:
		   Settings.Instance.ShowMsgFieldByOpen = value;
		   break;
	   case 38:
		   Settings.Instance.ShowCmtFieldByOpen = value;
		   break;
	   case 39:
		   Settings.Instance.ShiftTitleRight = value;
		   break;
	   case 40:
		   Settings.Instance.UseKeypadInput = value;
		   break;
		   
		   
	   case 41:
		   Settings.Instance.DebugLongPoll = value;
		   break;
	   case 42:
		   Settings.Instance.SleepWithTimeout = value;
		   break;
	   case 43:
		   Settings.Instance.HideAfterSending = value;
		   break;
	   case 44:
		   Settings.Instance.TypingInDialogs = value;
		   break;
	   case 45:
		   Settings.Instance.UpperFirstChar = value;
		   break;
	   case 46:
		   Settings.Instance.ReplaceEmailAtYo = value;
		   break;
	   case 47:
		   Settings.Instance.SetOffline = value;
		   break;
	   }
	   
   }
}
