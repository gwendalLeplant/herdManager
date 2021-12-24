package org.gleplant.herdManager.bll;

import java.util.List;
import java.util.TimeZone;

import org.gleplant.herdManager.bo.Sheep;
import org.gleplant.herdManager.dal.SheepDAOJDBCImpl;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;

public class SheepManager {

	public static List<Sheep> getAll(){		
		return SheepDAOJDBCImpl.selectAll();
	}
	
	public static String getAllJSON() throws JsonProcessingException {
		String result ="{\"Tab\":[";
		List<Sheep> lst = getAll();
		for (int i = 0; i < lst.size(); i++) {
			ObjectMapper mapper = new ObjectMapper();
			mapper.setTimeZone(TimeZone.getDefault());
			mapper.registerModule(new JSR310Module());
			mapper.setSerializationInclusion(Include.NON_NULL);			
			result += mapper.writeValueAsString(lst.get(i));
			if (i < lst.size() - 1) {
				result += ",";
			}else {
				result+="]}";
			}
		}
		return result;
	}
}
