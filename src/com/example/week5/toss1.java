package com.example.week5;

import com.sun.istack.internal.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class toss1 {
    public static void main(String[] args) throws IOException{
        String[] data = {"https://toss.im", "abc://example.com/path/data", "http://localhost/path/to/myfile.html?key1=value1", "market://details?id=viva.republica.toss&referrer=web"};
        solution(data);
    }

    public static String[] solution(String[] data) {
        return Arrays.stream(data).map(input -> {
            return parse(input).toString();
        }).toArray(String[]::new);
    }

    // 이 함수를 구현해주세요.
    public static Uri parse(String input) {
        String[] subInput1 = input.split("://");
        String sch = subInput1[0];
        String[] subInput2 = subInput1[1].split("/|\\?");
        String host = subInput2[0];
        String subInput3 = subInput1[1].replaceFirst(sch+"://"+host, "");
        String[] subInput4 = subInput3.split("\\?");
        String path = subInput4[0];
        if (!path.equals("")) path = "/"+path;
        Map<String, String> query = new HashMap<>();
        if (subInput4.length >= 2) {
            String[] querys = subInput4[1].split("&");
            for (String q : querys) {
                String[] pair = q.split("=");
                query.put(pair[0], pair[1]);
            }
        }

        Uri uri = new Uri(sch, host, path, query);
        return uri;
    }

    // 이 클래스는 수정하지 않아도 됩니다.
    static class Uri {
        private String scheme;
        private String host;
        private String path;
        private Map<String, String> query;

        public Uri(String scheme, String host, String path, Map<String, String> query) {
            this.scheme = scheme;
            this.host = host;
            this.path = path;
            this.query = query;
        }

        public String getScheme() {
            return scheme;
        }

        public void setScheme(String scheme) {
            this.scheme = scheme;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public Map<String, String> getQuery() {
            return query;
        }

        public void setQuery(Map<String, String> query) {
            this.query = query;
        }

        @NotNull
        @Override
        public String toString() {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("{");
            if (query != null) {
                String pair = query.entrySet().stream()
                        .sorted(Map.Entry.comparingByKey())
                        .map(entry -> String.format("%s=%s", entry.getKey(), entry.getValue()))
                        .collect(Collectors.joining(", "));
                queryBuilder.append(pair);
            }
            queryBuilder.append("}");
            return String.format(
                    "Uri(scheme=%s, host=%s, path=%s, query=%s)",
                    scheme != null ? scheme : "",
                    host != null ? host : "",
                    path != null ? path : "",
                    queryBuilder.toString());
        }
    }
}
