package io.nolt.jsonDiff;

import com.github.wnameless.json.flattener.JsonFlattener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonDiffUtilBuilder implements JsonDiffUtil {

    private List<String> ignoreKeys = new ArrayList<>();

    public JsonDiffUtil withIgnoreKey(List<String> list) {
        this.ignoreKeys.addAll(list);
        return this;
    }

    public JsonDiffUtil withIgnoreKey(String key) {
        this.ignoreKeys.add(key);
        return this;
    }

    public List<String> getIgnoreKeys() {
        return ignoreKeys;
    }

    public JsonDiffUtil.JsonDiff diff(String subject, String compareWith) {
        Map<String, Object> flattenSubject = JsonFlattener.flattenAsMap(subject);
        Map<String, Object> flattenCompareWith = JsonFlattener.flattenAsMap(compareWith);


        this.ignoreKeys.forEach(x -> {
            flattenCompareWith.remove(x);
            flattenSubject.remove(x);
        });
        return JsonDiffUtil.getDiff(flattenSubject, flattenCompareWith);
    }
}
