   #!/bin/bash
   eval $(minikube docker-env)
   kubectl delete -k ./manifests