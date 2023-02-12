package pvapersonal.ru.models;

import lombok.Value;

import java.util.List;

@Value
public class Code {
    String header;
    String spec;
    String funcName;
    List<String> parameters;
}
