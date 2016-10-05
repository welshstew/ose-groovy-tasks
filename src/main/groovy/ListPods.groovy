import io.fabric8.kubernetes.client.DefaultKubernetesClient

def dkc = new DefaultKubernetesClient()
println dkc.inNamespace("default").pods().list()

