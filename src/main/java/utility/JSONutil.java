package utility;

import com.google.gson.Gson;

public class JSONutil {
	
		private Gson gson;

		public JSONutil() {
			this.gson = new Gson();
		}

		public String getJSONForObject(Object obj) {
			return gson.toJson(obj);
		}

		public <T> T getObjectForJSON(String jsonString, Class<T> clas) {
			return gson.fromJson(jsonString, clas);
		}

	}

