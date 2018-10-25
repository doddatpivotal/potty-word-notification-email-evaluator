package functions;

import com.google.gson.Gson;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.function.Function;

@Log
@SpringBootApplication
public class PottyWordNotifierEmailEvaluatorApplication implements Function<EvaluatedMessageSentEvent, Message> {

    public static void main(String[] args) {
        SpringApplication.run(PottyWordNotifierEmailEvaluatorApplication.class, args);
    }

    @Value("${functions.potty-word-notification-email-evaluator.to:foo@foo.com}")
    private String to;

    @Value("${functions.potty-word-notification-email-evaluator.from:foo@foo.com}")
    private String from;

    @Value("${functions.potty-word-notification-email-evaluator.subject:Potty Words Found}")
    private String subject;

    @Override
    public Message apply(EvaluatedMessageSentEvent evaluatedMessageSentEvent) {

        Gson gson = new Gson();
        String json = gson.toJson(evaluatedMessageSentEvent);

        log.info("Evaluating: " + json);

        if(evaluatedMessageSentEvent.isHasPottyWord()) {

            String body = "Potty words found in message: " + json;

            Message message = new Message(to, from, subject, body);
            json = gson.toJson(message);

            log.info("Sending for email notification to: " + json);

            return message;

        } else {

            log.info("No email should be sent");

            return new Message();
        }
    }

}
