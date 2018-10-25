# Potty word notifier email evaluator
This sample requires riff v0.1.3 or later.

>To push to GCR set $DOCKER_ID to gcr.io/<project_id>

#### create locally
```sh
riff function create java potty-word-notification-email-evaluator \
  --local-path . \
  --image $DOCKER_ID/potty-word-notification-email-evaluator \
  --verbose
```

#### create from git repo, pushing image to DockerHub
```sh
riff function create java potty-word-notification-email-evaluator \
    --git-repo https://github.com/doddatpivotal/potty-word-notification-email-evaluator.git \
    --image $DOCKER_ID/potty-word-notification-email-evaluator \
  --verbose
```
To set `$DOCKER_ID` do `export DOCKER_ID=your-docker-id`

#### invoke
```
riff service invoke potty-word-notification-email-evaluator --json -- -d '{"hasPottyWord":true, "eventName": "messageSent", "eventBody": {"date": "10/29/2019", "username": "fuzzybunnyslippers", "avatar": "//api.adorable.io/avatars/30/fuzzybunnyslippers.png", "message": "This is a potty message"}}'
```
