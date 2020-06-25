package io.nolt.jsonDiff;


class Test1 {
static String json1 = "{\n" +
		"  \"Rating\": 1,\n" +
		"  \"SecondaryRatings\": {\n" +
		"    \"Design\": 4,\n" +
		"    \"Price\": 2,\n" +
		"    \"RatingDimension3\": 2\n" +
		"  }\n" +
		"}";
static String json2 = "{\n" +
		"  \"Rating1\": 1,\n" +
		"  \"SecondaryRatings\": {\n" +
		"    \"Design\": 1,\n" +
		"    \"Price\": 2,\n" +
		"    \"RatingDimension3\": 2\n" +
		"  }\n" +
		"}";
	public static void main(String[] args) {
		 JsonDiffUtil.JsonDiff jsonDiff = JsonDiffUtil.diff(json1,json2);
		System.out.println(jsonDiff);
	}


}
