package functions;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluatedMessageSentEvent {
    private boolean hasPottyWord;
    private String eventName;
    private HashMap<String, Object> eventBody;
}
