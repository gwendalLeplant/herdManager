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

	public static List<Sheep> selectAll() {
		return SheepDAOJDBCImpl.selectAll();
	}

	public static Sheep selectById(Integer id) {
		return SheepDAOJDBCImpl.selectById(id);
	}

	public static Sheep insert(Sheep sheepToInsert) {
		return SheepDAOJDBCImpl.insert(sheepToInsert);
	}

	public static Sheep update(Sheep sheepToUpdate) {
		return SheepDAOJDBCImpl.update(sheepToUpdate);
	}

	public static Sheep delete(Sheep sheepToDelete) {
		return SheepDAOJDBCImpl.delete(sheepToDelete);
	}

	public static String getAllJSON() throws JsonProcessingException {
		String result = "{\"Tab\":[";
		List<Sheep> lst = selectAll();
		for (int i = 0; i < lst.size(); i++) {
			ObjectMapper mapper = new ObjectMapper();
			mapper.setTimeZone(TimeZone.getDefault());
			mapper.registerModule(new JSR310Module());
			mapper.setSerializationInclusion(Include.NON_NULL);
			result += mapper.writeValueAsString(lst.get(i));
			if (i < lst.size() - 1) {
				result += ",";
			} else {
				result += "]}";
			}
		}
		return result;
	}
}
