public class VKResponse extends DataJson {
	// VKError
	public String error;
	public String error_description;
	public String error_type;
	public String error_msg;
	public int error_code;

	MethodsWithParameters methodeParams;

	public DataJson ProcessFields(JSONObject json)
	{
		if (json == null)
		{
			return this;
		}
		else
		{
			if (json.has("error"))
			{
				JSONObject var2 = json.Method180("error");
				if (var2 != null)
				{
					this.error_code = var2.optGetInt("error_code");
					this.error_msg = var2.optGetString("error_msg");
				}
				else
				{
					this.error = json.optGetString("error");
				}
			}
			else
			{
				this.error_code = json.optGetInt("error_code");
				this.error_msg = json.optGetString("error_msg");
			}

			this.error_description = json.optGetString("error_description");
			this.error_type = json.optGetString("error_type");
			return this;
		}
	}

	public VKResponse(String method) {
		this.methodeParams = new MethodsWithParameters(method);

		this.methodeParams.AddParameter("v", "5.103");
		this.methodeParams.AddParameter("access_token", Settings.Instance.Token);
	}

	public final void AddParameter(String key, Object value) {
		this.methodeParams.AddParameter(key, value);
	}

	public final void AddIntiger(String key, int value) {
		this.methodeParams.AddParameter(key, String.valueOf(value));
	}
	
	public final void AddLong(String key, long value) {
	      this.methodeParams.AddParameter(key, String.valueOf(value));
	   }

	public JSONObject GetResponse() {

		String var9 = Class278.Method376(this.methodeParams);
		JSONObject json = null;
		try {
			json = new JSONObject(var9);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.ProcessFields(json);// наполняем VKError

		return json;
	}
}
