package edu.hzu.github;

import java.io.IOException;

import edu.hzu.github.JsonData;

public class Test1 {

	public static void main(String[] args) throws IOException {
		JsonData.user();
		JsonData.repo();
		JsonData.repodataforks();
		JsonData.repodatawatchers();
		JsonData.repodataopen_issues();
	}

}
