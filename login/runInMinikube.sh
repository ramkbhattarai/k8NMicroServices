   #!/bin/bash
   eval $(minikube docker-env)
   docker build -t login-app:3 .
   kubectl apply -k ./manifests
   max=3
   for (( i=0; i <= $max; i++ ))
   do
       echo "Starting"
       sleep 2
   done
   echo "done"