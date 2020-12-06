package com.akmola.android.kokshetauchat.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SmartReplyData {

    public static final List<String> defaultReplies = Collections.unmodifiableList(
            new ArrayList<String>(Arrays.asList("Ок", "Да", "Нет", "\ud83d\udc4d", "\ud83d\udc4e", "\ud83d\ude04", "\ud83d\ude1e", "\u2764\ufe0f", "Привет!", "Как дела?", "Что делаешь?", "Хорошо!", "Ты как?", "Понятно!", "Спасибо!", "Не за что!", "Не знаю!"))
    );

    public static final Map<String, List<String>> repliesMap = Collections.unmodifiableMap(
            new TreeMap<String, List<String>>(String.CASE_INSENSITIVE_ORDER) {{ }}
    );
}
