# Simple gradle project

Just trying out stuff..

Build the s2i-gradle project before building this...

```
oc new-app s2i-gradle~https://github.com/welshstew/ose-groovy-tasks
# then delete the dc - because it'll just crash loop
```

## Job

Why not try running it as a Job??

```
oc create -f kube/groovy-job.yaml
```