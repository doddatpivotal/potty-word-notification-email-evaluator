#!/usr/bin/env bash

riff service delete potty-word-notification-email-evaluator

riff function create java potty-word-notification-email-evaluator \
    --local-path . \
    --image $DOCKER_ID/potty-word-notification-email-evaluator \
    --env FUNCTIONS_POTTY_WORD_NOTIFICATION_EMAIL_EVALUATOR_FROM=$FUNCTIONS_POTTY_WORD_NOTIFICATION_EMAIL_EVALUATOR_FROM \
    --env FUNCTIONS_POTTY_WORD_NOTIFICATION_EMAIL_EVALUATOR_TO=$FUNCTIONS_POTTY_WORD_NOTIFICATION_EMAIL_EVALUATOR_TO \
    --verbose

