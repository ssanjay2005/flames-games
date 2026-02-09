package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class FlamesService {

    public String calculateFlames(String a, String b) {

        a = a.toLowerCase();
        b = b.toLowerCase();

        int[] c = new int[26];
        int[] d = new int[26];

        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            if (ch >= 'a' && ch <= 'z')
                c[ch - 'a']++;
        }

        for (int i = 0; i < b.length(); i++) {
            char ch = b.charAt(i);
            if (ch >= 'a' && ch <= 'z')
                d[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            int min = Math.min(c[i], d[i]);
            c[i] -= min;
            d[i] -= min;
        }

        int s = 0;
        for (int i = 0; i < 26; i++) {
            s += c[i] + d[i];
        }

        if (s == 0) s = 6;

        String[] flames = {"F", "L", "A", "M", "E", "S"};
        int len = 6;
        int index = 0;

        while (len > 1) {
            index = (index + s - 1) % len;
            for (int i = index; i < len - 1; i++) {
                flames[i] = flames[i + 1];
            }
            len--;
        }

        return mapFlamesResult(flames[0]);
    }

    private String mapFlamesResult(String ch) {
        switch (ch) {
            case "F": return "Friends";
            case "L": return "Love";
            case "A": return "Affection";
            case "M": return "Marriage";
            case "E": return "Enemies";
            case "S": return "Siblings";
            default: return "Unknown";
        }
    }
}
