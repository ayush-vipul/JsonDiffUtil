package io.nolt.jsonDiff;

import com.github.wnameless.json.flattener.JsonFlattener;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public interface JsonDiffUtil {

    public static JsonDiff diff(String subject, String compareWith) {
        Map<String, Object> flattenSubject = JsonFlattener.flattenAsMap(subject);
        Map<String, Object> flattenCompareWith = JsonFlattener.flattenAsMap(compareWith);


        JsonDiff jsonDiff = getDiff(flattenSubject, flattenCompareWith);

        return jsonDiff;
    }

    static JsonDiff getDiff(Map<String, Object> flattenSubject, Map<String, Object> flattenCompareWith) {
        Set<String> unexpected = Sets.difference(flattenSubject.keySet(), flattenSubject.keySet());
        Set<String> missing = Sets.difference(flattenCompareWith.keySet(), flattenSubject.keySet());

        Map matchingValues = Maps.difference(flattenSubject,flattenCompareWith).entriesInCommon();
        Map notMatchingValues = Maps.difference(flattenSubject,flattenCompareWith).entriesDiffering();
        JsonDiff jsonDiff = new JsonDiff();


        jsonDiff.setUnexpectedKeys(unexpected);
        jsonDiff.setMissingKeys(missing);

        jsonDiff.setMatchingValues(matchingValues);
        jsonDiff.setNotMatchingValues(notMatchingValues);
        return jsonDiff;
    }


    public static class JsonDiff {

        //key diff

        private Set<String> missingKeys;

        private Set<String> unexpectedKeys;

        private Map matchingValues;

        private Map notMatchingValues;

        public JsonDiff() {
        }



        public Set<String> getMissingKeys() {
            return missingKeys;
        }

        public void setMissingKeys(Set<String> missingKeys) {
            this.missingKeys = missingKeys;
        }

        public Set<String> getUnexpectedKeys() {
            return unexpectedKeys;
        }

        public void setUnexpectedKeys(Set<String> unexpectedKeys) {
            this.unexpectedKeys = unexpectedKeys;
        }

        public Map getMatchingValues() {
            return matchingValues;
        }

        public void setMatchingValues(Map matchingValues) {
            this.matchingValues = matchingValues;
        }

        public Map getNotMatchingValues() {
            return notMatchingValues;
        }

        public void setNotMatchingValues(Map notMatchingValues) {
            this.notMatchingValues = notMatchingValues;
        }

        @Override
        public String toString() {
            return "JsonDiff{" +
                    "missingKeys=" + missingKeys +
                    ", unexpectedKeys=" + unexpectedKeys +
                    ", matchingValues=" + matchingValues +
                    ", notMatchingValues=" + notMatchingValues +
                    '}';
        }
    }


}
