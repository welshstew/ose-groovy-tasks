# Simple gradle/java project

Just trying out stuff..

Build the s2i-gradle/s2i-java project before building this...

```
oc create -f https://raw.githubusercontent.com/jorgemoralespou/s2i-java/master/ose3/s2i-java-build_in_ose3.json
```

```
oc new-app s2i-java~https://github.com/welshstew/ose-groovy-tasks
# then delete the dc - because it'll just crash loop
```

## Job

Why not try running it as a Job??

```
oc create -f kube/groovy-job.yaml
```
