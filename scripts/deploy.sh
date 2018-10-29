#!/usr/bin/env bash

riff service delete potty-word-notification-email-evaluator

localpath=${1:-.}

riff function create java potty-word-notification-email-evaluator \
    --local-path $localpath \
    --image $DOCKER_ID/potty-word-notification-email-evaluator \
    --env FUNCTIONS_POTTY_WORD_NOTIFICATION_EMAIL_EVALUATOR_FROM=$FUNCTIONS_POTTY_WORD_NOTIFICATION_EMAIL_EVALUATOR_FROM \
    --env FUNCTIONS_POTTY_WORD_NOTIFICATION_EMAIL_EVALUATOR_TO=$FUNCTIONS_POTTY_WORD_NOTIFICATION_EMAIL_EVALUATOR_TO \
    --verbose

