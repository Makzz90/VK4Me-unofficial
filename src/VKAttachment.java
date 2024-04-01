//import java.util.Hashtable;

public  class VKAttachment extends DataJson {
   //private static Hashtable Field506;
	public String type;
	public VKPhoto photo;
	public VKSticker sticker;
	public VKAudio audio;
	public VKGraffiti graffiti;
	public VKDocument doc;
	public VKAudioMessage audio_message;
   public VKPlayList audio_playlist;
   public VKStory story;
   public VKVideo video;
   public VKGift gift;
   public VKLink link;
   public VKNewsfeedPost wall;
   public VKWallReply wall_reply;

   public String toString() {
	return null;
}
/*
   public static VKAttachment ProcessData(JSONObject json)
   {
	   
      if (Field506 == null)
      {
    	 Field506 = new Hashtable();
         Field506.put("photo", photo == null ? (photo = Method4("sb")) : photo);
         Field506.put("sticker", sticker == null ? (sticker = Method4("fi")) : sticker);
         Field506.put("audio", audio == null ? (audio = Method4("ck")) : audio);
         Field506.put("graffiti", graffiti == null ? (graffiti = Method4("nq")) : graffiti);
         Field506.put("doc", doc == null ? (doc = Method4("ie")) : doc);
         Field506.put("audio_message", audio_message == null ? (audio_message = Method4("he")) : audio_message);
         Field506.put("audio_playlist", audio_playlist == null ? (audio_playlist = Method4("ij")) : audio_playlist);
         Field506.put("story", story == null ? (story = Method4("mg")) : story);
         Field506.put("video", video == null ? (video = Method4("nn")) : video);
         Field506.put("gift", gift == null ? (gift = Method4("ou")) : gift);
         Field506.put("link", link == null ? (link = Method4("gf")) : link);
         Field506.put("wall", wall == null ? (wall = Method4("nc")) : wall);
         Field506.put("wall_reply", wall_reply == null ? (wall_reply = Method4("jh")) : wall_reply);
      }

      String type = json.optGetString("type");
      if (!IsStringEmpty(type) && Field506.containsKey(type))
      {
    	  
         Class var2;
         if ((var2 = (Class)Field506.get(type)) != null)
         {
            try
            {
               return (VKAttachment)((VKAttachment)var2.newInstance()).ProcessFields(json.Method180(type));
            } catch (Exception var3) {
               Logger.PrintError(var3);
            }
         }
    	  VKAttachment attachment = new VKAttachment();
    	  

         return null;
      }
      else
      {
         return (VKAttachment)(new UnknownAttachment(type)).ProcessFields(json.Method180(type));
      }
   }

   private static Class Method4(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var1) {
         throw new NoClassDefFoundError(var1.getMessage());
      }
   }
*/
public DataJson ProcessFields(JSONObject json) {
	this.type = json.optGetString("type");
	if(this.type.equalsIgnoreCase("photo"))
	{
		this.photo = new VKPhoto();
		this.photo.ProcessFields(json.Method180(this.type));
	}
	else if(this.type.equalsIgnoreCase("sticker"))
	{
		this.sticker = new VKSticker();
		this.sticker.ProcessFields(json.Method180(this.type));
	}
	else if(this.type.equalsIgnoreCase("audio"))
	{
		this.audio = new VKAudio();
		this.audio.ProcessFields(json.Method180(this.type));
	}
	else if(this.type.equalsIgnoreCase("graffiti"))
	{
		this.graffiti = new VKGraffiti();
		this.graffiti.ProcessFields(json.Method180(this.type));
	}
	else if(this.type.equalsIgnoreCase("doc"))
	{
		this.doc = new VKDocument();
		this.doc.ProcessFields(json.Method180(this.type));
	}
	else if(this.type.equalsIgnoreCase("audio_message"))
	{
		this.audio_message = new VKAudioMessage();
		this.audio_message.ProcessFields(json.Method180(this.type));
	}
	else if(this.type.equalsIgnoreCase("audio_playlist"))
	{
		this.audio_playlist = new VKPlayList();
		this.audio_playlist.ProcessFields(json.Method180(this.type));
	}
	else if(this.type.equalsIgnoreCase("story"))
	{
		this.story = new VKStory();
		this.story.ProcessFields(json.Method180(this.type));
	}
	else if(this.type.equalsIgnoreCase("video"))
	{
		this.video = new VKVideo();
		this.video.ProcessFields(json.Method180(this.type));
	}
	else if(this.type.equalsIgnoreCase("gift"))
	{
		this.gift = new VKGift();
		this.gift.ProcessFields(json.Method180(this.type));
	}
	else if(this.type.equalsIgnoreCase("link"))
	{
		this.link = new VKLink();
		this.link.ProcessFields(json.Method180(this.type));
	}
	else if(this.type.equalsIgnoreCase("wall"))
	{
		this.wall = new VKNewsfeedPost();
		this.wall.ProcessFields(json.Method180(this.type));
	}
	else if(this.type.equalsIgnoreCase("wall_reply"))
	{
		this.wall_reply = new VKWallReply();
		this.wall_reply.ProcessFields(json.Method180(this.type));
	}
	else
	{
		Logger.PrintToConsole(type);
	}
	return this;
}
}
